package com.zhixin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhixin.entity.ModuleSubType;
import com.zhixin.vo.common.ResponseEntity;
import com.zhixin.vo.request.RequestModuleSubTypeSaveVo;
import com.zhixin.vo.response.ResponseModuleSubTypeVo;

import java.util.List;
import java.util.Map;

/**
 * @author yutiantang
 * @create 2021/5/28 22:08
 */
public interface ModuleSubTypeService extends IService<ModuleSubType> {

    ResponseEntity save(RequestModuleSubTypeSaveVo saveVo);

    Map<Long, ResponseModuleSubTypeVo> listMap();

    ResponseEntity listByModuleTypeId(Long moduleTypeId);
}
