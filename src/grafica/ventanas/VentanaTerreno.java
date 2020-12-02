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
import logicapersistencia.valueObjects.VOcasas;
import logicapersistencia.valueObjects.VOinmueble;
import logicapersistencia.valueObjects.VOterrenos;
import logicapersistencia.valueObjects.VOterrenosSoloTerrenos;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class VentanaTerreno extends JFrame {

	private Fondo contentPane;
	private JTextField textField_AreaEdificable;
	private JTextField textField_AreaTotal;
	private JTextField textField_MetrosFrente;
	private JTextField textFieldRutaImagen;
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
	private DefaultTableModel modelo;
	private JTextField textFieldRefTerreno;
	Icon img = new ImageIcon(getClass().getResource("uy2.png"));
	public JTextField textField_refInm;
	private JTextField textField_FactorOcupacionSuelo;
	private JTextField textField_coneat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaTerreno frame = new VentanaTerreno();
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
	
	
	public VentanaTerreno() {
		
		JCheckBox checkBox_mejoras = new JCheckBox("Con Mejoras");
		JComboBox comboBox_TiposSuelos = new JComboBox();
		comboBox_TiposSuelos.setModel(new DefaultComboBoxModel(new String[] {"", "URBANO", "SUB-URBANO", "RURAL"}));
	    JComboBox comboBox_productividad = new JComboBox();
	    comboBox_productividad.setModel(new DefaultComboBoxModel(new String[] {"", "GANADERO", "AGR\u00CDCOLA", "VITIVINICOLA", "FRUTIVIN\u00CDCOLA"}));
		
		JLabel label_Asterisco7 = new JLabel("*");
		JLabel label_Asterisco6 = new JLabel("*");
		JLabel label_Asterisco5 = new JLabel("*");
		JLabel label_Asterisco4 = new JLabel("*");
		JLabel label_Asterisco2 = new JLabel("*");
		JLabel label_Asterisco1 = new JLabel("*");

		
		label_Asterisco1.setVisible(false);
		label_Asterisco2.setVisible(false);
		label_Asterisco4.setVisible(false);
		label_Asterisco5.setVisible(false);
		label_Asterisco6.setVisible(false);
		label_Asterisco7.setVisible(false);
		JLabel lblImagen = new JLabel("");
		
		JComboBox comboBox_refInmueble = new JComboBox();
		JRadioButton rdbtnEditarRefInm = new JRadioButton("Editar");
		JRadioButton rdbtnListaInmuebleRef = new JRadioButton("Lista");
		ControladorInsert controladorInsert = new ControladorInsert();

		//------------------------- IMAGEN POR DEFECTO -------------------------------------//
			
				ImageIcon imagenDefecto = new ImageIcon(this.getClass().getResource("img_defecto.png"));
				Image imagDefecto = imagenDefecto.getImage().getScaledInstance(179, 138, Image.SCALE_SMOOTH);
				lblImagen.setIcon(new ImageIcon(imagDefecto));
//				68, 37, 179, 138
		//******************************************************************************************//
		
		setBackground(UIManager.getColor("Button.foreground"));
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaTerreno.class.getResource("/grafica/ventanas/uy2.png")));
		setTitle("Gestor de Terreno");

		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(30, 30, 1316, 769);
		contentPane = new Fondo("primerFondo.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea_Detalles = new JTextArea();
		
		textArea_Detalles.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

						if(textArea_Detalles.getText().length()>=200){
							arg0.consume();
						}
													
					}
				});
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "  Caracter\u00EDsticas  ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel_1.setBounds(31, 177, 661, 302);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblreaTotal = new JLabel("\u00C1rea Total:");
		lblreaTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblreaTotal.setForeground(Color.WHITE);
		lblreaTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblreaTotal.setBounds(360, 59, 103, 23);
		panel_1.add(lblreaTotal);
		
		JLabel lblMetrosFrente = new JLabel("Metros Frente:");
		lblMetrosFrente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMetrosFrente.setForeground(Color.WHITE);
		lblMetrosFrente.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMetrosFrente.setBounds(360, 87, 103, 23);
		panel_1.add(lblMetrosFrente);
		
		textField_AreaEdificable = new JTextField();
		

		textField_AreaEdificable.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
					char c = arg0.getKeyChar();
					if (c<'0'|| c>'9'){ 
						arg0.consume();
					}
					if(textField_AreaEdificable.getText().length()>=9){
						arg0.consume();

				}

			}
		});
		
		textField_AreaEdificable.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_AreaEdificable.setBounds(473, 170, 86, 20);
		panel_1.add(textField_AreaEdificable);
		textField_AreaEdificable.setColumns(10);
		
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
		
		
		textField_AreaTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_AreaTotal.setColumns(10);
		textField_AreaTotal.setBounds(473, 61, 86, 20);
		panel_1.add(textField_AreaTotal);
		
		textField_MetrosFrente = new JTextField();
		
		textField_MetrosFrente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
					char c = arg0.getKeyChar();
					if (c<'0'|| c>'9'){ 
						arg0.consume();
					}
					if(textField_MetrosFrente.getText().length()>=9){
						arg0.consume();

				}

			}
		});
		
		
		textField_MetrosFrente.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_MetrosFrente.setColumns(10);
		textField_MetrosFrente.setBounds(473, 89, 86, 20);
		panel_1.add(textField_MetrosFrente);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setOpaque(false);
		panel_4.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "  Detalles      ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel_4.setBounds(702, 297, 573, 182);
		contentPane.add(panel_4);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(33, 490, 1242, 232);
		contentPane.add(tabbedPane);
		
		
		 //***************************************** TABLA INMUEBLES ******************************//
		
		Icon img = new ImageIcon(getClass().getResource("uy2.png"));  
      	
   		Object[] fila = new Object[40];
       
       table = new JTable();
       modelo = new DefaultTableModel();
		
			
		modelo.addColumn("idTerreno");
		modelo.addColumn("idInmueble");
		modelo.addColumn("FOS");
		modelo.addColumn("Altura Edificable");
		modelo.addColumn("Frente");
		modelo.addColumn("Situación Jurídica");
		modelo.addColumn("Productividad");
		modelo.addColumn("Mejoras");
		modelo.addColumn("Detalle");
		modelo.addColumn("RutaImg");
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(UIManager.getColor("CheckBox.darkShadow"));
		tabbedPane.addTab("Lista de Terrenos", null, panel_5, null);
		panel_5.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 18, 1217, 175);
		panel_5.add(scrollPane_2);
		
	
		//************************************ TABLA ***********************************//
		
		ControladorList controlador = new ControladorList();
		List<VOterrenosSoloTerrenos> lstTerrenos = controlador.listarTerrenosSoloTerrenos();
			if (lstTerrenos.size() > 0){	
				Iterator<VOterrenosSoloTerrenos> iterTerreno = lstTerrenos.iterator();
				while (iterTerreno.hasNext()){
					VOterrenosSoloTerrenos datosTerreno= iterTerreno.next();
									
					
					
					fila[0] = datosTerreno.getIdTerreno();
					fila[1] = datosTerreno.getIdInmueble();
					fila[2] = datosTerreno.getFOS();
					fila[3] = datosTerreno.getAlturaEdificable();
					fila[4] = datosTerreno.getFrente();
					fila[5] = datosTerreno.getSituacionJuridicaSuelo();
					fila[6] = datosTerreno.getProductividad();
					fila[7] = datosTerreno.getConMejoras();
					fila[8] = datosTerreno.getDetalleTerr();
					fila[9] = datosTerreno.getRutaImagenTerreno();
						
					modelo.addRow(fila);
				
				}
			}
			table = new JTable(modelo);	
			
			scrollPane_2.setViewportView(table);
			
			//**********************************************************//
			
