
package cn.my.service;

import java.io.FileNotFoundException;

import cn.my.dao.DaoFactory;
import cn.my.dao.UserDao;
import cn.my.dao.UserDaoImple;
import cn.my.domain.User;
/**
 * user的业务层
 * @author Administrator
 *
 */
public class UserService {
	/**
	 * service依赖dao层
	 */
	//把具体的实现类的创建。隐藏到工厂，提供getUserDao()方法
	private UserDao userDao=DaoFactory.getUserDao();
	//service 的查询，需要使用dao来完成！
	/**
	 * 注册功能
	 * @param user
	 * @throws UserException
	 * @throws FileNotFoundException 
	 */
	public void register(User user) throws UserException, FileNotFoundException{
		/**
		 * 1.用户名查询，如果返回null,完成添加
		 * 2.如果返回的不是null，抛出异常！
		 */
		User user2=userDao.findByUsername(user.getUsername());
		if (user2!=null) {
			throw new UserException("用户名"+user.getUsername()+"已存在，请重新输入！");
		}
		else {
			userDao.addUser(user);//注意是user这个参数，是从表格里获取的数据
		}
	}
	/**
	 * 登录层
	 * @param form
	 * @return
	 * @throws UserException
	 */
	public User login(User formUser) throws UserException {
		//1. 使用formUser中的username进行查询，得到User user
		User user = userDao.findByUsername(formUser.getUsername());
		//2. 如果返回null，说明用户名不存在，抛出异常，异常信息为“用户名不存在”
		if(user == null) throw new UserException("用户名不存在！");
		//3. 比较user的password和form的password，如果不同，抛出异常，异常信息为“密码错误！”
		if(!formUser.getPassword().equals(user.getPassword())) {
			throw new UserException("密码错误！");
		}
		//返回数据库中查询出来的user，而不是form，因为form中只有用户名和密码，而user是所有用户信息！
		return user;
	}
}
