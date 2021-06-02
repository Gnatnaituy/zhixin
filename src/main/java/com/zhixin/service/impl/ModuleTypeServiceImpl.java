package com.zhixin.service.impl;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhixin.common.BaseEntity;
import com.zhixin.consts.Const;
import com.zhixin.consts.ErrorMessage;
import com.zhixin.entity.ModuleType;
import com.zhixin.mapper.ModuleTypeMapper;
import com.zhixin.service.ModuleService;
import com.zhixin.service.ModuleTypeService;
import com.zhixin.vo.common.ResponseEntity;
import com.zhixin.vo.request.RequestModuleSearchVo;
import com.zhixin.vo.request.RequestModuleTypeSaveVo;
import com.zhixin.vo.response.ResponseModuleInfoVo;
import com.zhixin.vo.response.ResponseModuleTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yutiantang
 * @create 2021/5/28 22:08
 */
@Service
public class ModuleTypeServiceImpl extends ServiceImpl<ModuleTypeMapper, ModuleType> implements ModuleTypeService {

    @Autowired
    private ModuleService moduleService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(List<RequestModuleTypeSaveVo> saveVos) {
        if (ObjectUtils.isEmpty(saveVos)) {
            return ResponseEntity.error(ErrorMessage.EMPTY_PARAMS);
        }

        List<ModuleType> updates = saveVos.stream()
                .filter(o -> !ObjectUtils.isEmpty(o.getId()))
                .map(o -> Convert.convert(ModuleType.class, o))
                .collect(Collectors.toList());
        List<Long> retainedIds = saveVos.stream()
                .map(RequestModuleTypeSaveVo::getId)
                .filter(id -> !ObjectUtils.isEmpty(id))
                .collect(Collectors.toList());
        List<ModuleType> adds = saveVos.stream()
                .filter(o -> ObjectUtils.isEmpty(o.getId()))
                .map(o -> Convert.convert(ModuleType.class, o))
                .collect(Collectors.toList());

        if (ObjectUtils.isEmpty(retainedIds)) {
            this.remove(new QueryWrapper<>());
        } else {
            QueryWrapper<ModuleType> queryWrapper = new QueryWrapper<>();
            queryWrapper.notIn(ModuleType.ID, retainedIds);
            this.remove(queryWrapper);
        }
        if (!ObjectUtils.isEmpty(updates)) {
            this.updateBatchById(updates, updates.size());
        }
        if (!ObjectUtils.isEmpty(adds)) {
            this.saveBatch(adds);
        }

        return ResponseEntity.success();
    }

    @Override
    public ResponseEntity listAll() {
        QueryWrapper<ModuleType> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc(ModuleType.SORT);
        List<ModuleType> moduleTypes = this.list(queryWrapper);
        if (ObjectUtils.isEmpty(moduleTypes)) {
            return ResponseEntity.success(Collections.emptyList());
        }

        List<ResponseModuleTypeVo> bannerVos = moduleTypes.stream()
                .map(o -> Convert.convert(ResponseModuleTypeVo.class, o))
                .collect(Collectors.toList());

        return ResponseEntity.success(bannerVos);
    }

    @Override
    public List<ResponseModuleTypeVo> listInHome() {
        QueryWrapper<ModuleType> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(ModuleType.SHOW_IN_HOME_PAGE, Const.YES);
        queryWrapper.orderByAsc(ModuleType.SORT);
        List<ModuleType> moduleTypes = this.list(queryWrapper);
        if (ObjectUtils.isEmpty(moduleTypes)) {
            return Collections.emptyList();
        }
        RequestModuleSearchVo searchVo = new RequestModuleSearchVo();
        searchVo.setPageStart(0);
        searchVo.setPageLength(6);
        List<ResponseModuleTypeVo> typeModules = new ArrayList<>();
        for (ModuleType type : moduleTypes) {
            searchVo.setTypeId(type.getId());
            IPage<ResponseModuleInfoVo> page = moduleService.page(searchVo);
            ResponseModuleTypeVo typeVo = Convert.convert(ResponseModuleTypeVo.class, type);
            typeVo.setModules(page.getRecords());
            typeModules.add(typeVo);
        }

        return typeModules;
    }

    @Override
    public Map<Long, ResponseModuleTypeVo> listMap() {
        QueryWrapper<ModuleType> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc(ModuleType.SORT);
        List<ModuleType> moduleTypes = this.list(queryWrapper);
        if (ObjectUtils.isEmpty(moduleTypes)) {
            return Collections.emptyMap();
        }

        return moduleTypes.stream()
                .collect(Collectors.toMap(BaseEntity::getId,
                        o -> Convert.convert(ResponseModuleTypeVo.class, o),
                        (o1, o2) -> o2));
    }
}
