package com.zhixin.controller;

import com.zhixin.service.SysUserService;
import com.zhixin.vo.common.ResponseEntity;
import com.zhixin.vo.request.RequestSysUserSaveVo;
import org.springframework.web.bind.annotation.*;

/**
 * @author yutiantang
 * @create 2021/5/31 18:06
 */
@RestController
@RequestMapping(value = "sys_user")
public class SysUserController {

    private final SysUserService sysUserService;

    public SysUserController(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @PostMapping(value = "/save")
    public ResponseEntity save(@RequestBody RequestSysUserSaveVo saveVo) {
        return sysUserService.save(saveVo);
    }

    @GetMapping(value = "/list")
    public ResponseEntity list() {
        return sysUserService.listAll();
    }
}
