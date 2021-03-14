package cn.spring5;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest6 {
	@Test
	public void demo1() {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		Collection1 collection1=(Collection1) applicationContext.getBean("collection1");
		System.out.println(collection1);
	}
}
