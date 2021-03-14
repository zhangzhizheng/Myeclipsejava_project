package cn.spring.demo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class SpringTest1 {
	@SuppressWarnings("resource")
	@Test
	public void demo1(){
		
	   ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		Service service=(Service) applicationContext.getBean("userService");
		service.sayhello();
		
	}
}
