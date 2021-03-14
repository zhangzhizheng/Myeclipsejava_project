package dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import utils.JdbcUtils;
import dao.UserDao;
import domain.User;
/**
 * 用户的注册与登录
 * @author Administrator
 *
 */
public class UserDaoImpl implements UserDao {
	public void add(User user){
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into user(id,username,password,phone,cellphone,address,email) values(?,?,?,?,?,?,?)";
			Object params[] = {user.getId(), user.getUsername(), user.getPassword(), user.getPhone(), user.getCellphone(), user.getAddress(), user.getEmail()};
			runner.update(sql, params);
		} catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	public User find(String id){
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from user where id=?";
			//然后会把rs的结果数据封装到指定类型的JavaBean对象，然后返回JavaBean。通过反射机制
			return (User)runner.query(sql, id, new BeanHandler(User.class));
		} catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	public User find(String username, String password){
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from user where username=? and password=?";
			Object params[] = {username, password};
			return (User)runner.query(sql, params, new BeanHandler(User.class));
		} catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}
