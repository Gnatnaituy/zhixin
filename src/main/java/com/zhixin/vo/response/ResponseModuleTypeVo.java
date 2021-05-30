package com.zhixin.vo.response;

import com.zhixin.common.ResponseBaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yutiantang
 * @create 2021/5/28 22:11
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ResponseModuleTypeVo extends ResponseBaseVo {

    private String name;

    private String background;

    private Integer sort;
}
