package com.zhixin.service;

import com.zhixin.vo.request.RequestModuleSaveVo;
import com.zhixin.vo.request.RequestModuleSearchVo;
import com.zhixin.vo.response.ResponseModuleVo;

import java.util.List;

/**
 * @author yutiantang
 * @create 2021/5/28 21:55
 */
public interface ModuleService {

    void save(RequestModuleSaveVo saveVo);

    void delete(Long id);

    List<ResponseModuleVo> list(RequestModuleSearchVo searchVo);
}
