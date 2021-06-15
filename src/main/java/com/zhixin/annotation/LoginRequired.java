package com.zhixin.annotation;

import java.lang.annotation.*;

/**
 * @author yutiantang
 * @create 2021/6/15 15:20
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginRequired {
}
