<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
<script type="text/javascript">
function _change(){
/*
1.得到图片的元素
2.修改src为/Demo11Session/VerifyServlet

*/

var imgEle=document.getElementById("imgverify1");
/*修改新的src路径，注意要添加没回都不一样的参数，否者浏览器不想服务器发请求，因为事先有缓存,
才用时间参数，这才会让浏览器以为没有缓存参数，每次都向浏览器发请求
*/
imgEle.src="/Demo11Session/VerifyServlet?a="+new Date().getTime();

}</script>
</head>
<body>
	<h1>欢迎登录！</h1>
	<%/*读取名为userString的cookie*/
   String username="";
   Cookie[] csCookie=request.getCookies();//获取请求中所有cookie
   if(csCookie!=null){//如果存在cookie
   for(Cookie c:csCookie){//循环遍历所有的cookie
   		if("username".equals(c.getName())){//在所有cookie中寻找名为username
   		username=c.getValue();//获取这个cookie的值给username
   		}
   }
   } %>
	<font color="red"><b> <%
   String msg=(String)request.getAttribute("msg"); //获取错误信息
   if(msg!=null){
   out.print(msg);
   }
   else{%> <%
   out.print("");
   }
   %>
	</b> </font>
	<form action="/Demo11Session/AServlet" method="post">
		<%--把用户名保存到用户名文本框 --%>
		用户名:<input type="text" name="username" value="<%=username%>" /><br />
		密    码：<input type="password" name="password" /><br /> 
		验证码：<input type="text" name="verifyCode" size="3" />
             <img id="imgverify1" alt="验证码" src="/Demo11Session/VerifyServlet" border="2" /><!-- img标签的地址要项目名 -->
		<a href="javascript:_change()">看不清，换一张</a> <br /> <input type="submit"
			value="提交" />
	</form>
</body>
</html>
