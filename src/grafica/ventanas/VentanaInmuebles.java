package grafica.ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import java.awt.TextArea;
import javax.swing.JTextArea;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.Button;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.BoxLayout;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import grafica.controladores.ControladorComparar;
import grafica.controladores.ControladorDelete;
import grafica.controladores.ControladorInsert;
import grafica.controladores.ControladorList;
import grafica.controladores.ControladorUpdate;
import logicapersistencia.valueObjects.VOMonedaLista;
import logicapersistencia.valueObjects.VOinmueble;

import java.awt.Label;

public class VentanaInmuebles extends JFrame {

	private DefaultTableModel modelo;
	Icon img = new ImageIcon(getClass().getResource("uy2.png"));
	private Fondo contentPane;
	private JTextField textField_Direccion;
	private JTextField textField_Padron;
	public JTextField textField_NombrePersona;
	private JTextField textField_TelContacto;
	private JTextField textField_Email;
	
	VentanaApartamentos ventanaAptos = new VentanaApartamentos();
	VentanaCasas ventanaCasas = new VentanaCasas();
	VentanaTerreno ventanaTerreno = new VentanaTerreno();
	private JTextField textField_Antiguedad;
	private JTextField textFieldRef_Inmueble;
	JTextArea textArea_Estado = new JTextArea();
	private JTextField textField_PrecioLista;
	private JTextField textField_ContribucionInmobiliaria;
	private JTextField textField_AreaTotal;
	private JTextField textField_idPersona;
	private JTextField textField_idCliente;
	private JTextField textField_DetalleTel;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInmuebles frame = new VentanaInmuebles();
					frame.setVisible(true);
					frame.setResizable(false); //DEJA ESTÁTICA EL TAMAÑO DE LA VENTANA
					frame.setExtendedState(MAXIMIZED_BOTH);// maximisa la ventana
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	public VentanaInmuebles() {
		setBackground(UIManager.getColor("Button.foreground"));
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaInmuebles.class.getResource("/grafica/ventanas/uy2.png")));
		setTitle("Ingreso de inmueble");
		
		
		
		JLabel label_Asterisco1 = new JLabel("*");
		JLabel label_Asterisco2 = new JLabel("*");
		JLabel label_Asterisco3 = new JLabel("*");
		JLabel label_Asterisco4 = new JLabel("*");
	    JLabel label_Asterisco11 = new JLabel("*");
	    JLabel label_Asterisco12 = new JLabel("*");
	    JLabel label_Asterisco28 = new JLabel("*");
	    JLabel label_Asterisco27 = new JLabel("*");
	    JLabel label_Asterisco29 = new JLabel("*");
	       
	       JLabel label_Asterisco26 = new JLabel("*");
	       JLabel label_Asterisco25 = new JLabel("*");
	       JLabel label_Asterisco10 = new JLabel("*");
	       JLabel label_Asterisco6 = new JLabel("*");
	       JLabel label_Asterisco7 = new JLabel("*");
	       JLabel label_Asterisco8 = new JLabel("*");
	       
	       label_Asterisco1.setVisible(false);
			label_Asterisco2.setVisible(false);
			label_Asterisco3.setVisible(false);
			label_Asterisco4.setVisible(false);
			label_Asterisco6.setVisible(false);
			label_Asterisco7.setVisible(false);
			label_Asterisco8.setVisible(false);
			label_Asterisco10.setVisible(false);
			label_Asterisco25.setVisible(false);
			label_Asterisco26.setVisible(false);
			label_Asterisco27.setVisible(false);
			label_Asterisco28.setVisible(false);
			label_Asterisco29.setVisible(false);
			label_Asterisco11.setVisible(false);
			label_Asterisco12.setVisible(false);


		JComboBox comboBoxEstadoConservacion = new JComboBox();
		JDateChooser dateChooserFechaIngreso = new JDateChooser();
		dateChooserFechaIngreso.setDateFormatString("dd/MM/yyyy");
		JComboBox comboBox_precioLista = new JComboBox();
		
		
		//--------------------------------TRAE LA TABLA AL COMBOBOX--------------------------------------//
				ControladorList controladorComboBox3 = new ControladorList();
				List<VOMonedaLista> lstSeccion = controladorComboBox3.listarMonedaLista();
						
				Iterator<VOMonedaLista> iterSecciones = lstSeccion.iterator();
				while (iterSecciones.hasNext()){
				VOMonedaLista dataMonedaLista = iterSecciones.next();
				comboBox_precioLista.addItem(dataMonedaLista.getMonedaLista());
				}
		
		textField_AreaTotal = new JTextField();
		
		textField_AreaTotal.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					
						char c = arg0.getKeyChar();
						if (c<'0'|| c>'9'){ 
							arg0.consume();
						}
						if(textField_AreaTotal.getText().length()>=9){
							arg0.consume();

					}

				}
			});
		
		
	       textField_ContribucionInmobiliaria = new JTextField();
	       
	       textField_ContribucionInmobiliaria.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					
						char c = arg0.getKeyChar();
						if (c<'0'|| c>'9'){ 
							arg0.consume();
						}
						if(textField_ContribucionInmobiliaria.getText().length()>=9){
							arg0.consume();

					}

				}
			});
	       
	       
	       
	       textFieldRef_Inmueble = new JTextField();
	       
	       textFieldRef_Inmueble.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					
						char c = arg0.getKeyChar();
						if (c<'0'|| c>'9'){ 
							arg0.consume();
						}
						if(textFieldRef_Inmueble.getText().length()>=9){
							arg0.consume();

					}

				}
			});
	       
	       
	       JCheckBox chckbxExclusividad = new JCheckBox("Exclusividad");
	       JComboBox comboBox_Estado = new JComboBox();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(30, 30, 1313, 773);
		contentPane = new Fondo("sextoFondo.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		textArea_Estado.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				if(textArea_Estado.getText().length()>=30){
					arg0.consume();
				}
				
				char TipoDeTecla =arg0.getKeyChar();
				if(Character.isDigit(TipoDeTecla)){
					arg0.consume();
				}
				
			}
		});
		
		//------------------------------------ FLECHA CON ACCION ------------------------------//
	       
	       JLabel label_Flecha = new JLabel("");
	       label_Flecha.setBounds(28, 507, 56, 62);
	       ImageIcon imagen4 = new ImageIcon(VentanaCasas.class.getResource("flecha.png"));
	       Image imag4 = imagen4.getImage().getScaledInstance(label_Flecha.getWidth(), label_Flecha.getHeight(), Image.SCALE_SMOOTH);
	       
	       			label_Flecha.setIcon(new ImageIcon(imag4));
	       			
	       			label_Flecha.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                VentanaPrincipal frameVentanaPrincipal = new VentanaPrincipal();
	                frameVentanaPrincipal.setVisible(true);
	                dispose();
	            }

	        });
	       			
	       			contentPane.add(label_Flecha);
	       			
	       			
	       			
	     	       
	     	       //---------------------------------------------------------------------------------------------//
		
		JPanel panel_4 = new JPanel();
		panel_4.setForeground(new Color(0, 0, 0));
		panel_4.setBackground(new Color(0, 0, 0));
		panel_4.setOpaque(true);
		panel_4.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "  Detalle Inmueble   ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel_4.setBounds(930, 30, 367, 275);
		contentPane.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_4.add(scrollPane_1);
		
		JTextArea textArea_Detalle = new JTextArea();
		
		textArea_Detalle.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				if(textArea_Detalle.getText().length()>=400){
					arg0.consume();
				}
				
			}
		});
		
		
		textArea_Detalle.setFont(new Font("Monospaced", Font.BOLD, 13));
		scrollPane_1.setViewportView(textArea_Detalle);
		
		JPanel panel_8 = new JPanel();
		panel_8.setForeground(new Color(0, 0, 0));
		panel_8.setBackground(new Color(0, 0, 0));
		panel_8.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_8.setOpaque(true);
		panel_8.setBounds(47, 136, 869, 94);
		contentPane.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblFechaIngreso = new JLabel("Fecha Ingreso:");
		lblFechaIngreso.setBounds(39, 23, 102, 23);
		lblFechaIngreso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaIngreso.setForeground(Color.WHITE);
		lblFechaIngreso.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel_8.add(lblFechaIngreso);
		
		JLabel lblPadrn = new JLabel("Padr\u00F3n:");
		lblPadrn.setBounds(70, 57, 67, 23);
		lblPadrn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPadrn.setForeground(Color.WHITE);
		lblPadrn.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_8.add(lblPadrn);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setBounds(318, 23, 91, 23);
		lblDireccin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccin.setForeground(Color.WHITE);
		lblDireccin.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_8.add(lblDireccin);
		
		JLabel lblBarrio = new JLabel("Barrio:");
		lblBarrio.setBounds(318, 47, 91, 23);
		lblBarrio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBarrio.setForeground(Color.WHITE);
		lblBarrio.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_8.add(lblBarrio);
		
		JLabel lblDepartamento = new JLabel("Departamento:");
		lblDepartamento.setBounds(582, 47, 113, 23);
		lblDepartamento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDepartamento.setForeground(Color.WHITE);
		lblDepartamento.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_8.add(lblDepartamento);
		
		textField_Direccion = new JTextField();
		
		textField_Direccion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				if(textField_Direccion.getText().length()>=30){
					arg0.consume();
				}
				
				char TipoDeTecla =arg0.getKeyChar();
				if(Character.isDigit(TipoDeTecla)){
					arg0.consume();
				}
				
			}
		});
		
		
		
		textField_Direccion.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_Direccion.setBounds(419, 23, 405, 20);
		textField_Direccion.setColumns(10);
		panel_8.add(textField_Direccion);
		
		JComboBox comboBox_Barrio = new JComboBox();
		comboBox_Barrio.setModel(new DefaultComboBoxModel(new String[] {"", "Aguada", "Aires Puros", "Atahualpa", "Ba\u00F1ados de Carrasco", "Barrio Sur", "Belvedere,\u00A0Paso Molino", "Brazo Oriental", "Buceo", "Capurro,\u00A0Bella Vista,\u00A0Arroyo Seco", "Carrasco", "Carrasco Norte", "Casab\u00F3,\u00A0Pajas Blancas", "Casavalle", "Castro,\u00A0P\u00E9rez Castellanos", "Centro", "Cerrito de la Victoria", "Ciudad Vieja", "Col\u00F3n Centro y Noroeste", "Col\u00F3n Sureste,\u00A0Abayub\u00E1", "Conciliaci\u00F3n", "Cord\u00F3n", "Flor de Maro\u00F1as", "Ituzaing\u00F3", "Jacinto Vera", "Jardines del Hip\u00F3dromo", "La Blanqueada", "La Comercial", "La Figurita", "La Paloma,\u00A0Tomkinson", "La Teja", "Larra\u00F1aga", "Las Acacias", "Las Canteras", "Lezica,\u00A0Melilla", "Malv\u00EDn", "Malv\u00EDn Norte", "Manga", "Manga,\u00A0Toledo Chico", "Maro\u00F1as,\u00A0Parque Guaran\u00ED", "Mercado Modelo,\u00A0Bol\u00EDvar", "Nuevo Par\u00EDs", "Palermo", "Parque Batlle,\u00A0Villa Dolores", "Parque Rod\u00F3", "Paso de la Arena,\u00A0Santiago V\u00E1zquez", "Paso de las Duranas", "Pe\u00F1arol,\u00A0Lavalleja", "Piedras Blancas", "Pocitos", "Prado,\u00A0Nueva Savona", "Punta Carretas", "Punta de Rieles,\u00A0Bella Italia", "Punta Gorda", "Reducto", "Sayago", "Tres Cruces", "Tres Omb\u00FAes,\u00A0Pueblo Victoria", "Uni\u00F3n", "Villa del Cerro", "Villa Espa\u00F1ola", "Villa Garc\u00EDa,\u00A0Manga Rural", "Villa Mu\u00F1oz,\u00A0Retiro,\u00A0Goes"}));
		comboBox_Barrio.setBounds(419, 49, 138, 21);
		panel_8.add(comboBox_Barrio);
		
		JComboBox comboBox_Departamento = new JComboBox();
		comboBox_Departamento.setModel(new DefaultComboBoxModel(new String[] {"", "Artigas", "Canelones", "Cerro Largo", "Colonia", "Durazno", "Flores", "Florida", "Lavalleja", "Maldonado", "Montevideo", "Paysand\u00FA", "Rivera", "Rocha", "R\u00EDo Negro", "Salto map", "San Jos\u00E9", "Soriano", "Tacuaremb\u00F3", "Treinta y Tres"}));
		comboBox_Departamento.setBounds(705, 49, 119, 21);
		panel_8.add(comboBox_Departamento);
		
		textField_Padron = new JTextField();
		

		textField_Padron.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
					char c = arg0.getKeyChar();
					if (c<'0'|| c>'9'){ 
						arg0.consume();
					}
					if(textField_Padron.getText().length()>=9){
						arg0.consume();

				}

			}
		});
		
		
		textField_Padron.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_Padron.setColumns(10);
		textField_Padron.setBounds(147, 58, 119, 20);
		panel_8.add(textField_Padron);
		
		JPanel panel_9 = new JPanel();
		panel_9.setForeground(new Color(0, 0, 0));
		panel_9.setBackground(new Color(0, 0, 0));
		panel_9.setOpaque(true);
		panel_9.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "  Datos Contacto    ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel_9.setBounds(47, 248, 607, 296);
		contentPane.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(50, 61, 80, 23);
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_9.add(lblNombre);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setBounds(50, 85, 80, 23);
		lblTelfono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelfono.setForeground(Color.WHITE);
		lblTelfono.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_9.add(lblTelfono);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(295, 85, 70, 23);
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_9.add(lblEmail);
		
		textField_NombrePersona = new JTextField();
		textField_NombrePersona.setBounds(163, 61, 391, 20);
		
		
		textField_NombrePersona.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				if(textField_NombrePersona.getText().length()>=30){
					arg0.consume();
				}
				
				char TipoDeTecla =arg0.getKeyChar();
				if(Character.isDigit(TipoDeTecla)){
					arg0.consume();
				}
				
			}
		});
		
		textField_NombrePersona.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_NombrePersona.setColumns(10);
		panel_9.add(textField_NombrePersona);
		
		textField_TelContacto = new JTextField();
		textField_TelContacto.setBounds(163, 85, 103, 20);
		
		textField_TelContacto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
					char c = arg0.getKeyChar();
					if (c<'0'|| c>'9'){ 
						arg0.consume();
					}
					if(textField_TelContacto.getText().length()>=20){
						arg0.consume();

				}

			}
		});
		
			
		
		
		textField_TelContacto.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_TelContacto.setColumns(10);
		panel_9.add(textField_TelContacto);
		
		textField_Email = new JTextField();
		
		textField_Email.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				if(textField_Email.getText().length()>=30){
					arg0.consume();
				}
				
								
			}
		});
		
		textField_Email.setBounds(375, 87, 179, 20);
		textField_Email.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_Email.setColumns(10);
		panel_9.add(textField_Email);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setOpaque(true);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(930, 418, 367, 126);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Button button_2 = new Button("Cerrar");
		button_2.setBounds(202, 65, 142, 32);
		panel.add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
			}
		});
		button_2.setForeground(Color.RED);
		button_2.setFont(new Font("Dialog", Font.BOLD, 14));
		
		Button button_1 = new Button("Eliminar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ref0 =textFieldRef_Inmueble.getText();
				int ref = Integer.parseInt(ref0);
				
				int resp=JOptionPane.showConfirmDialog(null,"¿Quiere borrar el registro Ref Nº"+ ref +"?","Mensaje",JOptionPane.ERROR_MESSAGE);
			      if (JOptionPane.OK_OPTION == resp){
			    	  
			    	  ControladorDelete controladorBorrar = new ControladorDelete();
			    	  try {
						controladorBorrar.eliminarInmueble(ref);
						JOptionPane.showMessageDialog(null, "Has borrado correctamente el registro. \nGracias por su tiempo","Mensaje",JOptionPane.ERROR_MESSAGE, img);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			    	  
			   
			 }
			      else{
			    	  JOptionPane.showMessageDialog(null, "Se ha cancelado la operación. \nGracias por su tiempo");
			   }

				
				
			}
		});
		button_1.setBounds(202, 20, 142, 32);
		panel.add(button_1);
		button_1.setFont(new Font("Dialog", Font.BOLD, 14));
		
		Button button = new Button("Actualizar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ControladorList controladorList = new ControladorList();
				
				try {
				String refInmueble0=textFieldRef_Inmueble.getText();
	       		int refInmueble=Integer.parseInt(refInmueble0);
	       		String tipoMonedaPrecioLista0=(String)comboBox_precioLista.getSelectedItem();
	       		int tipoMonedaPrecioLista;
				
					tipoMonedaPrecioLista = controladorList.obtenerIdMonedaLista(tipoMonedaPrecioLista0);
				
	       		String precioLista0=textField_PrecioLista.getText();
	       		int precioLista = Integer.parseInt(precioLista0);
	       		String contribucionInmobiliaria0=textField_ContribucionInmobiliaria.getText();
	       		int contribucionInmobiliaria=Integer.parseInt(contribucionInmobiliaria0);
	       		String areaTotal0=textField_AreaTotal.getText();
	       		int areaTotal= Integer.parseInt(areaTotal0);
	       		String exclusividad;
	       			if(chckbxExclusividad.isSelected()){
	       			 exclusividad="SI";
	       			}else{
	       			exclusividad ="NO";}
	       		
	       		String estadoDisponibilidad=(String)comboBox_Estado.getSelectedItem();
	       		String fechaIngreso=((JTextField)dateChooserFechaIngreso.getDateEditor().getUiComponent()).getText();
	       		String direccion=textField_Direccion.getText();
	       		String padron0 = textField_Padron.getText();
	       		int padron = Integer.parseInt(padron0);
	       		String barrio=(String) comboBox_Barrio.getSelectedItem();
	       		String departamento=(String) comboBox_Departamento.getSelectedItem();
	       		String estadoDetalle=textArea_Estado.getText();
	       		String detalleInmueble=textArea_Detalle.getText();
	       		String antiguedad0= textField_Antiguedad.getText();
	       		int antiguedad=Integer.parseInt(antiguedad0);
	       		
	       		String estadoConservacion =(String)comboBoxEstadoConservacion.getSelectedItem();
   				
				
				
				ControladorUpdate controladorUpdate = new ControladorUpdate();
				
					controladorUpdate.updateInmueble2(refInmueble, tipoMonedaPrecioLista, 
							precioLista, contribucionInmobiliaria, areaTotal, exclusividad, 
							estadoDisponibilidad, fechaIngreso, direccion, padron, barrio, 
							departamento, estadoDetalle, detalleInmueble, antiguedad, 
							estadoConservacion);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		button.setBounds(28, 20, 141, 32);
		panel.add(button);
		button.setFont(new Font("Dialog", Font.BOLD, 14));
		
		Button button_3 = new Button("Resetear");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textFieldRef_Inmueble.setText("");
				comboBox_precioLista.setSelectedItem("");
				textField_PrecioLista.setText("");
				textField_ContribucionInmobiliaria.setText("");
				textField_AreaTotal.setText("");
				chckbxExclusividad.setText("");
				comboBox_Estado.setSelectedItem("");
				dateChooserFechaIngreso.setDate(null);
				textField_Direccion.setText("");
				textField_Padron.setText("");
				comboBox_Barrio.setSelectedItem("");
				comboBox_Departamento.setSelectedItem("");
				textArea_Estado.setText("");
				comboBox_precioLista.setSelectedItem("");
				textArea_Detalle.setText("");
				textField_Antiguedad.setText("");	
				
				
			}
		});
		button_3.setFont(new Font("Dialog", Font.BOLD, 14));
		button_3.setBounds(28, 65, 141, 32);
		panel.add(button_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(664, 249, 252, 295);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
		comboBoxEstadoConservacion.setModel(new DefaultComboBoxModel(new String[] {"", "malo", "regular", "bueno", "muy bueno", "excelente"}));
		comboBoxEstadoConservacion.setBounds(23, 97, 179, 21);
		panel_1.add(comboBoxEstadoConservacion);
		
		JLabel lblEstadoDeConservacin = new JLabel("Estado de Conservaci\u00F3n:");
		lblEstadoDeConservacin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstadoDeConservacin.setForeground(Color.WHITE);
		lblEstadoDeConservacin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEstadoDeConservacin.setBounds(23, 73, 160, 23);
		panel_1.add(lblEstadoDeConservacin);
		
		JLabel lblAntigedad = new JLabel("Antig\u00FCedad:");
		lblAntigedad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAntigedad.setForeground(Color.WHITE);
		lblAntigedad.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAntigedad.setBounds(10, 32, 94, 23);
		panel_1.add(lblAntigedad);
		
		textField_Antiguedad = new JTextField();
		
		
		textField_Antiguedad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
					char c = arg0.getKeyChar();
					if (c<'0'|| c>'9'){ 
						arg0.consume();
					}
					if(textField_Antiguedad.getText().length()>=4){
						arg0.consume();

				}

			}
		});
		
		
		textField_Antiguedad.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_Antiguedad.setColumns(10);
		textField_Antiguedad.setBounds(114, 34, 88, 20);
		panel_1.add(textField_Antiguedad);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 129, 179, 125);
		panel_1.add(scrollPane);
		
		
		textArea_Estado.setFont(new Font("Monospaced", Font.BOLD, 13));
		scrollPane.setViewportView(textArea_Estado);
	       	       
	       
		
		
		
		
		//************************************************ SOMBRAS ******************************//
		
		 JFrame frame = new JFrame();
	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     
	     
	     GhostText ghostText = new GhostText(textField_Direccion, "Ej. Benito Blanco 123 ...");
	     textField_Direccion.setPreferredSize(new Dimension(300, 24));
	       
	       GhostText ghostText2 = new GhostText(textField_Padron, "Ej. 860...");
	       textField_Padron.setPreferredSize(new Dimension(300, 24));
	       
	      
	       dateChooserFechaIngreso.setBounds(147, 26, 119, 20);
	       panel_8.add(dateChooserFechaIngreso);
	       
	       label_Asterisco6.setForeground(Color.RED);
	       label_Asterisco6.setFont(new Font("Tahoma", Font.BOLD, 18));
	       label_Asterisco6.setBounds(834, 27, 25, 14);
	       panel_8.add(label_Asterisco6);
	       
	       label_Asterisco7.setForeground(Color.RED);
	       label_Asterisco7.setFont(new Font("Tahoma", Font.BOLD, 18));
	       label_Asterisco7.setBounds(834, 52, 25, 14);
	       panel_8.add(label_Asterisco7);
	       
	     
	       label_Asterisco29.setForeground(Color.RED);
	       label_Asterisco29.setFont(new Font("Tahoma", Font.BOLD, 18));
	       label_Asterisco29.setBounds(571, 57, 25, 14);
	       panel_8.add(label_Asterisco29);
	       
	       label_Asterisco8.setForeground(Color.RED);
	       label_Asterisco8.setFont(new Font("Tahoma", Font.BOLD, 18));
	       label_Asterisco8.setBounds(276, 32, 25, 14);
	       panel_8.add(label_Asterisco8);
	       

	       label_Asterisco10.setForeground(Color.RED);
	       label_Asterisco10.setFont(new Font("Tahoma", Font.BOLD, 18));
	       label_Asterisco10.setBounds(276, 62, 25, 14);
	       panel_8.add(label_Asterisco10);
	       textField_NombrePersona.setPreferredSize(new Dimension(300, 24));
	       
	       GhostText ghostText4 = new GhostText(textField_NombrePersona, "Ej. Martín Rodriguez ...");
	       textField_NombrePersona.setPreferredSize(new Dimension(300, 24));
	       
	       GhostText ghostText5 = new GhostText(textField_TelContacto, "");
	       textField_TelContacto.setPreferredSize(new Dimension(300, 24));
	       
	       GhostText ghostText6 = new GhostText(textField_Email, "Ej. ejemplo@gmail.com ...");
	       textField_Email.setPreferredSize(new Dimension(300, 24));
	       
	       JLabel lblIdPersona = new JLabel("id Persona:");
	       lblIdPersona.setBounds(36, 27, 94, 23);
	       lblIdPersona.setHorizontalAlignment(SwingConstants.RIGHT);
	       lblIdPersona.setForeground(Color.WHITE);
	       lblIdPersona.setFont(new Font("Tahoma", Font.BOLD, 13));
	       panel_9.add(lblIdPersona);
	       
	       textField_idPersona = new JTextField();
	       
	       textField_idPersona.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					
						char c = arg0.getKeyChar();
						if (c<'0'|| c>'9'){ 
							arg0.consume();
						}
						if(textField_idPersona.getText().length()>=9){
							arg0.consume();

					}

				}
			});
			
	       
	       
	       textField_idPersona.setBounds(161, 29, 52, 20);
	       textField_idPersona.setPreferredSize(new Dimension(300, 24));
	       textField_idPersona.setFont(new Font("Tahoma", Font.BOLD, 12));
	       textField_idPersona.setColumns(10);
	       panel_9.add(textField_idPersona);
	       
	       textField_idCliente = new JTextField();
	       
	       textField_idCliente.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					
						char c = arg0.getKeyChar();
						if (c<'0'|| c>'9'){ 
							arg0.consume();
						}
						if(textField_idCliente.getText().length()>=9){
							arg0.consume();

					}

				}
			});
	       
	       
	       textField_idCliente.setBounds(336, 29, 52, 20);
	       textField_idCliente.setPreferredSize(new Dimension(300, 24));
	       textField_idCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
	       textField_idCliente.setColumns(10);
	       panel_9.add(textField_idCliente);
	       
	       JLabel lblIdCliente = new JLabel("id Cliente");
	       lblIdCliente.setBounds(243, 27, 80, 23);
	       lblIdCliente.setHorizontalAlignment(SwingConstants.RIGHT);
	       lblIdCliente.setForeground(Color.WHITE);
	       lblIdCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
	       panel_9.add(lblIdCliente);
	       
	       JLabel lblHorarioContacto = new JLabel("Horario Contacto:");
	       lblHorarioContacto.setBounds(20, 119, 134, 23);
	       lblHorarioContacto.setHorizontalAlignment(SwingConstants.RIGHT);
	       lblHorarioContacto.setForeground(Color.WHITE);
	       lblHorarioContacto.setFont(new Font("Tahoma", Font.BOLD, 13));
	       panel_9.add(lblHorarioContacto);
	       
	       textField_DetalleTel = new JTextField();
	       textField_DetalleTel.setBounds(164, 119, 390, 20);
	       textField_DetalleTel.setPreferredSize(new Dimension(300, 24));
	       textField_DetalleTel.setFont(new Font("Tahoma", Font.BOLD, 12));
	       textField_DetalleTel.setColumns(10);
	       panel_9.add(textField_DetalleTel);
	       
	       JLabel lblDetallePersona = new JLabel("Detalle Persona:");
	       lblDetallePersona.setBounds(50, 153, 134, 23);
	       lblDetallePersona.setHorizontalAlignment(SwingConstants.RIGHT);
	       lblDetallePersona.setForeground(Color.WHITE);
	       lblDetallePersona.setFont(new Font("Tahoma", Font.BOLD, 13));
	       panel_9.add(lblDetallePersona);
	       
	       JLabel lblDetalleContacto = new JLabel("Detalle Contacto:");
	       lblDetalleContacto.setBounds(336, 153, 134, 23);
	       lblDetalleContacto.setHorizontalAlignment(SwingConstants.RIGHT);
	       lblDetalleContacto.setForeground(Color.WHITE);
	       lblDetalleContacto.setFont(new Font("Tahoma", Font.BOLD, 13));
	       panel_9.add(lblDetalleContacto);
	       
	       JScrollPane scrollPane_2 = new JScrollPane();
	       scrollPane_2.setBounds(70, 180, 196, 87);
	       panel_9.add(scrollPane_2);
	       
	       JTextArea textArea_detallePersona = new JTextArea();
	       
	       
	       textArea_detallePersona.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {

							if(textArea_detallePersona.getText().length()>=200){
								arg0.consume();
							}
														
						}
					});
	       
	       
	       scrollPane_2.setViewportView(textArea_detallePersona);
	       
	       JScrollPane scrollPane_3 = new JScrollPane();
	       scrollPane_3.setBounds(357, 180, 196, 87);
	       panel_9.add(scrollPane_3);
	       
	       JTextArea textArea_detalleContacto = new JTextArea();
	       
	       textArea_detalleContacto.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {

							if(textArea_detalleContacto.getText().length()>=200){
								arg0.consume();
							}							
						}
					});
	       
	       
	       scrollPane_3.setViewportView(textArea_detalleContacto);
	       
	       JSeparator separator = new JSeparator();
	       separator.setBounds(309, 166, 14, 101);
	       separator.setOrientation(SwingConstants.VERTICAL);
	       panel_9.add(separator);
	       

	       label_Asterisco25.setFont(new Font("Tahoma", Font.BOLD, 18));
	       label_Asterisco25.setForeground(Color.RED);
	       label_Asterisco25.setBounds(223, 32, 26, 14);
	       panel_9.add(label_Asterisco25);

	       label_Asterisco26.setForeground(Color.RED);
	       label_Asterisco26.setFont(new Font("Tahoma", Font.BOLD, 18));
	       label_Asterisco26.setBounds(398, 32, 26, 14);
	       panel_9.add(label_Asterisco26);
	       

	       label_Asterisco27.setForeground(Color.RED);
	       label_Asterisco27.setFont(new Font("Tahoma", Font.BOLD, 18));
	       label_Asterisco27.setBounds(564, 66, 26, 14);
	       panel_9.add(label_Asterisco27);
	       
	       label_Asterisco28.setForeground(Color.RED);
	       label_Asterisco28.setFont(new Font("Tahoma", Font.BOLD, 18));
	       label_Asterisco28.setBounds(276, 90, 26, 20);
	       panel_9.add(label_Asterisco28);
	       
	       GhostText ghostText7 = new GhostText(textField_Antiguedad, "Ej. 1960 ...");
	       textField_Antiguedad.setPreferredSize(new Dimension(300, 24));
	       
	       GhostTextArea ghostText8 = new GhostTextArea(textArea_Detalle, "Ej. Dos casas en un padrón ...");
	       textArea_Detalle.setPreferredSize(new Dimension(300, 24));
	       
	       GhostTextArea ghostText9 = new GhostTextArea(textArea_Estado, "Ej. Actualizar...");
	       textArea_Estado.setPreferredSize(new Dimension(300, 24));
	       
	       label_Asterisco11.setForeground(Color.RED);
	       label_Asterisco11.setFont(new Font("Tahoma", Font.BOLD, 18));
	       label_Asterisco11.setBounds(217, 37, 25, 14);
	       panel_1.add(label_Asterisco11);
	       
	       label_Asterisco12.setForeground(Color.RED);
	       label_Asterisco12.setFont(new Font("Tahoma", Font.BOLD, 18));
	       label_Asterisco12.setBounds(217, 100, 25, 14);
	       panel_1.add(label_Asterisco12);
	       
	       JPanel panel_2 = new JPanel();
	       panel_2.setOpaque(true);
	       panel_2.setForeground(Color.BLACK);
	       panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
	       panel_2.setBackground(Color.BLACK);
	       panel_2.setBounds(47, 30, 869, 94);
	       contentPane.add(panel_2);
	       panel_2.setLayout(null);
	       
	       JLabel lblPrecioLista = new JLabel("Precio Lista:");
	       lblPrecioLista.setBounds(20, 57, 88, 23);
	       lblPrecioLista.setHorizontalAlignment(SwingConstants.RIGHT);
	       lblPrecioLista.setForeground(Color.WHITE);
	       lblPrecioLista.setFont(new Font("Tahoma", Font.BOLD, 13));
	       panel_2.add(lblPrecioLista);
	       
	       JLabel lblArea = new JLabel("Area:");
	       lblArea.setBounds(342, 58, 79, 23);
	       lblArea.setHorizontalAlignment(SwingConstants.RIGHT);
	       lblArea.setForeground(Color.WHITE);
	       lblArea.setFont(new Font("Tahoma", Font.BOLD, 13));
	       panel_2.add(lblArea);
	       
	       JLabel lblEstado = new JLabel("Estado");
	       lblEstado.setBounds(584, 57, 79, 23);
	       lblEstado.setHorizontalAlignment(SwingConstants.RIGHT);
	       lblEstado.setForeground(Color.WHITE);
	       lblEstado.setFont(new Font("Tahoma", Font.BOLD, 13));
	       panel_2.add(lblEstado);
	       
	       
	       
	       comboBox_Estado.setModel(new DefaultComboBoxModel(new String[] {"Disponible", "Suspendido", "Retirado"}));
	       comboBox_Estado.setBounds(673, 59, 133, 21);
	       panel_2.add(comboBox_Estado);
	       
	       textField_PrecioLista = new JTextField();
	       
	       textField_PrecioLista.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					
						char c = arg0.getKeyChar();
						if (c<'0'|| c>'9'){ 
							arg0.consume();
						}
						if(textField_PrecioLista.getText().length()>=9){
							arg0.consume();

					}

				}
			});
	       
	       textField_PrecioLista.setBounds(200, 58, 79, 20);
	       textField_PrecioLista.setPreferredSize(new Dimension(300, 24));
	       textField_PrecioLista.setFont(new Font("Tahoma", Font.BOLD, 12));
	       textField_PrecioLista.setColumns(10);
	       panel_2.add(textField_PrecioLista);
	       
	       
	       chckbxExclusividad.setBackground(Color.BLACK);
	       chckbxExclusividad.setForeground(Color.WHITE);
	       chckbxExclusividad.setFont(new Font("Tahoma", Font.BOLD, 12));
	       chckbxExclusividad.setBounds(673, 24, 138, 23);
	       panel_2.add(chckbxExclusividad);
	       
	       JLabel lblReferencia = new JLabel("Referencia:");
	       lblReferencia.setBounds(10, 23, 94, 23);
	       panel_2.add(lblReferencia);
	       lblReferencia.setHorizontalAlignment(SwingConstants.RIGHT);
	       lblReferencia.setForeground(Color.WHITE);
	       lblReferencia.setFont(new Font("Tahoma", Font.BOLD, 13));
	       
	       
	       textFieldRef_Inmueble.setBounds(117, 25, 162, 20);
	       panel_2.add(textFieldRef_Inmueble);
	       textFieldRef_Inmueble.setPreferredSize(new Dimension(300, 24));
	       textFieldRef_Inmueble.setFont(new Font("Tahoma", Font.BOLD, 12));
	       textFieldRef_Inmueble.setColumns(10);
	       
	       
	       JLabel lblCinmob = new JLabel("C.Inmob.:");
	       lblCinmob.setHorizontalAlignment(SwingConstants.RIGHT);
	       lblCinmob.setForeground(Color.WHITE);
	       lblCinmob.setFont(new Font("Tahoma", Font.BOLD, 13));
	       lblCinmob.setBounds(321, 24, 94, 23);
	       panel_2.add(lblCinmob);
	       
	       
	       textField_ContribucionInmobiliaria.setPreferredSize(new Dimension(300, 24));
	       textField_ContribucionInmobiliaria.setFont(new Font("Tahoma", Font.BOLD, 12));
	       textField_ContribucionInmobiliaria.setColumns(10);
	       textField_ContribucionInmobiliaria.setBounds(431, 25, 94, 20);
	       panel_2.add(textField_ContribucionInmobiliaria);
	       
	       
	       textField_AreaTotal.setPreferredSize(new Dimension(300, 24));
	       textField_AreaTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
	       textField_AreaTotal.setColumns(10);
	       textField_AreaTotal.setBounds(431, 59, 94, 20);
	       panel_2.add(textField_AreaTotal);
	       
	       
	       comboBox_precioLista.setBounds(118, 59, 63, 21);
	       panel_2.add(comboBox_precioLista);
	       
	       label_Asterisco1.setFont(new Font("Tahoma", Font.BOLD, 18));
	       label_Asterisco1.setForeground(Color.RED);
	       label_Asterisco1.setBounds(823, 62, 36, 14);
	       panel_2.add(label_Asterisco1);
	       
	       label_Asterisco2.setForeground(Color.RED);
	       label_Asterisco2.setFont(new Font("Tahoma", Font.BOLD, 18));
	       label_Asterisco2.setBounds(559, 62, 46, 14);
	       panel_2.add(label_Asterisco2);
	       
	       label_Asterisco3.setForeground(Color.RED);
	       label_Asterisco3.setFont(new Font("Tahoma", Font.BOLD, 18));
	       label_Asterisco3.setBounds(305, 33, 46, 14);
	       panel_2.add(label_Asterisco3);
	       
	       label_Asterisco4.setForeground(Color.RED);
	       label_Asterisco4.setFont(new Font("Tahoma", Font.BOLD, 18));
	       label_Asterisco4.setBounds(305, 62, 46, 14);
	       panel_2.add(label_Asterisco4);
	       
	       JLabel lblM = new JLabel("m2");
	       lblM.setHorizontalAlignment(SwingConstants.LEFT);
	       lblM.setForeground(Color.WHITE);
	       lblM.setFont(new Font("Tahoma", Font.BOLD, 13));
	       lblM.setBounds(535, 57, 40, 23);
	       panel_2.add(lblM);
	       
	       JLabel lbluy = new JLabel("$UY");
	       lbluy.setHorizontalAlignment(SwingConstants.LEFT);
	       lbluy.setForeground(Color.WHITE);
	       lbluy.setFont(new Font("Tahoma", Font.BOLD, 13));
	       lbluy.setBounds(535, 24, 40, 23);
	       panel_2.add(lbluy);
	       
	       JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	       tabbedPane.setBounds(53, 581, 1234, 141);
	       contentPane.add(tabbedPane);
	       
	       JPanel panel_3 = new JPanel();
	       tabbedPane.addTab("Datos Inmueble", null, panel_3, null);
	       panel_3.setLayout(null);
	       
	       JScrollPane scrollPane_4 = new JScrollPane();
	       scrollPane_4.setBounds(10, 11, 1194, 91);
	       panel_3.add(scrollPane_4);
	       
	       //***************************************** TABLA INMUEBLES ******************************//
	       
	      
	       Object[] fila = new Object[16];
	       
	       table = new JTable();
	       modelo = new DefaultTableModel();
			
			modelo.addColumn("Ref");
			modelo.addColumn("Moneda");
			modelo.addColumn("Precio");
			modelo.addColumn("Contribución Inmo");
			modelo.addColumn("Area Total");
			modelo.addColumn("Exclusividad");
			modelo.addColumn("Estado");
			modelo.addColumn("Fecha Ingreso");
			modelo.addColumn("Direccion");
			modelo.addColumn("Padrón");
			modelo.addColumn("Barrio");
			modelo.addColumn("Departamento");
			modelo.addColumn("Detalle Estado");
			modelo.addColumn("Detalle Inmueble");
			modelo.addColumn("Año");
			modelo.addColumn("Estado");
			
		
			
			
			ControladorList controlador = new ControladorList();
			List<VOinmueble> lstInmueble = controlador.listaInmuebles();
				if (lstInmueble.size() > 0){	
					Iterator<VOinmueble> iterInmueble = lstInmueble.iterator();
					while (iterInmueble.hasNext()){
						VOinmueble datosInmueble= iterInmueble.next();
										
						
						
						fila[0] = datosInmueble.getRefInmueble();
						fila[1] = datosInmueble.getTipoMonedaPrecioLista();
						fila[2] = datosInmueble.getPrecioLista();
						fila[3] = datosInmueble.getContribucionInmobiliaria();
						fila[4] = datosInmueble.getAreaTotal();
						fila[5] = datosInmueble.getExclusividad();
						fila[6] = datosInmueble.getEstadoDisponibilidad();
						fila[7] = datosInmueble.getFechaIngreso();
						fila[8] = datosInmueble.getDireccion();
						fila[9] = datosInmueble.getPadron();
						fila[10] = datosInmueble.getBarrio();
						fila[11] = datosInmueble.getDepartamento();
						fila[12] = datosInmueble.getEstadoDetalle();
						
						fila[13] = datosInmueble.getDetalleInmueble();
						fila[14] = datosInmueble.getAntiguedad();
						fila[15] = datosInmueble.getEstadoConservacion();
						
			
						modelo.addRow(fila);
					
					}
				}
				table = new JTable(modelo);	
				scrollPane_4.setViewportView(table);
				
				//**********************************************************//
				
				//----------------- TOMA LOS VALORES DE LA TABLA -------------------------------//
				
				table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){

					@Override
					public void valueChanged(ListSelectionEvent e){
					if(table.getSelectedRow() !=-1){
						
					int fila = table.getSelectedRow();
					try {
					
					textFieldRef_Inmueble.setText(table.getValueAt(fila,0).toString());

					String moneda0 = (table.getValueAt(fila,1).toString());
					int moneda1 = Integer.parseInt(moneda0);
					String nombreMoneda;
					nombreMoneda = controlador.obtenerNombreMonedaLista(moneda1);
					comboBox_precioLista.setSelectedItem(nombreMoneda);
						
					textField_PrecioLista.setText(table.getValueAt(fila,2).toString());
					textField_ContribucionInmobiliaria.setText(table.getValueAt(fila,3).toString());
					textField_AreaTotal.setText(table.getValueAt(fila,4).toString());
					
					if(table.getValueAt(fila,5).toString().equals("SI")){
						chckbxExclusividad.setSelected(true);
					}else{
						chckbxExclusividad.setSelected(false);
					}
					String estado0 = (table.getValueAt(fila,6).toString());
					comboBox_Estado.setSelectedItem(estado0);
					
					java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat("dd/MM/yyyy");
					String fechaIngreso2 = (table.getValueAt(fila,7).toString());
					java.util.Date fechaDate;
					try {
						fechaDate = formato.parse(fechaIngreso2);
						dateChooserFechaIngreso.setDate(fechaDate);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					textField_Direccion.setText(table.getValueAt(fila,8).toString());
					textField_Padron.setText(table.getValueAt(fila,9).toString());
					
					String barrio = (table.getValueAt(fila,10).toString());
					comboBox_Barrio.setSelectedItem(barrio);
					String departamento = (table.getValueAt(fila,11).toString());
					comboBox_Departamento.setSelectedItem(departamento);
					textArea_Estado.setText(table.getValueAt(fila,12).toString());
					textArea_Detalle.setText(table.getValueAt(fila,13).toString());
					
					textField_Antiguedad.setText(table.getValueAt(fila,14).toString());
					
					String estadoConservacion = (table.getValueAt(fila,15).toString());
					comboBoxEstadoConservacion.setSelectedItem(estadoConservacion);
					
					
						
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				
					
	}
}
});
					//----------------------------------------------------------------------------------//
				
				
	       scrollPane_4.setViewportView(table);
	       
	       JPanel panel_5 = new JPanel();
	       tabbedPane.addTab("Clientes Datos", null, panel_5, null);
	       panel_5.setLayout(null);
	       
	       JPanel panel_6 = new JPanel();
	       tabbedPane.addTab("Personas Datos", null, panel_6, null);
	       panel_6.setLayout(null);
	       
	       JPanel panel_7 = new JPanel();
	       panel_7.setBackground(Color.BLACK);
	       panel_7.setBounds(930, 316, 367, 91);
	       contentPane.add(panel_7);
	       panel_7.setLayout(null);
	       
	       JLabel lblSeleccioneOpcin = new JLabel("Seleccione Opci\u00F3n:");
	       lblSeleccioneOpcin.setBounds(10, 11, 195, 23);
	       panel_7.add(lblSeleccioneOpcin);
	       lblSeleccioneOpcin.setHorizontalAlignment(SwingConstants.RIGHT);
	       lblSeleccioneOpcin.setForeground(Color.WHITE);
	       lblSeleccioneOpcin.setFont(new Font("Dialog", Font.BOLD, 18));
	       
	       JComboBox comboBoxSeleccion = new JComboBox();
	       comboBoxSeleccion.setBounds(36, 37, 139, 30);
	       panel_7.add(comboBoxSeleccion);
	       comboBoxSeleccion.setModel(new DefaultComboBoxModel(new String[] {"", "Casa", "Apto", "Terreno"}));
	       comboBoxSeleccion.setFont(new Font("Dialog", Font.BOLD, 18));
	       JLabel label_Asterisco = new JLabel("*");
	       label_Asterisco.setBounds(186, 48, 29, 14);
	       panel_7.add(label_Asterisco);
	       label_Asterisco.setVisible(false);
	       
	       
	       label_Asterisco.setFont(new Font("Tahoma", Font.BOLD, 20));
	       label_Asterisco.setForeground(Color.RED);
	       
	       
	
	       
	       Button button_4 = new Button("CONTINUAR");
	       button_4.setBounds(217, 35, 118, 32);
	       panel_7.add(button_4);
	       button_4.addActionListener(new ActionListener() {
	       	public void actionPerformed(ActionEvent arg0) {
	       		
	       		//*************************** INGRESO LOS DATO EN LA DATA BASE **********************//
	       		try {
	       			
	       			ControladorComparar controladorComparar = new ControladorComparar();
	       			
	       			String refInmueble0=textFieldRef_Inmueble.getText();
    	       		int refInmueble=Integer.parseInt(refInmueble0);
       				
    	       		String idPersona0 = textField_idPersona.getText();
	       			int idPersona = Integer.parseInt(idPersona0);
	       			
	       			String idPropietario0 = textField_idCliente.getText();
	       			int idPropietario = Integer.parseInt(idPropietario0);
	       			
	       			
	       			if( textFieldRef_Inmueble.getText().equals("") || 
	       					textField_PrecioLista.getText().equals("") ||
	       					textField_PrecioLista.getText().equals("") ||
	       					comboBox_Estado.getSelectedItem().equals("")||
	       					textField_AreaTotal.getText().equals("") ||
	       					comboBox_Departamento.getSelectedItem().equals("")||
	       					comboBox_Barrio.getSelectedItem().equals("")||
	       					comboBox_Estado.getSelectedItem().equals("")||
	       					textField_Direccion.getText().equals("") ||
	       					comboBoxEstadoConservacion.getSelectedItem().equals("")||
	       					textField_PrecioLista.getText().equals("")||
	       					comboBox_precioLista.getSelectedItem().equals("") ||
	       					dateChooserFechaIngreso.getDateFormatString().equals("")
	       				){
	       			

	       				label_Asterisco1.setVisible(true);
	       				label_Asterisco2.setVisible(true);
	       				label_Asterisco3.setVisible(true);
	       				label_Asterisco4.setVisible(true);
	       				
	       				label_Asterisco6.setVisible(true);
	       				label_Asterisco7.setVisible(true);
	       				label_Asterisco8.setVisible(true);
	       				label_Asterisco10.setVisible(true);

	       				label_Asterisco25.setVisible(true);
	       				label_Asterisco26.setVisible(true);
	       				label_Asterisco27.setVisible(true);
	       				label_Asterisco28.setVisible(true);
	       				
	       				label_Asterisco29.setVisible(true);
	       				label_Asterisco11.setVisible(true);
	       				label_Asterisco12.setVisible(true);
	       				label_Asterisco28.setVisible(true);
	       				
	       			JOptionPane.showMessageDialog(null, "Por favor completar los campos obligatorios, gracias","Mensaje",JOptionPane.ERROR_MESSAGE, img);
	       			
	       			
	       			} else if(controladorComparar.existeInmueble(refInmueble)){
	       				
	       				JOptionPane.showMessageDialog(null, "Referencia de INMUEBLE existente\n Intentelo nuevamente.","Mensaje",JOptionPane.ERROR_MESSAGE, img);
		
	       			} else if(controladorComparar.existePersona(idPersona)){
	       				
	       				JOptionPane.showMessageDialog(null, "Referencia de PERSONA existente\n Intentelo nuevamente.","Mensaje",JOptionPane.ERROR_MESSAGE, img);
		
	       			} else if(controladorComparar.existePropietario(idPropietario)){
	       				
	       				JOptionPane.showMessageDialog(null, "Referencia de CLIENTE existente\n Intentelo nuevamente.","Mensaje",JOptionPane.ERROR_MESSAGE, img);
		
	       				
	       			}else{

	       				label_Asterisco1.setVisible(false);
	       				label_Asterisco2.setVisible(false);
	       				label_Asterisco3.setVisible(false);
	       				label_Asterisco4.setVisible(false);
	       				label_Asterisco6.setVisible(false);
	       				label_Asterisco7.setVisible(false);
	       				label_Asterisco8.setVisible(false);
	       				label_Asterisco10.setVisible(false);
	       				label_Asterisco25.setVisible(false);
	       				label_Asterisco26.setVisible(false);
	       				label_Asterisco27.setVisible(false);
	       				label_Asterisco28.setVisible(false);
	       				label_Asterisco28.setVisible(false);
	       				
	       				JOptionPane.showMessageDialog(null, "Campos obligatorios completos","Mensaje",JOptionPane.ERROR_MESSAGE, img);
	       
	       		
	       		ControladorList controladorList = new ControladorList();
	       		
	       		String tipoMonedaPrecioLista0=(String)comboBox_precioLista.getSelectedItem();
	       		int tipoMonedaPrecioLista=controladorList.obtenerIdMonedaLista(tipoMonedaPrecioLista0);
	       		String precioLista0=textField_PrecioLista.getText();
	       		int precioLista = Integer.parseInt(precioLista0);
	       		String contribucionInmobiliaria0=textField_ContribucionInmobiliaria.getText();
	       		int contribucionInmobiliaria=Integer.parseInt(contribucionInmobiliaria0);
	       		String areaTotal0=textField_AreaTotal.getText();
	       		int areaTotal= Integer.parseInt(areaTotal0);
	       		String exclusividad;
	       			if(chckbxExclusividad.isSelected()){
	       			 exclusividad="SI";
	       			}else{
	       			exclusividad ="NO";}
	       		
	       		String estadoDisponibilidad=(String)comboBox_Estado.getSelectedItem();
	       		String fechaIngreso=((JTextField)dateChooserFechaIngreso.getDateEditor().getUiComponent()).getText();
	       		String direccion=textField_Direccion.getText();
	       		String padron0 = textField_Padron.getText();
	       		int padron = Integer.parseInt(padron0);
	       		String barrio=(String) comboBox_Barrio.getSelectedItem();
	       		String departamento=(String) comboBox_Departamento.getSelectedItem();
	       		String estadoDetalle=textArea_Estado.getText();
	       		String detalleInmueble=textArea_Detalle.getText();
	       		String antiguedad0= textField_Antiguedad.getText();
	       		int antiguedad=Integer.parseInt(antiguedad0);
	       		
	       		String estadoConservacion =(String)comboBoxEstadoConservacion.getSelectedItem();
	       						
	       		ControladorInsert controladorInsert = new ControladorInsert();
	       		       			
	       			controladorInsert.nuevoInmueble2(refInmueble, tipoMonedaPrecioLista, 
	       					precioLista, contribucionInmobiliaria, areaTotal, exclusividad, 
	       					estadoDisponibilidad, fechaIngreso, direccion, padron, barrio,
	       					departamento, estadoDetalle, detalleInmueble, antiguedad, estadoConservacion);
 
	       			//******************************** INGRESO DATOS PERSONA A BASE DATOS******//
	       			
	       			
	       			String nombrePer = textField_NombrePersona.getText();
	       			String emailPer = textField_Email.getText();
	       			String detallePer =textArea_detallePersona.getText();
	       			
	       			JOptionPane.showMessageDialog(null, "Se han ingresado correctamente todos los datos\n de INMUEBLE");
	       			
	       			controladorInsert.nuevaPersona(idPersona, nombrePer, emailPer, detallePer);
	       			
	       			JOptionPane.showMessageDialog(null, "Se han ingresado correctamente todos los datos\n de PERSONA");
	       			
	       			//********************************** INGRESO LOS DATOS DE CLIENTE ****************//
	       			
	       			
	       			String detalleCli = textArea_detalleContacto.getText();
	       			
	       			controladorInsert.nuevoPropietario(idPersona, idPropietario, detalleCli);
	       			JOptionPane.showMessageDialog(null, "Se han ingresado correctamente todos los datos\n de CLIENTE PROPIETARIO");
	       			
	       			//********************************** INGRESO LOS DATOS DE TEL ****************//
	       			
	       			String telPersona0 = textField_TelContacto.getText();
	       			int telPersona = Integer.parseInt(telPersona0);
	       			String detalleTel = textField_DetalleTel.getText();
	       			
	       			//*************************************** CHEQUEAR ------------------------------------//
	       			
	       			controladorInsert.nuevoTelefono(idPersona, telPersona, detalleTel);
	       			JOptionPane.showMessageDialog(null, "Se han ingresado correctamente todos los datos\n del TEL");
	       			
	       			//*********************************************************************************************//
	       		
	       			String refInmueble2 = String.valueOf(refInmueble);
	       			
	       		if (comboBoxSeleccion.getSelectedItem()=="Casa"){
	       				ventanaCasas.setVisible(true);
	       				ventanaCasas.setExtendedState(MAXIMIZED_BOTH);// maximisa la ventana
	       				ventanaCasas.textField_refInm.setText(refInmueble2);
	       				dispose();
	       			
	       		}else if (comboBoxSeleccion.getSelectedItem()=="Apto"){
	       			
	       			ventanaAptos.setVisible(true);
	       			ventanaAptos.setExtendedState(MAXIMIZED_BOTH);// maximisa la ventana
	       			ventanaAptos.textField_refInm.setText(refInmueble2);
	       			dispose();
	       			}

	       			}	
	       		
	       		} catch (SQLException e) {
	       			// TODO Auto-generated catch block
	       			e.printStackTrace();
	       			JOptionPane.showMessageDialog(null, "Error - " + e);
	       		}
  	}
	       });
	       button_4.setFont(new Font("Dialog", Font.BOLD, 14));
	       
	 
		
	}
}
