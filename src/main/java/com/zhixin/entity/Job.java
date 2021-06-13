package com.zhixin.entity;

import com.zhixin.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yutiantang
 * @create 2021/6/13 10:26
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Job extends BaseEntity {

    private String title;

    private String content;
}
