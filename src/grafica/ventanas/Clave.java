package grafica.ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.itextpdf.text.pdf.codec.wmf.Point;

import grafica.controladores.ControladorComparar;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.MouseInfo;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D; 


public class Clave extends JFrame {

	private Fondo contentPane;
	private JTextField txtFieldUsuario;
	private JPasswordField passwordField;
	Icon img = new ImageIcon(getClass().getResource("uy2.png"));

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clave frame = new Clave();
					frame.setVisible(true);
					frame.setOpacity(0.9f);//con la f aclaramos que es float 
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	int x,y;
	public Clave() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 380);
		contentPane = new Fondo("sextoFondo.jpg");
		
		//Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 30, 30); 
		Shape forma =  new Ellipse2D.Float(0,0,getWidth(),getHeight()); 
		//AWTUtilities.setWindowShape(this, forma);
		//AWTUtilities.setWindowShape(this,forma)  ; 
		
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				 java.awt.Point point = MouseInfo.getPointerInfo().getLocation() ; 
				 setLocation(point.x - x, point.y - y)  ; 
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent evt) {
				
				   x = evt.getX   ()  ; 
				   y = evt.getY   ()  ; 
				
			}
		});
		contentPane.setBackground(new Color(153, 204, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(41, 66, 455, 272);
		panel.setBackground(Color.WHITE);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setOpaque(false);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setFont(new Font("Lobster 1.4", Font.BOLD, 40));
		lblUsuario.setBounds(24, 69, 166, 61);
		panel.add(lblUsuario);
		
		JLabel lblClave = new JLabel("Clave:");
		lblClave.setForeground(Color.WHITE);
		lblClave.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClave.setFont(new Font("Lobster 1.4", Font.BOLD, 40));
		lblClave.setBounds(24, 132, 166, 61);
		panel.add(lblClave);
		
		txtFieldUsuario = new JTextField();
		txtFieldUsuario.setFont(new Font("Tahoma", Font.BOLD, 30));
		txtFieldUsuario.setBounds(217, 72, 205, 44);
		panel.add(txtFieldUsuario);
		txtFieldUsuario.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Ingresar");
		btnNewButton_2.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				
				ControladorComparar controladorComparar = new ControladorComparar();
				
				String clave= new String(passwordField.getPassword());
				String usuario= txtFieldUsuario.getText();

				try {
					if(controladorComparar.existeUsuario(usuario, clave)==true ){
					
						JOptionPane.showMessageDialog(null, "Bienvenido al sistema: "+usuario, 
								"LALK Negocios Inmobiliarios", JOptionPane.ERROR_MESSAGE, img);
						
						VentanaPrincipal framePrincipal=new VentanaPrincipal();
						
						framePrincipal.setVisible(true);
						
						dispose();
						
					}else{
						JOptionPane.showMessageDialog(null, "Has ingresado mal la clave o el usuario \n. Usuario ingresado: "+usuario, 
								"LALK Negocios Inmobiliarios", JOptionPane.ERROR_MESSAGE, img);			
					}
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				} catch (HeadlessException e) {
//					
//					JOptionPane.showMessageDialog(null, "Error - "+e);
//					e.printStackTrace();
 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
				
			}

		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.setBounds(243, 204, 166, 44);
		panel.add(btnNewButton_2);
		
		JLabel lblIngresoAlSistema = new JLabel("Ingreso al sistema");
		lblIngresoAlSistema.setForeground(Color.WHITE);
		lblIngresoAlSistema.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresoAlSistema.setFont(new Font("Arsenale White", Font.PLAIN, 40));
		lblIngresoAlSistema.setBounds(53, 11, 369, 35);
		panel.add(lblIngresoAlSistema);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(95, 69, 302, -20);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(71, 56, 326, 2);
		panel.add(separator_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(217, 130, 205, 41);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("x");
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(487, 11, 51, 23);
		this.dispose();
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("_");
		button.setForeground(Color.WHITE);
		button.setBackground(Color.BLACK);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setExtendedState(ICONIFIED); // minimiza
			}
		});
		button.setBounds(425, 11, 51, 23);
		contentPane.add(button);
		
		//................................. //
		
		button.setFocusable(false)  ;
		btnNewButton.setFocusable(false) ;
		
	}
}
