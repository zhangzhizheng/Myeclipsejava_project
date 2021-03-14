import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("hellworld")
public class AServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String aString=request.getParameter("int1");
		String bString=request.getParameter("int2");
		int a=Integer.parseInt(aString);
		int b=Integer.parseInt(bString);
		int sum=a+b;
		request.setAttribute("result", sum);
		request.getRequestDispatcher("/jsppage/result.jsp").forward(request, response);
		
	}

}
