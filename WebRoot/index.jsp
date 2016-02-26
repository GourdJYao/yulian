<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>约练首页</title>
<link rel="stylesheet" type="text/css" href="css/index.css" lang="" />
<!--[if lt IE 9]>
		<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
<script src="js/jquery-1.8.2.min.js"></script>
<script src="js/index.js">
	
</script>
</head>

<body>
	<div class="cf">
		<nav>
		<ul>
			<li id="login"><a id="login-trigger" href="#"> 登录 <span>&#x25BC;</span>
			</a>
				<div id="login-content">
					<form>
						<fieldset id="inputs">
							<input id="username" name="username" placeholder="用户名" required>
							<input id="password" type="password" name="password"
								placeholder="密码" required>
						</fieldset>
						<fieldset id="actions">
							<input type="submit" id="submit" value="登录"> <label><input
								type="checkbox" checked="checked"> 记住密码</label>
						</fieldset>
					</form>
				</div></li>
			<li id="signup"><a href="register.jsp">注&nbsp;&nbsp;册</a></li>
		</ul>
		</nav>
	</div>

	<p id="about">
		返回<a href="/simple-and-effective-dropdown-login-box">article</a> /
		Drop me a message on <a href="http://twitter.com/catalinred">Twitter</a>!
	</p>
	<!-- 
	<script>
		(function() {
			var bsa = document.createElement('script');
			bsa.async = true;
			bsa.src = 'js/tools.js';
			(document.getElementsByTagName('head')[0] || document
					.getElementsByTagName('body')[0]).appendChild(bsa);
		})();
	</script>
	BSA AdPacks code -->

</body>
</html>
