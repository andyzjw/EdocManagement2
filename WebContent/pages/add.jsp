<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" href="../css/main.css" rel="stylesheet">
<title>电子文档增加</title>
</head>
<body>
	<div class="main-add">
		<form action="${pageContext.request.contextPath}/add" method="post">
			<table>
				<caption>增加电子文档</caption>
				<tr>
					<td>文档名称<span>(*)</span></td>
					<td><input name="title" size="25"></td>
				</tr>
				<tr>
					<td>文档摘要</td>
					<td><textarea name="summary" cols="40" rows="5"></textarea></td>
				</tr>
				<tr>
					<td>上传人</td>
					<td><input name="uploadUser" size="25"></td>
				</tr>
				<tr>
					<td>上传时间<span>(*)</span></td>
					<td><input name="createDate" size="25">(yyyy-MM-dd)</td>
				</tr>
				<input type="hidden" name="classify" value="${param.classify}">
				<tr align="center">
					<td colspan="2">
					<input type="submit" value="提交">
					<input type="button" value="返回" onclick="history.back()"> 
					</td>
				</tr>
			</table>
		</form>
	</div>
	<select>
					<c:forEach begin="5" end = "20"step="5" var = "s">
					<option value="${s }">${s }</option>
					</c:forEach>
				</select>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/regular.js">
</script>
</html>