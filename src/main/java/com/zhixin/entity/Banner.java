package com.zhixin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yutiantang
 * @create 2021/5/28 23:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Banner implements Serializable {

    private static final long serialVersionUID = -1840831686851699941L;

    private Long id;

    private String image;

    private Integer sort;

    private Boolean isDeleted;
}
