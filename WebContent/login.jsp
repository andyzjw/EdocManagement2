<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录页面</title>
<style type="text/css">
* {
	padding: 0;
	margin: 0;
}
fieldset {
	width: 600px;
	margin: 5px auto;
	border:solid;
	font-size:20px;
}
.login form input{
	font-size:20px;
	width:200px;
	margin:15px;
	height:30px;
}

.login form{
width:500px;
	margin:auto;
}
.msg{
	color:red;
}
</style>
</head>
<body>
	<fieldset>
		<legend>登录页</legend>
	<div class="login">
		<form action="login1" method="post">
			<table align="center">
				<tr>
					<td align="right">用户名:</td>
					<td><input name="userName" value="${userName}" placeholder="请输入用户名"></td>
				</tr>
				<tr>
					<td align="right">密码:</td>
					<td><input type="password"  value="${pwd}" name="pwd" placeholder="请输入密码"></td>
				</tr>
				<tr align="center">
					<td colspan="2"><input type="submit" value="登陆"></td>
				</tr>
		</form>
	</div>
	</fieldset>
	<div class="msg">${loginMsg}</div> 
</body>
<script type="text/javascript" src=""></script>
<script type="text/javascript">

</script>
</html>