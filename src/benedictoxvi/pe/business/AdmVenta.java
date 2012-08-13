package benedictoxvi.pe.business;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


import benedictoxvi.pe.data.Cliente;
import benedictoxvi.pe.data.Venta;
import benedictoxvi.pe.datatest.DataBD;
import benedictoxvi.pe.util.FormatException;
import benedictoxvi.pe.util.ProcessException;
import benedictoxvi.pe.util.Validaciones;

public class AdmVenta {
	
	Venta objVenta = new Venta();
	
	Validaciones objVal = new Validaciones();
	
	
	
	public Boolean registrarPagoConBoleta(
			List<Venta> arrVenta,
			int nroMovimiento,
			String codTipoDocumento, 
			String codCurso, 
			String codCliente,
			String nomCliente,
			String concepto, 
			String fecEmision, 
			Double subtot, 
			Double monIGV,
			Double monTot, 
			String moneda, 
			String fecVencim, 
			String estado,
			String fecPagoReal, 
			String observ) {

String msg_err = "";
		
		if (!objVal.isSet(codTipoDocumento))
		{
				msg_err = "Debe ingresar tipo de documento de venta(boleta / factura)";
		}else if (!objVal.isSet(codCurso))
		{
			msg_err = "Debe ingresar el curso a facturar";			
		}
		else if (!objVal.isSet(codCliente))
		{
			msg_err = "Debe ingresar el cliente a facturar";			
		}		 
		else if (!objVal.isSet(concepto)){
			msg_err = "Debe ingresar el concepto de venta";			
		}
		else if (!objVal.isDate(fecEmision)){
			msg_err = "La Fecha de Emision debe tener el formato dd/mm/aaaa";			
		}
		else if (subtot<=0){
			msg_err = "El Subtotal del Monto de venta debe ser mayor a cero";
		}
		else if (monIGV<=0){
			msg_err = "El Monto IGV de venta debe ser mayor a cero";
		}
		else if (monIGV >= subtot || monIGV < 0){
			msg_err = "EL Monto IGV debe ser mayor a cera y menor al SubTotal de  "+subtot;
		}
		else if (monTot<=0){
			msg_err = "El Monto Total de venta debe ser mayor a cero";
		}
		else if(!objVal.isSet(moneda)){
			msg_err = "Ingrese la moneda a utilizar en la operacion.";
		}
		else if (!objVal.isSet(fecVencim)){
			msg_err = "Debe ingresar la Fecha de Vecimiento del Documento";
		}
		else if (!objVal.isDate(fecVencim)){
			msg_err = "La Fecha de Vecimiento debe tener el formato dd/mm/aaaa";			
		}		
		else if (objVal.isSet(fecPagoReal) && !objVal.isDate(fecPagoReal)){
			msg_err = "El Formato de Fecha de Pago debe ser dd/mm/aaaa";
		}
		
		
		if (objVal.isSet(msg_err)){
			new FormatException(msg_err).printStackTrace();
			return false;
		}
		
		objVenta.setNumero(nroMovimiento);
		objVenta.setCodTipoDocumento(codTipoDocumento);
		objVenta.setCodCurso(codCurso);
		objVenta.setCodCliente(codCliente);
		objVenta.setNomCliente(nomCliente);		
		objVenta.setConcepto(concepto);
		objVenta.setFecEmision(fecEmision);		
		objVenta.setMonSubtot(subtot);
		objVenta.setMonIGV(monIGV);
		objVenta.setMonTotal(monTot);
		objVenta.setMoneda(moneda);
		objVenta.setFecVencim(fecVencim);
		objVenta.setEstado(estado);
		objVenta.setFecPago(fecPagoReal);
		objVenta.setObservacion(observ);	
		
		arrVenta.add(objVenta);
		
		return true;
	}

