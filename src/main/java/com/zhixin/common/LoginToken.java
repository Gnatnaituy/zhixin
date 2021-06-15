package com.zhixin.common;

import com.zhixin.entity.SysUser;
import lombok.Data;

/**
 * @author yutiantang
 * @create 2021/6/15 15:15
 */
@Data
public class LoginToken {

    private String token;

    private Long expireTime;

    private SysUser user;
}
