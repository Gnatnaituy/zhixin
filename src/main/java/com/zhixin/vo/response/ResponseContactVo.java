package com.zhixin.vo.response;

import lombok.Data;

/**
 * @author yutiantang
 * @create 2021/5/28 23:16
 */
@Data
public class ResponseContactVo {

    private Long id;

    private String name;

    private String position;

    private String phone;

    private String email;

    private Integer sort;
}
