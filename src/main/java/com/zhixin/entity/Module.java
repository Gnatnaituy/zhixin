package com.zhixin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yutiantang
 * @create 2021/5/28 21:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Module implements Serializable {

    private static final long serialVersionUID = -1840831686851699943L;

    private Long id;

    private Long type;

    private Long subType;

    private String title;

    private String description;

    private String image;

    private String content;

    private Boolean isDeleted;

    private Long createTime;

    private Long updateTime;
}
