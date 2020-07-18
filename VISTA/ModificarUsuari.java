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
import DADES.SQLUsuari;
import MODEL.ClientCl;
import MODEL.ComandaCl;

import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class ModificarUsuari {
	
	
	/** IMPORTACIÓ I DECLARACIÓ DELS CONTROLADORS DE CONSULTES SQL QUE S'UTILITZEN EN AQUESTA PANTALLA */

	SQLClients sqlCl = new SQLClients();
	SQLUsuari sqlU = new SQLUsuari();


	/** DECLARACIÓ GLOBAL D'ALGUNES VARIABLES */

	private String idClient;

	
	/** DECLARACIÓ DEL JFRAME, DE BOTONS, DE CAMPS DE TEXT I ALTRES */

	JFrame frame;
	private boolean fet=false;
	JTextField textPane = new JTextField();
	JTextField textPane_1 = new JTextField();
	JTextField textPane_2 = new JTextField();
	JTextField textPane_3 = new JTextField();
	JTextField textPane_4 = new JTextField();
	JTextField textPane_5 = new JTextField();
	JTextField textPane_6 = new JTextField();
	JTextField textPane_8 = new JTextField();
	JButton button = new JButton("APLICAR CANVIS");
	JButton button_1 = new JButton("CANCEL·LAR OPERACIÓ");
	private JTextField txtModificarClient;
	private final JLabel lblNewLabel_1 = new JLabel("New label");

	
	/** FUNCIÓ PER A OMPLIR ELS CAMPS AMB LA INFORMACIÓ DEL CLIENT QUE VOLEM MODIFICAR */

	public void omplirCamps() throws SQLException {

	ArrayList<ClientCl> miLista = sqlCl.consultarClientperID(idClient);
		
		for (int i = 0; i < miLista.size(); i++) {
			
			textPane.setText(miLista.get(i).getEmpresa());
			textPane_2.setText(miLista.get(i).getConcepte());
			textPane_5.setText(miLista.get(i).getNif());
			textPane_6.setText(miLista.get(i).getId());
			textPane_8.setText(miLista.get(i).getMail());
			
		}
		
	}
	
	
	/** FUNCIÓ PER A CRIDAR A LA FUNCIÓ QUE COMPOSA ELS ELEMENTS DE LA PANTALLA I A LES FUNCIONS DE CONSTRUCCIÓ DE LA TAULA */

	public ModificarUsuari() throws SQLException {
		
		initialize();
		omplirCamps();
		
	}

	
	/** FUNCIÓ ON ES CONSTRUEIXEN TOTS ELS ELEMENTS DE LA PANTALLA I S'APLIQUEN LES CONSULTES SQL, ENTRE ALTRES FUNCIONS */

	private void initialize() throws SQLException {
		
		
		/** Aquí es declaren les característiques que tindrà la base de la pantalla (resolució, color, mida fixe) */
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setResizable(false);
		frame.getContentPane().setFocusable(false);
		frame.getContentPane().setFocusTraversalKeysEnabled(false);
		frame.setBounds(730, 300, 466, 508);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
        frame.setTitle("OnTime Agency App - v.2.0");
		
		/** Inici del conjunt d'elements que composen la capçalera */
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 467, 82);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTextField txtLogIn = new JTextField();
		txtLogIn.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogIn.setBounds(81, 11, 330, 30);
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
		txtLogIn.setText("OnTime Agency");
		txtLogIn.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ModificarClient.class.getResource("/VISTA/img/logo.png")));
		lblNewLabel.setBounds(0, 0, 102, 82);
		panel.add(lblNewLabel);
		
		txtModificarClient = new JTextField();
		txtModificarClient.setText("MODIFICAR PERFIL");
		txtModificarClient.setSelectionColor(Color.GRAY);
		txtModificarClient.setHorizontalAlignment(SwingConstants.CENTER);
		txtModificarClient.setForeground(Color.BLACK);
		txtModificarClient.setFont(new Font("HelveticaNeue", Font.PLAIN, 30));
		txtModificarClient.setFocusable(false);
		txtModificarClient.setFocusTraversalKeysEnabled(false);
		txtModificarClient.setEditable(false);
		txtModificarClient.setColumns(10);
		txtModificarClient.setBorder(null);
		txtModificarClient.setBackground(Color.WHITE);
		txtModificarClient.setAutoscrolls(false);
		txtModificarClient.setBounds(81, 40, 330, 31);
		panel.add(txtModificarClient);
		
		/** Fi del conjunt d'elements que composen la capçalera */
		textPane.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		textPane.setText(sqlU.nomUsuari());
		textPane.setForeground(Color.BLACK);
		textPane.setFont(new Font("HelveticaNeue", Font.PLAIN, 24));
		textPane.setFocusTraversalKeysEnabled(false);
		textPane.setFocusCycleRoot(false);
		textPane.setBackground(Color.WHITE);
		textPane.setBounds(44, 135, 159, 35);
		frame.getContentPane().add(textPane);
		textPane_1.setHorizontalAlignment(SwingConstants.CENTER);
		textPane_1.setBorder(null);
		
		textPane_1.setText("NOM");
		textPane_1.setForeground(Color.WHITE);
		textPane_1.setFont(new Font("HelveticaNeue", Font.PLAIN, 17));
		textPane_1.setFocusable(false);
		textPane_1.setFocusTraversalKeysEnabled(false);
		textPane_1.setFocusCycleRoot(false);
		textPane_1.setEditable(false);
		textPane_1.setBackground(Color.BLACK);
		textPane_1.setBounds(44, 93, 159, 42);
		frame.getContentPane().add(textPane_1);
		textPane_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		textPane_2.setText(sqlU.cognomsUsuari());
		textPane_2.setForeground(Color.BLACK);
		textPane_2.setFont(new Font("Dialog", Font.PLAIN, 22));
		textPane_2.setFocusTraversalKeysEnabled(false);
		textPane_2.setFocusCycleRoot(false);
		textPane_2.setBackground(Color.WHITE);
		textPane_2.setBounds(246, 135, 159, 35);
		frame.getContentPane().add(textPane_2);
		textPane_3.setHorizontalAlignment(SwingConstants.CENTER);
		textPane_3.setBorder(null);
		
		textPane_3.setText("COGNOM");
		textPane_3.setForeground(Color.WHITE);
		textPane_3.setFont(new Font("HelveticaNeue", Font.PLAIN, 17));
		textPane_3.setFocusable(false);
		textPane_3.setFocusTraversalKeysEnabled(false);
		textPane_3.setFocusCycleRoot(false);
		textPane_3.setEditable(false);
		textPane_3.setBackground(Color.BLACK);
		textPane_3.setBounds(246, 93, 159, 42);
		frame.getContentPane().add(textPane_3);
		textPane_4.setOpaque(false);
		textPane_4.setHorizontalAlignment(SwingConstants.CENTER);
		textPane_4.setBorder(null);
		
		textPane_4.setText("DNI");
		textPane_4.setForeground(Color.WHITE);
		textPane_4.setFont(new Font("HelveticaNeue", Font.PLAIN, 17));
		textPane_4.setFocusable(false);
		textPane_4.setFocusTraversalKeysEnabled(false);
		textPane_4.setFocusCycleRoot(false);
		textPane_4.setEditable(false);
		textPane_4.setBackground(Color.BLACK);
		textPane_4.setBounds(44, 201, 159, 42);
		frame.getContentPane().add(textPane_4);
		textPane_5.setHorizontalAlignment(SwingConstants.CENTER);
		
		textPane_5.setText(sqlU.dniUsuari());
		textPane_5.setForeground(Color.BLACK);
		textPane_5.setFont(new Font("Dialog", Font.PLAIN, 22));
		textPane_5.setFocusTraversalKeysEnabled(false);
		textPane_5.setFocusCycleRoot(false);
		textPane_5.setBackground(Color.WHITE);
		textPane_5.setBounds(44, 243, 159, 35);
		frame.getContentPane().add(textPane_5);
		
		textPane_6.setText(sqlU.pwdUsuari());
		textPane_6.setEnabled(true);
		textPane_6.setHorizontalAlignment(SwingConstants.CENTER);
		textPane_6.setForeground(Color.BLACK);
		textPane_6.setFont(new Font("Dialog", Font.PLAIN, 22));
		textPane_6.setFocusTraversalKeysEnabled(false);
		textPane_6.setFocusCycleRoot(false);
		textPane_6.setBackground(Color.WHITE);
		textPane_6.setBounds(246, 243, 159, 35);
		frame.getContentPane().add(textPane_6);
		
		JTextField textPane_7 = new JTextField();
		textPane_7.setOpaque(false);
		textPane_7.setHorizontalAlignment(SwingConstants.CENTER);
		textPane_7.setBorder(null);
		textPane_7.setText("CONTRASENYA");
		textPane_7.setForeground(Color.WHITE);
		textPane_7.setFont(new Font("HelveticaNeue", Font.PLAIN, 17));
		textPane_7.setFocusable(false);
		textPane_7.setFocusTraversalKeysEnabled(false);
		textPane_7.setFocusCycleRoot(false);
		textPane_7.setEditable(false);
		textPane_7.setBackground(Color.BLACK);
		textPane_7.setBounds(246, 201, 159, 42);
		frame.getContentPane().add(textPane_7);
		textPane_8.setHorizontalAlignment(SwingConstants.CENTER);
		
		textPane_8.setText(sqlU.mailUsuari());
		textPane_8.setForeground(Color.BLACK);
		textPane_8.setFont(new Font("Dialog", Font.PLAIN, 22));
		textPane_8.setFocusTraversalKeysEnabled(false);
		textPane_8.setFocusCycleRoot(false);
		textPane_8.setBackground(Color.WHITE);
		textPane_8.setBounds(44, 344, 361, 35);
		frame.getContentPane().add(textPane_8);
		
		JTextField textPane_9 = new JTextField();
		textPane_9.setBorder(null);
		textPane_9.setHorizontalAlignment(SwingConstants.CENTER);
		textPane_9.setText("Mail");
		textPane_9.setForeground(Color.WHITE);
		textPane_9.setFont(new Font("HelveticaNeue", Font.PLAIN, 22));
		textPane_9.setFocusable(false);
		textPane_9.setFocusTraversalKeysEnabled(false);
		textPane_9.setFocusCycleRoot(false);
		textPane_9.setEditable(false);
		textPane_9.setBackground(Color.BLACK);
		textPane_9.setBounds(44, 299, 361, 42);
		textPane_9.setOpaque(false);
		frame.getContentPane().add(textPane_9);
		

		/** Inici conjunt de codi que composa els botons */
		/** Inici botó "Cancel·lar Operació" */
		
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
		
		button_1.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY));
		button_1.setFocusPainted(false);
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		button_1.setBackground(Color.WHITE);
		button_1.setFont(new Font("HelveticaNeue", Font.BOLD, 10));
		button_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					/** En apretar el botó, ens tornarà a la pantalla principal */
					
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
		
		button_1.setBounds(255, 410, 150, 35);
		frame.getContentPane().add(button_1);
		
		/** Fi botó "Cancel·lar Operació" */


		/** Inici botó "Aplicar Canvis" */
		
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
				
				/** En apretar el botó, es comprova que els camps introduïts compleixin els requisíts abans d'aplicar els canvis */
				
				if(textPane_5.getText().length()>9) {
					
					JOptionPane.showMessageDialog(null, "El NIF és massa llarg","ERROR",JOptionPane.ERROR_MESSAGE);
					
				} else {
					
					if(textPane.getText().length()==0 || textPane_2.getText().length()==0 || textPane_5.getText().length()==0 || textPane_8.getText().length()==0) {
						
						JOptionPane.showMessageDialog(null, "Hi ha camps vuits!","ERROR",JOptionPane.ERROR_MESSAGE);
						
					} else {
						
						sqlU.modificarUsuari(textPane.getText(), textPane_2.getText(), textPane_5.getText(), textPane_8.getText(), textPane_6.getText());
						System.out.println("Hola");
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
		
		button.setBounds(44, 409, 150, 35);
		frame.getContentPane().add(button);
		lblNewLabel_1.setIcon(new ImageIcon(ModificarClient.class.getResource("/VISTA/img/backg.png")));
		lblNewLabel_1.setBounds(0, 11, 450, 468);
		
		frame.getContentPane().add(lblNewLabel_1);
		
		/** Fi botó "Aplicar Canvis" */
		/** Fi conjunt de codi que composa els botons */
	}
}
