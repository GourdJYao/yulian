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

<title>用户注册</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/normalize.css" rel="stylesheet" />
<link href="css/jquery-ui.css" rel="stylesheet" />
<link href="css/jquery.idealforms.min.css" rel="stylesheet"
	media="screen" />

</head>

<body>
	<form id="registerform" action="<%=basePath%>registeruser/registerUser"
		method="post" style="margin-top: 40%;">
		<table align="center">
			<tr>
				<td><lable>用&nbsp;户&nbsp;名</lable></td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td><lable>密&nbsp;&nbsp;&nbsp;&nbsp;码</lable></td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td><lable>确认密码</lable></td>
				<td><input type="password" name="repassword" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button" value="注册"
					onclick="return checkUser();" /><input type="reset" value="重置" /></td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
	function checkUser() {
		if ($("input[name='username']").val().trim() == '') {
			alert('用户名不能为空');
			return false;
		}
		if ($("input[name='password']").val().trim() == '') {
			alert('密码不能为空');
			return false;
		}
		if ($("input[name='repassword']").val().trim() == '') {
			alert('确认密码不能为空');
			return false;
		}
		if ($("input[name='repassword']").val()!=$("input[name='repassword']").val()) {
			alert('密码与确认密码不能一致');
			return false;
		}
		var form = document.forms[0];
  		$.post('<%=basePath%>registeruser/registerUser', {
			username : $("input[name='username']").val(),
			password :$("input[name='password']").val()
		}, function(data, status) {
			if(data=='success'){
				alert("注册成功~");
				window.location.href="<%=basePath%>manager.jsp";
			}else{
				var dataarry=data.split(";");
				alert("注册失败。"+dataarry[1]);
				return false;
			}
		});
	}
</script>
</html>
