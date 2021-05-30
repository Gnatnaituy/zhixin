package com.zhixin.service.impl;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhixin.consts.ErrorMessage;
import com.zhixin.entity.Banner;
import com.zhixin.entity.Contact;
import com.zhixin.mapper.ContactMapper;
import com.zhixin.service.ContactService;
import com.zhixin.vo.common.ResponseEntity;
import com.zhixin.vo.request.RequestBannerSaveVo;
import com.zhixin.vo.request.RequestContactSaveVo;
import com.zhixin.vo.response.ResponseBannerVo;
import com.zhixin.vo.response.ResponseContactVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yutiantang
 * @create 2021/5/28 22:17
 */
@Service
public class ContactServiceImpl extends ServiceImpl<ContactMapper, Contact> implements ContactService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(List<RequestContactSaveVo> saveVos) {
        if (ObjectUtils.isEmpty(saveVos)) {
            return ResponseEntity.error(ErrorMessage.EMPTY_PARAMS);
        }

        List<Contact> updates = saveVos.stream()
                .filter(o -> !ObjectUtils.isEmpty(o.getId()))
                .map(o -> Convert.convert(Contact.class, o))
                .collect(Collectors.toList());
        List<Long> retainedIds = saveVos.stream()
                .map(RequestContactSaveVo::getId)
                .filter(id -> !ObjectUtils.isEmpty(id))
                .collect(Collectors.toList());
        List<Contact> adds = saveVos.stream()
                .filter(o -> ObjectUtils.isEmpty(o.getId()))
                .map(o -> Convert.convert(Contact.class, o))
                .collect(Collectors.toList());

        if (ObjectUtils.isEmpty(retainedIds)) {
            this.remove(new QueryWrapper<>());
        } else {
            QueryWrapper<Contact> queryWrapper = new QueryWrapper<>();
            queryWrapper.notIn(Contact.ID, retainedIds);
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
    public ResponseEntity listByCompanyId(Long companyId) {
        QueryWrapper<Contact> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(Contact.COMPANY_ID, companyId);
        queryWrapper.orderByAsc(Contact.SORT);
        List<Contact> contacts = this.list(queryWrapper);
        if (ObjectUtils.isEmpty(contacts)) {
            return ResponseEntity.success(Collections.emptyList());
        }

        List<ResponseContactVo> bannerVos = contacts.stream()
                .map(o -> Convert.convert(ResponseContactVo.class, o))
                .collect(Collectors.toList());

        return ResponseEntity.success(bannerVos);
    }
}