	public Boolean registrarPagoConFactura(ArrayList<Venta> arrVenta,
			int nroMovimiento, 
			String codTipoDocumento, 
			String codCurso,
			String codCliente, 
			String nomCliente, 
			String nroRucCliente,
			String concepto, 
			String fecEmision, 
			Double subtot, 
			Double monIGV,
			Double monTot, 
			String moneda, 
			String fecVencim, 
			String estado,
			String fecPagoReal, 
			String observ) {
		
		String msg_err = "";
		
		if (!objVal.isSet(codTipoDocumento))
		{
				msg_err = "Debe ingresar tipo de documento de venta(boleta / factura)";
		}else if (!objVal.isSet(codCurso))
		{
			msg_err = "Debe ingresar el curso a facturar";			
		}
		else if (!objVal.isSet(codCliente))
		{
			msg_err = "Debe ingresar el cliente a facturar";			
		}else if (!objVal.isRUC(nroRucCliente))
		{
			msg_err = "Debe ingresar un numero de RUC válido";
		}		 
		else if (!objVal.isSet(concepto)){
			msg_err = "Debe ingresar el concepto de venta";			
		}
		else if (!objVal.isDate(fecEmision)){
			msg_err = "La Fecha de Emision debe tener el formato dd/mm/aaaa";			
		}
		else if (!objVal.isSet(fecVencim)){
			msg_err = "Debe ingresar la Fecha de Vecimiento del Documento";
		}
		else if (!objVal.isDate(fecVencim)){
			msg_err = "La Fecha de Vecimiento debe tener el formato dd/mm/aaaa";			
		}
		else if (subtot<=0){
			msg_err = "El Subtotal del Monto de venta debe ser mayor a cero";
		}
		else if (monIGV<=0){
			msg_err = "El Monto IGV de venta debe ser mayor a cero";
		}
		else if (monIGV >= subtot || monIGV < 0){
			msg_err = "EL Monto IGV debe ser mayor a cera y menor al SubTotal de  "+subtot;
		}
		else if (monTot<=0){
			msg_err = "El Monto Total de venta debe ser mayor a cero";
		}
		else if (objVal.isSet(fecPagoReal) && !objVal.isDate(fecPagoReal)){
			msg_err = "El Formato de Fecha de Pago debe ser dd/mm/aaaa";
		}
		
		
		if (objVal.isSet(msg_err)){
			new FormatException(msg_err).printStackTrace();
			return false;
		}
		
		objVenta.setNumero(nroMovimiento);
		objVenta.setCodTipoDocumento(codTipoDocumento);
		objVenta.setCodCurso(codCurso);
		objVenta.setCodCliente(codCliente);
		objVenta.setNomCliente(nomCliente);
		objVenta.setNroRucCliente(nroRucCliente);
		objVenta.setConcepto(concepto);
		objVenta.setFecEmision(fecEmision);		
		objVenta.setMonSubtot(subtot);
		objVenta.setMonIGV(monIGV);
		objVenta.setMonTotal(monTot);
		objVenta.setMoneda(moneda);
		objVenta.setFecVencim(fecVencim);
		objVenta.setEstado(estado);
		objVenta.setFecPago(fecPagoReal);
		objVenta.setObservacion(observ);		 
		
		arrVenta.add(objVenta);
		
		return true;		
	}

	public ArrayList<Venta> listarMovimientos(ArrayList<Venta> arrMovimiento) {
		
		Collections.sort(arrMovimiento, new Venta());
		
		Iterator<Venta> iMovimientos = arrMovimiento.iterator(); 
		
		while(iMovimientos.hasNext()){
			System.out.println(iMovimientos.next().toString());
		}
		return arrMovimiento;
	}

	public ArrayList<Venta> listarMovimientosTipoDocumento(
			ArrayList<Venta> arrMovimiento, String codTipoDocumento) {
		
		ArrayList<Venta> olstMovimiento = new ArrayList<Venta>();
		Iterator<Venta> iMovimientos = arrMovimiento.iterator(); 
		Venta oVenta;
				
		while(iMovimientos.hasNext()){
			oVenta = iMovimientos.next();
			if(oVenta.getCodTipoDocumento() == codTipoDocumento)
			{
				olstMovimiento.add(oVenta);
				System.out.println(oVenta.toString());
			}			
		}
		if (olstMovimiento.size() == 0) {
			 System.err.println("\nNo se encontraron registros.");
		}
		else 
		{
			 System.out.println("Se encontraron '"+ olstMovimiento.size()+"' conincidencias.");
			 
		}
		
		return olstMovimiento;
	}

	public ArrayList<Venta> listarDetalleMovimiento(
			ArrayList<Venta> arrMovimiento, int nroMovimiento) {
		
		ArrayList<Venta> olstMovimiento = new ArrayList<Venta>();
		Iterator<Venta> iMovimientos = arrMovimiento.iterator(); 
		Venta oVenta;
		
		while(iMovimientos.hasNext()){
			oVenta = iMovimientos.next();
			if(oVenta.getNumero() == nroMovimiento)
			{
				olstMovimiento.add(oVenta);
				System.out.println(oVenta.toString());
			}			
		}
		if (olstMovimiento.size() == 0) {
			 System.err.println("\nNo se encontraron registros.");
		}
		else 
		{
			 System.out.println("Se encontraron '"+ olstMovimiento.size()+"' conincidencias.");
			 
		}
		
		return olstMovimiento;
	}

