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
import java.awt.Canvas;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import DADES.*;
import MODEL.*;
import java.awt.Label;
import javax.swing.ScrollPaneConstants;
import java.awt.ComponentOrientation;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class Principal {
	
	
	/** IMPORTACIÓ I DECLARACIÓ DELS CONTROLADORS DE CONSULTES SQL QUE S'UTILITZEN EN AQUESTA PANTALLA */

	SQLComandes sqlC = new SQLComandes();
	SQLClients sqlCl = new SQLClients();
	SQLProductes sqlPr = new SQLProductes();

	
	/** DECLARACIÓ GLOBAL D'ALGUNES VARIABLES */

	private int filaIndex;
	private int columnaIndex;
	private int perF = 0;
	private int perEP = 0;
	private int perP = 0;
	private boolean isSelected = false;
	private String test = "";
	private String dLimit = "";

	/** DECLARACIÓ DEL JFRAME, DE BOTONS, DE CAMPS DE TEXT I ALTRES */

	public JFrame frame;
	private JTable table_1;
	private JTable table_2;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	JButton btnNewButton = new JButton("CONSULTAR CLIENT SELECCIONAT");
	JButton btnAfegirClient = new JButton("AFEGIR CLIENT");
	JButton btnAfegirProducteservei = new JButton("CREAR PRODUCTE/SERVEI");
	JButton btnEinesDadmin = new JButton("ELIMINAR CLIENTS");
	JButton btnConsultarComandesPendents = new JButton("");

	
	/** FUNCIÓ PER A CRIDAR A LA FUNCIÓ QUE COMPOSA ELS ELEMENTS DE LA PANTALLA I A LES FUNCIONS DE CONSTRUCCIÓ DE LA TAULA */

	public Principal() throws ClassNotFoundException, SQLException {
		
		initialize();
		construirTaula();
		construirTauler();
		
	}
	
	/** INICI FUNCIONS TAULA PRINCIPAL */
	/** FUNCIÓ PER A CONSTRUÏR LA TAULA DE CLIENTS */

	private void construirTaula() throws ClassNotFoundException, SQLException {
		
		String cap[] = {"EMPRESA","CONCEPTE", "NIF", "ID"};
		String info[][] = obtenirMatriu();
		
		table_1 = new JTable(info, cap);
		table_1.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				isSelected = true;
				
			}
			
		});
		
		scrollPane.setViewportView(table_1);

	}
	
	
	/** FUNCIÓ PER A RECOPILAR LA INFORMACIÓ DELS CLIENTS AMB LA QUE S'OMPLIRÀ LA TAULA */

	private String[][] obtenirMatriu() throws ClassNotFoundException, SQLException {
		
		SQLClients sqlU = new SQLClients();
			ArrayList<ClientCl> miLista = sqlU.consultarClient();
			
			String matInfo[][] = new String[miLista.size()] [4];

			for (int i = 0; i < miLista.size(); i++) {
				
				matInfo[i][0] = miLista.get(i).getEmpresa()+"";
				matInfo[i][1] = miLista.get(i).getConcepte()+"";
				matInfo[i][2] = miLista.get(i).getNif()+"";
				matInfo[i][3] = miLista.get(i).getId()+"";

			}
			
		return matInfo;
		
	}

	/** FI FUNCIONS TAULA PRINCIPAL */

	
	/**INICI FUNCIONS TAULER*/
	/** FUNCIÓ PER A CONSTRUÏR LA TAULA DEL TAULER DE RECORDATORIS */

		private void construirTauler() throws ClassNotFoundException, SQLException {
			
			String cap[] = {"TAULER"};
			String info[][] = obtenirMatr();
			
			table_2 = new JTable(info, cap);
			table_2.setForeground(Color.BLACK);
			table_2.setFont(new Font("HelveticaNeue", Font.PLAIN, 11));
			table_2.setBorder(null);
			scrollPane_1.setViewportView(table_2);

		}
		
		
		/** FUNCIÓ PER A RECOPILAR LA INFORMACIÓ DE LES COMANDES AMB LA QUE S'OMPLIRÀ EL TAULER DE RECORDATORIS */
		
		private String[][] obtenirMatr() throws ClassNotFoundException, SQLException {
			
			ArrayList<ComandaCl> miLista = sqlC.consultarComandes();
			String matInfo[][] = new String[miLista.size()] [2];
			
			try {
				
				if(sqlC.contarComandes()==0) {
					
				} else {
					
					for (int x = 0; x < miLista.size(); x++) {
						
						matInfo[x][0] = sqlC.consultarEstatComanda(Integer.toString(x+1)) + " " + sqlCl.consultarNomClient(miLista.get(x).getIdEmpresa())+" - "+sqlPr.consultarProducte(miLista.get(x).getIdProducte());
						
					}
					
				}
				
			} catch (Exception e) {
				
				System.out.println("");
				
			}
			
			return matInfo;

		}

	/**FI FUNCIONS TAULER*/
	
		
	/** FUNCIÓ ON ES CONSTRUEIXEN TOTS ELS ELEMENTS DE LA PANTALLA I S'APLIQUEN LES CONSULTES SQL, ENTRE ALTRES FUNCIONS */

	private void initialize() {
		
		
		/** Aquí es declaren les característiques que tindrà la base de la pantalla (resolució, color, mida fixe) */

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setResizable(false);
		frame.getContentPane().setFocusable(false);
		frame.getContentPane().setFocusTraversalKeysEnabled(false);
		frame.setBounds(730, 300, 686, 566);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
        frame.setTitle("OnTime Agency App - v.2.0");
		
        
		/** Inici del conjunt d'elements que composen la capçalera */
		
        
		JButton btnModificarContrasenya = new JButton("MODIFICAR PERFIL");
		btnModificarContrasenya.setOpaque(false);
        btnModificarContrasenya.setForeground(Color.GRAY);
        btnModificarContrasenya.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnModificarContrasenya.setForeground(Color.WHITE);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnModificarContrasenya.setForeground(Color.GRAY);
				
			}
			
		});
        
		btnModificarContrasenya.setToolTipText("Modificar la informaci\u00F3 del teu perfil");
		btnModificarContrasenya.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/** En clicar aquest botó, s'obrirà la pantalla "Modificar Perfil" */
				
				try {
					ModificarUsuari frm = new ModificarUsuari();
					frm.frame.setVisible(true);
					frame.setVisible(false);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		
		btnConsultarComandesPendents.setForeground(Color.BLACK);
		btnConsultarComandesPendents.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnConsultarComandesPendents.setBackground(Color.BLACK);
				btnConsultarComandesPendents.setForeground(Color.WHITE);
				btnConsultarComandesPendents.setIcon(new ImageIcon(Principal.class.getResource("/VISTA/img/be_w.png")));

			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnConsultarComandesPendents.setBackground(Color.WHITE);
				btnConsultarComandesPendents.setForeground(Color.BLACK);
				btnConsultarComandesPendents.setIcon(new ImageIcon(Principal.class.getResource("/VISTA/img/be.png")));

			}
			
		});
		
		btnConsultarComandesPendents.setIcon(new ImageIcon(Principal.class.getResource("/VISTA/img/be.png")));
		btnConsultarComandesPendents.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
			    /** Inici conjunt de codi notificació de tasca pendent */
		        
		        try {
		        	
		        	
		        	for(int z=0; z<99; z++) {
		        		
			        	int recompteComPen = 0;
		             	ArrayList<String> miLista = sqlC.consultarDataLimit(Integer.toString(z));
		        		String matInfo[] = new String[miLista.size()];
		        		
		        		for (int i = 0; i < miLista.size(); i++) {
		        			
		        			test = ""+miLista.get(i).charAt(0)+miLista.get(i).charAt(1)+miLista.get(i).charAt(2);
		        			
		        			if(test.equals("Sen")) {
		        				
		        				
		        			} else {
		        				
		        				dLimit = ""+miLista.get(i).charAt(0)+miLista.get(i).charAt(1)+miLista.get(i).charAt(2)+
		        						miLista.get(i).charAt(3)+miLista.get(i).charAt(4)+miLista.get(i).charAt(5)+
		        						miLista.get(i).charAt(6)+miLista.get(i).charAt(7)+miLista.get(i).charAt(8)+
		        						miLista.get(i).charAt(9)+miLista.get(i).charAt(10);
		        				System.out.println(dLimit);
		        				++recompteComPen;
		        				
		        			}
		        			
		        		}
		        		
		       			if(recompteComPen>0) {
	        				
	        				JOptionPane.showMessageDialog(null, "Tens " + recompteComPen + " Comandes Pendents de " + sqlCl.consultarNomClient(Integer.toString(z)) + " per el dia " + dLimit,"", JOptionPane.INFORMATION_MESSAGE);

	        			} 
		       			
		        	}
		   
		    		
				} catch (Exception e) {
					
					System.out.println("ERROR");
					
				}
		    
		        
		        /** Fi conjunt de codi notificació de tasca pendent */
		        
			}
		});
		
		btnConsultarComandesPendents.setToolTipText("Consultar Comandes Pendents\r\n");
		btnConsultarComandesPendents.setForeground(Color.BLACK);
		btnConsultarComandesPendents.setFont(new Font("HelveticaNeue", Font.BOLD, 10));
		btnConsultarComandesPendents.setFocusPainted(false);
		btnConsultarComandesPendents.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY));
		btnConsultarComandesPendents.setBackground(Color.WHITE);
		btnConsultarComandesPendents.setBounds(80, 297, 45, 44);
		frame.getContentPane().add(btnConsultarComandesPendents);
		btnModificarContrasenya.setFont(new Font("HelveticaNeue", Font.BOLD, 12));
		btnModificarContrasenya.setFocusPainted(false);
		btnModificarContrasenya.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY));
		btnModificarContrasenya.setBackground(Color.WHITE);
		btnModificarContrasenya.setBounds(319, 467, 205, 44);
		frame.getContentPane().add(btnModificarContrasenya);
		
		JTextPane txtpnGrficDeProjectes = new JTextPane();
		txtpnGrficDeProjectes.setText("GR\u00C0FIC DE PROJECTES");
		txtpnGrficDeProjectes.setOpaque(false);
		txtpnGrficDeProjectes.setForeground(Color.LIGHT_GRAY);
		txtpnGrficDeProjectes.setFont(new Font("HelveticaNeue", Font.PLAIN, 16));
		txtpnGrficDeProjectes.setFocusable(false);
		txtpnGrficDeProjectes.setFocusTraversalKeysEnabled(false);
		txtpnGrficDeProjectes.setFocusCycleRoot(false);
		txtpnGrficDeProjectes.setEditable(false);
		txtpnGrficDeProjectes.setBackground(Color.BLACK);
		txtpnGrficDeProjectes.setBounds(10, 110, 205, 25);
		frame.getContentPane().add(txtpnGrficDeProjectes);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 680, 82);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTextField txtLogIn = new JTextField();
		txtLogIn.setOpaque(false);
		txtLogIn.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogIn.setBounds(0, 11, 680, 60);
		txtLogIn.setForeground(Color.BLACK);
		panel.add(txtLogIn);
		txtLogIn.setBorder(null);
		txtLogIn.setAutoscrolls(false);
		txtLogIn.setFocusTraversalKeysEnabled(false);
		txtLogIn.setFocusable(false);
		txtLogIn.setBackground(Color.WHITE);
		txtLogIn.setSelectionColor(Color.GRAY);
		txtLogIn.setEditable(false);
		txtLogIn.setFont(new Font("HelveticaNeue", Font.PLAIN, 45));
		txtLogIn.setText("ONTIME AGENCY");
		txtLogIn.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/VISTA/img/logo.png")));
		lblNewLabel.setBounds(0, 0, 102, 82);
		panel.add(lblNewLabel);
		
		/** Fi del conjunt d'elements que composen la capçalera */
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GREEN);
		panel_1.setBounds(32, 150, 30, 16);
		frame.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.YELLOW);
		panel_2.setBounds(32, 180, 30, 16);
		frame.getContentPane().add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(32, 210, 30, 16);
		frame.getContentPane().add(panel_3);

		
		JTextPane textPane = new JTextPane();
		textPane.setOpaque(false);
		textPane.setText("FINALITZATS");
		textPane.setForeground(Color.LIGHT_GRAY);
		textPane.setFont(new Font("HelveticaNeue", Font.PLAIN, 16));
		textPane.setFocusable(false);
		textPane.setFocusTraversalKeysEnabled(false);
		textPane.setFocusCycleRoot(false);
		textPane.setEditable(false);
		textPane.setBackground(Color.BLACK);
		textPane.setBounds(72, 144, 107, 25);
		frame.getContentPane().add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setOpaque(false);
		textPane_1.setText("EN PROCÉS");
		textPane_1.setForeground(Color.LIGHT_GRAY);
		textPane_1.setFont(new Font("HelveticaNeue", Font.PLAIN, 16));
		textPane_1.setFocusable(false);
		textPane_1.setFocusTraversalKeysEnabled(false);
		textPane_1.setFocusCycleRoot(false);
		textPane_1.setEditable(false);
		textPane_1.setBackground(Color.BLACK);
		textPane_1.setBounds(72, 175, 107, 30);
		frame.getContentPane().add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setOpaque(false);
		textPane_2.setText("PENDENTS");
		textPane_2.setForeground(Color.LIGHT_GRAY);
		textPane_2.setFont(new Font("HelveticaNeue", Font.PLAIN, 16));
		textPane_2.setFocusable(false);
		textPane_2.setFocusTraversalKeysEnabled(false);
		textPane_2.setFocusCycleRoot(false);
		textPane_2.setEditable(false);
		textPane_2.setBackground(Color.BLACK);
		textPane_2.setBounds(72, 205, 92, 27);
		frame.getContentPane().add(textPane_2);
		
		
		/** Inici conjunt codi que composa els botons */
		/** Inici codi botó "Consultar Client" */
		btnNewButton.setToolTipText("Accedeix a la pantalla de gesti\u00F3 d'informaci\u00F3 i comandes del client seleccionat");
		btnNewButton.setOpaque(false);
		btnNewButton.setForeground(Color.GRAY);
		btnNewButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnNewButton.setForeground(Color.WHITE);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnNewButton.setForeground(Color.GRAY);
				
			}
			
		});
		
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("HelveticaNeue", Font.BOLD, 9));
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					if(isSelected == false) {
						
					} else {
						
						Client frm = new Client(table_1.getModel().getValueAt(table_1.getSelectedRow(), 3).toString());
						frm.frame.setVisible(true);
						frame.setVisible(false);
						
					}
					
				} catch (ClassNotFoundException | SQLException e1) {
					
					e1.printStackTrace();
					
				}
			
			}
			
		});
		
		btnNewButton.setBounds(186, 333, 205, 44);
		frame.getContentPane().add(btnNewButton);
		
		/** Fi codi botó "Consultar Client" */

		
		/** Inici codi botó "Afegir Client" */
		btnAfegirClient.setToolTipText("Crear un nou client");
		btnAfegirClient.setOpaque(false);
		btnAfegirClient.setForeground(Color.GRAY);
		btnAfegirClient.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnAfegirClient.setForeground(Color.WHITE);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnAfegirClient.setForeground(Color.GRAY);
				
			}
			
		});
		
		btnAfegirClient.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY));
		btnAfegirClient.setFocusPainted(false);
		btnAfegirClient.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnAfegirClient.setBackground(Color.WHITE);
		btnAfegirClient.setFont(new Font("HelveticaNeue", Font.BOLD, 12));
		btnAfegirClient.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					CrearClient frm = new CrearClient();
					frm.frame.setVisible(true);
					frame.setVisible(false);
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
					
				}
				
			}
			
		});
		
		btnAfegirClient.setBounds(186, 404, 205, 44);
		frame.getContentPane().add(btnAfegirClient);
		
		/** Fi codi botó "Afegir Client" */

		
		/** Inici codi botó "Afegir Producte/Servei" */
		btnAfegirProducteservei.setOpaque(false);
		btnAfegirProducteservei.setForeground(Color.GRAY);
		
		btnAfegirProducteservei.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnAfegirProducteservei.setForeground(Color.WHITE);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnAfegirProducteservei.setForeground(Color.GRAY);
				
			}
			
		});
		
		btnAfegirProducteservei.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY));
		btnAfegirProducteservei.setFocusPainted(false);
		btnAfegirProducteservei.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnAfegirProducteservei.setBackground(Color.WHITE);
		btnAfegirProducteservei.setFont(new Font("HelveticaNeue", Font.BOLD, 12));
		btnAfegirProducteservei.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					
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
		
		btnAfegirProducteservei.setBounds(447, 404, 205, 44);
		frame.getContentPane().add(btnAfegirProducteservei);
		
		/** Fi codi botó "Afegir Producte/Servei" */


		/** Inici codi Gràfic de Barres */
		
		try {
			
			if(sqlC.contarComandes()>0) {
				
				perF = sqlC.contarComandesFin() * 100 / sqlC.contarComandes();
				perEP = sqlC.contarComandesEnProces() * 100 / sqlC.contarComandes();
				perP = sqlC.contarComandesP() * 100 / sqlC.contarComandes();
				
			}

		} catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
			
		}
		
		if(perF>0) {
			
			perF = perF+60;
			
		}

		if(perEP>0) {
			
			perEP = perEP+60;
			
		}

		if(perP>0) {
			
			perP = perP+60;
			
		}

		/** Fi codi Gràfic de Barres */

		
		/** Inici codi botó "Eines d'Admin" */
		btnEinesDadmin.setToolTipText("Elimina el client seleccionat");
		btnEinesDadmin.setOpaque(false);
		btnEinesDadmin.setForeground(Color.GRAY);
		btnEinesDadmin.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnEinesDadmin.setForeground(Color.WHITE);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnEinesDadmin.setForeground(Color.GRAY);
				
			}
			
		});
		
		btnEinesDadmin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					EinesAdmin frm = new EinesAdmin();
					frm.frame.setVisible(true);
					frame.setVisible(false);
					
				} catch (Exception e2) {
					
					System.out.println("ERROR");
					
				}
				
			}
			
		});
		
		btnEinesDadmin.setFont(new Font("HelveticaNeue", Font.BOLD, 12));
		btnEinesDadmin.setFocusPainted(false);
		btnEinesDadmin.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY));
		btnEinesDadmin.setBackground(Color.WHITE);
		btnEinesDadmin.setBounds(447, 333, 205, 44);
		frame.getContentPane().add(btnEinesDadmin);

		/** Fi codi botó "Eines d'Admin" */
		/** Fi conjunt codi que composa els botons */
		
		
		/** Inici Scroll Panel que conté la taula de Clients */
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setBackground(Color.BLACK);
		scrollPane.setFont(new Font("HelveticaNeue", Font.PLAIN, 11));
		scrollPane.setBounds(186, 144, 466, 171);
		frame.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table_1);

		/** Fi Scroll Panel que conté la taula de Clients */


		/** Inici Scroll Panel que conté el tauler */

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(null);
		scrollPane_1.setFont(new Font("HelveticaNeue", Font.BOLD, 11));
		scrollPane_1.setBorder(null);
		scrollPane_1.setBackground(Color.BLACK);
		scrollPane_1.setBounds(32, 341, 137, 133);
		frame.getContentPane().add(scrollPane_1);
		scrollPane_1.setViewportView(table_2);
		
		/** Fi Scroll Panel que conté el tauler */
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.GREEN);
		panel_4.setBounds(29, 252, perF, 10);
		frame.getContentPane().add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.YELLOW);
		panel_5.setBounds(29, 262, perEP, 10);
		frame.getContentPane().add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(29, 272, perP, 10);
		frame.getContentPane().add(panel_6);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Principal.class.getResource("/VISTA/img/backg.png")));
		lblNewLabel_1.setBounds(0, 33, 670, 478);
		frame.getContentPane().add(lblNewLabel_1);
		
	}
}
