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
import logicapersistencia.valueObjects.VOapartamentos;
import logicapersistencia.valueObjects.VOapartamentosSoloAptos;
import logicapersistencia.valueObjects.VOcasas;
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
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class VentanaApartamentos extends JFrame {

	private Fondo contentPane;
	private JTextField textField_Dormitorio;
	private JTextField textField_Baños;
	private JTextField textField_AreaEdificada;
	private JTextField textField_GastosComunes;
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
	private JTextField textFieldRefApto;
	Icon img = new ImageIcon(getClass().getResource("uy2.png"));
	public JTextField textField_refInm;
	private JTextField textField_unidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaApartamentos frame = new VentanaApartamentos();
					frame.setVisible(true);
//					frame.setResizable(false); // DEJA ESTÁTICA EL TAMAÑO DE LA
												// VENTANA
//					frame.setExtendedState(MAXIMIZED_BOTH);// maximisa la
															// ventana
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public VentanaApartamentos() {

		JCheckBox checkBox_gje = new JCheckBox("Garaje");
		JCheckBox checkBox_balcon = new JCheckBox("Balc\u00F3n");
		JCheckBox checkBox_cochTechada = new JCheckBox("Coch. Techada");
		JCheckBox checkBox_cochAbierta = new JCheckBox("Coch. Abierta");
		JCheckBox checkBox_Vestidor = new JCheckBox("Vestidor");
		JCheckBox checkBox_UN_ambiente = new JCheckBox("Un Ambiente");
		JCheckBox checkBox_Monoambiente = new JCheckBox("Monoambiente");
		JCheckBox checkBox_tzaLavadero = new JCheckBox("Tza-lavadero");
		JCheckBox checkBox_terraza = new JCheckBox("Terraza");

		JLabel label_Asterisco10 = new JLabel("*");
		JLabel label_Asterisco9 = new JLabel("*");
		JLabel label_Asterisco8 = new JLabel("*");
		JLabel label_Asterisco7 = new JLabel("*");
		JLabel label_Asterisco6 = new JLabel("*");
		JLabel label_Asterisco5 = new JLabel("*");
		JLabel label_Asterisco3 = new JLabel("*");
		JLabel label_Asterisco2 = new JLabel("*");
		JLabel label_Asterisco1 = new JLabel("*");

		label_Asterisco1.setVisible(false);
		label_Asterisco2.setVisible(false);
		label_Asterisco3.setVisible(false);
		label_Asterisco5.setVisible(false);
		label_Asterisco6.setVisible(false);
		label_Asterisco7.setVisible(false);
		label_Asterisco8.setVisible(false);
		label_Asterisco9.setVisible(false);
		label_Asterisco10.setVisible(false);
		JLabel lblImagen = new JLabel("");

		JComboBox comboBox_refInmueble = new JComboBox();
		JRadioButton rdbtnEditarRefInm = new JRadioButton("Editar");
		JRadioButton rdbtnListaInmuebleRef = new JRadioButton("Lista");
		ControladorInsert controladorInsert = new ControladorInsert();
		ControladorComparar controladorComparar = new ControladorComparar();
		JComboBox comboBox_ubicacionPlanta = new JComboBox();
		comboBox_ubicacionPlanta.setModel(new DefaultComboBoxModel(
				new String[] { "Frente", "Fondo", "Lateral", "Contra-frente", "Planta entera" }));
		JComboBox comboBox_ubicacionEdificio = new JComboBox();
		comboBox_ubicacionEdificio.setModel(new DefaultComboBoxModel(new String[] { "Planta Baja", "1\u00BA Piso",
				"2\u00BA Piso", "3\u00BA Piso", "4\u00BA Piso", "5\u00BA Piso", "6\u00BA Piso", "7\u00BA Piso",
				"8\u00BA Piso", "9\u00BA Piso", "10\u00BA Piso", "11\u00BA Piso", "12\u00BA Piso", "13\u00BA Piso",
				"14\u00BA Piso", "15\u00BA Piso", "16\u00BA Piso", "17\u00BA Piso", "18\u00BA Piso", "19\u00BA Piso",
				"20\u00BA Piso", "m\u00E1s Piso.", "Pent-house." }));

		// ------------------------- IMAGEN POR DEFECTO
		// -------------------------------------//

		ImageIcon imagenDefecto = new ImageIcon(this.getClass().getResource("img_defecto.png"));
		Image imagDefecto = imagenDefecto.getImage().getScaledInstance(179, 138, Image.SCALE_SMOOTH);
		lblImagen.setIcon(new ImageIcon(imagDefecto));
		// 68, 37, 179, 138
		// ******************************************************************************************//

		setBackground(UIManager.getColor("Button.foreground"));
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(VentanaApartamentos.class.getResource("/grafica/ventanas/uy2.png")));
		setTitle("Gestor de Apartamentos - LALK Negocios Inmobiliarios");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(30, 30, 1316, 769);
		contentPane = new Fondo("primerFondo.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(33, 317, 323, 162);
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null),
				"  Habitaciones Sociales      ", TitledBorder.CENTER, TitledBorder.TOP, null,
				new Color(255, 255, 255)));
		panel.setOpaque(false);
		contentPane.add(panel);
		panel.setLayout(null);

		JComboBox comboBox_Living = new JComboBox();
		comboBox_Living.setModel(new DefaultComboBoxModel(
				new String[] { "", "Living", "Living-comedor", "Comedor", "Living y Comedor" }));
		comboBox_Living.setBounds(26, 30, 116, 21);
		panel.add(comboBox_Living);

		JLabel lblDormitorios = new JLabel("Dorm.:");
		lblDormitorios.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDormitorios.setForeground(Color.WHITE);
		lblDormitorios.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDormitorios.setBounds(152, 28, 90, 23);
		panel.add(lblDormitorios);

		textField_Dormitorio = new JTextField();

		textField_Dormitorio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

				char c = arg0.getKeyChar();
				if (c < '0' || c > '9') {
					arg0.consume();
				}
				if (textField_Dormitorio.getText().length() >= 2) {
					arg0.consume();
				}
			}
		});

		JTextArea textArea_Detalles = new JTextArea();

		textArea_Detalles.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

				if (textArea_Detalles.getText().length() >= 200) {
					arg0.consume();
				}

			}
		});

		textField_Dormitorio.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_Dormitorio.setBounds(252, 30, 32, 20);
		panel.add(textField_Dormitorio);
		textField_Dormitorio.setColumns(10);

		JCheckBox chckbxConSuite = new JCheckBox("Con Suite");
		chckbxConSuite.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckbxConSuite.setForeground(Color.WHITE);
		chckbxConSuite.setBounds(198, 99, 97, 23);
		chckbxConSuite.setOpaque(false);
		panel.add(chckbxConSuite);

		JCheckBox chckbxSocial = new JCheckBox("Servicio");
		chckbxSocial.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckbxSocial.setForeground(Color.WHITE);
		chckbxSocial.setBounds(198, 125, 97, 23);
		chckbxSocial.setOpaque(false);
		panel.add(chckbxSocial);

		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null),
				"  Caracter\u00EDsticas  ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel_1.setBounds(31, 177, 661, 129);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		textField_AreaEdificada = new JTextField();

		textField_AreaEdificada.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

				char c = arg0.getKeyChar();
				if (c < '0' || c > '9') {
					arg0.consume();
				}
				if (textField_AreaEdificada.getText().length() >= 9) {
					arg0.consume();

				}

			}
		});

		textField_AreaEdificada.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_AreaEdificada.setBounds(500, 31, 86, 20);
		panel_1.add(textField_AreaEdificada);
		textField_AreaEdificada.setColumns(10);

		textField_GastosComunes = new JTextField();

		textField_GastosComunes.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

				char c = arg0.getKeyChar();
				if (c < '0' || c > '9') {
					arg0.consume();
				}
				if (textField_GastosComunes.getText().length() >= 9) {
					arg0.consume();

				}

			}
		});

		textField_GastosComunes.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_GastosComunes.setColumns(10);
		textField_GastosComunes.setBounds(500, 68, 86, 20);
		panel_1.add(textField_GastosComunes);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setOpaque(false);
		panel_2.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null),
				"  Habitaciones Servicio      ", TitledBorder.CENTER, TitledBorder.TOP, null,
				new Color(255, 255, 255)));
		panel_2.setBounds(702, 297, 573, 85);
		contentPane.add(panel_2);

		JLabel lblBaos = new JLabel("Ba\u00F1os:");
		lblBaos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBaos.setForeground(Color.WHITE);
		lblBaos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBaos.setBounds(269, 23, 90, 23);
		panel_2.add(lblBaos);

		JComboBox comboBox_Cocina = new JComboBox();
		comboBox_Cocina.setModel(new DefaultComboBoxModel(
				new String[] { "", "Cocina", "Cocina con Office", "Cocina Americana", "Kitchenette" }));
		comboBox_Cocina.setBounds(61, 40, 168, 21);
		panel_2.add(comboBox_Cocina);

		textField_Baños = new JTextField();

		textField_Baños.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

				char c = arg0.getKeyChar();
				if (c < '0' || c > '9') {
					arg0.consume();
				}
				if (textField_Baños.getText().length() >= 2) {
					arg0.consume();
				}
			}
		});

		textField_Baños.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_Baños.setColumns(10);
		textField_Baños.setBounds(369, 25, 32, 20);
		panel_2.add(textField_Baños);

		JCheckBox chckbxServicio = new JCheckBox("Servicio");
		chckbxServicio.setOpaque(false);
		chckbxServicio.setForeground(Color.WHITE);
		chckbxServicio.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckbxServicio.setBounds(459, 23, 97, 23);
		panel_2.add(chckbxServicio);

		JCheckBox chckbxSocial_Baño = new JCheckBox("Social");
		chckbxSocial_Baño.setOpaque(false);
		chckbxSocial_Baño.setForeground(Color.WHITE);
		chckbxSocial_Baño.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckbxSocial_Baño.setBounds(459, 53, 97, 23);
		panel_2.add(chckbxSocial_Baño);

		JCheckBox chckbxJacuzzi = new JCheckBox("Jacuzzi");
		chckbxJacuzzi.setOpaque(false);
		chckbxJacuzzi.setForeground(Color.WHITE);
		chckbxJacuzzi.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckbxJacuzzi.setBounds(353, 53, 97, 23);
		panel_2.add(chckbxJacuzzi);

		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel_3.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null),
				"  Amenities      ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel_3.setBounds(369, 317, 323, 162);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 86, 278, 57);
		panel_3.add(scrollPane);

		JTextArea textArea_Amenities = new JTextArea();

		textArea_Amenities.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

				if (textArea_Amenities.getText().length() >= 400) {
					arg0.consume();
				}

				char TipoDeTecla = arg0.getKeyChar();
				if (Character.isDigit(TipoDeTecla)) {
					arg0.consume();
				}

			}
		});

		scrollPane.setViewportView(textArea_Amenities);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setOpaque(false);
		panel_4.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null),
				"  Detalles      ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel_4.setBounds(702, 380, 573, 99);
		contentPane.add(panel_4);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(33, 490, 1242, 232);
		contentPane.add(tabbedPane);

		// ***************************************** TABLA APARTAMENTOS
		// ******************************//

		Icon img = new ImageIcon(getClass().getResource("uy2.png"));

		Object[] fila = new Object[42];

		table = new JTable();
		modelo = new DefaultTableModel();

		modelo.addColumn("IdApartamento");
		modelo.addColumn("Ref Inmueble");
		modelo.addColumn("Unidad");
		modelo.addColumn("Ubicar Edificio");
		modelo.addColumn("Ubicar Planta");
		modelo.addColumn("Habitación Social");
		modelo.addColumn("Cocina");
		modelo.addColumn("Monoambiente");
		modelo.addColumn("Un Ambiente");
		modelo.addColumn("Dorm");
		modelo.addColumn("Dormitorio (c/suite)");
		modelo.addColumn("Dormitorio (c/vestidor)");
		modelo.addColumn("Baños");
		modelo.addColumn("Baño Social");
		modelo.addColumn("Baño Servicio");
		modelo.addColumn("Baño Jacuzzi");
		modelo.addColumn("Balcón");
		modelo.addColumn("Terraza Principal");
		modelo.addColumn("Terraza Lavadero");
		modelo.addColumn("Garaje");
		modelo.addColumn("Cochera Abierta");
		modelo.addColumn("Cochera Techada");
		modelo.addColumn("Amenities");
		modelo.addColumn("Gastos Comunes");
		modelo.addColumn("Área Edificada");
		modelo.addColumn("Detalle Apto");
		modelo.addColumn("Ruta Imagen");
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(UIManager.getColor("CheckBox.darkShadow"));
		tabbedPane.addTab("Lista de Apartamentos", null, panel_5, null);
		panel_5.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 18, 1217, 175);
		panel_5.add(scrollPane_2);
		
		//************************************ TABLA ***********************************//

		ControladorList controlador = new ControladorList();
		List<VOapartamentosSoloAptos> lstApto = controlador.listarApartamentosSoloAptos();
		if (lstApto.size() > 0) {
			Iterator<VOapartamentosSoloAptos> iterApto = lstApto.iterator();
			while (iterApto.hasNext()) {
				VOapartamentosSoloAptos datosApto = iterApto.next();
				
								
				fila[0] = datosApto.getIdApartamento();
				fila[1] = datosApto.getIdInmueble();
				fila[2] = datosApto.getUnidad();
				fila[3] = datosApto.getUbicarEdificio();
				fila[4] = datosApto.getUbicarPlanta();
				fila[5] = datosApto.getHabitacionSocial();
				fila[6] = datosApto.getCocina();
				fila[7] = datosApto.getMonoambiente();
				fila[8] = datosApto.getUnAmbiente();
				
				fila[9] = datosApto.getDorm();
				fila[10] = datosApto.getDormConSuite();
				fila[11] = datosApto.getDormConVestidor();
				fila[12] = datosApto.getBaños();
				fila[13] = datosApto.getBañoSocial();
				fila[14] = datosApto.getBañoServicio();
				fila[15] = datosApto.getBañoJacuzzi();
				fila[16] = datosApto.getBalcon();
				fila[17] = datosApto.getTerrazaPrincipal();
				fila[18] = datosApto.getTerrazaLavadero();
				fila[19] = datosApto.getGaraje();
				fila[20] = datosApto.getCochAbierta();
				fila[21] = datosApto.getCochTechada();
				fila[22] = datosApto.getAmenities();
				fila[23] = datosApto.getGastosComunes();
				fila[24] = datosApto.getAreaEdificada();
				fila[25] = datosApto.getDetalleApto();
				fila[26] = datosApto.getRutaImagenApto();
			
				modelo.addRow(fila);
			}
		}
		table = new JTable(modelo);

		scrollPane_2.setViewportView(table);

		// **********************************************************//
		
		
		//----------------- TOMO LOS VALORES DE LA TABLA -------------------------------//
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent e){
			if(table.getSelectedRow() !=-1){
				
			int fila = table.getSelectedRow();
//			try {
			
			textFieldRefApto.setText(table.getValueAt(fila,0).toString());

			String refInmueble = (table.getValueAt(fila,1).toString());
			int refInmueble1 = Integer.parseInt(refInmueble);
			comboBox_refInmueble.setSelectedItem(refInmueble1);
			
			textField_unidad.setText(table.getValueAt(fila,2).toString());
			
			String ubicarEdificio =  (table.getValueAt(fila,3).toString());
			comboBox_ubicacionEdificio.setSelectedItem(ubicarEdificio);
			
			String ubicarPlanta =  (table.getValueAt(fila,4).toString());
			comboBox_ubicacionPlanta.setSelectedItem(ubicarPlanta);
			
			
			
			
			String living = (table.getValueAt(fila,5).toString()); 
			comboBox_Living.setSelectedItem(living);
			
			String cocina = (table.getValueAt(fila,6).toString()); 
			comboBox_Cocina.setSelectedItem(cocina);
			
			if(table.getValueAt(fila,7).toString().equals("SI")){
				checkBox_Monoambiente.setSelected(true);
			}else{
				checkBox_Monoambiente.setSelected(false);
			}
			if(table.getValueAt(fila,8).toString().equals("SI")){
				checkBox_UN_ambiente.setSelected(true);
			}else{
				checkBox_UN_ambiente.setSelected(false);
			}
			
			
			String dorm0 = (table.getValueAt(fila,9).toString()); 
			textField_Dormitorio.setText(dorm0);
			
			if(table.getValueAt(fila,10).toString().equals("SI")){
				chckbxConSuite.setSelected(true);
			}else{
				chckbxConSuite.setSelected(false);
			}
			if(table.getValueAt(fila,11).toString().equals("SI")){
				checkBox_Vestidor.setSelected(true);
			}else{
				checkBox_Vestidor.setSelected(false);
			}
			
			textField_Baños.setText(table.getValueAt(fila,12).toString());
			
			//*
			if(table.getValueAt(fila,13).toString().equals("SI")){
				chckbxSocial_Baño.setSelected(true);
			}else{
				chckbxSocial_Baño.setSelected(false);
			}
			if(table.getValueAt(fila,14).toString().equals("SI")){
				chckbxServicio.setSelected(true);
			}else{
				chckbxServicio.setSelected(false);
			}
			
			if(table.getValueAt(fila,15).toString().equals("SI")){
				chckbxJacuzzi.setSelected(true);
			}else{
				chckbxJacuzzi.setSelected(false);
			}
			if(table.getValueAt(fila,16).toString().equals("SI")){
				checkBox_balcon.setSelected(true);
			}else{
				checkBox_balcon.setSelected(false);
			}
			
			
			if(table.getValueAt(fila,17).toString().equals("SI")){
				checkBox_terraza.setSelected(true);
			}else{
				checkBox_terraza.setSelected(false);
			}
			if(table.getValueAt(fila,18).toString().equals("SI")){
				checkBox_tzaLavadero.setSelected(true);
			}else{
				checkBox_tzaLavadero.setSelected(false);
			}
			
			if(table.getValueAt(fila,19).toString().equals("SI")){
				checkBox_gje.setSelected(true);
			}else{
				checkBox_gje.setSelected(false);
			}
			if(table.getValueAt(fila,20).toString().equals("SI")){
				checkBox_cochAbierta.setSelected(true);
			}else{
				checkBox_cochAbierta.setSelected(false);
			}
			if(table.getValueAt(fila,21).toString().equals("SI")){
				checkBox_cochTechada.setSelected(true);
			}else{
				checkBox_cochTechada.setSelected(false);
			}
			
			textArea_Amenities.setText(table.getValueAt(fila,22).toString());
			textField_GastosComunes.setText(table.getValueAt(fila,23).toString());
			textField_AreaEdificada.setText(table.getValueAt(fila,24).toString());
			textArea_Detalles.setText(table.getValueAt(fila,25).toString());
			textFieldRutaImagen.setText(table.getValueAt(fila,26).toString());

			
			//------------------------ TOMA LA RUTA DE LA FOTO ---------------------//
			
			Image foto = getToolkit().getImage(textFieldRutaImagen.getText());
			foto = foto.getScaledInstance(179, 138, Image.SCALE_DEFAULT);
			lblImagen.setIcon(new ImageIcon (foto));
			//C:\Users\Mariu\Desktop\img\img_defecto.png
			}}});
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

				// ************************** BUSCA RUTA PARA GUARDAR Y GENERAR
				// PDF ***************//

				JFileChooser dlg = new JFileChooser();
				int option = dlg.showSaveDialog(btnBuscarRuta);
				if (option == JFileChooser.APPROVE_OPTION) {
					File f = dlg.getSelectedFile();
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

				// ------------------------GENERO EL PDF
				// ----------------------//

				String ruta = textField_RutaPdf.getText();
				String contenido = textArea_Imprime.getText();

				try {

					if (ruta != ("") || ruta != null) {
						FileOutputStream archivo = new FileOutputStream(ruta + ".pdf");

						Document doc = new Document();

						PdfWriter.getInstance(doc, archivo);
						doc.open();
						doc.add(new Paragraph(contenido));

						doc.close();

						JOptionPane.showMessageDialog(null, "PDF Creado Correctamente", "LALK Negocios Inmobiliarios",
								JOptionPane.ERROR_MESSAGE, null);

					} else {
						JOptionPane.showMessageDialog(null,
								"Debes seleccionar una ruta y escribir el nombre del archivo\n "
										+ "Recuerda escribir el nombre del archivo sin la extensión dado que ya la tiene",
								"LALK Negocios Inmobiliarios", JOptionPane.ERROR_MESSAGE, null);
					}

				} catch (Exception error) {
					JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "LALK Negocios Inmobiliaros",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnGenerarPdf.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGenerarPdf.setBounds(688, 25, 167, 23);
		panel_6.add(btnGenerarPdf);

		JPanel panel_7 = new JPanel();
		panel_7.setOpaque(false);
		panel_7.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "  Fotos      ",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
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

				if (textFieldRutaImagen.getText().length() >= 200) {
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

				// ************************** BUSCA RUTA PARA BUSCAR
				// JPG***************//

				FileNameExtensionFilter filtro = new FileNameExtensionFilter("Formatos de archivo JPG(*.jpg; *.png)",
						"jpg", "png");

				JFileChooser dlg = new JFileChooser();
				dlg.addChoosableFileFilter(filtro);
				dlg.setDialogTitle("Abrir archivo");
				File ruta = new File("C:/Users/Mariu/Desktop/img");
				dlg.setCurrentDirectory(ruta);

				int option = dlg.showSaveDialog(btnNewButton);

				if (option == JFileChooser.APPROVE_OPTION) {

					File f = dlg.getSelectedFile();
					textFieldRutaImagen.setText(f.toString());
					String fotoRuta = textFieldRutaImagen.getText();

					Image foto = getToolkit().getImage(textFieldRutaImagen.getText());
					foto = foto.getScaledInstance(179, 138, Image.SCALE_DEFAULT);
					lblImagen.setIcon(new ImageIcon(foto));

				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(68, 216, 179, 23);
		panel_7.add(btnNewButton);

		Button button = new Button("Ingresar Datos");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textFieldRefApto.getText().equals("") || textField_GastosComunes.getText().equals("")
						|| comboBox_ubicacionEdificio.getSelectedItem().equals("")
						|| comboBox_ubicacionPlanta.getSelectedItem().equals("")
						|| comboBox_Living.getSelectedItem().equals("") || textField_Dormitorio.getText().equals("")
						|| comboBox_refInmueble.getSelectedItem().equals("")
						|| textField_AreaEdificada.getText().equals("") 
						|| textField_GastosComunes.getText().equals("") || textField_Baños.getText().equals("")) {

					label_Asterisco1.setVisible(true);
					label_Asterisco2.setVisible(true);
					label_Asterisco3.setVisible(true);
					label_Asterisco5.setVisible(true);
					label_Asterisco6.setVisible(true);
					label_Asterisco7.setVisible(true);
					label_Asterisco8.setVisible(true);
					label_Asterisco10.setVisible(true);

					JOptionPane.showMessageDialog(null, "Por favor completar los campos obligatorios, gracias");

				} else {

					label_Asterisco1.setVisible(false);
					label_Asterisco2.setVisible(false);
					label_Asterisco3.setVisible(false);
					label_Asterisco5.setVisible(false);
					label_Asterisco6.setVisible(false);
					label_Asterisco7.setVisible(false);
					label_Asterisco8.setVisible(false);
					label_Asterisco10.setVisible(false);

					JOptionPane.showMessageDialog(null, "Campos obligatorios completos", "Mensaje",
							JOptionPane.ERROR_MESSAGE, img);

				}

				try {
					String refA = textFieldRefApto.getText();
					int idApto = Integer.parseInt(refA);// ******************************

					String habitacionSocial = (String) comboBox_Living.getSelectedItem();// ******

					String dorm0 = textField_Dormitorio.getText();
					int dorm = Integer.parseInt(dorm0);

					String dormConSuite;// ******************************************************
					if (chckbxConSuite.isSelected()) {
						dormConSuite = "SI";
					} else {
						dormConSuite = "NO";
					}

					String dormConVestidor;// ******************************************************
					if (checkBox_Vestidor.isSelected()) {
						dormConVestidor = "SI";
					} else {
						dormConVestidor = "NO";
					}

					String dormSocial;
					if (chckbxSocial.isSelected()) {
						dormSocial = "SI";
					} else {
						dormSocial = "NO";
					}

					String bañ = textField_Baños.getText();
					int baños = Integer.parseInt(bañ);

					String bañoSocial; // *******************************************
					if (chckbxSocial_Baño.isSelected()) {
						bañoSocial = "SI";
					} else {
						bañoSocial = "NO";
					}

					String bañoServicio; // *******************************************
					if (chckbxServicio.isSelected()) {
						bañoServicio = "SI";
					} else {
						bañoServicio = "NO";
					}

					String bañoConJacuzzi; // *******************************************
					if (chckbxJacuzzi.isSelected()) {
						bañoConJacuzzi = "SI";
					} else {
						bañoConJacuzzi = "NO";
					}

					String balcon; // **********************************************
					if (checkBox_balcon.isSelected()) {
						balcon = "SI";
					} else {
						balcon = "NO";
					}
					//
					String terrazaPrincipal;// ****************************************
					if (checkBox_terraza.isSelected()) {
						terrazaPrincipal = "SI";
					} else {
						terrazaPrincipal = "NO";
					}
					//
					String terrazaLavadero;// ****************************************
					if (checkBox_tzaLavadero.isSelected()) {
						terrazaLavadero = "SI";
					} else {
						terrazaLavadero = "NO";
					}
					String garaje;// ****************************************
					if (checkBox_gje.isSelected()) {
						garaje = "SI";
					} else {
						garaje = "NO";
					}
					String cocheraAbierta;// ****************************************
					if (checkBox_cochAbierta.isSelected()) {
						cocheraAbierta = "SI";
					} else {
						cocheraAbierta = "NO";
					}
					String cocheraTechada;// ****************************************
					if (checkBox_cochTechada.isSelected()) {
						cocheraTechada = "SI";
					} else {
						cocheraTechada = "NO";
					}

					String monoambiente;// ****************************************
					if (checkBox_Monoambiente.isSelected()) {
						monoambiente = "SI";
					} else {
						monoambiente = "NO";
					}

					String unAmbiente;// ****************************************
					if (checkBox_UN_ambiente.isSelected()) {
						unAmbiente = "SI";
					} else {
						unAmbiente = "NO";
					}

					String amenities = textArea_Amenities.getText();

					String aEdif = textField_AreaEdificada.getText();
					double areaEdificada = Double.parseDouble(aEdif);

					String mFte = textField_GastosComunes.getText();
					double metrosFrente = Double.parseDouble(mFte);

					String detalleApto = textArea_Detalles.getText();

					String unidad0 = textField_unidad.getText();
					int unidad = Integer.parseInt(unidad0);

					String ubicacionEdificio = (String) comboBox_ubicacionEdificio.getSelectedItem();// ******
					String ubicacionPlanta = (String) comboBox_ubicacionPlanta.getSelectedItem();// ******

					String gastosComunes0 = textField_GastosComunes.getText();
					int gastosComunes = Integer.parseInt(gastosComunes0);
					
					

					String cocina = (String) comboBox_Cocina.getSelectedItem();// ******
					
					

					// System.out.println("linea 836");

					int idInmueble;

					if (rdbtnListaInmuebleRef.isSelected()) {
						String ref = (String) comboBox_refInmueble.getSelectedItem();
						idInmueble = Integer.parseInt(ref);
					} else {
						String ref = textField_refInm.getText();
						idInmueble = Integer.parseInt(ref);
					}

					String rutaImagenApto = textFieldRutaImagen.getText();

					if (controladorComparar.existeApartamento(idApto)) {

						JOptionPane.showMessageDialog(null,
								"Chequéa la referencia de apartamento. \n YA EXISTE DICHA REF",
								"Mensaje - Lalk Negocios Inmobiliarios", JOptionPane.ERROR_MESSAGE, img);

					} else {

						controladorInsert.nuevoApartamento(idApto, idInmueble, unidad, ubicacionEdificio,
								ubicacionPlanta, habitacionSocial, cocina, monoambiente, unAmbiente,dorm, dormConSuite,
								dormConVestidor, baños, bañoSocial, bañoServicio, bañoConJacuzzi, balcon,
								terrazaPrincipal, terrazaLavadero, garaje, cocheraAbierta, cocheraTechada, amenities,
								gastosComunes, areaEdificada, detalleApto, rutaImagenApto);

						JOptionPane.showMessageDialog(null,
								"Se han ingresado correctamente sus registros.\n Gracias por su tiempo.",
								"Mensaje - Lalk Negocios Inmobiliarios", JOptionPane.ERROR_MESSAGE, img);

					}

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
			public void actionPerformed(ActionEvent arg0) {

				try {
					String refA = textFieldRefApto.getText();
					int idApartamento = Integer.parseInt(refA);// ******************************

					String habitacionSocial = (String) comboBox_Living.getSelectedItem();// ******
					if(textField_Dormitorio.getText()==""){
					String dorm0 = textField_Dormitorio.getText();
					int dorm = Integer.parseInt(dorm0);
					}

					String dormConSuite;// ******************************************************
					if (chckbxConSuite.isSelected()) {
						dormConSuite = "SI";
					} else {
						dormConSuite = "NO";
					}

					String dormConVestidor;// ******************************************************
					if (checkBox_Vestidor.isSelected()) {
						dormConVestidor = "SI";
					} else {
						dormConVestidor = "NO";
					}

					String dormSocial;
					if (chckbxSocial.isSelected()) {
						dormSocial = "SI";
					} else {
						dormSocial = "NO";
					}

					String bañ = textField_Baños.getText();
					int baños = Integer.parseInt(bañ);

					String bañoSocial; // *******************************************
					if (chckbxSocial_Baño.isSelected()) {
						bañoSocial = "SI";
					} else {
						bañoSocial = "NO";
					}

					String bañoServicio; // *******************************************
					if (chckbxServicio.isSelected()) {
						bañoServicio = "SI";
					} else {
						bañoServicio = "NO";
					}

					String bañoJacuzzi; // *******************************************
					if (chckbxJacuzzi.isSelected()) {
						bañoJacuzzi = "SI";
					} else {
						bañoJacuzzi = "NO";
					}

					String balcon; // **********************************************
					if (checkBox_balcon.isSelected()) {
						balcon = "SI";
					} else {
						balcon = "NO";
					}
					//
					String terrazaPrincipal;// ****************************************
					if (checkBox_terraza.isSelected()) {
						terrazaPrincipal = "SI";
					} else {
						terrazaPrincipal = "NO";
					}
					//
					String terrazaLavadero;// ****************************************
					if (checkBox_tzaLavadero.isSelected()) {
						terrazaLavadero = "SI";
					} else {
						terrazaLavadero = "NO";
					}
					String garaje;// ****************************************
					if (checkBox_gje.isSelected()) {
						garaje = "SI";
					} else {
						garaje = "NO";
					}
					String cochAbierta;// ****************************************
					if (checkBox_cochAbierta.isSelected()) {
						cochAbierta = "SI";
					} else {
						cochAbierta = "NO";
					}
					String cochTechada;// ****************************************
					if (checkBox_cochTechada.isSelected()) {
						cochTechada = "SI";
					} else {
						cochTechada = "NO";
					}

					String monoambiente;// ****************************************
					if (checkBox_Monoambiente.isSelected()) {
						monoambiente = "SI";
					} else {
						monoambiente = "NO";
					}

					String unAmbiente;// ****************************************
					if (checkBox_UN_ambiente.isSelected()) {
						unAmbiente = "SI";
					} else {
						unAmbiente = "NO";
					}

					String amenities = textArea_Amenities.getText();

					String aEdif = textField_AreaEdificada.getText();
					double areaEdificada = Double.parseDouble(aEdif);

					String mFte = textField_GastosComunes.getText();
					double metrosFrente = Double.parseDouble(mFte);

					String detalleApto = textArea_Detalles.getText();

					String unidad0 = textField_unidad.getText();
					int unidad = Integer.parseInt(unidad0);

					String ubicarEdificio = (String) comboBox_ubicacionEdificio.getSelectedItem();// ******
					String ubicarPlanta = (String) comboBox_ubicacionPlanta.getSelectedItem();// ******

					String gastosComunes0 = textField_GastosComunes.getText();
					int gastosComunes = Integer.parseInt(gastosComunes0);

					String cocina = (String) comboBox_Cocina.getSelectedItem();// ******

					// System.out.println("linea 836");

					int idInmueble;

					if (rdbtnListaInmuebleRef.isSelected()) {
						String ref = (String) comboBox_refInmueble.getSelectedItem();
						idInmueble = Integer.parseInt(ref);
					} else {
						String ref = textField_refInm.getText();
						idInmueble = Integer.parseInt(ref);
					}

					String rutaImagenApto = textFieldRutaImagen.getText();

					ControladorUpdate controladorUpdate = new ControladorUpdate();
					controladorUpdate.updateApartamento(idApartamento, idInmueble, unidad, ubicarEdificio, ubicarPlanta,
							habitacionSocial, cocina, monoambiente, unAmbiente, dormConSuite, dormConVestidor, baños,
							bañoSocial, bañoServicio, bañoJacuzzi, balcon, terrazaPrincipal, terrazaLavadero, garaje,
							cochAbierta, cochTechada, amenities, gastosComunes, areaEdificada, detalleApto,
							rutaImagenApto);

					JOptionPane.showMessageDialog(null,
							"Se han actualizado correctamente sus registros.\n Gracias por su tiempo.",
							"Mensaje - Lalk Negocios Inmobiliarios", JOptionPane.ERROR_MESSAGE, img);

				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error MYSQL - \n" + e);
					e.printStackTrace();
				}

			}
		});
		button_1.setFont(new Font("Dialog", Font.BOLD, 14));
		button_1.setBounds(1055, 67, 175, 32);
		contentPane.add(button_1);

		Button button_2 = new Button("Borrar Datos");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String referenciaApto = textFieldRefApto.getText();
				int refApto = Integer.parseInt(referenciaApto);

				int resp = JOptionPane.showConfirmDialog(null, "¿Quiere borrar el registro Ref Nº" + refApto + "?",
						"Mensaje", JOptionPane.ERROR_MESSAGE);
				if (JOptionPane.OK_OPTION == resp) {

					ControladorDelete controladorEliminar = new ControladorDelete();
					ControladorComparar controladorComparar = new ControladorComparar();
					try {

						if (controladorComparar.existeApartamento(refApto) == true) {
							controladorEliminar.eliminarApartamento(refApto);
							JOptionPane.showMessageDialog(null,
									"Has borrado correctamente el registro. \nGracias por su tiempo", "Mensaje",
									JOptionPane.ERROR_MESSAGE, img);
						} else {
							JOptionPane.showMessageDialog(null, "No hay registro \nGracias por su tiempo", "Mensaje",
									JOptionPane.ERROR_MESSAGE, img);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else {
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

				comboBox_Living.setSelectedItem(null);
				textField_Dormitorio.setText(null);
				chckbxConSuite.setToolTipText(null);
				chckbxSocial.setToolTipText(null);
				comboBox_Cocina.setSelectedItem(null);
				textField_Baños.setText(null);
				chckbxServicio.setToolTipText(null);
				chckbxSocial_Baño.setToolTipText(null);
				chckbxJacuzzi.setToolTipText(null);
				textField_AreaEdificada.setToolTipText(null);
				textField_GastosComunes.setText(null);
				textArea_Amenities.setText(null);
				textArea_Detalles.setText(null);
				lblImagen.setText("");
				textFieldRutaImagen.setText(null);
				textField_RutaPdf.setText(null);
				textArea_Imprime.setText(null);
				textFieldRefApto.setText(null);
				comboBox_ubicacionEdificio.setSelectedItem(null);
				comboBox_ubicacionPlanta.setSelectedItem(null);
				textField_unidad.setText(null);
				textField_AreaEdificada.setText(null);
				textField_GastosComunes.setText(null);
				
				checkBox_terraza.setToolTipText("");
				checkBox_balcon.setToolTipText("");
				checkBox_cochAbierta.setToolTipText(null);
				checkBox_tzaLavadero.setToolTipText(null);
				checkBox_gje.setToolTipText(null);
				checkBox_cochTechada.setToolTipText(null);
				textArea_Amenities.setToolTipText(null);
				
				
				
				
				
				
				

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

		// ************************************************ SOMBRAS
		// ******************************//

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GhostText ghostText = new GhostText(textField_Baños, "");
		textField_Baños.setPreferredSize(new Dimension(300, 24));

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(281, 23, 23, 44);
		panel_2.add(separator_1);

		label_Asterisco10.setForeground(Color.RED);
		label_Asterisco10.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_Asterisco10.setBounds(411, 28, 28, 14);
		panel_2.add(label_Asterisco10);

		GhostText ghostText2 = new GhostText(textField_AreaEdificada, "");
		textField_AreaEdificada.setPreferredSize(new Dimension(300, 24));

		GhostText ghostText4 = new GhostText(textField_GastosComunes, "");
		textField_GastosComunes.setPreferredSize(new Dimension(300, 24));

		JLabel lblM = new JLabel("m2");
		lblM.setHorizontalAlignment(SwingConstants.LEFT);
		lblM.setForeground(Color.WHITE);
		lblM.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblM.setBounds(596, 29, 28, 23);
		panel_1.add(lblM);

		JLabel lblNmts = new JLabel("$UY");
		lblNmts.setHorizontalAlignment(SwingConstants.LEFT);
		lblNmts.setForeground(Color.WHITE);
		lblNmts.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNmts.setBounds(596, 71, 28, 23);
		panel_1.add(lblNmts);

		label_Asterisco1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_Asterisco1.setForeground(Color.RED);
		label_Asterisco1.setBounds(337, 68, 28, 14);
		panel_1.add(label_Asterisco1);

		label_Asterisco2.setForeground(Color.RED);
		label_Asterisco2.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_Asterisco2.setBounds(337, 33, 28, 14);
		panel_1.add(label_Asterisco2);

		label_Asterisco3.setForeground(Color.RED);
		label_Asterisco3.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_Asterisco3.setBounds(623, 34, 28, 14);
		panel_1.add(label_Asterisco3);

		label_Asterisco5.setForeground(Color.RED);
		label_Asterisco5.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_Asterisco5.setBounds(623, 76, 28, 14);
		panel_1.add(label_Asterisco5);

		JLabel label_15 = new JLabel("Ubicaci\u00F3n en el Edificio:");
		label_15.setHorizontalAlignment(SwingConstants.RIGHT);
		label_15.setForeground(Color.WHITE);
		label_15.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_15.setBounds(2, 28, 170, 23);
		panel_1.add(label_15);

		JLabel label_16 = new JLabel("Ubicaci\u00F3n en la Planta:");
		label_16.setHorizontalAlignment(SwingConstants.RIGHT);
		label_16.setForeground(Color.WHITE);
		label_16.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_16.setBounds(7, 59, 170, 23);
		panel_1.add(label_16);

		comboBox_ubicacionPlanta.setBounds(187, 61, 140, 21);
		panel_1.add(comboBox_ubicacionPlanta);

		comboBox_ubicacionEdificio.setBounds(187, 27, 140, 21);
		panel_1.add(comboBox_ubicacionEdificio);

		JLabel label_17 = new JLabel("Unidad:");
		label_17.setHorizontalAlignment(SwingConstants.RIGHT);
		label_17.setForeground(Color.WHITE);
		label_17.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_17.setBounds(45, 95, 127, 23);
		panel_1.add(label_17);

		textField_unidad = new JTextField();

		textField_unidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

				char c = arg0.getKeyChar();
				if (c < '0' || c > '9') {
					arg0.consume();
				}
				if (textField_unidad.getText().length() >= 5) {
					arg0.consume();

				}

			}
		});

		textField_unidad.setColumns(10);
		textField_unidad.setBounds(187, 94, 86, 20);
		panel_1.add(textField_unidad);

		JLabel label_18 = new JLabel("\u00C1rea Edificada:");
		label_18.setHorizontalAlignment(SwingConstants.RIGHT);
		label_18.setForeground(Color.WHITE);
		label_18.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_18.setBounds(364, 34, 126, 23);
		panel_1.add(label_18);

		JLabel lblGastosComunes = new JLabel("Gastos Comunes:");
		lblGastosComunes.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGastosComunes.setForeground(Color.WHITE);
		lblGastosComunes.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGastosComunes.setBounds(298, 71, 192, 23);
		panel_1.add(lblGastosComunes);

		GhostText ghostText5 = new GhostText(textField_RutaPdf, "Ej. C://EJEMPLO...");
		textField_RutaPdf.setPreferredSize(new Dimension(300, 24));

		JButton btnResumen = new JButton("Resumen");
		btnResumen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textArea_Imprime.setText("\tRESUMEN APTO:\n\n" + "\n\t*Ref:: \t" + textFieldRefApto.getText()
				+"\n\t*CARACTERÍSTICAS\t"
				+
				"\n\t***** Ubicación Edificio:\t\t "+ comboBox_ubicacionEdificio.getSelectedItem() +
				"\n\t***** Ubicación Planta: " + comboBox_ubicacionPlanta.getSelectedItem() +
				"\n\t***** Unidad: " + textField_unidad.getText() +
				"\n\t***** Área Edificada: " + textField_AreaEdificada.getText() +
				"\n\t----------------------------------------------------------- "+
				"\n\n\t***** GASTOS COMUNES: \t\t "+textField_GastosComunes.getText()+
				
				"\n\n\t***** HABITACIONES SOCIALES: \t\t "+
				"\n\t***** Habitación social1:\t\t "+ comboBox_Living.getSelectedItem() +
				"\n\t***** Dormitorio: " + textField_Dormitorio.getText() +

				"\n\n\t***** HABITACIONES SERVICIO: \t\t "+
				"\n\t***** Habitación servicio:\t\t "+ comboBox_Cocina.getSelectedItem() +
				"\n\t***** Baños: " + textField_Baños.getText() +
				
				"\n\n\t***** DETALLES APARTAMENTO: \t\t "+
				"\n\t***** " + textArea_Detalles.getText() +
				
				"/n/n LALK Negocios Inmobiliarios - Contacto: 099828182");

			}
		});
		btnResumen.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnResumen.setBounds(503, 25, 167, 23);
		panel_6.add(btnResumen);

		GhostText ghostText12 = new GhostText(textField_Dormitorio, "");
		textField_Dormitorio.setPreferredSize(new Dimension(300, 24));

		label_Asterisco8.setForeground(Color.RED);
		label_Asterisco8.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_Asterisco8.setBounds(152, 33, 28, 14);
		panel.add(label_Asterisco8);

		label_Asterisco9.setForeground(Color.RED);
		label_Asterisco9.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_Asterisco9.setBounds(294, 37, 28, 14);
		panel.add(label_Asterisco9);

		checkBox_Vestidor.setOpaque(false);
		checkBox_Vestidor.setForeground(Color.WHITE);
		checkBox_Vestidor.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkBox_Vestidor.setBounds(198, 73, 97, 23);
		panel.add(checkBox_Vestidor);

		checkBox_UN_ambiente.setOpaque(false);
		checkBox_UN_ambiente.setForeground(Color.WHITE);
		checkBox_UN_ambiente.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkBox_UN_ambiente.setBounds(33, 109, 134, 23);
		panel.add(checkBox_UN_ambiente);

		checkBox_Monoambiente.setOpaque(false);
		checkBox_Monoambiente.setForeground(Color.WHITE);
		checkBox_Monoambiente.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkBox_Monoambiente.setBounds(33, 73, 134, 23);
		panel.add(checkBox_Monoambiente);

		GhostText ghostText14 = new GhostText(textFieldRutaImagen, "img_defecto.png");
		textFieldRutaImagen.setPreferredSize(new Dimension(300, 24));

		GhostTextArea ghostText15 = new GhostTextArea(textArea_Amenities, "Ej. Amenities ...");
		textArea_Amenities.setPreferredSize(new Dimension(300, 24));

		checkBox_tzaLavadero.setOpaque(false);
		checkBox_tzaLavadero.setForeground(Color.WHITE);
		checkBox_tzaLavadero.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkBox_tzaLavadero.setBounds(20, 56, 129, 23);
		panel_3.add(checkBox_tzaLavadero);

		checkBox_terraza.setOpaque(false);
		checkBox_terraza.setForeground(Color.WHITE);
		checkBox_terraza.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkBox_terraza.setBounds(20, 20, 97, 23);
		panel_3.add(checkBox_terraza);

		checkBox_gje.setOpaque(false);
		checkBox_gje.setForeground(Color.WHITE);
		checkBox_gje.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkBox_gje.setBounds(133, 56, 97, 23);
		panel_3.add(checkBox_gje);

		checkBox_balcon.setOpaque(false);
		checkBox_balcon.setForeground(Color.WHITE);
		checkBox_balcon.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkBox_balcon.setBounds(133, 20, 97, 23);
		panel_3.add(checkBox_balcon);

		checkBox_cochTechada.setOpaque(false);
		checkBox_cochTechada.setForeground(Color.WHITE);
		checkBox_cochTechada.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkBox_cochTechada.setBounds(201, 56, 136, 23);
		panel_3.add(checkBox_cochTechada);

		checkBox_cochAbierta.setOpaque(false);
		checkBox_cochAbierta.setForeground(Color.WHITE);
		checkBox_cochAbierta.setFont(new Font("Tahoma", Font.BOLD, 13));
		checkBox_cochAbierta.setBounds(201, 20, 136, 23);
		panel_3.add(checkBox_cochAbierta);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(31, 24, 511, 64);
		panel_4.add(scrollPane_3);

		scrollPane_3.setViewportView(textArea_Detalles);

		textArea_Detalles.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

				if (textArea_Detalles.getText().length() >= 400) {
					arg0.consume();
				}

				char TipoDeTecla = arg0.getKeyChar();
				if (Character.isDigit(TipoDeTecla)) {
					arg0.consume();
				}

			}
		});

		GhostTextArea ghostText16 = new GhostTextArea(textArea_Detalles, "Ej. Detalles ...");
		textArea_Detalles.setPreferredSize(new Dimension(300, 24));

		ImageIcon imagen4 = new ImageIcon(VentanaApartamentos.class.getResource("flecha.png"));

		JPanel panel_8 = new JPanel();
		panel_8.setOpaque(false);
		panel_8.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null),
				"  Inmueble  Identificador ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel_8.setBounds(309, 29, 377, 137);
		contentPane.add(panel_8);
		panel_8.setLayout(null);

		// --------------------------------TRAE LA TABLA AL
		// COMBOBOX--------------------------------------//
		ControladorList controladorComboBoxInmueble = new ControladorList();
		List<VOinmueble> lstSeccion = controladorComboBoxInmueble.listaInmuebles();

		Iterator<VOinmueble> iterSecciones = lstSeccion.iterator();
		while (iterSecciones.hasNext()) {
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
				if (c < '0' || c > '9') {
					arg0.consume();
				}
				if (textField_refInm.getText().length() >= 5) {
					arg0.consume();
				}
			}
		});

		textField_refInm.setBounds(296, 48, 52, 28);
		panel_8.add(textField_refInm);
		textField_refInm.setColumns(10);

		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setOpaque(false);
		panel_9.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null),
				"  Identificador Casa  ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel_9.setBounds(33, 29, 259, 137);
		contentPane.add(panel_9);

		JLabel label_13 = new JLabel("Referencia:");
		label_13.setHorizontalAlignment(SwingConstants.RIGHT);
		label_13.setForeground(Color.WHITE);
		label_13.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_13.setBounds(38, 34, 126, 23);
		panel_9.add(label_13);

		textFieldRefApto = new JTextField();

		textFieldRefApto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

				char c = arg0.getKeyChar();
				if (c < '0' || c > '9') {
					arg0.consume();
				}
				if (textFieldRefApto.getText().length() >= 5) {
					arg0.consume();
				}
			}
		});

		textFieldRefApto.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldRefApto.setFont(new Font("Tahoma", Font.BOLD, 22));
		textFieldRefApto.setColumns(10);
		textFieldRefApto.setBounds(89, 68, 75, 43);
		panel_9.add(textFieldRefApto);

		label_Asterisco7.setForeground(Color.RED);
		label_Asterisco7.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_Asterisco7.setBounds(174, 87, 28, 14);
		panel_9.add(label_Asterisco7);

		// ------------------------------------ FLECHA CON ACCION
		// ------------------------------//

		JLabel label_14 = new JLabel("");
		label_14.setBounds(1219, 177, 56, 62);
		ImageIcon imagenFlecha = new ImageIcon(VentanaApartamentos.class.getResource("flecha.png"));
		Image imagFlecha = imagenFlecha.getImage().getScaledInstance(label_14.getWidth(), label_14.getHeight(),
				Image.SCALE_SMOOTH);

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

		// ---------------------------------------------------------------------------

		// ---------------------------------------------------------------------------------------------//

	}
}
