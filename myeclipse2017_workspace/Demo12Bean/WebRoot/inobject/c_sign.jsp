<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'c_sign.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet"  type="text/css" href="styles.css">
	-->

  </head>
  <body>
    
    <h1>c标签库</h1>
    <%
    request.setAttribute("code", "<script> alert('hello'); <script/>") ;
    %>
    <c:out value="${code }" escapeXml="false"/>
    <br/>
   <c:url value="/AServlet"/>
   ${ pageContext.request.contextPath}/AServlet
   <br/>
   <hr/>
   <c:if test="${empty param.name} }">
   您没有给出名为name的参数
   </c:if>
   <hr/>
   <c:choose>
   <c:when test="${empty param.name }">
   您未给出名为name的参数
   </c:when>
  <c:otherwise>谁让你给的参数</c:otherwise>
   </c:choose>
   <hr/>
   <c:forEach var="i" begin="1" end="10">
   ${i }
   </c:forEach>
   <hr/>
   <% String []strs={"1","2"};
   request.setAttribute("strs", strs);
   %>
   
   <c:forEach items="${strs }" var="str"><!-- items指定要循环谁，是集合或数组 ；var把集合赋值给var指定的变量 -->
   ${str }<br/>
   </c:forEach>
   <br/>
   <%ArrayList<String> list=new ArrayList<String>();
   list.add("1");
   list.add("2");
   list.add("3");
   pageContext.setAttribute("list", list);
   %>
   <c:forEach items="${list }" var="el" varStatus="vs">
   ${vs.index } ${vs.count } ${vs.first } ${vs.last } ${vs.current }<br/>
   </c:forEach>
   <!-- coun：循环元素的个数
   index:下标
   first:是否为第一个元素
   last:是否为最后的元素
   current:当前元素
   -->
   <br/>
   <%Date date=new Date();
   request.setAttribute("date", date);
    %>
    <!-- 使用fmt标签让时间规范化 -->
    <fmt:formatDate value="${requestScope.date }" pattern="yyy-MM-dd hh:mm:ss"/>
  </body>
</html>
