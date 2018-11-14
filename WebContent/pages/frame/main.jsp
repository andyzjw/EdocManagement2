<%@ page language="java" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath}/css/frame.css"
	type="text/css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<div class="main-top">
		欢迎${user.userName}登陆
		<div>
			<span><a href="${pageContext.request.contextPath}/login"
				target="_top">退出</a></span>
		</div>
	</div>
	<div class="middle">
		<div class="main-left">
			<div>
				<p >用户信息</p>
				<p onclick="toJump('${pageContext.request.contextPath}/main')" class="mesg">电子文档管理</p>
				<p>
					<a href="${pageContext.request.contextPath}/login">退出</a>
				</p>
			</div>
		</div>
		<div class="main-right">
			欢&nbsp;&nbsp;迎&nbsp;&nbsp;使&nbsp;&nbsp;用&nbsp;&nbsp;X&nbsp;X&nbsp;X&nbsp;&nbsp;系&nbsp;&nbsp;统!
		</div>
	</div>

	<div class="main-bottom">制作人 &copy;</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" >
	function toJump(url){
		$.post(
			url,
			function(data){
		//alert(data);
				$(".main-right").html(data);
			},
			"html"
		);
	}
</script>
</html>