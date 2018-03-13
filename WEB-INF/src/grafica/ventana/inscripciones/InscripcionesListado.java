package grafica.ventana.inscripciones;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;

import grafica.controlador.inscripciones.ControladorInscripcionesListado;
import grafica.ventana.Ventana;
import grafica.ventana.inscripciones.InscripcionNueva;
import logica.vo.VOEscolaridad;


@SuppressWarnings("serial")
public class InscripcionesListado extends Ventana{

	private JPanel contentPane;
	private JTextField txtCedula;
	private JTable table;
	private JButton btnAgregar;
	private JButton btnModificar;
	private InscripcionNueva inscripcionNueva;
	private InscripcionCalificar inscripcionCalificar;
	private JComboBox<String> comboBox;

	
	ControladorInscripcionesListado controlador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InscripcionesListado frame = new InscripcionesListado();
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
	public InscripcionesListado() {
		controlador = new ControladorInscripcionesListado( this );
		
		setTitle("Manejo de Inscripciones/Escolaridad");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblFltCedula = new JLabel("Cedula:");
		lblFltCedula.setBounds(10, 34, 66, 14);
		contentPane.add(lblFltCedula);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(113, 31, 151, 20);
		contentPane.add(txtCedula);
		txtCedula.setColumns(10);
		
		JButton btnBuscar = new JButton("Obtener Escolaridad");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					cargarTabla();
				} catch (Exception a) {
					//showMessageDialog( "Vuelva a intentar con otra cédula" );
				}
			}
		});
		btnBuscar.setBounds(274, 31, 156, 20);
		contentPane.add(btnBuscar);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"N\u00B0 Inscripci\u00F3n", "Nombre Asignatura", "A\u00F1o Lectivo", "Calificaci\u00F3n", "Monto Base"
			}
		) );
		table.setBounds(10, 106, 454, 211);
		JScrollPane jScrollPane = new JScrollPane(table);
		jScrollPane.setBounds(10, 78, 561, 211);
		contentPane.add(jScrollPane);
		
		btnAgregar = new JButton("Nueva Inscripción");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cedula	= txtCedula.getText();
				
				if (inscripcionNueva != null)
					inscripcionNueva.dispose();
				inscripcionNueva = new InscripcionNueva(cedula);
				inscripcionNueva.setVisible(true);
			}
		});
		btnAgregar.setBounds(429, 31, 142, 20);
		contentPane.add(btnAgregar);
		
		btnModificar = new JButton("Calificar Asignatura");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if( table.getSelectedRow() >= 0 ) {
					String cedula	= txtCedula.getText();
					int numeroInsc = (int)table.getValueAt(table.getSelectedRow(), 0);
					
					if (inscripcionCalificar != null)
						inscripcionCalificar.dispose();
					inscripcionCalificar = new InscripcionCalificar(cedula, numeroInsc);
					inscripcionCalificar.setVisible(true);
				}else {
					showMessageDialog( "Seleccione una inscripción para calificar" );
				}
			}
		});
		btnModificar.setBounds(10, 300, 151, 20);
		contentPane.add(btnModificar);
		
		JLabel lblModoListado = new JLabel("Modo Listado:");
		lblModoListado.setBounds(10, 11, 90, 14);
		contentPane.add(lblModoListado);
		
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Completo", "Parcial"}));
		comboBox.setBounds(113, 8, 151, 20);
		contentPane.add(comboBox);
		
		//cargarTabla();
	}

	private void cargarTabla() {
		Object[][] data = null;
		Object[] titles = null;
		int i = 0;
		List<VOEscolaridad> lvoe;
		
		if( "Parcial".equals( (String)comboBox.getSelectedItem() ) ) {
			lvoe = controlador.listarInscripciones( txtCedula.getText(), true );
			data = new Object[lvoe.size()][];
			for( VOEscolaridad voe: lvoe ) {
				data[i] = new Object[] { voe.getNumero(), voe.getAsignaturaNombre(), voe.getAnioLectivo(), voe.getCalificacion() };
				i++;
			}
			titles = new Object[] { "N° Inscripción", "Nombre Asignatura", "Año Lectivo", "Calificación" };
		}else {
			lvoe = controlador.listarInscripciones( txtCedula.getText(), false );
			data = new Object[lvoe.size()][];
			for( VOEscolaridad voe: lvoe ) {
				data[i] = new Object[] { voe.getNumero(), voe.getAsignaturaNombre(), voe.getAnioLectivo(), voe.getCalificacion(), voe.getMontoBase() };
				i++;
			}
			titles = new Object[] { "N° Inscripción", "Nombre Asignatura", "Año Lectivo", "Calificación", "Monto Base" };
		}
		
		table.setModel( new DefaultTableModel(data, titles) );
		table.repaint();
	}
	
	public void showMessageDialog( String mensaje ) {

		javax.swing.JOptionPane.showMessageDialog( null, mensaje );
	}
}
