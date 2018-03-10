package grafica.ventana;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Ventana extends JFrame {

	public Ventana() {
		super();
	}
	
	public void showMessageDialog( String mensaje ) {
		javax.swing.JOptionPane.showMessageDialog( null, mensaje );
	}
	
}
