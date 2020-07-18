package VISTA;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.border.BevelBorder;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.Toolkit;
import javax.swing.JTabbedPane;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Properties;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JDesktopPane;
import java.io.File;
import java.io.IOException;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


import DADES.*;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class LogIn {

	
	/** IMPORTACIÓ I DECLARACIÓ DELS CONTROLADORS DE CONSULTES SQL QUE S'UTILITZEN EN AQUESTA PANTALLA */

	SQLUsuari sqlU = new SQLUsuari();

	
	/** DECLARACIÓ DEL JFRAME, DE BOTONS, DE CAMPS DE TEXT I ALTRES */
	
	public JFrame frame;
	JButton btnEntrar = new JButton("ENTRAR");

	private JTextField txtLogIn;
	JTextField textField;
	private JPasswordField passwordField;
	private JTextPane txtpnUsuari;
	private JTextField txtpnContrasenya;
	static LogIn window;
	private final JLabel lblNewLabel_1 = new JLabel("New label");
	private JTextField txtTest;
	

	/** EN AQUEST MAIN SERÀ ON S'INICIARÀ L'EXECUCIÓ DEL PROGRAMA */
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				try {
					
					window = new LogIn();
					
				} catch (Exception e) {
					
					e.printStackTrace();
					
				}
				
			}
			
		});
		
	}
	
	
	/** FUNCIÓ PER A CRIDAR A LA FUNCIÓ QUE COMPOSA ELS ELEMENTS DE LA PANTALLA I A LES FUNCIONS DE CONSTRUCCIÓ DE LA TAULA */
	
	public LogIn() throws SQLException {
		
		initialize();

		if(sqlU.exist() == false) {
			
			CrearUsuari frm = new CrearUsuari();
			frm.frame.setVisible(true);
			frame.setVisible(false);
			
		} else {
			
			frame.setVisible(true);
			
		}
		
	}

	
	/** FUNCIÓ ON ES CONSTRUEIXEN TOTS ELS ELEMENTS DE LA PANTALLA I S'APLIQUEN LES CONSULTES SQL, ENTRE ALTRES FUNCIONS */
	
	private void initialize() {
		
		
		/** Aquí es declaren les característiques que tindrà la base de la pantalla (resolució, color, mida fixe) */
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setResizable(false);
		frame.getContentPane().setFocusable(false);
		frame.getContentPane().setFocusTraversalKeysEnabled(false);
		frame.setBounds(730, 300, 472, 316);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
        frame.setTitle("OnTime Agency App - v.2.0");
		
		txtTest = new JTextField();
		txtTest.setToolTipText("Rebr\u00E0s un correu al teu Gmail amb la teva contrasenya");
		txtTest.setCaretColor(Color.RED);
		txtTest.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				final String username = "marcsanjustmartinez@gmail.com";
			    final String password = "IAmDedsec_27";
			    Properties props = new Properties();
			    
			    props.put("mail.smtp.auth", "true");
			    props.put("mail.smtp.starttls.enable", "true");
			    props.put("mail.smtp.host", "smtp.gmail.com");
			    props.put("mail.smtp.port", "587");
			    props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

			    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			    	protected PasswordAuthentication getPasswordAuthentication() {
			    		return new PasswordAuthentication(username, password);
			    	}
			    });
			    
			    try {
			    	
			    	Message message = new MimeMessage(session);
			    	message.setFrom(new InternetAddress(username));
			    	message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(sqlU.mailUsuari()));
			    	message.setSubject("Recuperació de contrasenya OnTime");
			    	message.setText("Hola, "+sqlU.nomUsuari() + "\n\n La teva contrasenya és: ''"+ sqlU.pwdUsuari() + "''");
			    	Transport transport = session.getTransport("smtp");
			        transport.connect(username, password);
			        transport.sendMessage(message, message.getAllRecipients());
			        transport.close();
			    	System.out.println("Correcto!");
					JOptionPane.showMessageDialog(null, "S'ha enviat un correu amb la contrasenya a "+sqlU.mailUsuari(),"",JOptionPane.INFORMATION_MESSAGE);

			    } catch (MessagingException e) {
			    	throw new RuntimeException(e);
			    } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				txtTest.setForeground(Color.GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				txtTest.setForeground(Color.WHITE);
			}
		});
		
		txtTest.setOpaque(false);
		txtTest.setText("[HE OBLIDAT LA CONTRASENYA]");
		txtTest.setHorizontalAlignment(SwingConstants.CENTER);
		txtTest.setForeground(Color.WHITE);
		txtTest.setFont(new Font("HelveticaNeue", Font.PLAIN, 10));
		txtTest.setFocusable(false);
		txtTest.setFocusTraversalKeysEnabled(false);
		txtTest.setFocusCycleRoot(false);
		txtTest.setEditable(false);
		txtTest.setBorder(null);
		txtTest.setBackground(Color.BLACK);
		txtTest.setBounds(138, 267, 210, 20);
		frame.getContentPane().add(txtTest);
		
		JTextField txtpnIdentificat = new JTextField();
		txtpnIdentificat.setBounds(154, 86, 147, 29);
		frame.getContentPane().add(txtpnIdentificat);
		txtpnIdentificat.setBorder(null);
		txtpnIdentificat.setHorizontalAlignment(SwingConstants.CENTER);
		txtpnIdentificat.setText("IDENTIFICA'T");
		txtpnIdentificat.setForeground(Color.WHITE);
		txtpnIdentificat.setFont(new Font("HelveticaNeue", Font.PLAIN, 16));
		txtpnIdentificat.setFocusable(false);
		txtpnIdentificat.setFocusTraversalKeysEnabled(false);
		txtpnIdentificat.setFocusCycleRoot(false);
		txtpnIdentificat.setEditable(false);
		txtpnIdentificat.setBackground(Color.BLACK);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 466, 82);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtLogIn = new JTextField();
		txtLogIn.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogIn.setBounds(86, 11, 329, 60);
		txtLogIn.setForeground(Color.BLACK);
		panel.add(txtLogIn);
		txtLogIn.setBorder(null);
		txtLogIn.setAutoscrolls(false);
		txtLogIn.setFocusTraversalKeysEnabled(false);
		txtLogIn.setFocusable(false);
		txtLogIn.setBackground(Color.WHITE);
		txtLogIn.setSelectionColor(Color.GRAY);
		txtLogIn.setEditable(false);
		txtLogIn.setFont(new Font("HelveticaNeue", Font.PLAIN, 35));
		txtLogIn.setText("ONTIME AGENCY");
		txtLogIn.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(LogIn.class.getResource("/VISTA/img/logo.png")));
		lblNewLabel.setBounds(0, 0, 102, 82);
		panel.add(lblNewLabel);
		
		/** Fi del conjunt d'elements que composen la capçalera */
		
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(null);
		layeredPane.setBackground(Color.BLACK);
		layeredPane.setBounds(23, 116, 416, 107);
		frame.getContentPane().add(layeredPane);
		
		txtpnUsuari = new JTextPane();
		txtpnUsuari.setOpaque(false);
		txtpnUsuari.setBackground(Color.BLACK);
		txtpnUsuari.setForeground(Color.WHITE);
		txtpnUsuari.setFocusable(false);
		txtpnUsuari.setFocusTraversalKeysEnabled(false);
		txtpnUsuari.setFocusCycleRoot(false);
		txtpnUsuari.setEditable(false);
		txtpnUsuari.setFont(new Font("HelveticaNeue", Font.PLAIN, 22));
		txtpnUsuari.setText("DNI");
		txtpnUsuari.setBounds(47, 11, 50, 27);
		layeredPane.add(txtpnUsuari);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("HelveticaNeue", Font.PLAIN, 15));
		textField.setBounds(10, 49, 124, 27);
		layeredPane.add(textField);
		textField.setColumns(10);
		
		txtpnContrasenya = new JTextField();
		txtpnContrasenya.setBorder(null);
		txtpnContrasenya.setHorizontalAlignment(SwingConstants.CENTER);
		txtpnContrasenya.setBackground(Color.BLACK);
		txtpnContrasenya.setForeground(Color.WHITE);
		txtpnContrasenya.setText("CONTRASENYA");
		txtpnContrasenya.setFont(new Font("HelveticaNeue", Font.PLAIN, 15));
		txtpnContrasenya.setFocusable(false);
		txtpnContrasenya.setFocusTraversalKeysEnabled(false);
		txtpnContrasenya.setFocusCycleRoot(false);
		txtpnContrasenya.setEditable(false);
		txtpnContrasenya.setBounds(279, 11, 127, 35);
		layeredPane.add(txtpnContrasenya);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("HelveticaNeue", Font.PLAIN, 15));
		passwordField.setBounds(279, 49, 127, 27);
		layeredPane.add(passwordField);
		
		
		/** Inici codi botó "Entratr" */
		
		btnEntrar.setForeground(Color.BLACK);
		btnEntrar.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnEntrar.setBackground(Color.BLACK);
				btnEntrar.setForeground(Color.WHITE);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnEntrar.setBackground(Color.WHITE);
				btnEntrar.setForeground(Color.BLACK);
				
			}
			
		});
		
		/** Fi codi botó "Entratr" */

		
		btnEntrar.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY));
		btnEntrar.setFocusPainted(false);
		btnEntrar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnEntrar.setBackground(Color.WHITE);
		btnEntrar.setFont(new Font("HelveticaNeue", Font.BOLD, 16));
		btnEntrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					if(sqlU.iniciarSessió(textField.getText(), passwordField.getText()) == true) {
						
						try {
							
							Principal frm = new Principal();
							frm.frame.setVisible(true);
							frame.setVisible(false);
							
						} catch (ClassNotFoundException e1) {
							
							e1.printStackTrace();
							
						}
						
					} else {
						
					}
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
					
				}
				
			}
			
		});
		
		btnEntrar.setBounds(177, 234, 117, 29);
		frame.getContentPane().add(btnEntrar);
		lblNewLabel_1.setIcon(new ImageIcon(LogIn.class.getResource("/VISTA/img/backg.png")));
		lblNewLabel_1.setBounds(0, 81, 348, 237);
		frame.getContentPane().add(lblNewLabel_1);
		
	}
}
