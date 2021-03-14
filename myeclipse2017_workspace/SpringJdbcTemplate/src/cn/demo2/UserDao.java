package cn.demo2;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
/**
 * 用模板实现数据库的操作
 * 注：如果使用以下代码在Dao里比较麻烦
 * private JdbcTemplate jdbcTemplate;//给予set方法并在xml文件设置
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
 *	所以可以采用继承spring核心库里JdbcDaoSupport
 * @author Administrator
 *
 */
public class UserDao extends JdbcDaoSupport {
	/**
	 * 插入数据
	 * @param user
	 */
	public void add(User user){
		String sql1="insert into user_info values(null,?)";
		this.getJdbcTemplate().update(sql1, user.getName());
	}
	/**
	 * 修改数据
	 * @param user
	 */
	public void update(User user){
		String sql2="update user_info set name=? where id=?";
		this.getJdbcTemplate().update(sql2, user.getName(),user.getId());
	}
	/**
	 * 查找数据表的记录数
	 * @param user
	 * @return
	 */
	public int findConut(User user){
		String sql3="select count(*) from user_info";
		return this.getJdbcTemplate().queryForInt(sql3);
		
	}
	/**
	 * 查找指定id的名字
	 * @param id
	 * @return
	 */
	public String findNameById(int id){
		String sql3="select name from user_info where id=?";
		//String.class是自己获取类型为String
		return this.getJdbcTemplate().queryForObject(sql3,String.class,id);
	}
	public void delete(User user){
		String sql4="delete from user_info where id=?";
		this.getJdbcTemplate().update(sql4,user.getId());
	}
	/**
	 * 通过id查找该id的所有信息
	 * @param id
	 * @return
	 */
	public User findById(int id){
		String sql5="select * from user_info where id=?";
		//rowMapper和dbutils的handler类似;需要自己手动封装，编写了类：UserRowMapper()
		//注意query时的返回类型别搞错了
		User user=(User) this.getJdbcTemplate().queryForObject(sql5, new UserRowMapper(), id);//获得结果到user对象最后再返回
		return user;
	}
	public List<User> findAll(){
		String sql6="select * from user_info";
		return (List<User>) this.getJdbcTemplate().query(sql6, new UserRowMapper());//获得结果到user对象最后再返回

	}
	/**
	 * 自定义封装类封装结果集
	 * @author Administrator
	 *
	 */
	class UserRowMapper implements RowMapper<User>{
		/**
		 * rs:结果集
		 * rowNum:行号
		 */
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user=new User();
			user.setId(rs.getInt("id"));//把结果集id数据封到user
			user.setName(rs.getString("name"));//把结果集name数据封到user
			return user;//封完后再返回对象
		}
		
	}
}
