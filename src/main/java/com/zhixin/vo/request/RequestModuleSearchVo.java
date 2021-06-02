package com.zhixin.vo.request;

import lombok.Data;

/**
 * @author yutiantang
 * @create 2021/5/28 22:02
 */
@Data
public class RequestModuleSearchVo {

    private Long typeId;

    private Long subTypeId;

    private Integer pageStart;

    private Integer pageLength;
}
