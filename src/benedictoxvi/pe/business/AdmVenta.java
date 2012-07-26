package benedictoxvi.pe.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


import benedictoxvi.pe.data.Venta;
import benedictoxvi.pe.util.FormatException;
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

	
	
	
	
	
}
