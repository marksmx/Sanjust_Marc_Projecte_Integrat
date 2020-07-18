package VISTA;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import DADES.SQLClients;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JTextPane;
import javax.swing.JTable;

public class EinesAdmin {
	
	
	/** IMPORTACIÓ I DECLARACIÓ DELS CONTROLADORS DE CONSULTES SQL QUE S'UTILITZEN EN AQUESTA PANTALLA */

	SQLClients sqlCl = new SQLClients();

	
	/** DECLARACIÓ DEL JFRAME, DE BOTONS, DE CAMPS DE TEXT I ALTRES */
	
	JFrame frame;
	JComboBox comboBox = new JComboBox();
	JButton btnNewButton = new JButton("ELIMINAR CLIENT");
	JButton button_1 = new JButton("TORNAR AL INICI");
	private JTextField txtEliminarClient;

	
	/** FUNCIÓ PER A CRIDAR A LA FUNCIÓ QUE COMPOSA ELS ELEMENTS DE LA PANTALLA I A LES FUNCIONS DE CONSTRUCCIÓ DE LA TAULA */

	public EinesAdmin() {
		
		initialize();
		
	}

	
	/** FUNCIÓ ON ES CONSTRUEIXEN TOTS ELS ELEMENTS DE LA PANTALLA I S'APLIQUEN LES CONSULTES SQL, ENTRE ALTRES FUNCIONS */

	private void initialize() {
		
		
		/** Aquí es declaren les característiques que tindrà la base de la pantalla (resolució, color, mida fixe) */

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setResizable(false);
		frame.getContentPane().setFocusable(false);
		frame.getContentPane().setFocusTraversalKeysEnabled(false);
		frame.setBounds(730, 300, 460, 337);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
        frame.setTitle("OnTime Agency App - v.2.0");
		
		/** Inici del conjunt d'elements que composen la capçalera */
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 454, 82);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTextField txtLogIn = new JTextField();
		txtLogIn.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogIn.setBounds(143, 11, 205, 29);
		txtLogIn.setForeground(Color.BLACK);
		panel.add(txtLogIn);
		txtLogIn.setBorder(null);
		txtLogIn.setAutoscrolls(false);
		txtLogIn.setFocusTraversalKeysEnabled(false);
		txtLogIn.setFocusable(false);
		txtLogIn.setBackground(Color.WHITE);
		txtLogIn.setSelectionColor(Color.GRAY);
		txtLogIn.setEditable(false);
		txtLogIn.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		txtLogIn.setText("ONTIME AGENCY");
		txtLogIn.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/VISTA/img/logo.png")));
		lblNewLabel.setBounds(0, 0, 102, 82);
		panel.add(lblNewLabel);
		
		txtEliminarClient = new JTextField();
		txtEliminarClient.setText("ELIMINAR CLIENT");
		txtEliminarClient.setSelectionColor(Color.GRAY);
		txtEliminarClient.setHorizontalAlignment(SwingConstants.CENTER);
		txtEliminarClient.setForeground(Color.BLACK);
		txtEliminarClient.setFont(new Font("HelveticaNeue", Font.PLAIN, 30));
		txtEliminarClient.setFocusable(false);
		txtEliminarClient.setFocusTraversalKeysEnabled(false);
		txtEliminarClient.setEditable(false);
		txtEliminarClient.setColumns(10);
		txtEliminarClient.setBorder(null);
		txtEliminarClient.setBackground(Color.WHITE);
		txtEliminarClient.setAutoscrolls(false);
		txtEliminarClient.setBounds(105, 35, 282, 36);
		panel.add(txtEliminarClient);
		
		/** Fi del conjunt d'elements que composen la capçalera */

		
		/** Inici conjunt de codi botons */
		/** Inici codi botó "Eliminar Client" */

		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnNewButton.setBackground(Color.BLACK);
				btnNewButton.setForeground(Color.WHITE);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnNewButton.setBackground(Color.WHITE);
				btnNewButton.setForeground(Color.BLACK);
				
			}
			
		});
		
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("HelveticaNeue", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					/** En clicar el botó, s'eliminarà el client seleccionat */
					
					sqlCl.eliminarClient(Integer.toString(comboBox.getSelectedIndex()));
					EinesAdmin frm = new EinesAdmin();
					frm.frame.setVisible(true);
					frame.setVisible(false);
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
					
				}
				
			}
			
		});
		
		btnNewButton.setBounds(121, 169, 219, 41);
		frame.getContentPane().add(btnNewButton);
		
		/** Fi codi botó "Eliminar Client" */

		
		/** Inici codi botó "Tornar al Inici" */

		button_1.setForeground(Color.BLACK);
		button_1.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				button_1.setBackground(Color.BLACK);
				button_1.setForeground(Color.WHITE);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				button_1.setBackground(Color.WHITE);
				button_1.setForeground(Color.BLACK);
				
			}
			
		});
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					/** En clicar el botó, es tornarà a la pantalla d'inici */
					
					Principal frm = new Principal();
					frm.frame.setVisible(true);
					frame.setVisible(false);
					
				} catch (Exception e2) {
					
					System.out.println("ERROR");
					
				}
				
			}
			
		});
		
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("HelveticaNeue", Font.BOLD, 16));
		button_1.setFocusPainted(false);
		button_1.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY));
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(121, 234, 219, 41);
		frame.getContentPane().add(button_1);
		
		comboBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		comboBox.setBackground(Color.WHITE);
		comboBox.setForeground(Color.BLACK);
		comboBox.setBounds(121, 112, 219, 35);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("");
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(EinesAdmin.class.getResource("/VISTA/img/backg.png")));
		lblNewLabel_1.setBounds(0, 0, 395, 308);
		frame.getContentPane().add(lblNewLabel_1);
		
		try {
			
			for(int i=0; i<=sqlCl.recompteClients()+1;i++) {
				System.out.println(i);
				try {
					if(sqlCl.consultarNomClient(Integer.toString(i)).equals(null)) {
						
					} else {
						comboBox.addItem(sqlCl.consultarNomClient(Integer.toString(i)));
					}
				} catch (Exception e) {
					
				}
				
			}
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
			
		}
		
		/** Fi codi botó "Tornar al Inici" */
		/** Fi conjunt de codi botons */
		
	}
}
