package com.zhixin.controller;

import com.zhixin.service.SysUserService;
import com.zhixin.vo.common.ResponseEntity;
import com.zhixin.vo.request.RequestSysUserSaveVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author yutiantang
 * @create 2021/5/31 18:06
 */
@Api
@RestController
@RequestMapping(value = "/sys_user")
public class SysUserController {

    private final SysUserService sysUserService;

    public SysUserController(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @ApiOperation(value = "xxx")
    @PostMapping(value = "/save")
    public ResponseEntity save(@RequestBody RequestSysUserSaveVo saveVo) {
        return sysUserService.save(saveVo);
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping(value = "/{sysUserId}")
    public ResponseEntity delete(@PathVariable("sysUserId") Long sysUserId) {
        return sysUserService.delete(sysUserId);
    }

    @ApiOperation(value = "xxx")
    @GetMapping(value = "/list")
    public ResponseEntity list() {
        return sysUserService.listAll();
    }
}
