package MODEL;


/** DECLARACIÓ DE VARIABLES, GETTERS I SETTERS DE LA CLASE LÍNEA FACURA */

public class LiniaFacturaCl {
	
	String idFactura;
	String descripcio;
	String quantitat;
	String preuUnitari;
	String total;
	
	public LiniaFacturaCl (String idFactura, String descripcio, String quantitat, String preuUnitari, String total) {
		
		this.idFactura = idFactura;
		this.descripcio = descripcio;
		this.quantitat = quantitat;
		this.preuUnitari = preuUnitari;
		this.total = total;
		
	}

	public void setIdFactura(String idFactura) {
		
		this.idFactura = idFactura;
		
	}

	public void setDescripcio(String descripcio) {
		
		this.descripcio = descripcio;
		
	}

	public void setQuantitat(String quantitat) {
		
		this.quantitat = quantitat;
		
	}

	public void setPreuUnitari(String preuUnitari) {
		
		this.preuUnitari = preuUnitari;
		
	}

	public void setTotal(String total) {
		
		this.total = total;
		
	}

	public String getIdFactura() {
		
		return idFactura;
		
	}

	public String getDescripcio() {
		
		return descripcio;
		
	}

	public String getQuantitat() {
		
		return quantitat;
		
	}

	public String getPreuUnitari() {
		
		return preuUnitari;
		
	}

	public String getTotal() {
		
		return total;
		
	}

	@Override
	public String toString() {
		
		return "LiniaFacturaCl [idFactura=" + idFactura + ", descripcio=" + descripcio + ", quantitat=" + quantitat
				+ ", preuUnitari=" + preuUnitari + ", total=" + total + "]";
		
	}

}
