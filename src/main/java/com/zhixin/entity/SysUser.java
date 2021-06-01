package com.zhixin.entity;

import com.zhixin.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yutiantang
 * @create 2021/5/31 18:02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysUser extends BaseEntity {

    private String name;

    private String username;

    private String password;

    private String position;

    private String email;

    private String phone;

    public static final String NAME = "name";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String POSITION = "position";
    public static final String EMAIL = "email";
    public static final String PHONE = "phone";
}
