package cn.spring3;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest4 {
	@Test
	public void demo1(){
		ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerService customerService=(CustomerService) applicationContext.getBean("customerservice");
		customerService.add();
		customerService.find();
		applicationContext.close();
		
	}
}
