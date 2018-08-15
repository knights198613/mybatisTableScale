package com.jiangwei.mybatistablescale.strategy.impl;

import com.dushangkui.domyself.common.util.split.Strategy;
import com.jiangwei.mybatistablescale.strategy.Strategy;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Creator: jiang.wei
 * Date: 2018/8/15
 * DESC: 按年份维度分表策略
 */
public class YYYYStrategy implements Strategy {

	@Override
	public String convert(Map<String, Object> params) {
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY");
		StringBuilder sb=new StringBuilder(params.get(Strategy.TABLE_NAME).toString());
		sb.append("_");
		sb.append(sdf.format(new Date()));
		return sb.toString();
	}
	
}