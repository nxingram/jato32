<%@page import="java.time.LocalDateTime"%>
<html>
<body>
<h2>Hello Maven!</h2>

<% LocalDateTime ld = LocalDateTime.now();

	out.print(ld);

%>


</body>
</html>
