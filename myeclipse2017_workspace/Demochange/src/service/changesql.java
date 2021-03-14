package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.jdbc.JdbcUtils;
import domain.Province;

public class changesql {
	public void getProvince() throws ClassNotFoundException, IOException, SQLException{
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<Province> pList=new ArrayList<Province>();
		conn=JdbcUtils.getConnection();
		String sql1="select name from t_province";
		pst=conn.prepareStatement(sql1);
		rs=pst.executeQuery();
		while(rs.next()){
			Province province=new Province();
			province.setName(rs.getString(rs.getString("name")));
			pList.add(province);
		}
		
		
	}
	public List<Province> getCity(int pid) throws ClassNotFoundException, IOException, SQLException{
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<Province> pList=new ArrayList<Province>();
		conn=JdbcUtils.getConnection();
		
		String sql1="select t_city.name from t_province left join t_city on t_province.pid=t_city.pid and t_province.pid=?";
		pst.setInt(1,pid);
		pst=conn.prepareStatement(sql1);
		rs=pst.executeQuery();
		while(rs.next()){
			Province province=new Province();
			province.setName(rs.getString(rs.getString("t_city.name")));
			pList.add(province);
		}
		return pList;
	}
}
