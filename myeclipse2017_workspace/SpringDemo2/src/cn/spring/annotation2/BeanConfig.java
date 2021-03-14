package cn.spring.annotation2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * 配置类
 * @author Administrator
 *
 */
@Configuration
public class BeanConfig {
	@Bean(name="car")
	public Car showCar() {
		Car car=new Car();
		car.setName("奥迪");
		car.setPrice(35.9);
		return car;
	}
	@Bean(name="product")
	public Product showProduct() {
		Product product=new Product();
		product.setName("电脑");
		product.setPrice(3.5);
		return product;
		
	}
}
