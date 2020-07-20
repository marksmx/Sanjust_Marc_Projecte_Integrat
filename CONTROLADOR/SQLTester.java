package CONTROLADOR;

import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;

import DADES.*;
import MODEL.ComandaCl;


/** FUNCIÓ PER  */

public class SQLTester {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		SQLUsuari sqlU = new SQLUsuari();
		SQLClients sqlC = new SQLClients();
		SQLComandes sqlCo = new SQLComandes();
		SQLProductes sqlP = new SQLProductes();
		sqlC.conectar();
		
		ArrayList<String> miLista = sqlCo.consultarDataLimit("0");
		String matInfo[] = new String[miLista.size()];

		for (int i = 0; i < miLista.size(); i++) {
			
			String test = ""+miLista.get(i).charAt(0)+miLista.get(i).charAt(1)+miLista.get(i).charAt(2);
			
			if(test.equals("Sen")) {
				
				System.out.println("Nada");
				
			} else {
				
				System.out.println("Ieep");
				
			}
			
		}
		
		//sqlU.modificarUsuari("hola", "hola", "hola", "dew", "hola");

		//sqlU.exist();
		//sqlU.crearPerfil("", "", "", "", "");
		//sqlU.iniciarSessió("qwd", "qwd");
		//sqlC.consultarClient();
		//sqlCo.consultarComandes();
		//sqlCo.conectar();
		//sqlCo.contarComandesFin();
		//sqlC.crearClient("coco", "carpes", "test", "5", "test");
		//sqlP.crearProducte("Test", "1 per Setmana", "1", "33", "2", "35", "1");
		//sqlP.crearServei("Test", "1 per Setmana", "1", "33", "2", "35");
		//sqlC.modificarClient("1", "BroMomento", "Coco2", "1234", "1", "coco@coco.co");
		//sqlCo.finalitzarComanda("2", "15:10:19.113");
		//System.out.println(sqlP.contarProductes());
		//System.out.println(sqlP.contarServeis());
	}
}
