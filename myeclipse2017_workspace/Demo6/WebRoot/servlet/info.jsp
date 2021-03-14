<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'info.jsp' starting page</title>

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
	<form action="servlet/LoginServlet" method="post"
		onsubmit="return check(this);">
		<table cellSpaching=0 cellPadding=0 width="511" border=0>
			<tbody>
				<tr>
					<td width="165" rowSpan=6>
						<div align=left>
							<img border="0" alt="正在加载" src="/Demo6/13.jpg" width="127">
						</div>
					</td>
				</tr>
				<tr>
					<td height=22 width="74">姓名</td>
					<td height=22 width="266"><input type="text" name="name"></td>
				</tr>
				<tr>
					<td height=22 width="74">年龄</td>
					<td height=22 width="74"><input type="text" name="age"></td>
				</tr>
				<tr>
					<td height=22 width="74">性别</td>
					<td height=22 width="226"><input type="radio" name="sex"
						value="男" checked="checked">男 <input type="radio"
						name="sex" value="女">女</td>

				</tr>
				<tr>
					<td height=22 width="74">地址</td>
					<td height=22 width="266">
					<textarea rows="5" cols="30" name="address"></textarea>
					</td>
				</tr>
				<tr>
					<td height=22 align="center" colspan="2"><input type="submit"
						value="添加"></td>
				</tr>


			</tbody>

		</table>
	</form>
</body>
<script type="text/javascript">
		function check(form) {
			if (name.value == "") {
				alert("姓名不能为空");
				return false;
			}
			if (age.value == "") {
				alert("年龄不能为空");
				return false;
			}
			if (address.value == "") {
				alert("地址不能为空");
				return false;
			}
		}
	</script>
</html>
