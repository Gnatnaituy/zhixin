package com.zhixin.service.impl;

import com.zhixin.mapper.ModuleMapper;
import com.zhixin.service.ModuleService;
import com.zhixin.vo.request.RequestModuleSaveVo;
import com.zhixin.vo.request.RequestModuleSearchVo;
import com.zhixin.vo.response.ResponseModuleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yutiantang
 * @create 2021/5/28 21:56
 */
@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    private ModuleMapper moduleMapper;

    @Override
    public void save(RequestModuleSaveVo saveVo) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<ResponseModuleVo> list(RequestModuleSearchVo searchVo) {
        return null;
    }
}
