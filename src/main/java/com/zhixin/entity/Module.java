package com.zhixin.entity;

import com.zhixin.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yutiantang
 * @create 2021/5/28 21:57
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Module extends BaseEntity {

    private Long typeId;

    private Long subTypeId;

    private String title;

    private String description;

    private String cover;

    private String content;

    public static final String TYPE_ID = "type_id";
    public static final String SUB_TYPE_ID = "sub_type_id";
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final String COVER = "cover";
    public static final String CONTENT = "content";
}
