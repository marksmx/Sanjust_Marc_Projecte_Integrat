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
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;

import com.toedter.calendar.JCalendar;

import DADES.SQLComandes;
import DADES.SQLProductes;
import MODEL.ComandaCl;
import MODEL.ProducteCl;
import MODEL.ServeiCl;

import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class CrearComanda {
	
	
	/** IMPORTACIÓ I DECLARACIÓ DELS CONTROLADORS DE CONSULTES SQL QUE S'UTILITZEN EN AQUESTA PANTALLA */
	
	SQLProductes sqlP = new SQLProductes();
	SQLComandes sqlC = new SQLComandes();

	
	/** DECLARACIÓ GLOBAL D'ALGUNES VARIABLES */

	private String idClient;
	private String dLimit = "";
	private double iva;
	private double total;
	
	
	/** DECLARACIÓ DEL JFRAME, DE BOTONS I DE CAMPS DE TEXT */

	JFrame frame;
	JButton button = new JButton("VALIDAR COMANDA");
	JButton button_1 = new JButton("TORNAR ENRERE");
	JButton button2 = new JButton("FINALITZAR COMANDA");
	JButton btnAsignarDataLmit = new JButton("ASIGNAR DATA L\u00CDMIT");
	JButton btnSenseDataLmit = new JButton("SENSE DATA L\u00CDMIT");
	ArrayList<ProducteCl> miLista = sqlP.veureProducte();
	ArrayList<ServeiCl> miLista2 = sqlP.veureServei();
	ArrayList<ComandaCl> miLista3 = sqlC.consultarComandes();
	SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy"); 
	JTextPane textPane_6 = new JTextPane();
	JCalendar calendar_1;
	private JTextField txtProducte;
	private JTextField txtServei;
	private JTextField txtAfegir;
	private JTextField txtCrearComanda;
	
	/** FUNCIÓ PER A CRIDAR A LA FUNCIÓ QUE COMPOSA ELS ELEMENTS DE LA PANTALLA I A LES FUNCIONS DE CONSTRUCCIÓ DE LA TAULA */

	public CrearComanda(String idClient) throws SQLException {
		
		this.idClient = idClient;
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
		frame.setBounds(730, 300, 618, 527);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
        frame.setTitle("OnTime Agency App - v.2.0");

        
		/** Inici conjunt de codi dels botons de designació de data límit */
        
        btnAsignarDataLmit.setForeground(Color.BLACK);
        btnAsignarDataLmit.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnAsignarDataLmit.setBackground(Color.BLACK);
				btnAsignarDataLmit.setForeground(Color.WHITE);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnAsignarDataLmit.setBackground(Color.WHITE);
				btnAsignarDataLmit.setForeground(Color.BLACK);
				
			}
			
		});
        
		btnAsignarDataLmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dLimit = ""+
				calendar_1.getDate().toString().charAt(25) + calendar_1.getDate().toString().charAt(26) + calendar_1.getDate().toString().charAt(27) + calendar_1.getDate().toString().charAt(28) + "/" + 
				calendar_1.getDate().toString().charAt(4) + calendar_1.getDate().toString().charAt(5) + calendar_1.getDate().toString().charAt(6) + "/" +
				calendar_1.getDate().toString().charAt(8) + calendar_1.getDate().toString().charAt(9) + "";
				System.out.println(dLimit);
				
			}
		});
		
		
		btnSenseDataLmit.setForeground(Color.BLACK);
		btnSenseDataLmit.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnSenseDataLmit.setBackground(Color.BLACK);
				btnSenseDataLmit.setForeground(Color.WHITE);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnSenseDataLmit.setBackground(Color.WHITE);
				btnSenseDataLmit.setForeground(Color.BLACK);
				
			}
			
		});
		
		btnSenseDataLmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dLimit = "Sense data límit";
			}
		});
		btnSenseDataLmit.setForeground(Color.BLACK);
		btnSenseDataLmit.setFont(new Font("HelveticaNeue", Font.BOLD, 15));
		btnSenseDataLmit.setFocusPainted(false);
		btnSenseDataLmit.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY));
		btnSenseDataLmit.setBackground(Color.WHITE);
		btnSenseDataLmit.setBounds(304, 338, 279, 30);
		frame.getContentPane().add(btnSenseDataLmit);
		btnAsignarDataLmit.setForeground(Color.BLACK);
		btnAsignarDataLmit.setFont(new Font("HelveticaNeue", Font.BOLD, 15));
		btnAsignarDataLmit.setFocusPainted(false);
		btnAsignarDataLmit.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY));
		btnAsignarDataLmit.setBackground(Color.WHITE);
		btnAsignarDataLmit.setBounds(304, 308, 279, 30);
		frame.getContentPane().add(btnAsignarDataLmit);
		
		/** Fi conjunt de codi dels botons de designació de data límit */

		
		/** Inici Codi JCalendar */
		
		calendar_1 = new JCalendar();
		calendar_1.getDayChooser().setDecorationBordersVisible(true);
		calendar_1.getDayChooser().setDecorationBackgroundColor(Color.BLACK);
		calendar_1.getDayChooser().setBackground(Color.BLACK);
		calendar_1.getDayChooser().getDayPanel().setBackground(Color.GRAY);
		calendar_1.getDayChooser().setForeground(Color.BLACK);
		calendar_1.getDayChooser().setWeekdayForeground(Color.BLACK);
		calendar_1.setWeekdayForeground(Color.BLACK);
		calendar_1.setSundayForeground(new Color(164, 0, 0));
		calendar_1.setDecorationBackgroundColor(Color.WHITE);
		calendar_1.setBounds(304, 143, 279, 161);
		calendar_1.setWeekOfYearVisible(false);
		frame.getContentPane().add(calendar_1);
		
		/** Fi Codi JCalendar */
		
		
		/** Inici del conjunt d'elements que composen la capçalera */

		txtAfegir = new JTextField();
		txtAfegir.setOpaque(false);
		txtAfegir.setText("AFEGIR");
		txtAfegir.setHorizontalAlignment(SwingConstants.CENTER);
		txtAfegir.setForeground(Color.WHITE);
		txtAfegir.setFont(new Font("HelveticaNeue", Font.PLAIN, 24));
		txtAfegir.setFocusable(false);
		txtAfegir.setFocusTraversalKeysEnabled(false);
		txtAfegir.setFocusCycleRoot(false);
		txtAfegir.setEditable(false);
		txtAfegir.setBorder(null);
		txtAfegir.setBackground(Color.BLACK);
		txtAfegir.setBounds(20, 248, 99, 36);
		frame.getContentPane().add(txtAfegir);
		
		JTextField textPane_1 = new JTextField();
		textPane_1.setOpaque(false);
		textPane_1.setBorder(null);
		textPane_1.setHorizontalAlignment(SwingConstants.CENTER);
		textPane_1.setText("AFEGIR\r\n");
		textPane_1.setForeground(SystemColor.text);
		textPane_1.setFont(new Font("HelveticaNeue", Font.PLAIN, 25));
		textPane_1.setFocusable(false);
		textPane_1.setFocusTraversalKeysEnabled(false);
		textPane_1.setFocusCycleRoot(false);
		textPane_1.setEditable(false);
		textPane_1.setBackground(new Color(0, 0, 0));
		textPane_1.setBounds(20, 154, 105, 46);
		frame.getContentPane().add(textPane_1);
		
		txtProducte = new JTextField();
		txtProducte.setOpaque(false);
		txtProducte.setBorder(null);
		txtProducte.setText("PRODUCTE\r\n");
		txtProducte.setHorizontalAlignment(SwingConstants.CENTER);
		txtProducte.setForeground(Color.WHITE);
		txtProducte.setFont(new Font("HelveticaNeue", Font.PLAIN, 17));
		txtProducte.setFocusable(false);
		txtProducte.setFocusTraversalKeysEnabled(false);
		txtProducte.setFocusCycleRoot(false);
		txtProducte.setEditable(false);
		txtProducte.setBackground(Color.BLACK);
		txtProducte.setBounds(20, 189, 99, 36);
		frame.getContentPane().add(txtProducte);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 612, 82);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTextField txtLogIn = new JTextField();
		txtLogIn.setBounds(233, 11, 170, 29);
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
		lblNewLabel.setIcon(new ImageIcon(CrearComanda.class.getResource("/VISTA/img/logo.png")));
		lblNewLabel.setBounds(0, 0, 102, 82);
		panel.add(lblNewLabel);
		
		txtCrearComanda = new JTextField();
		txtCrearComanda.setBounds(149, 32, 383, 50);
		panel.add(txtCrearComanda);
		txtCrearComanda.setText("CREAR COMANDA");
		txtCrearComanda.setSelectionColor(Color.GRAY);
		txtCrearComanda.setForeground(Color.BLACK);
		txtCrearComanda.setFont(new Font("HelveticaNeue", Font.PLAIN, 40));
		txtCrearComanda.setFocusable(false);
		txtCrearComanda.setFocusTraversalKeysEnabled(false);
		txtCrearComanda.setEditable(false);
		txtCrearComanda.setColumns(10);
		txtCrearComanda.setBorder(null);
		txtCrearComanda.setBackground(Color.WHITE);
		txtCrearComanda.setAutoscrolls(false);
		
		JTextField textPane_2 = new JTextField();
		textPane_2.setHorizontalAlignment(SwingConstants.CENTER);
		textPane_2.setEditable(false);
		textPane_2.setForeground(Color.BLACK);
		textPane_2.setFont(new Font("Dialog", Font.PLAIN, 20));
		textPane_2.setFocusTraversalKeysEnabled(false);
		textPane_2.setFocusCycleRoot(false);
		textPane_2.setBackground(Color.WHITE);
		textPane_2.setBounds(435, 402, 80, 30);
		frame.getContentPane().add(textPane_2);
		
		JTextPane txtpnCostTotal = new JTextPane();
		txtpnCostTotal.setText("COST TOTAL");
		txtpnCostTotal.setForeground(Color.WHITE);
		txtpnCostTotal.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		txtpnCostTotal.setFocusable(false);
		txtpnCostTotal.setFocusTraversalKeysEnabled(false);
		txtpnCostTotal.setFocusCycleRoot(false);
		txtpnCostTotal.setEditable(false);
		txtpnCostTotal.setBackground(Color.BLACK);
		txtpnCostTotal.setBounds(294, 402, 137, 30);
		frame.getContentPane().add(txtpnCostTotal);

		
		/** Inici declaració dels "ComboBox" */
		
		JComboBox<String> comboBox = new JComboBox<String>();
		JComboBox<String> comboBox_1 = new JComboBox<String>();
	
		
		comboBox.setFont(new Font("HelveticaNeue", Font.PLAIN, 11));
		comboBox.setBounds(135, 176, 128, 36);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("");
		
		for (int i = 0; i < miLista.size(); i++) {
			
			comboBox.addItem(miLista.get(i).getElement()+", "+miLista.get(i).getUnitats());
			
		}
		
		comboBox_1.setFont(new Font("HelveticaNeue", Font.PLAIN, 11));
		comboBox_1.setBounds(135, 268, 128, 36);
		frame.getContentPane().add(comboBox_1);
		comboBox_1.addItem("");

		for (int i = 0; i < miLista2.size(); i++) {
			
			comboBox_1.addItem(miLista2.get(i).getElement()+", "+miLista2.get(i).getUnitats()+" per "+miLista2.get(i).getFrequencia());
			
		}

		/** Fi declaració dels "ComboBox" */


		/** Inici botó "Tornar Enrere" */
		
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
				
				try {
					
					/** Depenent de si hem començat la comanda o no, tornarem al inici o es refrescarà la pestanya */
					
					Client frm = new Client(idClient);
					frm.frame.setVisible(true);
					frame.setVisible(false);
						
				} catch (SQLException e1) {
					
					e1.printStackTrace();
					
				} catch (ClassNotFoundException e1) {
					
					e1.printStackTrace();
					
				}
				
			}
			
		});
		
		button_1.setBounds(435, 436, 148, 36);
		frame.getContentPane().add(button_1);
		
		/** Fi botó "Tornar Enrere" */

		
		/** Inici botó "Validar Comanda" */
		button.setToolTipText("Comprova la validesa de la comanda i calcula el preu");

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
				
				/** Al clicar el botó, es comprobaràn els camps, i si tot està correcte es podrà finalitzar la creació de la comanda */
				
				if(comboBox.getSelectedItem().equals("") && !comboBox_1.getSelectedItem().equals("") || !comboBox.getSelectedItem().equals("") && comboBox_1.getSelectedItem().equals("")) {
					
					button.setVisible(false);
					button2.setVisible(true);
					comboBox.enable(false);
					comboBox_1.enable(false);
					
				}
				
				if(!comboBox.getSelectedItem().equals("") && !comboBox_1.getSelectedItem().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Tria només un servei o un producte","ERROR",JOptionPane.ERROR_MESSAGE);
					
				}
				
				if(comboBox.getSelectedItem().equals("") && comboBox_1.getSelectedItem().equals("")) {
					
					JOptionPane.showMessageDialog(null, "No has triat cap servei ni producte","ERROR",JOptionPane.ERROR_MESSAGE);
					
				}
				
				if(!comboBox.getSelectedItem().equals("") && comboBox_1.getSelectedItem().equals("")) {
					
					textPane_2.setText(miLista.get(comboBox.getSelectedIndex()-1).getTotal());
					
				}
				
				if(comboBox.getSelectedItem().equals("") && !comboBox_1.getSelectedItem().equals("")) {
					
					textPane_2.setText(miLista2.get(comboBox_1.getSelectedIndex()-1).getTotal());
					
				}
				
			}
			
		});
		
		button.setBounds(283, 436, 148, 36);
		frame.getContentPane().add(button);
		
		/** Fi botó "Validar Comanda" */


		/** Inici botó "Finalitzar Comanda" */
		button2.setToolTipText("Afegeix la comanda a la llista");
		
		button2.setVisible(false);
		button2.setForeground(Color.BLACK);
		button2.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				button2.setBackground(Color.BLACK);
				button2.setForeground(Color.WHITE);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				button2.setBackground(Color.WHITE);
				button2.setForeground(Color.BLACK);
				
			}
			
		});
		
		button2.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY));
		button2.setFocusPainted(false);
		button2.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		button2.setBackground(Color.WHITE);
		button2.setFont(new Font("HelveticaNeue", Font.BOLD, 12));
		
		button2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					/** Al clicar el botó, es crearà una comanda amb la informació introduïda */
					
					if(comboBox.getSelectedIndex()>=1 && comboBox_1.getSelectedIndex()==0) {
						
						iva = Integer.parseInt(miLista.get(comboBox.getSelectedIndex()-1).getBase())*0.21;
						total = Integer.parseInt(miLista.get(comboBox.getSelectedIndex()-1).getBase())+(Integer.parseInt(miLista.get(comboBox.getSelectedIndex()-1).getBase())*0.21);
						String rec = "";
						
						try {
							rec = Integer.toString(Integer.parseInt(miLista3.get(sqlC.contarComandes()-1).getNumComanda())+1);
						} catch (Exception e2) {
							rec = "1";
						}
						
						String id =  miLista.get(comboBox.getSelectedIndex()-1).getIdProducte();
						LocalDate dataS = java.time.LocalDate.now();  
						String totalS = Double.toString(total);
						
						sqlC.crearComanda("p", rec, id, dataS.toString(), "", totalS, idClient, dLimit,textPane_6.getText());
					} 
					
					if(comboBox_1.getSelectedIndex()>=1 && comboBox.getSelectedIndex()==0) {
						
						iva = Integer.parseInt(miLista2.get(comboBox_1.getSelectedIndex()-1).getBase())*0.21;
						total = Integer.parseInt(miLista2.get(comboBox_1.getSelectedIndex()-1).getBase())+(Integer.parseInt(miLista2.get(comboBox_1.getSelectedIndex()-1).getBase())*0.21);
						String rec = "";
						try {
							rec = Integer.toString(Integer.parseInt(miLista3.get(sqlC.contarComandes()-1).getNumComanda())+1);
						} catch (Exception e2) {
							rec = "1";
						}
						String id =  miLista2.get(comboBox_1.getSelectedIndex()-1).getIdProducte();
						LocalDate dataS = java.time.LocalDate.now(); 
						String baseS = miLista2.get(comboBox_1.getSelectedIndex()-1).getBase();
						String ivaS = Double.toString(iva);
						String totalS = Double.toString(total);
						String dLimit = "";
						/*
						if(comboBox_2.getSelectedItem().toString().equals("") || comboBox_3.getSelectedItem().toString().equals("") || comboBox_3.getSelectedItem().toString().equals("")) {
							
							dLimit = "Sense data límit";
							
						} else {
							
							dLimit =  comboBox_2.getSelectedItem().toString() + "-" + comboBox_3.getSelectedItem().toString() + "-" + comboBox_4.getSelectedItem().toString();
							 
						}
						*/
						sqlC.crearComanda("p", rec, id, dataS.toString(), "", totalS, idClient, dLimit, textPane_6.getText());
						
					} 
					
					JOptionPane.showMessageDialog(null, "S'ha afegit la comanda","",JOptionPane.INFORMATION_MESSAGE);
					Client frm = new Client(idClient);
					frm.frame.setVisible(true);
					frame.setVisible(false);
					
				} catch (ClassNotFoundException | SQLException e1) {
					
					e1.printStackTrace();
					
				}
				
			}
			
		});
		
		button2.setBounds(262, 436, 169, 36);
		frame.getContentPane().add(button2);
		
		/** Fi botó "Finalitzar Comanda" */

		
		JTextField txtpnDataLmit = new JTextField();
		txtpnDataLmit.setBorder(null);
		txtpnDataLmit.setHorizontalAlignment(SwingConstants.CENTER);
		txtpnDataLmit.setText("DATA L\u00CDMIT");
		txtpnDataLmit.setForeground(Color.WHITE);
		txtpnDataLmit.setFont(new Font("HelveticaNeue", Font.PLAIN, 22));
		txtpnDataLmit.setFocusable(false);
		txtpnDataLmit.setFocusTraversalKeysEnabled(false);
		txtpnDataLmit.setFocusCycleRoot(false);
		txtpnDataLmit.setEditable(false);
		txtpnDataLmit.setBackground(Color.BLACK);
		txtpnDataLmit.setBounds(304, 103, 279, 36);
		frame.getContentPane().add(txtpnDataLmit);
		
		JTextPane txtpnDescripciComanda = new JTextPane();
		txtpnDescripciComanda.setOpaque(false);
		txtpnDescripciComanda.setText("DESCRIPCI\u00D3 COMANDA");
		txtpnDescripciComanda.setForeground(Color.WHITE);
		txtpnDescripciComanda.setFont(new Font("HelveticaNeue", Font.PLAIN, 19));
		txtpnDescripciComanda.setFocusable(false);
		txtpnDescripciComanda.setFocusTraversalKeysEnabled(false);
		txtpnDescripciComanda.setFocusCycleRoot(false);
		txtpnDescripciComanda.setEditable(false);
		txtpnDescripciComanda.setBackground(Color.BLACK);
		txtpnDescripciComanda.setBounds(20, 368, 227, 36);
		frame.getContentPane().add(txtpnDescripciComanda);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 402, 227, 70);
		frame.getContentPane().add(scrollPane);
		scrollPane.setViewportView(textPane_6);
		
		textPane_6.setText("");
		textPane_6.setForeground(Color.BLACK);
		textPane_6.setFont(new Font("Dialog", Font.PLAIN, 13));
		textPane_6.setFocusTraversalKeysEnabled(false);
		textPane_6.setFocusCycleRoot(false);
		textPane_6.setEditable(true);
		textPane_6.setBackground(Color.WHITE);
		
		txtServei = new JTextField();
		txtServei.setOpaque(false);
		txtServei.setText("SERVEI");
		txtServei.setHorizontalAlignment(SwingConstants.CENTER);
		txtServei.setForeground(Color.WHITE);
		txtServei.setFont(new Font("HelveticaNeue", Font.PLAIN, 23));
		txtServei.setFocusable(false);
		txtServei.setFocusTraversalKeysEnabled(false);
		txtServei.setFocusCycleRoot(false);
		txtServei.setEditable(false);
		txtServei.setBorder(null);
		txtServei.setBackground(Color.BLACK);
		txtServei.setBounds(20, 284, 93, 36);
		frame.getContentPane().add(txtServei);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("\u20AC");
		textPane.setForeground(Color.WHITE);
		textPane.setFont(new Font("Georgia", Font.PLAIN, 20));
		textPane.setFocusable(false);
		textPane.setFocusTraversalKeysEnabled(false);
		textPane.setFocusCycleRoot(false);
		textPane.setEditable(false);
		textPane.setBackground(Color.BLACK);
		textPane.setBounds(520, 402, 24, 30);
		frame.getContentPane().add(textPane);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 10, 612, 488);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(CrearComanda.class.getResource("/VISTA/img/backg.png")));

		for(int x=0; x<4; x++) {
			
			String dataLlista = "";
			int dataLlistInt = 0;
			
			for(int i=0; i<4; i++) {
				
				LocalDate data = java.time.LocalDate.now();
				dataLlista += data.toString().charAt(i);
				
			}
			
			dataLlistInt = Integer.parseInt(dataLlista)+x;
		//	comboBox_4.addItem(Integer.toString(dataLlistInt));
			
		}
		
	}
}
