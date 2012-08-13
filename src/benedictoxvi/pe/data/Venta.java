package benedictoxvi.pe.data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import benedictoxvi.pe.util.Loader;
import benedictoxvi.pe.util.ProcessException;
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
	
	//Para Comprobante
	private int NroMovimiento;		
	private String TipoComprobante;		
	private String NroBoleta;
	private String RUC;
	private Date FechaPago;
	private Double SubTotal;
	private Double Igv;
	private Double Total;
	private String Moneda;
	private String Observacion;
	private  int UsuarioRegistro;		
	private Date FechaRegistro;

	//Variables para Cuenta
	private String CodCuenta;
	private String DesCuenta;
	private Double MontoTotalCuenta;
	private String MonCuenta;
	private  Double SalCuenta;
	private String EstadoCuenta;
	

	//para Cronograma
	private int NroCuota;
	private Double MontoCronograma;
	private String MonedaCronograma;
	private Date FechaVencimientoCronograma;
	private Double MontoMora;
	private String EstadoCuota;
	
	
	
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
	
	public ArrayList<Venta> getDataCursos() {
		Loader objLoa = new Loader();
		ArrayList<Venta> arrVentas = new ArrayList<Venta>();
		Venta objVenta = null;
		String url = objLoa.getClass().getResource("../bd/curso.txt").getFile();		//
		ArrayList<String[]> lisPro = objLoa.getDataTxt(url);
		//System.out.println(lisPro.size());
		for(String[] row : lisPro){
		//	System.out.println(row[0]);
			objVenta = new Venta();
			objVenta.setCodCurso(row[0]);
			objVenta.setNomCurso(row[1]);			
			objVenta.setPreCurso( Double.parseDouble( row[2] ) );						
			arrVentas.add(objVenta);
		}
		return arrVentas;
	}
	
	public ArrayList<Venta> getDataCuentas() {
		Loader objLoa = new Loader();
		ArrayList<Venta> arrVentas = new ArrayList<Venta>();
		Venta objVenta = null;
		String url = objLoa.getClass().getResource("../bd/cuenta.txt").getFile();		//
		ArrayList<String[]> lisPro = objLoa.getDataTxt(url);
		//System.out.println(lisPro.size());
		for(String[] row : lisPro){
		//	System.out.println(row[0]);
			if(!row[0].equalsIgnoreCase("")){
				objVenta = new Venta();
				objVenta.setCodCuenta(row[0]);
				objVenta.setCodCliente(row[1]);
				objVenta.setCodCurso(row[2]);
				objVenta.setMontoTotalCuenta( Double.parseDouble(row[3]));
				objVenta.setMoneda(row[4]);
				objVenta.setSalCuenta(Double.parseDouble( row[5] ));
				objVenta.setEstadoCuenta(row[6]);						
				arrVentas.add(objVenta);
			}
		}
		return arrVentas;
	}
	
	
	public ArrayList<Venta> getDataCronogramaCuentas() {
		Validaciones oUtil = new Validaciones();
		Loader objLoa = new Loader();
		ArrayList<Venta> arrVentas = new ArrayList<Venta>();
		Venta objVenta = null;
		String url = objLoa.getClass().getResource("../bd/cronograma.txt").getFile();		//
		ArrayList<String[]> lisPro = objLoa.getDataTxt(url);
		//System.out.println(lisPro.size());
		for(String[] row : lisPro){
		//	System.out.println(row[0]);
			if(!row[0].equalsIgnoreCase("")){
				objVenta = new Venta();
				objVenta.setCodCuenta(row[0]);
				objVenta.setNroCuota( Integer.parseInt( row[1] ) );
				objVenta.setMontoCronograma( Double.parseDouble(row[2] ) );
				objVenta.setMonedaCronograma(row[3]);
				objVenta.setFechaVencimientoCronograma( oUtil.stringToDate( row[4] ));				
				objVenta.setEstadoCuota(row[6]);						
				arrVentas.add(objVenta);
			}
		}
		return arrVentas;
	}
	
	public Venta getCursoByCodigo(String CodCurso){
		List<Venta> arrCursos = new ArrayList<Venta>();
		arrCursos = getDataCursos();
		for(Venta oVenCurso : arrCursos){
			if (oVenCurso.getCodCurso().equals(CodCurso)){
				return oVenCurso;
			}
		}
		new ProcessException("El Codigo de cuenta '"+CodCuenta+"' no se encuentra registrado.").printStackTrace();
		return null;
	}
	
	
	public Venta getCuentaByCodigo(String CodCuenta){
		List<Venta> arrCuenta = new ArrayList<Venta>();
		arrCuenta = getDataCuentas();
		for(Venta oVenCuenta : arrCuenta){
			if (oVenCuenta.getCodCuenta().equals(CodCuenta)){
				return oVenCuenta;
			}
		}
		new ProcessException("El Codigo de cuenta '"+CodCuenta+"' no se encuentra registrado.").printStackTrace();
		return null;
	}
	
	public List<Venta> getCronogramaByCodigoCuenta(String CodCuenta){
		List<Venta> arrCrono = new ArrayList<Venta>();
		
		List<Venta> arrCronograma = new ArrayList<Venta>();
		arrCronograma = getDataCronogramaCuentas();
		for(Venta oVenCrono : arrCronograma){
			if (oVenCrono.getCodCuenta().equals(CodCuenta)){
				arrCrono.add( oVenCrono);
			}
		}
		return arrCrono;
		//new ProcessException("El Codigo de cuenta '"+ CodCuenta + "' no tiene cronograma asociado.").printStackTrace();
		//return null;
	}
	
	
	
		public int getNroCuota() {
			return NroCuota;
		}



		public void setNroCuota(int nroCuota) {
			NroCuota = nroCuota;
		}



		public Double getMontoCronograma() {
			return MontoCronograma;
		}



		public void setMontoCronograma(Double montoCronograma) {
			MontoCronograma = montoCronograma;
		}



		public String getMonedaCronograma() {
			return MonedaCronograma;
		}



		public void setMonedaCronograma(String monedaCronograma) {
			MonedaCronograma = monedaCronograma;
		}



		public Date getFechaVencimientoCronograma() {
			return FechaVencimientoCronograma;
		}



		public void setFechaVencimientoCronograma(Date fechaVencimientoCronograma) {
			FechaVencimientoCronograma = fechaVencimientoCronograma;
		}



		public String getEstadoCuota() {
			return EstadoCuota;
		}



		public void setEstadoCuota(String estadoCuota) {
			EstadoCuota = estadoCuota;
		}

		
		
			
			public int getNroMovimiento() {
					return NroMovimiento;
				}



				public void setNroMovimiento(int nroMovimiento) {
					NroMovimiento = nroMovimiento;
				}



				public String getTipoComprobante() {
					return TipoComprobante;
				}



				public void setTipoComprobante(String tipoComprobante) {
					TipoComprobante = tipoComprobante;
				}



				public String getNroBoleta() {
					return NroBoleta;
				}



				public void setNroBoleta(String nroBoleta) {
					NroBoleta = nroBoleta;
				}



				public String getRUC() {
					return RUC;
				}



				public void setRUC(String rUC) {
					RUC = rUC;
				}



				public Date getFechaPago() {
					return FechaPago;
				}



				public void setFechaPago(Date fechaPago) {
					FechaPago = fechaPago;
				}



				public Double getSubTotal() {
					return SubTotal;
				}



				public void setSubTotal(Double subTotal) {
					SubTotal = subTotal;
				}



				public Double getIgv() {
					return Igv;
				}



				public void setIgv(Double igv) {
					Igv = igv;
				}



				public Double getTotal() {
					return Total;
				}



				public void setTotal(Double total) {
					Total = total;
				}



				public String getMoneda() {
					return Moneda;
				}



				public void setMoneda(String moneda) {
					Moneda = moneda;
				}



				public String getObservacion() {
					return Observacion;
				}



				public void setObservacion(String observacion) {
					Observacion = observacion;
				}



				public int getUsuarioRegistro() {
					return UsuarioRegistro;
				}



				public void setUsuarioRegistro(int usuarioRegistro) {
					UsuarioRegistro = usuarioRegistro;
				}



				public Date getFechaRegistro() {
					return FechaRegistro;
				}



				public void setFechaRegistro(Date fechaRegistro) {
					FechaRegistro = fechaRegistro;
				}



			public String getCodCuenta() {
				return CodCuenta;
			}



			public void setCodCuenta(String codCuenta) {
				CodCuenta = codCuenta;
			}



			public String getDesCuenta() {
				return DesCuenta;
			}



			public void setDesCuenta(String desCuenta) {
				DesCuenta = desCuenta;
			}



			public Double getMontoTotalCuenta() {
				return MontoTotalCuenta;
			}



			public void setMontoTotalCuenta(Double montoTotalCuenta) {
				MontoTotalCuenta = montoTotalCuenta;
			}



			public String getMonCuenta() {
				return MonCuenta;
			}



			public void setMonCuenta(String monCuenta) {
				MonCuenta = monCuenta;
			}



			public Double getSalCuenta() {
				return SalCuenta;
			}



			public void setSalCuenta(Double salCuenta) {
				SalCuenta = salCuenta;
			}



			public String getEstadoCuenta() {
				return EstadoCuenta;
			}



			public void setEstadoCuenta(String estadoCuenta) {
				EstadoCuenta = estadoCuenta;
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
	public String getNomCurso() {
		return NomCurso;
	}
	public void setNomCurso(String nomCurso) {
		NomCurso = nomCurso;
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


	private Double getMontoMora() {
		return MontoMora;
	}


	private void setMontoMora(Double montoMora) {
		MontoMora = montoMora;
	}
	
	
	
	
	

	
		
}
 