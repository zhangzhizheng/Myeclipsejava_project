package dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import utils.JdbcUtils;
import dao.BookDao;
import domain.Book;
/**
 * 接口的实现
 * @author Administrator
 *
 */
public class BookDaoImpl implements BookDao {
	public void add(Book book){
		try {
			/**
			 * 引用工具类queryRunner类(org.apache.commons.dbutils.QueryRunner) 显著的简化了SQL查询，
			 * 并与ResultSetHandler协同工作将使编码量大为减少。
			 * 使用commons-dbutils的jar用来操作数据库（增删改查）的工具包
			 * commons-dbcp和
			 */
			  //通过DataSource对象实例化QueryRunner对象,其update()和query()方法不再需要Connection连接对象
			//JDBCUtils.java（连接池工具类,用于获取DataSource实现类对象
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into book(id,name,author,price,image,description,category_id) values(?,?,?,?,?,?,?)";
			Object params[] = {book.getId(), book.getName(), book.getAuthor(), book.getPrice(), book.getImage(), book.getDescription(), book.getCategory_id()};
			//数据表更新
			runner.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 指定查找书
	 */
	public Book find(String id){
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from book where id=?";
			/**
			 * 把结果集转为一个 Bean,并返回
			 * Bean的类型在创建BeanHandler 对象时以 Class 对象的方式传入 BeanHandler(Class<T> type)。
			 */
			return (Book)runner.query(sql, id, new BeanHandler(Book.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Book> getPageData(int startindex, int pagesize){
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from book limit ?,?";
			Object params[] = {startindex, pagesize};
			/**
			 * 把结果集转为一个 Bean 的 List, 并返回.。
			 * Bean的类型在创建 BeanListHanlder对象时以 Class对象的方式传入，可以适应列的别名来映射 JavaBean 的属性 名
			 */
			return (List<Book>)runner.query(sql, params, new BeanListHandler(Book.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 获取记录
	 */
	public int getTotalRecord(){
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select count(*) from book";
			/**ScalarHandler: 可以返回指定列的一个值或返回一个统计函数的值，比如count(1)。
			 */
			/**由于count的类型不确定
			 * 要用以下的父类Number
			 * Integer
			 * Long
			 *BigInteger
			 */
			Number totalrecord = (Long)runner.query(sql, new ScalarHandler());
			int count=totalrecord.intValue();
			return count;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * BeanListHandler是多行处理器
	 * 每行对应一个book对象
	 */
	public List<Book> getPageData(int startindex, int pagesize, String category_id){
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from book where category_id=? limit ?,?";
			Object params[] = {category_id, startindex, pagesize};
			return (List<Book>)runner.query(sql, params, new BeanListHandler(Book.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public int getTotalRecord(String category_id){
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select count(*) from book where category_id=?";
			Number totalrecord = (Long)runner.query(sql, category_id,new ScalarHandler());
			int count=totalrecord.intValue();
			return count;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
