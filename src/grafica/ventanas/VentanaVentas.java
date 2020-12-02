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
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
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

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import grafica.controladores.ControladorComparar;
import grafica.controladores.ControladorDelete;
import grafica.controladores.ControladorInsert;
import grafica.controladores.ControladorList;
import grafica.controladores.ControladorUpdate;
import logicapersistencia.valueObjects.VOMonedaLista;
import logicapersistencia.valueObjects.VOalquileres;
import logicapersistencia.valueObjects.VOcasas;
import logicapersistencia.valueObjects.VOcasasSoloCasas;
import logicapersistencia.valueObjects.VOcompradores;
import logicapersistencia.valueObjects.VOinmueble;
import logicapersistencia.valueObjects.VOtel_personas;
import logicapersistencia.valueObjects.VOventas;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;

public class VentanaVentas extends JFrame {

	private Fondo contentPane;
	private JTextField textField_Celular;
	private JTextField textField_PrecioVenta;
	private JTextField textField_Gravamen;
	private JTextField textField_RutaPdf;
	public JLabel label1;
	public JLabel label_2;
	public JLabel label_3;
	public JLabel label_4;
	public JLabel label_5;
	public JLabel label_6;
	public JLabel label_7;
	public JLabel label_8;
	public JLabel label_9;
	public JLabel label_10;
	public JLabel label_11;
	public JLabel label_12;
	private DefaultTableModel modeloVenta;
	private DefaultTableModel modeloTel;
	private DefaultTableModel modeloComprador;
	private JTextField textFieldRefVenta;
	Icon img = new ImageIcon(getClass().getResource("logo.png"));
	public JTextField textField_refInm;
	private JTextField textField_refComprador;
	private JTextField textField_Nombre_esc;
	private JTextField textField_Email_Esc;
	private JTable table_ventas;
	private JTextField textField_horario;
	private JTextField textField_Teléfono;
	private JTextField textField_Nombre;
	private JTextField textField_idPersona;
	private JTextField textField_idComprador;
	private JTextField textField_email;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaVentas frame = new VentanaVentas();
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
	
	
	public VentanaVentas() {
		JLabel label_Asterisco9 = new JLabel("*");
		JLabel label_Asterisco8 = new JLabel("*");
		JLabel label_Asterisco7 = new JLabel("*");
		JLabel label_Asterisco6 = new JLabel("*");
		JLabel label_Asterisco3 = new JLabel("*");
		JLabel label_Asterisco2 = new JLabel("*");
		JLabel label_Asterisco1 = new JLabel("*");
		JLabel label_Asterisco = new JLabel("*");
       JLabel label_Asterisco100 = new JLabel("*");
       JLabel label_Asterisco101 = new JLabel("*");

		
		label_Asterisco.setVisible(false);
		label_Asterisco1.setVisible(false);
		label_Asterisco2.setVisible(false);
		label_Asterisco3.setVisible(false);
		label_Asterisco6.setVisible(false);
		label_Asterisco7.setVisible(false);
		label_Asterisco8.setVisible(false);
		label_Asterisco9.setVisible(false);
		
		JComboBox comboBox_refInmueble = new JComboBox();
		JRadioButton rdbtnEditarRefInm = new JRadioButton("Editar");
		JRadioButton rdbtnListaInmuebleRef = new JRadioButton("Lista");
		ControladorInsert controladorInsert = new ControladorInsert();

		JTextArea textArea_detalleEscribano = new JTextArea();
		
		JDateChooser dateChooser_fechaEgreso = new JDateChooser();
		JTextArea textArea_detallePersona = new JTextArea();
	
		setBackground(UIManager.getColor("Button.foreground"));
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaVentas.class.getResource("/grafica/ventanas/uy2.png")));
		setTitle("Gestor de Ventas");

		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(30, 30, 1316, 769);
		contentPane = new Fondo("primerFondo.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(33, 317, 659, 162);
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "  Datos Escribano      ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel.setOpaque(false);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_Celular = new JLabel("Celular:");
		lbl_Celular.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_Celular.setForeground(Color.WHITE);
		lbl_Celular.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_Celular.setBounds(10, 116, 90, 23);
		panel.add(lbl_Celular);
		
		textField_Celular = new JTextField();
		
		textField_Celular.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
					char c = arg0.getKeyChar();
					if (c<'0'|| c>'9'){ 
						arg0.consume();
					}
					if(textField_Celular.getText().length()>=10){
						arg0.consume();
			}}
		});
		
		JTextArea textArea_Detalles = new JTextArea();
		textField_Celular.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_Celular.setBounds(110, 117, 134, 20);
		panel.add(textField_Celular);
		textField_Celular.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "  Caracter\u00EDsticas  ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel_1.setBounds(31, 177, 661, 129);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblSituacinJurdica = new JLabel("Precio:");
		lblSituacinJurdica.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSituacinJurdica.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSituacinJurdica.setForeground(Color.WHITE);
		lblSituacinJurdica.setBounds(10, 67, 126, 23);
		panel_1.add(lblSituacinJurdica);
		
		JComboBox comboBox_tipoMoneda = new JComboBox();
		
		
		//--------------------------------TRAE LA TABLA AL COMBOBOX--------------------------------------//
		ControladorList controladorComboBox3 = new ControladorList();
		List<VOMonedaLista> lstSeccion2 = controladorComboBox3.listarMonedaLista();
				
		Iterator<VOMonedaLista> iterSecciones2 = lstSeccion2.iterator();
		while (iterSecciones2.hasNext()){
		VOMonedaLista dataMonedaLista = iterSecciones2.next();
		comboBox_tipoMoneda.addItem(dataMonedaLista.getMonedaLista());
		}
		
		
		
		
		comboBox_tipoMoneda.setBounds(159, 30, 83, 21);
		panel_1.add(comboBox_tipoMoneda);
		
		JLabel lblreaEdificada = new JLabel("Fecha Egreso:");
		lblreaEdificada.setHorizontalAlignment(SwingConstants.RIGHT);
		lblreaEdificada.setForeground(Color.WHITE);
		lblreaEdificada.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblreaEdificada.setBounds(308, 28, 103, 23);
		panel_1.add(lblreaEdificada);
		
		JLabel lblreaTotal = new JLabel("Grav\u00E1men:");
		lblreaTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblreaTotal.setForeground(Color.WHITE);
		lblreaTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblreaTotal.setBounds(308, 67, 103, 23);
		panel_1.add(lblreaTotal);
		
		textField_PrecioVenta = new JTextField();
		

		textField_PrecioVenta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
					char c = arg0.getKeyChar();
					if (c<'0'|| c>'9'){ 
						arg0.consume();
					}
					if(textField_PrecioVenta.getText().length()>=9){
						arg0.consume();

				}

			}
		});
		
		textField_PrecioVenta.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_PrecioVenta.setBounds(156, 68, 86, 20);
		panel_1.add(textField_PrecioVenta);
		textField_PrecioVenta.setColumns(10);
		
		textField_Gravamen = new JTextField();
			
		textField_Gravamen.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {

					if (textField_Gravamen.getText().length() >= 50) {
						arg0.consume();
					}

				}
			});
		
		
		textField_Gravamen.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_Gravamen.setColumns(10);
		textField_Gravamen.setBounds(435, 68, 199, 20);
		panel_1.add(textField_Gravamen);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setOpaque(false);
		panel_4.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "  Detalles      ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel_4.setBounds(702, 405, 573, 129);
		contentPane.add(panel_4);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(33, 528, 1242, 194);
		contentPane.add(tabbedPane);
		
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(UIManager.getColor("CheckBox.darkShadow"));
		tabbedPane.addTab("Lista de Inmuebles en Venta", null, panel_5, null);
		panel_5.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 18, 1217, 122);
		panel_5.add(scrollPane_2);
		
		 //***************************************** TABLA VENTAS ******************************//
	       
	      
	       Object[] filaVenas = new Object[15];
	       
	       table_ventas = new JTable();
	       modeloVenta = new DefaultTableModel();
			
	       modeloVenta.addColumn("id Venta");
	       modeloVenta.addColumn("id Comprador");
	       modeloVenta.addColumn("id Inmueble");
	       modeloVenta.addColumn("Moneda");
	       modeloVenta.addColumn("Precio");
	       modeloVenta.addColumn("Fecha Egreso");
	       modeloVenta.addColumn("Gravámen");
	       modeloVenta.addColumn("Nombre esc.");
	       modeloVenta.addColumn("Tel esc.");
	       modeloVenta.addColumn("Email esc.");
	       modeloVenta.addColumn("Detalle Esc.");
	       modeloVenta.addColumn("Detalle venta");
	       			
			ControladorList controlador = new ControladorList();
			List<VOventas> lstVentas = controlador.listarVentas();
				if (lstVentas.size() > 0){	
					Iterator<VOventas> iterVentas = lstVentas.iterator();
					while (iterVentas.hasNext()){
						VOventas datosVentas= iterVentas.next();
										
						
						
						filaVenas[0] = datosVentas.getIdVentas();
						filaVenas[1] = datosVentas.getIdComprador();
						filaVenas[2] = datosVentas.getIdInmueble();
						filaVenas[3] = datosVentas.getTipoMoneda();
						filaVenas[4] = datosVentas.getPrecioVenta();
						
						filaVenas[5] = datosVentas.getFechaEgreso();
						filaVenas[6] = datosVentas.getGravamen();
						filaVenas[7] = datosVentas.getNombreEsc();
						filaVenas[8] = datosVentas.getTelEsc();
						filaVenas[9] = datosVentas.getEmailEsc();
						filaVenas[10] = datosVentas.getDetalleEsc();
						filaVenas[11] = datosVentas.getDetalleVen();
						
						modeloVenta.addRow(filaVenas);
					
					}
				}
				table_ventas = new JTable(modeloVenta);	
				scrollPane_2.setViewportView(table_ventas);
				
				//**********************************************************//
				
				//----------------- TOMA LOS VALORES DE LA TABLA -------------------------------//
				
				table_ventas.getSelectionModel().addListSelectionListener(new ListSelectionListener(){

					@Override
					public void valueChanged(ListSelectionEvent e){
					if(table_ventas.getSelectedRow() !=-1){
						
					int fila = table_ventas.getSelectedRow();
					try {
					
														
					textFieldRefVenta.setText(table_ventas.getValueAt(fila,0).toString());
					textField_refComprador.setText(table_ventas.getValueAt(fila,2).toString());
						
					String refInmueble = (table_ventas.getValueAt(fila,1).toString());
					textField_refInm.setText(refInmueble);
					int refInmueble1 = Integer.parseInt(refInmueble);
					comboBox_refInmueble.setSelectedItem(refInmueble);
						
					
					String moneda0 = (table_ventas.getValueAt(fila,3).toString());
					int moneda1 = Integer.parseInt(moneda0);
					String nombreMoneda;
					nombreMoneda = controlador.obtenerNombreMonedaLista(moneda1);
					comboBox_tipoMoneda.setSelectedItem(nombreMoneda);
					
					
					textField_PrecioVenta.setText(table_ventas.getValueAt(fila,4).toString());
										
					java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat("dd/MM/yyyy");
					String fechaIngreso2 = (table_ventas.getValueAt(fila,5).toString());
					java.util.Date fechaDate;
							fechaDate = formato.parse(fechaIngreso2);
						
						dateChooser_fechaEgreso.setDate(fechaDate);
					
					String gravamen = (table_ventas.getValueAt(fila,6).toString());
					textField_Gravamen.setText(gravamen);
					
					String nombre = (table_ventas.getValueAt(fila,7).toString());
					textField_Nombre_esc.setText(nombre);
					
					String email = (table_ventas.getValueAt(fila,9).toString());
					textField_Email_Esc.setText(email);
					
					String celu0 = (table_ventas.getValueAt(fila,8).toString());
					textField_Celular.setText(celu0);
					
					textArea_detalleEscribano.setText(table_ventas.getValueAt(fila,10).toString());
					
					textArea_Detalles.setText(table_ventas.getValueAt(fila,11).toString());
					
					
						
					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
					
	}
}
});
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(176, 224, 230));
		tabbedPane.addTab("Datos Compradores", null, panel_3, null);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(37, 11, 1179, 144);
		panel_3.add(scrollPane_4);
		

		
		
		
		
		 //***************************************** TABLA COMPRADOR ******************************//
		
		
		
		
	      
	       Object[] filaC = new Object[10];
	       
	       table = new JTable();
	       modeloComprador = new DefaultTableModel();
			
	       modeloComprador.addColumn("idPERSONA");
	       modeloComprador.addColumn("idCOMPRADOR");
	       modeloComprador.addColumn("NOMBRE");
	       modeloComprador.addColumn("EMAIL");
	       modeloComprador.addColumn("DETALLE PERSONA");
	       modeloComprador.addColumn("DETALLE COMPRADOR");
	     
	       
			ControladorList controladorCompradores = new ControladorList();
			List<VOcompradores> lstCompradores = controladorCompradores.listarCompradores();
				if (lstCompradores.size() > 0){	
					Iterator<VOcompradores> iterComprador = lstCompradores.iterator();
					while (iterComprador.hasNext()){
						VOcompradores datosComprador= iterComprador.next();
										
						
						
						filaC[0] = datosComprador.getIdComprador();
						filaC[1] = datosComprador.getIdPersona();
						filaC[2] = datosComprador.getNombrePer();
						filaC[3] = datosComprador.getEmailPer();
						filaC[4] = datosComprador.getDetallePer();
						
						filaC[5] = datosComprador.getDetalleComp();

						
						modeloComprador.addRow(filaC);
					
					}
				}
				table = new JTable(modeloComprador);	
				scrollPane_4.setViewportView(table);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(176, 224, 230));
		tabbedPane.addTab("Datos Tel\u00E9fonos", null, panel_10, null);
		panel_10.setLayout(null);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(29, 11, 1187, 130);
		panel_10.add(scrollPane_5);
		
		//************************************** TABLA TEL ************************//
				
		Object[] filaTel = new Object[10];
		
		table_1 = new JTable();
	       modeloTel = new DefaultTableModel();
			
	       modeloTel.addColumn("idPERSONA");
	       modeloTel.addColumn("NOMBRE");
	       modeloTel.addColumn("EMAIL");
	       modeloTel.addColumn("DETALLE PERSONA");
	       modeloTel.addColumn("TEL");
	       modeloTel.addColumn("DETALLE TEL");
	       
	       ControladorList controladorTels = new ControladorList();
			List<VOtel_personas> lstTel = controladorTels.listarTelefonos();
				if (lstTel.size() > 0){	
					Iterator<VOtel_personas> iterTel = lstTel.iterator();
					while (iterTel.hasNext()){
						VOtel_personas datosTel= iterTel.next();  
						filaTel[0] = datosTel.getIdPersona();
						filaTel[1] = datosTel.getNombrePer();
						filaTel[2] = datosTel.getEmailPer();
						filaTel[3] = datosTel.getDetallePer();
						filaTel[4] = datosTel.getTelPersona();
						filaTel[5] = datosTel.getDetalleTel();
						
						
						modeloTel.addRow(filaTel);
					}
				}
				
				table_1 = new JTable(modeloTel);	
				scrollPane_5.setViewportView(table_1);
			
		
		
		
		
		
				//**********************************************************//
				
					//----------------------------------------------------------------------------------//
				
				
		
	
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(UIManager.getColor("CheckBox.darkShadow"));
		tabbedPane.addTab("Generar PDF", null, panel_6, null);
		panel_6.setLayout(null);
		
		TextArea textArea_Imprime = new TextArea();
		textArea_Imprime.setBounds(21, 61, 1182, 82);
		panel_6.add(textArea_Imprime);
		
		JLabel label = new JLabel("Ruta:");
		label.setBackground(UIManager.getColor("CheckBox.focus"));
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setForeground(Color.WHITE);
		label.setBounds(29, 29, 46, 14);
		panel_6.add(label);
		
		textField_RutaPdf = new JTextField();
		textField_RutaPdf.setColumns(10);
		textField_RutaPdf.setBounds(73, 29, 230, 19);
		panel_6.add(textField_RutaPdf);
		
		JButton btnBuscarRuta = new JButton("Buscar Ruta");
		btnBuscarRuta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	// ************************** BUSCA RUTA PARA GUARDAR Y GENERAR PDF ***************//
				
				JFileChooser dlg= new JFileChooser();
				int option = dlg.showSaveDialog(btnBuscarRuta);
				if (option == JFileChooser.APPROVE_OPTION) {
				File f=dlg.getSelectedFile();
				textField_RutaPdf.setText(f.toString());
				}
	       		
			}
		});
		btnBuscarRuta.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuscarRuta.setBounds(313, 25, 167, 23);
		panel_6.add(btnBuscarRuta);
		
		JButton btnGenerarPdf = new JButton("Generar PDF");
		btnGenerarPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
