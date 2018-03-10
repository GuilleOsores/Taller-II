package servlets;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import logica.IFachada;


public abstract class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected IFachada conectar( HttpServletRequest req ) {
		String servidorIp		= super.getInitParameter( "ServidorIp" );
		String servidorPuerto	= super.getInitParameter( "ServidorPuerto" );

		IFachada fachada = null;
		try {
			fachada = (IFachada) Naming.lookup("//" + servidorIp + ":" + servidorPuerto + "/fachada");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			fachada = null;
			req.setAttribute("msgError", "Servidor caído");
		}
		return fachada;
	}

	protected boolean soloNumeros( String string ) {
		Pattern pattern = Pattern.compile( "^[0-9]*$" );

		Matcher matcher = pattern.matcher( string );
		boolean matches = matcher.matches();

		return matches;
	}

}
