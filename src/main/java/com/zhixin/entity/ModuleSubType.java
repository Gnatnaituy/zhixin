package com.zhixin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yutiantang
 * @create 2021/5/28 22:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ModuleSubType implements Serializable {

    private static final long serialVersionUID = -1840831686851699944L;

    private Long id;

    private Long typeId;

    private String name;

    private Integer sort;

    private Boolean isDeleted;

    private Long createTime;

    private Long updateTime;
}
