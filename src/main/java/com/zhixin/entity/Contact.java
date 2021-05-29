package com.zhixin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yutiantang
 * @create 2021/5/28 22:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Contact implements Serializable {

    private static final long serialVersionUID = -1840831686851699942L;

    private Long id;

    private String name;

    private String position;

    private String phone;

    private String email;

    private Integer sort;

    private Boolean isDeleted;

    private Long createTime;

    private Long updateTime;
}
