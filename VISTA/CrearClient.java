package VISTA;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;

import DADES.SQLClients;

import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.TextField;
import javax.swing.SwingConstants;

public class CrearClient {
	
	
	/** IMPORTACIÓ I DECLARACIÓ DELS CONTROLADORS DE CONSULTES SQL QUE S'UTILITZEN EN AQUESTA PANTALLA */
	
	SQLClients sqlCl = new SQLClients();
	
	
	/** DECLARACIÓ GLOBAL D'ALGUNES VARIABLES */
	
	private boolean fet=false;

	
	/** DECLARACIÓ DEL JFRAME, DE BOTONS I DE CAMPS DE TEXT */

	JFrame frame;
	JButton button = new JButton("AFEGIR CLIENT");
	JButton button_1 = new JButton("CANCEL·LAR OPERACIÓ");
	private JTextField textField;
	

	/** FUNCIÓ PER A CRIDAR A LA FUNCIÓ QUE COMPOSA ELS ELEMENTS DE LA PANTALLA I A LES FUNCIONS DE CONSTRUCCIÓ DE LA TAULA */

	public CrearClient() throws SQLException {
		
		initialize();
		
	}
	
	
	/** FUNCIÓ ON ES CONSTRUEIXEN TOTS ELS ELEMENTS DE LA PANTALLA I S'APLIQUEN LES CONSULTES SQL, ENTRE ALTRES FUNCIONS */

