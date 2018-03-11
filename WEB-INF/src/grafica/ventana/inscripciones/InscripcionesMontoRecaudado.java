package grafica.ventana.inscripciones;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import grafica.controlador.inscripciones.ControladorInscripcionesMontoRecaudado;

import grafica.ventana.Ventana;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class InscripcionesMontoRecaudado extends Ventana {

	private JPanel contentPane;
	private JTextField textCedula;
	private JTextField textAnioLectivo;
	private JTextField textMontoRecaudado;
	
	ControladorInscripcionesMontoRecaudado controlador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InscripcionesMontoRecaudado frame = new InscripcionesMontoRecaudado();
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
	public InscripcionesMontoRecaudado() {
		
		controlador = new ControladorInscripcionesMontoRecaudado(this);
		
		setTitle("Monto recaudado por Inscripciones");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 175);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCdula = new JLabel("C\u00E9dula:");
		lblCdula.setBounds(20, 23, 86, 14);
		contentPane.add(lblCdula);
		
		textCedula = new JTextField();
		textCedula.setBounds(144, 20, 86, 20);
		contentPane.add(textCedula);
		textCedula.setColumns(10);
		
		JLabel lblAoLectivo = new JLabel("A\u00F1o lectivo:");
		lblAoLectivo.setBounds(20, 48, 95, 14);
		contentPane.add(lblAoLectivo);
		
		textAnioLectivo = new JTextField();
		textAnioLectivo.setBounds(144, 45, 86, 20);
		contentPane.add(textAnioLectivo);
		textAnioLectivo.setColumns(10);
		
		JLabel lblMontoRecaudado = new JLabel("Monto recaudado");
		lblMontoRecaudado.setBounds(20, 96, 114, 14);
		contentPane.add(lblMontoRecaudado);
		
		textMontoRecaudado = new JTextField();
		textMontoRecaudado.setEnabled(false);
		textMontoRecaudado.setBounds(144, 93, 86, 20);
		contentPane.add(textMontoRecaudado);
		textMontoRecaudado.setColumns(10);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cedula = textCedula.getText();
				String anio = textAnioLectivo.getText();
				
				float monto = controlador.calcular(cedula, anio);
				
				textMontoRecaudado.setText(Float.toString(monto));
				
				
				
			}
		});		
		btnCalcular.setBounds(270, 19, 89, 23);
		contentPane.add(btnCalcular);
	}
}
