package cn.mybatis.mapper;

import java.util.List;

import cn.mybatis.po.User;
import cn.mybatis.po.UserQueryVo;

/**
 * 用户的mapper
 * 
 * @author Administrator
 *
 */
public interface UserMapper {
	//根据id查询用户信息
	public User findUserById(int id) throws Exception;
	//根据用户名模糊查询 
	public List<User> findUserByName(String name) throws Exception;
	//自定义查询条件
	public List<User> findUserList(UserQueryVo userQueryVo) throws Exception;
    //查询用户，返回记录个数
	public int findUserCount(UserQueryVo userQueryVo) throws Exception;
	
	//插入用户
	public void insertUser(User user)throws Exception;
	//删除用户
	public void deleteUser(int id) throws Exception;
	//修改用户
	public void updateUser(User user) throws Exception;
}
