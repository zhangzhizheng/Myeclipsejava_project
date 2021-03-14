package cn.my.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.my.domain.User;
import cn.my.service.UserException;
import cn.my.service.UserService;

public class RegisterServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//请求编码
		response.setContentType("text/html;charset=utf-8");//响应编码
		//依赖service层
		UserService userService=new UserService();
		/**
		 * 1.封装表单数据（封装到user）
		 */
		User formUser=CommonUtils.toBean(request.getParameterMap(), User.class);
		/**
		 * 对表单数据进行校验
		 * 1.创建一个map，装载错误信息
		 * 2.校验过程中，如果失败，向map添加错误信息，其中key为表单字段
		 * 3.校验过程中，看map是否为空，不为空说明有错误信息
		 *     ->如果是空则没有错误信息，继续向下执行 
		 */
	
		Map<String, String> errorsMap=new HashMap<String, String>();
		String username=formUser.getUsername();
		if(username==null||username.trim().isEmpty()){//空格
			errorsMap.put("username", "用户名不能为空！");//注意两个username不相同，一个是表单文本框的名字
		}
		else if(username.length()<4||username.length() > 15){
			errorsMap.put("username", "用户名长度必须在4~15之间!");
		}
		String password=formUser.getPassword();
        if(password==null||password.trim().isEmpty()){//空格
        	errorsMap.put("password", "密码不能为空！");
		}
		else if(password.length()<5|| password.length() > 15){
			errorsMap.put("password", "密码长度必须在5~10之间!");
			
		}
    	String session_code=(String)request.getSession().getAttribute("session_vcode");//从session里获取验证码
		String verifycode=formUser.getVerifycode();
        if(verifycode==null||verifycode.trim().isEmpty()){//空格
        	errorsMap.put("verifycode", "验证码不能为空！");
		}
		else if(verifycode.length()!=4){
			errorsMap.put("verifycode", "验证码长度必须是4!");
			
		}
		else if (!verifycode.equalsIgnoreCase(session_code)) {
			errorsMap.put("verifycode", "验证码错误！");
		}
        //装载错误信息后，来判断map是否为空
        if(errorsMap!=null&&errorsMap.size()>0){
        	request.setAttribute("user", formUser);
        	request.setAttribute("errorsMap",errorsMap);
        	request.getRequestDispatcher("/jsppage/register.jsp").forward(request, response);
        	return;
        	
        }
		/**
		 * 对验证码进行处理
		 * 1.用户填写验证码封装到user
		 * 2.congsession获取真正验证码
		 * 3.比较两者是否相同
		 *     《1》不同的话，保存错误信息、保存表单数据，转发到注册页
		 *      《2》相同的话，继续向下执行 
		 */
		
		
//		if(!session_code.equalsIgnoreCase(formUser.getVerifycode())){
//			request.setAttribute("msg","验证码错误");//返回错误信息
//			request.setAttribute("user", formUser);//保存表单数据
//			request.getRequestDispatcher("/jsppage/register.jsp").forward(request, response);//转发到注册页面
//			return;//下面代码不在继续执行
//		}
		/**
		 * 2.调用userService的register()方法,传form过去
		 *3. 得到异常，获取异常信息，保存到request,转发到regist.jsp页面
		 *4.没有异常，输出注册成功
		 */
		  try {
			userService.register(formUser);
			response.getWriter().print("<h1>注册成功！<h1><a href='"+request.getContextPath()+"/jsppage/login.jsp"+"'>点击这里去登录<a/>");
		} catch (UserException e) {
			// TODO Auto-generated catch block
			//获取异常信息，保存到request域中
		request.setAttribute(""
				+ "",e.getMessage());
		//转发到注册页面register
		request.getRequestDispatcher("/jsppage/register.jsp").forward(request, response);
		
		
		}
	}

}
