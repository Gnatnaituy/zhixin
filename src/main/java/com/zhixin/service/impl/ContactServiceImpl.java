package com.zhixin.service.impl;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhixin.common.BaseEntity;
import com.zhixin.consts.ErrorMessage;
import com.zhixin.entity.Contact;
import com.zhixin.mapper.ContactMapper;
import com.zhixin.service.ContactService;
import com.zhixin.vo.common.ResponseEntity;
import com.zhixin.vo.request.RequestContactSaveVo;
import com.zhixin.vo.response.ResponseContactItemVo;
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
public class ContactServiceImpl extends ServiceImpl<ContactMapper, Contact> implements ContactService {

    @Autowired
    private ContactItemServiceImpl contactItemService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(List<RequestContactSaveVo> saveVos) {
        if (ObjectUtils.isEmpty(saveVos)) {
            return ResponseEntity.error(ErrorMessage.EMPTY_PARAMS);
        }

        List<Long> retainedIds = saveVos.stream()
                .map(RequestContactSaveVo::getId)
                .filter(id -> !ObjectUtils.isEmpty(id))
                .collect(Collectors.toList());

        if (ObjectUtils.isEmpty(retainedIds)) {
            this.remove(new QueryWrapper<>());
            contactItemService.removeByExcludeContactIds(retainedIds);
        } else {
            QueryWrapper<Contact> queryWrapper = new QueryWrapper<>();
            queryWrapper.notIn(Contact.ID, retainedIds);
            this.remove(queryWrapper);
            contactItemService.removeByExcludeContactIds(retainedIds);
            List<RequestContactSaveVo> updates = saveVos.stream()
                    .filter(o -> !ObjectUtils.isEmpty(o.getId()))
                    .collect(Collectors.toList());
            this.updateBatchById(updates.stream()
                    .map(o -> Convert.convert(Contact.class, o))
                    .collect(Collectors.toList()), updates.size());
            updates.forEach(o -> contactItemService.save(o.getContactItems(), o.getId()));
        }

        List<RequestContactSaveVo> adds = saveVos.stream()
                .filter(o -> ObjectUtils.isEmpty(o.getId()))
                .collect(Collectors.toList());
        if (!ObjectUtils.isEmpty(adds)) {
            adds.forEach(o -> {
                Contact contact = Convert.convert(Contact.class, o);
                this.save(contact);
                contactItemService.save(o.getContactItems(), contact.getId());
            });
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

        List<Long> contactIds = contacts.stream().map(BaseEntity::getId).collect(Collectors.toList());
        Map<Long, List<ResponseContactItemVo>> contactItems = contactItemService.listByContactIds(contactIds);

        List<ResponseContactVo> bannerVos = contacts.stream()
                .map(o -> {
                    ResponseContactVo contactVo = Convert.convert(ResponseContactVo.class, o);
                    contactVo.setContactItems(contactItems.get(o.getId()));
                    return contactVo;
                })
                .collect(Collectors.toList());

        return ResponseEntity.success(bannerVos);
    }

    @Override
    public Map<Long, List<ResponseContactVo>> listByCompanyIds(List<Long> companyIds) {
        QueryWrapper<Contact> queryWrapper = new QueryWrapper<>();
        queryWrapper.in(Contact.COMPANY_ID, companyIds);
        queryWrapper.orderByAsc(Contact.SORT);
        List<Contact> contacts = this.list(queryWrapper);
        if (ObjectUtils.isEmpty(contacts)) {
            return Collections.emptyMap();
        }

        List<Long> contactIds = contacts.stream().map(BaseEntity::getId).collect(Collectors.toList());
        Map<Long, List<ResponseContactItemVo>> contactItems = contactItemService.listByContactIds(contactIds);

        return contacts.stream()
                .map(o -> {
                    ResponseContactVo contactVo = Convert.convert(ResponseContactVo.class, o);
                    contactVo.setContactItems(contactItems.get(o.getId()));
                    return contactVo;
                })
                .collect(Collectors.groupingBy(ResponseContactVo::getCompanyId));
    }
}