// ------------------------GENERO EL PDF ----------------------//
				
				String ruta = textField_RutaPdf.getText();
				String contenido = textArea_Imprime.getText();
		

				try{
					
					if(ruta!=("")||ruta!=null){
					FileOutputStream archivo = new FileOutputStream(ruta+".pdf");
					
					Document doc = new Document(); 
					
					PdfWriter.getInstance(doc, archivo);
					doc.open();
					doc.add(new Paragraph (contenido));
					
					doc.close();
					
					JOptionPane.showMessageDialog(null, "PDF Creado Correctamente", 
							"LALK Negocios Inmobiliarios", JOptionPane.ERROR_MESSAGE, img);
					
					}else{
						JOptionPane.showMessageDialog(null, 
								"Debes seleccionar una ruta y escribir el nombre del archivo\n "
								+ "Recuerda escribir el nombre del archivo sin la extensión dado que ya la tiene", 
								"LALK Negocios Inmobiliarios", JOptionPane.ERROR_MESSAGE,img);
					}

				} catch (Exception error){
					JOptionPane.showMessageDialog(null, "Ha ocurrido un error", 
							"LALK Negocios Inmobiliaros", JOptionPane.ERROR_MESSAGE, img);
				}
	       		
	       		
				
				
				
			}
		});
		btnGenerarPdf.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGenerarPdf.setBounds(688, 25, 167, 23);
		panel_6.add(btnGenerarPdf);
		
		Button button = new Button("Ingresar Datos");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				String refVenta0 = textFieldRefVenta.getText();
				int refVentas = Integer.parseInt(refVenta0);
				
				ControladorComparar controladorComparar = new ControladorComparar();
					
					if(
							textFieldRefVenta.getText().equals("") || 
							comboBox_tipoMoneda.getSelectedItem().equals("")||
							textField_Nombre_esc.getText().equals("") || 
							textField_Email_Esc.getText().equals("") || 
							textField_Celular.getText().equals("") || 
							textField_refComprador.getText().equals("") || 
							textField_PrecioVenta.getText().equals("")
							
													
							
							){
						label_Asterisco7.setVisible(true);
						label_Asterisco.setVisible(true);
						label_Asterisco6.setVisible(true);
						label_Asterisco2.setVisible(true);
						label_Asterisco1.setVisible(true);
						label_Asterisco3.setVisible(true);
						label_Asterisco8.setVisible(true);
						label_Asterisco9.setVisible(true);
						
						JOptionPane.showMessageDialog(null, "Debes completar los campos obligatorios. \nGracias por su tiempo","Mensaje",JOptionPane.ERROR_MESSAGE, img);
						
					} else
						try {
							if(controladorComparar.existeVenta(refVentas)){
								JOptionPane.showMessageDialog(null, "Referencia VENTAS Nº"+refVentas+" ya existente \nGracias por su tiempo","Mensaje",JOptionPane.ERROR_MESSAGE, img);
												
							}else{
							

									try {

										String refComprador0 = textField_refComprador.getText();
										int refComprador = Integer.parseInt(refComprador0);
										
										int idInmueble;
										if(rdbtnListaInmuebleRef.isSelected()){
							String ref =(String) comboBox_refInmueble.getSelectedItem();	
							String ref0 = ref;
							idInmueble = Integer.parseInt(ref0);
										}else{
							String ref = textField_refInm.getText();
							idInmueble = Integer.parseInt(ref);
							}


										ControladorList controladorList = new ControladorList();
										int tipoMoneda;
										String tipoMoneda0 = (String) comboBox_tipoMoneda.getSelectedItem();
										tipoMoneda = controladorList.obtenerIdMonedaLista(tipoMoneda0);
							
								ControladorInsert controladorInsert = new ControladorInsert();

								String precioVenta0 = textField_PrecioVenta.getText();
								double precioVenta = Double.parseDouble(precioVenta0);

								String fechaEgreso = ((JTextField)dateChooser_fechaEgreso.getDateEditor().getUiComponent()).getText();

								String gravamen = textField_Gravamen.getText();
							
								String nombreEscribano = textField_Nombre_esc.getText();
								String emailEscribano = textField_Email_Esc.getText();
								String celEsc0 = textField_Celular.getText();
								int celEsc = Integer.parseInt(celEsc0);
								String detalleEsc = textArea_detalleEscribano.getText();
								String areaDetalle = textArea_Detalles.getText();


								controladorInsert.nuevaVenta(refVentas, refComprador, 
								idInmueble, tipoMoneda, precioVenta, fechaEgreso, gravamen, nombreEscribano,
								celEsc,emailEscribano,detalleEsc,areaDetalle);

								JOptionPane.showMessageDialog(null, "Se han ingresado los datos correctamente", 
								"LALK Negocios Inmobiliarios", JOptionPane.ERROR_MESSAGE, null);	

							
									} catch (SQLException e1) {
							
							e1.printStackTrace();
							
							JOptionPane.showMessageDialog(null, "Error - " + e1, 
									"LALK Negocios Inmobiliarios", JOptionPane.ERROR_MESSAGE, null);	
}

}
						} catch (HeadlessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				
			}
		});
		button.setFont(new Font("Dialog", Font.BOLD, 14));
		button.setBounds(918, 45, 357, 32);
		contentPane.add(button);
		
		Button button_1 = new Button("Actualizar Datos");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				ControladorUpdate controladorUpdate = new ControladorUpdate();

				
				String refVenta0 = textFieldRefVenta.getText();
				int refVentas = Integer.parseInt(refVenta0);
				
				ControladorComparar controladorComparar = new ControladorComparar();

				String refComprador0 = textField_refComprador.getText();
				int refComprador = Integer.parseInt(refComprador0);
										
				int idInmueble;
				if(rdbtnListaInmuebleRef.isSelected()){
							String ref =(String) comboBox_refInmueble.getSelectedItem();	
							String ref0 = ref;
							idInmueble = Integer.parseInt(ref0);
				}else{
							String ref = textField_refInm.getText();
							idInmueble = Integer.parseInt(ref);

				}

				ControladorList controladorList = new ControladorList();
				int tipoMoneda;
				String tipoMoneda0 = (String) comboBox_tipoMoneda.getSelectedItem();
				
					tipoMoneda = controladorList.obtenerIdMonedaLista(tipoMoneda0);
				
				
				String precioVenta0 = textField_PrecioVenta.getText();
				double precioVenta = Double.parseDouble(precioVenta0);

				String fechaEgreso = ((JTextField)dateChooser_fechaEgreso.getDateEditor().getUiComponent()).getText();

				String gravamen = textField_Gravamen.getText();
							
				String nombreEscribano = textField_Nombre_esc.getText();
				String emailEscribano = textField_Email_Esc.getText();
				String celEsc0 = textField_Celular.getText();
				int celEsc = Integer.parseInt(celEsc0);
				String detalleEsc = textArea_detalleEscribano.getText();
				String areaDetalle = textArea_Detalles.getText();

				
					controladorUpdate.updateVenta(refVentas, refComprador, idInmueble, tipoMoneda, 
							precioVenta, fechaEgreso, gravamen, 
							nombreEscribano, celEsc, emailEscribano, detalleEsc, areaDetalle);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
				JOptionPane.showMessageDialog(null, "Se han ACTUALIZADO los datos correctamente", 
				"LALK Negocios Inmobiliarios", JOptionPane.ERROR_MESSAGE, img);	


				
				
			}
		});
		button_1.setFont(new Font("Dialog", Font.BOLD, 14));
		button_1.setBounds(918, 83, 175, 32);
		contentPane.add(button_1);
		
		Button button_2 = new Button("Borrar Datos");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
				String refVenta0 = textFieldRefVenta.getText();
				int refVentas = Integer.parseInt(refVenta0);
				
				ControladorDelete controladorDelete = new ControladorDelete();
					controladorDelete.eliminarVenta(refVentas);
					
					JOptionPane.showMessageDialog(null, "Se ha eliminado el registro Nº "+refVentas+" de la tabla VENTAS \n Gracias por su tiempo", 
							"LALK Negocios Inmobiliarios", JOptionPane.ERROR_MESSAGE, img);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
					
			}
		});
		button_2.setFont(new Font("Dialog", Font.BOLD, 14));
		button_2.setBounds(918, 121, 175, 32);
		contentPane.add(button_2);
		
		Button button_3 = new Button("Resetear");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textFieldRefVenta.setText("");
				textField_refComprador.setText("");
				comboBox_refInmueble.setSelectedItem("");
				textField_refInm.setText("");
				comboBox_tipoMoneda.setSelectedItem("");
				textField_PrecioVenta.setText("");
				//date
				textField_Gravamen.setText("");
				textField_Nombre_esc.setText("");
				textField_Email_Esc.setText("");
				textField_Celular.setText("");
				textArea_detalleEscribano.setText("");
				textArea_Detalles.setText("");
				
				textField_idPersona.setText("");
				textField_idComprador.setText("");
				textField_Nombre.setText("");
				textField_Teléfono.setText("");
				textField_email.setText("");
				textField_horario.setText("");
				textArea_detallePersona.setText("");
				
				
			}
		});
		button_3.setFont(new Font("Dialog", Font.BOLD, 14));
		button_3.setBounds(1100, 83, 175, 32);
		contentPane.add(button_3);
		
		Button button_4 = new Button("Cerrar");
		button_4.setForeground(Color.RED);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		button_4.setFont(new Font("Dialog", Font.BOLD, 15));
		button_4.setBounds(1100, 121, 175, 32);
		contentPane.add(button_4);
		
		
		
		
		//************************************************ SOMBRAS ******************************//
		
		 JFrame frame = new JFrame();
	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       
	       label_Asterisco1.setFont(new Font("Tahoma", Font.BOLD, 20));
	       label_Asterisco1.setForeground(Color.RED);
	       label_Asterisco1.setBounds(252, 65, 28, 14);
	       panel_1.add(label_Asterisco1);
	       
	       label_Asterisco2.setForeground(Color.RED);
	       label_Asterisco2.setFont(new Font("Tahoma", Font.BOLD, 20));
	       label_Asterisco2.setBounds(252, 30, 28, 14);
	       panel_1.add(label_Asterisco2);
	       
	       label_Asterisco3.setForeground(Color.RED);
	       label_Asterisco3.setFont(new Font("Tahoma", Font.BOLD, 20));
	       label_Asterisco3.setBounds(550, 37, 28, 14);
	       panel_1.add(label_Asterisco3);
	       
	       JLabel lblMoneda = new JLabel("Moneda:");
	       lblMoneda.setHorizontalAlignment(SwingConstants.RIGHT);
	       lblMoneda.setForeground(Color.WHITE);
	       lblMoneda.setFont(new Font("Tahoma", Font.BOLD, 13));
	       lblMoneda.setBounds(10, 33, 126, 23);
	       panel_1.add(lblMoneda);
	       
	       
	       dateChooser_fechaEgreso.setBounds(435, 31, 95, 20);
	       dateChooser_fechaEgreso.setDateFormatString("dd/MM/yyyy");
	       panel_1.add(dateChooser_fechaEgreso);
	       
	       GhostText ghostText5 = new GhostText(textField_RutaPdf, "");
	       textField_RutaPdf.setPreferredSize(new Dimension(300, 24));
	       
	       JButton btnResumen = new JButton("Resumen");
	       btnResumen.addActionListener(new ActionListener() {
	       	public void actionPerformed(ActionEvent e) {
	       		
	       		textArea_Imprime.setText("\tRESUMEN VENTAS:\n\n"+"\n\t*Ref:: \t"+ textFieldRefVenta.getText()
				+"\n\t*PRECIO: \t"+ comboBox_tipoMoneda.getSelectedItem()+"\t"+textField_PrecioVenta.getText() 
				+
				"\n\t***** Escribano:\t\t "+ textField_Nombre_esc.getText() +
				"\n\t***** Email: " + textField_Email_Esc.getText() +
				"\n\t***** Celular/Tel: " + textField_Celular.getText() +
				"\n\t***** Detalle Escribano: " + textArea_detalleEscribano.getText() +
				"\n\t----------------------------------------------------------- "+
				"\n\n\t***** Detalle VENTA: \t\t "+textArea_Detalles.getText()+
				"/n/n LALK Negocios Inmobiliarios - Contacto: 099828182"
				);
	       		
	       		
	       		
	       		
	       		
	       		
	       		
	       		
	       	}
	       });
	       btnResumen.setFont(new Font("Tahoma", Font.BOLD, 14));
	       btnResumen.setBounds(503, 25, 167, 23);
	       panel_6.add(btnResumen);
	       
	       
	       GhostText ghostText12 = new GhostText(textField_Celular, "");
	       textField_Celular.setPreferredSize(new Dimension(300, 24));
	       
	       label_Asterisco8.setForeground(Color.RED);
	       label_Asterisco8.setFont(new Font("Tahoma", Font.BOLD, 20));
	       label_Asterisco8.setBounds(357, 37, 28, 14);
	       panel.add(label_Asterisco8);
	       
	       label_Asterisco9.setForeground(Color.RED);
	       label_Asterisco9.setFont(new Font("Tahoma", Font.BOLD, 20));
	       label_Asterisco9.setBounds(254, 125, 28, 14);
	       panel.add(label_Asterisco9);
	       
	       JLabel lblNombre = new JLabel("Nombre:");
	       lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
	       lblNombre.setForeground(Color.WHITE);
	       lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
	       lblNombre.setBounds(10, 28, 90, 23);
	       panel.add(lblNombre);
	       
	       textField_Nombre_esc = new JTextField();
	       
	       textField_Nombre_esc.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {

					if (textField_Nombre_esc.getText().length() >= 50) {
						arg0.consume();
					}

				}
			});
		
	       
	       
	       textField_Nombre_esc.setBounds(110, 31, 234, 20);
	       panel.add(textField_Nombre_esc);
	       textField_Nombre_esc.setColumns(10);
	       
	       JSeparator separator = new JSeparator();
	       separator.setOrientation(SwingConstants.VERTICAL);
	       separator.setBounds(395, 37, 33, 94);
	       panel.add(separator);
	       
	       JLabel lblEmail = new JLabel("Email:");
	       lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
	       lblEmail.setForeground(Color.WHITE);
	       lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
	       lblEmail.setBounds(10, 74, 90, 23);
	       panel.add(lblEmail);
	       
	       textField_Email_Esc = new JTextField();
	       
	       textField_Email_Esc.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					
					if(textField_Email_Esc.getText().length()>=50){
						arg0.consume();
					}
					
				}
			});
	       
	       
	       textField_Email_Esc.setColumns(10);
	       textField_Email_Esc.setBounds(110, 76, 234, 20);
	       panel.add(textField_Email_Esc);
	       
	       JScrollPane scrollPane = new JScrollPane();
	       scrollPane.setBounds(426, 24, 202, 115);
	       panel.add(scrollPane);
	       
	       
	       scrollPane.setViewportView(textArea_detalleEscribano);
	       
	       JScrollPane scrollPane_3 = new JScrollPane();
	       scrollPane_3.setBounds(27, 34, 515, 79);
	       panel_4.add(scrollPane_3);
	       
	       
	       scrollPane_3.setViewportView(textArea_Detalles);
	       
	       
	       textArea_Detalles.addKeyListener(new KeyAdapter() {
	       	@Override
	       	public void keyTyped(KeyEvent arg0) {
	       		
	       		if(textArea_Detalles.getText().length()>=400){
	       			arg0.consume();
	       		}
	       		
	       		char TipoDeTecla =arg0.getKeyChar();
	       		if(Character.isDigit(TipoDeTecla)){
	       			arg0.consume();
	       		}
	       		
	       	}
	       });
	       
	       GhostTextArea ghostText16 = new GhostTextArea(textArea_Detalles, "Ej. Detalles ...");
	       textArea_Detalles.setPreferredSize(new Dimension(300, 24));
	       	       
	       ImageIcon imagen4 = new ImageIcon(VentanaVentas.class.getResource("flecha.png"));
			
			JPanel panel_8 = new JPanel();
			panel_8.setOpaque(false);
			panel_8.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "  Inmueble  Identificador ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
			panel_8.setBounds(516, 37, 377, 129);
			contentPane.add(panel_8);
			panel_8.setLayout(null);
			
			
			
			//--------------------------------TRAE LA TABLA AL COMBOBOX--------------------------------------//
			ControladorList controladorComboBoxInmueble = new ControladorList();
			List<VOinmueble> lstSeccion = controladorComboBoxInmueble.listaInmuebles();
					
			Iterator<VOinmueble> iterSecciones = lstSeccion.iterator();
			while (iterSecciones.hasNext()){
			VOinmueble dataInmuebleLista = iterSecciones.next();
			comboBox_refInmueble.addItem(dataInmuebleLista.getRefInmueble());
			}
			
			JLabel lblReferencia = new JLabel("Referencia:");
			lblReferencia.setHorizontalAlignment(SwingConstants.RIGHT);
			lblReferencia.setForeground(Color.WHITE);
			lblReferencia.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblReferencia.setBounds(31, 33, 126, 23);
			panel_8.add(lblReferencia);
			
			label_Asterisco6.setForeground(Color.RED);
			label_Asterisco6.setFont(new Font("Tahoma", Font.BOLD, 20));
			label_Asterisco6.setBounds(167, 36, 28, 20);
			panel_8.add(label_Asterisco6);
			
			
			
			
			
			comboBox_refInmueble.setFont(new Font("Tahoma", Font.BOLD, 22));
			comboBox_refInmueble.setBounds(80, 67, 90, 43);
			panel_8.add(comboBox_refInmueble);
			
			rdbtnEditarRefInm.setBackground(Color.BLACK);
			rdbtnEditarRefInm.setForeground(Color.WHITE);
			rdbtnEditarRefInm.setBounds(232, 51, 63, 23);
			panel_8.add(rdbtnEditarRefInm);
			
			rdbtnListaInmuebleRef.setBackground(Color.BLACK);
			rdbtnListaInmuebleRef.setForeground(Color.WHITE);
			rdbtnListaInmuebleRef.setBounds(232, 87, 71, 23);
			panel_8.add(rdbtnListaInmuebleRef);
			
				
			rdbtnListaInmuebleRef.setSelected(true);
			
			
			rdbtnEditarRefInm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					rdbtnEditarRefInm.setSelected(true);
					rdbtnListaInmuebleRef.setSelected(false);
					textField_refInm.setEnabled(true);
					textField_refInm.setVisible(true);
				}
			});
			rdbtnListaInmuebleRef.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					rdbtnEditarRefInm.setSelected(false);
					rdbtnListaInmuebleRef.setSelected(true);
					textField_refInm.setEnabled(false);
					textField_refInm.setVisible(false);
				}
			});
			
		
			
			
			textField_refInm = new JTextField();
			
			textField_refInm.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					
						char c = arg0.getKeyChar();
						if (c<'0'|| c>'9'){ 
							arg0.consume();
						}
						if(textField_refInm.getText().length()>=5){
							arg0.consume();
				}}
			});
			
			textField_refInm.setBounds(296, 48, 52, 28);
			panel_8.add(textField_refInm);
			textField_refInm.setColumns(10);
			
			JPanel panel_9 = new JPanel();
			panel_9.setLayout(null);
			panel_9.setOpaque(false);
			panel_9.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "  Identificador Venta  ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
			panel_9.setBounds(33, 37, 259, 129);
			contentPane.add(panel_9);
			
			JLabel label_13 = new JLabel("Referencia:");
			label_13.setHorizontalAlignment(SwingConstants.RIGHT);
			label_13.setForeground(Color.WHITE);
			label_13.setFont(new Font("Tahoma", Font.BOLD, 13));
			label_13.setBounds(38, 34, 126, 23);
			panel_9.add(label_13);
			
			textFieldRefVenta = new JTextField();
			
			textFieldRefVenta.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					
						char c = arg0.getKeyChar();
						if (c<'0'|| c>'9'){ 
							arg0.consume();
						}
						if(textFieldRefVenta.getText().length()>=5){
							arg0.consume();
				}}
			});
			
			
			textFieldRefVenta.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldRefVenta.setFont(new Font("Tahoma", Font.BOLD, 22));
			textFieldRefVenta.setColumns(10);
			textFieldRefVenta.setBounds(89, 68, 75, 43);
			panel_9.add(textFieldRefVenta);
			
			
			label_Asterisco7.setForeground(Color.RED);
			label_Asterisco7.setFont(new Font("Tahoma", Font.BOLD, 20));
			label_Asterisco7.setBounds(174, 87, 28, 14);
			panel_9.add(label_Asterisco7);
			
			
			//------------------------------------ FLECHA CON ACCION ------------------------------//
		       
		       JLabel label_14 = new JLabel("");
		       label_14.setBounds(1234, 156, 56, 62);
		       ImageIcon imagenFlecha = new ImageIcon(VentanaVentas.class.getResource("flecha.png"));
		       Image imagFlecha = imagenFlecha.getImage().getScaledInstance(label_14.getWidth(), label_14.getHeight(), Image.SCALE_SMOOTH);
		       
		       label_14.setIcon(new ImageIcon(imagFlecha));
		       			
		       label_14.addMouseListener(new MouseAdapter() {
		            @Override
		            public void mouseClicked(MouseEvent e) {
		                VentanaPrincipal frameVentanaPrincipal = new VentanaPrincipal();
		                frameVentanaPrincipal.setVisible(true);
		                dispose();
		            }

		        });
		       			
		       
		       contentPane.add(label_14);
		       
		       JPanel panel_7 = new JPanel();
		       panel_7.setBounds(302, 35, 204, 131);
		       panel_7.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "  Identificador Comprador ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		       panel_7.setLayout(null);
		       panel_7.setOpaque(false);
		       
		       contentPane.add(panel_7);
		       
		       textField_refComprador = new JTextField();
		       
		       textField_refComprador.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent arg0) {
						
							char c = arg0.getKeyChar();
							if (c<'0'|| c>'9'){ 
								arg0.consume();
							}
							if(textField_refComprador.getText().length()>=5){
								arg0.consume();
					}}
				});
		       
		       textField_refComprador.setHorizontalAlignment(SwingConstants.CENTER);
		       textField_refComprador.setFont(new Font("Tahoma", Font.BOLD, 22));
		       textField_refComprador.setColumns(10);
		       textField_refComprador.setBounds(64, 66, 75, 43);
		       panel_7.add(textField_refComprador);
		       
		       JLabel label_15 = new JLabel("Referencia:");
		       label_15.setHorizontalAlignment(SwingConstants.RIGHT);
		       label_15.setForeground(Color.WHITE);
		       label_15.setFont(new Font("Tahoma", Font.BOLD, 13));
		       label_15.setBounds(14, 21, 126, 23);
		       panel_7.add(label_15);
		       
		      
		       label_Asterisco.setHorizontalAlignment(SwingConstants.LEFT);
		       label_Asterisco.setForeground(Color.RED);
		       label_Asterisco.setFont(new Font("Tahoma", Font.BOLD, 19));
		       label_Asterisco.setBounds(149, 77, 30, 23);
		       panel_7.add(label_Asterisco);
		       
		       JPanel panel_2 = new JPanel();
		       panel_2.setOpaque(false);
		       panel_2.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "  Detalles      ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		       panel_2.setBounds(702, 177, 573, 224);
		       contentPane.add(panel_2);
		       panel_2.setLayout(null);
		       
		       JScrollPane scrollPane_1 = new JScrollPane();
		       scrollPane_1.setBounds(36, 169, 259, 33);
		       panel_2.add(scrollPane_1);
		       
		       
		       
		       textArea_detallePersona.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent arg0) {

						if (textArea_detallePersona.getText().length() >= 350) {
							arg0.consume();
						}

					}
				});
		       
		       
		       scrollPane_1.setViewportView(textArea_detallePersona);
		       
		       JLabel label_19 = new JLabel("Detalle Persona:");
		       label_19.setBounds(20, 135, 134, 23);
		       panel_2.add(label_19);
		       label_19.setHorizontalAlignment(SwingConstants.RIGHT);
		       label_19.setForeground(Color.WHITE);
		       label_19.setFont(new Font("Tahoma", Font.BOLD, 13));
		       
		       JLabel label_18 = new JLabel("Horario Contacto:");
		       label_18.setBounds(10, 101, 134, 23);
		       panel_2.add(label_18);
		       label_18.setHorizontalAlignment(SwingConstants.RIGHT);
		       label_18.setForeground(Color.WHITE);
		       label_18.setFont(new Font("Tahoma", Font.BOLD, 13));
		       
		       JLabel label_17 = new JLabel("Tel\u00E9fono:");
		       label_17.setBounds(40, 75, 80, 23);
		       panel_2.add(label_17);
		       label_17.setHorizontalAlignment(SwingConstants.RIGHT);
		       label_17.setForeground(Color.WHITE);
		       label_17.setFont(new Font("Tahoma", Font.BOLD, 13));
		       
		       JLabel label_16 = new JLabel("Nombre:");
		       label_16.setBounds(40, 51, 80, 23);
		       panel_2.add(label_16);
		       label_16.setHorizontalAlignment(SwingConstants.RIGHT);
		       label_16.setForeground(Color.WHITE);
		       label_16.setFont(new Font("Tahoma", Font.BOLD, 13));
		       
		       JLabel label_1 = new JLabel("id Persona:");
		       label_1.setBounds(26, 22, 94, 23);
		       panel_2.add(label_1);
		       label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		       label_1.setForeground(Color.WHITE);
		       label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		       
		       textField_idPersona = new JTextField();
		       
		       textField_idPersona.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent arg0) {
						
							char c = arg0.getKeyChar();
							if (c<'0'|| c>'9'){ 
								arg0.consume();
							}
							if(textField_idPersona.getText().length()>=5){
								arg0.consume();

						}

					}
				});
		       
		       
		       
		       textField_idPersona.setBounds(154, 27, 52, 20);
		       panel_2.add(textField_idPersona);
		       textField_idPersona.setPreferredSize(new Dimension(300, 24));
		       textField_idPersona.setFont(new Font("Tahoma", Font.BOLD, 12));
		       textField_idPersona.setColumns(10);
		       
		       textField_Nombre = new JTextField();
		       
		       textField_Nombre.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent arg0) {

						if (textField_Nombre.getText().length() >= 50) {
							arg0.consume();
						}

					}
				});
		       
		       
		       textField_Nombre.setBounds(156, 54, 391, 20);
		       panel_2.add(textField_Nombre);
		       textField_Nombre.setPreferredSize(new Dimension(300, 24));
		       textField_Nombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		       textField_Nombre.setColumns(10);
		       
		       textField_Teléfono = new JTextField();
		       
		       textField_Teléfono.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent arg0) {
						
							char c = arg0.getKeyChar();
							if (c<'0'|| c>'9'){ 
								arg0.consume();
							}
							if(textField_Teléfono.getText().length()>=11){
								arg0.consume();

						}

					}
				});
		       
		       
		       textField_Teléfono.setBounds(156, 78, 103, 20);
		       panel_2.add(textField_Teléfono);
		       textField_Teléfono.setPreferredSize(new Dimension(300, 24));
		       textField_Teléfono.setFont(new Font("Tahoma", Font.BOLD, 12));
		       textField_Teléfono.setColumns(10);
		       
		       textField_horario = new JTextField();
		       
		       textField_horario.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent arg0) {

						if (textField_horario.getText().length() >= 50) {
							arg0.consume();
						}

					}
				});
		       
		       
		       textField_horario.setBounds(157, 104, 390, 20);
		       panel_2.add(textField_horario);
		       textField_horario.setPreferredSize(new Dimension(300, 24));
		       textField_horario.setFont(new Font("Tahoma", Font.BOLD, 12));
		       textField_horario.setColumns(10);
		       
		       JLabel lblIdComprador = new JLabel("id Comprador");
		       lblIdComprador.setHorizontalAlignment(SwingConstants.RIGHT);
		       lblIdComprador.setForeground(Color.WHITE);
		       lblIdComprador.setFont(new Font("Tahoma", Font.BOLD, 13));
		       lblIdComprador.setBounds(263, 21, 126, 23);
		       panel_2.add(lblIdComprador);
		       
		       textField_idComprador = new JTextField();
		       
		       textField_idComprador.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent arg0) {
						
							char c = arg0.getKeyChar();
							if (c<'0'|| c>'9'){ 
								arg0.consume();
							}
							if(textField_idComprador.getText().length()>=5){
								arg0.consume();

						}

					}
				});
		       
		       
		       textField_idComprador.setHorizontalAlignment(SwingConstants.CENTER);
		       textField_idComprador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		       textField_idComprador.setColumns(10);
		       textField_idComprador.setBounds(403, 20, 39, 23);
		       panel_2.add(textField_idComprador);
		       
		       JLabel label_21 = new JLabel("E-mail:");
		       label_21.setHorizontalAlignment(SwingConstants.RIGHT);
		       label_21.setForeground(Color.WHITE);
		       label_21.setFont(new Font("Tahoma", Font.BOLD, 13));
		       label_21.setBounds(285, 74, 70, 23);
		       panel_2.add(label_21);
		       
		       textField_email = new JTextField();
		       
		       textField_email.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent arg0) {

						if (textField_email.getText().length() >= 50) {
							arg0.consume();
						}

					}
				});
		       
		       textField_email.setPreferredSize(new Dimension(300, 24));
		       textField_email.setFont(new Font("Tahoma", Font.BOLD, 12));
		       textField_email.setColumns(10);
		       textField_email.setBounds(368, 79, 179, 20);
		       panel_2.add(textField_email);
		       
		       label_Asterisco100.setVisible(false);
		       label_Asterisco101.setVisible(false);
		       
		       JButton button_5 = new JButton("Ingresar Persona");
		       button_5.addActionListener(new ActionListener() {
		       	public void actionPerformed(ActionEvent arg0) {
		       		
	//******************************* INGRESO DATOS COMPRADOR Y PERSONA ******************//

		       		if(

		       				textField_idPersona.getText().equals("") || 
		       				textField_idComprador.getText().equals("")

		       				){

		       			label_Asterisco100.setVisible(true);
		       			label_Asterisco101.setVisible(true);

		       			JOptionPane.showMessageDialog(null, "Debes completar los campos obligatorios. \nGracias por su tiempo","Mensaje",JOptionPane.ERROR_MESSAGE, img);

		       		}else{
		       			
					String idPersona0 = textField_idPersona.getText();
					int idPersona = Integer.parseInt(idPersona0);
					
					String nombrePer = textField_Nombre.getText();
					
					String emailPer = textField_Teléfono.getText();
					
					String detallePer = textArea_detallePersona.getText();
					
					String idComprador0 = textField_refComprador.getText();
					int idComprador = Integer.parseInt(idComprador0);
					
					String detalleComp = textArea_detallePersona.getText();
					
					try {
						controladorInsert.nuevaPersona(idPersona, nombrePer, emailPer, detallePer);
						controladorInsert.nuevoComprador(idComprador, detalleComp);
						
						JOptionPane.showMessageDialog(null, "Se han ingresado correctamente todos los datos\n de PERSONA y COMPRADOR");
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Error" + e1);
					}
	       			
	       			
		       		}
		       		
		       		
		       	}
		       });
		       button_5.setBounds(342, 145, 188, 23);
		       panel_2.add(button_5);
		       
		       JButton button_6 = new JButton("Ingresar Tel\u00E9fono");
		       button_6.addActionListener(new ActionListener() {
		       	public void actionPerformed(ActionEvent e) {
		       		

		       			if(

		       					textField_idPersona.getText().equals("") || 
		       					textField_idComprador.getText().equals("")

		       					){

		       					label_Asterisco100.setVisible(true);
		       					label_Asterisco101.setVisible(true);

		       					JOptionPane.showMessageDialog(null, "Debes completar los campos obligatorios. \nGracias por su tiempo","Mensaje",JOptionPane.ERROR_MESSAGE, img);

		       					}else{
		       		
		       		//---------------------------------------- INGRESO LOS DATOS DE TELÉFONO ------------------//
	       			
	       			String idPersona0 = textField_idPersona.getText();
					int idPersona = Integer.parseInt(idPersona0);
	       			
	       			
	       			String telPersona0 = textField_Teléfono.getText();
	       			int telPersona = Integer.parseInt(telPersona0);
	       			String detalleTel = textField_horario.getText();
	       			
	       			try {
						controladorInsert.nuevoTelefono(idPersona, telPersona, detalleTel);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Error" + e1);
					}
	       			JOptionPane.showMessageDialog(null, "Se han ingresado correctamente todos los datos\n del TEL");
	       			
	       			//************************************************************************************************//
				
		       	}
		       	}
		       });
		       button_6.setBounds(342, 179, 188, 23);
		       panel_2.add(button_6);
		       
		       label_Asterisco100.setHorizontalAlignment(SwingConstants.RIGHT);
		       label_Asterisco100.setForeground(Color.RED);
		       label_Asterisco100.setFont(new Font("Tahoma", Font.BOLD, 21));
		       label_Asterisco100.setBounds(209, 27, 39, 23);
		       panel_2.add(label_Asterisco100);
		       
		       label_Asterisco101.setHorizontalAlignment(SwingConstants.RIGHT);
		       label_Asterisco101.setForeground(Color.RED);
		       label_Asterisco101.setFont(new Font("Tahoma", Font.BOLD, 21));
		       label_Asterisco101.setBounds(452, 22, 28, 23);
		       panel_2.add(label_Asterisco101);
	
		
	}
}
