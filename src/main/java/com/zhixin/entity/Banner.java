package com.zhixin.entity;

import com.zhixin.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yutiantang
 * @create 2021/5/28 23:14
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Banner extends BaseEntity {

    private String image;

    private Integer sort;

    public static final String IMAGE = "image";
    public static final String SORT = "sort";
}
