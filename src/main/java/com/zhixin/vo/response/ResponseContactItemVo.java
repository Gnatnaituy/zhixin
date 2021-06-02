package com.zhixin.vo.response;

import com.zhixin.common.ResponseBaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yutiantang
 * @create 2021/6/2 00:31
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ResponseContactItemVo extends ResponseBaseVo {

    private Long contactId;

    private String name;

    private String value;

    private Integer sort;
}
