package com.zhixin.vo.request;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author yutiantang
 * @create 2021/5/28 23:16
 */
@Data
@ApiModel
public class RequestBannerSaveVo {

    private Long id;

    private String image;

    private Integer sort;
}
