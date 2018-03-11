<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.LinkedList" %>
<jsp:useBean id='egresados' scope='request' class='java.util.LinkedList' />

<html>
<head>
<title>Escolaridad</title>
</head>

<body>
	<table border="5" width="50%" height="50">
		<tr>
			<th>Cédula</th>
			<th>Nombre</th>
			<th>Apellido</th>
		</tr>
		<c:forEach items="${egresados}" var="i" >
			<tr>
				<td> ${i.getCedula()} </td>
				<td> ${i.getNombre()} </td>
				<td> ${i.getApellido()} </td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>