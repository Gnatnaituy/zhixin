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
public class ResponseContactVo extends ResponseBaseVo {

    private Long companyId;

    private String title;

    private String name;

    private String position;

    private Integer sort;

    List<ResponseContactItemVo> items;
}
