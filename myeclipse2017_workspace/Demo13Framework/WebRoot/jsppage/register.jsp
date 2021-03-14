<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'register.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<script type="text/javascript">
	function change() {
		//获取图片
		var imgmle = document.getElementById("imgverfycode1");
		/*使用时间来刷新验证码*/
		imgmle.src = "<c:url value='/VerifyServlet'></c:url>?a=" + new Date().getTime();
	}
</script>
<body>
	<!--   ${pageContext.request.contextPath}/RegisterServlet -->
	<h1>注册新用户</h1>
	<p style="color:red; font-weight:900">${msg }<p />
	<form action="<c:url value='/RegisterServlet'/>"  align="bottom" method="post">
		用户名：<input type="text" name="username"  value="${user.username }" /><p style="color:red; font-weight:300">${errorsMap.username }<p /><br /><!--*** 切记名字要和后面数据层的保持一致 -->
		 密 &nbsp;&nbsp;码： <input type="password" name="password" value="${user.password}" /><p style="color:red; font-weight:300">${errorsMap.password }<p /> <br />
		<!-- 获取验证码路径，并且使用js更换 -->
		验证码：<input type="text" name="verifycode"  value="${user.verifycode }" size="3"> 
		<img id="imgverfycode1" alt="验证码" src="<c:url value='/VerifyServlet'/>" height="23" width="60"  style="border:solid 1px #CCC;border-radius:4px;" >
		<a href="javascript:change()">看不清，换一张</a><p style="color:red; font-weight:300">${errorsMap.verifycode }<p /><br/>
		<input type="submit" value="提交"/><br/>
	</form>
</body>
</html>
