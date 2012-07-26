package benedictoxvi.pe.data;

import java.util.Comparator;

import benedictoxvi.pe.util.Validaciones;

public class Venta extends Movimiento implements Comparator<Venta>{

	private String CodAlumno;
	private String NomAlumno;
	private String ApePatAlumno;
	private String ApeMatAlumno;
	
	private String CodTipoDocumento;//1 boleta, 2 Factura
	private String CodCurso;
	private String NomCurso;
	private double PreCurso;
	private int CanCurso;
	private String NomEmpleado;
	private String ApeEmpleado;
	private String CodEmpleado;
	
	private String CodCliente;
	private String CodTipCliente;
	private String NroRucCliente;
	private String NroDniCliente;
	private String NomCliente;
	private String ApePatCliente;
	private String ApeMatCliente;
	
	
	public Venta(){
		
	}
	
	@Override
	public String toString() {
		String tipoDocumento = "";
		
		if(CodTipoDocumento == "1"){
			tipoDocumento = "BOLETA";
		}else if(CodTipoDocumento == "2"){
			tipoDocumento = "FACTURA";
		}
		
		if(CodCurso == "C01"){
			NomCurso = "POO";
		}else{
			NomCurso = "Sin Curso";
		}
		
		
		return "Movimiento [NumeroMovimiento=" + Numero 
				//+ ", CodigoTipoDocumento=" + CodTipoDocumento 
				+ ", tipoDocumento= " + tipoDocumento
				//+ ", CodigoCurso="	+ CodCurso 
				+ ", NombreCurso=" + NomCurso 
				//+ ", CodCliente=" + CodCliente 
				+ ", NombreCliente=" + NomCliente 
				+ ", NroDocumentoCliente=" + NroRucCliente				
				+ ", Concepto=" + Concepto
				+ ", FechaEmision=" + FecEmision
				+ ", FechaVencim=" + FecVencim 
				+ ", FechaPago=" + FecPago
				+ ", Estado=" + Estado 
				+ ", Observacion=" + Observacion
				+ ", MontoSubtot=" + MonSubtot 
				+ ", MontoIGV=" + MonIGV
				+ ", MontoTotal=" + MonTotal 
				+ ", Moneda=" + Moneda 
				//+ ", Tipo="	+ Tipo 
				+ "]";
	}
	
	
	public String getNomAlumno() {
		return NomAlumno;
	}
	public void setNomAlumno(String nomAlumno) {
		NomAlumno = nomAlumno;
	}
	public String getApePatAlumno() {
		return ApePatAlumno;
	}
	public void setApePatAlumno(String apePatAlumno) {
		ApePatAlumno = apePatAlumno;
	}
	public String getApeMatAlumno() {
		return ApeMatAlumno;
	}
	public void setApeMatAlumno(String apeMatAlumno) {
		ApeMatAlumno = apeMatAlumno;
	}
	public String getCodTipoDocumento() {
		return CodTipoDocumento;
	}
	public void setCodTipoDocumento(String codTipoDocumento) {
		CodTipoDocumento = codTipoDocumento;
	}
	public String getCodCurso() {
		return CodCurso;
	}
	public void setCodCurso(String codCurso) {
		CodCurso = codCurso;
	}
	public String getNomCuro() {
		return NomCurso;
	}
	public void setNomCuro(String nomCuro) {
		NomCurso = nomCuro;
	}
	public double getPreCurso() {
		return PreCurso;
	}
	public void setPreCurso(double preCurso) {
		PreCurso = preCurso;
	}
	public int getCanCurso() {
		return CanCurso;
	}
	public void setCanCurso(int canCurso) {
		CanCurso = canCurso;
	}
	public String getNomEmpleado() {
		return NomEmpleado;
	}
	public void setNomEmpleado(String nomEmpleado) {
		NomEmpleado = nomEmpleado;
	}
	public String getApeEmpleado() {
		return ApeEmpleado;
	}
	public void setApeEmpleado(String apeEmpleado) {
		ApeEmpleado = apeEmpleado;
	}
	public String getCodEmpleado() {
		return CodEmpleado;
	}
	public void setCodEmpleado(String codEmpleado) {
		CodEmpleado = codEmpleado;
	}

	public String getCodAlumno() {
		return CodAlumno;
	}

	public void setCodAlumno(String codAlumno) {
		CodAlumno = codAlumno;
	}

	public String getCodCliente() {
		return CodCliente;
	}

	public void setCodCliente(String codCliente) {
		CodCliente = codCliente;
	}

	public String getCodTipCliente() {
		return CodTipCliente;
	}

	public void setCodTipCliente(String codTipCliente) {
		CodTipCliente = codTipCliente;
	}

	public String getNomCliente() {
		return NomCliente;
	}

	public void setNomCliente(String nomCliente) {
		NomCliente = nomCliente;
	}

	public String getApePatCliente() {
		return ApePatCliente;
	}

	public void setApePatCliente(String apePatCliente) {
		ApePatCliente = apePatCliente;
	}

	public String getApeMatCliente() {
		return ApeMatCliente;
	}

	public void setApeMatCliente(String apeMatCliente) {
		ApeMatCliente = apeMatCliente;
	}



	public String getNroRucCliente() {
		return NroRucCliente;
	}



	public void setNroRucCliente(String nroRucCliente) {
		NroRucCliente = nroRucCliente;
	}

	private String getNroDniCliente() {
		return NroDniCliente;
	}

	private void setNroDniCliente(String nroDniCliente) {
		NroDniCliente = nroDniCliente;
	}
	
	Validaciones objValidaciones = new Validaciones();
	@Override
	public int compare(Venta oVenta1, Venta oVenta2) {
		
		if (objValidaciones.dateToInt(oVenta1.getFecVencim()) == objValidaciones.dateToInt(oVenta2.getFecVencim())) 
		{          
			return 0;
		} 
		else if (objValidaciones.dateToInt(oVenta1.getFecVencim()) >= objValidaciones.dateToInt(oVenta2.getFecVencim())) 
		{   
			return 1;
		} 
		else 
		{                           
			return -1;
		}
		
		
		//return (-1*(objValidaciones.dateToInt(oVenta1.getFecVencim()) 
		//			- objValidaciones.dateToInt(oVenta2.getFecVencim())));
	}
	
	

	
		
}
 