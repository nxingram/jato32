<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h2 {
	color: red;
}
</style>
</head>
<body>
	<form action="" method="post">
		<input type="text" name="cognome"> <input type="submit"
			value="Invia">
	</form>

	<h2>
		Benvenuto
		<%=request.getParameter("cognome")%>
	</h2>


	<script type="text/javascript">
		console.log("login funziona")
	</script>
</body>
</html>