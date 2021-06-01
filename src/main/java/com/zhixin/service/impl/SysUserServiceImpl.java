package com.zhixin.service.impl;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhixin.entity.SysUser;
import com.zhixin.mapper.SysUserMapper;
import com.zhixin.service.SysUserService;
import com.zhixin.vo.common.ResponseEntity;
import com.zhixin.vo.request.RequestSysUserSaveVo;
import com.zhixin.vo.response.ResponseSysUserVo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yutiantang
 * @create 2021/5/31 18:05
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity save(RequestSysUserSaveVo saveVo) {
        SysUser sysUser = Convert.convert(SysUser.class, saveVo);
        sysUser.setPassword(new BCryptPasswordEncoder().encode(saveVo.getPassword()));
        if (ObjectUtils.isEmpty(sysUser.getId())) {
            this.save(sysUser);
        } else {
            this.updateById(sysUser);
        }
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SysUser.USERNAME, username);
        SysUser sysUser = this.getOne(queryWrapper);
        if (ObjectUtils.isEmpty(sysUser)) {
            throw new UsernameNotFoundException("用户不存在！");
        }
        return new User(username, sysUser.getPassword(), Collections.emptyList());
    }
}
