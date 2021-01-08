<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String strN1 = request.getParameter("n1");
    	String strN2 = request.getParameter("n2");
    	int n1 = Integer.parseInt(strN1);
    	int n2 = Integer.parseInt(strN2);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><%=n1%>+<%=n2%>=<%=n1+n2%></div>
</body>
</html>
