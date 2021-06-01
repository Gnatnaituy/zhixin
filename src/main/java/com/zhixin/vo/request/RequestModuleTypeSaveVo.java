package com.zhixin.vo.request;

import lombok.Data;

/**
 * @author yutiantang
 * @create 2021/5/28 22:11
 */
@Data
public class RequestModuleTypeSaveVo {

    private Long id;

    private String name;

    private String background;

    private String path;

    private String showInHomePage;

    private Integer sort;
}
