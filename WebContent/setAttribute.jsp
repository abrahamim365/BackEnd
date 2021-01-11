<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	pageContext.setAttribute("name","순일이");
	request.setAttribute("name","도흠이");
	session.setAttribute("name","홍길동");
	application.setAttribute("name","유정이");

	String name = "dkdkdkdkdk";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>${param.n1} + ${param.n2} = ${param.n1}${param.n2}</div>
	<div>${param.n1} + ${param.n2} = ${param.n1 + param.n2}</div>
	<div>${name}</div>
	<div><%=name%></div> 
</body>
</html>
