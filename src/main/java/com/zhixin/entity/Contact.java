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

    private String name;

    private String position;

    private String phone;

    private String email;

    private Integer sort;
}
