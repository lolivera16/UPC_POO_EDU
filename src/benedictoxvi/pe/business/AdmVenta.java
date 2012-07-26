package benedictoxvi.pe.business;

import java.util.List;

import benedictoxvi.pe.data.Compra;
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
			String NomCliente,
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
		
		
		if (!objVal.isSet(codCurso)){
			msg_err = "Debe ingresar el concepto de Compra";			
		}
		else if (!objVal.isSet(codCliente)){
			msg_err = "Debe ingresar el concepto de Compra";			
		}
		else if (!objVal.isSet(concepto)){
			msg_err = "Debe ingresar el concepto de Compra";			
		}
		else if (!objVal.isSet(codTipoDocumento)){
			msg_err = "Debe ingresar la Fecha de Emision del Documento";
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
		else if (objVal.isSet(fecPagoReal) && !objVal.isDate(fecPagoReal)){
			msg_err = "El Formato de Fecha de Pago debe ser dd/mm/aaaa";
		}
		else if (subtot<=0){
			msg_err = "El Subtotal del Monto de Compra debe ser mayor a cero";
		}
		else if (monIGV<=0){
			msg_err = "El Monto IGV de Compra debe ser mayor a cero";
		}
		else if (monIGV >= subtot){
			msg_err = "EL Monto IGV debe ser menor al SubTotal de  "+subtot;
		}
		else if (monTot<=0){
			msg_err = "El Monto Total de Compra debe ser mayor a cero";
		}
		
		if (objVal.isSet(msg_err)){
			new FormatException(msg_err).printStackTrace();
			return false;
		}
		
		objVenta.setConcepto(concepto);
		objVenta.setNumero(nroMovimiento);
		objVenta.setFecEmision(fecEmision);
		objVenta.setNomCliente(NomCliente);
		objVenta.setEstado(estado);
		objVenta.setFecPago(fecPagoReal);
		objVenta.setFecVencim(fecVencim);
		objVenta.setMonSubtot(subtot);
		objVenta.setMonIGV(monIGV);
		objVenta.setMonTotal(monTot);
		objVenta.setObservacion(observ);
		
		arrVenta.add(objVenta);
		
		return true;
	}

	
	
	
	
	
}
