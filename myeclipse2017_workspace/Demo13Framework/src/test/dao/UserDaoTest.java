package test.dao;

import java.io.FileNotFoundException;

import org.junit.Test;

import cn.my.dao.UserDaoImple;
import cn.my.domain.User;

/**
 * UserDao测试类
 * @author Administrator
 *
 */
public class UserDaoTest {
	@Test
	public void testFinByUsername(){
		UserDaoImple userDao=new UserDaoImple();
		User user=userDao.findByUsername("1user123");
		System.out.println(user);
		
	}
	@Test
	public void testAddUser(){
		UserDaoImple userDao=new UserDaoImple();
		User user=new User();
		user.setUsername("741");
		user.setPassword("dfdfdf");
		userDao.addUser(user);
	}
}