	private void initialize() throws SQLException {

		
		/** Aquí es declaren les característiques que tindrà la base de la pantalla (resolució, color, mida fixe) */
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setResizable(false);
		frame.getContentPane().setFocusable(false);
		frame.getContentPane().setFocusTraversalKeysEnabled(false);
		frame.setBounds(730, 300, 473, 515);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
        frame.setTitle("OnTime Agency App - v.2.0");
		
		/** Inici del conjunt d'elements que composen la capçalera */

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 688, 82);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTextField txtLogIn = new JTextField();
		txtLogIn.setBounds(133, 0, 220, 43);
		txtLogIn.setForeground(Color.BLACK);
		panel.add(txtLogIn);
		txtLogIn.setBorder(null);
		txtLogIn.setAutoscrolls(false);
		txtLogIn.setFocusTraversalKeysEnabled(false);
		txtLogIn.setFocusable(false);
		txtLogIn.setBackground(Color.WHITE);
		txtLogIn.setSelectionColor(Color.GRAY);
		txtLogIn.setEditable(false);
		txtLogIn.setFont(new Font("HelveticaNeue", Font.PLAIN, 25));
		txtLogIn.setText("ONTIME AGENCY");
		txtLogIn.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(CrearClient.class.getResource("/VISTA/img/logo.png")));
		lblNewLabel.setBounds(0, 0, 102, 82);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setText("CREAR CLIENT");
		textField.setSelectionColor(Color.GRAY);
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("HelveticaNeue", Font.PLAIN, 30));
		textField.setFocusable(false);
		textField.setFocusTraversalKeysEnabled(false);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBackground(Color.WHITE);
		textField.setAutoscrolls(false);
		textField.setBounds(127, 39, 220, 43);
		panel.add(textField);
		
		/** Fi del conjunt d'elements que composen la capçalera */

		
		/*JTextPane textPane = new JTextPane();
		textPane.setText("");
		textPane.setForeground(Color.BLACK);
		textPane.setFont(new Font("HelveticaNeue", Font.PLAIN, 24));
		textPane.setFocusTraversalKeysEnabled(false);
		textPane.setFocusCycleRoot(false);
		textPane.setBackground(Color.WHITE);
		textPane.setBounds(44, 135, 159, 35);
		frame.getContentPane().add(textPane);
		*/
		
		JTextField textPane = new JTextField();
		textPane.setHorizontalAlignment(SwingConstants.CENTER);
		textPane.setFont(new Font("HelveticaNeue", Font.PLAIN, 12));
		textPane.setBounds(44, 135, 159, 35);
		frame.getContentPane().add(textPane);
		textPane.setColumns(10);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("EMPRESA");
		textPane_1.setForeground(Color.LIGHT_GRAY);
		textPane_1.setFont(new Font("HelveticaNeue", Font.PLAIN, 22));
		textPane_1.setFocusable(false);
		textPane_1.setFocusTraversalKeysEnabled(false);
		textPane_1.setFocusCycleRoot(false);
		textPane_1.setEditable(false);
		textPane_1.setBackground(Color.BLACK);
		textPane_1.setBounds(71, 93, 110, 42);
		frame.getContentPane().add(textPane_1);
		
		JTextField textPane_2 = new JTextField();
		textPane_2.setHorizontalAlignment(SwingConstants.CENTER);
		textPane_2.setFont(new Font("HelveticaNeue", Font.PLAIN, 12));
		textPane_2.setColumns(10);
		textPane_2.setBounds(271, 135, 159, 35);
		frame.getContentPane().add(textPane_2);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setText("CONCEPTE");
		textPane_3.setForeground(Color.LIGHT_GRAY);
		textPane_3.setFont(new Font("HelveticaNeue", Font.PLAIN, 22));
		textPane_3.setFocusable(false);
		textPane_3.setFocusTraversalKeysEnabled(false);
		textPane_3.setFocusCycleRoot(false);
		textPane_3.setEditable(false);
		textPane_3.setBackground(Color.BLACK);
		textPane_3.setBounds(285, 93, 122, 42);
		frame.getContentPane().add(textPane_3);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setOpaque(false);
		textPane_4.setText("NIF");
		textPane_4.setForeground(Color.LIGHT_GRAY);
		textPane_4.setFont(new Font("HelveticaNeue", Font.PLAIN, 22));
		textPane_4.setFocusable(false);
		textPane_4.setFocusTraversalKeysEnabled(false);
		textPane_4.setFocusCycleRoot(false);
		textPane_4.setEditable(false);
		textPane_4.setBackground(Color.BLACK);
		textPane_4.setBounds(105, 201, 47, 42);
		frame.getContentPane().add(textPane_4);
		
		JTextField textPane_5 = new JTextField();
		textPane_5.setHorizontalAlignment(SwingConstants.CENTER);
		textPane_5.setFont(new Font("HelveticaNeue", Font.PLAIN, 12));
		textPane_5.setColumns(10);
		textPane_5.setBounds(44, 243, 159, 35);
		frame.getContentPane().add(textPane_5);
		
		JTextField textPane_6 = new JTextField();
		textPane_6.setHorizontalAlignment(SwingConstants.CENTER);
		textPane_6.setEditable(false);
		textPane_6.setText(Integer.toString(sqlCl.recompteClients()));
		textPane_6.setFont(new Font("Dialog", Font.PLAIN, 22));
		textPane_6.setBounds(329, 243, 47, 35);
		frame.getContentPane().add(textPane_6);
		
		JTextPane textPane_7 = new JTextPane();
		textPane_7.setOpaque(false);
		textPane_7.setText("ID CLIENT");
		textPane_7.setForeground(Color.LIGHT_GRAY);
		textPane_7.setFont(new Font("HelveticaNeue", Font.PLAIN, 22));
		textPane_7.setFocusable(false);
		textPane_7.setFocusTraversalKeysEnabled(false);
		textPane_7.setFocusCycleRoot(false);
		textPane_7.setEditable(false);
		textPane_7.setBackground(Color.BLACK);
		textPane_7.setBounds(297, 201, 122, 42);
		frame.getContentPane().add(textPane_7);
		
		JTextField textPane_8 = new JTextField();
		textPane_8.setHorizontalAlignment(SwingConstants.CENTER);
		textPane_8.setFont(new Font("HelveticaNeue", Font.PLAIN, 12));
		textPane_8.setColumns(10);
		textPane_8.setBounds(71, 339, 325, 35);
		frame.getContentPane().add(textPane_8);
		
		JTextPane textPane_9 = new JTextPane();
		textPane_9.setText("MAIL");
		textPane_9.setForeground(Color.LIGHT_GRAY);
		textPane_9.setFont(new Font("HelveticaNeue", Font.PLAIN, 22));
		textPane_9.setFocusable(false);
		textPane_9.setFocusTraversalKeysEnabled(false);
		textPane_9.setFocusCycleRoot(false);
		textPane_9.setEditable(false);
		textPane_9.setBackground(Color.BLACK);
		textPane_9.setBounds(202, 299, 65, 42);
		frame.getContentPane().add(textPane_9);
		
		
		/** Inici conjunt de codi dels botóns */
		/** Inici del botó "Cancel·lar Operació" */
		
		button_1.setOpaque(false);
		button_1.setForeground(Color.GRAY);
		button_1.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				button_1.setForeground(Color.WHITE);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				button_1.setForeground(Color.GRAY);
				
			}
			
		});
		
		button_1.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY));
		button_1.setFocusPainted(false);
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		button_1.setBackground(Color.WHITE);
		button_1.setFont(new Font("HelveticaNeue", Font.BOLD, 10));
		button_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					/** En clicar el botó, tornarem a la pantalla principal */
					
					Principal frm = new Principal();
					frm.frame.setVisible(true);
					frame.setVisible(false);
					
				} catch (ClassNotFoundException e1) {
					
					e1.printStackTrace();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
					
				}
			
			}
			
		});
		
		button_1.setBounds(246, 410, 150, 35);
		frame.getContentPane().add(button_1);
		
		/** Fi del botó "Cancel·lar Operació" */

		
		/** Inici del botó "Afegir Client" */
		
		button.setForeground(Color.GRAY);
		button.setOpaque(false);
		button.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				button.setForeground(Color.WHITE);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				button.setForeground(Color.GRAY);
				
			}
			
		});
		
		button.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY));
		button.setFocusPainted(false);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		button.setBackground(Color.WHITE);
		button.setFont(new Font("HelveticaNeue", Font.BOLD, 12));
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				/** En clicar el botó, comprovará els camps i afegirà un nou client */
				
				if(textPane.getText().length()==0 || textPane_2.getText().length()==0 || textPane_5.getText().length()==0 || textPane_8.getText().length()==0) {
					
					JOptionPane.showMessageDialog(null, "Has deixat camps sense omplir!","ERROR",JOptionPane.ERROR_MESSAGE);
					
				}else {
					
					if(textPane_5.getText().length()>9) {
						
						JOptionPane.showMessageDialog(null, "El NIF és massa llarg","ERROR",JOptionPane.ERROR_MESSAGE);
						
					} else {
						
						sqlCl.crearClient(textPane.getText(), textPane_2.getText(), textPane_5.getText(), textPane_6.getText(), textPane_8.getText());
						
						fet = true;
						
					}
					
				}
				
				if(fet == true) {
					
					try {
						
						Principal frm = new Principal();
						frm.frame.setVisible(true);
						frame.setVisible(false);
						
					} catch (ClassNotFoundException e1) {
						
						e1.printStackTrace();
						
					} catch (SQLException e1) {
						
						e1.printStackTrace();
						
					}
					
				} 
				
				fet = false;
				
			}
			
		});
		
		button.setBounds(71, 410, 150, 35);
		frame.getContentPane().add(button);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(CrearClient.class.getResource("/VISTA/img/backg.png")));
		lblNewLabel_1.setBounds(-42, 82, 509, 404);
		frame.getContentPane().add(lblNewLabel_1);
		
	
		
		
		
	
		
	
		
	
	
		/** Fi del botó "Afegir Client" */
		/** Fi conjunt de codi dels botóns */
		
	}

}
