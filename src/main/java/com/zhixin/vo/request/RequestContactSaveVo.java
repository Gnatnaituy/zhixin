package com.zhixin.vo.request;

import lombok.Data;

import java.util.List;

/**
 * @author yutiantang
 * @create 2021/5/28 23:18
 */
@Data
public class RequestContactSaveVo {

    private Long id;

    private Long companyId;

    private String title;

    private String name;

    private String position;

    private Integer sort;

    List<RequestContactItemSaveVo> contactItems;
}
