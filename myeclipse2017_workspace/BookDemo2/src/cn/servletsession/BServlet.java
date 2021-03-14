package cn.servletsession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html；charset=utf-8");
	response.getWriter().print("输出"+request.getParameter("username"));
	HttpSession mysession2=request.getSession(true);
	System.out.println("session2id:"+mysession2.getId());
	String unupS=mysession2.getAttribute("s1").toString();
	String []sss=unupS.split(",");
	response.getWriter().println("用户名:"+sss[0]+"<br/>");
	response.getWriter().println("密码:"+sss[1]+"<br/>");
	
		
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
