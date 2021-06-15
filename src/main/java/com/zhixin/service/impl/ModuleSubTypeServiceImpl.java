package com.zhixin.service.impl;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhixin.common.BaseEntity;
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
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yutiantang
 * @create 2021/5/28 22:08
 */
@Service
public class ModuleSubTypeServiceImpl extends ServiceImpl<ModuleSubTypeMapper, ModuleSubType> implements ModuleSubTypeService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(RequestModuleSubTypeSaveVo saveVo) {
        if (ObjectUtils.isEmpty(saveVo)) {
            return ResponseEntity.error(ErrorMessage.EMPTY_PARAMS);
        }
        ModuleSubType moduleSubType = Convert.convert(ModuleSubType.class, saveVo);
        if (ObjectUtils.isEmpty(moduleSubType.getId())) {
            this.save(moduleSubType);
        } else {
            this.updateById(moduleSubType);
        }

        return ResponseEntity.success();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long subTypeId) {
        this.removeById(subTypeId);
    }

    @Override
    public Map<Long, ResponseModuleSubTypeVo> listMap() {
        QueryWrapper<ModuleSubType> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc(ModuleSubType.SORT);
        List<ModuleSubType> moduleSubTypes = this.list(queryWrapper);
        if (ObjectUtils.isEmpty(moduleSubTypes)) {
            return Collections.emptyMap();
        }

        return moduleSubTypes.stream()
                .collect(Collectors.toMap(BaseEntity::getId,
                        o -> Convert.convert(ResponseModuleSubTypeVo.class, o),
                        (o1, o2) -> o2));
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
