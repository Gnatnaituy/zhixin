package com.zhixin.controller;

import com.zhixin.service.ModuleTypeService;
import com.zhixin.vo.common.ResponseEntity;
import com.zhixin.vo.request.RequestModuleTypeSaveVo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yutiantang
 * @create 2021/5/28 22:10
 */
@RestController
@RequestMapping(value = "/module_type")
public class ModuleTypeController {

    private final ModuleTypeService moduleTypeService;

    public ModuleTypeController(ModuleTypeService moduleTypeService) {
        this.moduleTypeService = moduleTypeService;
    }

    @PostMapping(value = "/save")
    public ResponseEntity save(@RequestBody List<RequestModuleTypeSaveVo> saveVos) {
        return moduleTypeService.save(saveVos);
    }

    @GetMapping(value = "/list")
    public ResponseEntity list() {
        return moduleTypeService.listAll();
    }

    @GetMapping(value = "/list/in-home")
    public ResponseEntity listInHome() {
        return ResponseEntity.success(moduleTypeService.listInHome());
    }

    @GetMapping(value = "/detail/{id}")
    public ResponseEntity detail(@PathVariable("id") Long id) {
        return ResponseEntity.success(moduleTypeService.detail(id));
    }
}
