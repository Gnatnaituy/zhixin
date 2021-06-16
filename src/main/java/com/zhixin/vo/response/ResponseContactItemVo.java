package com.zhixin.vo.response;

import com.zhixin.common.ResponseBaseVo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yutiantang
 * @create 2021/6/2 00:31
 */
@Data
@ApiModel
@EqualsAndHashCode(callSuper = true)
public class ResponseContactItemVo extends ResponseBaseVo {

    private Long companyId;

    private Long contactId;

    private String name;

    private String value;

    private Integer sort;
}
