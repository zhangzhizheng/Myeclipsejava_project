package cn.my.dbutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import cn.domain.Student;
import cn.my.jdbc.JdbcUtils;
/**
 * 简化jdbc代码
 * @author Administrator
 *
 */
public class DemoDbutils {
	@Test
	public void addStufun(Student stu) throws SQLException{
		Connection conn=null;
		PreparedStatement pSt=null;
		try {
			conn=JdbcUtils.getConnection();
			String sql="insert into student values(?,?,?)";
			pSt=conn.prepareStatement(sql);
			pSt.setInt(1,stu.getId());
			pSt.setString(2, stu.getSname());
			pSt.setString(3, stu.getSno());
			pSt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
		throw new RuntimeException(e);
		}
		finally {
			if (pSt!=null) {
				pSt.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
		
	}
	@Test
	public void deleteStufun(int id) throws SQLException{
		Connection conn=null;
		PreparedStatement pSt=null;
		try {
			conn=JdbcUtils.getConnection();
			String sql="delete from student where id=?";
			pSt=conn.prepareStatement(sql);
			pSt.setInt(1,id);
			pSt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
		throw new RuntimeException(e);
		}
		finally {
			if (pSt!=null) {
				pSt.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
		
	}
	@Test
	public void udateStufun(Student stu) throws SQLException{
		Connection conn=null;
		PreparedStatement pSt=null;
		try {
			conn=JdbcUtils.getConnection();
			String sql="update student set sname=?,sno=? where id=?";
			pSt=conn.prepareStatement(sql);
			pSt.setInt(3,stu.getId());
			pSt.setString(1, stu.getSname());
			pSt.setString(2, stu.getSno());
			pSt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
		throw new RuntimeException(e);
		}
		finally {
			if (pSt!=null) {
				pSt.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
		
	}
	@Test
	public Student selectStufun(int id) throws SQLException{
		Connection conn=null;
		PreparedStatement pSt=null;
		ResultSet rS=null;
		try {
			conn=JdbcUtils.getConnection();
			String sql="select * from student where id=?";
			pSt=conn.prepareStatement(sql);
			pSt.setInt(1,id);
		
			rS=pSt.executeQuery();
			/**
			 * 把rs转换student映射
			 */
			if(rS.next()){
				return null;
			}
			Student stu=new Student();
			stu.setId(rS.getInt("id"));
			stu.setSname(rS.getString("sname"));
			stu.setSno(rS.getString("sno"));
			return stu;
		} catch (Exception e) {
			// TODO Auto-generated catch block
		throw new RuntimeException(e);
		}
		finally {
			if(rS!=null){
				rS.close();
			}
			if (pSt!=null) {
				pSt.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
		
	}

}
