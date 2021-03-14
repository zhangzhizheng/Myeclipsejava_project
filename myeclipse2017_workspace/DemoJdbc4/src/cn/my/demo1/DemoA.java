package cn.my.demo1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.io.IOUtils;
import org.junit.Test;


//import cn.jdbc.JdbcUtils;
/**
 * 处理大数据到数据库里
 * MP3文件的存取与读出
 * 使用Blob类
 * @author Administrator
 *
 */
public class DemoA {
	/**
	 * 保存MP3文件
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
//	@Test
//	public void  fun1() throws ClassNotFoundException, IOException, SQLException {
//		Connection con=JdbcUtils.getConnection();
//		String sql="insert into table_bin values(?,?,?)";
//		PreparedStatement pSt=con.prepareStatement(sql);
//		//设置sql的参数
//		pSt.setInt(1, 2);
//		pSt.setString(2, "认真的雪.mp3");
//		/*把文件变成字节数组
//		 * Blob对象的获取通过字节数组
//		 * 
//		 */
//		byte[] bytes=IOUtils.toByteArray(new FileInputStream("D:/认真的雪.mp3"));
//		Blob blob=new SerialBlob(bytes);
//		pSt.setBlob(3, blob);
//		pSt.executeUpdate();
//	}
	/**
	 * 提取MP3
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * 
	 */
//
//	@Test
//	public void fun2() throws ClassNotFoundException, IOException, SQLException {
//		Connection con=JdbcUtils.getConnection();
//		String sql="select * from table_bin";
//		PreparedStatement pSt=con.prepareStatement(sql);
//		//执行查询
//		ResultSet rs=pSt.executeQuery();
//		if(rs.next()){
//			/*
//			 *把Blob变成磁盘文件
//			 *通过Blob得到输入流对象
//			 *自己创建输出流对象
//			 *把输入流数据写入输入流
//			 */
//			Blob blob=rs.getBlob("DATA");
//			InputStream input=blob.getBinaryStream();
//			OutputStream output=new FileOutputStream("D:/ss.mp3");
//			//IOUtil是封装文件的操作的io流
//			IOUtils.copy(input, output);
//		}
//		
//	}
}
