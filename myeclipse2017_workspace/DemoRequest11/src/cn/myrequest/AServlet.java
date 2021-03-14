package cn.myrequest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
	/**
	 * 获取客户端的ip地址、请求方式、获取user-Agent，得到客户端的信息(操作系统,浏览器)
	 */
		String pathIp=request.getRemoteAddr();//获取ip
		String requeWay=request.getMethod();//获取请求方式
		String user=request.getHeader("User-Agent");//获取User-Agent的请求头
		System.out.println("ip地址："+pathIp);
		System.out.println("请求方式："+requeWay);
		System.out.println("获取的User-Agent:"+user);
		if (user.toLowerCase().contains("chrome")) {
			System.out.println("用户你好！你的ip是："+pathIp+"你使用的浏览器是：谷歌");
		} else if(user.toLowerCase().contains("firefox")){
			System.out.println("用户你好！你的ip是："+pathIp+"你使用的浏览器是：火狐");
		}
		else if (user.toLowerCase().contains("msie")) {
			System.out.println("用户你好！你的ip是："+pathIp+"你使用的浏览器是：ie");
			
		}
	}

}
