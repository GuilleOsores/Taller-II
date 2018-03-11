package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exception.AlumnoNoExisteException;
import logica.IFachada;
import logica.vo.VOEgresado;
import logica.vo.VOEscolaridad;

public class Egresados extends Servlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) {

	}	


	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		IFachada iFachada = conectar( req );

		if( iFachada != null ) {


			List<VOEgresado> lvoegre = iFachada.listadoEgresados(true); //true es parcial y solo pide listado parcial 
			req.setAttribute( "egresados", lvoegre );

		} 

		// forwardeo a la página apropiada
		RequestDispatcher rd;
		rd = req.getRequestDispatcher("Egresados.jsp");
		rd.forward(req, resp);

	}

}
