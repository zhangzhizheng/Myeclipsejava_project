package cn.my.dbutils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import cn.domain.Student;
import cn.my.dbutils.QR.RsHandler;
import cn.my.jdbc.JdbcUtils;

public class DemoTest {
	/**
	 * 测试增加
	 */
	@Test
	public void fun1(){
		Student s1=new Student(22,"lisi","7410");
		addStudent(s1);
	}
	@Test
	public void fun2(){
		Student s2=selectStudent(22);
		System.out.println(s2);
	}
	public void addStudent(Student student){
		QR qr=new QR(JdbcUtils.getDataSource());//创建对象时给出连接池
		String sqlString="insert into student values(?,?,?)";//给出sql模板
		//给出参数
		Object[] params={student.getId(),student.getSname(),student.getSno()};
		//调用update执行
		qr.update(sqlString, params);
	}
	public Student selectStudent(int id) {
		QR qr=new QR(JdbcUtils.getDataSource());
		String sql2="select * from student where id=?";
		Object[] params={id};
		//内部类,把rSet变成Student
		RsHandler<Student> rh=new RsHandler<Student>() {
			//处理SQL异常
			public Student handle(ResultSet rSet) throws SQLException {
				if(!rSet.next()){
					return null;
				}
				Student student2=new Student(); 
				student2.setId(rSet.getInt("id"));
				student2.setSname(rSet.getString("sname"));
				student2.setSno(rSet.getString("sno"));
				return student2;
			}
		};
		return (Student)qr.query(sql2, rh, params);
	}
}
