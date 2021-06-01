package com.zhixin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhixin.entity.Contact;
import com.zhixin.vo.common.ResponseEntity;
import com.zhixin.vo.request.RequestContactSaveVo;
import com.zhixin.vo.response.ResponseContactVo;

import java.util.List;
import java.util.Map;

/**
 * @author yutiantang
 * @create 2021/5/28 22:17
 */
public interface ContactService extends IService<Contact> {

    ResponseEntity save(List<RequestContactSaveVo> saveVos);

    ResponseEntity listByCompanyId(Long companyId);

    Map<Long, List<ResponseContactVo>> listByCompanyIds(List<Long> companyIds);
}
