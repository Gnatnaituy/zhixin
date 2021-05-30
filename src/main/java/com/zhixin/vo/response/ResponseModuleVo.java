package com.zhixin.vo.response;

import com.zhixin.common.ResponseBaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yutiantang
 * @create 2021/5/28 22:02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ResponseModuleVo extends ResponseBaseVo {

    private Long typeId;

    private String typeName;

    private Long subTypeId;

    private String subTypeName;

    private String title;

    private String image;

    private String desc;

    private String content;
}
