package com.zhixin.vo.request;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * @author yutiantang
 * @create 2021/5/28 23:18
 */
@Data
@ApiModel
public class RequestContactSaveVo {

    private Long id;

    private Long companyId;

    private String title;

    private String name;

    private String position;

    private Integer sort;

    List<RequestContactItemSaveVo> contactItems;
}
