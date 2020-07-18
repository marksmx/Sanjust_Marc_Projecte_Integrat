package MODEL;


/** DECLARACIÓ DE VARIABLES, GETTERS I SETTERS DE LA CLASE COMANDA */

public class ComandaCl {
	
	String estatComanda;
	String numComanda;
	String idProducte;
	String data;
	String hores;
	String total;
	String idEmpresa;
	String pagat;
	String dataLimit;
	String descripcio;

	public ComandaCl (String estatComanda, String numComanda, String idProducte, String data, String hores, String total, String idEmpresa, String pagat, String dataLimit, String descripcio) {
		
		this.estatComanda = estatComanda;
		this.numComanda = numComanda;
		this.idProducte = idProducte;
		this.data = data;
		this.hores = hores;
		this.total = total;
		this.idEmpresa = idEmpresa;
		this.pagat = pagat;
		this.dataLimit = dataLimit;
		this.descripcio = descripcio;
		
	}


	public void setEstatComanda(String estatComanda) {
		
		this.estatComanda = estatComanda;
		
	}


	public void setNumComanda(String numComanda) {
		
		this.numComanda = numComanda;
		
	}


	public void setIdProducte(String idProducte) {
		
		this.idProducte = idProducte;
		
	}


	public void setData(String data) {
		
		this.data = data;
		
	}


	public void setHores(String hores) {
		
		this.hores = hores;
		
	}


	public void setTotal(String total) {
		
		this.total = total;
		
	}


	public void setIdEmpresa(String idEmpresa) {
		
		this.idEmpresa = idEmpresa;
		
	}

	public void setPagat(String pagat) {
		
		this.pagat = pagat;
		
	}
	
	public void setDataLimit(String dataLimit) {
		
		this.dataLimit = dataLimit;
		
	}
	
	public void setDescripcio(String descripcio) {
		
		this.descripcio = descripcio;
		
	}


	public String getEstatComanda() {
		
		return estatComanda;
		
	}


	public String getNumComanda() {
		
		return numComanda;
		
	}


	public String getIdProducte() {
		
		return idProducte;
		
	}


	public String getData() {
		
		return data;
		
	}


	public String getHores() {
		
		return hores;
		
	}

	public String getTotal() {
		
		return total;
		
	}


	public String getIdEmpresa() {
		
		return idEmpresa;
		
	}
	
	public String getPagat() {
		
		return pagat;
		
	}
	
	public String getDataLimit() {
		
		return dataLimit;
		
	}
	
	public String getDescripcio() {
		
		return descripcio;
		
	}


	@Override
	public String toString() {
		
		return "ComandaCl [estatComanda=" + estatComanda + ", numComanda=" + numComanda + ", idProducte=" + idProducte
				+ ", data=" + data + ", hores=" + hores + ", total=" + total
				+ ", idEmpresa=" + idEmpresa + "]";
		
	}

}
