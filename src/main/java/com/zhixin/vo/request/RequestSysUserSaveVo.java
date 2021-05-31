package com.zhixin.vo.request;

import lombok.Data;

/**
 * @author yutiantang
 * @create 2021/5/31 18:07
 */
@Data
public class RequestSysUserSaveVo {

    private Long id;

    private String name;

    private String username;

    private String password;

    private String position;

    private String email;

    private String phone;
}
