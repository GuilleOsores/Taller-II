package grafica.ventana.inscripciones;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import grafica.controlador.inscripciones.ControladorInscripcionCalificar;
import grafica.ventana.Ventana;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;

@SuppressWarnings("serial")
public class InscripcionCalificar extends Ventana {

	private JPanel contentPane;
	private JTextField textCedula;
	private JTextField textNroInsc;
	ControladorInscripcionCalificar controlador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InscripcionCalificar frame = new InscripcionCalificar("",0);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InscripcionCalificar(String cedula, Integer numeroInsc) {
		
		controlador = new ControladorInscripcionCalificar(this);
		
		setResizable(false);
		setTitle("Calificar Inscripci\u00F3n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 280, 200);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Calificaci\u00F3n:");
		lblNewLabel.setBounds(10, 79, 90, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblCdula = new JLabel("C\u00E9dula:");
		lblCdula.setBounds(10, 31, 46, 14);
		contentPane.add(lblCdula);
		
		textCedula = new JTextField();
		textCedula.setBounds(110, 28, 134, 20);
		contentPane.add(textCedula);
		textCedula.setColumns(10);
		
		JLabel lblNInscripcin = new JLabel("N\u00B0 Inscripci\u00F3n");
		lblNInscripcin.setBounds(10, 56, 90, 14);
		contentPane.add(lblNInscripcin);
		
		textNroInsc = new JTextField();
		textNroInsc.setBounds(110, 53, 134, 20);
		contentPane.add(textNroInsc);
		textNroInsc.setColumns(10);
	
		JSpinner calificacion = new JSpinner();
		calificacion.setBounds(110, 76, 134, 20);
		contentPane.add(calificacion);
		
		textCedula.setText(cedula);
		textNroInsc.setText(Integer.toString(numeroInsc));
		
		JButton btnCalificar = new JButton("Calificar");
		btnCalificar.setBounds(155, 127, 89, 23);
		btnCalificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cedula = textCedula.getText();
				String nroInsc = textNroInsc.getText();
				Integer calif = (Integer)calificacion.getValue();
				
				controlador.calificar(cedula, nroInsc, calif);

			}
		});
		
		
		contentPane.add(btnCalificar);
		
	}
}
