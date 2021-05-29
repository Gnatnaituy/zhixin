package com.zhixin.vo.response;

import lombok.Data;

/**
 * @author yutiantang
 * @create 2021/5/28 22:02
 */
@Data
public class ResponseModuleVo {

    private Long id;

    private Long type;

    private String typeName;

    private Long subType;

    private String subTypeName;

    private String title;

    private String image;

    private String desc;

    private String content;

    private Long createTime;
}
