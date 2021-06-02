package com.zhixin.controller;

import com.zhixin.service.ModuleService;
import com.zhixin.vo.common.ResponseEntity;
import com.zhixin.vo.request.RequestModuleSaveVo;
import com.zhixin.vo.request.RequestModuleSearchVo;
import org.springframework.web.bind.annotation.*;

/**
 * @author yutiantang
 * @create 2021/5/28 21:57
 */
@RestController
@RequestMapping(value = "/module")
public class ModuleController {

    private final ModuleService moduleService;

    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    @PostMapping(value = "/save")
    public ResponseEntity save(@RequestBody RequestModuleSaveVo saveVo) {
        return moduleService.save(saveVo);
    }

    @DeleteMapping(value = "/delete/{moduleId}")
    public ResponseEntity delete(@PathVariable("moduleId") Long moduleId) {
        return moduleService.delete(moduleId);
    }

    @PostMapping(value = "/list")
    public ResponseEntity list(@RequestBody RequestModuleSearchVo searchVo) {
        return ResponseEntity.success(moduleService.page(searchVo));
    }
}
