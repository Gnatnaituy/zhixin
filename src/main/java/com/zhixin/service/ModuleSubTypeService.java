package com.zhixin.service;

import com.zhixin.vo.request.RequestModuleSubTypeSaveVo;
import com.zhixin.vo.response.ResponseModuleSubTypeVo;

import java.util.List;

/**
 * @author yutiantang
 * @create 2021/5/28 22:08
 */
public interface ModuleSubTypeService {

    void save(RequestModuleSubTypeSaveVo saveVo);

    void delete(Long id);

    List<ResponseModuleSubTypeVo> list(Long typeId);
}
