package cn.spring.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest11 {
	@Test
	public void demo1(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserService userService=(UserService) applicationContext.getBean("userService");
		userService.sayHello();
	}
}
