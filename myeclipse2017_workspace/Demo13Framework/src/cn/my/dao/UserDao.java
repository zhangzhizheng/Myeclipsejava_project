package cn.my.dao;

import cn.my.domain.User;

public interface UserDao {
	public User findByUsername(String username);//按用户名查找
	public void addUser(User user);//增加用户
}
