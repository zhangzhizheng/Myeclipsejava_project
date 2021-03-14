package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.mybatis.mapper.UserMapper;
import cn.mybatis.po.User;
import cn.mybatis.po.UserCustom;
import cn.mybatis.po.UserQueryVo;

public class UserMapperDaoImplTest {
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
	//通过id查询信息
	@Test
	public void testFindUserById() throws Exception{
		SqlSession sqlSession=sqlSessionFactory.openSession();
		//创建代理对象
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		User user=userMapper.findUserById(1);
		System.out.println(user.toString());
	}
	//插入信息
	@Test
	public void TestinsertUser() throws Exception{
		SqlSession sqlSession=sqlSessionFactory.openSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		//插入对象
		User user=new User();
		user.setName("李美丽23");
		userMapper.insertUser(user);
		sqlSession.commit();
		sqlSession.close();
		
	}
	//通过包装类型查询用户信息
		@Test
		public void findUserList() throws Exception{
			SqlSession sqlSession=sqlSessionFactory.openSession();
			//创建代理对象
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			//构造查询条件
			UserQueryVo userQueryVo=new UserQueryVo();
			UserCustom userCustom=new UserCustom();
			userCustom.setName("李美丽");
			userQueryVo.setUserCustom(userCustom);
		    List<User> list=userMapper.findUserList(userQueryVo);
			sqlSession.close();
		    
		    System.out.println(list);
		}
	
}
