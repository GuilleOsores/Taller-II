<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.LinkedList" %>
<jsp:useBean id='escolaridad' scope='request' class='java.util.LinkedList' />

<html>
<head>
<title>Escolaridad</title>
</head>

<body>
	<form action='Escolaridad' method='POST'>
		<table border="5" width="50%" height="50">
			<tr>
				<td><span>Cédula</span></td>
				<td><input type="text" id="cedula" name="cedula"/></td>
			</tr>
		</table>
		<p>
			<input type='submit' value='ENVIAR'>
		</p>
	</form>
	<table border="5" width="50%" height="50">
		<tr>
			<th>Número</th>
			<th>Asignatura</th>
			<th>Año Lectivo</th>
			<th>Calificación</th>
		</tr>
		<c:forEach items="${escolaridad}" var="i" >
			<tr>
				<td> ${i.getNumero()} </td>
				<td> ${i.getAsignaturaNombre()} </td>
				<td> ${i.getAnioLectivo()} </td>
				<td> ${i.getCalificacion()} </td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>