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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import DADES.*;
import javax.swing.SwingConstants;

public class CrearUsuari {

	
	/** IMPORTACIÓ I DECLARACIÓ DELS CONTROLADORS DE CONSULTES SQL QUE S'UTILITZEN EN AQUESTA PANTALLA */

	SQLUsuari sqlU = new SQLUsuari();
	
	
	/** DECLARACIÓ DEL JFRAME, DE BOTONS I DE CAMPS DE TEXT */

	public JFrame frame;
	JButton button = new JButton("ACABAR I CONTINUAR");
	private JTextField txtCrearUsuari;


	/** FUNCIÓ PER A CRIDAR A LA FUNCIÓ QUE COMPOSA ELS ELEMENTS DE LA PANTALLA I A LES FUNCIONS DE CONSTRUCCIÓ DE LA TAULA */

	public CrearUsuari() {
		
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
		frame.setBounds(730, 300, 473, 461);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
        frame.setTitle("OnTime Agency App - v.2.0");
		
		/** Inici del conjunt d'elements que composen la capçalera */
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 467, 82);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtCrearUsuari = new JTextField();
		txtCrearUsuari.setHorizontalAlignment(SwingConstants.CENTER);
		txtCrearUsuari.setBounds(121, 36, 251, 35);
		panel.add(txtCrearUsuari);
		txtCrearUsuari.setText("CREAR USUARI");
		txtCrearUsuari.setSelectionColor(Color.GRAY);
		txtCrearUsuari.setForeground(Color.BLACK);
		txtCrearUsuari.setFont(new Font("HelveticaNeue", Font.PLAIN, 30));
		txtCrearUsuari.setFocusable(false);
		txtCrearUsuari.setFocusTraversalKeysEnabled(false);
		txtCrearUsuari.setEditable(false);
		txtCrearUsuari.setColumns(10);
		txtCrearUsuari.setBorder(null);
		txtCrearUsuari.setBackground(Color.WHITE);
		txtCrearUsuari.setAutoscrolls(false);
		
