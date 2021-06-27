<!DOCTYPE html>
<%@page import="model.Libro"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<h1>Hello World</h1>
	<% 
	/*
	String s = "ciao";
	for(int i=1; i<=6;i++){
		out.print("<h"+i+">"+s+"</h"+i+">");
	}*/
	
	Libro l = new Libro();
	l.titolo = "I/O, Robot";
	out.print(l.titolo);
	
	%>

	
</body>
</html>