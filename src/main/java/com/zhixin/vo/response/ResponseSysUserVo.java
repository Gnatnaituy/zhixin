package com.zhixin.vo.response;

import com.zhixin.common.ResponseBaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yutiantang
 * @create 2021/5/31 18:07
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ResponseSysUserVo extends ResponseBaseVo {

    private String name;

    private String username;

    private String password;

    private String position;

    private String email;

    private String phone;
}
