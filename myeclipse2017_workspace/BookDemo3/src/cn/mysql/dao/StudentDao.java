package cn.mysql.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import cn.mysql.javabean.Student;
import cn.mysql.util.DBpool;

public class StudentDao {
	private static DBpool dBpool;
	private static Statement state ;
	private static PreparedStatement pstmt;//带参数的写法
	/**
	 * 返回所有的学生
	 * @return
	 */
	public ArrayList<Student> getAllstudent(){
		ArrayList<Student> slist=new ArrayList<Student>();
		//从数据库中读出数据，写入slist
		try {
			state=dBpool.getConnection().createStatement();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("statement出错");
		}
		try {
			ResultSet resultSet=state.executeQuery("select * from student");
			while (resultSet.next()) {//把每个数据读出来
				Student stu=new Student();
				stu.setId(resultSet.getInt(1));
				stu.setSname(resultSet.getString(2));
				stu.setSno(resultSet.getString(3));
				slist.add(stu);
			}
			resultSet.close();
			dBpool.getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据返回异常");
		}
		
		return slist;
	}
	public ArrayList<Student> ByName(String sname){
		ArrayList<Student> slist2=new ArrayList<Student>();
		try {
			pstmt=dBpool.getConnection().prepareStatement("select * from student where sname=?");//参数用问号表示
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pstmt.setString(1,sname);
			ResultSet resultSet2=pstmt.executeQuery();//不用再写
			while(resultSet2.next()){
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return slist2;
		
	}
	
}
