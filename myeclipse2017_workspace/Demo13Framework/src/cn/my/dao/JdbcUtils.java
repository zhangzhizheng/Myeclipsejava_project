package cn.my.dao;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


/**
 * v1.0
 * @author Administrator
 *
 */
public class JdbcUtils {
	private static Properties pro=null;
	/**
	 * 为了代码配置多次执行，把重复执行的代码块放在一个静态块
	 */
	//只在JdbcUtils加载时执行一次
	static{
				//.getClassLoader()加载类的
				try {
					//加载配置文件dbconfing
					InputStream input=JdbcUtils.class.getClassLoader().getResourceAsStream("dbconfig.properties");
				   pro=new Properties();
					pro.load(input);//从输入字节流读取属性列表（键和元素对）。
				} catch (IOException e) {
					// TODO Auto-generated catch block
					//抛出运行异常
					throw new RuntimeException(e);
				}
				try {
					//加载驱动类
					Class.forName(pro.getProperty("driverClassName"));
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					throw new RuntimeException(e);
				}
	}
	public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		/**
		 * 1.加载配置文件
		 * 2.加载驱动类
		 * 3.调用DriverManager.getConnection()return DriverManager.getConnection(pro.getProperty("url"),
				pro.getProperty("username"),pro.getProperty("password"));
		 */
		//得到连接
		return (Connection) DriverManager.getConnection(pro.getProperty("url"),pro.getProperty("username"),pro.getProperty("password"));
	}
}
