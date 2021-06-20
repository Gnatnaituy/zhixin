package com.zhixin.vo.request;

import com.zhixin.vo.common.RequestSearchVo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yutiantang
 * @create 2021/5/28 22:02
 */
@Data
@ApiModel
@EqualsAndHashCode(callSuper = true)
public class RequestModuleSearchVo extends RequestSearchVo {

    private Long typeId;

    private Long subTypeId;

    private String showInHomePage;
}
