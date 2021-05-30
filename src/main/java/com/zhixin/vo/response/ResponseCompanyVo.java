package com.zhixin.vo.response;

import com.zhixin.common.ResponseBaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yutiantang
 * @create 2021/5/28 23:16
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ResponseCompanyVo extends ResponseBaseVo {

    private String name;

    private String desc;

    private String location;

    private Integer sort;
}
