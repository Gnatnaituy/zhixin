package com.zhixin.service.impl;

import com.zhixin.mapper.ContactMapper;
import com.zhixin.service.ContactService;
import com.zhixin.vo.request.RequestContactSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yutiantang
 * @create 2021/5/28 22:17
 */
@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactMapper contactMapper;

    @Override
    public void save(RequestContactSaveVo saveVo) {

    }

    @Override
    public void delete(Long id) {

    }
}
