package cn.myjdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.management.RuntimeErrorException;

import org.junit.Test;

import javassist.compiler.ast.Stmnt;

import static org.hamcrest.CoreMatchers.nullValue;

import java.sql.Connection;

public class JdbcOne {
	@Test
	public void  JdbcConn() throws Exception  {
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/info";
		String username="root";
		String password="mysql123";
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		PreparedStatement pSt=null;
		String sname="张三";
		try {
			Class.forName(driver);
			  conn=DriverManager.getConnection(url, username, password);
			  
			 String sql="select * from student where sname=?";
			 pSt=conn.prepareStatement(sql);
			 pSt.setObject(1, "张三");
			//  pSt.setString(1,sname);//给？赋值
			  rs=pSt.executeQuery();//无参
			  System.out.println("wo；"+rs.toString());
			while(rs.next()){ 
				//getString()和getObject()是通用的
				//System.out.println("结果:"+rs.getObject("id")+rs.getString("sname")+rs.getString("sno"));
				//System.out.println(rs.getRow());
				System.out.println("结果");
			}
//		    rs= st.executeQuery(sql);
//		    System.out.println(rs.getRow());
//		while(rs.next()){
//			//getString()和getObject()是通用的
//			System.out.println("结果:"+rs.getObject("id")+rs.getString("sname")+rs.getString("sno"));
//			System.out.println(rs.getRow());
//		}
//		int count=rs.getMetaData().getColumnCount();
//		System.out.println(count);
//		while(rs.next()){
//			for(int i=1;i<=count;i++){
//				System.out.print(rs.getObject(i));
//				if(i<count){
//					System.out.print(",");
//				}
//			
//			}
//			System.out.println("");
//		}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		finally {
			//关闭是倒着关的
			//判断为空是为了代码的健壮性
			
			if(rs!=null){
				rs.close();
				
			}
			if(st!=null){
				st.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
	   
	    
	}
	

}
