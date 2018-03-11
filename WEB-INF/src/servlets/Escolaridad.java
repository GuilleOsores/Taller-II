package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exception.AlumnoNoExisteException;
import logica.IFachada;
import logica.vo.VOEscolaridad;


public class Escolaridad extends Servlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) {

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// obtengo los datos del Request
		String cedula = req.getParameter("cedula");
		boolean error = true;

		String msgError = new String();
		if( (cedula == null) || cedula.trim().equals("") ) {
			msgError = "La cedula no puede estar vacio" + cedula;
			req.setAttribute("msgError", msgError);

		} else if ( !soloNumeros( cedula ) ) {
			msgError = "La cédula debe ser numérica";
			req.setAttribute("msgError", msgError);

		} else {		    
			IFachada iFachada = conectar( req );

			if( iFachada != null ) {
				int intCedula	= Integer.parseInt( cedula );

				try {
					List<VOEscolaridad> lvoe = iFachada.escolaridad( intCedula, true ); //parcial
					req.setAttribute( "escolaridad", lvoe );

					error = false;

				} catch (AlumnoNoExisteException e) {
					msgError = "El alumno no existe";
					req.setAttribute("msgError", msgError);
				}

			}
  
		}    

		// forwardeo a la página apropiada
		RequestDispatcher rd;
		if (!error)
			rd = req.getRequestDispatcher("Escolaridad.jsp");
		else {
			rd = req.getRequestDispatcher("Error.jsp");
		}

		rd.forward(req, resp);
	}
}
