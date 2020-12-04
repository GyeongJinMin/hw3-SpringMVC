<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Please sign in (Customs Login Form)</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/login.css" >
</head>
<body>
	<div class="Container">
		<h1 class="form-signin-header">Sign In</h1>
		<form class="form-signin" method="post" action="<c:url value="login"/>">
			<hr>
			<h2 class="form-signin-description">Please sign in</h2>
			
			<c:if test="${not empty errorMsg}">
				<div style="color:#ff0000"> <h4> ${errorMsg} </h4> </div>
			</c:if>
			
			<c:if test="${not empty logoutMsg}">
				<div style="color:#0000ff"> <h4> ${logoutMsg} </h4> </div>
			</c:if>
			
			<p>
				<input type="text" id="username" name="username" placeholder="Username" required autofocus>
			</p>
			<p>
				<input type="password" id="password" name="password" placeholder="Password" required>
			</p>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<button type="submit">Login</button>
		</form>
	</div>
</body>
</html>