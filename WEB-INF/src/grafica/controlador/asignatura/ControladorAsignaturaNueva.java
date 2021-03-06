package grafica.controlador.asignatura;

import java.rmi.RemoteException;

import exception.AsignaturaYaExisteException;
import exception.ListaLlenaException;
import grafica.controlador.Controlador;
import grafica.ventana.asignatura.AsignaturaNueva;
import logica.vo.VOAsignatura;

public class ControladorAsignaturaNueva extends Controlador {


	public ControladorAsignaturaNueva (AsignaturaNueva asignaturaNueva) {

		super(asignaturaNueva);
	}

	public void grabar(String codigo, String nombre, String descripcion) {
		System.out.println("k=llegue");
		if( codigo.isEmpty() ) {
			showMessageDialog( "El codigo no puede ser vac�o" );
		}else if( nombre.isEmpty() ) {
			showMessageDialog( "El nombre no puede ser vac�o" );
		}
		else if( descripcion.isEmpty() ) {
			showMessageDialog( "La descripcion no puede ser vac�a" );	
		}else {



			VOAsignatura voAsig = new VOAsignatura(codigo,nombre,descripcion);
			try {
				getFachada().registrarAsignatura(voAsig);

				showMessageDialog("Asignatura registrada");
				getVentana().dispose();
			}catch(RemoteException e) {
				showMessageDialog( "El servidor est� ca�do" );
			} catch (ListaLlenaException e) {
				showMessageDialog( "No se admiten mas asignaturas " );
			}catch (AsignaturaYaExisteException e) {
				showMessageDialog( "La asignatura ya existe" );
			}

		}
	}

	@Override
	public void showMessageDialog( String string ) {

		getVentana().showMessageDialog( string );
	}

}

