package cn.jdbctest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import cn.jdbc.JdbcUtils;



public class JdbcThree {
	@Test
	public void fun22() throws ClassNotFoundException, IOException, SQLException{
		Connection conn=JdbcUtils.getConnection();
		System.out.println(conn);
		Connection conn2=JdbcUtils.getConnection();
		System.out.println(conn2);
	}
}
