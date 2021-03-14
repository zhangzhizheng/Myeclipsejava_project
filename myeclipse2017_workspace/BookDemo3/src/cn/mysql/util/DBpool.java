package cn.mysql.util;

import java.sql.DriverManager;

import java.sql.Connection;

public class DBpool {
	  private static final String driverStr = "com.mysql.jdbc.Driver";
	   private static final String connStr = "jdbc:mysql://localhost:3306/info";
	   private static final String username = "root";
	   private static final String password ="mysql123";
	   private static Connection conn;
	  static{
			try {
				Class.forName(driverStr);
				System.out.println("加载正常");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   }
	  public  static Connection getConnection(){
		  //获取用户连接实例
		  try {
 		  conn=DriverManager.getConnection(connStr,username,password);
 		  System.out.println("连接成功");
 		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("异常连接");
		}
		  return conn;
	   }
}
