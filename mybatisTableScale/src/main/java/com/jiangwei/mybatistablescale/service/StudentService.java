package com.jiangwei.mybatistablescale.service;

import com.jiangwei.mybatistablescale.entity.Student;

/**
 * Creator: jiang.wei
 * Date: 2018/8/15
 * DESC:
 */

public interface StudentService {

    Student findOneByCode(int code);
}
