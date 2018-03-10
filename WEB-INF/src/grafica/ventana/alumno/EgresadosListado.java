package grafica.ventana.alumno;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import grafica.controlador.alumno.ControladorEgresadosListados;
import grafica.ventana.Ventana;

public class EgresadosListado extends Ventana {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTable table;
	
	ControladorEgresadosListados controlador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EgresadosListado frame = new EgresadosListado();
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
	public EgresadosListado() {
		setTitle("Listado egresados");
		controlador = new ControladorEgresadosListados( this );
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 602, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Cédula", "Nombre", "Apellido", "Prom. Total", "Prom. Aprovaciones"
			}
		) {
			Class[] columnTypes = new Class[] {
					String.class, String.class, String.class, Float.class, Float.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBounds(10, 106, 454, 211);
		JScrollPane jScrollPane = new JScrollPane(table);
		jScrollPane.setBounds(10, 55, 454, 211);
		contentPane.add(jScrollPane);
	}

}
