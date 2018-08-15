package com.jiangwei.mybatistablescale.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Creator: jiang.wei
 * Date: 2018/8/15
 * DESC: 分表策略管理器
 */
public class StrategyManager {
	private Logger logger = LoggerFactory.getLogger(StrategyManager.class);
	private  Map<String,Strategy> strategies = new ConcurrentHashMap<String,Strategy>(10);
	
	public  Strategy getStrategy(String key){
		return strategies.get(key);
	}

	public   Map<String, Strategy> getStrategies() {
		return strategies;
	}

	/**
	 * 策略组装
	 * @param strategies
	 */
	public  void setStrategies(Map<String, String> strategies) {
		for(Entry<String, String> entry : strategies.entrySet()){
			try {
				this.strategies.put(entry.getKey(),(Strategy)Class.forName(entry.getValue()).newInstance());
			} catch (Exception e) {
				logger.error("实例化策略出错", e);
			}
		}
		printDebugInfo();
	}


	private void printDebugInfo(){
		StringBuffer msg= new StringBuffer("初始化了"+strategies.size()+"策略");
		for(String key: strategies.keySet()){
			msg.append("\n");
			msg.append(key);
			msg.append("  --->  ");
			msg.append(strategies.get(key));
		}
		logger.debug(msg.toString());
	}
}
