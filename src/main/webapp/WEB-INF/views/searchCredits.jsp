<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학기별 이수 학점 조회</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/courseTable.css" >
</head>
<body>
	<form>
	<table>
		<thead>
			<tr><th>년도</th><th>학기</th><th>취득 학점</th><th>상세보기</th></tr>
		</thead>
		<c:set var="total" value="0" />
		<c:forEach var="course" items="${courses}">
			<tr>
				<td><c:out value="${course.year}"> </c:out></td>
				<td><c:out value="${course.semester}"> </c:out></td>
				<td><c:out value="${course.credit}"> </c:out></td>
				<td><a href='searchCourses?year=${course.year}&semester=${course.semester}'} type="submit">상세보기</a></td>
			</tr>
			<c:set var="total" value="${total + course.credit}" />
		</c:forEach>
		<tfoot>
			<tr><td>총계</td><td></td><td><c:out value="${total}" /></td><td></td></tr>
		</tfoot>
	</table>
	</form>
	
</body>
</html>