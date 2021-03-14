package cn.myservlet.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

public class AServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		doPost(request, response);
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");//处理中文问题
		/**
		 * 校验验证码
		 * 1.从session中获取正确的验证码
		 * 2.从表单数据中获取填写的验证码
		 * 3.进对比
		 * 4.如果相同向下运行，否者保存错误信息到request域中，转发到login.jsp
		 * 
		 */
		String sessioncode=(String) request.getSession().getAttribute("session_vcode");//从session里获得数据
		String formcode=request.getParameter("verifyCode");//从表单里获取数据
		if(!formcode.equalsIgnoreCase(sessioncode)){//如果两者不同进行反馈
			request.setAttribute("msg", "验证码错误");
			request.getRequestDispatcher("/loginpage/login.jsp").forward(request, response);//转发到登录页面
			return;//要写return，防止后面的代码继续执行
		}
		String userString=request.getParameter("username");
		String userpassString =request.getParameter("password");
		//System.out.println(userString+userpassString);为看输入的登录名和密码
		
	if("admin".equals(userString)&&"12345".equals(userpassString)){
//		if(!"admin".equalsIgnoreCase(userString)){
			/**
			 * 使用Cookie来保存用户名,发送给客户端浏览器
			 * 当再次打开login.jsp会读取Cookie把它显示到用户名文本输入框
			 */
		Cookie cookie1=new Cookie("userString", userString);//创建cookie
		cookie1.setMaxAge(60*60*24);//设置cookie的生存时间一天
		response.addCookie(cookie1);//保存cookie
			/**
			 * 重定向必须要加项目名
			 * 请求转发可以不加项目名你
			 * 请求成功之后跳转到success1.jsp
			 */
		HttpSession session=request.getSession();//获取session
		session.setAttribute("userString", userString);//向session域中保存用户名
		response.sendRedirect("/Demo11Session/loginpage/success1.jsp");
		}else {
			//response.sendRedirect("/Demo11Session/loginpage/error.jsp");
			/**
			 * 如果错误则进行信息提示及转发到登陆页面
			 * 同时保存错误的的信息到request域中
			 */
			request.setAttribute("msg", "登录错误");
			RequestDispatcher rp=request.getRequestDispatcher("/loginpage/login.jsp");//重定向到登录页面被
			rp.forward(request, response);
			
		
		}
		
	}

}
