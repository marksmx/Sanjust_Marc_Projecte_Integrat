package VISTA;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Transparency;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.awt.image.WritableRenderedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
/*
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
*/


import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;

import DADES.SQLClients;
import DADES.SQLComandes;
import DADES.SQLFactura;
import DADES.SQLProductes;
import MODEL.ComandaCl;
import MODEL.ProducteCl;

public class GenerarFactura {

	
	/** IMPORTACIÓ I DECLARACIÓ DELS CONTROLADORS DE CONSULTES SQL QUE S'UTILITZEN EN AQUESTA PANTALLA */

	SQLFactura sqlF = new SQLFactura();
	SQLComandes sqlC = new SQLComandes();
	SQLProductes sqlP = new SQLProductes();
	SQLClients sqlCl = new SQLClients();
	
	
	/** DECLARACIÓ DEL JFRAME, DE BOTONS, DE CAMPS DE TEXT I ALTRES */

	JFrame frame;
	private JTextField txtMesAFacturar;
	private JTextField txtNmeroDeComanda;
	private JTextField textField_2;
	private JTextField textField_3;
	JComboBox<String> comboBox = new JComboBox<String>();
	JButton btnNewButton_1 = new JButton("GENERAR FACTURA");
	JButton btnNewButton_2 = new JButton("TORNAR A INICI");

	
	/** DECLARACIÓ GLOBAL D'ALGUNES VARIABLES */

	private String idEmpresa;
	private JTextField txtGenerarFactura;
	private JTextField txtnotaNoEs;
	private String totalLinia = "";
	private double finalLinia = 0.0;
	private String anyCom;
	private String anyAct;
	
	/** FUNCIÓ PER A CRIDAR A LA FUNCIÓ QUE COMPOSA ELS ELEMENTS DE LA PANTALLA I A LES FUNCIONS DE CONSTRUCCIÓ DE LA TAULA 
	 * @throws IOException 
	 * @throws DocumentException */

	public GenerarFactura(String idEmpresa) throws IOException, DocumentException {
		
		this.idEmpresa = idEmpresa;
		initialize();
		
	}
	
	/** FUNCIÓ ON ES CONSTRUEIXEN TOTS ELS ELEMENTS DE LA PANTALLA I S'APLIQUEN LES CONSULTES SQL, ENTRE ALTRES FUNCIONS */

	private void initialize() throws DocumentException, MalformedURLException, IOException {
		
		
		/** Aquí es declaren les característiques que tindrà la base de la pantalla (resolució, color, mida fixe) */

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setResizable(false);
		frame.getContentPane().setFocusable(false);
		frame.getContentPane().setFocusTraversalKeysEnabled(false);
		frame.setBounds(730, 300, 517, 435);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
        frame.setTitle("OnTime Agency App - v.2.0");
		
		/** Inici del conjunt d'elements que composen la capçalera */
		
		txtnotaNoEs = new JTextField();
		txtnotaNoEs.setText("*nota: assegura't de calcular el preu final abans de generar la factura\r\n");
		txtnotaNoEs.setSelectionColor(Color.GRAY);
		txtnotaNoEs.setOpaque(false);
		txtnotaNoEs.setHorizontalAlignment(SwingConstants.CENTER);
		txtnotaNoEs.setForeground(Color.WHITE);
		txtnotaNoEs.setFont(new Font("HelveticaNeue", Font.PLAIN, 10));
		txtnotaNoEs.setFocusable(false);
		txtnotaNoEs.setFocusTraversalKeysEnabled(false);
		txtnotaNoEs.setEditable(false);
		txtnotaNoEs.setColumns(10);
		txtnotaNoEs.setBorder(null);
		txtnotaNoEs.setBackground(Color.BLACK);
		txtnotaNoEs.setAutoscrolls(false);
		txtnotaNoEs.setBounds(0, 380, 511, 26);
		frame.getContentPane().add(txtnotaNoEs);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		textField_3.setBounds(160, 132, 190, 33);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 511, 82);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTextField txtLogIn = new JTextField();
		txtLogIn.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogIn.setBounds(165, 11, 241, 30);
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
		lblNewLabel.setIcon(new ImageIcon(Client.class.getResource("/VISTA/img/logo.png")));
		lblNewLabel.setBounds(0, 0, 102, 82);
		panel.add(lblNewLabel);
		
