package com.zhixin.vo.response;

import com.zhixin.common.ResponseBaseVo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yutiantang
 * @create 2021/5/28 22:12
 */
@Data
@ApiModel
@EqualsAndHashCode(callSuper = true)
public class ResponseModuleSubTypeVo extends ResponseBaseVo {

    private Long moduleTypeId;

    private String name;

    private Integer sort;
}
