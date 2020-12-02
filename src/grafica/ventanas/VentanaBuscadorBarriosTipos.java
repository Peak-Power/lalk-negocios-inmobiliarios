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
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.AbstractButton;
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
import logicapersistencia.accesoBD.AccesoBD;
import logicapersistencia.valueObjects.VOMonedaLista;
import logicapersistencia.valueObjects.VOapartamentos;
import logicapersistencia.valueObjects.VOcasas;
import logicapersistencia.valueObjects.VOinmueble;
import logicapersistencia.valueObjects.VOterrenos;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ScrollPaneConstants;

public class VentanaBuscadorBarriosTipos extends JFrame {

	private Fondo contentPane;
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
	private DefaultTableModel  model4;
	private DefaultTableModel modelo2;
	private DefaultTableModel modelo3;
	Icon img = new ImageIcon(getClass().getResource("uy2.png"));
	private JTable tablePrueba;
	private JTextField textField;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaBuscadorBarriosTipos frame = new VentanaBuscadorBarriosTipos();
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
	
	 //***********************//  BUSCA DATOS  //****************************//
    public void buscarDato(String texto, String estado){

 		try{
 			
 			 String SQL="";
 			
   
    
    if(estado=="CASA"){
    	
		 String [] titulos={
	    		"refInmueble","Moneda","precioLista","areaTotal",
	    		"fechaIngreso","direccion","barrio","detalleInmueble",
	    		"antiguedad","estado",
	    		
	    		"situación Jurídica","Dorm",
	    		"Baños","Fdo","Patio","Área Edif.","Fte","Coc.","Img"};
  
		 model4=new DefaultTableModel(null, titulos);
		 
    String filtro=""+texto+"_%";
     SQL="SELECT "
    		+ "inm.refInmueble, inm.tipoMonedaPrecioLista,"
    		+ "inm.precioLista, inm.areaTotal,"
    		+ "inm.fechaIngreso, inm.direccion,inm.barrio,"
    		+ "inm.detalleInmueble, inm.antiguedad, inm.estadoConservacion,"
    		
    		+ "cas.situacionJuridica,cas.dormitorios,cas.baños,"
    		+ "cas.fondo,cas.patio,cas.areaEdificada,cas.metrosFrente,cas.cocina,cas.rutaImagenCasa"
    		+ " FROM inmueble2 as inm, casas as cas "
    		+ "WHERE inm.estadoDisponibilidad='Disponible' AND inm.barrio LIKE"+'"'+filtro+'"'+"ORDER BY precioLista";
    
     //*******************************APARTAMENTO **********************************************//
     
 	}else if(estado=="APARTAMENTO"){
 		
 		String [] titulos1={
	    		"refInmueble","Moneda","precioLista","areaTotal",
	    		"fechaIngreso","direccion","barrio","detalleInmueble",
	    		"antiguedad","estado",
	    		
	    		"unidad","ubicarEdificio","ubicarPlanta","dorm",
	    		"baños","garaje","gastosComunes","Área Edif.","detalleApto","Img"};
 		
 		model4=new DefaultTableModel(null, titulos1);
 		
 	String filtro=""+texto+"_%";
 	SQL="SELECT "
    		+ "inm.refInmueble, inm.tipoMonedaPrecioLista,"
    		+ "inm.precioLista, inm.areaTotal,"
    		+ "inm.fechaIngreso, inm.direccion,inm.barrio,"
    		+ "inm.detalleInmueble, inm.antiguedad, inm.estadoConservacion,"
    		+ ""
    		+ "apa.unidad,apa.ubicarEdificio,apa.ubicarPlanta,apa.dorm,"
    		+ "apa.baños,apa.garaje,apa.gastosComunes,apa.areaEdificada,apa.detalleApto, "
    		+ "apa.rutaImagenApto"
    		
    		
			+ " FROM inmueble2 as inm, apartamentos as apa "
    		+"WHERE estadoDisponibilidad='Disponible' AND barrio LIKE"+'"'+filtro+'"'+"ORDER BY precioLista";
 			
 	
 	//******************************* TERRENOS **********************************************//
 	
 	}else if(estado=="TERRENO"){
 		
 		String [] titulos2={
	    		"refInmueble","Moneda","precioLista","areaTotal",
	    		"fechaIngreso","direccion","barrio","detalleInmueble",
	    		"antiguedad","estado",
	    		
	    		"FOS","frente","alturaEdificable","situacionJuridicaSuelo",
	    		"productividad","conMejoras","Coneat","AreaTotal",
	    		"detalleTerr","rutaImagenTerreno"};
 		
 		
 		model4=new DefaultTableModel(null, titulos2);
 		
 	String filtro=""+texto+"_%";
 	SQL="SELECT "
    		+ "inm.refInmueble, inm.tipoMonedaPrecioLista,"
    		+ "inm.precioLista, inm.areaTotal,"
    		+ "inm.fechaIngreso, inm.direccion,inm.barrio,"
    		+ "inm.detalleInmueble, inm.antiguedad, inm.estadoConservacion,"
    		+ ""
    		+ "terr.FOS,terr.frente,terr.alturaEdificable,terr.situacionJuridicaSuelo,"
    		+ "terr.productividad,terr.conMejoras,terr.Coneat,terr.AreaTotal,terr.detalleTerr,"
    		+ "terr.rutaImagenTerreno"
    		
    		
			+ " FROM inmueble2 as inm, terrenos as terr "
    		+"WHERE estadoDisponibilidad='Disponible' AND barrio LIKE"+'"'+filtro+'"'+"ORDER BY precioLista";
						
 	}
    
    System.out.println(SQL);
    
		AccesoBD a = new AccesoBD();
		Connection con=a.conectarBD();	
		PreparedStatement pstmt;
		pstmt=con.prepareStatement(SQL);
		ResultSet rs =pstmt.executeQuery(SQL);
		String [] fila = new String [20];
		while(rs.next()){
			fila[0]=rs.getString("refInmueble");
			fila[1]=rs.getString("tipoMonedaPrecioLista");
			fila[2]=rs.getString("precioLista");
			fila[3]=rs.getString("areaTotal");
			
			fila[4]=rs.getString("fechaIngreso");
			fila[5]=rs.getString("direccion");
			fila[6]=rs.getString("barrio");
			
			fila[7]=rs.getString("detalleInmueble");
			fila[8]=rs.getString("antiguedad");
			fila[9]=rs.getString("estadoConservacion");
			
			
			if(estado=="CASA"){
				
				fila[10]=rs.getString("situacionJuridica");
				fila[11]=rs.getString("dormitorios");
				fila[12]=rs.getString("baños");
				fila[13]=rs.getString("fondo");
				fila[14]=rs.getString("patio");
				fila[15]=rs.getString("areaEdificada");
				fila[16]=rs.getString("metrosFrente");
				fila[17]=rs.getString("cocina");
				fila[18]=rs.getString("rutaImagenCasa");
				
			} else if(estado=="APARTAMENTO"){
				
				fila[10]=rs.getString("unidad");
				fila[11]=rs.getString("ubicarEdificio");
				fila[12]=rs.getString("ubicarPlanta");
				fila[13]=rs.getString("dorm");
				fila[14]=rs.getString("baños");
				fila[15]=rs.getString("garaje");
				fila[16]=rs.getString("gastosComunes");
				fila[17]=rs.getString("areaEdificada");
				fila[18]=rs.getString("detalleApto");
				fila[19]=rs.getString("rutaImagenApto");
			
			} else if(estado=="TERRENO"){
				
				fila[10]=rs.getString("FOS");
				fila[11]=rs.getString("frente");
				fila[12]=rs.getString("alturaEdificable");
				fila[13]=rs.getString("situacionJuridicaSuelo");
				fila[14]=rs.getString("productividad");
				fila[15]=rs.getString("conMejoras");
				fila[16]=rs.getString("Coneat");
				fila[17]=rs.getString("AreaTotal");
				fila[18]=rs.getString("detalleTerr");
				fila[19]=rs.getString("rutaImagenTerreno");
			
			} 
			
			
			
//			fila[11]=rs.getString("antiguedad");
//			fila[12]=rs.getString("estadoConservacion");
			
			
			model4.addRow(fila);
			
		}
		
		table_1.setModel(model4);
		rs.close();
		pstmt.close();
		
 		}catch(Exception e){
 			
 			System.err.println(""+e.getMessage());
 		}
    }
  //***************************************************//
	
