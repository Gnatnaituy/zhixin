package com.zhixin.service.impl;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhixin.consts.ErrorMessage;
import com.zhixin.entity.ModuleSubType;
import com.zhixin.entity.ModuleSubType;
import com.zhixin.mapper.ModuleSubTypeMapper;
import com.zhixin.service.ModuleSubTypeService;
import com.zhixin.vo.common.ResponseEntity;
import com.zhixin.vo.request.RequestModuleSubTypeSaveVo;
import com.zhixin.vo.request.RequestModuleSubTypeSaveVo;
import com.zhixin.vo.response.ResponseModuleSubTypeVo;
import com.zhixin.vo.response.ResponseModuleSubTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yutiantang
 * @create 2021/5/28 22:08
 */
@Service
public class ModuleSubTypeServiceImpl extends ServiceImpl<ModuleSubTypeMapper, ModuleSubType> implements ModuleSubTypeService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(List<RequestModuleSubTypeSaveVo> saveVos) {
        if (ObjectUtils.isEmpty(saveVos)) {
            return ResponseEntity.error(ErrorMessage.EMPTY_PARAMS);
        }

        List<ModuleSubType> updates = saveVos.stream()
                .filter(o -> !ObjectUtils.isEmpty(o.getId()))
                .map(o -> Convert.convert(ModuleSubType.class, o))
                .collect(Collectors.toList());
        List<Long> retainedIds = saveVos.stream()
                .map(RequestModuleSubTypeSaveVo::getId)
                .filter(id -> !ObjectUtils.isEmpty(id))
                .collect(Collectors.toList());
        List<ModuleSubType> adds = saveVos.stream()
                .filter(o -> ObjectUtils.isEmpty(o.getId()))
                .map(o -> Convert.convert(ModuleSubType.class, o))
                .collect(Collectors.toList());

        if (ObjectUtils.isEmpty(retainedIds)) {
            this.remove(new QueryWrapper<>());
        } else {
            QueryWrapper<ModuleSubType> queryWrapper = new QueryWrapper<>();
            queryWrapper.notIn(ModuleSubType.ID, retainedIds);
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
    public ResponseEntity listByModuleTypeId(Long moduleTypeId) {
        QueryWrapper<ModuleSubType> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(ModuleSubType.MODULE_TYPE_ID, moduleTypeId);
        queryWrapper.orderByAsc(ModuleSubType.SORT);
        List<ModuleSubType> moduleSubTypes = this.list(queryWrapper);
        if (ObjectUtils.isEmpty(moduleSubTypes)) {
            return ResponseEntity.success(Collections.emptyList());
        }

        List<ResponseModuleSubTypeVo> bannerVos = moduleSubTypes.stream()
                .map(o -> Convert.convert(ResponseModuleSubTypeVo.class, o))
                .collect(Collectors.toList());

        return ResponseEntity.success(bannerVos);
    }
}
