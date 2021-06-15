package com.zhixin.controller;

import com.zhixin.service.SysUserService;
import com.zhixin.vo.common.ResponseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yutiantang
 * @create 2021/5/28 22:10
 */
@Api
@RestController
@RequestMapping(value = "/")
public class MainController {

    @Autowired
    private SysUserService sysUserService;

    @ApiOperation(value = "登录")
    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestParam("username") String username,
                                @RequestParam("password") String password) {
        return sysUserService.login(username, password);
    }

    @ApiOperation(value = "登出")
    @PostMapping(value = "/logout")
    public ResponseEntity login(@RequestParam("token") String token) {
        return sysUserService.logout(token);
    }
}