	public VentanaBuscadorBarriosTipos() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(65, 164, 1208, 474);
		ControladorInsert controladorInsert = new ControladorInsert();
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
	       			

		//------------------------- IMAGEN POR DEFECTO -------------------------------------//
			
				ImageIcon imagenDefecto = new ImageIcon(this.getClass().getResource("img_defecto.png"));
				Image imagDefecto = imagenDefecto.getImage().getScaledInstance(179, 138, Image.SCALE_SMOOTH);
//				68, 37, 179, 138
		//******************************************************************************************//
		
		setBackground(UIManager.getColor("Button.foreground"));
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaBuscadorBarriosTipos.class.getResource("/grafica/ventanas/uy2.png")));
		setTitle("Buscador por Barrio de INMUEBLES");

		
		JRadioButton rdbtnApartamento = new JRadioButton("Apartamento");
		JRadioButton rdbtnCasa = new JRadioButton("Casa");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(30, 30, 1316, 769);
		contentPane = new Fondo("primerFondo.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Button button_4 = new Button("Cerrar");
		button_4.setBounds(1098, 688, 175, 32);
		button_4.setForeground(Color.RED);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		contentPane.setLayout(null);
		button_4.setFont(new Font("Dialog", Font.BOLD, 15));
		contentPane.add(button_4);
		
		
		 JFrame frame = new JFrame();
	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       	       
	       ImageIcon imagen4 = new ImageIcon(VentanaBuscadorBarriosTipos.class.getResource("flecha.png"));
			
	      
			//------------------------------------ FLECHA CON ACCION ------------------------------//
		       
		       JLabel label_14 = new JLabel("");
		       label_14.setBounds(51, 688, 34, 32);
		       ImageIcon imagenFlecha = new ImageIcon(VentanaBuscadorBarriosTipos.class.getResource("flecha.png"));
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
		       contentPane.add(scrollPane);
		       
		       JPanel panel = new JPanel();
		       panel.setBounds(668, 40, 599, 96);
		       panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "  TIPOS DISPONIBLES  ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		       panel.setOpaque(false);
		       contentPane.add(panel);
		       panel.setLayout(null);
		       JRadioButton rdbtnTerreno = new JRadioButton("Terreno");
		       rdbtnTerreno.setBounds(401, 36, 118, 23);
		       panel.add(rdbtnTerreno);
		       
		       rdbtnTerreno.addActionListener(new ActionListener() {
				       	public void actionPerformed(ActionEvent e) {
				       		
				       		rdbtnCasa.setSelected(false);
				       		rdbtnApartamento.setSelected(false);
				       		rdbtnTerreno.setSelected(true);	
				       	}
				       });
		       
		       rdbtnTerreno.setForeground(Color.WHITE);
		       rdbtnTerreno.setFont(new Font("Tahoma", Font.BOLD, 18));
		       rdbtnTerreno.setBackground(Color.BLACK);
		       
		       rdbtnApartamento.setBounds(192, 36, 152, 23);
		       panel.add(rdbtnApartamento);
		       
		       rdbtnApartamento.addActionListener(new ActionListener() {
				       	public void actionPerformed(ActionEvent e) {
				       		
				       		rdbtnCasa.setSelected(false);
				       		rdbtnApartamento.setSelected(true);
				       		rdbtnTerreno.setSelected(false);	
				       	}
				       });
		       
		       rdbtnApartamento.setForeground(Color.WHITE);
		       rdbtnApartamento.setFont(new Font("Tahoma", Font.BOLD, 18));
		       rdbtnApartamento.setBackground(Color.BLACK);
		       
		       
		       rdbtnCasa.setBounds(50, 36, 140, 23);
		       panel.add(rdbtnCasa);
		       
		       rdbtnCasa.addActionListener(new ActionListener() {
			       	public void actionPerformed(ActionEvent e) {
			       		
			       		rdbtnCasa.setSelected(true);
			       		rdbtnApartamento.setSelected(false);
			       		rdbtnTerreno.setSelected(false);	
			       	}
			       });
		       
		       
		       
		       
		       
		       rdbtnCasa.setForeground(Color.WHITE);
		       rdbtnCasa.setFont(new Font("Tahoma", Font.BOLD, 18));
		       rdbtnCasa.setBackground(Color.BLACK);
		       
		       JPanel panel_1 = new JPanel();
		       panel_1.setOpaque(false);
		       panel_1.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "  Control Busquedas  ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		       panel_1.setBounds(65, 41, 593, 96);
		       contentPane.add(panel_1);
		       panel_1.setLayout(null);
		       
		       textField = new JTextField();
		       textField.setBounds(261, 38, 244, 32);
		       
		       
		       textField.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent arg0) {

						if (textField.getText().length() >= 50) {
							arg0.consume();
						}

					}
				});
		       
		       
		       panel_1.add(textField);
		       textField.setColumns(10);
		       
		       JLabel lblBarrio = new JLabel("Barrio:");
		       lblBarrio.setBounds(84, 38, 108, 32);
		       panel_1.add(lblBarrio);
		       lblBarrio.setHorizontalAlignment(SwingConstants.RIGHT);
		       lblBarrio.setFont(new Font("Tahoma", Font.BOLD, 22));
		       lblBarrio.setForeground(Color.WHITE);
		       
		      
		       
		       //***********************************************//
		       
		       
		       
		       
		       textField.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent arg0) {
						
						String estado="";
						if(rdbtnCasa.isSelected()==true){
							estado = "CASA";
						} else if(rdbtnApartamento.isSelected()==true){
							estado = "APARTAMENTO";	
						}else if(rdbtnTerreno.isSelected()==true){
							estado = "TERRENO";	
						}
						
						String buscar = textField.getText();
						buscarDato(buscar,estado);
						

					}
				});
		
	}
}
