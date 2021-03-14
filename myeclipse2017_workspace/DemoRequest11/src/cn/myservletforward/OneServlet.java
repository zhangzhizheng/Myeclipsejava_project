package cn.myservletforward;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OneServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		/**
		 * 演示请求转发
		 * 涉及一个请求，至少两个Servlet
		 * 留有响应头，不留响应体（留头不留体）
		 */
		System.out.println("OneServlet");
     	response.setHeader("aa","AAA");//设置响应头
		response.getWriter().print("请求1");//响应体
		//等同调用TwoServlet的service（）方法
		request.getRequestDispatcher("/TwoServlet").forward(request, response);//请求转发
	}

}
