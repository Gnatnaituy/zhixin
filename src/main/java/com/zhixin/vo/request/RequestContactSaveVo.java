package com.zhixin.vo.request;

import lombok.Data;

/**
 * @author yutiantang
 * @create 2021/5/28 23:18
 */
@Data
public class RequestContactSaveVo {

    private Long id;

    private String name;

    private String position;

    private String phone;

    private String email;
}
