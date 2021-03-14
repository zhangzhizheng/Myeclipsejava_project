package dao;

import domain.User;
/**
 * 用户接口
 * @author Administrator
 *
 */
public interface UserDao {

	void add(User user);

	User find(String id);

	User find(String username, String password);

}