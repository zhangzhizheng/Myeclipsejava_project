package cn.my.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BServlet extends HttpServlet {

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/**
		 * 响应重定向
		 * 用户请求BServlet,响应302，给出location头
		 */
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		System.out.println("BServlet");
		/**
		 * 步骤：1.设置Location
		 * 2.发送302状态码
		 */
		response.setHeader("Location", "/Demo10/CServlet");//请求url
		response.setStatus(302,"重定向");
		/**
		 * 快捷重定向
		 */
		response.sendRedirect("/Demo10/CServlet");
		request.getRemoteAddr();
	}

}
