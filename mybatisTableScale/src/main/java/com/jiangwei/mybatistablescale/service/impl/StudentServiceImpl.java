package com.jiangwei.mybatistablescale.service.impl;

import com.jiangwei.mybatistablescale.dao.StudentMapper;
import com.jiangwei.mybatistablescale.entity.Student;
import com.jiangwei.mybatistablescale.service.StudentService;
import com.jiangwei.mybatistablescale.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Creator: jiang.wei
 * Date: 2018/8/15
 * DESC:
 */
@Service("studentService")
public class StudentServiceImpl extends BaseServiceImpl implements StudentService {

    @Override
    public Student findOneByCode(int code) {
        return this.getReadMapperd(StudentMapper.class).selectOneByCode(code);
    }
}
