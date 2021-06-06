package com.zhixin.vo.request;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author yutiantang
 * @create 2021/5/28 23:17
 */
@Data
@ApiModel
public class RequestCompanySaveVo {

    private Long id;

    private String name;

    private String bio;

    private String description;

    private String logo;

    private String location;

    private Double lng;

    private Double lat;

    private String isPrimary;

    private Integer sort;
}
