package com.zhixin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhixin.entity.ModuleType;
import com.zhixin.vo.common.ResponseEntity;
import com.zhixin.vo.request.RequestModuleTypeSaveVo;
import com.zhixin.vo.response.ResponseModuleInfoVo;
import com.zhixin.vo.response.ResponseModuleTypeVo;

import java.util.List;
import java.util.Map;

/**
 * @author yutiantang
 * @create 2021/5/28 22:07
 */
public interface ModuleTypeService extends IService<ModuleType> {

    ResponseEntity save(List<RequestModuleTypeSaveVo> saveVos);

    ResponseEntity listAll();

    List<ResponseModuleTypeVo> listInHome();

    Map<Long, ResponseModuleTypeVo> listMap();
}
