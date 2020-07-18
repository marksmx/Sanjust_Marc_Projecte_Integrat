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

import DADES.SQLProductes;
import javax.swing.SwingConstants;

public class CrearProducte {
	
	/** IMPORTACIÓ I DECLARACIÓ DELS CONTROLADORS DE CONSULTES SQL QUE S'UTILITZEN EN AQUESTA PANTALLA */
	
	SQLProductes sqlP = new SQLProductes();
	
	
	/** DECLARACIÓ GLOBAL D'ALGUNES VARIABLES */

	private String curText="";
	private double iva = 0;
	private double total = 0;
	private boolean producte=false;
	private boolean servei=false;
	private int idCom = sqlP.contarProductes() + sqlP.contarServeis() + 1;

	
	/** DECLARACIÓ DEL JFRAME, DE BOTONS I DE CAMPS DE TEXT */

	JFrame frame;
	JButton button = new JButton("CREAR PRODUCTE");
	JButton button_1 = new JButton("CREAR SERVEI");
	JButton button_2 = new JButton("TORNAR A INICI");
	JButton button_3 = new JButton("CANCEL·LAR OPERACIÓ");
	JButton button_4 = new JButton("CREAR");
	JButton button_5 = new JButton("CALCULAR PREU");
	private JTextField txtCrearProducte;

	
	/** FUNCIÓ PER A CRIDAR A LA FUNCIÓ QUE COMPOSA ELS ELEMENTS DE LA PANTALLA I A LES FUNCIONS DE CONSTRUCCIÓ DE LA TAULA */

	public CrearProducte() throws ClassNotFoundException, SQLException {
		
		initialize();
		
	}

	
	/** FUNCIÓ ON ES CONSTRUEIXEN TOTS ELS ELEMENTS DE LA PANTALLA I S'APLIQUEN LES CONSULTES SQL, ENTRE ALTRES FUNCIONS */

