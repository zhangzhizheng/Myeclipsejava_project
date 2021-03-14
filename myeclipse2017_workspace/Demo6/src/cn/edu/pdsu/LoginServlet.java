package cn.edu.pdsu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public LoginServlet() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

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

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		doPost(request, response);
		
		
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		try {
			String name=request.getParameter("name");
			String password=request.getParameter("password");
			/*equalsIgnoreCase忽略大小写判断是否相等*/
			if ("admin".equalsIgnoreCase(name)&&"123".equals(password)) {
				out.print("登录成功");
				RequestDispatcher rd=request.getRequestDispatcher("info.jsp");
				rd.forward(request, response);/*转发到新的文件上*/
				
				
			}
			else{
				/**
				 *   response.sendRedirect(跳转页面URL）重定向
				 */
				out.print("密码或用户名错误");
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
//				response.sendRedirect("error.jsp");
			}
			
		} finally {
			// TODO: handle finally clause
			out.close();
			
		}
		
		
	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

}
