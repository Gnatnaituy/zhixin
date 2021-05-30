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

    private Long typeId;

    private String name;

    private Integer sort;
}
