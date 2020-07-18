package MODEL;


/** DECLARACIÓ DE VARIABLES, GETTERS I SETTERS DE LA CLASE CLIENT */

public class ClientCl {
	
	String empresa;
	String concepte;
	String nif;
	String id;
	String mail;

	public ClientCl (String empresa, String concepte, String nif, String id, String mail) {
		
		this.empresa = empresa;
		this.concepte = concepte;
		this.nif = nif;
		this.id = id;
		this.mail = mail;
		
	}

	public void setEmpresa(String empresa) {
		
		this.empresa = empresa;
		
	}

	public void setConcepte(String concepte) {
		
		this.concepte = concepte;
		
	}

	public void setNif(String nif) {
		
		this.nif = nif;
		
	}

	public void setId(String id) {
		
		this.id = id;
		
	}

	public void setMail(String mail) {
		
		this.mail = mail;
		
	}

	public String getEmpresa() {
		
		return empresa;
		
	}

	public String getConcepte() {
		
		return concepte;
		
	}

	public String getNif() {
		
		return nif;
		
	}

	public String getId() {
		
		return id;
		
	}

	public String getMail() {
		
		return mail;
		
	}

	@Override
	public String toString() {
		
		return "Client [empresa=" + empresa + ", concepte=" + concepte + ", nif=" + nif + ", id=" + id + ", mail="
				+ mail + "]";
		
	}

}
