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
			showMessageDialog( "La c�dula no puede ser vac�o" );
			
		}else if(!soloNumeros(cedula)){			
			showMessageDialog( "La c�dula debe ser num�rica");		
		
		}else if( anioLectivo.trim().isEmpty() ) {
			showMessageDialog( "El a�o lectivo no puede se vac�o" );
			
		}else if(!soloNumeros(anioLectivo)){			
			showMessageDialog( "El a�o lectivo debe ser num�rico");		
		
		}else {
			int intCedula	= Integer.parseInt( cedula );
			int intAnioLectivo	= Integer.parseInt( anioLectivo );
			
			try {
				monto = getFachada().montoRecaudado(intCedula, intAnioLectivo);
				//showMessageDialog( "Monto calculado correctamente" );
				//getVentana().dispose();
			} catch (RemoteException e) {
				showMessageDialog( "El servidor est� ca�do" );
			} catch (AlumnoNoExisteException e) {
				showMessageDialog( "El alumno no existe" );
			} 
		}
		
		return monto;
		
	}		
	
}
