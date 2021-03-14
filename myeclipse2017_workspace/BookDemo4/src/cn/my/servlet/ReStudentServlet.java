package cn.my.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;

import cn.my.dao.Student;

public class ReStudentServlet extends HttpServlet {
	@Test
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		/**
		 *   获取变量
		 */																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																														
		String sname1="lisi";
		int sage1=20;
		long sno1=161210244;
		Student s1=new Student(sname1,sage1,sno1);
		HttpSession session=request.getSession();//创建session对象
		session.setAttribute("stu1", s1);
		//response.sendRedirect("/BookDemo4/jsppage/result.jsp");
		request.getRequestDispatcher("/jsppage/result.jsp").forward(request, response);
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
