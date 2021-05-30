package com.zhixin.controller;

import com.zhixin.service.ModuleSubTypeService;
import com.zhixin.vo.common.ResponseEntity;
import com.zhixin.vo.request.RequestModuleSubTypeSaveVo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yutiantang
 * @create 2021/5/28 22:10
 */
@RestController
@RequestMapping(value = "/module_sub_type")
public class ModuleSubTypeController {

    private final ModuleSubTypeService moduleSubTypeService;

    public ModuleSubTypeController(ModuleSubTypeService moduleSubTypeService) {
        this.moduleSubTypeService = moduleSubTypeService;
    }

    @PostMapping(value = "/save")
    public ResponseEntity save(@RequestBody List<RequestModuleSubTypeSaveVo> saveVos) {
        return moduleSubTypeService.save(saveVos);
    }

    @GetMapping(value = "/list/{moduleTypeId}")
    public ResponseEntity list(@PathVariable("moduleTypeId") Long moduleTypeId) {
        return moduleSubTypeService.listByModuleTypeId(moduleTypeId);
    }
}
