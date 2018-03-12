<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.LinkedList" %>
<jsp:useBean id='egresados' scope='request' class='java.util.ArrayList' />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Egresados</title>
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
          <li ><a href="Escolaridad.jsp"><span>Escolaridad</span></a></li>
          <li class="active"><a href="Egresados"><span>Egresados</span></a></li>
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
	<h2>Listado de egresados</h2>
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
    </div>
  </div>


</div>
</body>
</html>



