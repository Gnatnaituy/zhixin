package com.zhixin.vo.response;

import lombok.Data;

/**
 * @author yutiantang
 * @create 2021/5/28 23:16
 */
@Data
public class ResponseCompanyVo {

    private Long id;

    private String name;

    private String desc;

    private String location;

    private Integer sort;
}
