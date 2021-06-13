package com.zhixin.vo.request;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author yutiantang
 * @create 2021/6/13 10:30
 */
@Data
@ApiModel
public class RequestJobSaveVo {

    private Long id;

    private String title;

    private String content;
}
