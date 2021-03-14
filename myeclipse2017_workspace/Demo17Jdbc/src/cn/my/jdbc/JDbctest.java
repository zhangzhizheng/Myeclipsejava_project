package cn.my.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import java.sql.Connection;
public class JDbctest {
	
	public void jdball() throws ClassNotFoundException, SQLException{
		Connection conn=null;
		Class.forName("com.mysql.jdbc.Driver");//加载驱动类
		String url="jdbc:mysql://localhost:3306/info";
		String username="root";
		String password="mysql123";
	    conn=DriverManager.getConnection(url,username,password);//用参数得到连接对象
		System.out.println("连接成功");
	}
}
