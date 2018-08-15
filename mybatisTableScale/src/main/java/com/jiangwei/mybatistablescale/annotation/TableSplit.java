package com.jiangwei.mybatistablescale.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Creator: jiang.wei
 * Date: 2018/8/15
 * DESC: 分表实体注解标识分表机制
 */
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface TableSplit {
    //是否分表
    boolean split() default true;
    //表名称
    String value() default "";
    //分表维度
    String field() default "";
    //获取分表策略
    String strategy();
}
