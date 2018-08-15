package com.jiangwei.mybatistablescale.utils;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.math.BigDecimal;
import java.util.Map;

/**
 * Creator: jiang.wei
 * Date: 2018/8/15
 * DESC: json 工具类
 */

public class JsonUtil {

    private static final Logger LOG = LoggerFactory.getLogger(JsonUtil.class);

    /**
     * 
     * 根据key取得相应的值
     * 
     * @param map
     *            欲取值的map
     * @param key
     *            key
     * @return String
     */
    public static String getString(Map<String, Object> map, String key) {
        try {
            return (String) map.get(key);
        } catch (Exception e) {
            return JsonUtil.toString(map.get(key));
        }
    }


    /**
     * 
     * 根据key取值int
     * 
     * @param map
     *            欲取值的map
     * @param key
     *            key
     * @param defaultValue
     *            默认值
     * @return int
     */
    public static int getInt(Map<String, Object> map, String key, int defaultValue) {
        try {
            return (Integer) map.get(key);
        } catch (Exception e) {
            try {
                return Integer.parseInt(JsonUtil.toString(map.get(key)));
            } catch (Exception e2) {
                return defaultValue;
            }
        }
    }

    /**
     * 
     * 根据key取BigDecial
     * 
     * @param map
     *            欲取值的map
     * @param key
     *            key
     * @param defaultValue
     *            默认值
     * @return BigDecimal
     */
    public static BigDecimal getBigDecimal(Map<String, Object> map, String key, BigDecimal defaultValue) {
        return new BigDecimal(getDouble(map, key, defaultValue.doubleValue()));
    }

    /**
     * 
     * 根据key取BigDecial
     * 
     * @param map
     *            欲取值的map
     * @param key
     *            key
     * @return BigDecimal
     */
    public static BigDecimal getBigDecimal(Map<String, Object> map, String key) {
        return new BigDecimal(getDouble(map, key));
    }

    /**
     * 
     * 根据key取值int
     * 
     * @param map
     *            欲取值的map
     * @param key
     *            key
     * @return int
     */
    public static int getInt(Map<String, Object> map, String key) {
        return JsonUtil.getInt(map, key, 0);
    }

    /**
     * 
     * 根据key取得boolean值
     * 
     * @param map
     *            欲取值的map
     * @param key
     *            key
     * @param defaultValue
     *            默认值
     * @return boolean
     */
    public static boolean getBoolean(Map<String, Object> map, String key, boolean defaultValue) {
        try {
            return (Boolean) map.get(key);
        } catch (Exception e) {
            try {
                return Boolean.parseBoolean(JsonUtil.toString(map.get(key)));
            } catch (Exception e2) {
                return defaultValue;
            }
        }
    }

    /**
     * 
     * 根据key取得boolean值,默认为false
     * 
     * @param map
     *            欲取值的map
     * @param key
     *            key
     * @return boolean
     */
    public static boolean getBoolean(Map<String, Object> map, String key) {
        return getBoolean(map, key, false);
    }



    /**
     * 
     * 根据key取得double值
     * 
     * @param map
     *            欲取值的map
     * @param key
     *            key
     * @param defaultValue
     *            默认值
     * @return double
     */
    public static double getDouble(Map<String, Object> map, String key, double defaultValue) {
        try {
            return (Double) map.get(key);
        } catch (Exception e) {
            try {
                return Double.parseDouble(JsonUtil.toString(map.get(key)));
            } catch (Exception e2) {
                return defaultValue;
            }
        }

    }

    /**
     * 
     * 根据key取得double值
     * 
     * @param map
     *            欲取值的map
     * @param key
     *            key
     * @return double
     */
    public static double getDouble(Map<String, Object> map, String key) {
        return getDouble(map, key, 0D);
    }

    /**
     * 
     * 根据key取得double值
     *
     * @param map
     *            欲取值的map
     * @param key
     *            key
     * @param defaultValue
     *            默认值
     * @return long
     */
    public static long getLong(Map<String, Object> map, String key, long defaultValue) {
        try {
            return (Long) map.get(key);
        } catch (Exception e) {
            try {
                return Long.parseLong(JsonUtil.toString(map.get(key)));
            } catch (Exception e2) {
                return defaultValue;
            }
        }
    }

    /**
     * 
     * 此方法描述的是：根据key取得double值
     * 
     * @param map
     *            欲取值的map
     * @param key
     *            key
     * @return long
     */
    public static long getLong(Map<String, Object> map, String key) {
        return getLong(map, key, 0L);
    }

    /**
     * 
     * 将Object转化为Json格式字符串
     * 
     * @param obj
     *            欲转换的对象
     * @return String
     */
    public static String toString(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        } else if (null == obj) {
            return null;
        }
        return JSON.toJSONString(obj);

    }


}
