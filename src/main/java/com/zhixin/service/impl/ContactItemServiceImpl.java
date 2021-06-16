package com.zhixin.service.impl;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhixin.entity.ContactItem;
import com.zhixin.mapper.ContactItemMapper;
import com.zhixin.service.ContactItemService;
import com.zhixin.vo.common.ResponseEntity;
import com.zhixin.vo.request.RequestContactItemSaveVo;
import com.zhixin.vo.response.ResponseContactItemVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yutiantang
 * @create 2021/6/2 00:20
 */
@Service
public class ContactItemServiceImpl extends ServiceImpl<ContactItemMapper, ContactItem> implements ContactItemService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(List<RequestContactItemSaveVo> contactItems, Long contactId, Long companyId) {
        contactItems.forEach(o -> o.setContactId(contactId));
        contactItems.forEach(o -> o.setCompanyId(companyId));

        List<Long> updateIds = contactItems.stream()
                .map(RequestContactItemSaveVo::getId)
                .filter(id -> !ObjectUtils.isEmpty(id))
                .collect(Collectors.toList());
        if (!ObjectUtils.isEmpty(updateIds)) {
            QueryWrapper<ContactItem> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq(ContactItem.COMPANY_ID, companyId);
            queryWrapper.eq(ContactItem.CONTACT_ID, contactId);
            queryWrapper.notIn(ContactItem.ID, updateIds);
            this.remove(queryWrapper);
            List<ContactItem> updates = contactItems.stream()
                    .filter(o -> !ObjectUtils.isEmpty(o.getId()))
                    .map(o -> Convert.convert(ContactItem.class, o))
                    .collect(Collectors.toList());
            this.updateBatchById(updates);
        } else {
            QueryWrapper<ContactItem> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq(ContactItem.COMPANY_ID, companyId);
            queryWrapper.eq(ContactItem.CONTACT_ID, contactId);
            this.remove(queryWrapper);
        }
        List<ContactItem> adds = contactItems.stream()
                .filter(o -> ObjectUtils.isEmpty(o.getId()))
                .map(o -> Convert.convert(ContactItem.class, o))
                .collect(Collectors.toList());
        if (!ObjectUtils.isEmpty(adds)) {
            this.saveBatch(adds);
        }

        return ResponseEntity.success();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeByExcludeContactIds(List<Long> contactIds, Long companyId) {
        QueryWrapper<ContactItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(ContactItem.COMPANY_ID, companyId);
        if (!ObjectUtils.isEmpty(contactIds)) {
            queryWrapper.notIn(ContactItem.CONTACT_ID, contactIds);
        }
        this.remove(queryWrapper);
    }

    @Override
    public Map<Long, List<ResponseContactItemVo>> listByContactIds(List<Long> contactIds) {
        QueryWrapper<ContactItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.in(ContactItem.CONTACT_ID, contactIds);
        List<ContactItem> contactItems = this.list(queryWrapper);
        if (ObjectUtils.isEmpty(contactItems)) {
            return Collections.emptyMap();
        }

        return contactItems.stream()
                .map(o -> Convert.convert(ResponseContactItemVo.class, o))
                .collect(Collectors.groupingBy(ResponseContactItemVo::getContactId));
    }
}
