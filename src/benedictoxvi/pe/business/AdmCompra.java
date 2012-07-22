package benedictoxvi.pe.business;

import java.util.ArrayList;

import benedictoxvi.pe.data.Compra;
import benedictoxvi.pe.util.FormatException;
import benedictoxvi.pe.util.Validaciones;

public class AdmCompra {

	Validaciones objVal = new Validaciones();
	
	public boolean darAltaCompra(ArrayList<Compra> arrCom,String concepto, int numero,
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

	public ArrayList<Compra> findCompras(ArrayList<Compra> arrCom,String concepto, int numero,
			String fec_emision, String nom_empresa, String fec_venc,
			String fec_pago, String estado) {
		ArrayList<Compra> filtroCom = new  ArrayList<Compra>();
		for(Compra objCom : arrCom){
			boolean compare = 
					objCom.getConcepto().contains(concepto) &&
					(objCom.getFecEmision().contains(fec_emision)) &&
					objCom.getNomEmpresa().contains(nom_empresa) &&
					objCom.getFecVencim().contains(fec_venc) &&
					objCom.getFecPago().contains(fec_pago) &&
					objCom.getEstado().contains(estado) ;
			if (numero > 0){
				if (objCom.getNumero() == numero && compare){
					filtroCom.add(objCom);
				} 
			}
			else if (compare) {
				filtroCom.add(objCom);
			}
		}
		
		if (filtroCom.size()==0){
			System.err.println("\n No se encontraron registros de Compras para los filtros especificados.");
		}
		else {
			System.out.println("\n Se encontraron '"+filtroCom.size()+"' conincidencias con los filtros especificados.");
			for(Compra objCom : filtroCom){
				System.out.println("\t" + objCom.getNumero() + "\t" + objCom.getConcepto()
						+ "\t" + objCom.getFecEmision() + "\t" + objCom.getFecPago() + "\t" + objCom.getFecVencim()
						+ "\t" + objCom.getNomEmpresa() + "\t" + objCom.getMonSubtot() + "\t" + objCom.getMonIGV()
						+ "\t" + objCom.getMonTotal() + "\t" + objCom.getMoneda()  + "\t" + objCom.getEstado());
			}
			
		}
		// TODO Auto-generated method stub
		return filtroCom;
	}


}
