import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

public class AServlet extends HttpServlet {

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
	/**
	 * 统计访问量
	 * 1.获取/servletcontext对象
	 * 2.从ServletContext对象中获取名为count的对象
	 * 3.如果存在，访问量加1，再保存回去
	 * 4.如果不存在，说明第一次访问，想Servletcontext中保存名为count的属性，值为1
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/**
		 * 统计访问量
		 * 1.获取/servletcontext对象
		 * 2.从ServletContext对象中获取名为count的对象
		 * 3.如果存在，访问量加1，再保存回去
		 * 4.如果不存在，说明第一次访问，想Servletcontext中保存名为count的属性，值为1
		 */
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
//		ServletContext context=this.getServletContext();
//		Integer count=(Integer)context.getAttribute("count");//服务器获取数据
//		if (count==null) {
//			context.setAttribute("count", 1);
//			/**
//			 * 第一次访问
//			 */
//			
//		} else {
//			context.setAttribute("count", count+1);
//			/**
//			 * 第二次访问
//			 */
//
//		}
//		/**
//		 * 向浏览器输出访问量
//		 */
//		PrintWriter pWriter=response.getWriter();
//		pWriter.print("<h1>"+count+"</h1>");
		/**
		 * 获取类路径下资源
		 * 1.得到classLoader:先得到class，再得到classLoader
		 * 2.调用其getResourceAsStream(),得到一个Input Stream
		 */
		ClassLoader c1=this.getClass().getClassLoader();
		InputStream stream=c1.getResourceAsStream("a.txt");
		String s=IOUtils.toString(stream);//读取内容，转成字符串返回
		System.out.println(s);
	}

}