		txtGenerarFactura = new JTextField();
		txtGenerarFactura.setText("GENERAR FACTURA");
		txtGenerarFactura.setSelectionColor(Color.GRAY);
		txtGenerarFactura.setHorizontalAlignment(SwingConstants.CENTER);
		txtGenerarFactura.setForeground(Color.BLACK);
		txtGenerarFactura.setFont(new Font("HelveticaNeue", Font.PLAIN, 35));
		txtGenerarFactura.setFocusable(false);
		txtGenerarFactura.setFocusTraversalKeysEnabled(false);
		txtGenerarFactura.setEditable(false);
		txtGenerarFactura.setColumns(10);
		txtGenerarFactura.setBorder(null);
		txtGenerarFactura.setBackground(Color.WHITE);
		txtGenerarFactura.setAutoscrolls(false);
		txtGenerarFactura.setBounds(93, 40, 375, 31);
		panel.add(txtGenerarFactura);
		
		/** Fi del conjunt d'elements que composen la capçalera */

		
		txtMesAFacturar = new JTextField();
		txtMesAFacturar.setOpaque(false);
		txtMesAFacturar.setHorizontalAlignment(SwingConstants.CENTER);
		txtMesAFacturar.setText("MES A FACTURAR");
		txtMesAFacturar.setSelectionColor(Color.GRAY);
		txtMesAFacturar.setForeground(Color.WHITE);
		txtMesAFacturar.setFont(new Font("HelveticaNeue", Font.PLAIN, 20));
		txtMesAFacturar.setFocusable(false);
		txtMesAFacturar.setFocusTraversalKeysEnabled(false);
		txtMesAFacturar.setEditable(false);
		txtMesAFacturar.setColumns(10);
		txtMesAFacturar.setBorder(null);
		txtMesAFacturar.setBackground(Color.BLACK);
		txtMesAFacturar.setAutoscrolls(false);
		txtMesAFacturar.setBounds(159, 192, 190, 33);
		frame.getContentPane().add(txtMesAFacturar);
		
		
		/** Inici codi Combo Box */
		
		comboBox.setBounds(159, 224, 190, 27);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("");
		comboBox.addItem("Gener");
		comboBox.addItem("Febrer");
		comboBox.addItem("Març");
		comboBox.addItem("Abril");
		comboBox.addItem("Maig");
		comboBox.addItem("Juny");
		comboBox.addItem("Juliol");
		comboBox.addItem("Agost");
		comboBox.addItem("Setembre");
		comboBox.addItem("Octubre");
		comboBox.addItem("Novembre");
		comboBox.addItem("Desembre");
		
		/** Fi codi Combo Box */

		/** Inici conjunt codi botons */
		/** Inici botó "Generar Factura" */
		