	private void initialize() throws ClassNotFoundException, SQLException {

		
		/** Aquí es declaren les característiques que tindrà la base de la pantalla (resolució, color, mida fixe) */
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setResizable(false);
		frame.getContentPane().setFocusable(false);
		frame.getContentPane().setFocusTraversalKeysEnabled(false);
		frame.setBounds(730, 300, 819, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
        frame.setTitle("OnTime Agency App - v.2.0");
		
		/** Inici del conjunt d'elements que composen la capçalera */
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 813, 82);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTextField txtLogIn = new JTextField();
		txtLogIn.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogIn.setBounds(310, 0, 220, 44);
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
		lblNewLabel.setIcon(new ImageIcon(CrearProducte.class.getResource("/VISTA/img/logo.png")));
		lblNewLabel.setBounds(0, 0, 102, 82);
		panel.add(lblNewLabel);
		
		txtCrearProducte = new JTextField();
		txtCrearProducte.setHorizontalAlignment(SwingConstants.CENTER);
		txtCrearProducte.setText("CREAR PRODUCTE / SERVEI");
		txtCrearProducte.setSelectionColor(Color.GRAY);
		txtCrearProducte.setForeground(Color.BLACK);
		txtCrearProducte.setFont(new Font("HelveticaNeue", Font.PLAIN, 30));
		txtCrearProducte.setFocusable(false);
		txtCrearProducte.setFocusTraversalKeysEnabled(false);
		txtCrearProducte.setEditable(false);
		txtCrearProducte.setColumns(10);
		txtCrearProducte.setBorder(null);
		txtCrearProducte.setBackground(Color.WHITE);
		txtCrearProducte.setAutoscrolls(false);
		txtCrearProducte.setBounds(205, 30, 428, 52);
		panel.add(txtCrearProducte);

		/** Fi del conjunt d'elements que composen la capçalera */
		
		
		JTextField textPane = new JTextField();
		textPane.setHorizontalAlignment(SwingConstants.CENTER);
		textPane.setEnabled(false);
		textPane.setText("");
		textPane.setForeground(Color.BLACK);
		textPane.setFont(new Font("Dialog", Font.PLAIN, 22));
		textPane.setFocusTraversalKeysEnabled(false);
		textPane.setFocusCycleRoot(false);
		textPane.setBackground(Color.LIGHT_GRAY);
		textPane.setBounds(311, 135, 181, 35);
		frame.getContentPane().add(textPane);
		
		JTextPane txtpnElement = new JTextPane();
		txtpnElement.setText("ELEMENT\r\n");
		txtpnElement.setForeground(Color.WHITE);
		txtpnElement.setFont(new Font("HelveticaNeue", Font.PLAIN, 22));
		txtpnElement.setFocusable(false);
		txtpnElement.setFocusTraversalKeysEnabled(false);
		txtpnElement.setFocusCycleRoot(false);
		txtpnElement.setEditable(false);
		txtpnElement.setBackground(Color.BLACK);
		txtpnElement.setBounds(337, 93, 115, 42);
		frame.getContentPane().add(txtpnElement);
		
		JTextField textPane_2 = new JTextField();
		textPane_2.setHorizontalAlignment(SwingConstants.CENTER);
		textPane_2.setEnabled(false);
		textPane_2.setText("");
		textPane_2.setForeground(Color.BLACK);
		textPane_2.setFont(new Font("Dialog", Font.PLAIN, 22));
		textPane_2.setFocusTraversalKeysEnabled(false);
		textPane_2.setFocusCycleRoot(false);
		textPane_2.setBackground(Color.LIGHT_GRAY);
		textPane_2.setBounds(555, 135, 190, 35);
		frame.getContentPane().add(textPane_2);
		
		JTextPane txtpnFreqncia = new JTextPane();
		txtpnFreqncia.setText("FREQ\u00DC\u00C8NCIA");
		txtpnFreqncia.setForeground(Color.WHITE);
		txtpnFreqncia.setFont(new Font("HelveticaNeue", Font.PLAIN, 22));
		txtpnFreqncia.setFocusable(false);
		txtpnFreqncia.setFocusTraversalKeysEnabled(false);
		txtpnFreqncia.setFocusCycleRoot(false);
		txtpnFreqncia.setEditable(false);
		txtpnFreqncia.setBackground(Color.BLACK);
		txtpnFreqncia.setBounds(577, 93, 155, 42);
		frame.getContentPane().add(txtpnFreqncia);
		
		JTextPane txtpnUnitats = new JTextPane();
		txtpnUnitats.setText("UNITATS");
		txtpnUnitats.setForeground(Color.WHITE);
		txtpnUnitats.setFont(new Font("HelveticaNeue", Font.PLAIN, 22));
		txtpnUnitats.setFocusable(false);
		txtpnUnitats.setFocusTraversalKeysEnabled(false);
		txtpnUnitats.setFocusCycleRoot(false);
		txtpnUnitats.setEditable(false);
		txtpnUnitats.setBackground(Color.BLACK);
		txtpnUnitats.setBounds(349, 201, 101, 42);
		frame.getContentPane().add(txtpnUnitats);
		
		JTextField textPane_5 = new JTextField();
		textPane_5.setHorizontalAlignment(SwingConstants.CENTER);
		textPane_5.setEnabled(false);
		textPane_5.setText("");
		textPane_5.setForeground(Color.BLACK);
		textPane_5.setFont(new Font("Dialog", Font.PLAIN, 22));
		textPane_5.setFocusTraversalKeysEnabled(false);
		textPane_5.setFocusCycleRoot(false);
		textPane_5.setBackground(Color.LIGHT_GRAY);
		textPane_5.setBounds(376, 243, 55, 35);
		frame.getContentPane().add(textPane_5);
		
		JTextField textPane_6 = new JTextField();
		textPane_6.setHorizontalAlignment(SwingConstants.CENTER);
		textPane_6.setEnabled(true);
		textPane_6.setEditable(false);
		textPane_6.setText(Integer.toString(idCom));
		textPane_6.setForeground(Color.BLACK);
		textPane_6.setFont(new Font("Dialog", Font.PLAIN, 22));
		textPane_6.setFocusTraversalKeysEnabled(false);
		textPane_6.setFocusCycleRoot(false);
		textPane_6.setBackground(Color.WHITE);
		textPane_6.setBounds(632, 243, 55, 35);
		frame.getContentPane().add(textPane_6);
		
		JTextPane txtpnIdElement = new JTextPane();
		txtpnIdElement.setText("ID ELEMENT");
		txtpnIdElement.setForeground(Color.WHITE);
		txtpnIdElement.setFont(new Font("HelveticaNeue", Font.PLAIN, 22));
		txtpnIdElement.setFocusable(false);
		txtpnIdElement.setFocusTraversalKeysEnabled(false);
		txtpnIdElement.setFocusCycleRoot(false);
		txtpnIdElement.setEditable(false);
		txtpnIdElement.setBackground(Color.BLACK);
		txtpnIdElement.setBounds(593, 201, 139, 42);
		frame.getContentPane().add(txtpnIdElement);
	
		JTextField textPane_8 = new JTextField();
		textPane_8.setHorizontalAlignment(SwingConstants.CENTER);
		textPane_8.setEnabled(false);
		textPane_8.setText("");
		textPane_8.setForeground(Color.BLACK);
		textPane_8.setFont(new Font("Dialog", Font.PLAIN, 22));
		textPane_8.setFocusTraversalKeysEnabled(false);
		textPane_8.setFocusCycleRoot(false);
		textPane_8.setBackground(Color.LIGHT_GRAY);
		textPane_8.setBounds(349, 352, 90, 35);
		frame.getContentPane().add(textPane_8);
		
		JTextPane txtpnBase = new JTextPane();
		txtpnBase.setText("BASE");
		txtpnBase.setForeground(Color.WHITE);
		txtpnBase.setFont(new Font("HelveticaNeue", Font.PLAIN, 22));
		txtpnBase.setFocusable(false);
		txtpnBase.setFocusTraversalKeysEnabled(false);
		txtpnBase.setFocusCycleRoot(false);
		txtpnBase.setEditable(false);
		txtpnBase.setBackground(Color.BLACK);
		txtpnBase.setBounds(364, 309, 66, 42);
		frame.getContentPane().add(txtpnBase);
		
		JTextPane textPane_10 = new JTextPane();
		textPane_10.setText("IVA");
		textPane_10.setForeground(Color.WHITE);
		textPane_10.setFont(new Font("HelveticaNeue", Font.PLAIN, 22));
		textPane_10.setFocusable(false);
		textPane_10.setFocusTraversalKeysEnabled(false);
		textPane_10.setFocusCycleRoot(false);
		textPane_10.setEditable(false);
		textPane_10.setBackground(Color.BLACK);
		textPane_10.setBounds(521, 309, 47, 42);
		frame.getContentPane().add(textPane_10);
		
		JTextField textPane_11 = new JTextField();
		textPane_11.setHorizontalAlignment(SwingConstants.CENTER);
		textPane_11.setEnabled(false);
		textPane_11.setText("");
		textPane_11.setForeground(Color.BLACK);
		textPane_11.setFont(new Font("Dialog", Font.PLAIN, 22));
		textPane_11.setFocusTraversalKeysEnabled(false);
		textPane_11.setFocusCycleRoot(false);
		textPane_11.setBackground(Color.LIGHT_GRAY);
		textPane_11.setBounds(498, 352, 90, 35);
		frame.getContentPane().add(textPane_11);
		
		JTextField textPane_12 = new JTextField();
		textPane_12.setHorizontalAlignment(SwingConstants.CENTER);
		textPane_12.setEnabled(false);
		textPane_12.setText("");
		textPane_12.setForeground(Color.BLACK);
		textPane_12.setFont(new Font("Dialog", Font.PLAIN, 22));
		textPane_12.setFocusTraversalKeysEnabled(false);
		textPane_12.setFocusCycleRoot(false);
		textPane_12.setBackground(Color.LIGHT_GRAY);
		textPane_12.setBounds(655, 352, 90, 35);
		frame.getContentPane().add(textPane_12);
		
		JTextPane txtpnTotal = new JTextPane();
		txtpnTotal.setText("TOTAL");
		txtpnTotal.setForeground(Color.WHITE);
		txtpnTotal.setFont(new Font("HelveticaNeue", Font.PLAIN, 22));
		txtpnTotal.setFocusable(false);
		txtpnTotal.setFocusTraversalKeysEnabled(false);
		txtpnTotal.setFocusCycleRoot(false);
		txtpnTotal.setEditable(false);
		txtpnTotal.setBackground(Color.BLACK);
		txtpnTotal.setBounds(659, 309, 77, 42);
		frame.getContentPane().add(txtpnTotal);

		
		/** Inici conjunt codi botons */
		/** Inici botó "Tornar a Inici" */
		
		button_2.setForeground(Color.BLACK);
		button_2.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				button_2.setBackground(Color.BLACK);
				button_2.setForeground(Color.WHITE);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				button_2.setBackground(Color.WHITE);
				button_2.setForeground(Color.BLACK);
				
			}
			
		});
		
		button_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					/** Al clicar el botó, tornarem a la pantalla principal */
					
					Principal frm = new Principal();
					frm.frame.setVisible(true);
					frame.setVisible(false);
					
				} catch (ClassNotFoundException | SQLException e) {
					
					e.printStackTrace();
					
				}
				
			}
			
		});
		
		button_2.setForeground(Color.BLACK);
		button_2.setFont(new Font("HelveticaNeue", Font.BOLD, 12));
		button_2.setFocusPainted(false);
		button_2.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY));
		button_2.setBackground(Color.WHITE);
		button_2.setBounds(50, 352, 146, 35);
		frame.getContentPane().add(button_2);
		
		/** Fi botó "Tornar a Inici" */

		
		/** Inici botó "Cancel·lar Operació" */

		button_3.setForeground(Color.BLACK);
		button_3.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				button_3.setBackground(Color.BLACK);
				button_3.setForeground(Color.WHITE);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				button_3.setBackground(Color.WHITE);
				button_3.setForeground(Color.BLACK);
				
			}
			
		});
		
		button_3.setVisible(false);
		button_3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					/** Al clicar el botó, es reinicia la pantalla */
					
					CrearProducte frm = new CrearProducte();
					frm.frame.setVisible(true);
					frame.setVisible(false);
					
				} catch (ClassNotFoundException e1) {
					
					e1.printStackTrace();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
					
				}
				
			}
			
		});
		
		button_3.setForeground(Color.BLACK);
		button_3.setFont(new Font("HelveticaNeue", Font.BOLD, 10));
		button_3.setFocusPainted(false);
		button_3.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY));
		button_3.setBackground(Color.WHITE);
		button_3.setBounds(50, 309, 146, 35);
		frame.getContentPane().add(button_3);
		
		/** Fi botó "Cancel·lar Operació" */


		/** Inici botó "Crear Producte" */
		button.setToolTipText("Crea un Producte nou");

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
				
				/** Al clicar el botó, es creará un producte amb les característiques que li hem introduït */
				
				textPane.setBackground(Color.WHITE);
				textPane.setEnabled(true);
				textPane_5.setBackground(Color.WHITE);
				textPane_5.setEnabled(true);
				textPane_8.setBackground(Color.WHITE);
				textPane_8.setEnabled(true);
				textPane_11.setBackground(Color.WHITE);
				textPane_12.setBackground(Color.WHITE);
				button_3.setVisible(true);
				button_1.setVisible(false);
				button.setVisible(false);
				button_4.setVisible(true);
				button_5.setVisible(true);
				producte = true;
				servei = false;
				
			}
			
		});
		
		button.setBounds(50, 135, 146, 35);
		frame.getContentPane().add(button);
		
		/** Fi botó "Crear Producte" */

		
		/** Inici botó "Crear Servei" */
		button_1.setToolTipText("Crea un Servei nou");

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
		button_1.setFont(new Font("HelveticaNeue", Font.BOLD, 12));
		button_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				/** Al clicar el botó, es creará un servei amb les característiques que li hem introduït */

				textPane.setBackground(Color.WHITE);
				textPane.setEnabled(true);
				textPane_2.setBackground(Color.WHITE);
				textPane_2.setEnabled(true);
				textPane_5.setBackground(Color.WHITE);
				textPane_5.setEnabled(true);
				textPane_8.setBackground(Color.WHITE);
				textPane_8.setEnabled(true);
				textPane_11.setBackground(Color.WHITE);
				textPane_12.setBackground(Color.WHITE);
				button_3.setVisible(true);
				button_1.setVisible(false);
				button.setVisible(false);
				button_4.setVisible(true);
				button_5.setVisible(true);
				producte = false;
				servei = true;
				
			}
			
		});
		
		button_1.setBounds(50, 243, 146, 35);
		frame.getContentPane().add(button_1);
		
		/** Fi botó "Crear Servei" */

		
		/** Inici botó "Crear" */
		button_4.setToolTipText("Afegeix el Producte o Servei a la llista");

		button_4.setForeground(Color.BLACK);
		button_4.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				button_4.setBackground(Color.BLACK);
				button_4.setForeground(Color.WHITE);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				button_4.setBackground(Color.WHITE);
				button_4.setForeground(Color.BLACK);
				
			}
			
		});
		
		button_4.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				/** Al clicar el botó, es comprovaràn els camps i es crearà el producte o servei en qüestió */
				
				if(producte==true && servei==false) {
					
					if(textPane.getText().length()==0 || textPane_5.getText().length()==0 || textPane_8.getText().length()==0 || textPane_11.getText().length()==0 || textPane_12.getText().length()==0 || textPane_6.getText().length()==0) {
						
						JOptionPane.showMessageDialog(null, "Has deixat camps sense omplir!","ERROR",JOptionPane.ERROR_MESSAGE);
						
					}else {
						
						try {
							
							Integer.parseInt(textPane_5.getText());
							sqlP.crearProducte(textPane.getText(), textPane_5.getText(), textPane_8.getText(), textPane_11.getText(), textPane_12.getText(),Integer.toString(idCom));
							JOptionPane.showMessageDialog(null, "S'ha afegit correctament","",JOptionPane.INFORMATION_MESSAGE);
							CrearProducte frm = new CrearProducte();
							frm.frame.setVisible(true);
							frame.setVisible(false);
							
						} catch (Exception e2) {
							
							JOptionPane.showMessageDialog(null, "Les unitats han de ser números!","ERROR",JOptionPane.ERROR_MESSAGE);
							
						}
						
					}
					
				}
				
				if(producte==false && servei==true) {
					
					if(textPane.getText().length()==0  || textPane_2.getText().length()==0 || textPane_5.getText().length()==0 || textPane_8.getText().length()==0 || textPane_11.getText().length()==0 || textPane_12.getText().length()==0 || textPane_6.getText().length()==0) {
						
						JOptionPane.showMessageDialog(null, "Has deixat camps sense omplir!","ERROR",JOptionPane.ERROR_MESSAGE);
						
					} else {
						
						try {
							
							Integer.parseInt(textPane_5.getText());
							sqlP.crearServei(textPane.getText(), textPane_2.getText(), textPane_5.getText(), textPane_8.getText(), textPane_11.getText(), textPane_12.getText(), Integer.toString(idCom));
							JOptionPane.showMessageDialog(null, "S'ha afegit correctament","",JOptionPane.INFORMATION_MESSAGE);
							CrearProducte frm = new CrearProducte();
							frm.frame.setVisible(true);
							frame.setVisible(false);
							
						} catch (Exception e2) {
							
							JOptionPane.showMessageDialog(null, "Les unitats han de ser números!","ERROR",JOptionPane.ERROR_MESSAGE);
							
						}
						
					}
					
				}
				
			}
			
		});
		
		button_4.setVisible(false);
		button_4.setForeground(Color.BLACK);
		button_4.setFont(new Font("HelveticaNeue", Font.BOLD, 12));
		button_4.setFocusPainted(false);
		button_4.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY));
		button_4.setBackground(Color.WHITE);
		button_4.setBounds(50, 188, 146, 35);
		frame.getContentPane().add(button_4);
		
		/** Fi botó "Crear" */

		
		/** Inici botó "Calcular Preu" */
		button_5.setToolTipText("Calcula el IVA i el total a partir del preu base");

		button_5.setForeground(Color.BLACK);
		button_5.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				button_5.setBackground(Color.BLACK);
				button_5.setForeground(Color.WHITE);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				button_5.setBackground(Color.WHITE);
				button_5.setForeground(Color.BLACK);
				
			}
			
		});
		
		button_5.setVisible(false);
		button_5.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				/** Al clicar el botó, es calcularà el iva i el preu final a partir del preu base */
				
				if(textPane_8.getText().equals("")) {
					
				} else {
					
					try {
						
						Integer.parseInt(textPane_8.getText());
						iva = Integer.parseInt(textPane_8.getText()) * 0.21;
						textPane_11.setText(Double.toString(iva));
						total = Integer.parseInt(textPane_8.getText()) + iva;
						textPane_12.setText(Double.toString(total));
						
					} catch (Exception e2) {
						
						JOptionPane.showMessageDialog(null, "Has d'introduïr un número!","ERROR",JOptionPane.ERROR_MESSAGE);
						
					}
				
				}
				
			}
			
		});
		
		button_5.setForeground(Color.BLACK);
		button_5.setFont(new Font("HelveticaNeue", Font.BOLD, 10));
		button_5.setFocusPainted(false);
		button_5.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY));
		button_5.setBackground(Color.WHITE);
		button_5.setBounds(224, 352, 115, 35);
		frame.getContentPane().add(button_5);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(CrearProducte.class.getResource("/VISTA/img/backg.png")));
		lblNewLabel_1.setBounds(0, -28, 813, 459);
		frame.getContentPane().add(lblNewLabel_1);
		
		/** Fi botó "Calcular Preu" */
		/** Fi conjunt codi botons */
		
	}
	
}
