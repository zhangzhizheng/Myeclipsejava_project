package cn.spring1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * bean的实例化测试
 * @author Administrator
 *
 */
public class SpringTest2 {
	@Test
	//无参的构造方法实现
	public void demo1(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		Bean1 bean1=(Bean1) applicationContext.getBean("bean1");
		System.out.println(bean1);
	}
	@Test
	//静态工厂的实例化
	public void demo2(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		Bean2 bean2=(Bean2) applicationContext.getBean("bean2");
		System.out.println(bean2);
	}
	@Test
	//静态工厂的实例化
	public void demo3(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		Bean3 bean3=(Bean3) applicationContext.getBean("bean3");
		System.out.println(bean3);
	}
}
