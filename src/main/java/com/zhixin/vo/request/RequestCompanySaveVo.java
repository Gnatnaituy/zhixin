package com.zhixin.vo.request;

import lombok.Data;

/**
 * @author yutiantang
 * @create 2021/5/28 23:17
 */
@Data
public class RequestCompanySaveVo {

    private Long id;

    private String name;

    private String bio;

    private String description;

    private String logo;

    private String location;

    private String isPrimary;

    private Integer sort;
}
