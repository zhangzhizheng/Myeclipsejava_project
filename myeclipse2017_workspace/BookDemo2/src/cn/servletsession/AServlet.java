package cn.servletsession;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class AServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String un=request.getParameter("username");
		String up=request.getParameter("password");
		response.setContentType("text/html;charset=utf-8");
		HttpSession mysession1=request.getSession();
		mysession1.setAttribute("un", un+","+up);
		System.out.println("session1:"+mysession1.getId());
		response.sendRedirect("/BookDemo2/BServlet");
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String un=request.getParameter("username");
		String up=request.getParameter("password");
		response.setContentType("text/html;charset=utf-8");
		HttpSession mysession1=request.getSession();
		mysession1.setAttribute("un", un+","+up);
		System.out.println("session1:"+mysession1.getId());
		response.sendRedirect("/BookDemo2/BServlet");
	}
	

}
