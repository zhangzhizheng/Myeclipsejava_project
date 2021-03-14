package cn.my.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.my.domain.User;
import cn.my.service.UserService;

public class UserServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		UserService userService=new UserService();

		request.getRequestDispatcher("/jsppage/show.jsp").forward(request, response);
		
	}

}
