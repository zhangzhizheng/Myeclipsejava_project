package cn.spring.annotation2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest2 {
	@Test
	public void demo1(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		Car car=(Car) applicationContext.getBean("car");
		Product product=(Product) applicationContext.getBean("product");
		System.out.println(car);
		System.out.println(product);
	}
}
