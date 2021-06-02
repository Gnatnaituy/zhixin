package com.zhixin.vo.request;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author yutiantang
 * @create 2021/5/28 22:11
 */
@Data
@ApiModel
public class RequestModuleTypeSaveVo {

    private Long id;

    private String name;

    private String background;

    private String path;

    private String showInHomePage;

    private Integer sort;
}
