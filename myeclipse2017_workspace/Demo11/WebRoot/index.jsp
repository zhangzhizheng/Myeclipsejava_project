<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<!-- 向页面输出basepath -->
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
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
	This is my JSP page.
	<br>
	<!--  <a href="he.html"></a><!-- 相对当前页面的路径 -->
	<table border="1" align="center" width="60%">
		<tr>
			<td>姓名</td>
			<td>年龄</td>

		</tr>
		<%
		   for(int i=0;i<10;i++)
		   {
		   
		 %>
		<tr>
			<td>张三</td>
			<td>28</td>
		</tr>
		<%} %>
	</table>
</html>
