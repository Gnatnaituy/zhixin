package com.zhixin.service.impl;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhixin.consts.ErrorMessage;
import com.zhixin.entity.Company;
import com.zhixin.mapper.CompanyMapper;
import com.zhixin.service.CompanyService;
import com.zhixin.service.ContactService;
import com.zhixin.vo.common.ResponseEntity;
import com.zhixin.vo.request.RequestCompanySaveVo;
import com.zhixin.vo.response.ResponseCompanyVo;
import com.zhixin.vo.response.ResponseContactVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yutiantang
 * @create 2021/5/28 22:17
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService {

    @Autowired
    private ContactService contactService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(List<RequestCompanySaveVo> saveVos) {
        if (ObjectUtils.isEmpty(saveVos)) {
            return ResponseEntity.error(ErrorMessage.EMPTY_PARAMS);
        }

        List<Company> updates = saveVos.stream()
                .filter(o -> !ObjectUtils.isEmpty(o.getId()))
                .map(o -> Convert.convert(Company.class, o))
                .collect(Collectors.toList());
        List<Long> retainedIds = saveVos.stream()
                .map(RequestCompanySaveVo::getId)
                .filter(id -> !ObjectUtils.isEmpty(id))
                .collect(Collectors.toList());
        List<Company> adds = saveVos.stream()
                .filter(o -> ObjectUtils.isEmpty(o.getId()))
                .map(o -> Convert.convert(Company.class, o))
                .collect(Collectors.toList());

        if (ObjectUtils.isEmpty(retainedIds)) {
            this.remove(new QueryWrapper<>());
        } else {
            QueryWrapper<Company> queryWrapper = new QueryWrapper<>();
            queryWrapper.notIn(Company.ID, retainedIds);
            this.remove(queryWrapper);
        }
        if (!ObjectUtils.isEmpty(updates)) {
            this.updateBatchById(updates, updates.size());
        }
        if (!ObjectUtils.isEmpty(adds)) {
            this.saveBatch(adds);
        }

        return ResponseEntity.success();
    }

    @Override
    public ResponseEntity listAll() {
        QueryWrapper<Company> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc(Company.SORT);
        List<Company> companies = this.list(queryWrapper);
        if (ObjectUtils.isEmpty(companies)) {
            return ResponseEntity.success(Collections.emptyList());
        }

        List<Long> companyIds = companies.stream().map(Company::getId).collect(Collectors.toList());
        Map<Long, List<ResponseContactVo>> contacts = contactService.listByCompanyIds(companyIds);

        List<ResponseCompanyVo> bannerVos = companies.stream()
                .map(o -> {
                    ResponseCompanyVo companyVo = Convert.convert(ResponseCompanyVo.class, o);
                    companyVo.setContacts(contacts.get(o.getId()));
                    return companyVo;
                })
                .collect(Collectors.toList());

        return ResponseEntity.success(bannerVos);
    }
}