	public boolean anularDocumento(ArrayList<Venta> arrMovimiento,
			int nroMovimiento) {
				 
		for (Venta oVenta : arrMovimiento){
			if(oVenta.getNumero() == nroMovimiento){
				return arrMovimiento.remove(oVenta);				
			}			
		}		
		return false;
	}

	public boolean registraPagoBoletaFactura(ArrayList<Venta> arrVenta,
			int nroMovimiento, String tipoComprobante, String nroBoleta,
			String RUC, String CodCliente, String CodCuenta, List<Venta> arrNroCuota,
			String usuarioRegistro) {
		
		String Comprobante = "";		
		String msg_err = "";
		
		if (!objVal.isSet(tipoComprobante))
		{
				msg_err = "Debe ingresar tipo de documento de venta(boleta / factura)";
		}else if (!objVal.isSet(CodCuenta))
		{
			msg_err = "Debe ingresar el curso a facturar";			
		}
		else if (!objVal.isSet(CodCliente))
		{
			msg_err = "Debe ingresar el cliente a facturar";			
		}			
		else if(!objVal.isSet(usuarioRegistro)){
			msg_err = "Debe existir un responsable de emisión(Usuario registro).";
		}

		if(validaciones(CodCliente, CodCuenta) != true){
			msg_err = "Mensaje de validacion interno";		
		}
		
		if(tipoComprobante.equalsIgnoreCase("1")){
			Comprobante = "BOLETA";
		}else{
			Comprobante = "FACTURA";
		}	
		
		
		if (objVal.isSet(msg_err)){
			new FormatException(msg_err).printStackTrace();
			return false;
		}
		
		Venta objVenCronograma = new Venta();
		List<Venta> arrCrono = new ArrayList<Venta>();
		arrCrono = objVenCronograma.getCronogramaByCodigoCuenta(CodCuenta);
		
		Venta oCuenta = new Venta();
		oCuenta = objVenCronograma.getCuentaByCodigo(CodCuenta); 
		
		Venta oCurso = new Venta();
		oCurso = objVenCronograma.getCursoByCodigo(oCuenta.getCodCurso());
		
		Cliente objCliente = new Cliente();
		objCliente = getClienteByCodigo(CodCliente  );
		
		Date FechaActual = new Date();
		
		System.out.println("Comprobante Venta Nro " + nroMovimiento);
		System.out.println("Tipo Comprobante 	: " + Comprobante);
		System.out.println("Número Comprobante 	: "+ nroBoleta);
		System.out.println("Fecha Emisión 		: "+ fechaToString(FechaActual));		
		System.out.println("Nombre Cliente 		: " + objCliente.getNomCliente() + " " 
				+ objCliente.getApePatCliente() + " "  + objCliente.getApeMatCliente());
		System.out.println("--Items ");
		
		
		String fecha = "";
		int n = 0;
		Double MontoTotal = 0.0;
		Double Mora = 0.0;
		Double TotalMora = 0.0;
		for(Venta oCuota : arrNroCuota){
			for(Venta oCuota2: arrCrono ){
				if (oCuota2.getNroCuota() == oCuota.getNroCuota() &&
						oCuota2.getEstadoCuota().equals("P")){
					Mora = 0.0;
					
					n = n + 1;
					long difDias = difDiasEntre2fechas(oCuota2.getFechaVencimientoCronograma(),FechaActual);
					if( difDias  > 0){
						Mora = difDias * 0.01 * oCuota2.getMontoCronograma();						
					}
					
					System.out.println("--"  + n + ". Cuota " + oCuota2.getNroCuota() + " " 
							+ oCurso.getNomCurso() + " --> " + oCuota2.getMontoCronograma() 
							+ " \n 		Fecha Vencimiento : " + fechaToString(oCuota2.getFechaVencimientoCronograma())
							+ " Mora : " + Mora							 
							);
					fecha = fechaToString(oCuota2.getFechaVencimientoCronograma());
					TotalMora = TotalMora + Mora;
					
					MontoTotal = MontoTotal + oCuota2.getMontoCronograma();
				}
			}
		}
		
		System.out.println("--");
		Double Igv = 0.0;
		if(tipoComprobante.equalsIgnoreCase("2")){
			Igv = (0.18) * MontoTotal ;
			System.out.println("Sub Total		: " + MontoTotal);
			System.out.println("IGV			: " + Igv);
		}
		Double ImporteTotal = ( Igv + MontoTotal + TotalMora);
		System.out.println("Total			: " + ImporteTotal);
		System.out.println("");
		
		objVenta.setNumero(nroMovimiento);
		objVenta.setCodTipoDocumento(tipoComprobante);
		objVenta.setCodCurso(oCurso.getCodCurso());
		objVenta.setNomCurso(oCurso.getNomCurso());		
		objVenta.setCodCliente(CodCliente);
		objVenta.setNomCliente(objCliente.getNomCliente());
		objVenta.setNroRucCliente(RUC);
		objVenta.setConcepto(oCurso.getNomCurso());
		objVenta.setFecEmision(fechaToString(FechaActual));		
		objVenta.setMonSubtot(MontoTotal);
		objVenta.setMonIGV(Igv);
		objVenta.setMonTotal(ImporteTotal);
		objVenta.setMoneda(oCuenta.getMoneda());
		objVenta.setFecVencim(fecha);
		objVenta.setEstado("A");
		objVenta.setFecPago(fechaToString(FechaActual));
		objVenta.setObservacion("Pago cuota");		 
		
		arrVenta.add(objVenta);
		
		
		return true;
	}

	
	public Cliente getClienteByCodigo(String CodCliente){
		//Cliente obj = null;
		DataBD bd = new DataBD();
		List<Cliente> arrCli = new ArrayList<Cliente>();
		arrCli = bd.getDataCliente();
		
		for(Cliente cli : arrCli){
			if (cli.getCodCliente().equals(CodCliente)){
				return cli;
			}
		}
		new ProcessException("El Código de Cliente '"+ CodCliente +"' no existe.").printStackTrace();
		return null;
	}
	
