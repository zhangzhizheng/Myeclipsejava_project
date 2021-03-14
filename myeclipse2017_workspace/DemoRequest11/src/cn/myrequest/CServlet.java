package cn.myrequest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		/**
		 * 使用Refresh请求头，来防盗链
		 */
		String refer=request.getHeader("Referer");
		System.out.println("请求头："+refer); 
		/**
		 * 如果为空或者不包含local host定向到百度否者输出hello
		 */
		if (refer==null||!refer.contains("localhost")) {
			response.sendRedirect("http://www.baidu.com");
			
		}
		else {
			System.out.println("hello!");
		}
		
	}

}
