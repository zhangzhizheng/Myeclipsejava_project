package cn.my.demo1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

//import cn.jdbc.JdbcUtils;
/**
 * JDBC事务处理的模板
 * @author Administrator
 * 有待优化
 */
public class DemoB {
	/**
	 * 
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
//	 public void fun2() throws ClassNotFoundException, IOException, SQLException{
//		//对事务的操作必须使用Connection对象
//		 Connection conn=JdbcUtils.getConnection();
//		 try {
//			 //开启事务
//			 conn.setAutoCommit(false);
//			 /*执行的数据库操作
//			  * .
//			  * .
//			  * .
//			  */
//			 //提交事务
//			 conn.commit();
//			 /**
//			  * .
//			  * .
//			  * .
//			  */
//			 conn.close();
//		} catch (Exception e) {
//			//事务回滚
//			 conn.rollback();
//		}
//				
//	 }
}
