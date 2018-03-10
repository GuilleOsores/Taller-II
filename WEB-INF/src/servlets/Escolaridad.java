package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exception.AlumnoNoExisteException;
import logica.IFachada;


public class Escolaridad extends Servlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    // obtengo los datos del Request
	    String cedula = req.getParameter("cedula").trim();
	    String completo = req.getParameter("completo").trim();
	    boolean error = true;
	    	    
	    String msgError = new String();
	    if( (cedula == null) || cedula.equals("") ) {
			msgError = "La cedula no puede estar vacio";
			req.setAttribute("msgError", msgError);
		
	    } else if ( !soloNumeros( cedula ) ) {
	    	msgError = "La cédula debe ser numérica";
	    	req.setAttribute("msgError", msgError);
	    	
	    } else if ( completo != "true" || completo != "false" ) {
	    	msgError = "Opción inválida";
	    	req.setAttribute("msgError", msgError);
	    	
		} else {		    
			IFachada iFachada = conectar( req );
			
			if( iFachada != null ) {
				int intCedula	= Integer.parseInt( cedula );
				boolean parcial = !Boolean.parseBoolean( completo );
				
				try {
					iFachada.escolaridad( intCedula, parcial );
				} catch (AlumnoNoExisteException e) {
					msgError = "El alumno no existe";
			    	req.setAttribute("msgError", msgError);
				}
				
			}
			
			HttpSession session = req.getSession();
		    //DataPersona datosPer = new DataPersona(nombre,procedencia);
		    synchronized (session)
		    {
		        session.setAttribute("cedula", cedula);    
		    }	    
	    }    
	    
		// forwardeo a la página apropiada
		RequestDispatcher rd;
		if (!error)
			rd = req.getRequestDispatcher("Mensaje.jsp");
		else {
			rd = req.getRequestDispatcher("Error.jsp");
		}
			
		rd.forward(req, resp);
	}
}
