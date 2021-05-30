package com.zhixin.vo.request;

import lombok.Data;

/**
 * @author yutiantang
 * @create 2021/5/28 22:11
 */
@Data
public class RequestModuleSubTypeSaveVo {

    private Long id;

    private Long moduleTypeId;

    private String name;

    private Integer sort;
}
