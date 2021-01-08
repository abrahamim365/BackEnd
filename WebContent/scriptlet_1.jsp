<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//자바 문법을 사용할 수 있는 부분!!
int n1 = 10;
int n2 = 20;
int result = n1 + n2;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><%out.print(result); %></div> 
<div><%out.print(n1 + n2); %></div>
<div><%=n1+n2 %></div>
<div><%=result %></div>
</body>
</html>
