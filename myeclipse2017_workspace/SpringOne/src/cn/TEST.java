package cn;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TEST {
	@Test
	public void demo1(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		SA sa=(SA) applicationContext.getBean("user");
		sa.sayhello();
	}
}