		JTextField txtLogIn = new JTextField();
		txtLogIn.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogIn.setBounds(160, 11, 180, 35);
		txtLogIn.setForeground(Color.BLACK);
		panel.add(txtLogIn);
		txtLogIn.setBorder(null);
		txtLogIn.setAutoscrolls(false);
		txtLogIn.setFocusTraversalKeysEnabled(false);
		txtLogIn.setFocusable(false);
		txtLogIn.setBackground(Color.WHITE);
		txtLogIn.setSelectionColor(Color.GRAY);
		txtLogIn.setEditable(false);
		txtLogIn.setFont(new Font("HelveticaNeue", Font.PLAIN, 15));
		txtLogIn.setText("ONTIME AGENCY");
		txtLogIn.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(CrearUsuari.class.getResource("/VISTA/img/logo.png")));
		lblNewLabel.setBounds(0, 0, 102, 82);
		panel.add(lblNewLabel);
		
		/** Fi del conjunt d'elements que composen la capçalera */
		
		JTextField textPane = new JTextField();
		textPane.setHorizontalAlignment(SwingConstants.CENTER);
		textPane.setText("");
		textPane.setForeground(Color.BLACK);
		textPane.setFont(new Font("Dialog", Font.PLAIN, 22));
		textPane.setFocusTraversalKeysEnabled(false);
		textPane.setFocusCycleRoot(false);
		textPane.setBackground(Color.WHITE);
		textPane.setBounds(44, 135, 159, 35);
		frame.getContentPane().add(textPane);
		
		JTextPane txtpnNom = new JTextPane();
		txtpnNom.setText("NOM");
		txtpnNom.setForeground(Color.WHITE);
		txtpnNom.setFont(new Font("HelveticaNeue", Font.PLAIN, 22));
		txtpnNom.setFocusable(false);
		txtpnNom.setFocusTraversalKeysEnabled(false);
		txtpnNom.setFocusCycleRoot(false);
		txtpnNom.setEditable(false);
		txtpnNom.setBackground(Color.BLACK);
		txtpnNom.setBounds(100, 93, 61, 42);
		frame.getContentPane().add(txtpnNom);
		
		JTextField textPane_2 = new JTextField();
		textPane_2.setHorizontalAlignment(SwingConstants.CENTER);
		textPane_2.setText("");
		textPane_2.setForeground(Color.BLACK);
		textPane_2.setFont(new Font("Dialog", Font.PLAIN, 22));
		textPane_2.setFocusTraversalKeysEnabled(false);
		textPane_2.setFocusCycleRoot(false);
		textPane_2.setBackground(Color.WHITE);
		textPane_2.setBounds(268, 135, 159, 35);
		frame.getContentPane().add(textPane_2);
		
		JTextPane txtpnCognom = new JTextPane();
		txtpnCognom.setText("COGNOM");
		txtpnCognom.setForeground(Color.WHITE);
		txtpnCognom.setFont(new Font("HelveticaNeue", Font.PLAIN, 22));
		txtpnCognom.setFocusable(false);
		txtpnCognom.setFocusTraversalKeysEnabled(false);
		txtpnCognom.setFocusCycleRoot(false);
		txtpnCognom.setEditable(false);
		txtpnCognom.setBackground(Color.BLACK);
		txtpnCognom.setBounds(291, 93, 109, 42);
		frame.getContentPane().add(txtpnCognom);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setOpaque(false);
		textPane_4.setText("DNI");
		textPane_4.setForeground(Color.WHITE);
		textPane_4.setFont(new Font("HelveticaNeue", Font.PLAIN, 22));
		textPane_4.setFocusable(false);
		textPane_4.setFocusTraversalKeysEnabled(false);
		textPane_4.setFocusCycleRoot(false);
		textPane_4.setEditable(false);
		textPane_4.setBackground(Color.BLACK);
		textPane_4.setBounds(105, 181, 47, 42);
		frame.getContentPane().add(textPane_4);
		
		JTextField textPane_5 = new JTextField();
		textPane_5.setHorizontalAlignment(SwingConstants.CENTER);
		textPane_5.setText("");
		textPane_5.setForeground(Color.BLACK);
		textPane_5.setFont(new Font("Dialog", Font.PLAIN, 22));
		textPane_5.setFocusTraversalKeysEnabled(false);
		textPane_5.setFocusCycleRoot(false);
		textPane_5.setBackground(Color.WHITE);
		textPane_5.setBounds(44, 223, 159, 35);
		frame.getContentPane().add(textPane_5);
		
		JTextField textPane_6 = new JTextField();
		textPane_6.setHorizontalAlignment(SwingConstants.CENTER);
		textPane_6.setText("");
		textPane_6.setForeground(Color.BLACK);
		textPane_6.setFont(new Font("Dialog", Font.PLAIN, 22));
		textPane_6.setFocusTraversalKeysEnabled(false);
		textPane_6.setFocusCycleRoot(false);
		textPane_6.setBackground(Color.WHITE);
		textPane_6.setBounds(268, 223, 159, 35);
		frame.getContentPane().add(textPane_6);
		
		JTextPane txtpnContrasenya = new JTextPane();
		txtpnContrasenya.setText("CONTRASENYA");
		txtpnContrasenya.setForeground(Color.WHITE);
		txtpnContrasenya.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		txtpnContrasenya.setFocusable(false);
		txtpnContrasenya.setFocusTraversalKeysEnabled(false);
		txtpnContrasenya.setFocusCycleRoot(false);
		txtpnContrasenya.setEditable(false);
		txtpnContrasenya.setBackground(Color.BLACK);
		txtpnContrasenya.setBounds(268, 181, 159, 35);
		frame.getContentPane().add(txtpnContrasenya);
		
		JTextField textPane_8 = new JTextField();
		textPane_8.setHorizontalAlignment(SwingConstants.CENTER);
		textPane_8.setText("");
		textPane_8.setForeground(Color.BLACK);
		textPane_8.setFont(new Font("Dialog", Font.PLAIN, 22));
		textPane_8.setFocusTraversalKeysEnabled(false);
		textPane_8.setFocusCycleRoot(false);
		textPane_8.setBackground(Color.WHITE);
		textPane_8.setBounds(44, 310, 383, 35);
		frame.getContentPane().add(textPane_8);
		
		JTextPane txtpnMail = new JTextPane();
		txtpnMail.setText("MAIL");
		txtpnMail.setForeground(Color.WHITE);
		txtpnMail.setFont(new Font("HelveticaNeue", Font.PLAIN, 22));
		txtpnMail.setFocusable(false);
		txtpnMail.setFocusTraversalKeysEnabled(false);
		txtpnMail.setFocusCycleRoot(false);
		txtpnMail.setEditable(false);
		txtpnMail.setBackground(Color.BLACK);
		txtpnMail.setBounds(205, 266, 61, 42);
		frame.getContentPane().add(txtpnMail);

		
		/** Inici codi botó "Acabar i Continuar" */
		
		button.setForeground(Color.BLACK);
		button.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				button.setBackground(Color.BLACK);
				button.setForeground(Color.WHITE);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				button.setBackground(Color.WHITE);
				button.setForeground(Color.BLACK);
				
			}
			
		});
		
		button.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY));
		button.setFocusPainted(false);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		button.setBackground(Color.WHITE);
		button.setFont(new Font("HelveticaNeue", Font.BOLD, 12));
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(textPane.getText().length()==0 || textPane_2.getText().length()==0 || textPane_5.getText().length()==0 || textPane_8.getText().length()==0 || textPane_6.getText().length()==0) {
					
					JOptionPane.showMessageDialog(null, "Has deixat camps sense omplir!","ERROR",JOptionPane.ERROR_MESSAGE);
					
				} else {
					
					if(textPane_5.getText().length()>9) {
						
						JOptionPane.showMessageDialog(null, "El DNI és massa llarg","ERROR",JOptionPane.ERROR_MESSAGE);
						
					} else {
						
						sqlU.crearPerfil(textPane.getText(), textPane_2.getText(), textPane_5.getText(), textPane_8.getText(), textPane_6.getText());
						
						try {
							
							LogIn frm = new LogIn();
							frm.frame.setVisible(true);
							frame.setVisible(false);
							
						} catch (SQLException e1) {
							
							e1.printStackTrace();
							
						}
						
					}
					
				}
				
			}
			
		});
		
		button.setBounds(153, 372, 174, 35);
		frame.getContentPane().add(button);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(CrearUsuari.class.getResource("/VISTA/img/backg.png")));
		lblNewLabel_1.setBounds(0, 0, 467, 432);
		frame.getContentPane().add(lblNewLabel_1);
		
		/** Fi codi botó "Acabar i Continuar" */
		
	}

}
