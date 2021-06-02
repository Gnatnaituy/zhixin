package com.zhixin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhixin.entity.ContactItem;
import com.zhixin.vo.common.ResponseEntity;
import com.zhixin.vo.request.RequestContactItemSaveVo;
import com.zhixin.vo.response.ResponseContactItemVo;

import java.util.List;
import java.util.Map;

/**
 * @author yutiantang
 * @create 2021/6/2 00:19
 */
public interface ContactItemService extends IService<ContactItem> {

    ResponseEntity save(List<RequestContactItemSaveVo> contactItems, Long companyId);

    void removeByExcludeContactIds(List<Long> contactIds);

    Map<Long, List<ResponseContactItemVo>> listByContactIds(List<Long> contactIds);
}
