<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>登录管理系统</title>

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
	<form action="<%=basePath%>user/login" method="post">
		<table align="center">
			<tr>
				<td><label>用户名：</label></td>
				<td><input name="username" type="text"/></td>
			</tr>
			<tr>
				<td><label>密 &nbsp;&nbsp;&nbsp;码：</label></td>
				<td><input name="password" type="password" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="登录"/> <a href="<%=basePath%>userregister.jsp">新用户注册</a></td>
			</tr>
		</table>
	</form>
</body>
</html>
