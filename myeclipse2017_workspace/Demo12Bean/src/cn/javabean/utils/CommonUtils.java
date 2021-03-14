package cn.javabean.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;

public class CommonUtils {
	/**
	 * 生成不重复的32位长的大写字符串
	 * @return
	 */
	public String   uuid() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}
	/**
	 * 把map转成指定类型的JavaBean对象
	 * @param map
	 * @param clazz
	 * @return
	 */
	public static <T> T toBean(Map map,Class<T> clazz){
		
		try {
			/*
			 * 1创建指定类的javabean对象
			 */
			T bean=clazz.newInstance();
			/**
			 * 2.把数据封装到Java bean中
			 */
			BeanUtils.populate(bean, map);
			/**
			 * 3.返回Javabean;
			 */
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		
		}
	}

}
