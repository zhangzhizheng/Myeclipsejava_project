package cn.myservletinclude;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 请求包含
		 * 涉及一个请求，至少两个Servlet
		 * 留有响应头和响应体（都留）
		 */
		response.setContentType("text/html;charset=utf-8");
		System.out.println("FirstServlet");
	    response.setHeader("aa","AAA");//设置响应头
		response.getWriter().print("请求-1");//响应体

		request.getRequestDispatcher("/SecondServlet").include(request, response);//请求转发
	}

}
