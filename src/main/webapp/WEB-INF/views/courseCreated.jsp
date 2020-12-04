<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

${course.year}-${course.semester} ${course.title}을 신청할 예상 교과목에 저장하였습니다. 감사합니다.

<a href='searchApplyCourse?year=${course.year}&semester=${course.semester}'}>수강 신청 조회</a>
</body>
</html>