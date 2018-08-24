<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>c:choose版</title>
<style type="text/css">
	.row1 td {
		background: #ffffff;
	}
	.row2 td {
		background: #eeeeee;
	}
</style>
</head>
<body>

<div>
	<form action="${pageContext.request.contextPath}/getAllList" method="post">
		<input type="text" id="typename" name="typename">
		<input type="submit" id="button" name="button" value="搜尋">
	</form>
</div>

	<table class="table">
		<tr class="table_title">
			<td>廠牌</td>
			<td>品項</td>
		</tr>
		<c:choose>
			<c:when test="${type != ''  }">
				<c:forEach items="${list}" var="items" varStatus="s">
				<c:if test="${type eq items.type }">
					<tr class="row${s.index%2+1}">
					<td>${items.type}</td>
					<td>${items.name}</td></tr>
				</c:if>
			</c:forEach>
			</c:when>
				
			<c:when test="${type == '' }">
				<c:forEach items="${list}" var="items" varStatus="s">
				<tr class="row${s.index%2+1}">
				<td>${items.type}</td>
				<td>${items.name}</td></tr>
			</c:forEach>
			</c:when>
			
			<c:otherwise>
				<tr class="row1">
				<td>查無資料</td></tr>
			</c:otherwise>
		</c:choose>
	</table>
</body>

</html>