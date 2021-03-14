 package cn.my.dao;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.my.domain.User;

public class JdbcUserDaoImple implements UserDao{

	@Override
	public User findByUsername(String username) {
		Connection con=null;
		PreparedStatement pSt=null;
		ResultSet rS=null;
		try {
			/// 得到连接
			con=JdbcUtils.getConnection();
			//准备sql模板，得到pSt
			String sql="select * from user where username=?";
			pSt=con.prepareStatement(sql);
			pSt.setString(1, username);
			//执行sql
		   rS=pSt.executeQuery();
		   //rs转换成User类型，返回
		   if(rS==null){
			   return null;
		   }
		   if(rS.next()){
			   //转换为User对象，并返回
			   //ORM--->对象关系映射！把表的东西放到对象里。后期借助工具hibernate
			   User user=new User();
			   user.setUsername(rS.getString("username"));
			   user.setPassword(rS.getString("password"));
			   user.setVerifycode(rS.getString("verifycode"));
			   return user;
		   }
		   
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
		finally {
			
				try {
					if(con!=null){
						con.close();
					}
					if(pSt!=null){
					con.close();
					pSt.close(); 
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		return null;
	}

	@Override
	public void addUser(User user)  {
		Connection con=null;
		PreparedStatement pSt=null;
		try {
			/// 得到连接
			con=JdbcUtils.getConnection();
			//准备sql模板，得到pSt
			String sql="insert into user values(?,?,?)";
			pSt=con.prepareStatement(sql);
			pSt.setString(1, user.getUsername());
			pSt.setString(2, user.getPassword());
			pSt.setString(3, user.getVerifycode());
			//执行sql
		   pSt.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
		finally {
			
				try {
					if(con!=null){
						con.close();
					}
					if(pSt!=null){
					con.close();
					pSt.close(); 
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
	}

}

























































































