package com.zhixin.entity;

import com.zhixin.common.BaseEntity;
import lombok.*;

import java.io.Serializable;

/**
 * @author yutiantang
 * @create 2021/5/28 22:15
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Contact extends BaseEntity {

    private Long companyId;

    private String title;

    private String name;

    private String position;

    private String phone;

    private String email;

    private Integer sort;

    public static final String COMPANY_ID = "company_id";
    public static final String TITLE = "title";
    public static final String NAME = "name";
    public static final String POSITION = "position";
    public static final String PHONE = "phone";
    public static final String EMAIL = "email";
    public static final String SORT = "sort";
}
