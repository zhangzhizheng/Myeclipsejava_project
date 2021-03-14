package cn.spring1;
/**
 * 使用实例的工厂
 * @author Administrator
 *
 */
public class Bean3Factory {
	public Bean3 getBean3(){
		System.out.println("Bean3实例执行");
		return new Bean3();
	}
}
