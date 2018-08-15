package com.jiangwei.mybatistablescale.service;

import com.jiangwei.mybatistablescale.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Creator: jiang.wei
 * Date: 2018/8/15
 * DESC:
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring_config.xml" )
public class StudentServiceTest {

    @Autowired
    StudentService studentService;

    @Test
    public void testSelectOne() {
       Student student = studentService.findOneByCode(10);
    }
}
