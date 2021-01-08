<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! //메소드 밖이기 때문에 전역이므로 가능하다.
	int a=10;
	private int sum(int n1, int n2) {
		return n1+n2;
	}

%>
<% //자바는 메소드안에 메소드를 넣는것은 불가능하다.
   /* public void sum(int n1, int n2) {
 	
   }*/
	int a=20;	//this가 없으면 젤가까운 지역변수가 출력된다.

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립틀릿2</title>
</head>
<body>
	<div><%=sum(10,40) %></div>
	<div>this.a:<%=this.a %></div>
	<div>a:<%=a %></div>
</body>
</html>
