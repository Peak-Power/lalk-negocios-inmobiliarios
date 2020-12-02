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
import logicapersistencia.valueObjects.VOinmueble;

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

public class VentanaAlquileres extends JFrame {

	private Fondo contentPane;
	private JTextField textField_Celfia;
	private JTextField textField_PrecioAlquiler;
	private JTextField textField_plazoContractual;
	private JTextField textField_RutaPdf;
	private JTable table;
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
	private DefaultTableModel modeloAlq;
	private JTextField textFieldRefAlquiler;
	Icon img = new ImageIcon(getClass().getResource("uy2.png"));
	public JTextField textField_refInm;
	private JTextField textField_refArrendatario;
	private JTextField textField_Nombre_fia;
	private JTextField textField_Email_fia;
	private JTextField textField_horarioContacto;
	private JTextField textField_Tel_Arrendatario;
	private JTextField textField_NombreArrendatario;
	private JTextField textField_idPersona;
	private JTextField textField_Email_Arrendatario;

	private JTable table_alquileres;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAlquileres frame = new VentanaAlquileres();
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
	
	
	public VentanaAlquileres() {
		JLabel label_Asterisco9 = new JLabel("*");
		JLabel label_Asterisco8 = new JLabel("*");
		JLabel label_Asterisco7 = new JLabel("*");
		JLabel label_Asterisco6 = new JLabel("*");
		JLabel label_Asterisco3 = new JLabel("*");
		JLabel label_Asterisco2 = new JLabel("*");
		JLabel label_Asterisco1 = new JLabel("*");
		JLabel label_Asterisco5 = new JLabel("*");
		
		label_Asterisco1.setVisible(false);
		label_Asterisco2.setVisible(false);
		label_Asterisco3.setVisible(false);
		label_Asterisco6.setVisible(false);
		label_Asterisco7.setVisible(false);
		label_Asterisco8.setVisible(false);
		label_Asterisco9.setVisible(false);
		label_Asterisco5.setVisible(false);
		
		JComboBox comboBox_refInmueble = new JComboBox();
		JRadioButton rdbtnEditarRefInm = new JRadioButton("Editar");
		JRadioButton rdbtnListaInmuebleRef = new JRadioButton("Lista");
		ControladorInsert controladorInsert = new ControladorInsert();
	       JComboBox comboBox_Garantia_1 = new JComboBox();
	       JComboBox comboBox_Garantia_2 = new JComboBox();
	       JLabel lblGaranta_1 = new JLabel("Garant\u00EDa (2):");
	       JTextArea textArea_Alquiler = new JTextArea();
	       
	       
	       textArea_Alquiler.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					
					if(textArea_Alquiler.getText().length()>=400){
						arg0.consume();
					}
					
				}
			});
	       
	       
	       JTextArea textArea_Fiador = new JTextArea();
	       JLabel lblGaranta = new JLabel("Garant\u00EDa (1):");
	       JTextArea textArea_DetalleGarantia = new JTextArea();
	       
	       textArea_DetalleGarantia.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					
					if(textArea_DetalleGarantia.getText().length()>=200){
						arg0.consume();
					}
					
				}
			});
	       
	       
	       JTextArea textArea_detallePersona = new JTextArea();
	       
	       textArea_detallePersona.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					
					if(textArea_detallePersona.getText().length()>=400){
						arg0.consume();
					}
					
				}
			});


		
		JDateChooser dateChooser_fechaEgreso = new JDateChooser();
	
		setBackground(UIManager.getColor("Button.foreground"));
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaAlquileres.class.getResource("/grafica/ventanas/uy2.png")));
		setTitle("Gestor de Alquileres");

		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(30, 30, 1316, 769);
		contentPane = new Fondo("primerFondo.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(33, 317, 659, 219);
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "  Datos Garant\u00EDa      ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel.setOpaque(false);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_Celular = new JLabel("Celular:");
		lbl_Celular.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_Celular.setForeground(Color.WHITE);
		lbl_Celular.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_Celular.setBounds(283, 120, 90, 23);
		panel.add(lbl_Celular);
		
		textField_Celfia = new JTextField();
		
		textField_Celfia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
					char c = arg0.getKeyChar();
					if (c<'0'|| c>'9'){ 
						arg0.consume();
					}
					if(textField_Celfia.getText().length()>=11){
						arg0.consume();
			}}
		});
		textField_Celfia.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_Celfia.setBounds(383, 121, 134, 20);
		panel.add(textField_Celfia);
		textField_Celfia.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "  Caracter\u00EDsticas  ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel_1.setBounds(33, 182, 661, 129);
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
		
		JLabel pla = new JLabel("Plazo Contractual:");
		pla.setHorizontalAlignment(SwingConstants.RIGHT);
		pla.setForeground(Color.WHITE);
		pla.setFont(new Font("Tahoma", Font.BOLD, 13));
		pla.setBounds(273, 67, 138, 23);
		panel_1.add(pla);
		
		textField_PrecioAlquiler = new JTextField();
		

		textField_PrecioAlquiler.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
					char c = arg0.getKeyChar();
					if (c<'0'|| c>'9'){ 
						arg0.consume();
					}
					if(textField_PrecioAlquiler.getText().length()>=9){
						arg0.consume();

				}

			}
		});
		
		textField_PrecioAlquiler.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_PrecioAlquiler.setBounds(156, 68, 86, 20);
		panel_1.add(textField_PrecioAlquiler);
		textField_PrecioAlquiler.setColumns(10);
		
		textField_plazoContractual = new JTextField();
		
		
		textField_plazoContractual.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
					char c = arg0.getKeyChar();
					if (c<'0'|| c>'9'){ 
						arg0.consume();
					}
					if(textField_plazoContractual.getText().length()>=2){
						arg0.consume();
			}}
		});
			
		
		textField_plazoContractual.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_plazoContractual.setColumns(10);
		textField_plazoContractual.setBounds(435, 68, 54, 20);
		panel_1.add(textField_plazoContractual);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setOpaque(false);
		panel_4.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "  Detalles Alquiler      ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel_4.setBounds(702, 450, 573, 96);
		contentPane.add(panel_4);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(33, 547, 1242, 175);
		contentPane.add(tabbedPane);
		
		
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(UIManager.getColor("CheckBox.darkShadow"));
		tabbedPane.addTab("Lista de Inmuebles en Alquiler", null, panel_5, null);
		panel_5.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 11, 1217, 125);
		panel_5.add(scrollPane_2);


		 //***************************************** TABLA ALQUILERES ******************************//
			       
			      
			       Object[] filaAlq = new Object[16];
			       
			       table_alquileres = new JTable();
			       modeloAlq = new DefaultTableModel();
					
			       modeloAlq.addColumn("Ref Alq");
			       modeloAlq.addColumn("Ref Arrendatario");
			       modeloAlq.addColumn("Ref Inmueble");
			       modeloAlq.addColumn("fechaEgreso");
			       modeloAlq.addColumn("precioAlquiler");
			       modeloAlq.addColumn("plazoContractual");
			       modeloAlq.addColumn("garantia1");
			       modeloAlq.addColumn("garantia2");
			       modeloAlq.addColumn("nombreFia");
			       modeloAlq.addColumn("telFia");
			       modeloAlq.addColumn("emailFia");
			       modeloAlq.addColumn("detalleFia");
			       modeloAlq.addColumn("detalleGar");
			       modeloAlq.addColumn("detalleAlq");
			       modeloAlq.addColumn("Tipo Moneda");
					
					ControladorList controlador = new ControladorList();
					List<VOalquileres> lstAlquileres = controlador.listarAlquileres();
						if (lstAlquileres.size() > 0){	
							Iterator<VOalquileres> iterAlquileres = lstAlquileres.iterator();
							while (iterAlquileres.hasNext()){
								VOalquileres datosAlquileres= iterAlquileres.next();
												
								
								
								filaAlq[0] = datosAlquileres.getIdAlquiler();
								filaAlq[1] = datosAlquileres.getIdArrendatario();
								filaAlq[2] = datosAlquileres.getIdInmueble();
								filaAlq[3] = datosAlquileres.getFechaEgreso();
								filaAlq[4] = datosAlquileres.getPrecioAlquiler();
								filaAlq[5] = datosAlquileres.getPlazoContractual();
								filaAlq[6] = datosAlquileres.getGarantia1();
								filaAlq[7] = datosAlquileres.getGarantia2();
								filaAlq[8] = datosAlquileres.getNombreFia();
								filaAlq[9] = datosAlquileres.getTelFia();
								filaAlq[10] = datosAlquileres.getEmailFia();
								filaAlq[11] = datosAlquileres.getDetalleFia();
								filaAlq[12] = datosAlquileres.getDetalleGar();
								
								filaAlq[13] = datosAlquileres.getDetalleAlq();
								filaAlq[14] = datosAlquileres.getTipoMoneda();
								
								modeloAlq.addRow(filaAlq);
							
							}
						}
						table_alquileres = new JTable(modeloAlq);	
						scrollPane_2.setViewportView(table_alquileres);
						
			//**********************************************************//
						
						
						//----------------- TOMA LOS VALORES DE LA TABLA -------------------------------//
						
						table_alquileres.getSelectionModel().addListSelectionListener(new ListSelectionListener(){

							@Override
							public void valueChanged(ListSelectionEvent e){
							if(table_alquileres.getSelectedRow() !=-1){
								
							int fila = table_alquileres.getSelectedRow();
							try {
							
							textFieldRefAlquiler.setText(table_alquileres.getValueAt(fila,0).toString());
							textField_refArrendatario.setText(table_alquileres.getValueAt(fila,1).toString());
							
							//*****
							String num =(table_alquileres.getValueAt(fila,2).toString());
							String num2 =(table_alquileres.getValueAt(fila,2).toString());
							int num3 = Integer.parseInt(num2);
							textField_refInm.setText(num);
							comboBox_refInmueble.setSelectedItem(num3);
							
							java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat("dd/MM/yyyy");
							String fechaIngreso2 = (table_alquileres.getValueAt(fila,3).toString());
							java.util.Date fechaDate;
							
								fechaDate = formato.parse(fechaIngreso2);
								dateChooser_fechaEgreso.setDate(fechaDate);
							
							
							textField_PrecioAlquiler.setText(table_alquileres.getValueAt(fila,4).toString());
							textField_plazoContractual.setText(table_alquileres.getValueAt(fila,5).toString());
														
							String garantia1 = (table_alquileres.getValueAt(fila,6).toString());
							comboBox_Garantia_1.setSelectedItem(garantia1);
							
							String garantia2 = (table_alquileres.getValueAt(fila,7).toString());
							comboBox_Garantia_2.setSelectedItem(garantia2);
							
							textField_Nombre_fia.setText(table_alquileres.getValueAt(fila,8).toString());
							textField_Email_fia.setText(table_alquileres.getValueAt(fila,10).toString());
							textField_Celfia.setText(table_alquileres.getValueAt(fila,9).toString());
							textArea_Fiador.setText(table_alquileres.getValueAt(fila,11).toString());
							textArea_DetalleGarantia.setText(table_alquileres.getValueAt(fila,12).toString());
							textArea_Alquiler.setText(table_alquileres.getValueAt(fila,13).toString());
							
							String moneda0 = (table_alquileres.getValueAt(fila,14).toString());
							int moneda1 = Integer.parseInt(moneda0);
							String nombreMoneda;
							nombreMoneda = controlador.obtenerNombreMonedaLista(moneda1);
							comboBox_tipoMoneda.setSelectedItem(nombreMoneda);
								
							
							
							

							
							
								
							} catch (SQLException e1) {
								e1.printStackTrace();
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						
							
			}
		}
		});
							//----------------------------------------------------------------------------------//
						
						
						
						
						
						
						
						
						
						
						

		
		
				
				
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(UIManager.getColor("CheckBox.darkShadow"));
		tabbedPane.addTab("Generar PDF", null, panel_6, null);
		panel_6.setLayout(null);
		
		TextArea textArea_Imprime = new TextArea();
		textArea_Imprime.setBounds(29, 65, 1174, 58);
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
							"LALK Negocios Inmobiliarios", JOptionPane.ERROR_MESSAGE, null);
					
					}else{
						JOptionPane.showMessageDialog(null, 
								"Debes seleccionar una ruta y escribir el nombre del archivo\n "
								+ "Recuerda escribir el nombre del archivo sin la extensión dado que ya la tiene", 
								"LALK Negocios Inmobiliarios", JOptionPane.ERROR_MESSAGE,null);
					}

				} catch (Exception error){
					JOptionPane.showMessageDialog(null, "Ha ocurrido un error", 
							"LALK Negocios Inmobiliaros", JOptionPane.ERROR_MESSAGE);
				}
	       		
	       		
				
				
				
			}
		});
		btnGenerarPdf.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGenerarPdf.setBounds(688, 25, 167, 23);
		panel_6.add(btnGenerarPdf);
		
		Button button = new Button("Ingresar Datos");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					
					String plazoMax0 = textField_plazoContractual.getText();
					int plazoMax = Integer.parseInt(plazoMax0);
					
					String refAlquiler0 = textFieldRefAlquiler.getText();
					int refAlquiler = Integer.parseInt(refAlquiler0);
					
					ControladorComparar controladorComparar = new ControladorComparar();
										
					if(
							textFieldRefAlquiler.getText().equals("") || 
							comboBox_tipoMoneda.getSelectedItem().equals("")||
							textField_PrecioAlquiler.getText().equals("") || 
							textField_plazoContractual.getText().equals("") || 
							textField_idPersona.getText().equals("") || 
							textField_refArrendatario.getText().equals("") || 
							comboBox_Garantia_1.getSelectedItem().equals("")||
							comboBox_Garantia_2.getSelectedItem().equals("")
							
							
							
							){
						
						label_Asterisco1.setVisible(true);
						label_Asterisco2.setVisible(true);
						label_Asterisco3.setVisible(true);
						label_Asterisco6.setVisible(true);
						label_Asterisco7.setVisible(true);
						label_Asterisco8.setVisible(true);
						label_Asterisco9.setVisible(true);
						label_Asterisco5.setVisible(true);

						
						JOptionPane.showMessageDialog(null, "Por favor completar los campos obligatorios, gracias","Mensaje - LALK Negocios Inmobiliarios",JOptionPane.ERROR_MESSAGE, img);
						
					} else if (plazoMax>15){
						
						label_Asterisco3.setVisible(true);
						
						JOptionPane.showMessageDialog(null, "Los arrendamientos no pueden tener un plazo mayor a 15 años \n art 1785 CCU \n Excepciones: 20 años para los destinos represa, embalse, y forestación.","Mensaje - LALK Negocios Inmobiliarios",JOptionPane.ERROR_MESSAGE, img);
					
					} else if(controladorComparar.existeAlquiler(refAlquiler)){
	       				
	       				JOptionPane.showMessageDialog(null, "Referencia de ALQUILER existente\n Intentelo nuevamente.","Mensaje",JOptionPane.ERROR_MESSAGE, img);
		
	       				
	       			}else{
	       			
	       			
					
				ControladorInsert controladorInsert = new ControladorInsert();
				
				
				
				
				String refArrendatario0 = textField_refArrendatario.getText();
				int refArrendatario = Integer.parseInt(refArrendatario0);
								
				int idInmueble;
				if(rdbtnListaInmuebleRef.isSelected()){
					String ref =(String) comboBox_refInmueble.getSelectedItem();						
					idInmueble = Integer.parseInt(ref);
				}else{
					String ref = textField_refInm.getText();
					idInmueble = Integer.parseInt(ref);
					}
				
				
				String fechaEgreso = ((JTextField)dateChooser_fechaEgreso.getDateEditor().getUiComponent()).getText();
				
				String precioAlquiler0 = textField_PrecioAlquiler.getText();
				double precioAlquiler = Double.parseDouble(precioAlquiler0);
				
				String plazoContractual0  = textField_plazoContractual.getText();
				int plazoContractual = Integer.parseInt(plazoContractual0);
				
				String garantia1 = (String) comboBox_Garantia_1.getSelectedItem();
				String garantia2 = (String) comboBox_Garantia_2.getSelectedItem();
				
				String nombreFiador = textField_Nombre_fia.getText();
				
				String emailFiador = textField_Email_fia.getText();
				
				String celFiador0 = textField_Celfia.getText();
				int celFiador = Integer.parseInt(celFiador0);
				
				String detalle_Fiador = textArea_Fiador.getText();
				String detalle_Garantia = textArea_DetalleGarantia.getText();
				String detalle_Alquiler = textArea_Alquiler.getText();
				
				String tipoMoneda0 = (String) comboBox_tipoMoneda.getSelectedItem();
				ControladorList controladorList = new ControladorList();
				
					int tipoMoneda;
					tipoMoneda = controladorList.obtenerIdMonedaLista(tipoMoneda0);
				
				
				
					controladorInsert.nuevoAlquiler(refAlquiler, refArrendatario, idInmueble, fechaEgreso, 
							precioAlquiler, plazoContractual, garantia1, garantia2, 
							nombreFiador, celFiador, emailFiador, detalle_Fiador, detalle_Garantia, 
							detalle_Alquiler,tipoMoneda);
					
					
					JOptionPane.showMessageDialog(null, "Se han ingresado correctamente todos los datos\n del ALQUILER");
					
	       			}
					
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Error" + e1);
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
				ControladorList controladorList = new ControladorList();

				String plazoMax0 = textField_plazoContractual.getText();
				int plazoMax = Integer.parseInt(plazoMax0);
					
				String refAlquiler0 = textFieldRefAlquiler.getText();
				int refAlquiler = Integer.parseInt(refAlquiler0);
				String fechaEgreso = ((JTextField)dateChooser_fechaEgreso.getDateEditor().getUiComponent()).getText();
				
				String precioAlquiler0 = textField_PrecioAlquiler.getText();
				double precioAlquiler = Double.parseDouble(precioAlquiler0);
				
				String plazoContractual0  = textField_plazoContractual.getText();
				int plazoContractual = Integer.parseInt(plazoContractual0);
				
				String garantia1 = (String) comboBox_Garantia_1.getSelectedItem();
				String garantia2 = (String) comboBox_Garantia_2.getSelectedItem();
				
				String nombreFiador = textField_Nombre_fia.getText();
				
				String emailFiador = textField_Email_fia.getText();
				
				String celFiador0 = textField_Celfia.getText();
				int celFiador = Integer.parseInt(celFiador0);
				
				String detalle_Fiador = textArea_Fiador.getText();
				String detalle_Garantia = textArea_DetalleGarantia.getText();
				String detalle_Alquiler = textArea_Alquiler.getText();
				
				String tipoMoneda0 = (String) comboBox_tipoMoneda.getSelectedItem();
				
				
					int tipoMoneda;
					
						tipoMoneda = controladorList.obtenerIdMonedaLista(tipoMoneda0);
					
				
					String refArrendatario0 = textField_refArrendatario.getText();
					int refArrendatario = Integer.parseInt(refArrendatario0);
									
					int idInmueble;
					if(rdbtnListaInmuebleRef.isSelected()){
						String ref =(String) comboBox_refInmueble.getSelectedItem();						
						idInmueble = Integer.parseInt(ref);
					}else{
						String ref = textField_refInm.getText();
						idInmueble = Integer.parseInt(ref);
						}
					
					
					controladorUpdate.updateAlquileres(refAlquiler, refArrendatario, idInmueble, 
							fechaEgreso, precioAlquiler, plazoContractual, garantia1, garantia2, 
							nombreFiador, celFiador, emailFiador, detalle_Fiador, detalle_Garantia, 
							detalle_Alquiler, tipoMoneda);
					
					JOptionPane.showMessageDialog(null, "Alquiler Ref - "+refAlquiler+" actualizado correctamente\nGracias por su tiempo","Mensaje",JOptionPane.ERROR_MESSAGE, img);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
					JOptionPane.showMessageDialog(null, "Error"+e1,"Mensaje",JOptionPane.ERROR_MESSAGE, img);
				}
				
				
				
			}
		});
		button_1.setFont(new Font("Dialog", Font.BOLD, 14));
		button_1.setBounds(918, 83, 175, 32);
		contentPane.add(button_1);
		
		Button button_2 = new Button("Borrar Datos");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String refAlquiler0 = textFieldRefAlquiler.getText();
				int refAlquiler = Integer.parseInt(refAlquiler0);
				
				String refArrendatario0 = textField_refArrendatario.getText();
				int refArrendatario = Integer.parseInt(refArrendatario0);
				
				ControladorDelete controladorDelete = new ControladorDelete();
				try {
					controladorDelete.eliminarAlquiler(refAlquiler);
					JOptionPane.showMessageDialog(null, "Se han eliminado los datos del alquiler correctamente \n Gracias por su tiempo.","Mensaje",JOptionPane.ERROR_MESSAGE, img);
					
					controladorDelete.eliminarArrendatario(refArrendatario);
					JOptionPane.showMessageDialog(null, "Se han eliminado los datos del arrendatario correctamente \n Gracias por su tiempo.","Mensaje",JOptionPane.ERROR_MESSAGE, img);
					
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
				
				
				comboBox_tipoMoneda.setSelectedIndex(0);
				textField_Celfia.setText(null);
				textField_PrecioAlquiler.setToolTipText(null);
				textField_plazoContractual.setText(null);
				textField_RutaPdf.setText(null);
				textArea_Imprime.setText(null);
				textFieldRefAlquiler.setText(null);
				comboBox_tipoMoneda.setSelectedIndex(0);
				textField_PrecioAlquiler.setText(null);
				comboBox_Garantia_1.setSelectedIndex(0);
				comboBox_Garantia_2.setSelectedIndex(0);
				textField_Nombre_fia.setText(null);
				textField_Email_fia.setText(null);
				textField_Celfia.setText(null);
				textArea_Fiador.setText(null);
				textField_NombreArrendatario.setText(null);
				textField_Tel_Arrendatario.setText(null);
				textField_Email_Arrendatario.setText(null);
				textField_horarioContacto.setText(null);
				textArea_detallePersona.setText(null);
				textArea_Alquiler.setText(null);

				
				
				
				
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
	       
	       GhostText ghostText2 = new GhostText(textField_PrecioAlquiler, "");
	       textField_PrecioAlquiler.setPreferredSize(new Dimension(300, 24));
	       
	       GhostText ghostText3 = new GhostText(textField_plazoContractual, "");
	       textField_plazoContractual.setPreferredSize(new Dimension(300, 24));
	       
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
	       label_Asterisco3.setBounds(540, 68, 28, 14);
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
	       
	       JLabel lblAos = new JLabel("a\u00F1os.");
	       lblAos.setHorizontalAlignment(SwingConstants.LEFT);
	       lblAos.setForeground(Color.WHITE);
	       lblAos.setFont(new Font("Tahoma", Font.BOLD, 13));
	       lblAos.setBounds(499, 67, 54, 23);
	       panel_1.add(lblAos);
	       
	       GhostText ghostText5 = new GhostText(textField_RutaPdf, "");
	       textField_RutaPdf.setPreferredSize(new Dimension(300, 24));
	       
	       JButton btnResumen = new JButton("Resumen");
	       btnResumen.addActionListener(new ActionListener() {
	       	public void actionPerformed(ActionEvent e) {
	       		
	       		       		
	       		textArea_Imprime.setText("\tRESUMEN ALQUILERES:\n\n"+"\n\t*Ref:: \t"+ textFieldRefAlquiler.getText()
				+"\nCARACTERISTICAS \n"
				+ "\t*PRECIO: \t"+ comboBox_tipoMoneda.getSelectedItem()+" "+textField_PrecioAlquiler.getText()
				+"\n\t*FECHA EGRESO \t"+ dateChooser_fechaEgreso.getDate()+"\t*Plazo Contractual: "+textField_plazoContractual.getText()+" años."+
				"\nGARANTÍA"
				+ "\n\t*Garantía Principal: "+ comboBox_Garantia_1.getSelectedItem() + ", Garantía Secundaria:\t"+(String) comboBox_Garantia_2.getSelectedItem()+""
				+ "\n\t*Detalle garantía: "+ textArea_DetalleGarantia.getText()+""
				+ "\n\t*Datos Fiador "+ textField_Nombre_fia.getText()+","+textField_Email_fia.getText()+", "+textField_Celfia.getText()+","+", "+textArea_Fiador.getText()	+"\n\n"+
				"\nARRENDATARIO"+
				"\n\t***** Nombre:\t\t "+ textField_NombreArrendatario.getText() +
				"\n\t***** Tel: " + textField_Tel_Arrendatario.getText() +
				"\n\t***** Email: " + textField_Email_Arrendatario.getText()+
				"\n\t***** Horario contacto: " + textField_horarioContacto.getText() +
				"\n\t***** Detalle individuo: " + textArea_detallePersona.getText()+
				"\n\t----------------------------------------------------------- "+
				"\n\n\t***** Detalle arrendamiento: \t\t "+textArea_Alquiler.getText()
				);
	       		
	       		
	       		
	       		
	       		
	       		
	       		
	       		
	       	}
	       });
	       btnResumen.setFont(new Font("Tahoma", Font.BOLD, 14));
	       btnResumen.setBounds(503, 25, 167, 23);
	       panel_6.add(btnResumen);
	       
	       
	       GhostText ghostText12 = new GhostText(textField_Celfia, "");
	       textField_Celfia.setPreferredSize(new Dimension(300, 24));
	       
	       label_Asterisco8.setForeground(Color.RED);
	       label_Asterisco8.setFont(new Font("Tahoma", Font.BOLD, 20));
	       label_Asterisco8.setBounds(258, 89, 28, 14);
	       panel.add(label_Asterisco8);
	       
	       label_Asterisco9.setForeground(Color.RED);
	       label_Asterisco9.setFont(new Font("Tahoma", Font.BOLD, 20));
	       label_Asterisco9.setBounds(258, 64, 28, 14);
	       panel.add(label_Asterisco9);
	       
	       JLabel lblNombre = new JLabel("Nombre:");
	       lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
	       lblNombre.setForeground(Color.WHITE);
	       lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
	       lblNombre.setBounds(283, 52, 90, 23);
	       panel.add(lblNombre);
	       
	       textField_Nombre_fia = new JTextField();
	       
	       textField_Nombre_fia.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					
					if(textField_Nombre_fia.getText().length()>=50){
						arg0.consume();
					}
					
				}
			});
	       
	       
	       textField_Nombre_fia.setBounds(383, 55, 234, 20);
	       panel.add(textField_Nombre_fia);
	       textField_Nombre_fia.setColumns(10);
	       
	       JSeparator separator = new JSeparator();
	       separator.setOrientation(SwingConstants.VERTICAL);
	       separator.setBounds(296, 44, 33, 150);
	       panel.add(separator);
	       
	       JLabel lblEmail = new JLabel("Email:");
	       lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
	       lblEmail.setForeground(Color.WHITE);
	       lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
	       lblEmail.setBounds(283, 86, 90, 23);
	       panel.add(lblEmail);
	       
	       textField_Email_fia = new JTextField();
	       
	       textField_Nombre_fia.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					
					if(textField_Nombre_fia.getText().length()>=50){
						arg0.consume();
					}
					
				}
			});
	       
	       textField_Email_fia.setColumns(10);
	       textField_Email_fia.setBounds(383, 88, 234, 20);
	       panel.add(textField_Email_fia);
	       
	       JScrollPane scrollPane = new JScrollPane();
	       scrollPane.setBounds(53, 127, 202, 67);
	       panel.add(scrollPane);
	       
	      
	       scrollPane.setViewportView(textArea_DetalleGarantia);
	       
	       JLabel lblFiador = new JLabel(" *** Datos Fiador ***");
	       lblFiador.setHorizontalAlignment(SwingConstants.CENTER);
	       lblFiador.setForeground(Color.WHITE);
	       lblFiador.setFont(new Font("Tahoma", Font.BOLD, 13));
	       lblFiador.setBounds(414, 19, 157, 23);
	       panel.add(lblFiador);
	       
	       JScrollPane scrollPane_1 = new JScrollPane();
	       scrollPane_1.setBounds(383, 155, 234, 39);
	       panel.add(scrollPane_1);
	       
	       
	       scrollPane_1.setViewportView(textArea_Fiador);
	       
	       comboBox_Garantia_1.setModel(new DefaultComboBoxModel(new String[] {"", "CGN", "ANDA", "PORTO", "BHU", "FIANZA", "FIADOR ", "OTRO"}));
	       comboBox_Garantia_1.setBounds(130, 57, 125, 23);
	       panel.add(comboBox_Garantia_1);
	       
	       comboBox_Garantia_2.setModel(new DefaultComboBoxModel(new String[] {"", "BHU", "FIANZA", "FIADOR"}));
	       comboBox_Garantia_2.setBounds(130, 89, 125, 23);
	       panel.add(comboBox_Garantia_2);
	       
	       lblGaranta.setHorizontalAlignment(SwingConstants.RIGHT);
	       lblGaranta.setForeground(Color.WHITE);
	       lblGaranta.setFont(new Font("Tahoma", Font.BOLD, 13));
	       lblGaranta.setBounds(30, 55, 90, 23);
	       panel.add(lblGaranta);
	       
	       lblGaranta_1.setHorizontalAlignment(SwingConstants.RIGHT);
	       lblGaranta_1.setForeground(Color.WHITE);
	       lblGaranta_1.setFont(new Font("Tahoma", Font.BOLD, 13));
	       lblGaranta_1.setBounds(30, 89, 90, 23);
	       panel.add(lblGaranta_1);
	       
	       JScrollPane scrollPane_3 = new JScrollPane();
	       scrollPane_3.setBounds(31, 24, 501, 61);
	       panel_4.add(scrollPane_3);
	       
	       scrollPane_3.setViewportView(textArea_Alquiler);
	       	       
	       ImageIcon imagen4 = new ImageIcon(VentanaAlquileres.class.getResource("flecha.png"));
			
			JPanel panel_8 = new JPanel();
			panel_8.setOpaque(false);
			panel_8.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "  Inmueble  Identificador ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
			panel_8.setBounds(320, 37, 454, 129);
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
			panel_9.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "  Identificador Alquiler  ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
			panel_9.setBounds(33, 37, 259, 129);
			contentPane.add(panel_9);
			
			JLabel label_13 = new JLabel("Referencia:");
			label_13.setHorizontalAlignment(SwingConstants.RIGHT);
			label_13.setForeground(Color.WHITE);
			label_13.setFont(new Font("Tahoma", Font.BOLD, 13));
			label_13.setBounds(38, 34, 126, 23);
			panel_9.add(label_13);
			
			textFieldRefAlquiler = new JTextField();
			
			textFieldRefAlquiler.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					
						char c = arg0.getKeyChar();
						if (c<'0'|| c>'9'){ 
							arg0.consume();
						}
						if(textFieldRefAlquiler.getText().length()>=5){
							arg0.consume();
				}}
			});
			
			
			textFieldRefAlquiler.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldRefAlquiler.setFont(new Font("Tahoma", Font.BOLD, 22));
			textFieldRefAlquiler.setColumns(10);
			textFieldRefAlquiler.setBounds(89, 68, 75, 43);
			panel_9.add(textFieldRefAlquiler);
			
			
			label_Asterisco7.setForeground(Color.RED);
			label_Asterisco7.setFont(new Font("Tahoma", Font.BOLD, 20));
			label_Asterisco7.setBounds(174, 87, 28, 14);
			panel_9.add(label_Asterisco7);
			
			
			//------------------------------------ FLECHA CON ACCION ------------------------------//
		       
		       JLabel label_14 = new JLabel("");
		       label_14.setBounds(816, 65, 56, 62);
		       ImageIcon imagenFlecha = new ImageIcon(VentanaAlquileres.class.getResource("flecha.png"));
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
		       
		       JPanel panel_2 = new JPanel();
		       panel_2.setOpaque(false);
		       panel_2.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "  Detalles Arrendatario      ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		       panel_2.setBounds(702, 182, 573, 257);
		       contentPane.add(panel_2);
		       panel_2.setLayout(null);
		       
		       JLabel label_1 = new JLabel("Tel\u00E9fono:");
		       label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		       label_1.setForeground(Color.WHITE);
		       label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		       label_1.setBounds(40, 79, 80, 23);
		       panel_2.add(label_1);
		       
		       JLabel label_16 = new JLabel("Horario Contacto:");
		       label_16.setHorizontalAlignment(SwingConstants.RIGHT);
		       label_16.setForeground(Color.WHITE);
		       label_16.setFont(new Font("Tahoma", Font.BOLD, 13));
		       label_16.setBounds(10, 105, 134, 23);
		       panel_2.add(label_16);
		       
		       JLabel label_17 = new JLabel("Nombre:");
		       label_17.setHorizontalAlignment(SwingConstants.RIGHT);
		       label_17.setForeground(Color.WHITE);
		       label_17.setFont(new Font("Tahoma", Font.BOLD, 13));
		       label_17.setBounds(40, 55, 80, 23);
		       panel_2.add(label_17);
		       
		       JLabel label_18 = new JLabel("id Persona:");
		       label_18.setHorizontalAlignment(SwingConstants.RIGHT);
		       label_18.setForeground(Color.WHITE);
		       label_18.setFont(new Font("Tahoma", Font.BOLD, 13));
		       label_18.setBounds(26, 26, 94, 23);
		       panel_2.add(label_18);
		       
		       JLabel label_20 = new JLabel("E-mail:");
		       label_20.setHorizontalAlignment(SwingConstants.RIGHT);
		       label_20.setForeground(Color.WHITE);
		       label_20.setFont(new Font("Tahoma", Font.BOLD, 13));
		       label_20.setBounds(285, 79, 70, 23);
		       panel_2.add(label_20);
		       
		       textField_horarioContacto = new JTextField();
		       
		       textField_horarioContacto.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent arg0) {
						
						if(textField_horarioContacto.getText().length()>=50){
							arg0.consume();
						}
						
					}
				});
		       
		       
		       textField_horarioContacto.setPreferredSize(new Dimension(300, 24));
		       textField_horarioContacto.setFont(new Font("Tahoma", Font.BOLD, 12));
		       textField_horarioContacto.setColumns(10);
		       textField_horarioContacto.setBounds(157, 108, 390, 20);
		       panel_2.add(textField_horarioContacto);
		       
		       textField_Tel_Arrendatario = new JTextField();
		       
		       textField_Tel_Arrendatario.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent arg0) {
						
							char c = arg0.getKeyChar();
							if (c<'0'|| c>'9'){ 
								arg0.consume();
							}
							if(textField_Tel_Arrendatario.getText().length()>=5){
								arg0.consume();
					}}
				});
		       
		       
		       textField_Tel_Arrendatario.setPreferredSize(new Dimension(300, 24));
		       textField_Tel_Arrendatario.setFont(new Font("Tahoma", Font.BOLD, 12));
		       textField_Tel_Arrendatario.setColumns(10);
		       textField_Tel_Arrendatario.setBounds(156, 82, 103, 20);
		       panel_2.add(textField_Tel_Arrendatario);
		       
		       textField_NombreArrendatario = new JTextField();
		       
		       textField_NombreArrendatario.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent arg0) {
						
						if(textField_NombreArrendatario.getText().length()>=50){
							arg0.consume();
						}
						
					}
				});
		       
		       
		       textField_NombreArrendatario.setPreferredSize(new Dimension(300, 24));
		       textField_NombreArrendatario.setFont(new Font("Tahoma", Font.BOLD, 12));
		       textField_NombreArrendatario.setColumns(10);
		       textField_NombreArrendatario.setBounds(156, 58, 391, 20);
		       panel_2.add(textField_NombreArrendatario);
		       
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
					}}
				});
		       
		       
		       textField_idPersona.setPreferredSize(new Dimension(300, 24));
		       textField_idPersona.setFont(new Font("Tahoma", Font.BOLD, 12));
		       textField_idPersona.setColumns(10);
		       textField_idPersona.setBounds(154, 31, 52, 20);
		       panel_2.add(textField_idPersona);
		       
		       textField_Email_Arrendatario = new JTextField();
		       
		       textField_Email_Arrendatario.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent arg0) {
						
						if(textField_Email_Arrendatario.getText().length()>=50){
							arg0.consume();
						}
						
					}
				});
		       
		       
		       textField_Email_Arrendatario.setPreferredSize(new Dimension(300, 24));
		       textField_Email_Arrendatario.setFont(new Font("Tahoma", Font.BOLD, 12));
		       textField_Email_Arrendatario.setColumns(10);
		       textField_Email_Arrendatario.setBounds(368, 84, 179, 20);
		       panel_2.add(textField_Email_Arrendatario);
		       
		       JScrollPane scrollPane_4 = new JScrollPane();
		       scrollPane_4.setBounds(26, 170, 261, 59);
		       panel_2.add(scrollPane_4);
		       
		       
		       scrollPane_4.setViewportView(textArea_detallePersona);
		       
		       JLabel label_21 = new JLabel("Detalle Persona:");
		       label_21.setHorizontalAlignment(SwingConstants.RIGHT);
		       label_21.setForeground(Color.WHITE);
		       label_21.setFont(new Font("Tahoma", Font.BOLD, 13));
		       label_21.setBounds(10, 147, 134, 23);
		       panel_2.add(label_21);
		       
		       
		       label_Asterisco5.setHorizontalAlignment(SwingConstants.RIGHT);
		       label_Asterisco5.setForeground(Color.RED);
		       label_Asterisco5.setFont(new Font("Tahoma", Font.BOLD, 21));
		       label_Asterisco5.setBounds(185, 30, 40, 23);
		       panel_2.add(label_Asterisco5);
		       
		       JButton btn_IngresoPersona = new JButton("Ingresar Persona");
		       btn_IngresoPersona.addActionListener(new ActionListener() {
		       	public void actionPerformed(ActionEvent arg0) {
		       		
		       	//******************************* INGRESO DATOS ARRENDATARIO Y PERSONA ******************//
					
					String idPersona0 = textField_idPersona.getText();
					int idPersona = Integer.parseInt(idPersona0);
					
					String nombrePer = textField_NombreArrendatario.getText();
					
					String emailPer = textField_Email_Arrendatario.getText();
					
					String detallePer = textArea_detallePersona.getText();
					
					try {
						controladorInsert.nuevaPersona(idPersona, nombrePer, emailPer, detallePer);
						
						JOptionPane.showMessageDialog(null, "Se han ingresado correctamente todos los datos\n de PERSONA");
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Error" + e1);
					}
	       			
	       			
					
					
		       		
		       		
		       	}
		       });
		       btn_IngresoPersona.setBounds(316, 172, 188, 23);
		       panel_2.add(btn_IngresoPersona);
		       
		       JButton btnIngresarTelfono = new JButton("Ingresar Tel\u00E9fono");
		       btnIngresarTelfono.addActionListener(new ActionListener() {
		       	public void actionPerformed(ActionEvent e) {
		       		
		       		//---------------------------------------- INGRESO LOS DATOS DE TELÉFONO ------------------//
	       			
	       			String idPersona0 = textField_idPersona.getText();
					int idPersona = Integer.parseInt(idPersona0);
	       			
	       			
	       			String telPersona0 = textField_Tel_Arrendatario.getText();
	       			int telPersona = Integer.parseInt(telPersona0);
	       			String detalleTel = textField_horarioContacto.getText();
	       			
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
		       });
		       btnIngresarTelfono.setBounds(316, 206, 188, 23);
		       panel_2.add(btnIngresarTelfono);
		       
		       JLabel lblIdArrendatario = new JLabel("id Arrendatario:");
		       lblIdArrendatario.setBounds(263, 26, 126, 23);
		       panel_2.add(lblIdArrendatario);
		       lblIdArrendatario.setHorizontalAlignment(SwingConstants.RIGHT);
		       lblIdArrendatario.setForeground(Color.WHITE);
		       lblIdArrendatario.setFont(new Font("Tahoma", Font.BOLD, 13));
		       textField_refArrendatario = new JTextField();
		       
		       textField_refArrendatario.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent arg0) {
						
							char c = arg0.getKeyChar();
							if (c<'0'|| c>'9'){ 
								arg0.consume();
							}
							if(textField_refArrendatario.getText().length()>=5){
								arg0.consume();
					}}
				});
		       
		       
		       textField_refArrendatario.setBounds(403, 25, 39, 23);
		       panel_2.add(textField_refArrendatario);
		       
		      
		       textField_refArrendatario.setHorizontalAlignment(SwingConstants.CENTER);
		       textField_refArrendatario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		       textField_refArrendatario.setColumns(10);
		       JLabel label_Asterisco = new JLabel("*");
		       label_Asterisco.setBounds(452, 27, 30, 23);
		       panel_2.add(label_Asterisco);
		       
		       label_Asterisco.setVisible(false);
		       
		      
		       label_Asterisco.setHorizontalAlignment(SwingConstants.LEFT);
		       label_Asterisco.setForeground(Color.RED);
		       label_Asterisco.setFont(new Font("Tahoma", Font.BOLD, 19));
	
		
	}
}
