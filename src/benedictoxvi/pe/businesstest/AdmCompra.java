package benedictoxvi.pe.businesstest;

import java.util.ArrayList;

import benedictoxvi.pe.data.Compra;
import benedictoxvi.pe.util.FormatException;
import benedictoxvi.pe.util.Validaciones;

public class AdmCompra {

	Validaciones objVal = new Validaciones();
	
	public boolean darAltaCompraTest(ArrayList<Compra> arrCom,String concepto, int numero,
			String fecEmision, String nomEmpresa, Double subtot, Double monIGV,
			Double monTot, String moneda, String fecVencim, String estado, String fecPagoReal,
			String observ) {
		// TODO Auto-generated method stub
		String msg_err = "";
		if (!objVal.isSet(concepto)){
			msg_err = "Debe ingresar el concepto de Compra";			
		}
		else if (!objVal.isSet(fecEmision)){
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
		
		Compra objCom = new Compra();
		objCom.setConcepto(concepto);
		objCom.setNumero(numero);
		objCom.setFecEmision(fecEmision);
		objCom.setNomEmpresa(nomEmpresa);
		objCom.setEstado(estado);
		objCom.setFecPago(fecPagoReal);
		objCom.setFecVencim(fecVencim);
		objCom.setMonSubtot(subtot);
		objCom.setMonIGV(monIGV);
		objCom.setMonTotal(monTot);
		objCom.setObservacion(observ);
		arrCom.add(objCom);
		return true;
	}


}
