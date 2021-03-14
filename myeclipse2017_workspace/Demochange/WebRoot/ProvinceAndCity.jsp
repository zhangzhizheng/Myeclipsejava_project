<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>省市联动</title>

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
	function createXMLHttpRequest() {
		try {
			return new XMLHttpRequest();
		} catch (e) {
			try {
				return ActiveXObject("Msxm12.XMLHTTP"); //IE6.0
			} catch (e) {
				try {
					return ActiveXObject("Microsoft.XMLHTTP"); //IE5.5以下版本
				} catch (e) {
					alert("请问你用的是什么浏览器？");
					throw e;
				}
			}
		}
	}
	;
	window.onload=function(){
	var selectprovince=document.getElementById("province").value;
	
	}
var provincevalue =document.getElementById("province").value;
//var index=province.selectIndex;//获取选中的索引
</script>
<body>
	<h1>省市联动</h1>
	 <select id="province">
	<option>---请选择省份</option>
  </select>
       
    <select id="city">
  <option>---请选择城市</option>
  </select>
  </body>
</html>
