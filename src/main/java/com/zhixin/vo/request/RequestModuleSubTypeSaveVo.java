package com.zhixin.vo.request;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author yutiantang
 * @create 2021/5/28 22:11
 */
@Data
@ApiModel
public class RequestModuleSubTypeSaveVo {

    private Long id;

    private Long moduleTypeId;

    private String expandModuleContent;

    private String name;

    private Integer sort;
}
