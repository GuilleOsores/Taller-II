package grafica.controlador.alumno;

import java.rmi.RemoteException;
import java.util.List;

import grafica.controlador.Controlador;
import grafica.ventana.alumno.EgresadosListado;
import logica.vo.VOEgresado;

public class ControladorEgresadosListados extends Controlador{

	public ControladorEgresadosListados( EgresadosListado ventana ) {
		super( ventana );
	}
	
	public List<VOEgresado> Escolaridad( boolean completa ) {
		boolean parcial = !completa;
		List<VOEgresado> lvoe = null;
		try {
			lvoe = getFachada().listadoEgresados( parcial );
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lvoe;
	}
	
}
