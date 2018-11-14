<%@page import="java.util.List"%>
<%@page import="com.enetity.Entry"%>
<%@page import="com.services.impl.EntryDataServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" href="css/main.css" rel="stylesheet">
<title>电子文档列表</title>
</head>
<body>
	<div class="main">
		 <!-- 查询跳转等功能 -->
		<div class="supnav">
		<form action="${pageContext.request.contextPath}/main?pageSize=${p.pageSize}&currPage=${p.currPage }">
			查询条件：<input name="key" placeholder="请输入关键字" value="${key}">
			文档分类：<select name="select">
				<!-- 分类文档编号 -->
				<option value="">全部</option>
				<c:forEach var="c" items="${category}" varStatus="i">
					<option value="${c.id}"<c:if test="${c.id==categoryId}">selected</c:if>>${c.name}${c.id}</option>
				</c:forEach>
			</select> 
			<input type="submit" value="查询"> 
			<input type="button" value="新增电子文档" onclick="toAdd()"> 
		</form>
		</div>
		<!-- 跳页 -->
		<div>
			<div class="showState">当前页面为第 ${pa.currPage }页，共  ${pa.totalPage }页，
			当前显示第${pa.identifier+1 } 条到到第${pa.identifier+pa.pageSize>pa.count?pa.count:pa.identifier+pa.pageSize}
			条数据，共${pa.count}条数据。</div>
			<div class="to">
				<input type="button"  value="首页"  onclick="toQuery(1)" >
				<input type="button"  value="上一页" onclick="toQuery(${pa.currPage-1})" 
				<c:if test="${pa.currPage<=1}">disabled</c:if>>
				<input type="button"  value=下一页   onclick="toQuery(${pa.currPage+1})" 
				<c:if test="${pa.currPage >=pa.totalPage }">disabled</c:if>>
				<input type="button"  value="尾页"  onclick="toQuery(${pa.totalPage})">
				第<select name="page" onchange="toQuery()">
					<c:forEach var = "i" begin="1" end="${pa.totalPage}" step="1">
						<option value="${i}"
							<c:if test="${pa.currPage==i}">selected</c:if>
						>${i}</option>
					</c:forEach>
				</select>页
				每页<select name="size" onchange="toQuery()">
					<c:forEach var = "i" begin="5" end="25" step="5">
						<option value="${i}"
							<c:if test="${pa.pageSize==i}">selected</c:if>
						>${i}</option>
					</c:forEach>
				</select>条数据
			</div>
		</div>
		
		<!-- 查询结果显示 -->
		<div class="main-bottom">
			<table bgcolor="lightgray">
				<caption>电子文档列表</caption>
				<tr bgcolor="gray">
					<td>文档编号</td>
					<td>文档名称</td>
					<td>文档摘要</td>
					<td>上传人</td>
					<td>上传时间</td>
					<td>操作</td>
				</tr>
				<c:forEach var="d" items="${Entry}" varStatus="i">
					<tr bgcolor="${i.index%2==0?'lightgreen':'white' }">
						<td>${d.id}</td>
						<td>${d.title}</td>
						<td>${d.summary}</td>
						<td>${d.uploadUser}</td>
						<td>${d.createDate}</td>
						<td><a
							href="${pageContext.request.contextPath}/getData?id=${d.id}">修改</a>
							<a class="delete" href="${pageContext.request.contextPath}/delete?id=${d.id}"
							onclick="return confirm('是否删除')">删除</a></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="6" bgcolor="white" align="center" class="msg"></td>
				</tr>
			</table>
		</div>
	</div>
</body>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript">
 	 function toQuery2() {
		location = "queryByCategoryId?categoryId="+$("select option:selected").attr("value");
	}  
 	 /* 查询 */
	function toQuery(target) {
		if(!target){
			target = $("select[name='page'] option:selected").val()
		}
		$.post(
				"${pageContext.request.contextPath}/main",
				"currPage="+target+"&pageSize="+$("select[name='size'] option:selected").val()
				+"&"+$(".supnav form:first").serialize(),
				function(data){
					$(".main-right").html(data);
				},
				"html"
		);
	}
	function toAdd() {
		if($("select option:selected").attr("value")==0){
			alert('请选择分类');
		}else{
		location = "pages/add.jsp?classify="
				+ $("select option:selected").attr("value");
		}
	}
	
	if("${msg}"){
		$(".msg").removeClass("${clazz}");
		$(".msg").html("${msg}").addClass("${clazz}");
		setTimeout(function(){
			$(".msg").fadeOut(1000);	
		}, 1000*2);
	<%session.removeAttribute("msg"); %>
	}
</script>
</html>