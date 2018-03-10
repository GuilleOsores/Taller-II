<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!--<jsp:useBean id='datosPer' scope='session' class='valueObjects.DataPersona' />-->  

<html>
  <head>
    <title> Escolaridad </title>
  </head>

  <body bgcolor="#DCFBD2">
	<table border="5" width="50%" bordercolor="#00AE00" height="50" bgcolor="#B6F4AA">
		<tr>
			<td>
				<p align="center"><b>
				<font face="Tahoma" size="4"> Bienvenido ${datosPer.nombre} de ${datosPer.procedencia} </font></b>
			</td>
		</tr>
	</table>

    <form action='Escolaridad' method='POST'>
      <table border="5" width="50%" bordercolor="#00AE00" height="50" bgcolor="#B6F4AA">
      <tr>
			<td>
				<span>Cédula</span>
			</td>
			<td>
				<input type="text" id="cedula" />
			</td>
		</tr>
		<tr>
			<td>
			</td>
			<td>
				<select name="completo">
					<option value="true"> Completo </option>
					<option value="false"> Intermedio </option>
				</select>
			</td>
		</tr>
	</table>
      <p> <input type='submit' value='ENVIAR'> </p>
    </form>
  </body>
</html>