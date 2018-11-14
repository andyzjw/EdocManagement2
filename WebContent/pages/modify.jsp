<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
<title>电子文档修改</title>
</head>
<body>
	<div class="main-modify">
		<form action="${pageContext.request.contextPath}/modify?id=${edoc.id}" method="post">
			<table>
				<caption>更新电子文档</caption>
				<tr>
					<td>文档编号</td>
					<td>${edoc.id}<input type="hidden" value="${edoc.categoryId}" name="categoryId"></td>
				</tr>
				<tr>
					<td>文档名称<span>(*)</span></td>
					<td><input name="title" size="25" value="${edoc.title}"></td>
				</tr>
				<tr>
					<td>文档摘要</td>
					<td><textarea name = "summary"cols="40" rows="5">${edoc.summary}</textarea></td>
				</tr>
				<tr>
					<td>上传人</td>
					<td><input name="uploadUser" size="25" value="${edoc.uploadUser}"></td>
				</tr>
				<tr>
					<td>上传时间<span>(*)</span></td>
					<td><input name="createDate" size="25" value="${edoc.createDate}">(yyyy-MM-dd)</td>
				</tr>
				<tr align="center">
					<td colspan="2">
					<input type=submit value="提交">
					<input type="button" value="返回" onclick="history.back()"> 
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/regular.js">
</script>
</html>