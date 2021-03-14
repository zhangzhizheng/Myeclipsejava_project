<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312" import="java.util.*,java.text.SimpleDateFormat"%><!--  指令部分-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>first web</title>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"25499",secure:"25504"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-1" data-genuitec-path="/demo2/WebRoot/NewFile.jsp">
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