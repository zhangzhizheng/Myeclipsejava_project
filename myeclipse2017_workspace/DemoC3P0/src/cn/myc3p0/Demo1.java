package cn.myc3p0;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Demo1 {
	@Test
	public void fun1() throws PropertyVetoException, SQLException{
		//创建连接对象
		ComboPooledDataSource dataSource=new ComboPooledDataSource();
		//对池配置四大参数
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/info");
		dataSource.setUser("root");
		dataSource.setPassword("mysql123");
		//池配置(也可以不配置)
		dataSource.setAcquireIncrement(5);//增量
		dataSource.setInitialPoolSize(20);//初始化
		dataSource.setMaxPoolSize(50);
		dataSource.setMinPoolSize(2);
		Connection con=dataSource.getConnection();
		System.out.println("结果："+con);
		con.close();
	}
	@Test
	public void fun2() throws SQLException{
		//使用默认配置，自动加载配置文件,不用指定
		ComboPooledDataSource dataSource=new ComboPooledDataSource();
		Connection conn=dataSource.getConnection();
		System.out.println(conn);
		conn.close();
	}
	
	}
