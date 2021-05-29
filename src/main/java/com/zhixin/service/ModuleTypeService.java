package com.zhixin.service;

import com.zhixin.vo.request.RequestModuleTypeSaveVo;
import com.zhixin.vo.response.ResponseModuleTypeVo;

import java.util.List;

/**
 * @author yutiantang
 * @create 2021/5/28 22:07
 */
public interface ModuleTypeService {

    void save(RequestModuleTypeSaveVo saveVo);

    void delete(Long id);

    List<ResponseModuleTypeVo> list();
}
