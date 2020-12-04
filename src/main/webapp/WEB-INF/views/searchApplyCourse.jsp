<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강 신청 조회</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/courseTable.css" >
</head>
<body>
	<table>
		<thead>
			<tr><th>년도</th><th>학기</th><th>교과목명</th><th>교과구분</th><th>담당교수</th><th>학점</th></tr>
		</thead>
		<c:forEach var="course" items="${courses}">
			<tr>
				<td><c:out value="${course.year}"> </c:out></td>
				<td><c:out value="${course.semester}"> </c:out></td>
				<td class="td_title"><c:out value="${course.title}"> </c:out></td>
				<td><c:out value="${course.classification}"> </c:out></td>
				<td class="td_professor"><c:out value="${course.professor}"> </c:out></td>
				<td><c:out value="${course.credit}"> </c:out></td>
			</tr>
		</c:forEach>	
	</table>
	
	<a href='${pageContext.request.contextPath}'>Home</a>
</body>
</html>