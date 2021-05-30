package com.zhixin.service.impl;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhixin.consts.ErrorMessage;
import com.zhixin.entity.Module;
import com.zhixin.entity.ModuleType;
import com.zhixin.mapper.ModuleMapper;
import com.zhixin.service.ModuleService;
import com.zhixin.service.ModuleSubTypeService;
import com.zhixin.service.ModuleTypeService;
import com.zhixin.vo.common.ResponseEntity;
import com.zhixin.vo.request.RequestModuleSaveVo;
import com.zhixin.vo.request.RequestModuleSearchVo;
import com.zhixin.vo.response.ResponseModuleSubTypeVo;
import com.zhixin.vo.response.ResponseModuleTypeVo;
import com.zhixin.vo.response.ResponseModuleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Map;

/**
 * @author yutiantang
 * @create 2021/5/28 21:56
 */
@Service
public class ModuleServiceImpl extends ServiceImpl<ModuleMapper, Module> implements ModuleService {

    private final ModuleTypeService moduleTypeService;
    private final ModuleSubTypeService moduleSubTypeService;

    public ModuleServiceImpl(ModuleTypeService moduleTypeService, ModuleSubTypeService moduleSubTypeService) {
        this.moduleTypeService = moduleTypeService;
        this.moduleSubTypeService = moduleSubTypeService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(RequestModuleSaveVo saveVo) {
        if (ObjectUtils.isEmpty(saveVo)) {
            return ResponseEntity.error(ErrorMessage.EMPTY_PARAMS);
        }

        Module module = Convert.convert(Module.class, saveVo);

        this.save(module);

        return ResponseEntity.success();
    }

    @Override
    public ResponseEntity delete(Long id) {
        if (ObjectUtils.isEmpty(id)) {
            return ResponseEntity.error(ErrorMessage.EMPTY_PARAMS);
        }

        this.removeById(id);

        return ResponseEntity.success();
    }

    @Override
    public ResponseEntity list(RequestModuleSearchVo searchVo) {
        if (ObjectUtils.isEmpty(searchVo)) {
            return ResponseEntity.error(ErrorMessage.EMPTY_PARAMS);
        }
        if (ObjectUtils.isEmpty(searchVo.getPageStart())) {
            searchVo.setPageStart(0);
        }
        if (ObjectUtils.isEmpty(searchVo.getPageLength())) {
            searchVo.setPageLength(10);
        }

        Page<Module> page = new Page<>(searchVo.getPageStart(), searchVo.getPageLength());

        QueryWrapper<Module> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(ObjectUtils.isEmpty(searchVo.getTypeId()), Module.TYPE_ID, searchVo.getTypeId());
        queryWrapper.eq(ObjectUtils.isEmpty(searchVo.getSubTypeId()), Module.SUB_TYPE_ID, searchVo.getSubTypeId());
        queryWrapper.orderByDesc(Module.CREATE_TIME);
        Page<Module> modules = this.page(page, queryWrapper);

        Map<Long, ResponseModuleTypeVo> typeMap = moduleTypeService.listMap();
        Map<Long, ResponseModuleSubTypeVo> subTypeMap = moduleSubTypeService.listMap();

        modules.convert(o -> {
            ResponseModuleVo moduleVo = Convert.convert(ResponseModuleVo.class, o);
            ResponseModuleTypeVo type = typeMap.get(o.getTypeId());
            if (!ObjectUtils.isEmpty(type)) {
                moduleVo.setTypeName(type.getName());
            }
            ResponseModuleSubTypeVo subType = subTypeMap.get(o.getSubTypeId());
            if (!ObjectUtils.isEmpty(subType)) {
                moduleVo.setSubTypeName(subType.getName());
            }
            return moduleVo;
        });

        return ResponseEntity.success(modules);
    }
}
