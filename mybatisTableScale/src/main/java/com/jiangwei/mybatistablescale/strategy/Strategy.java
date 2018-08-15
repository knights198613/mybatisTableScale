package com.jiangwei.mybatistablescale.strategy;

import java.util.Map;

/**
 * Creator: jiang.wei
 * Date: 2018/8/15
 * DESC: 分表策略接口
 */
public interface Strategy {
	/**
	 * 表基
	 */
	String TABLE_NAME="table_name";
	/**
	 * 分表维度字段
	 */
	String SPLIT_FIELD="split_field";
	/**
	 * 执行器参数申明标识
	 */
	String EXECUTE_PARAM_DECLARE="execute_param_declare";
	/**
	 * 执行器参数值标识
	 */
	String EXECUTE_PARAM_VALUES="execute_param_values";
	/**
	 * 传入一个需要分表的表名，返回一个处理后的表名 
	 * Strategy必须包含一个无参构造器
	 * @param params
	 * @return
	 */
	String convert(Map<String, Object> params) throws Exception;
}
