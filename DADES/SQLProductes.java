package DADES;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

import MODEL.*;
import VISTA.CrearUsuari;
import VISTA.LogIn;
import VISTA.Principal;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class SQLProductes {
	
	/** DECLARACIÓ INICIAL DE VARIABLES I ALTRES */
	
	Connection c;
	JComponent frame;
	Statement sentencia;

	
	/** FUNCIO CONNEXIÓ A LA BASE DE DADES */
	
	public Connection conectar() {
		
		try {
			
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:onTimeDB.db");
			//c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Marc Sanjust\\eclipse-workspace\\ProjecteFiGrau\\src\\onTimeDB.db");
			System.out.println("Exito al conectar con base de datos");

		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "Error al conectar a la base de dades","ERROR",JOptionPane.ERROR_MESSAGE);
			
		}

		return c;
		
	}
	
	
	/** FUNCIO PER A CREAR UN PRODUCTE NOU */

	public void crearProducte(String element, String unitats, String base, String iva, String total, String idProducte) {
		
		conectar();
		String consultaSql = "INSERT INTO producte (element, unitats, base, iva, total, idProducte)"+
		"VALUES ("
		+ "'"+element+"'"
		+","
		+ "'"+unitats+"'"
		+","
		+ "'"+base+"'"
		+","
		+ "'"+iva+"'"
		+","
		+ "'"+total+"'"
		+","
		+ "'"+idProducte+"')"
		+ ";";
		
		try {
			
			sentencia = c.createStatement();
			ResultSet rs = sentencia.executeQuery(consultaSql);
			rs.close();
			sentencia.close();
			c.close();
			
		} catch (Exception e) {
			
			System.out.println("ERROR");
			
		}
		
	}
	
	
	/** FUNCIO PER A CREAR UN SERVEI NOU */

	public void crearServei(String element, String frequencia, String unitats, String base, String iva, String total, String idProducte) {
		
		conectar();
		String consultaSql = "INSERT INTO servei (element, frequencia, unitats, base, iva, total, idProducte)"+
		"VALUES ("
		+ "'"+element+"'"
		+","
		+ "'"+frequencia+"'"
		+","
		+ "'"+unitats+"'"
		+","
		+ "'"+base+"'"
		+","
		+ "'"+iva+"'"
		+","
		+ "'"+total+"'"
		+","
		+ "'"+idProducte+"')"
		+ ";";
		
		try {
			
			sentencia = c.createStatement();
			ResultSet rs = sentencia.executeQuery(consultaSql);
			rs.close();
			sentencia.close();
			c.close();
			
		} catch (Exception e) {
			
			System.out.println("ERROR");
			
		}
		
	}
	
	
	/** FUNCIO PER A CONSULTAR ELS SERVEIS EXISTENTS */

	public ArrayList<ServeiCl> veureServei() throws SQLException {
		
		conectar();
		sentencia = c.createStatement();
		ArrayList<ServeiCl> miLista = new ArrayList<ServeiCl>();
		ServeiCl ser = null;
		String consultaSql = "SELECT * FROM servei;";
		
		try {
			
			ResultSet rs = sentencia.executeQuery(consultaSql);
			
			while (rs.next()) {
				
				ser = new ServeiCl(rs.getString("element"), rs.getString("frequencia"), rs.getString("unitats"), rs.getString("base"), rs.getString("iva"), rs.getString("total"), rs.getString("idProducte"));
				miLista.add(ser);
				
			}
			
			rs.close();
			sentencia.close();
			c.close();
			
		} catch (Exception e) {
			
			System.out.println("ERROR");
			
		}
		
		return miLista;
	}
	
	
	/** FUNCIO PER A CONSULTAR ELS PRODUCTES EXISTENTS */

	public ArrayList<ProducteCl> veureProducte() throws SQLException {
		
		conectar();
		sentencia = c.createStatement();
		ArrayList<ProducteCl> miLista = new ArrayList<ProducteCl>();
		ProducteCl pr = null;
		String consultaSql = "SELECT * FROM producte;";
		
		try {
			
			ResultSet rs = sentencia.executeQuery(consultaSql);
			
			while (rs.next()) {
				
				pr = new ProducteCl(rs.getString("element"), rs.getString("unitats"), rs.getString("base"), rs.getString("iva"), rs.getString("total"), rs.getString("idProducte"));
				miLista.add(pr);
				
			}
			
			rs.close();
			sentencia.close();
			c.close();
			
		} catch (Exception e) {
			
			System.out.println("ERROR");
			
		}
		
		return miLista;
		
	}
	
	
	/** FUNCIO PER A CONSULTAR UN PRODUCTE EXISTENT EN BASE AL SEU ID */

	public String consultarProducte(String id) throws SQLException {
		
		conectar();
		String name = null;
		sentencia = c.createStatement();
		String consultaSql = "SELECT * FROM producte WHERE idProducte = '"+id+"';";
		
		try {
			
			ResultSet rs = sentencia.executeQuery(consultaSql);
			name = rs.getString("element");
			rs.close();
			sentencia.close();
			c.close();
			
		} catch (Exception e) {
			
			consultaSql = "SELECT * FROM servei WHERE idProducte = '"+id+"';";
			ResultSet rs = sentencia.executeQuery(consultaSql);
			name = rs.getString("element");
			rs.close();
			sentencia.close();
			c.close();
			
		}
		
		return name;
		
	}
	
	
	/** FUNCIO PER A CONSULTAR UN SERVEI EXISTENT EN BASE AL SEU ID */

	public String consultarServei(String id) throws SQLException {
		
		conectar();
		String name = null;
		sentencia = c.createStatement();
		String consultaSql = "SELECT * FROM servei WHERE idProducte = '"+id+"';";
		
		try {
			
			ResultSet rs = sentencia.executeQuery(consultaSql);
			name = rs.getString("element");
			rs.close();
			sentencia.close();
			c.close();
			
		} catch (Exception e) {
			
			System.out.println("ERROR");
			
		}
		
		return name;
		
	}
	
	
	/** FUNCIO PER A FER UN RECOMPTE DELS PRODUCTES EXISTENTS */

	public int contarProductes() throws SQLException, ClassNotFoundException {
		
		conectar();
		int amount = 0;
		sentencia = c.createStatement();
		String consultaSql = "SELECT * FROM producte;";
		ResultSet rs = sentencia.executeQuery(consultaSql);
	
		while (rs.next()) {
			
			++amount;
			
		}
		
		rs.close();
		sentencia.close();
		c.close();
		return amount;
		
	}
	
	
	/** FUNCIO PER A FER UN RECOMPTE DELS SERVEIS EXISTENTS */

	public int contarServeis() throws SQLException, ClassNotFoundException {
		
		conectar();
		int amount = 0;
		sentencia = c.createStatement();
		String consultaSql = "SELECT * FROM servei;";
		ResultSet rs = sentencia.executeQuery(consultaSql);
	
		while (rs.next()) {
			
			++amount;
			
		}
		
		rs.close();
		sentencia.close();
		c.close();
		return amount;
		
	}
	
}
