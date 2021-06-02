package com.zhixin.controller;

import com.zhixin.service.ModuleService;
import com.zhixin.vo.common.ResponseEntity;
import com.zhixin.vo.request.RequestModuleSaveVo;
import com.zhixin.vo.request.RequestModuleSearchVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author yutiantang
 * @create 2021/5/28 21:57
 */
@Api
@RestController
@RequestMapping(value = "/module")
public class ModuleController {

    private final ModuleService moduleService;

    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    @ApiOperation(value = "xxx")
    @PostMapping(value = "/save")
    public ResponseEntity save(@RequestBody RequestModuleSaveVo saveVo) {
        return moduleService.save(saveVo);
    }

    @ApiOperation(value = "xxx")
    @DeleteMapping(value = "/delete/{moduleId}")
    public ResponseEntity delete(@PathVariable("moduleId") Long moduleId) {
        return moduleService.delete(moduleId);
    }

    @ApiOperation(value = "xxx")
    @PostMapping(value = "/list")
    public ResponseEntity list(@RequestBody RequestModuleSearchVo searchVo) {
        return ResponseEntity.success(moduleService.page(searchVo));
    }
}
