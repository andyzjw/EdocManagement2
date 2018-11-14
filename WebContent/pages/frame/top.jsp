<%@ page  language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath}/css/frame.css" type="text/css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<div class="main-top">
		欢迎${user.userName}登陆
	<div >
		<span><a href = "${pageContext.request.contextPath}/login" target="_top">退出</a></span>
	</div>
	</div>
</body>
</html>