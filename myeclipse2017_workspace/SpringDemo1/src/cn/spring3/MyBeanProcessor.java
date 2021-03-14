package cn.spring3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.google.common.base.FinalizablePhantomReference;

public class MyBeanProcessor implements BeanPostProcessor {
	/**
	 * bean:实例对象
	 * beanName:在配置文件的类标识
	 */
	@Override
	public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("s8:初始化之后执行----");
		//动态代理：
		if(beanName.equals("customerservice")){
			//Proxy.newProxyInstance(bean.getClass().getClassLoader(),bean.getClass().getInterfaces(), 处理器：是个接口：《1》自己写一个类实现接口或者是匿名类
			Object proxy=Proxy.newProxyInstance(bean.getClass().getClassLoader(),bean.getClass().getInterfaces(), new InvocationHandler() {
				//调用目标方法的时候，调用invoke方法
				@Override
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					// TODO Auto-generated method stub
					//通过判断方法名，相应的增强,其他的方法就增强
					if("add".equals(method.getName())){
						//开始时间
						System.out.println(System.currentTimeMillis());
						System.out.println("校验");
						Object result=method.invoke(bean, args);
						System.out.println("结束的时间："+System.currentTimeMillis());
						return result;
					}
					return method.invoke(bean, args);
				}
			});
			return proxy;
		}
		
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("s5:在初始化前执行---");
		return bean;
	}

}
