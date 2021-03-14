package cn.my.dbcp;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

/**
 * DBCP连接池
 * @author Administrator
 *
 */
public class DemoDBCP {
	@Test
	public void fun2() throws SQLException{
		/**
		 * 1.创建连接池
		 * 2.配置四大参数对象
		 * 3.配置连接池参数
		 * 4.得到连接对象
		 */
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/info");
		dataSource.setUsername("root");
		dataSource.setPassword("mysql123");
		
		dataSource.setMaxActive(20);//设置活动连接数                                                      
		dataSource.setMinIdle(3);
		dataSource.setMaxWait(2000);//最大等待时间
		
		Connection conn=dataSource.getConnection();
		System.out.println(conn);
		System.out.println(conn.getClass().getName());
		/**
		 * 连接池内部使用的四大参数创建了连接对象！即mysql驱动提供的Connnection
		 * 连接池使用mysql的连接对象进行了装饰，只对close()方法进行了增强
		 * 装饰之后的Connection的close()的方法，用来把当前的连接归还给连接池
		 */
		conn.close();//归还连接给池
	}
}
