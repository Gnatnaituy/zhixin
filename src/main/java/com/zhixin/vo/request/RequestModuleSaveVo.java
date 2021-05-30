package com.zhixin.vo.request;

import lombok.Data;

/**
 * @author yutiantang
 * @create 2021/5/28 22:02
 */
@Data
public class RequestModuleSaveVo {

    private Long id;

    private Long typeId;

    private Long subTypeId;

    private String title;

    private String cover;

    private String description;

    private String content;
}
