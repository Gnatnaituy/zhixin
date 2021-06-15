package com.zhixin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhixin.entity.SysUser;
import com.zhixin.vo.common.ResponseEntity;
import com.zhixin.vo.request.RequestSysUserSaveVo;

/**
 * @author yutiantang
 * @create 2021/5/31 18:05
 */
public interface SysUserService extends IService<SysUser> {

    ResponseEntity login(String username, String password);

    ResponseEntity logout(String token);

    ResponseEntity checkToken(String token);

    ResponseEntity save(RequestSysUserSaveVo saveVo);

    ResponseEntity delete(Long id);

    ResponseEntity listAll();
}
