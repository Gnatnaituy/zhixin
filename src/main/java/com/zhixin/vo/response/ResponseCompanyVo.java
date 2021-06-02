package com.zhixin.vo.response;

import com.zhixin.common.ResponseBaseVo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author yutiantang
 * @create 2021/5/28 23:16
 */
@Data
@ApiModel
@EqualsAndHashCode(callSuper = true)
public class ResponseCompanyVo extends ResponseBaseVo {

    private String name;

    private String bio;

    private String description;

    private String logo;

    private String location;

    private String isPrimary;

    private Integer sort;

    private List<ResponseContactVo> contacts;
}
