<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312" import="java.util.*,java.text.SimpleDateFormat"%><!--  指令部分-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>first web</title>
</head>
<body>
<%!
String gettime()
{
Date date=new Date();
SimpleDateFormat dateformat=new SimpleDateFormat("yyy-MM-dd HH:MM:SS");
String day=dateformat.format(date);
return day;}
 %>
 <%
 String str=gettime();
  %>
  当前的时间是：<%=str %>

</body>
</html>