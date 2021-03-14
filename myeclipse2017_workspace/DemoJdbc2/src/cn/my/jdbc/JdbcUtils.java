package cn.my.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * c3p0的连接工具v1.0
 * @author Administrator
 *
 */
public class JdbcUtils {
	//使用默认配置
	private static ComboPooledDataSource dataSource=new ComboPooledDataSource();
	/**
	 * 使用连接池返回一个连接对象
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	/**
	 * 返回连接对象
	 * @return
	 */
	public static DataSource getDataSource() {
		return dataSource;
		
	}
}
