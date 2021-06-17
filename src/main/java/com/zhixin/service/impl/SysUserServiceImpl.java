package com.zhixin.service.impl;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.AES;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhixin.common.LoginToken;
import com.zhixin.consts.Const;
import com.zhixin.entity.SysUser;
import com.zhixin.mapper.SysUserMapper;
import com.zhixin.service.SysUserService;
import com.zhixin.vo.common.ResponseEntity;
import com.zhixin.vo.request.RequestSysUserSaveVo;
import com.zhixin.vo.response.ResponseSysUserVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yutiantang
 * @create 2021/5/31 18:05
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    private final Map<String, LoginToken> tokens = new HashMap<>();

    @Override
    public ResponseEntity login(String username, String password) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SysUser.USERNAME, username);
        SysUser sysUser = this.getOne(queryWrapper);
        if (ObjectUtils.isEmpty(sysUser)) {
            return ResponseEntity.error("用户不存在!");
        }
        if (!AES.encrypt(Base64.decodeStr(password), Const.PW_SALT).equals(sysUser.getPassword())) {
            return ResponseEntity.error("账户密码错误!");
        }

        String token = UUID.randomUUID().toString();
        LoginToken loginToken = new LoginToken();
        loginToken.setToken(token);
        loginToken.setExpireTime(DateUtil.current() + Const.TOKEN_EXPIRE_DURATION);
        loginToken.setUser(sysUser);
        tokens.put(token, loginToken);

        return ResponseEntity.success(token);
    }

    @Override
    public ResponseEntity logout(String token) {
        tokens.remove(token);
        return ResponseEntity.success();
    }

    @Override
    public ResponseEntity checkToken(String token) {
        LoginToken loginToken = tokens.get(token);
        if (ObjectUtils.isEmpty(loginToken)) {
            return ResponseEntity.error("INVALID_TOKEN");
        }
        if (loginToken.getExpireTime() < DateUtil.current()) {
            return ResponseEntity.error("TOKEN_EXPIRED");
        }
        loginToken.setExpireTime(DateUtil.current() + Const.TOKEN_EXPIRE_DURATION);
        tokens.put(token, loginToken);

        return ResponseEntity.success();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(RequestSysUserSaveVo saveVo) {
        if (ObjectUtils.isEmpty(saveVo.getId())) {
            QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq(SysUser.USERNAME, saveVo.getUsername());
            SysUser sysUser = this.getOne(queryWrapper);
            if (!ObjectUtils.isEmpty(sysUser)) {
                return ResponseEntity.error("用户名已存在!");
            }
            sysUser = Convert.convert(SysUser.class, saveVo);
            sysUser.setPassword(AES.encrypt(Base64.decodeStr(saveVo.getPassword()), Const.PW_SALT));
            this.save(sysUser);
        } else {
            SysUser sysUser = Convert.convert(SysUser.class, saveVo);
            sysUser.setPassword(AES.encrypt(Base64.decodeStr(saveVo.getPassword()), Const.PW_SALT));
            this.updateById(sysUser);
        }

        return ResponseEntity.success();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity delete(Long id) {
        this.removeById(id);
        return ResponseEntity.success();
    }

    @Override
    public ResponseEntity listAll() {
        List<SysUser> sysUsers = this.list(new QueryWrapper<>());
        if (ObjectUtils.isEmpty(sysUsers)) {
            return ResponseEntity.success(Collections.EMPTY_LIST);
        }
        List<ResponseSysUserVo> sysUserVos = sysUsers.stream()
                .map(o -> Convert.convert(ResponseSysUserVo.class, o))
                .collect(Collectors.toList());

        return ResponseEntity.success(sysUserVos);
    }
}
