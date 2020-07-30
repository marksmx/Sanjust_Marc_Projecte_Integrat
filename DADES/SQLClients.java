package DADES;
import java.io.File;
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
import java.io.File;
import java.io.IOException;

public class SQLClients {
	
	/** DECLARACIÓ INICIAL DE VARIABLES I ALTRES */
	
	Connection c;
	JComponent frame;
	Statement sentencia;
	
	
	/** FUNCIO CONNEXIÓ A LA BASE DE DADES */
	
	public Connection conectar() {
		
		try {
			
			Class.forName("org.sqlite.JDBC");
			//c = DriverManager.getConnection("jdbc:sqlite:onTimeDB.db");
			c = DriverManager.getConnection("jdbc:sqlite:"+System.getProperty("user.dir")+"\\src\\onTimeDB.db");
			System.out.println("Exito al conectar con base de datos");

		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "Error al conectar a la base de dades","ERROR",JOptionPane.ERROR_MESSAGE);
			
		}

		return c;
	}
	
	
	/** FUNCIÓ PER A CREAR UN CLIENT */
	
	public void crearClient(String empresa, String concepte, String nif, String id, String mail) {
		
		conectar();
		String consultaSql = "INSERT INTO client (empresa, concepte, nif, id, mail)"+
		"VALUES ("
		+ "'"+empresa+"'"
		+","
		+ "'"+concepte+"'"
		+","
		+ "'"+nif.toLowerCase()+"'"
		+","
		+ "'"+id+"'"
		+","
		+ "'"+mail+"')"
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
	
	
	/** FUNCIÓ PER A MODIFICAR UN CLIENT */

	public void modificarClient(String actId, String empresa, String concepte, String nif, String id, String mail) {
		
		conectar();
		String consultaSql = "UPDATE client SET " 
		+"empresa = '"+empresa+"'"
		+","
		+ "concepte = '"+concepte+"'"
		+","
		+ "nif = '"+nif.toLowerCase()+"'"
		+","
		+ "id = '"+id+"'"
		+","
		+ "mail = '"+mail+"' WHERE id = '"+ actId
		+ "';";
		System.out.println(consultaSql);
		
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

	
	/** FUNCIO PER A CONSULTAR A TOTS ELS CLIENTS */
	
	public ArrayList<ClientCl> consultarClient() throws SQLException {
		
		conectar();
		ArrayList<ClientCl> miLista = new ArrayList<ClientCl>();
		ClientCl cli = null;
		sentencia = c.createStatement();
		String consultaSql = "SELECT * FROM client;";

		try {
			
			ResultSet rs = sentencia.executeQuery(consultaSql);
			
			while (rs.next()) {
				
				cli = new ClientCl(rs.getString("empresa"), rs.getString("concepte"), rs.getString("nif"), rs.getString("id"), rs.getString("mail"));
				miLista.add(cli);
				
			}
			
			rs.close();
			sentencia.close();
			c.close();
			
		} catch (Exception e) {
			
			System.out.println("ERROR");
			
		}
		
		return miLista;
		
	}
	
	
	/** FUNCIO PER A CONSULTAR CLIENTS A TRAVÉS DEL SEU ID */
	
	public ArrayList<ClientCl> consultarClientperID(String id) throws SQLException {
		
		conectar();
		ArrayList<ClientCl> miLista = new ArrayList<ClientCl>();
		ClientCl cli = null;
		sentencia = c.createStatement();
		String consultaSql = "SELECT * FROM client WHERE id = '"+id+"';";

		try {
			
			ResultSet rs = sentencia.executeQuery(consultaSql);
			
			while (rs.next()) {
				
				cli = new ClientCl(rs.getString("empresa"), rs.getString("concepte"), rs.getString("nif"), rs.getString("id"), rs.getString("mail"));
				miLista.add(cli);
				
			}
			
			rs.close();
			sentencia.close();
			c.close();
			
		} catch (Exception e) {
			
			System.out.println("ERROR");
			
		}
		
		return miLista;
		
	}

	
	/** FUNCIO PER A CONSULTAR EL CONCEPTE D'UN CLIENT A TRAVÉS DEL SEU ID */
	
	public String consultarNomClient(String id) throws SQLException {
		
		conectar();
		String fullName = null;
		sentencia = c.createStatement();
		String consultaSql = "SELECT concepte FROM client WHERE id = '"+id+"';";
		//System.out.println(consultaSql);

		try {
			
			ResultSet rs = sentencia.executeQuery(consultaSql);
			
			while (rs.next()) {
				
				fullName = rs.getString("concepte");
				
			}
			
			rs.close();
			sentencia.close();
			c.close();
			
		} catch (Exception e) {
			
			System.out.println("ERROR");
			
		}
		
		return fullName;
		
	}
	
/** FUNCIO PER A CONSULTAR EL ID D'UN CLIENT A TRAVÉS DEL SEU ID */
	
	public ArrayList<String> consultarIDClient() throws SQLException {
			
		conectar();
		ArrayList<String> miLista = new ArrayList<String>();
		String cli = null;
		sentencia = c.createStatement();
		String consultaSql = "SELECT id FROM client;";

		try {
			
			ResultSet rs = sentencia.executeQuery(consultaSql);
			
			while (rs.next()) {
				
				cli = rs.getString("id");
				miLista.add(cli);
				
			}
			
			rs.close();
			sentencia.close();
			c.close();
			
		} catch (Exception e) {
			
			System.out.println("ERROR");
			
		}
		
		return miLista;
		
	}
	
	/** FUNCIO PER A CONSULTAR LA EMPRESA D'UN CLIENT A TRAVÉS DEL SEU ID */
	
	public String consultarEmpresaClient(String id) throws SQLException {
		
		conectar();
		String fullName = null;
		sentencia = c.createStatement();
		String consultaSql = "SELECT empresa FROM client WHERE id = '"+id+"';";
		System.out.println(consultaSql);

		try {
			
			ResultSet rs = sentencia.executeQuery(consultaSql);
			
			while (rs.next()) {
				
				fullName = rs.getString("empresa");
				
			}
			
			rs.close();
			sentencia.close();
			c.close();
			
		} catch (Exception e) {
			
			System.out.println("ERROR");
			
		}
		
		return fullName;
		
	}

	
	/** FUNCIO PER A CONSULTAR EL MAIL D'UN CLIENT A TRAVÉS DEL SEU ID */
	
	public String consultarMailClient(String id) throws SQLException {
		
		conectar();
		String fullName = null;
		sentencia = c.createStatement();
		String consultaSql = "SELECT mail FROM client WHERE id = '"+id+"';";
		System.out.println(consultaSql);

		try {
			
			ResultSet rs = sentencia.executeQuery(consultaSql);
			
			while (rs.next()) {
				
				fullName = rs.getString("mail");
				
			}
			
			rs.close();
			sentencia.close();
			c.close();
			
		} catch (Exception e) {
			
			System.out.println("ERROR");
			
		}
		
		return fullName;
		
	}
	
	
	/** FUNCIO PER A FER UN RECOMPTE DELS CLIENTS QUE TENIM GUARDATS */

	public int recompteClients() throws SQLException {
		
		conectar();
		int rec = 0;
		sentencia = c.createStatement();
		String consultaSql = "SELECT * FROM client;";

		try {
			
			ResultSet rs = sentencia.executeQuery(consultaSql);
			
			while (rs.next()) {
				
				++rec;
				
			}
			
			rs.close();
			sentencia.close();
			c.close();
			
		} catch (Exception e) {
			
			System.out.println("ERROR");
			
		}
		
		return rec;
		
	}

	
	/** FUNCIO PER A ELIMINAR CLIENTS A TRAVÉS DEL SEU ID */
	
	public void eliminarClient(String idClient) throws SQLException {
		
		conectar();
		sentencia = c.createStatement();

		String consultaSql = "DELETE FROM client WHERE id='"+idClient+"';";

		try {
			
			ResultSet rs = sentencia.executeQuery(consultaSql);
			rs.close();
			sentencia.close();
			c.close();
			
		} catch (Exception e) {
			
			System.out.println("ERROR");
			
		}
		
	}
	
}
