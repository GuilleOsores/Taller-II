package grafica.ventana.alumno;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import grafica.controlador.alumno.ControladorAlumnoEscolaridad;
import grafica.ventana.Ventana;
import logica.vo.VOEscolaridad;

@SuppressWarnings("serial")
public class AlumnoEscolaridad extends Ventana {

	private JPanel contentPane;
	private JTextField txtCedula;
	private JTable table;
	
	
	ControladorAlumnoEscolaridad controlador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlumnoEscolaridad frame = new AlumnoEscolaridad();
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
	public AlumnoEscolaridad() {
		controlador = new ControladorAlumnoEscolaridad( this );
	
	setTitle("Listado de Escolaridad");
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
	
	JButton btnBuscar = new JButton("Obtener");
	btnBuscar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			try {
				cargarTabla();
			} catch (Exception a) {
				//showMessageDialog( "Vuelva a intentar con otra cédula" );
			}
		}
	});
	btnBuscar.setBounds(280, 31, 90, 20);
	contentPane.add(btnBuscar);
	
	table = new JTable();
	table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	table.setModel(new DefaultTableModel(
		new Object[][] {
		},
		new String[] {
			"N\u00B0 Inscripci\u00F3n", "Nombre Asignatura", "A\u00F1o Lectivo", "Calificaci\u00F3n", "Monto Base"
		}
	) {
		@SuppressWarnings("rawtypes")
		Class[] columnTypes = new Class[] {
			Integer.class, String.class, String.class, String.class, String.class
		};
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public Class getColumnClass(int columnIndex) {
			return columnTypes[columnIndex];
		}
	});
	table.setBounds(10, 106, 454, 211);
	JScrollPane jScrollPane = new JScrollPane(table);
	jScrollPane.setBounds(10, 109, 561, 211);
	contentPane.add(jScrollPane);
	
	
}

private void cargarTabla() {
	System.out.println("cargo");
	Object[][] data = null;
	Object[] titles = null;
	int i = 0;
	List<VOEscolaridad> lvoe;

	
		lvoe = controlador.listarInscripciones( txtCedula.getText(), true );
		data = new Object[lvoe.size()][];
		for( VOEscolaridad voe: lvoe ) {
			data[i] = new Object[] { voe.getNumero(), voe.getAsignaturaNombre(), voe.getAnioLectivo(), voe.getCalificacion() };
			i++;
		
		titles = new Object[] { "N° Inscripción", "Nombre Asignatura", "Año Lectivo", "Calificación" };
			
	}
	
	table.setModel( new DefaultTableModel(data, titles) );
	table.repaint();
}

}
