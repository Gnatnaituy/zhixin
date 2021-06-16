package com.zhixin.vo.request;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author yutiantang
 * @create 2021/6/2 09:36
 */
@Data
@ApiModel
public class RequestContactItemSaveVo {

    private Long id;

    private Long companyId;

    private Long contactId;

    private String name;

    private String value;

    private Integer sort;
}
