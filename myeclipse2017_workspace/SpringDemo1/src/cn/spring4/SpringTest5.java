package cn.spring4;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest5 {
	@Test
	public void demo1(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		Car car=(Car) applicationContext.getBean("car");
		System.out.println("属性:"+car);
	}
	@Test
	public void demo2(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		Car2 car2=(Car2) applicationContext.getBean("car2");
		System.out.println("人的信息:"+car2);
	}
	@Test
	public void demo3(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		Person person=(Person) applicationContext.getBean("person");
		System.out.println("人的信息:"+person);
	}
	@Test
	public void demo4(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		Car2 car2=(Car2) applicationContext.getBean("car3");
		System.out.println("人的信息:"+car2);
	}
}
