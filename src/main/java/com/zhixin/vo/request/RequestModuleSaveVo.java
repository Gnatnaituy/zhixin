package com.zhixin.vo.request;

import lombok.Data;

/**
 * @author yutiantang
 * @create 2021/5/28 22:02
 */
@Data
public class RequestModuleSaveVo {

    private Long id;

    private Long type;

    private Long subType;

    private String title;

    private String image;

    private String desc;

    private String content;
}
