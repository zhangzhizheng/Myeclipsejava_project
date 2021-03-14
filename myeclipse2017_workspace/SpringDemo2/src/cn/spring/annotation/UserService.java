package cn.spring.annotation;

import org.springframework.stereotype.Component;

/**
 * 基于注解方式装配方式
 * @author Administrator
 */
@Component("userService")
public class UserService {
	public void sayHello(){
		System.out.println("hello,spring.annotation!");
	}
}
