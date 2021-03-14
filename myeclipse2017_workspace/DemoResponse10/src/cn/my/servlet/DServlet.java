package cn.my.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		
		/**
		 * 演示定时刷新
		 * 步骤：设置Refresh,表示定时刷新
		 *
		 */
		/**
		 * 响应体
		 */
		PrintWriter writer=response.getWriter();
		writer.print("欢迎你登录回来！");
		/**
		 * 设置名为Refresh的相应头
		 */
		response.setHeader("Refresh", "5;URL=/Demo10/EServlet");
		
	}

}
