package cn.demo2;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringJdbcTest {
	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;
	@Test
	public void demo1() {
		//自己手动注入属性，做下演示，数据本应该从其他层过来
		User user=new User();
		user.setName("zhangsan02");
		userDao.add(user);
		userDao.findConut(user);
	}
	@Test
	public void demo2() {
		User user=new User();
		System.out.println("记录数目："+userDao.findConut(user));
	}
	@Test
	public void demo3() {
		System.out.println("指定id的姓名："+userDao.findNameById(1));
	}
	@Test
	public void demo4() {
		System.out.println("指定id对应的全部信息："+userDao.findById(2));
	}
	@Test
	public void demo5() {
		List<User> list= userDao.findAll();//结果是集合
		//然后遍历集合
		for(User user:list){
			System.out.println("表中全部信息："+user);
		}
		
	}
	

}