//----------------- TOMO LOS VALORES DE LA TABLA -------------------------------//
			
			table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){

				@Override
				public void valueChanged(ListSelectionEvent e){
				if(table.getSelectedRow() !=-1){
					
				int fila = table.getSelectedRow();
//				try {
				
				textFieldRefTerreno.setText(table.getValueAt(fila,0).toString());
//
				String refInmueble = (table.getValueAt(fila,1).toString());
				int refInmueble1 = Integer.parseInt(refInmueble);
				comboBox_refInmueble.setSelectedItem(refInmueble1);
				
				textField_FactorOcupacionSuelo.setText(table.getValueAt(fila,2).toString());
				textField_AreaEdificable.setText(table.getValueAt(fila,3).toString());
				textField_MetrosFrente.setText(table.getValueAt(fila,4).toString());
				
				String tipoSuelo = (table.getValueAt(fila,5).toString());
				comboBox_TiposSuelos.setSelectedItem(tipoSuelo);
				
				String productividad = (table.getValueAt(fila,6).toString());
				comboBox_productividad.setSelectedItem(productividad);

				if(table.getValueAt(fila,7).toString().equals("SI")){
					checkBox_mejoras.setSelected(true);
				}else{
					checkBox_mejoras.setSelected(false);
				}
				
				textArea_Detalles.setText(table.getValueAt(fila,8).toString());
				textFieldRutaImagen.setText(table.getValueAt(fila,9).toString());
								
//------------------------ TOMA LA RUTA DE LA FOTO ---------------------//
				
				Image foto = getToolkit().getImage(textFieldRutaImagen.getText());
				foto = foto.getScaledInstance(179, 138, Image.SCALE_DEFAULT);
				lblImagen.setIcon(new ImageIcon (foto));
		
				//C:\Users\Mariu\Desktop\img\img_defecto.png
			
}
}
});
				//----------------------------------------------------------------------------------//
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(UIManager.getColor("CheckBox.darkShadow"));
		tabbedPane.addTab("Generar PDF", null, panel_6, null);
		panel_6.setLayout(null);
		
		TextArea textArea_Imprime = new TextArea();
		textArea_Imprime.setBounds(21, 61, 1182, 122);
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
		
		JPanel panel_7 = new JPanel();
		panel_7.setOpaque(false);
		panel_7.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "  Fotos      ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel_7.setBounds(702, 24, 323, 262);
		contentPane.add(panel_7);
		panel_7.setLayout(null);
		
		
		lblImagen.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblImagen.setBounds(68, 37, 179, 138);
		panel_7.add(lblImagen);
		
		JLabel lblRuta = new JLabel("Ruta:");
		lblRuta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRuta.setForeground(Color.WHITE);
		lblRuta.setBounds(68, 186, 46, 14);
		panel_7.add(lblRuta);
		
		textFieldRutaImagen = new JTextField();
		
		textFieldRutaImagen.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

						if(textFieldRutaImagen.getText().length()>=200){
							arg0.consume();
						}
													
					}
				});
		
		
		textFieldRutaImagen.setFont(new Font("Dialog", Font.BOLD, 12));
		textFieldRutaImagen.setBounds(105, 186, 138, 20);
		panel_7.add(textFieldRutaImagen);
		textFieldRutaImagen.setColumns(10);
		
		JButton btnNewButton = new JButton("Ingresar Foto");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// ************************** BUSCA RUTA PARA BUSCAR JPG***************//
				
				FileNameExtensionFilter filtro = new FileNameExtensionFilter("Formatos de archivo JPG(*.jpg; *.png)","jpg","png");
				
				JFileChooser dlg= new JFileChooser();
				dlg.addChoosableFileFilter(filtro);
				dlg.setDialogTitle("Abrir archivo");
				File ruta = new File("C:/Users/Mariu/Desktop/img");
				dlg.setCurrentDirectory(ruta);
				
				int option = dlg.showSaveDialog(btnNewButton);
				
				if (option == JFileChooser.APPROVE_OPTION) {
					
					File f=dlg.getSelectedFile();
					textFieldRutaImagen.setText(f.toString());
					String fotoRuta = textFieldRutaImagen.getText();
					
					Image foto = getToolkit().getImage(textFieldRutaImagen.getText());
					foto = foto.getScaledInstance(179, 138, Image.SCALE_DEFAULT);
					lblImagen.setIcon(new ImageIcon (foto));
				
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(68, 216, 179, 23);
		panel_7.add(btnNewButton);
		
		Button button = new Button("Ingresar Datos");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				if(
						textFieldRefTerreno.getText().equals("") || 
						comboBox_refInmueble.getSelectedItem().equals("")||
						textField_AreaEdificable.getText().equals("") ||
						textField_AreaTotal.getText().equals("") ||
						textField_MetrosFrente.getText().equals("") ){
       			
       			

       				label_Asterisco1.setVisible(true);
       				label_Asterisco2.setVisible(true);
       				
       				label_Asterisco4.setVisible(true);
       				label_Asterisco5.setVisible(true);
       				label_Asterisco6.setVisible(true);
       				label_Asterisco7.setVisible(true);
       			

       				
       				JOptionPane.showMessageDialog(null, "Por favor completar los campos obligatorios, gracias");
       			
       			
       			} else{
       				

       				label_Asterisco1.setVisible(false);
       				label_Asterisco2.setVisible(false);
       				
       				label_Asterisco4.setVisible(false);
       				label_Asterisco5.setVisible(false);
       				label_Asterisco6.setVisible(false);
       				label_Asterisco7.setVisible(false);
       				
       				
       				
       				JOptionPane.showMessageDialog(null, "Campos obligatorios completos","Mensaje",JOptionPane.ERROR_MESSAGE, img);
       	
			}
				
						String refT = textFieldRefTerreno.getText();
						int idTerreno = Integer.parseInt(refT);
					
						String aEdif = textField_AreaEdificable.getText();
						double alturaEdificable = Double.parseDouble(aEdif);
						
						String mFte = textField_MetrosFrente.getText();
						double frente = Double.parseDouble(mFte);
						
						String detalleTerr = textArea_Detalles.getText();
						
						String FOS_1 = textField_FactorOcupacionSuelo.getText();
						int FOS = Integer.parseInt(FOS_1);
						
						String situacionJuridica = (String) comboBox_TiposSuelos.getSelectedItem();
						String productividad = (String) comboBox_productividad.getSelectedItem();
						
						
						String conMejoras;
						if(checkBox_mejoras.isSelected()){
							conMejoras="SI";
			       			}else{
			       			conMejoras ="NO";}

					try {
					
						int idInmueble;
						
					if(rdbtnListaInmuebleRef.isSelected()){
						String ref =(String) comboBox_refInmueble.getSelectedItem();	
						String ref0 = ref;
						idInmueble = Integer.parseInt(ref0);
					}else{
						String ref = textField_refInm.getText();
						idInmueble = Integer.parseInt(ref);
						}
						
						String rutaImagenTerreno = textFieldRutaImagen.getText();
						ControladorComparar controladorComparar = new ControladorComparar();
						
						if(controladorComparar.existeTerreno(idTerreno)){
							
							JOptionPane.showMessageDialog(null,"Chequéa la referencia del Terreno. \n YA EXISTE DICHA REF", "Mensaje - Lalk Negocios Inmobiliarios", JOptionPane.ERROR_MESSAGE, img);
							
						}else{
														
							controladorInsert.nuevoTerreno(idTerreno, idInmueble, FOS, alturaEdificable, frente, 
									situacionJuridica, productividad, conMejoras, detalleTerr, rutaImagenTerreno);
							
						}
						JOptionPane.showMessageDialog(null,"Se han ingresado correctamente sus registros.\n Gracias por su tiempo.", "Mensaje - Lalk Negocios Inmobiliarios", JOptionPane.ERROR_MESSAGE, img);
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				


				
				
				}	
			
		});
		button.setFont(new Font("Dialog", Font.BOLD, 14));
		button.setBounds(1055, 29, 175, 32);
		contentPane.add(button);
		
		Button button_1 = new Button("Actualizar Datos");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					System.out.println("linea 660");
				String refT = textFieldRefTerreno.getText();
				int idTerreno = Integer.parseInt(refT);
			
				String aEdif = textField_AreaEdificable.getText();
				double alturaEdificable = Double.parseDouble(aEdif);
				
				String mFte = textField_MetrosFrente.getText();
				double frente = Double.parseDouble(mFte);
				
				String detalleTerr = textArea_Detalles.getText();
				
				String FOS_1 = textField_FactorOcupacionSuelo.getText();
				int FOS = Integer.parseInt(FOS_1);
				
				String situacionJuridica = (String) comboBox_TiposSuelos.getSelectedItem();
				String productividad = (String) comboBox_productividad.getSelectedItem();
				
				
				String conMejoras;
				if(checkBox_mejoras.isSelected()){
					conMejoras="SI";
	       			}else{
	       			conMejoras ="NO";}
				int idInmueble;
				
				if(rdbtnListaInmuebleRef.isSelected()){
					String ref =(String) comboBox_refInmueble.getSelectedItem();	
					String ref0 = ref;
					idInmueble = Integer.parseInt(ref0);
				}else{
					String ref = textField_refInm.getText();
					idInmueble = Integer.parseInt(ref);
					}
					
					String rutaImagenTerreno = textFieldRutaImagen.getText();
				
					System.out.println("linea 697");
				
					ControladorUpdate controladorUpdate = new ControladorUpdate();
						controladorUpdate.updateTerreno(idTerreno, idInmueble, FOS, alturaEdificable, 
						frente, situacionJuridica, productividad, conMejoras, detalleTerr, 
						rutaImagenTerreno);
				
				JOptionPane.showMessageDialog(null,"Se han modificado correctamente sus registros.\n Gracias por su tiempo.", "Mensaje - Lalk Negocios Inmobiliarios", JOptionPane.ERROR_MESSAGE, img);
				
				System.out.println("linea 704");
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Error MYSQL - "+e1);
				e1.printStackTrace();
			}
				
			}
		});
		button_1.setFont(new Font("Dialog", Font.BOLD, 14));
		button_1.setBounds(1055, 67, 175, 32);
		contentPane.add(button_1);
		
		Button button_2 = new Button("Borrar Datos");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
					String referenciaTerreno=textFieldRefTerreno.getText();
					int refTerreno = Integer.parseInt(referenciaTerreno);
					
					int resp=JOptionPane.showConfirmDialog(null,"¿Quiere borrar el registro Ref Nº"+ refTerreno +"?","Mensaje",JOptionPane.ERROR_MESSAGE);
				      if (JOptionPane.OK_OPTION == resp){
				    	  
				    	  ControladorDelete controladorEliminar = new ControladorDelete();
				    	  ControladorComparar controladorComparar = new ControladorComparar();
				    	  try {
				    		  
				    		 if (controladorComparar.existeTerreno(refTerreno)==true){
				    		  controladorEliminar.eliminarTerreno(refTerreno);
				    		  JOptionPane.showMessageDialog(null, "Has borrado correctamente el registro. \nGracias por su tiempo","Mensaje",JOptionPane.ERROR_MESSAGE, img);
				    		  }else{
				    			  JOptionPane.showMessageDialog(null, "No hay registro \nGracias por su tiempo","Mensaje",JOptionPane.ERROR_MESSAGE, img);
				    		  }
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
		button_2.setFont(new Font("Dialog", Font.BOLD, 14));
		button_2.setBounds(1055, 105, 175, 32);
		contentPane.add(button_2);
		
		Button button_3 = new Button("Resetear");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				textArea_Detalles.setText(null);
				lblImagen.setText("");
				textFieldRutaImagen.setText(null);
				textField_RutaPdf.setText(null);
				textArea_Imprime.setText(null);
				textFieldRefTerreno.setText(null);
				comboBox_TiposSuelos.setSelectedItem("");
				comboBox_productividad.setSelectedItem("");
				textField_coneat.setText("");
				textField_AreaTotal.setText("");
				textField_MetrosFrente.setText("");
				textField_AreaEdificable.setText("");
				textField_FactorOcupacionSuelo.setText("");
				textFieldRefTerreno.setText("");
				comboBox_refInmueble.setSelectedItem("");
				textField_refInm.setText("");
				
			}
		});
		button_3.setFont(new Font("Dialog", Font.BOLD, 14));
		button_3.setBounds(1055, 142, 175, 32);
		contentPane.add(button_3);
		
		Button button_4 = new Button("Cerrar");
		button_4.setForeground(Color.RED);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		button_4.setFont(new Font("Dialog", Font.BOLD, 15));
		button_4.setBounds(1055, 241, 175, 32);
		contentPane.add(button_4);
		
		
		
		
		//************************************************ SOMBRAS ******************************//
		
		 JFrame frame = new JFrame();
	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       
	       GhostText ghostText2 = new GhostText(textField_AreaEdificable, "");
	       textField_AreaEdificable.setPreferredSize(new Dimension(300, 24));
	       
	       GhostText ghostText3 = new GhostText(textField_AreaTotal, "");
	       textField_AreaTotal.setPreferredSize(new Dimension(300, 24));
	       
	       GhostText ghostText4 = new GhostText(textField_MetrosFrente, "");
	       textField_MetrosFrente.setPreferredSize(new Dimension(300, 24));
	       
	       JLabel lblM = new JLabel("m2");
	       lblM.setHorizontalAlignment(SwingConstants.LEFT);
	       lblM.setForeground(Color.WHITE);
	       lblM.setFont(new Font("Tahoma", Font.BOLD, 13));
	       lblM.setBounds(569, 168, 28, 23);
	       panel_1.add(lblM);
	       
	       JLabel label_1 = new JLabel("m2");
	       label_1.setHorizontalAlignment(SwingConstants.LEFT);
	       label_1.setForeground(Color.WHITE);
	       label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
	       label_1.setBounds(569, 59, 28, 23);
	       panel_1.add(label_1);
	       
	       JLabel lblNmts = new JLabel("mts");
	       lblNmts.setHorizontalAlignment(SwingConstants.LEFT);
	       lblNmts.setForeground(Color.WHITE);
	       lblNmts.setFont(new Font("Tahoma", Font.BOLD, 13));
	       lblNmts.setBounds(569, 92, 28, 23);
	       panel_1.add(lblNmts);
	       
	       label_Asterisco1.setFont(new Font("Tahoma", Font.BOLD, 20));
	       label_Asterisco1.setForeground(Color.RED);
	       label_Asterisco1.setBounds(335, 88, 28, 14);
	       panel_1.add(label_Asterisco1);
	       
	       label_Asterisco2.setForeground(Color.RED);
	       label_Asterisco2.setFont(new Font("Tahoma", Font.BOLD, 20));
	       label_Asterisco2.setBounds(335, 59, 28, 14);
	       panel_1.add(label_Asterisco2);
	       
	       label_Asterisco4.setForeground(Color.RED);
	       label_Asterisco4.setFont(new Font("Tahoma", Font.BOLD, 20));
	       label_Asterisco4.setBounds(596, 64, 28, 14);
	       panel_1.add(label_Asterisco4);
	       
	       label_Asterisco5.setForeground(Color.RED);
	       label_Asterisco5.setFont(new Font("Tahoma", Font.BOLD, 20));
	       label_Asterisco5.setBounds(596, 97, 28, 14);
	       panel_1.add(label_Asterisco5);
	       
	       JLabel label_15 = new JLabel("Altura Edificable:");
	       label_15.setHorizontalAlignment(SwingConstants.RIGHT);
	       label_15.setForeground(Color.WHITE);
	       label_15.setFont(new Font("Tahoma", Font.BOLD, 13));
	       label_15.setBounds(337, 168, 126, 23);
	       panel_1.add(label_15);
	       
	       JLabel label_16 = new JLabel("FOS:");
	       label_16.setHorizontalAlignment(SwingConstants.RIGHT);
	       label_16.setForeground(Color.WHITE);
	       label_16.setFont(new Font("Tahoma", Font.BOLD, 13));
	       label_16.setBounds(337, 202, 126, 23);
	       panel_1.add(label_16);
	       
	       textField_FactorOcupacionSuelo = new JTextField();
	       
	       textField_FactorOcupacionSuelo.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					
						char c = arg0.getKeyChar();
						if (c<'0'|| c>'9'){ 
							arg0.consume();
						}
						if(textField_FactorOcupacionSuelo.getText().length()>=3){
							arg0.consume();
				}}
			});
	       
	       textField_FactorOcupacionSuelo.setPreferredSize(new Dimension(300, 24));
	       textField_FactorOcupacionSuelo.setColumns(10);
	       textField_FactorOcupacionSuelo.setBounds(476, 204, 86, 20);
	       panel_1.add(textField_FactorOcupacionSuelo);
	       
	       JLabel label_17 = new JLabel("%");
	       label_17.setHorizontalAlignment(SwingConstants.LEFT);
	       label_17.setForeground(Color.WHITE);
	       label_17.setFont(new Font("Tahoma", Font.BOLD, 13));
	       label_17.setBounds(565, 202, 42, 23);
	       panel_1.add(label_17);
	       
	       
	       checkBox_mejoras.setOpaque(false);
	       checkBox_mejoras.setForeground(Color.WHITE);
	       checkBox_mejoras.setFont(new Font("Tahoma", Font.BOLD, 13));
	       checkBox_mejoras.setBounds(81, 207, 199, 23);
	       panel_1.add(checkBox_mejoras);
	       
	       JLabel label_18 = new JLabel("Indice CONEAT:");
	       label_18.setHorizontalAlignment(SwingConstants.RIGHT);
	       label_18.setForeground(Color.WHITE);
	       label_18.setFont(new Font("Tahoma", Font.BOLD, 13));
	       label_18.setBounds(52, 170, 126, 23);
	       panel_1.add(label_18);
	       
	       textField_coneat = new JTextField();
	       
	       textField_coneat.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					
						char c = arg0.getKeyChar();
						if (c<'0'|| c>'9'){ 
							arg0.consume();
						}
						if(textField_coneat.getText().length()>=5){
							arg0.consume();

					}

				}
			});
	       
	       textField_coneat.setPreferredSize(new Dimension(300, 24));
	       textField_coneat.setColumns(10);
	       textField_coneat.setBounds(201, 172, 79, 20);
	       panel_1.add(textField_coneat);
	       
	       
	       comboBox_productividad.setBounds(149, 89, 176, 21);
	       panel_1.add(comboBox_productividad);
	       
	       JLabel label_19 = new JLabel("Productividad:\r\n");
	       label_19.setHorizontalAlignment(SwingConstants.RIGHT);
	       label_19.setForeground(Color.WHITE);
	       label_19.setFont(new Font("Tahoma", Font.BOLD, 13));
	       label_19.setBounds(0, 87, 126, 23);
	       panel_1.add(label_19);
	       
	       JLabel label_20 = new JLabel("Tipo de Suelo:\r\n");
	       label_20.setHorizontalAlignment(SwingConstants.RIGHT);
	       label_20.setForeground(Color.WHITE);
	       label_20.setFont(new Font("Tahoma", Font.BOLD, 13));
	       label_20.setBounds(0, 53, 126, 23);
	       panel_1.add(label_20);
	       
	       comboBox_TiposSuelos.setBounds(149, 55, 176, 21);
	       panel_1.add(comboBox_TiposSuelos);
	       
	       GhostText ghostText5 = new GhostText(textField_RutaPdf, "Ej. C://EJEMPLO...");
	       textField_RutaPdf.setPreferredSize(new Dimension(300, 24));
	       
	       JButton btnResumen = new JButton("Resumen");
	       btnResumen.addActionListener(new ActionListener() {
	       	public void actionPerformed(ActionEvent e) {
	       		
	       		textArea_Imprime.setText("\tRESUMEN CASA:\n\n"+"\n\t*Ref:: \t"+ textFieldRefTerreno.getText()
				+"\n\t*FOS: \t"+ textField_FactorOcupacionSuelo.getText()
				+"\n\t*Área edificada: \t"+ textField_AreaEdificable.getText() +
				"\n\n\t*Mts fte.: "+ textField_MetrosFrente.getText() + ", Sit.Jurídica:\t"+(String) comboBox_TiposSuelos.getSelectedItem()+"\n\n"+

				"\n\t***** Productividad:\t\t "+ (String) comboBox_productividad.getSelectedItem() +
				"\n\t***** Coneat: " + textField_coneat.getText() +
				"\n\t***** Área total: " + textField_AreaTotal.getText() +
				"\n\t***** Ruta Img: " + textFieldRutaImagen.getText() +
				"\n\t----------------------------------------------------------- "+
				"\n\n\t***** Detalle: \t\t "+textArea_Detalles.getText()
				);
	       		
	       		
	       		
	       		
	       		
	       		
	       		
	       		
	       	}
	       });
	       btnResumen.setFont(new Font("Tahoma", Font.BOLD, 14));
	       btnResumen.setBounds(503, 25, 167, 23);
	       panel_6.add(btnResumen);
	       	         
	       GhostText ghostText14 = new GhostText(textFieldRutaImagen, "img_defecto.png");
	       textFieldRutaImagen.setPreferredSize(new Dimension(300, 24));
	       
	       JScrollPane scrollPane_3 = new JScrollPane();
	       scrollPane_3.setBounds(31, 24, 511, 130);
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
	       	       
	       ImageIcon imagen4 = new ImageIcon(VentanaTerreno.class.getResource("flecha.png"));
			
			JPanel panel_8 = new JPanel();
			panel_8.setOpaque(false);
			panel_8.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "  Inmueble  Identificador ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
			panel_8.setBounds(309, 29, 377, 137);
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
			panel_9.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "  Identificador Terreno  ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
			panel_9.setBounds(33, 29, 259, 137);
			contentPane.add(panel_9);
			
			JLabel label_13 = new JLabel("Referencia:");
			label_13.setHorizontalAlignment(SwingConstants.RIGHT);
			label_13.setForeground(Color.WHITE);
			label_13.setFont(new Font("Tahoma", Font.BOLD, 13));
			label_13.setBounds(38, 34, 126, 23);
			panel_9.add(label_13);
			
			textFieldRefTerreno = new JTextField();
			
			textFieldRefTerreno.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					
						char c = arg0.getKeyChar();
						if (c<'0'|| c>'9'){ 
							arg0.consume();
						}
						if(textFieldRefTerreno.getText().length()>=5){
							arg0.consume();
				}}
			});
			
			
			textFieldRefTerreno.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldRefTerreno.setFont(new Font("Tahoma", Font.BOLD, 22));
			textFieldRefTerreno.setColumns(10);
			textFieldRefTerreno.setBounds(89, 68, 75, 43);
			panel_9.add(textFieldRefTerreno);
			
			
			label_Asterisco7.setForeground(Color.RED);
			label_Asterisco7.setFont(new Font("Tahoma", Font.BOLD, 20));
			label_Asterisco7.setBounds(174, 87, 28, 14);
			panel_9.add(label_Asterisco7);
			
			
			//------------------------------------ FLECHA CON ACCION ------------------------------//
		       
		       JLabel label_14 = new JLabel("");
		       label_14.setBounds(1219, 177, 56, 62);
		       ImageIcon imagenFlecha = new ImageIcon(VentanaTerreno.class.getResource("flecha.png"));
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
		       			
		       			
		       			
		     	       
		     	       //---------------------------------------------------------------------------
			
		       			
	       
	       //---------------------------------------------------------------------------------------------//
	       
	       /*
	        * 
	       
	       textField_Dormitorio
			textField_Baños
			textField_AreaEdificada
			textField_AreaTotal
			textField_MetrosFrente
			textFieldRutaImagen
			textField_RutaPdf
			textField_Diereccion
			textField_Padron
			textField_FechaIngreso
			textField_Nombre
			textField_Telefono
			textField_Email

			textArea_Amenities
			textArea_Detalles
	       
	        * 
	        * */
	        
		
		
		
		
		
		
		
	}
}
