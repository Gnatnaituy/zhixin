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

    private String bio;

    private String description;

    private String logo;

    private String location;

    private Double lng;

    private Double lat;

    private String isPrimary;

    private Integer sort;

    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    public static final String LOCATION = "location";
    public static final String SORT = "sort";
}
