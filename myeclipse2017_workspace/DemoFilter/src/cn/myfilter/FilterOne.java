package cn.myfilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterOne implements Filter {
	/**
	 * 销毁之前执行，用来做对非内存的资源进行释放
	 */
	public void destroy() {
		System.out.println("销毁了");
	}
   /**
    * 每次过滤就会执行
    */
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("拦截了");
		arg2.doFilter(arg0, arg1);//放行
		System.out.println("放行");
	}

	/**
	 * 创建之后马上执行，用来做初始化
	 */
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("过滤器");

	}

}
