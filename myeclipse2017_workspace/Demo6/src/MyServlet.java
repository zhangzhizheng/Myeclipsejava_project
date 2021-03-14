import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public MyServlet() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		System.out.println("销毁Servlet");
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
		ServletContext context=this.getServletContext();
		System.out.println("服务器的真实路径："+context.getContext(""));//读取当前页面的绝对路径
		System.out.println("执行get请求");
		doPost(request,response);
//		Cookie cookie=new Cookie("name",request.getParameter("name"));//创建Cookie的对象
//		response.addCookie(cookie);//传送Cookie到客户端的方法
//		cookie.setMaxAge(60);//设置cookie的有效时间方法
//		cookie.setPath("/");//设置cookiepath属性
		
		
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

		System.out.println("执行post请求");
		Cookie cookie=new Cookie("name",request.getParameter("name"));//创建Cookie的对象
		response.addCookie(cookie);//传送Cookie到客户端的方法
		cookie.setMaxAge(60);//设置cookie的有效时间方法
		cookie.setPath("/");//设置cookiepath属性
	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
		System.out.println("执行初始化");
		super.init();
		
	}

}
