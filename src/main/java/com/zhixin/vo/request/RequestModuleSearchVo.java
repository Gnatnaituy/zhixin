package com.zhixin.vo.request;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author yutiantang
 * @create 2021/5/28 22:02
 */
@Data
@ApiModel
public class RequestModuleSearchVo {

    private Long typeId;

    private Long subTypeId;

    private Integer pageStart;

    private Integer pageLength;
}
