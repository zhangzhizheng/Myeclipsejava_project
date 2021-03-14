import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginServlet extends HttpServlet {
	private	ArrayList<String> users=null;
	private ServletContext context=null;
	
	/**
		 * Constructor of the object.
		 */
	public loginServlet() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		
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
		//项目创建第一次创建，该项目只创建一次，唯一的
		context=this.getServletContext();
		boolean flag=false;
		String url=".../login.jsp";
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		users=(ArrayList<String>) context.getAttribute("users");
		if(users.isEmpty()){
			users=new ArrayList<String>();
			users.add(name);
			context.setAttribute("users", users);//第一个用户的名字保存ServletContext对象中
			
		}else{
			for (String user:users) {
				if (name.equals(user)) {
					url="../error.jsp";
					flag=true;
					break;
					
					
				}
				
			}
			if (!flag) {
				//如果该用户已经登陆，请求error.jsp让不在登录
				users.add(name);
				
				
			}
		}
		response.sendRedirect(url);
		
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
