package com.zhixin.entity;

import com.zhixin.common.BaseEntity;
import lombok.*;

import java.io.Serializable;

/**
 * @author yutiantang
 * @create 2021/5/28 22:01
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ModuleType extends BaseEntity {

    private String name;

    private String background;

    private String path;

    private String showInHomePage;

    private String homePageLayout;

    private String showSubTypeAll;

    private Integer sort;

    public static final String NAME = "name";
    public static final String PATH = "path";
    public static final String SHOW_IN_HOME_PAGE = "show_in_home_page";
    public static final String HOME_PAGE_LAYOUT = "home_page_layout";
    public static final String SHOW_SUB_TYPE_ALL = "show_sub_type_all";
    public static final String BACKGROUND = "background";
    public static final String SORT = "sort";
}
