package com.zhixin.controller;

import com.zhixin.annotation.LoginRequired;
import com.zhixin.service.ModuleSubTypeService;
import com.zhixin.vo.common.ResponseEntity;
import com.zhixin.vo.request.RequestModuleSubTypeSaveVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yutiantang
 * @create 2021/5/28 22:10
 */
@Api
@RestController
@RequestMapping(value = "/module_sub_type")
public class ModuleSubTypeController {

    private final ModuleSubTypeService moduleSubTypeService;

    public ModuleSubTypeController(ModuleSubTypeService moduleSubTypeService) {
        this.moduleSubTypeService = moduleSubTypeService;
    }

    @LoginRequired
    @ApiOperation(value = "xxx")
    @PostMapping(value = "/save")
    public ResponseEntity save(@RequestBody RequestModuleSubTypeSaveVo saveVo) {
        return moduleSubTypeService.save(saveVo);
    }

    @ApiOperation(value = "xxx")
    @GetMapping(value = "/list/{moduleTypeId}")
    public ResponseEntity list(@PathVariable("moduleTypeId") Long moduleTypeId) {
        return moduleSubTypeService.listByModuleTypeId(moduleTypeId);
    }

    @LoginRequired
    @ApiOperation(value = "删除子模块")
    @DeleteMapping(value = "/{moduleSubTypeId}")
    public ResponseEntity delete(@PathVariable("moduleSubTypeId") Long moduleSubTypeId) {
        moduleSubTypeService.delete(moduleSubTypeId);
        return ResponseEntity.success();
    }
}
