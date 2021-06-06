package com.zhixin.entity;

import com.zhixin.common.BaseEntity;
import lombok.*;

import java.io.Serializable;

/**
 * @author yutiantang
 * @create 2021/5/28 22:03
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ModuleSubType extends BaseEntity {

    private Long moduleTypeId;

    private String name;

    private String expandModuleContent;

    private Integer sort;

    public static final String MODULE_TYPE_ID = "module_type_id";
    public static final String EXPAND_MODULE_CONTENT = "expand_module_content";
    public static final String NAME = "name";
    public static final String SORT = "sort";
}
