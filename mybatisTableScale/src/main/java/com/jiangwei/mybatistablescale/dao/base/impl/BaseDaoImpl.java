package com.jiangwei.mybatistablescale.dao.base.impl;

import com.jiangwei.mybatistablescale.dao.base.BaseDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Creator: jiang.wei
 * Date: 2018/8/15
 * DESC:
 */

@Repository
public class BaseDaoImpl implements BaseDao{

    @Resource
    private SqlSession sqlSessionMaster;

    @Resource
    private SqlSession sqlSessionSlave;

    public <T> T getWriteMapper(Class<T> type) {
        return sqlSessionMaster.getMapper(type);
    }

    public <T> T getReadMapperd(Class<T> type) {
        return sqlSessionSlave.getMapper(type);
    }
}