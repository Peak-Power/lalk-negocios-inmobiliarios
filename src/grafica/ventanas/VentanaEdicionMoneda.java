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

import grafica.controladores.ControladorComparar;
import grafica.controladores.ControladorDelete;
import grafica.controladores.ControladorInsert;
import grafica.controladores.ControladorList;
import logicapersistencia.valueObjects.VOMonedaLista;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;

public class VentanaEdicionMoneda extends JFrame {

	private Fondo contentPane;
	private JTextField textField_CodigoMoneda;
	private JTextField textField_NombreMoneda;
	private DefaultTableModel modelo;
	Icon img = new ImageIcon(getClass().getResource("uy2.png"));
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEdicionMoneda frame = new VentanaEdicionMoneda();
					frame.setVisible(true);
					frame.setResizable(false); //DEJA ESTÁTICA EL TAMAÑO DE LA VENTANA
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	public VentanaEdicionMoneda() {
		setBackground(UIManager.getColor("Button.foreground"));
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaEdicionMoneda.class.getResource("/grafica/ventanas/uy2.png")));
		setTitle("Tipo de moneda");

		JLabel label_Asterisco2 = new JLabel("*");
	    JLabel label_Asterisco = new JLabel("*");
	    label_Asterisco2.setVisible(false);
	    label_Asterisco.setVisible(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(30, 30, 583, 427);
		contentPane = new Fondo("sextoFondo.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "  Edici\u00F3n de Tipo Monedas  ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel_1.setBounds(42, 43, 477, 300);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblreaTotal = new JLabel("Id:");
		lblreaTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblreaTotal.setForeground(Color.WHITE);
		lblreaTotal.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblreaTotal.setBounds(72, 47, 72, 34);
		panel_1.add(lblreaTotal);
		
		textField_CodigoMoneda = new JTextField();
		textField_CodigoMoneda.setBounds(162, 53, 142, 32);
		panel_1.add(textField_CodigoMoneda);
		textField_CodigoMoneda.setColumns(10);
		
		
		
		//************************************************ SOMBRAS ******************************//
		
		 JFrame frame = new JFrame();
	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       
	       GhostText ghostText2 = new GhostText(textField_CodigoMoneda, "Ej. 123...");
	       textField_CodigoMoneda.setPreferredSize(new Dimension(300, 24));
	       
	       JLabel lblMoneda = new JLabel("Moneda:");
	       lblMoneda.setHorizontalAlignment(SwingConstants.RIGHT);
	       lblMoneda.setForeground(Color.WHITE);
	       lblMoneda.setFont(new Font("Tahoma", Font.BOLD, 23));
	       lblMoneda.setBounds(29, 102, 115, 34);
	       panel_1.add(lblMoneda);
	       
	       textField_NombreMoneda = new JTextField();
	       
	       
	       textField_NombreMoneda.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					
					if(textField_NombreMoneda.getText().length()>=30){
						arg0.consume();
					}
					
					char TipoDeTecla =arg0.getKeyChar();
					if(Character.isDigit(TipoDeTecla)){
						arg0.consume();
					}
					
				}
			});
	       
	       textField_NombreMoneda.setPreferredSize(new Dimension(300, 24));
	       textField_NombreMoneda.setColumns(10);
	       textField_NombreMoneda.setBounds(162, 106, 142, 32);
	       panel_1.add(textField_NombreMoneda);
	       
	       
	       
	       
	       
	       
	       JButton btnIngreso = new JButton("Ingreso");
	       btnIngreso.addActionListener(new ActionListener() {
	       	public void actionPerformed(ActionEvent e) {
	       		
	       		if( textField_CodigoMoneda.getText().equals("") || 
	       				textField_NombreMoneda.getText().equals("") 
					){

				label_Asterisco.setVisible(true);
				label_Asterisco2.setVisible(true);
				JOptionPane.showMessageDialog(null, "Por favor completar los campos obligatorios, gracias","Mensaje",JOptionPane.ERROR_MESSAGE, img);
				
				} else{
					
//					labelAsterisco.setVisible(false);
//					labelAsterisco_1.setVisible(false);
					JOptionPane.showMessageDialog(null, "Campos obligatorios completos","Mensaje", JOptionPane.ERROR_MESSAGE, img);
				
				
				try {
								
					String idMonComp0 = textField_CodigoMoneda.getText();
					int idMonLista = Integer.parseInt(idMonComp0);
					String monLista = textField_NombreMoneda.getText();
					
					ControladorInsert controladorInsertar = new ControladorInsert();
					controladorInsertar.nuevaMonedaLista(monLista, idMonLista);
					
					JOptionPane.showMessageDialog(null, "Ha ingresado correctamente","Mensaje", JOptionPane.ERROR_MESSAGE, img);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error " + e1);
				}
				
				}
			
	       		
	       		
	       	}
	       });
	       btnIngreso.setBounds(358, 36, 89, 23);
	       panel_1.add(btnIngreso);
	       
	       JButton btnResetear = new JButton("Resetear");
	       btnResetear.addActionListener(new ActionListener() {
	       	public void actionPerformed(ActionEvent e) {
	       		
	       		textField_CodigoMoneda.setText("");
	       		textField_NombreMoneda.setText("");
	       	}
	       });
	       btnResetear.setBounds(358, 81, 89, 23);
	       panel_1.add(btnResetear);
	       
	       JButton btnEliminar = new JButton("Eliminar");
	       btnEliminar.addActionListener(new ActionListener() {
	       	public void actionPerformed(ActionEvent e) {
	       	}
	       });
	       btnEliminar.setBounds(358, 115, 89, 23);
	       panel_1.add(btnEliminar);
	       
	       
	       label_Asterisco.setFont(new Font("Tahoma", Font.BOLD, 29));
	       label_Asterisco.setForeground(Color.RED);
	       label_Asterisco.setBounds(314, 56, 46, 29);
	       panel_1.add(label_Asterisco);
	       
	      
	       label_Asterisco2.setForeground(Color.RED);
	       label_Asterisco2.setFont(new Font("Tahoma", Font.BOLD, 29));
	       label_Asterisco2.setBounds(314, 117, 46, 29);
	       panel_1.add(label_Asterisco2);
	       
	       JScrollPane scrollPane = new JScrollPane();
	       scrollPane.setBounds(38, 162, 409, 114);
	       panel_1.add(scrollPane);
	       
	     //************************************ TABLA ***********************************//
	       Object[] fila = new Object[2];
	       table = new JTable();
	       modelo = new DefaultTableModel();
			
			modelo.addColumn("Tipo Moneda Compra");
			modelo.addColumn("Id Moneda Compra");
	
			
			ControladorList controlador = new ControladorList();
			List<VOMonedaLista> lstMonCompra = controlador.listarMonedaLista();
				if (lstMonCompra.size() > 0){	
					Iterator<VOMonedaLista> iterMonComp = lstMonCompra.iterator();
					while (iterMonComp.hasNext()){
						VOMonedaLista datosMonComp= iterMonComp.next();
						
						fila[0] = datosMonComp.getMonedaLista();
						fila[1] = datosMonComp.getIdMonedaLista();
						
						modelo.addRow(fila);
					}}

				table = new JTable(modelo);
	       scrollPane.setViewportView(table);
	       
	     //----------------- TOMO LOS VALORES DE LA TABLA -------------------------------//
			
			table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){

				@Override
				public void valueChanged(ListSelectionEvent e){
				if(table.getSelectedRow() !=-1){
					
				int fila = table.getSelectedRow();
								
				textField_NombreMoneda.setText(table.getValueAt(fila,0).toString());	
				textField_CodigoMoneda.setText(table.getValueAt(fila,1).toString());
				
				}}});
 
	       JButton btnCerrar = new JButton("Cerrar");
	       btnCerrar.addActionListener(new ActionListener() {
	       	public void actionPerformed(ActionEvent e) {
	       		
	       		dispose();
	       	}
	       });
	       btnCerrar.setBounds(439, 354, 89, 23);
	       contentPane.add(btnCerrar);
	       
	       
	     		
		
		
		
	}
}
