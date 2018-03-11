package grafica.controlador.inscripciones;

import java.rmi.RemoteException;

import exception.AlumnoNoExisteException;
import grafica.controlador.Controlador;
import grafica.ventana.inscripciones.InscripcionesMontoRecaudado;

public class ControladorInscripcionesMontoRecaudado extends Controlador{
	
	public ControladorInscripcionesMontoRecaudado( InscripcionesMontoRecaudado inscripcionesMontoRecaudado) {

		super( inscripcionesMontoRecaudado );

	}		

	public float calcular( String cedula, String anioLectivo) {
		
		float monto = 0;
		
		if (cedula.trim().isEmpty()) {
			showMessageDialog( "La cédula no puede ser vacío" );
			
		}else if(!soloNumeros(cedula)){			
			showMessageDialog( "La cédula debe ser numérica");		
		
		}else if( anioLectivo.trim().isEmpty() ) {
			showMessageDialog( "El año lectivo no puede se vacío" );
			
		}else if(!soloNumeros(anioLectivo)){			
			showMessageDialog( "El año lectivo debe ser numérico");		
		
		}else {
			int intCedula	= Integer.parseInt( cedula );
			int intAnioLectivo	= Integer.parseInt( anioLectivo );
			
			try {
				monto = getFachada().montoRecaudado(intCedula, intAnioLectivo);
				//showMessageDialog( "Monto calculado correctamente" );
				//getVentana().dispose();
			} catch (RemoteException e) {
				showMessageDialog( "El servidor está caído" );
			} catch (AlumnoNoExisteException e) {
				showMessageDialog( "El alumno no existe" );
			} 
		}
		
		return monto;
		
	}		
	
}
