package VISTA;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextPane;

import DADES.SQLClients;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Font;
import java.sql.SQLException;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Info {
	
	
	/** IMPORTACIÓ I DECLARACIÓ DELS CONTROLADORS DE CONSULTES SQL QUE S'UTILITZEN EN AQUESTA PANTALLA */

	SQLClients sqlC = new SQLClients();

	
	/** DECLARACIÓ DEL JFRAME, DE BOTONS, DE CAMPS DE TEXT I ALTRES */

	JFrame frame;
	private JTextField txtInformaciDelClient;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	
	/** DECLARACIÓ GLOBAL D'ALGUNES VARIABLES */

	private String idClient;
	
	
	/** FUNCIÓ PER A CRIDAR A LA FUNCIÓ QUE COMPOSA ELS ELEMENTS DE LA PANTALLA I A LES FUNCIONS DE CONSTRUCCIÓ DE LA TAULA */

	public Info(String idClient) throws SQLException {
		
		this.idClient = idClient;
		initialize();
		
	}

	
	/** FUNCIÓ ON ES CONSTRUEIXEN TOTS ELS ELEMENTS DE LA PANTALLA I S'APLIQUEN LES CONSULTES SQL, ENTRE ALTRES FUNCIONS */

	private void initialize() throws SQLException {
		
		
		/** Aquí es declaren les característiques que tindrà la base de la pantalla (resolució, color, mida fixe) */

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setResizable(false);
		frame.setBounds(750, 400, 500, 300);
		frame.getContentPane().setLayout(null);
        frame.setTitle("OnTime Agency App - v.2.0");

		txtInformaciDelClient = new JTextField();
		txtInformaciDelClient.setHorizontalAlignment(SwingConstants.CENTER);
		txtInformaciDelClient.setText("INFORMACI\u00D3 DEL CLIENT");
		txtInformaciDelClient.setSelectionColor(Color.GRAY);
		txtInformaciDelClient.setForeground(Color.WHITE);
		txtInformaciDelClient.setFont(new Font("HelveticaNeue", Font.PLAIN, 25));
		txtInformaciDelClient.setFocusable(false);
		txtInformaciDelClient.setFocusTraversalKeysEnabled(false);
		txtInformaciDelClient.setEditable(false);
		txtInformaciDelClient.setColumns(10);
		txtInformaciDelClient.setBorder(null);
		txtInformaciDelClient.setBackground(Color.BLACK);
		txtInformaciDelClient.setAutoscrolls(false);
		txtInformaciDelClient.setBounds(0, 11, 494, 60);
		frame.getContentPane().add(txtInformaciDelClient);
		
		textField_1 = new JTextField();
		textField_1.setOpaque(false);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setText("EMPRESA");
		textField_1.setSelectionColor(Color.GRAY);
		textField_1.setForeground(Color.LIGHT_GRAY);
		textField_1.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		textField_1.setFocusable(false);
		textField_1.setFocusTraversalKeysEnabled(false);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBackground(Color.BLACK);
		textField_1.setAutoscrolls(false);
		textField_1.setBounds(10, 82, 188, 41);
		frame.getContentPane().add(textField_1);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setText("CONCEPTE");
		textField_3.setSelectionColor(Color.GRAY);
		textField_3.setForeground(Color.LIGHT_GRAY);
		textField_3.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		textField_3.setFocusable(false);
		textField_3.setFocusTraversalKeysEnabled(false);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBorder(null);
		textField_3.setBackground(Color.BLACK);
		textField_3.setAutoscrolls(false);
		textField_3.setBounds(268, 82, 216, 41);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setOpaque(false);
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setText("MAIL");
		textField_4.setSelectionColor(Color.GRAY);
		textField_4.setForeground(Color.LIGHT_GRAY);
		textField_4.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		textField_4.setFocusable(false);
		textField_4.setFocusTraversalKeysEnabled(false);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBorder(null);
		textField_4.setBackground(Color.BLACK);
		textField_4.setAutoscrolls(false);
		textField_4.setBounds(119, 149, 231, 41);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setOpaque(false);
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setText(sqlC.consultarNomClient(idClient));
		textField_5.setSelectionColor(Color.GRAY);
		textField_5.setForeground(Color.WHITE);
		textField_5.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		textField_5.setFocusable(false);
		textField_5.setFocusTraversalKeysEnabled(false);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBorder(null);
		textField_5.setBackground(Color.BLACK);
		textField_5.setAutoscrolls(false);
		textField_5.setBounds(10, 120, 188, 41);
		frame.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setOpaque(false);
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setText(sqlC.consultarMailClient(idClient));
		textField_6.setSelectionColor(Color.GRAY);
		textField_6.setForeground(Color.WHITE);
		textField_6.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		textField_6.setFocusable(false);
		textField_6.setFocusTraversalKeysEnabled(false);
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBorder(null);
		textField_6.setBackground(Color.BLACK);
		textField_6.setAutoscrolls(false);
		textField_6.setBounds(119, 195, 231, 41);
		frame.getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setOpaque(false);
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setText(sqlC.consultarEmpresaClient(idClient));
		textField_7.setSelectionColor(Color.GRAY);
		textField_7.setForeground(Color.WHITE);
		textField_7.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		textField_7.setFocusable(false);
		textField_7.setFocusTraversalKeysEnabled(false);
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBorder(null);
		textField_7.setBackground(Color.BLACK);
		textField_7.setAutoscrolls(false);
		textField_7.setBounds(268, 120, 216, 41);
		frame.getContentPane().add(textField_7);
		
	}
	
}
