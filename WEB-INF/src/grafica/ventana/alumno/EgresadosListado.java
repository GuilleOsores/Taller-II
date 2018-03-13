package grafica.ventana.alumno;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import grafica.controlador.alumno.ControladorEgresadosListados;
import grafica.ventana.Ventana;
import logica.vo.VOEgresado;

import javax.swing.JRadioButton;

public class EgresadosListado extends Ventana {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTable table;
	private JRadioButton rdbtnCompleto;
	private JRadioButton rdbtnParcial;
	private JScrollPane jScrollPane;
	
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
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(10, 106, 454, 211);
		
		jScrollPane = new JScrollPane(table);
		jScrollPane.setBounds(5, 42, 576, 215);
		contentPane.add(jScrollPane);
		
		rdbtnCompleto = new JRadioButton("Completo");
		rdbtnCompleto.setBounds(5, 7, 89, 23);
		rdbtnCompleto.setSelected( true );
		contentPane.add(rdbtnCompleto);
		
		rdbtnParcial = new JRadioButton("Parcial");
		rdbtnParcial.setBounds(98, 7, 71, 23);
		contentPane.add(rdbtnParcial);
		
		ButtonGroup btngrp = new ButtonGroup();
		btngrp.add( rdbtnCompleto );
		btngrp.add( rdbtnParcial );
		
		rdbtnCompleto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//if( !rdbtnCompleto.isSelected() )
					cargarTabla();
			}
		});
		
		rdbtnParcial.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//if( !rdbtnParcial.isSelected() )
					cargarTabla();
			}
		});
		
		cargarTabla();
	}
	
	private void cargarTabla() {
		System.out.println("cargo");
		Object[][] data = null;
		Object[] titles = null;
		int i = 0;
		List<VOEgresado> lvoe;

		if( rdbtnCompleto.isSelected() ) {
			lvoe = controlador.Escolaridad( true );
			data = new Object[lvoe.size()][];
			for( VOEgresado voe: lvoe ) {
				data[i] = new Object[] { voe.getCedula(), voe.getNombre(), voe.getApellido(), voe.getPromedioCalificacion(), voe.getPromedioAprobacion() };
				i++;
			}
			titles = new Object[] { "Cédula", "Nombre", "Apellido", "Prom. Total", "Prom. Aprovaciones" };
				
		}else {
			lvoe = controlador.Escolaridad( false );
			data = new Object[lvoe.size()][];
			for( VOEgresado voe: lvoe ) {				
				data[i] = new Object[] { voe.getCedula(), voe.getNombre(), voe.getApellido() };
				titles = new Object[] { "Cédula", "Nombre", "Apellido" };
				i++;
			}
		}
		
		table.setModel( new DefaultTableModel(data, titles){
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			}  );
		table.repaint();
	}

}
