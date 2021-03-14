package cn.demo1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 默认JdbcTemplate配置写法
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTest1 {
	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	@Test
	public void demo1(){
		//创建连接池
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		//设置参数
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/info");
		dataSource.setUsername("root");
		dataSource.setPassword("mysql123");
		//使用JDBC的模板
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);//传放入dataSoure参数
		jdbcTemplate.execute("select * from user");
	}
	@Test
	public void demo2(){
		jdbcTemplate.execute("insert into student values(20,'黄蜂3','1455223')");
	}

}
