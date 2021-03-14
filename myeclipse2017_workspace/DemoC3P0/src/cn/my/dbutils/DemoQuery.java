package cn.my.dbutils;


import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import cn.domain.Student;
import cn.my.jdbc.JdbcUtils;

public class DemoQuery {
	/**
	 * jar包的使用
	 * 和自己写的QR的类差不多
	 * 信息插入
	 * @throws SQLException
	 */
	@Test
	public void addfun1() throws SQLException{
		QueryRunner qR=new QueryRunner(JdbcUtils.getDataSource());
		String sqlString="insert into student values(?,?,?)";
		Object[] params={23,"wanger","12341"};
		qR.update(sqlString,params);
	}
	/**
	 * 指定查找
	 * @throws SQLException
	 */
	@Test
	public void selectfun1() throws SQLException{
		//创建query Runner,需要提供数据库连接池对象
		QueryRunner qR=new QueryRunner(JdbcUtils.getDataSource());
		//sql模板
		String sqlString="select * from student where id=?";
		//通过数组给参数赋值
		Object[] params={23};
		//执行 query（）方法，需要给出结果集处理器，即ResultSetHandler的实体对象
		//这里给出的是BeanHandler她实现了ResultSetHandler。
		//他需要一个类型，然后会把rs的结果数据封装到指定类型的JavaBean对象，然后返回JavaBean。通过反射机制
		Student s3=qR.query(sqlString,new BeanHandler<Student>(Student.class),params);
		System.out.println(s3);
	}
	/**
	 * BeanListHandler是多行处理器
	 * 每行对应一个student对象
	 * @throws SQLException
	 */
	@Test
	public void selectAll() throws SQLException{
		QueryRunner qR=new QueryRunner(JdbcUtils.getDataSource());
		String sqlString="select * from student";
		List<Student> stulist=qR.query(sqlString, new BeanListHandler<Student>(Student.class));
		System.out.println(stulist);
	}
	/**
	 * MapHandler把一行转成一个map对象，是个单行处理器
	 * @throws SQLException
	 */
	@Test
	public void selectMap() throws SQLException{
		QueryRunner qR=new QueryRunner(JdbcUtils.getDataSource());
		String sqlString="select * from student where id=?";
		Object[] params={23};
		Map stumap=qR.query(sqlString,new MapHandler(),params);
		System.out.println(stumap);
	}
	/**
	 * MapListHandler是多行处理器,把每一行都转成一个Map，即List<Map>
	 * @throws SQLException
	 */
	@Test
	public void selectHashMap() throws SQLException{
		QueryRunner qR=new QueryRunner(JdbcUtils.getDataSource());
		String sqlString="select * from student ";
		List<Map<String, Object>> stulistmap=qR.query(sqlString,new MapListHandler());
		System.out.println(stulistmap);
	}
	/**
	 * scalarHandler单行单列值使用合适
	 * @throws SQLException
	 */
	@Test
	public void scalarHandler() throws SQLException{
		QueryRunner qR=new QueryRunner(JdbcUtils.getDataSource());
		String sqlString="select count(*) from student ";
		/**由于count的类型不确定
		 * 要用以下的父类Number
		 * Integer
		 * Long
		 *BigInteger
		 */
		Number cnt=(Long)qR.query(sqlString,new ScalarHandler());
		//转换到自己想要的类型
		int c=cnt.intValue();
		System.out.println(c);
	}
}
