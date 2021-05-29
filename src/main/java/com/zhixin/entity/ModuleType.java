package com.zhixin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yutiantang
 * @create 2021/5/28 22:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ModuleType implements Serializable {

    private static final long serialVersionUID = -1840831686851699945L;

    private Long id;

    private String name;

    private String background;

    private Boolean isDeleted;

    private Integer sort;

    private Long createTime;

    private Long updateTime;
}
