package cn.mybatis.first;



import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.mybatis.po.User;

public class MybatisOne {
	private SqlSessionFactory sqlSessionFactory;//放在外侧
	/*
	 * 创建会话工厂
	 */
	@Before
	public void  Init() throws IOException{
		//获取配置文件（SQlmap.xml）
		String resource="SqlMapConfig.xml";
		//加载配置文件到输入流
		InputStream inputStream=Resources.getResourceAsStream(resource);
		//创建会话
	      sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
	}
	/**
	 * 测试用id查询用户
	 */
	@Test
	public void FindUserById(){
		//通过sqlSessionFactory创建sqlSession
	     SqlSession sqlSession=sqlSessionFactory.openSession();
		//通过sqlSession操作数据库：sqlSession.selectOne(arg0, arg1);只返回一条数据
		//第一个参数：是statement的配置，等于namespace+statement的id
		//第二参数：传入的参数
		//加个异常处理
		User user=null;
		try {
			user=sqlSession.selectOne("test.findUserById", 3);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			//关闭sqlSession
			sqlSession.close();
		}
		//输出结果
		System.out.println(user);
		
	}
	/**
	 * 测试用name查询用户
	 */
	@Test
	public void FindUserByName() {
		//通过sqlSessionFactory创建sqlSession
	     SqlSession sqlSession=sqlSessionFactory.openSession();
		//通过sqlSession操作数据库：sqlSession.selectOne(arg0, arg1);
		//第一个参数：是statement的配置，等于namespace+statement的id
		//第二参数：传入的参数
		//加个异常处理
	     List<User> list=null;
		try {
			//user=sqlSession.selectOne("findUserByName", "%张%");
			list=sqlSession.selectList("test.findUserByName", "张");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			//关闭sqlSession
			sqlSession.close();
		}
		//输出结果
		System.out.println(list);
		
	}
	/**
	 * 添加用户
	 */
	@Test
	public void InsertUser(){
		//通过sqlSessionFactory创建sqlSession
	     SqlSession sqlSession=sqlSessionFactory.openSession();
		//通过sqlSession操作数据库：sqlSession.selectOne(arg0, arg1);
		//第一个参数：是statement的配置，等于namespace+statement的id
		//第二参数：传入的参数
		//加个异常处理
		User user=new User();
		user.setName("李美丽");
		user.setBirthday(new Date());
		user.setSex("女");
		user.setAddress("北京");
		try {
			sqlSession.insert("test.insertUser", user);
			//需要设定提交事务
			sqlSession.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			//关闭sqlSession
			sqlSession.close();
		}
		System.out.println("用户id："+user.getId());
	}
	/*
	 * 删除用户
	 */
	@Test
	public void DeleteUserById() {
		//通过sqlSessionFactory创建sqlSession
	     SqlSession sqlSession=sqlSessionFactory.openSession();
		//通过sqlSession操作数据库：sqlSession.selectOne(arg0, arg1);
		//第一个参数：是statement的配置，等于namespace+statement的id
		//第二参数：传入的参数
		//加个异常处理
		try {
			sqlSession.delete("test.deleteUserById", 9);
			//需要设定提交事务
			sqlSession.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			//关闭sqlSession
			sqlSession.close();
		}
	}
	/**
	 * 更新用户信息
	 */
	@Test
	public void  UpdateUser() {
		//通过sqlSessionFactory创建sqlSession
	     SqlSession sqlSession=sqlSessionFactory.openSession();
		//通过sqlSession操作数据库：sqlSession.selectOne(arg0, arg1);
		//第一个参数：是statement的配置，等于namespace+statement的id
		//第二参数：传入的参数
	     //创建更新对象
		 User user=new User();
		 user.setId(8);
	     user.setName("杨紫");
		// user.setBirthday(new Date());
		 user.setSex("女");
		 user.setAddress("北京");
			//加个异常处理
		try {
			sqlSession.update("test.updateUser", user);
			//需要设定提交事务
			sqlSession.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			//关闭sqlSession
			sqlSession.close();
		}
		
	}
}




