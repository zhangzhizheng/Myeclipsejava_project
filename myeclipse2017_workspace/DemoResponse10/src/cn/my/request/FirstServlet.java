package cn.my.request;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class FirstServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

     	request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String nameString=request.getParameter("username");
		String passwordString=request.getParameter("password");
		System.out.println("message:"+nameString+passwordString);
		
	}

}
