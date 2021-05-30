package com.zhixin.vo.response;

import com.zhixin.common.ResponseBaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yutiantang
 * @create 2021/5/28 22:12
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ResponseModuleSubTypeVo extends ResponseBaseVo {

    private Long typeId;

    private String name;

    private Integer sort;
}
