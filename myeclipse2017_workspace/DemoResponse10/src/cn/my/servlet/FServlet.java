package cn.my.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

public class FServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		
		/**
		 * 禁用浏览器缓存通过Cache-Control、pragma、expires
		 *  
		 */
//		response.setHeader("Cache-Control","no-cache");
//		response.setHeader("pragma", "no-cache");
//	    response.setDateHeader("expires", -1);
		/**
		 * String a="hello";
		byte [] by=a.getBytes();
		response.getOutputStream().write(by);
		 */
		/**
		 * 演示响应字节数据
		 */
		String pathString="C:/Users/Administrator/Desktop/15.jpg";
		FileInputStream in=new FileInputStream(pathString);
		byte [] by=IOUtils.toByteArray(in);//读取输入流的字节到字节数组中
		response.getOutputStream().write(by);
		
		
	}

}
