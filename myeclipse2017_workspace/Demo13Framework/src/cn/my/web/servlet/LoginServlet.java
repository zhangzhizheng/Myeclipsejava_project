package cn.my.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.my.service.UserException;
import cn.my.service.UserService;
import cn.itcast.commons.CommonUtils;
import cn.my.domain.User;
/**
 * userservlet层
 * @author Administrator
 *
 */
public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");//请求编码
		response.setContentType("text/html;charset=utf-8");//响应编码
		//依赖service层
		UserService userService=new UserService();
		/**
		 * 1.封装表单数据到form
		 * 2.调用service的login()方法，得到User user对象。
		 * 如果抛出异常，获取异常信息 ，保存到request域，在保存form 转发到login.jsp
		 * 如果没有异常，保存并返回到session中，重定向到成功页面
		 */
		User formUser= CommonUtils.toBean(request.getParameterMap(),User.class );//把信息封装到request域中
		User user;
		try {
			user = userService.login(formUser);
			request.getSession().setAttribute("user_session",user);//从用session保存用户信息
			response.sendRedirect(request.getContextPath()+"/jsppage/show.jsp");//重定向到登录成功页面
		} catch (UserException e) {
			request.setAttribute("msg", e.getMessage());//存放异常信息
			request.setAttribute("user", formUser);
			request.getRequestDispatcher("/jsppage/login.jsp").forward(request, response);
			
		}
		
		
	}

}