		btnNewButton_1.setVisible(true);
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnNewButton_1.setBackground(Color.BLACK);
				btnNewButton_1.setForeground(Color.WHITE);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnNewButton_1.setBackground(Color.WHITE);
				btnNewButton_1.setForeground(Color.BLACK);
				
			}
			
		});
		
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY));
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("HelveticaNeue", Font.BOLD, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			
public void actionPerformed(java.awt.event.ActionEvent e) {
				
				boolean totsIguals = false;
				int contador = 0;
				int unitats = 1;
				double total = 0;
				String ruta = "";
				String preuNum = "";
				double preuFinal = 0.0;
				int tope = 0;
				LocalDate dataS = java.time.LocalDate.now();  

				
				if(comboBox.getSelectedIndex() == 0) {
					
					JOptionPane.showMessageDialog(null, "No has triat el mes a facturar!","ERROR",JOptionPane.ERROR_MESSAGE);
					
				} else {
					
					if(textField_3.getText().equals("")) {
						
						JOptionPane.showMessageDialog(null, "Has d'introduïr un ID de comanda!","ERROR",JOptionPane.ERROR_MESSAGE);
						
					} else {
						
						JFileChooser nouPdf = new JFileChooser();
						int option = nouPdf.showSaveDialog(null);
						
						if(option == JFileChooser.APPROVE_OPTION) {
							
							File f = nouPdf.getSelectedFile();
							ruta = f.toString();
							
						}
						
						String contingut = "";
						
						try {
							contingut += dataS + "\n";
							contingut += "" + "\n";
							contingut += " Client: " + sqlCl.consultarNomClient(idEmpresa) + "\n";
							contingut += "" + "\n";
							
						} catch (SQLException e1) {
							
							e1.printStackTrace();
							
						}
						
						contingut += "\n";
						contingut += "\n";
						contingut += "" + "\n";
						
							try {
								
								ArrayList<ComandaCl> miLista = sqlC.consultarComandesClient(idEmpresa);
								
								for(int i=0; sqlC.contarComandesClient(idEmpresa)>=i; i++) {
									
									String mesComanda = "";
									preuNum = "";

									for(int y = 0; y<miLista.get(i).getTotal().length(); y++) {
										
										if(miLista.get(i).getTotal().charAt(y) != '€'){
											
											preuNum += miLista.get(i).getTotal().charAt(y);
											
										}
										
										if(miLista.get(i).getTotal().charAt(y) == '€') {
											
											preuFinal += Double.parseDouble(preuNum);
											sqlF.crearFactura(textField_3.getText(), dataS.toString(), sqlCl.consultarEmpresaClient(idEmpresa), sqlCl.consultarNomClient(idEmpresa), Double.toString(preuFinal)+"€");
											
										}
									}
									
									
									for(int x=5; x<7; x++) {
										
										mesComanda += miLista.get(i).getData().charAt(x);
									
									}
									
										if(Integer.parseInt(mesComanda)==comboBox.getSelectedIndex()) {
											
											String totalLinia = "";
											double finalLinia = 0.0;

											for(int z = 0; z<miLista.get(i).getTotal().length(); z++) {
												
												if(miLista.get(i).getTotal().charAt(z) != '€'){
													
													totalLinia += miLista.get(i).getTotal().charAt(z);
													
												}
												
												if(miLista.get(i).getTotal().charAt(z) == '€') {
													
													finalLinia += Double.parseDouble(totalLinia);
													
												}
											}
											
											if(contador>0) {
												
												if(tope<=sqlC.contarComandesPerProd(miLista.get(i).getIdProducte(), idEmpresa) && !sqlP.consultarProducte(miLista.get(i).getIdProducte()).equals(sqlP.consultarProducte(miLista.get(i-1).getIdProducte()))) {
													
													sqlF.crearLiniaFactura(textField_3.getText(), sqlP.consultarProducte(miLista.get(i).getIdProducte()), Integer.toString(sqlC.contarComandesPerProd(miLista.get(i).getIdProducte(), idEmpresa)) , miLista.get(i).getTotal(), Double.toString(finalLinia*sqlC.contarComandesPerProd(miLista.get(i).getIdProducte(), idEmpresa))+"€");
													contingut += " "+textField_3.getText()+ " _________ " + sqlP.consultarProducte(miLista.get(i).getIdProducte()) + " ________ " + Integer.toString(sqlC.contarComandesPerProd(miLista.get(i).getIdProducte(), idEmpresa)) + " ________ "+ miLista.get(i).getTotal() + " _________ " + Double.toString(finalLinia*sqlC.contarComandesPerProd(miLista.get(i).getIdProducte(), idEmpresa))+"€" + " " +"\n";
													tope++;
													
												}
												
											} else {
												
											
											}
											
											++contador;
											
											if(sqlC.contarComandesClient(idEmpresa)-1 == i) {
												
												for(int f = 0; contador > f; f++) {
													
													if(sqlP.consultarProducte(miLista.get(f).getIdProducte()).equals(sqlP.consultarProducte(miLista.get(contador-1).getIdProducte()))) {
														
														totsIguals = true;
														
													} else {
														
														totsIguals = false;
														f = contador;
														
													}
													
												}

												if(totsIguals == true) {
													
													sqlF.crearLiniaFactura(textField_3.getText(), sqlP.consultarProducte(miLista.get(i).getIdProducte()), Integer.toString(sqlC.contarComandesPerProd(miLista.get(i).getIdProducte(), idEmpresa)) , miLista.get(i).getTotal(), Double.toString(finalLinia*sqlC.contarComandesPerProd(miLista.get(i).getIdProducte(), idEmpresa))+"€");
													contingut += " "+textField_3.getText()+ " _________ " + sqlP.consultarProducte(miLista.get(i).getIdProducte()) + " ________ " + Integer.toString(sqlC.contarComandesPerProd(miLista.get(i).getIdProducte(), idEmpresa)) + " ________ "+ miLista.get(i).getTotal() + " _________ " + Double.toString(finalLinia*sqlC.contarComandesPerProd(miLista.get(i).getIdProducte(), idEmpresa))+"€" + " " +"\n";
													
												}
												
												
												contingut += ""+"\n";
												preuFinal = Math.round(preuFinal * 100);
												preuFinal = preuFinal/100;
												contingut += "Total: "+ preuFinal +" €";
												
											
												
											}
											
											FileOutputStream pdf = new FileOutputStream(ruta+".pdf");
											Document doc = new Document();
											PdfWriter.getInstance(doc, pdf);
											doc.open();
											String t = "C:\\Users\\Marc Sanjust\\eclipse-workspace\\ProjecteFiGrau\\src\\VISTA\\img\\pdfbase.png";
											Image img = Image.getInstance(t);
											img.setAbsolutePosition(0f, 0f);
	  										Paragraph test = new Paragraph(contingut);
											test.setAlignment(Element.ALIGN_CENTER);
										    doc.add(img);
											doc.add(test);
											doc.close();
											
										}
										
									}
								
								} catch (Exception e2) {
								
									System.out.println("ERROR");
								
								}
							}
					
						}
				
				if(contador>0) {
					
					JOptionPane.showMessageDialog(null, "S'ha creat la factura Correctament","",JOptionPane.DEFAULT_OPTION);
					
				} else {
					
					JOptionPane.showMessageDialog(null, "Aquest client no ha fet cap comanda durant el mes seleccionat.","AVÍS",JOptionPane.DEFAULT_OPTION);
					
				}
				
			}
			
		});
		
		btnNewButton_1.setBounds(160, 293, 190, 38);
		frame.getContentPane().add(btnNewButton_1);
		
		/** Fi botó "Generar Factura" */

		
		/** Inici botó "Tornar a Inici" */

		btnNewButton_2.setVisible(true);
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnNewButton_2.setBackground(Color.BLACK);
				btnNewButton_2.setForeground(Color.WHITE);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnNewButton_2.setBackground(Color.WHITE);
				btnNewButton_2.setForeground(Color.BLACK);
				
			}
			
		});
		
		btnNewButton_2.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY));
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setFont(new Font("HelveticaNeue", Font.BOLD, 17));
		btnNewButton_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Client frm = new Client(idEmpresa);
					frm.frame.setVisible(true);
					frame.setVisible(false);
					
				} catch (ClassNotFoundException e1) {
					
					e1.printStackTrace();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
					
				}
				
			}
			
		});
		
		btnNewButton_2.setBounds(160, 331, 190, 38);
		frame.getContentPane().add(btnNewButton_2);
		
		/** Fi botó "Tornar a Inici" */
		/** Fi conjunt codi botons */
		
		txtNmeroDeComanda = new JTextField();
		txtNmeroDeComanda.setOpaque(false);
		txtNmeroDeComanda.setHorizontalAlignment(SwingConstants.CENTER);
		txtNmeroDeComanda.setText("N\u00DAMERO DE COMANDA");
		txtNmeroDeComanda.setSelectionColor(Color.GRAY);
		txtNmeroDeComanda.setForeground(Color.WHITE);
		txtNmeroDeComanda.setFont(new Font("HelveticaNeue", Font.PLAIN, 16));
		txtNmeroDeComanda.setFocusable(false);
		txtNmeroDeComanda.setFocusTraversalKeysEnabled(false);
		txtNmeroDeComanda.setEditable(false);
		txtNmeroDeComanda.setColumns(10);
		txtNmeroDeComanda.setBorder(null);
		txtNmeroDeComanda.setBackground(Color.BLACK);
		txtNmeroDeComanda.setAutoscrolls(false);
		txtNmeroDeComanda.setBounds(159, 94, 190, 33);
		frame.getContentPane().add(txtNmeroDeComanda);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(GenerarFactura.class.getResource("/VISTA/img/backg.png")));
		lblNewLabel_1.setBounds(0, -76, 511, 471);
		frame.getContentPane().add(lblNewLabel_1);
		
	}
}