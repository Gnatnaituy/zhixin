package com.zhixin.service.impl;

import com.zhixin.mapper.ModuleSubTypeMapper;
import com.zhixin.service.ModuleSubTypeService;
import com.zhixin.vo.request.RequestModuleSubTypeSaveVo;
import com.zhixin.vo.response.ResponseModuleSubTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yutiantang
 * @create 2021/5/28 22:08
 */
@Service
public class ModuleSubTypeServiceImpl implements ModuleSubTypeService {

    @Autowired
    private ModuleSubTypeMapper moduleSubTypeMapper;

    @Override
    public void save(RequestModuleSubTypeSaveVo saveVo) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<ResponseModuleSubTypeVo> list(Long typeId) {
        return null;
    }
}
