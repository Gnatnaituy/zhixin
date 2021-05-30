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

    private String image;

    private String content;
}
