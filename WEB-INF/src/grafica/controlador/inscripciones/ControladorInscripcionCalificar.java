package grafica.controlador.inscripciones;

import java.rmi.RemoteException;

import exception.InscripcionNoExisteException;
import exception.AsignaturaYaCalificadaException;
import exception.AlumnoNoExisteException;
import grafica.controlador.Controlador;
import grafica.ventana.inscripciones.InscripcionCalificar;


public class ControladorInscripcionCalificar extends Controlador {
	
	public ControladorInscripcionCalificar( InscripcionCalificar inscripcionCalificar) {

		super( inscripcionCalificar );

	}	

	public void calificar( String cedula, String numeroInsc, Integer calificacion) {
		
		
		if (cedula.trim().isEmpty()) {
			showMessageDialog( "La c�dula no puede ser vac�o" );
			
		}else if(!soloNumeros(cedula)){			
			showMessageDialog( "La c�dula debe ser num�rica");		
		
		}else if( numeroInsc.trim().isEmpty() ) {
			showMessageDialog( "El N�mero de inscripci�n no puede se vac�o" );
			
		}else if(!soloNumeros(numeroInsc)){			
			showMessageDialog( "El n�mero de inscripci�n debe ser num�rico");		
		
		}else if( calificacion == null ) {
			showMessageDialog( "La calificaci�n no puede ser vac�o" );
			
		}else {
			int intCedula	= Integer.parseInt( cedula );
			int intNumInsc	= Integer.parseInt( numeroInsc );
			
			try {
				getFachada().registrarCalificacion(intCedula, intNumInsc, calificacion);;
				showMessageDialog( "Asignatura calificada correctamente" );
				getVentana().dispose();
			} catch (RemoteException e) {
				showMessageDialog( "El servidor est� ca�do" );
			} catch (InscripcionNoExisteException e) {
				showMessageDialog( "El alumno no est� inscripto en esta asignatura" );
			} catch (AsignaturaYaCalificadaException e) {
				showMessageDialog( "La asignatura ya fue calificada" );
			} catch (AlumnoNoExisteException e) {
				showMessageDialog( "El alumno no existe" );
			} 
		}
		
	}	
	
}
