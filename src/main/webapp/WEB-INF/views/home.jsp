<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*, java.text.*" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
	<p> <a href="${pageContext.request.contextPath}/searchCredits"> 학기별 이수 학점 조회 </a> </p>
	<p> <a href="${pageContext.request.contextPath}/applyCourse"> 수강 신청하기 </a> </p>
	
	<%
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int semester;
		
		// 다음학기
		if(3<= month && month<=8) { // 현재 1학기
			semester = 2;
		}
		else { // 현재 2학기
			if(9<= month && month<=12) {
				year = year + 1;
			}
			semester = 1;
		}
		
		String url = "/searchApplyCourse?year="+year+"&semester="+semester;
	%>
	<p> <a href=${pageContext.request.contextPath}<%= url %>> 수강 신청 조회 </a> </p>
	
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<a href="javascript:document.getElementById('logout').submit()">Logout</a>
	</c:if>
	
	<form id="logout" action="<c:url value="/logout"/>" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
	
</body>
</html>
