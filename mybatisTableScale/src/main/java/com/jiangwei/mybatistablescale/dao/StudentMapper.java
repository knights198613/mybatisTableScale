package com.jiangwei.mybatistablescale.dao;

import com.jiangwei.mybatistablescale.entity.Student;

/**
 * Creator: jiang.wei
 * Date: 2018/8/15
 * DESC:
 */

public interface StudentMapper {

    Student selectOneByCode(int code);
}
