<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'success1.jsp' starting page</title>
    
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
    <h1>登录1</h1>
    <% String username=(String) session.getAttribute("userString");
    if(username==null){
    /*向request域中保存错误信息，转发到登陆页面login.jsp*/
    request.setAttribute("msg", "您还没有登录");
    request.getRequestDispatcher("/loginpage/login.jsp").forward(request, response);
    return;/*不执行后面代码，你需要跳出它,可以直接用return而不能加任何量在后面了*/
    }%>
    热烈欢迎<font><b><%out.print(session.getAttribute("userString")); %></b></font>
    感谢您的一路相伴
    
  </body>
</html>
