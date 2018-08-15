package com.jiangwei.mybatistablescale.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Creator: jiang.wei
 * Date: 2018/8/15
 * DESC:
 */
@Data
public class Student implements Serializable {
    private static final long serialVersionUID = -5242061250102549374L;

    private int id;
    private int code;
    private String name;
}
