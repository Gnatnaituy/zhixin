package com.zhixin.vo.common;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author yutiantang
 * @create 2021/6/13 10:40
 */
@Data
@ApiModel
public class RequestSearchVo {

    private Integer pageStart;

    private Integer pageLength;
}
