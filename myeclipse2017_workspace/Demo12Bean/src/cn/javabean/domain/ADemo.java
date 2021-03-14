package cn.javabean.domain;

import java.lang.reflect.InvocationTargetException;
import java.net.PasswordAuthentication;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import cn.javabean.utils.CommonUtils;

public class ADemo {
	@Test
	public void fun1() throws Exception{
		String className="cn.javabean.domain.Student";
		/**
		 * Class.forName()在运行时加载；Class.class和getClass()是在编译时加载.
		 * Class.forName("类名字符串")  （注：类名字符串是包名+类名）  说明：装入类,并做类的静态初始化，返回Class的对象
		 */
		Class clazz=Class.forName(className);
		Object bean=clazz.newInstance();
		BeanUtils.setProperty(bean, "name", "张三");
		BeanUtils.setProperty(bean, "age", "18");
		BeanUtils.setProperty(bean, "sex", "男");
		System.out.println(bean);
	}
	/**
	 * 把map的属性直接封装到一个bean
	 * Map:{"username:"zhangsan","password","12345"}
	 * 我们要把map的数据装到Java Bean中，要求map的key与bean的属性名相同
	 * @throws Exception 
	 * 
	 */
	@Test
	public void fun2() throws  Exception{
		Map<String, String> map=new HashMap<String, String>();
		map.put("username", "zhangsan");
		map.put("password", "12345");
		User user1=new User();
		BeanUtils.populate(user1, map);
		System.out.println(user1);
		
		
	}
	@Test
	public void fun3(){
		Map<String, String> map=new HashMap<String, String>();
		map.put("username", "zhangsan");
		map.put("password", "12345");
		User user2=CommonUtils.toBean(map, User.class);
		System.out.println(user2);
	}
}
