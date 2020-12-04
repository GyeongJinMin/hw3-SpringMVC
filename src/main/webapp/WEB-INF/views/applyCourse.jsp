<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.*, java.text.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강 신청하기</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css" >
</head>
<body>

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
		
		// 폼
	%>

	<sf:form method="post" action="${pageContext.request.contextPath}/doCreate" modelAttribute="course">
		<table class="formtable">
			<tr> <td class="label"> Year:</td>
				<td> <sf:input class="control" type="text" path="year" value="<%=year %>"/> <br/>
				<sf:errors path="year" class="error"/> </td> </tr>
			<tr> <td class="label"> Semester:</td>
				<td> <sf:input class="control" type="text" path="semester" value="<%=semester %>"/> <br/>
				<sf:errors path="semester" class="error"/> </td> </tr>
			<tr> <td class="label"> Title:</td>
				<td> <sf:input class="control" type="text" path="title"/> <br/>
				<sf:errors path="title" class="error"/> </td> </tr>
			<tr> <td class="label"> Classification:</td>
				<td> <sf:input class="control" type="text" path="classification"/> <br/>
				<sf:errors path="classification" class="error"/> </td> </tr>
			<tr> <td class="label"> Professor:</td>
				<td> <sf:input class="control" type="text" path="professor"/> <br/>
				<sf:errors path="professor" class="error"/> </td> </tr>
			<tr> <td class="label"> Credit:</td>
				<td>
					<sf:select name="credit" class="control" path="credit">
						<option value="1">1학점</option>
						<option value="2">2학점</option>
						<option value="3" selected>3학점</option>
					</sf:select><br/><sf:errors path="credit" class="error"/> </td> </tr>
			<tr> <td>  </td> <td> <input type="submit" value="Apply"/> </td> </tr>
		</table>
	</sf:form>

</body>
</html>