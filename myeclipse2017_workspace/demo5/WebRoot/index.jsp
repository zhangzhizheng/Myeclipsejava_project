<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
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
    This is my JSP page. <br>
    <form action="" method="post">
    <table>
    <tbody>
    <tr><td><label for="login-username">账号：</label></td>
    <td><input type="text" name="username" value=""autocomplete="off" id="login-username" class="input-box"></td>
    </tr>
    <tr>
    <td><label for="login-password">密码：</label></td>
    <td><input type="password" name="password" value="" autocomplete="off" id="login-password" class="input-box"></td>
    </tr>
    <tr>
    <td>&nbsp;</td>
    <td class="autologin-container"><input type="checkbox" value="1" id="login-auto" name="autologin"class="login-auto"><label for="login-auto" class="login-auto" class="login-auto-label">一周自动登录</label><a target="_blank" href=""id="forget-password" class="login-forget-password">忘记密码？</a>
    </td>
    </tr>
    <tr>
    <td>&nbsp;</td>
    <td><input type="submit" value="立即登录" id="login-submit"><input type="button" value="注册" id="login-register">
    </td>
    </tr>
    
    
    </tbody>
    </table>
    </form>
  </body>
</html>
