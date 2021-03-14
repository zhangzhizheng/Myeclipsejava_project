<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.javabean.domain.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ELtest.jsp' starting page</title>
    
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
  <%
  Address address=new Address();
  address.setProvince("河南省");
  address.setCity("郑州");
  address.setStreet("二七区");
  Employee employee=new Employee();
  employee.setName("张三丰");
  employee.setSalary(15000);
  employee.setAddress(address);
  request.setAttribute("employee",employee );
  
  
   %>
  <h1>使用EL获取request</h1>
  ${requestScope.employee} <br/>
  ${requestScope.employee.name}<br/>
  ${requestScope.employee.salary }<br/>
  ${requestScope.employee.address}<br/>
  ${requestScope.employee.address.street}<br/>
  </body>
</html>
