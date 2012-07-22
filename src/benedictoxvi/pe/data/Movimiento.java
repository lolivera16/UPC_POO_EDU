package benedictoxvi.pe.data;

public abstract class Movimiento {

	String Concepto; //Concepto
	int Numero ; // N'umero de Compra
	String FecEmision;
	String NomEmpresa;
	String FecVencim;
	String FecPago;
	String Estado; // Nuevo, Anulada, cancelada
	String Observacion;
	Double MonSubtot;
	Double MonIGV;
	Double MonTotal;
	String Moneda;
	String Tipo;
	
	public String getConcepto() {
		return Concepto;
	}
	public void setConcepto(String concepto) {
		Concepto = concepto;
	}
	public int getNumero() {
		return Numero;
	}
	public void setNumero(int numero) {
		Numero = numero;
	}
	public String getFecEmision() {
		return FecEmision;
	}
	public void setFecEmision(String fecEmision) {
		FecEmision = fecEmision;
	}
	public String getNomEmpresa() {
		return NomEmpresa;
	}
	public void setNomEmpresa(String nomEmpresa) {
		NomEmpresa = nomEmpresa;
	}
	public String getFecVencim() {
		return FecVencim;
	}
	public void setFecVencim(String fecVencim) {
		FecVencim = fecVencim;
	}
	public String getFecPago() {
		return FecPago;
	}
	public void setFecPago(String fecPago) {
		FecPago = fecPago;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public String getObservacion() {
		return Observacion;
	}
	public void setObservacion(String observacion) {
		Observacion = observacion;
	}
	public Double getMonSubtot() {
		return MonSubtot;
	}
	public void setMonSubtot(Double monSubtot) {
		MonSubtot = monSubtot;
	}
	public Double getMonIGV() {
		return MonIGV;
	}
	public void setMonIGV(Double monIGV) {
		MonIGV = monIGV;
	}
	public Double getMonTotal() {
		return MonTotal;
	}
	public void setMonTotal(Double monTotal) {
		MonTotal = monTotal;
	}
	public String getMoneda() {
		return Moneda;
	}
	public void setMoneda(String moneda) {
		Moneda = moneda;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	
	
	
	
}
