package com.zhixin.entity;

import com.zhixin.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yutiantang
 * @create 2021/5/28 22:13
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Company extends BaseEntity {

    private String name;

    private String desc;

    private String location;

    private Integer sort;
}
