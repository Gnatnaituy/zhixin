package com.zhixin.service;

import com.zhixin.vo.request.RequestContactSaveVo;

/**
 * @author yutiantang
 * @create 2021/5/28 22:17
 */
public interface ContactService {

    void save(RequestContactSaveVo saveVo);

    void delete(Long id);
}
