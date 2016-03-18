<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<div align="center" width="100%" height="100%" style="padding-top: 20% ">
<form>
	<table>
		<tr><td><lable>旧&nbsp;密&nbsp;码</lable></td><td><input type="password" name="oldpassword"/></td></tr>
		<tr><td><lable>新&nbsp;密&nbsp;码</lable></td><td><input type="password" name="newpassword"/></td></tr>
		<tr><td><lable>确认密码</lable></td><td><input type="password" name="newrepassword"/></td></tr>
		<tr><td colspan="2" align="center"><input type="button" id="suerbutton" value="修改" onclick="updatepassowrd();"/><input type="reset" value="重置"/></td></tr>
	</table>
</form>
</div>
<script type="text/javascript">
	function updatepassowrd(){
		if($("input[name='oldpassword']").val().trim().length == 0)
		{
			alert('旧密码不能为空');
			return;
		}
		if($("input[name='newpassword']").val().trim().length == 0)
		{
			alert('新密码不能为空');
			return;
		}
		if($("input[name='newrepassword']").val().trim().length == 0)
		{
			alert('确认密码不能为空');
			return;
		}
		if($("input[name='oldpassword']").val().trim()==$("input[name='newpassword']").val().trim()){
			alert('新密码不能与旧密码一样~');
			return;
		}
		var form = document.forms[0];
		$("table").before("<div id='loading' class='loading'></div>");
  		$.post('<%=basePath%>user/updatepassword', {
			username :'${user.username}',
			oldpassword :$("input[name='oldpassword']").val(),
			newpassword:$("input[name='newpassword']").val()
		}, function(data, status) {
			$("body").find("loading").detach();
			if(data=='success'){
				alert("修改成功~");
				location.href='<%=basePath%>';
				return false;
			}else{
				var dataarry=data.split(";");
				alert("修改失败。"+dataarry[1]);
				return false;
			}
		});
	}
</script>
