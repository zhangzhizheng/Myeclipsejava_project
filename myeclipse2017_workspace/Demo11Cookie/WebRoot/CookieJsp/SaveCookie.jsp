<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'SaveCookie.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1>保存Cookie</h1>
  <%-- 九大对象request ,response,application,pageContext,config,out,page,exception--%>
  <%
  /*最终变成response头*/
  Cookie cookie1=new Cookie("aaa","AAA");
  response.addCookie(cookie1);
  cookie1.setMaxAge(60*60);//设置cookie的存活时间一小时
  /*cookie1.setMaxAge(0);//杀死cookie*/
  /*cookie1.setMaxAge(-1);活在浏览器的内存中，只要小于0*/
  Cookie cookie2=new Cookie("bbb","BBB");
  response.addCookie(cookie2);
  /*cookie的路径是当前页面所在路径*/ 
  
   %>
  </body>
</html>
