package grafica.controlador.alumno;

import java.rmi.RemoteException;
import java.util.List;

import exception.AlumnoNoExisteException;
import grafica.controlador.Controlador;
import grafica.ventana.alumno.AlumnoEscolaridad;

public class ControladorAlumnoEscolaridad extends Controlador {

	public ControladorAlumnoEscolaridad(AlumnoEscolaridad  ventana) {
		super(ventana);
		// TODO Auto-generated constructor stub
	}
	
	public List<logica.vo.VOEscolaridad> listarInscripciones( String cedulaStr, boolean modo ){
		List<logica.vo.VOEscolaridad> lvoe = null;
		
		if (cedulaStr.trim().isEmpty()) {
			showMessageDialog( "La c�dula no puede ser vac�o" );	
			
		}else if(!soloNumeros(cedulaStr)){			
			showMessageDialog( "La c�dula debe ser num�rica");		
			
		}else {
			int cedula = Integer.parseInt( cedulaStr );
			
			try {
				lvoe = getFachada().escolaridad(cedula, modo);
				
			} catch (AlumnoNoExisteException e) {
				showMessageDialog("AlumnoNoExisteException");
				
			} catch (RemoteException e) {
				showMessageDialog( "El servidor est� ca�do" );
			}
						
		}
		
		return lvoe;
		
	}

}
