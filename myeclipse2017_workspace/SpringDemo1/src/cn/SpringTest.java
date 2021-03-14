package cn;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringTest {
	@Test
	public void demo1(){
		//创建一个工厂类ApplicationContext，它继承了BeanFactory
		//ClassPathXmlApplicationContext是加载classpath下面的配置文件
		//对应的FileSystemXmlApplicationContext是加载磁盘路径下的文件
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		SpringImple springImple=(SpringImple) applicationContext.getBean("user");
		springImple.sayhello();
		
	}
}
