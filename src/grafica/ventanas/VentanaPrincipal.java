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
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
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

import grafica.controladores.ControladorList;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class VentanaPrincipal extends JFrame {

	private Fondo contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
					frame.setResizable(false); // DEJA ESTÁTICA EL TAMAÑO DE LA
												// VENTANA
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	VentanaInmuebles ventanaInmueble = new VentanaInmuebles();
	VentanaCasas ventanaCasas = new VentanaCasas();
	VentanaApartamentos ventanaApto = new VentanaApartamentos();
	VentanaTerreno ventanaTerreno = new VentanaTerreno();

	public VentanaPrincipal() {
		setBackground(new Color(0, 0, 0));
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/grafica/ventanas/uy2.png")));
		setTitle("LALK Negocios Inmobiliarios");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(30, 30, 1172, 558);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.setForeground(new Color(250, 235, 215));
		menuBar.setBackground(new Color(0, 0, 0));
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("   GESTOR   |   ");
		mnNewMenu.setForeground(new Color(255, 255, 255));
		mnNewMenu.setFont(new Font("Segoe UI Semilight", Font.BOLD, 26));
		menuBar.add(mnNewMenu);
		
		JMenu mnIngreso = new JMenu("   \u2663 Ingreso");
		mnIngreso.setFont(new Font("Segoe UI", Font.BOLD, 23));
		mnNewMenu.add(mnIngreso);

		JMenu mnInmuebles = new JMenu("   \u2660 Inmuebles: ");
		mnIngreso.add(mnInmuebles);
		mnInmuebles.setFont(new Font("Segoe UI", Font.BOLD, 23));

		JMenuItem mntmGestorInmuebles = new JMenuItem("\u2660   Gestor");
		mntmGestorInmuebles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				ventanaInmueble.setVisible(true);
				ventanaInmueble.setExtendedState(MAXIMIZED_BOTH);// maximisa la
																	// ventana

			}
		});
		mntmGestorInmuebles.setFont(new Font("Segoe UI", Font.BOLD, 23));
		mnInmuebles.add(mntmGestorInmuebles);
		
		JMenu mnNewMenu_1 = new JMenu("   \u2666 Alquileres");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 23));
		mnIngreso.add(mnNewMenu_1);
		
		JMenuItem mntmGestor = new JMenuItem("   \u2666 Gestor");
		mntmGestor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VentanaAlquileres ventanaAlquileres = new VentanaAlquileres();
				ventanaAlquileres.setVisible(true);
				ventanaAlquileres.setExtendedState(MAXIMIZED_BOTH);// maximisa la
				// ventana
				
			}
		});
		mntmGestor.setFont(new Font("Segoe UI", Font.BOLD, 23));
		mnNewMenu_1.add(mntmGestor);
		
		JMenu mnCasas = new JMenu("   \u2663 Ventas");
		mnCasas.setFont(new Font("Segoe UI", Font.BOLD, 23));
		mnIngreso.add(mnCasas);
		
		JMenuItem mntmGestor_1 = new JMenuItem("   \u2663 Gestor");
		mntmGestor_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VentanaVentas ventanVentas = new VentanaVentas();
				ventanVentas.setVisible(true);
				ventanVentas.setExtendedState(MAXIMIZED_BOTH);// maximisa la
				// ventana
				
			}
		});
		mntmGestor_1.setFont(new Font("Segoe UI", Font.BOLD, 23));
		mnCasas.add(mntmGestor_1);
		
		JMenu mnNewMenu_2 = new JMenu("   \u2666 Buscadores");
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.BOLD, 23));
		mnNewMenu.add(mnNewMenu_2);
		
		JMenuItem mntmBarrio = new JMenuItem("  \u2666  Barrio");
		mntmBarrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VentanaBuscadorBarrioInmuebles ventanaBuscador = new VentanaBuscadorBarrioInmuebles();
				ventanaBuscador.setVisible(true);
				ventanaBuscador.setExtendedState(MAXIMIZED_BOTH);// maximisa la

			}
		});
		mntmBarrio.setFont(new Font("Segoe UI", Font.BOLD, 23));
		mnNewMenu_2.add(mntmBarrio);
		
		JMenuItem mntmOperacin = new JMenuItem("  \u2660  Operaci\u00F3n");
		mntmOperacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				VentanaBuscadorBarriosTipos ventanaBuscador = new VentanaBuscadorBarriosTipos();
				ventanaBuscador.setVisible(true);
				ventanaBuscador.setExtendedState(MAXIMIZED_BOTH);// maximisa la

				
				
			}
		});
		mntmOperacin.setFont(new Font("Segoe UI", Font.BOLD, 23));
		mnNewMenu_2.add(mntmOperacin);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("  \u2663 Direcci\u00F3n");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VentanaBuscadorDirecciones ventanaBuscador = new VentanaBuscadorDirecciones();
				ventanaBuscador.setVisible(true);
				ventanaBuscador.setExtendedState(MAXIMIZED_BOTH);// maximisa la
				
			}
		});
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.BOLD, 22));
		mnNewMenu_2.add(mntmNewMenuItem_2);

		JMenu mnEditor = new JMenu("EDITOR   |  ");
		mnEditor.setForeground(new Color(255, 255, 224));
		mnEditor.setFont(new Font("Segoe UI Semilight", Font.BOLD, 23));
		menuBar.add(mnEditor);

		JMenuItem mntmMoneda = new JMenuItem("\u2660 Moneda        ");
		mntmMoneda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				VentanaEdicionMoneda ventanaEdicionMoneda = new VentanaEdicionMoneda();
				ventanaEdicionMoneda.setVisible(true);

			}
		});
		mntmMoneda.setFont(new Font("Segoe UI", Font.BOLD, 23));
		mnEditor.add(mntmMoneda);

		JMenuItem mntmNewMenuItem = new JMenuItem("\u2663 Casas");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				VentanaCasas ventanaCasas = new VentanaCasas();
				ventanaCasas.setVisible(true);
				ventanaCasas.setExtendedState(MAXIMIZED_BOTH);// maximisa la
																// ventana
				dispose();

			}
		});

		JMenuItem mntmApartamentos = new JMenuItem("\u2666 Apartamentos");
		mntmApartamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				VentanaApartamentos ventanaApartamentos = new VentanaApartamentos();
				ventanaApartamentos.setVisible(true);
				ventanaApartamentos.setExtendedState(MAXIMIZED_BOTH);// maximisa
																		// la
																		// ventana
				dispose();
			}
		});
		mntmApartamentos.setFont(new Font("Segoe UI", Font.BOLD, 23));
		mnEditor.add(mntmApartamentos);
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 23));
		mnEditor.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u2663 Terrenos");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ventanaTerreno.setVisible(true);
				ventanaTerreno.setExtendedState(MAXIMIZED_BOTH);// maximisa la
																// ventana
				dispose();

			}
		});
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.BOLD, 23));
		mnEditor.add(mntmNewMenuItem_1);

		JMenu mnControl = new JMenu("CONTROL   |  ");
		mnControl.setForeground(new Color(255, 255, 224));
		mnControl.setFont(new Font("Segoe UI Semilight", Font.BOLD, 23));
		menuBar.add(mnControl);

		JMenuItem mntmCerrar = new JMenuItem("\u2660 Cerrar         ");
		mntmCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				System.exit(0);
			}
		});
		mntmCerrar.setFont(new Font("Segoe UI", Font.BOLD, 23));
		mnControl.add(mntmCerrar);
		contentPane = new Fondo("sextoFondo.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(105, 105, 105));
		panel_7.setOpaque(true);
		panel_7.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_7.setBounds(57, 58, 953, 369);
		contentPane.add(panel_7);
		panel_7.setLayout(null);

		JPanel panel = new JPanel();
		panel.setOpaque(true);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBackground(Color.GRAY);
		panel.setBounds(50, 36, 270, 282);
		panel_7.add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("");
		label.setBounds(900, 64, 87, 74);
		label.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label.setBackground(Color.GRAY);
		panel.add(label);

		JLabel label_1 = new JLabel("0");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(182, 92, 78, 48);
		panel.add(label_1);
		label_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label_1.setBackground(Color.GRAY);

		JLabel lblCasas = new JLabel("Casas");
		lblCasas.setBounds(87, 21, 108, 35);
		lblCasas.setForeground(new Color(0, 0, 0));
		lblCasas.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panel.add(lblCasas);

		JLabel lblDisponibles = new JLabel("- Disponibles:");
		lblDisponibles.setBounds(10, 103, 185, 35);
		lblDisponibles.setForeground(new Color(0, 0, 0));
		lblDisponibles.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panel.add(lblDisponibles);

		JLabel lblSuspendidas = new JLabel("- Suspendidas:");
		lblSuspendidas.setBounds(10, 159, 185, 35);
		lblSuspendidas.setForeground(new Color(0, 0, 0));
		lblSuspendidas.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panel.add(lblSuspendidas);

		JLabel lblRetiradas = new JLabel("- Retiradas:");
		lblRetiradas.setBounds(10, 216, 185, 35);
		lblRetiradas.setForeground(new Color(0, 0, 0));
		lblRetiradas.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panel.add(lblRetiradas);

		JSeparator separator = new JSeparator();
		separator.setBounds(35, 64, 193, 2);
		panel.add(separator);

		JLabel label_2 = new JLabel("0");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label_2.setBackground(Color.GRAY);
		label_2.setBounds(182, 151, 78, 48);
		panel.add(label_2);

		JLabel label_3 = new JLabel("0");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label_3.setBackground(Color.GRAY);
		label_3.setBounds(182, 210, 78, 48);
		panel.add(label_3);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setOpaque(true);
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(344, 36, 270, 282);
		panel_7.add(panel_1);

		JLabel label_4 = new JLabel("");
		label_4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label_4.setBackground(Color.GRAY);
		label_4.setBounds(900, 64, 87, 74);
		panel_1.add(label_4);

		JLabel label_5 = new JLabel("0");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_5.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label_5.setBackground(Color.GRAY);
		label_5.setBounds(182, 92, 78, 48);
		panel_1.add(label_5);

		JLabel lblAptos = new JLabel("Aptos.");
		lblAptos.setForeground(Color.BLACK);
		lblAptos.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblAptos.setBounds(87, 21, 108, 35);
		panel_1.add(lblAptos);

		JLabel label_7 = new JLabel("- Disponibles:");
		label_7.setForeground(Color.BLACK);
		label_7.setFont(new Font("Times New Roman", Font.BOLD, 25));
		label_7.setBounds(10, 103, 185, 35);
		panel_1.add(label_7);

		JLabel label_8 = new JLabel("- Suspendidas:");
		label_8.setForeground(Color.BLACK);
		label_8.setFont(new Font("Times New Roman", Font.BOLD, 25));
		label_8.setBounds(10, 159, 185, 35);
		panel_1.add(label_8);

		JLabel label_9 = new JLabel("- Retiradas:");
		label_9.setForeground(Color.BLACK);
		label_9.setFont(new Font("Times New Roman", Font.BOLD, 25));
		label_9.setBounds(10, 216, 185, 35);
		panel_1.add(label_9);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(35, 64, 193, 2);
		panel_1.add(separator_1);

		JLabel label_10 = new JLabel("0");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_10.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label_10.setBackground(Color.GRAY);
		label_10.setBounds(182, 151, 78, 48);
		panel_1.add(label_10);

		JLabel label_11 = new JLabel("0");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_11.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label_11.setBackground(Color.GRAY);
		label_11.setBounds(182, 210, 78, 48);
		panel_1.add(label_11);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setOpaque(true);
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(643, 36, 270, 282);
		panel_7.add(panel_2);

		JLabel label_12 = new JLabel("");
		label_12.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label_12.setBackground(Color.GRAY);
		label_12.setBounds(900, 64, 87, 74);
		panel_2.add(label_12);

		JLabel label_13 = new JLabel("0");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_13.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label_13.setBackground(Color.GRAY);
		label_13.setBounds(182, 92, 78, 48);
		panel_2.add(label_13);

		JLabel lblTerreno = new JLabel("Terrenos");
		lblTerreno.setForeground(Color.BLACK);
		lblTerreno.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTerreno.setBounds(87, 21, 108, 35);
		panel_2.add(lblTerreno);

		JLabel label_15 = new JLabel("- Disponibles:");
		label_15.setForeground(Color.BLACK);
		label_15.setFont(new Font("Times New Roman", Font.BOLD, 25));
		label_15.setBounds(10, 103, 185, 35);
		panel_2.add(label_15);

		JLabel label_16 = new JLabel("- Suspendidas:");
		label_16.setForeground(Color.BLACK);
		label_16.setFont(new Font("Times New Roman", Font.BOLD, 25));
		label_16.setBounds(10, 159, 185, 35);
		panel_2.add(label_16);

		JLabel label_17 = new JLabel("- Retiradas:");
		label_17.setForeground(Color.BLACK);
		label_17.setFont(new Font("Times New Roman", Font.BOLD, 25));
		label_17.setBounds(10, 216, 185, 35);
		panel_2.add(label_17);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(35, 64, 193, 2);
		panel_2.add(separator_2);

		JLabel label_18 = new JLabel("0");
		label_18.setHorizontalAlignment(SwingConstants.CENTER);
		label_18.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_18.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label_18.setBackground(Color.GRAY);
		label_18.setBounds(182, 151, 78, 48);
		panel_2.add(label_18);

		JLabel label_19 = new JLabel("0");
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		label_19.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_19.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		label_19.setBackground(Color.GRAY);
		label_19.setBounds(182, 210, 78, 48);
		panel_2.add(label_19);

		ControladorList controlador = new ControladorList();

		String Casa = controlador.contarCasas();
		String[] Casas = Casa.split("/");

		label_1.setText(Casas[0]);
		label_2.setText(Casas[1]);
		label_3.setText(Casas[2]);

		String Aptos = controlador.contarAptos();
		String[] apartamentos = Aptos.split("/");

		label_5.setText(apartamentos[0]);
		label_10.setText(apartamentos[1]);
		label_11.setText(apartamentos[2]);

		String Terreno = controlador.contarTerrenos();
		String[] Terrenos = Terreno.split("/");

		label_13.setText(Terrenos[0]);
		label_18.setText(Terrenos[1]);
		label_19.setText(Terrenos[2]);
	}
}
