<%@ page language="java" import="java.util.*"  import="cn.edu.pdsu.User" import="com.pdsu.servlet.AddServlet" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查看信息</title>
    
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
   <table align="center" cellSpacing=0 cellPadding=0 width="1000" border=1 bordercolor="00FF00">
  
   <tbody> <!-- 表格信息 -->
   <tr>
   <td height=22 align="center" colspan="4"><h2>查看人员信息</h2></td>
   </tr>
   <tr align="center" style="font-weight:blod">
   <td width="20%">姓名</td>
   <td width="20%">性别</td>
   <td width="20%">年龄</td>
   <td> 地址</td>
   </tr>
   </tr>
   <%
   	ServletContext context=getServletContext();//获取Servlet Context对象
   List<User> lt=(List<User>)context.getAttribute("users");//list集合装user
   if(lt!=null)
   {
   for(User user:lt){//获取数据
   %><tr align="center">
   <td><%=user.getName() %></td>
   <td><%=user.getSex() %></td>
   <td><%=user.getAge() %></td>
   <td><%=user.getAddress() %></td>
   </tr>
   <% 
   }
   }%>
   <tr align="center">
   <td height=22 colspan="4"><a href="info.jsp">继续添加</a></td>
   </tr>
   </tbody>
   </table>
  </body>
</html>
