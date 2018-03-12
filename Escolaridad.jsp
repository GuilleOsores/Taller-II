<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.LinkedList" %>
<jsp:useBean id='escolaridad' scope='request' class='java.util.LinkedList' />


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Escolaridad</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="./static/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="./static/js/cufon-yui.js"></script>
<script type="text/javascript" src="./static/js/arial.js"></script>
<script type="text/javascript" src="./static/js/cuf_run.js"></script>
</head>
<body>
<div class="main">
  <div class="header">
    <div class="header_resize">
      <div class="logo">
        <h1><a href="index.jsp"><span>Chef</span>GourmetUruguay<br />
          <small>TallerII 2018</small></a></h1>
      </div>

      <div class="clr"></div>
      <div class="menu">
        <ul>
          <li ><a href="index.jsp"><span>Inicio</span></a></li>
          <li class="active"><a href="Escolaridad.jsp"><span>Escolaridad</span></a></li>
          <li><a href="Egresados"><span>Egresados</span></a></li>
        </ul>
      </div>
      <div class="clr"></div>
    </div>
  </div>
  <div class="clr"></div>
  <div class="hbg">

  </div>  
  <div class="content">
    <div class="content_resize">
		<h2>Consulta de escolaridad</h2>
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
    </div>
  </div>


</div>
</body>
</html>


	
