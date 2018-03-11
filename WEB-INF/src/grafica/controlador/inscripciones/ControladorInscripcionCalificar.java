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
			showMessageDialog( "La cédula no puede ser vacío" );
			
		}else if(!soloNumeros(cedula)){			
			showMessageDialog( "La cédula debe ser numérica");		
		
		}else if( numeroInsc.trim().isEmpty() ) {
			showMessageDialog( "El Número de inscripción no puede se vacío" );
			
		}else if(!soloNumeros(numeroInsc)){			
			showMessageDialog( "El número de inscripción debe ser numérico");		
		
		}else if( calificacion == null ) {
			showMessageDialog( "La calificación no puede ser vacío" );
			
		}else {
			int intCedula	= Integer.parseInt( cedula );
			int intNumInsc	= Integer.parseInt( numeroInsc );
			
			try {
				getFachada().registrarCalificacion(intCedula, intNumInsc, calificacion);;
				showMessageDialog( "Asignatura calificada correctamente" );
				getVentana().dispose();
			} catch (RemoteException e) {
				showMessageDialog( "El servidor está caído" );
			} catch (InscripcionNoExisteException e) {
				showMessageDialog( "El alumno no está inscripto en esta asignatura" );
			} catch (AsignaturaYaCalificadaException e) {
				showMessageDialog( "La asignatura ya fue calificada" );
			} catch (AlumnoNoExisteException e) {
				showMessageDialog( "El alumno no existe" );
			} 
		}
		
	}	
	
}
