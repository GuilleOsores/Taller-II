package grafica.ventana;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import grafica.controlador.ControladorMenuPrincipal;
import grafica.ventana.alumno.AlumnoEscolaridad;
import grafica.ventana.alumno.AlumnoNuevo;
import grafica.ventana.alumno.AlumnoPorCedula;
import grafica.ventana.alumno.AlumnosListado;
import grafica.ventana.alumno.EgresadosListado;
import grafica.ventana.asignatura.AsignaturaListado;
import grafica.ventana.asignatura.AsignaturaNueva;
import grafica.ventana.inscripciones.InscripcionesListado;
import grafica.ventana.inscripciones.InscripcionesMontoRecaudado;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;

public class VentanaMenu extends Ventana {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	ControladorMenuPrincipal controlador;

	private AsignaturaNueva asignaturaNueva;
	private AsignaturaListado asignaturaListado;
	private AlumnoNuevo alumnoNuevo;
	private AlumnoPorCedula alumnoPorCedula;
	private AlumnosListado alumnosListado;
	private EgresadosListado egresadosListado;
	private InscripcionesListado inscripcionesListado;
	private InscripcionesMontoRecaudado inscripcionesMontoRecaudado;
	private AlumnoEscolaridad alumnoEscolaridad;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMenu frame = new VentanaMenu();
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
	public VentanaMenu() {
		setTitle("Chef Gourmet Uruguay");

		controlador = new ControladorMenuPrincipal(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setName("Chef Gourmet Uruguay"); 

		JMenuBar menu = new JMenuBar();
		menu.setBounds(0, 0, 0, 0);
		contentPane.add(menu, BorderLayout.NORTH);


		JMenu asignaturas = new JMenu("Asignaturas");
		asignaturas.setForeground(new Color(0, 128, 128));
		asignaturas.setFont(new Font("Segoe UI Emoji", Font.BOLD, 15));
		asignaturas.setBackground(new Color(240, 255, 240));
		asignaturas.setHorizontalAlignment(SwingConstants.CENTER);
		menu.add(asignaturas);

		JMenu alumnos = new JMenu("Alumnos");
		alumnos.setForeground(new Color(0, 128, 128));
		alumnos.setFont(new Font("Segoe UI Emoji", Font.BOLD, 15));
		alumnos.setHorizontalAlignment(SwingConstants.CENTER);
		alumnos.setBackground(new Color(240, 255, 240));
		menu.add(alumnos);

		JMenu inscripciones = new JMenu("Inscripciones/ Escolaridad");
		inscripciones.setForeground(new Color(0, 128, 128));
		inscripciones.setFont(new Font("Segoe UI Emoji", Font.BOLD, 15));
		inscripciones.setHorizontalAlignment(SwingConstants.CENTER);
		inscripciones.setBackground(new Color(240, 255, 240));
		menu.add(inscripciones);

		//Asignaturas
		JMenuItem mnRegistrarAsignatrua = new JMenuItem("Registrar Asignatura");
		mnRegistrarAsignatrua.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				mnRegistrarAsignatruaActionPerformed(e);
			}
		});
		asignaturas.add(mnRegistrarAsignatrua);

		JMenuItem mnListarAsignatrua = new JMenuItem("Listar Asignatura");
		mnListarAsignatrua.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				mnListarAsignatruaActionPerformed(e);
			}
		});
		asignaturas.add(mnListarAsignatrua);

		//Alumnos
		JMenuItem mnRegistrarAlumno = new JMenuItem("Registrar Alumno");
		mnRegistrarAlumno.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				mnRegistrarAlumnoActionPerformed(e);
			}
		});
		alumnos.add(mnRegistrarAlumno);

		JMenuItem mnModificarAlumno = new JMenuItem("Modificar Alumno");
		mnModificarAlumno.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				mnModificarAlumnoActionPerformed(e);
			}
		});
		alumnos.add(mnModificarAlumno);

		JMenuItem mnListarAlumno = new JMenuItem("Listar Alumnos Apellido");
		mnListarAlumno.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				mnListarAlumnoActionPerformed(e);
			}
		});
		alumnos.add(mnListarAlumno);

		JMenuItem mnDetalleAlumno = new JMenuItem("Detalle Alumno");
		mnDetalleAlumno.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				mnDetalleAlumnoActionPerformed(e);
			}
		});
		alumnos.add(mnDetalleAlumno);

		//Inscripciones
		JMenuItem mnRegistrarInscripcion = new JMenuItem("Registrar Inscripcion");
		mnRegistrarInscripcion.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				mnRegistrarInscripcionActionPerformed(e);
			}
		});
		inscripciones.add(mnRegistrarInscripcion);

		JMenuItem mnRegistrarCalificacion = new JMenuItem("Calificar/ Listar Escolaridad");
		mnRegistrarCalificacion.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				mnRegistrarCalificacionActionPerformed(e);
			}
		});
		inscripciones.add(mnRegistrarCalificacion);

		JMenuItem mnCalcularMonto = new JMenuItem("Calcular Monto");
		mnCalcularMonto.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				mnCalcularMontoActionPerformed(e);
			}
		});
		inscripciones.add(mnCalcularMonto);


		JMenu egresados = new JMenu("Egresados");
		egresados.setForeground(new Color(0, 128, 128));
		egresados.setFont(new Font("Segoe UI Emoji", Font.BOLD, 15));
		egresados.setBackground(new Color(240, 255, 240));
		egresados.setHorizontalAlignment(SwingConstants.CENTER);
		menu.add(egresados);

		JMenuItem itemEgresados = new JMenuItem("Listado Egresados");
		itemEgresados.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				itemEgresadosActionPerformed(e);
			}
		});
		egresados.add(itemEgresados);




		//JMenuItem itemRespaldar = new JMenuItem("Respaldar Datos");
		//itemRespaldar.setFont(new Font("Segoe UI Emoji", Font.BOLD, 15));
		//itemRespaldar.setHorizontalAlignment(SwingConstants.LEFT);
		//itemRespaldar.setForeground(new Color(0, 128, 128));
		//itemRespaldar.setBackground(new Color(240, 255, 240));
		//itemRespaldar.addActionListener(new ActionListener() {
		//	public void actionPerformed(ActionEvent e) {
		//		itemRespaldarActionPerformed(e);
		//	}
		//});
		//menu.add(itemRespaldar);

		JMenu respaldar = new JMenu("Respaldos");
		respaldar.setForeground(new Color(0, 128, 128));
		respaldar.setFont(new Font("Segoe UI Emoji", Font.BOLD, 15));
		respaldar.setBackground(new Color(240, 255, 240));
		respaldar.setHorizontalAlignment(SwingConstants.CENTER);
		menu.add(respaldar);

		JMenuItem itemRespaldar = new JMenuItem("Respaldo de datos");
		itemRespaldar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				itemRespaldarActionPerformed(e);
			}
		});
		respaldar.add(itemRespaldar);


	}



	//ACCCION DE ITEMRESPALDAR

	private void itemRespaldarActionPerformed(ActionEvent e) {
		controlador.respaldar();

	}


	//ACCCION DE ITEMEGRESADOS
	private void itemEgresadosActionPerformed(ActionEvent e) {
		if (egresadosListado  != null)
			egresadosListado.dispose(); 
		egresadosListado  = new EgresadosListado();
		egresadosListado.setVisible(true); 

	}

	//ACCION DE  mnRegistrarAsignatrua REGISTRAR ASIGNATURA
	private void mnRegistrarAsignatruaActionPerformed(ActionEvent e) {
		if (asignaturaNueva  != null)
			asignaturaNueva.dispose(); 
		asignaturaNueva  = new AsignaturaNueva();
		asignaturaNueva.setVisible(true);


	}

	//ACCION DE  mnListarAsignatrua LISTAR ASIGNATURA
	private void mnListarAsignatruaActionPerformed(ActionEvent e) {
		if (asignaturaListado  != null)
			asignaturaListado.dispose(); 
		asignaturaListado  = new AsignaturaListado();
		asignaturaListado.setVisible(true);

	}

	//ACCION DE  mnRegistrarAlumno REGISTRAR ALUMNO 
	private void mnRegistrarAlumnoActionPerformed(ActionEvent e) {
		if (alumnoNuevo  != null)
			alumnoNuevo.dispose(); 
		alumnoNuevo  = new AlumnoNuevo();
		alumnoNuevo.setVisible(true);

	}

	//ACCION DE  mnModificarAlumno MODIFICAR ALUMNO
	private void mnModificarAlumnoActionPerformed(ActionEvent e) {
		if (alumnosListado  != null)
			alumnosListado.dispose(); 
		alumnosListado  = new AlumnosListado();
		alumnosListado.setVisible(true);

	}

	//ACCION DE  mnListadoAlumno LISTAR ALUMNO POR APELLIDO
	private void mnListarAlumnoActionPerformed(ActionEvent e) {
		if (alumnosListado  != null)
			alumnosListado.dispose();
		alumnosListado   = new AlumnosListado();
		alumnosListado.setVisible(true);

	}

	//ACCION DE  mnDetalleAlumno  ALUMNO DETALLADO  
	private void mnDetalleAlumnoActionPerformed(ActionEvent e) {
		if (alumnoPorCedula  != null)
			alumnoPorCedula.dispose();
		alumnoPorCedula   = new AlumnoPorCedula();
		alumnoPorCedula.setVisible(true);

	}


	//ACCION DE  mnRegistrarInscripcion REGISTRAR INSCRIPCION
	private void mnRegistrarInscripcionActionPerformed(ActionEvent e) {
		if (inscripcionesListado  != null)
			inscripcionesListado.dispose();
		inscripcionesListado   = new InscripcionesListado();
		inscripcionesListado.setVisible(true);

	}

	//ACCION DE  mnRegistrarCalificacion REGISTRAR CALIFICACION
	private void mnRegistrarCalificacionActionPerformed(ActionEvent e) {
		if (inscripcionesListado  != null)
			inscripcionesListado.dispose();
		inscripcionesListado  = new InscripcionesListado();
		inscripcionesListado.setVisible(true);

	}

	//ACCION DE  mnCalcularMonto CALCULAR MONTO POR INSCRIPCIONES  
	private void mnCalcularMontoActionPerformed(ActionEvent e) {
		if (inscripcionesMontoRecaudado   != null)
			inscripcionesMontoRecaudado.dispose();
		inscripcionesMontoRecaudado  = new InscripcionesMontoRecaudado();
		inscripcionesMontoRecaudado.setVisible(true);

	}
}
