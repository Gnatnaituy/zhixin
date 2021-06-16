package com.zhixin.controller;

import com.zhixin.annotation.LoginRequired;
import com.zhixin.service.ModuleTypeService;
import com.zhixin.vo.common.ResponseEntity;
import com.zhixin.vo.request.RequestModuleTypeSaveVo;
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
@RequestMapping(value = "/module_type")
public class ModuleTypeController {

    private final ModuleTypeService moduleTypeService;

    public ModuleTypeController(ModuleTypeService moduleTypeService) {
        this.moduleTypeService = moduleTypeService;
    }

    @LoginRequired
    @ApiOperation(value = "xxx")
    @PostMapping(value = "/save")
    public ResponseEntity save(@RequestBody List<RequestModuleTypeSaveVo> saveVos) {
        return moduleTypeService.save(saveVos);
    }

    @ApiOperation(value = "xxx")
    @GetMapping(value = "/list")
    public ResponseEntity list() {
        return moduleTypeService.listAll();
    }

    @ApiOperation(value = "xxx")
    @GetMapping(value = "/list/in-home")
    public ResponseEntity listInHome() {
        return ResponseEntity.success(moduleTypeService.listInHome());
    }

    @ApiOperation(value = "xxx")
    @GetMapping(value = "/detail/{id}")
    public ResponseEntity detail(@PathVariable("id") Long id) {
        return ResponseEntity.success(moduleTypeService.detail(id));
    }

    @ApiOperation(value = "xxx")
    @GetMapping(value = "/detail_by_path/{path}")
    public ResponseEntity detailByPath(@PathVariable("path") String path) {
        return ResponseEntity.success(moduleTypeService.detailByPath(path));
    }
}
