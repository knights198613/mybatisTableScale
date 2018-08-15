package com.jiangwei.mybatistablescale.strategy.impl;

import com.jiangwei.mybatistablescale.strategy.Strategy;
import com.jiangwei.mybatistablescale.utils.JsonUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;
import java.util.Map;

/**
 * Creator: jiang.wei
 * Date: 2018/8/15
 * DESC: 值支持map和Object分表策略
 */
public class RemainderStrategy implements Strategy {
	private Log log = LogFactory.getLog(RemainderStrategy.class);
	/**
	 * 表空间全集数
	 */
	private static final int DIVIDER=3;

	@Override
	public String convert(Map<String, Object> params) throws Exception{
		StringBuilder sb=new StringBuilder(params.get(Strategy.TABLE_NAME).toString());
		sb.append("_");
		String field=JsonUtil.getString(params, Strategy.SPLIT_FIELD);
		//List<Map<String,Object>> paramDeclare = JsonUtil.toList(params.get(Strategy.EXECUTE_PARAM_DECLARE));
		Object paramValue= params.get(Strategy.EXECUTE_PARAM_VALUES);
		String value="";
		if(paramValue instanceof Map){
			if(((Map) paramValue).size()==1){
				if(((Map) paramValue).containsKey("list")){
					paramValue =((List)((Map) paramValue).get("list")).get(0);
				}else if(((Map) paramValue).containsKey("array")){
					paramValue =((Object[])((Map) paramValue).get("list"))[0];
				}
				value = BeanUtils.getProperty(paramValue,field);
			}else{
				value = JsonUtil.getString((Map<String, Object>) paramValue, field);
			}

		}else{
			value= BeanUtils.getProperty(paramValue,field);
		}
		Integer reminder = Integer.valueOf(value) % DIVIDER;
		sb.append(Integer.toHexString(reminder));
		return sb.toString();
	}

}
