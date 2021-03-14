package cn.my.dbutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import cn.my.jdbc.JdbcUtils;

public class QR<T> {
	private DataSource dataSource;
	public QR() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QR(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	/**
	 * 做insert delete update
	 * @param sql
	 * @param params
	 * @return
	 */
	public int update(String sql,Object... params){
		Connection conn=null;
		PreparedStatement pSt=null;
		try {
			conn=dataSource.getConnection();//通过连接池
			pSt=conn.prepareStatement(sql);//使用sql创建pstmt
			initParams(pSt,params);//设置参数
			//调用update执行增、删、改！
			return pSt.executeUpdate();//执行
			
		} catch (Exception e) {
		throw new RuntimeException(e);
		}
		finally {
				try {
					if (pSt!=null) {
					pSt.close();
					}
					if(conn!=null){
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
	}
	//给参数赋值
	private void  initParams(PreparedStatement pstmt,Object...params) throws SQLException {
		for(int i=0;i<params.length;i++){
			pstmt.setObject(i+1, params[i]);
		}
	}
	public T query(String sql,RsHandler<T> rh,Object...params){
		Connection conn=null;
		PreparedStatement pSt=null;
		ResultSet rSet=null;
		try {
			conn=dataSource.getConnection();//通过连接池
			pSt=conn.prepareStatement(sql);//使用sql创建pstmt
			initParams(pSt,params);//设置参数
			rSet= pSt.executeQuery();//执行
			//rSet得到结果集变成一个对象
			return rh.handle(rSet);//hanle把rs变成T类型
		} catch (Exception e) {
		throw new RuntimeException(e);
		}
		finally {
				try {
					if (pSt!=null) {
					pSt.close();
					}
					if(conn!=null){
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	//用来把结果集转换需要的类型
	public interface RsHandler <T>  {
		public T handle(ResultSet rSet) throws SQLException;
	}
}
