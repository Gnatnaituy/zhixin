package com.zhixin.vo.response;

import com.zhixin.common.ResponseBaseVo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author yutiantang
 * @create 2021/5/28 22:11
 */
@Data
@ApiModel
@EqualsAndHashCode(callSuper = true)
public class ResponseModuleTypeVo extends ResponseBaseVo {

    private String name;

    private String background;

    private String path;

    private String showInHomePage;

    private String homePageLayout;

    private String showSubTypeAll;

    List<ResponseModuleVo> modules;

    private Integer sort;
}
