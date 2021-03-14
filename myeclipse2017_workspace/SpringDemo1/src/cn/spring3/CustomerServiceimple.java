package cn.spring3;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
/**
 * Bean生命周期演示
 * @author Administrator
 *
 */
public class CustomerServiceimple implements CustomerService,BeanNameAware,ApplicationContextAware,InitializingBean,DisposableBean{
	private String name;
	public CustomerServiceimple() {
		// TODO Auto-generated constructor stub
		System.out.println("s1:实例化");
	}
	public void add(){
		System.out.println("添加客户");
		
	}
	public void find(){
		System.out.println("查找客户");
	}
	public String getName() {
		return name;
	}
	//注入属性
	public void setName(String name) {
		System.out.println("s2:属性的注入");
		this.name = name;
	}
	@Override
	public void setBeanName(String arg0) {
		// TODO Auto-generated method stub
		System.out.println("s3:注入配置类的名称"+name);
	}
	public void name() {
		
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("s4:注入applicationContext"+applicationContext);
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("s6:属性设置后执行---");
	}
	public void setup(){
		System.out.println("s7：调用手动初始化的方法");
	}
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("s10：调用销毁的方法");
		
	}
	public void teardown(){
		System.out.println("s11:调用自己的定义销毁的方法");
	}
}