	public Boolean validaciones(String CodCliente, String CodCuenta){
		Boolean res = true;
		Cliente objCliente = new Cliente();
		objCliente = getClienteByCodigo(CodCliente);
		if(objCliente == null  ){
			res = false;
		}
		
		Venta oVenCuenta = new Venta();
		oVenCuenta = oVenCuenta.getCuentaByCodigo(CodCuenta);
		if(oVenCuenta == null  ){
			res = false;
		}
		
		Venta oVenCronograma = new Venta();
		List<Venta> arrCrono = new ArrayList<Venta>();
		arrCrono = oVenCronograma.getCronogramaByCodigoCuenta(CodCuenta);
		if(arrCrono == null  ){			
			res = false;
		}
		return res;
	}
	
	String fechaToString(Date pFecha){
		String Fecha = "";
		SimpleDateFormat Forma = new SimpleDateFormat("dd/MM/yyyy");
		Fecha = Forma.format(pFecha);
		return Fecha;
	}
	
	 public long difDiasEntre2fechas(Date pFecha1, Date pFecha2){
		 
		// System.out.println("FEcha1		: " + fechaToString(pFecha1));
		 String Fecha1 =  fechaToString(pFecha1);
		 String Fecha2 =  fechaToString(pFecha2);
		 
		 String[] parts ;
    	 int val = 0;
    	 parts = Fecha1.split("/");
    	 if (parts.length==3){
    	 	 val = Integer.parseInt(parts[2]+parts[1]+parts[0]);
    	 }   
    	 
    	 String[] parts2 ;
    	 int val2 = 0;
    	 parts2 = Fecha2.split("/");
    	 if (parts.length==3){
    	 	 val = Integer.parseInt(parts2[2]+parts2[1]+parts2[0]);
    	 }
		
		 /*
		 System.out.println("val		: " +val);
		 System.out.println("D1		: " + parts[0]);
		 System.out.println("M1		: " + parts[1]);
		 System.out.println("D1		: " + parts[2]);
		 
		 	 System.out.println("D2		: " + parts2[0]);
		 System.out.println("M2		: " + parts2[1]);
		 System.out.println("Y2		: " + parts2[2]);
		 
		 */
		 int D1 = Integer.parseInt(parts[0]);
		 int M1 = Integer.parseInt(parts[1]);
		 int Y1 = Integer.parseInt(parts[2]);
		 //System.out.println("Fecha2		: " + fechaToString(pFecha2));
		 int D2 = Integer.parseInt(parts2[0]);
		 int M2 = Integer.parseInt(parts2[1]);
		 int Y2 = Integer.parseInt(parts2[2]);
		 

	
		 java.util.GregorianCalendar date=new java.util.GregorianCalendar(Y1,M1,D1);
		 java.util.GregorianCalendar date2=new java.util.GregorianCalendar(Y2,M2,D2);
		 
		 long difms=date2.getTimeInMillis() - date.getTimeInMillis();
		 long difd=difms / (1000 * 60 * 60 * 24);
		 
		 return difd;
		 }
	 
	 
	 
	
	
}
