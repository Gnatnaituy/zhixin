package com.zhixin.service.impl;

import com.zhixin.mapper.ModuleTypeMapper;
import com.zhixin.service.ModuleTypeService;
import com.zhixin.vo.request.RequestModuleTypeSaveVo;
import com.zhixin.vo.response.ResponseModuleTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yutiantang
 * @create 2021/5/28 22:08
 */
@Service
public class ModuleTypeServiceImpl implements ModuleTypeService {

    @Autowired
    private ModuleTypeMapper moduleTypeMapper;

    @Override
    public void save(RequestModuleTypeSaveVo saveVo) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<ResponseModuleTypeVo> list() {
        return null;
    }
}
