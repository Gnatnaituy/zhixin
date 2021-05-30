package com.zhixin.vo.response;

import com.zhixin.common.ResponseBaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yutiantang
 * @create 2021/5/28 23:16
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ResponseContactVo extends ResponseBaseVo {

    private String name;

    private String position;

    private String phone;

    private String email;

    private Integer sort;
}
