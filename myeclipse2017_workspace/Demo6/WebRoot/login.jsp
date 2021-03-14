<%@ page language="java" import="java.util.*" import="java.lang.*"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'login.jsp' starting page</title>

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
	<form action="servlet/LoginServlet" method="post">
		用户名<input type="text" name="name" style="width:110px" /> <br> 密
		&nbsp;&nbsp;&nbsp;码:<input type="text" name="password"
			style="width:110px" /> <br> <br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="commit"
			value="登录" style="color:#666" />
	</form>
	<h2>在线人员</h2>
	<!-- /*使用iterator迭代，遍历数据*/ /*循环遍历*/-->
	<%
		ArrayList<String> users = (ArrayList<String>) application.getAttribute("users");
		Iterator iter = users.iterator();
		while (iter.hasNext()) {
	%>
	<li><%=iter.next()%></li>
	<%
		}
	%>
	<p>
		当前在线人数：<%=users.size()%></p>

</body>
</html>
