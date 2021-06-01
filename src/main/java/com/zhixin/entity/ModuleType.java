package com.zhixin.entity;

import com.zhixin.common.BaseEntity;
import lombok.*;

import java.io.Serializable;

/**
 * @author yutiantang
 * @create 2021/5/28 22:01
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ModuleType extends BaseEntity {

    private String name;

    private String background;

    private String path;

    private String showInHomePage;

    private Integer sort;

    public static final String NAME = "name";
    public static final String BACKGROUND = "background";
    public static final String SORT = "sort";
}
