package cn.spring1;
/**
 * bean2的静态工厂
 * @author Administrator
 *
 */
public class Bean2Factory {
	public static Bean2 getBean2(){
		System.out.println("bean2实例执行");
		return new Bean2();
		
	}
}
