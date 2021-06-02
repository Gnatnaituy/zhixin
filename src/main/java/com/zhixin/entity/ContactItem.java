package com.zhixin.entity;

import com.zhixin.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yutiantang
 * @create 2021/6/2 00:17
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ContactItem extends BaseEntity {

    private Long contactId;

    private String name;

    private String value;

    private Integer sort;

    public static final String CONTACT_ID = "contact_id";
    public static final String NAME = "name";
    public static final String VALUE = "value";
    public static final String SORT = "sort";
}
