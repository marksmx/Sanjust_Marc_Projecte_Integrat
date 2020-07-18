package MODEL;


/** DECLARACIÓ DE VARIABLES, GETTERS I SETTERS DE LA CLASE FACTURA */

public class FacturaCl {
	
	String numero;
	String data;
	String empresa;
	String concepte;
	String base;
	String iva;
	String total;
	
	public FacturaCl (String numero, String data, String empresa, String concepte, String base, String iva, String total) {
		
		this.numero = numero;
		this.data = data;
		this.empresa = empresa;
		this.concepte = concepte;
		this.base = base;
		this.iva = iva;
		this.total = total;
		
	}

	public void setNumero(String numero) {
		
		this.numero = numero;
		
	}

	public void setData(String data) {
		
		this.data = data;
		
	}

	public void setEmpresa(String empresa) {
		
		this.empresa = empresa;
		
	}

	public void setConcepte(String concepte) {
		
		this.concepte = concepte;
		
	}

	public void setBase(String base) {
		
		this.base = base;
		
	}

	public void setIva(String iva) {
		
		this.iva = iva;
		
	}

	public void setTotal(String total) {
		
		this.total = total;
		
	}

	public String getNumero() {
		
		return numero;
		
	}

	public String getData() {
		
		return data;
		
	}

	public String getEmpresa() {
		
		return empresa;
		
	}

	public String getConcepte() {
		
		return concepte;
		
	}

	public String getBase() {
		
		return base;
		
	}

	public String getIva() {
		
		return iva;
		
	}

	public String getTotal() {
		
		return total;
		
	}

	@Override
	public String toString() {
		
		return "LiniaFacturaCl [numero=" + numero + ", data=" + data + ", empresa=" + empresa + ", concepte=" + concepte
				+ ", base=" + base + ", iva=" + iva + ", total=" + total + "]";
		
	}
	
}
