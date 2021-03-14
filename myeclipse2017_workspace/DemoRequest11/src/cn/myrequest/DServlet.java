package cn.myrequest;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 演示request获取请求参数
 */
public class DServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

     	response.setContentType("text/html;charset=UTF-8");
		System.out.println("GET:"+request.getParameter("xxx"));
		System.out.println("GET:"+request.getParameter("yyy"));
		  
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String []hobby=request.getParameterValues("hobby");
		System.out.println("username:"+username+"\n"+"password:"+password+"\n"+"hobby:"+Arrays.toString(hobby));
		/**
		 * 测试获取所有请求参数的名称
		 */
		Enumeration names=request.getParameterNames();//Enumeration接口中定义了一些方法，通过这些方法可以枚举（一次获得一个）对象集合中的元素。
		while (names.hasMoreElements()) {
			//打印所有参数名称
			System.out.println(names.nextElement());
			
		}
		/**
		 * 获取所有请求参数
		 * 封装到Map中
		 */
		//Map 接口存储一组键值对象，提供key（键）到value（值）的映射。
		Map<String, String[]> map=request.getParameterMap();
		/**
		 * 将Map中所有的键存入到set集合中。因为set具备迭代器。所有可以迭代方式取出所有的键，再根据get方法。获取每一个键对应的值。
		 */
		//keySet():迭代后只能通过get()取key 
		for (String  name:map.keySet()) {
			String[] values=map.get(name);
			System.out.println("所有请求参数："+name+Arrays.toString(values));
			
		}
		
	}

}
