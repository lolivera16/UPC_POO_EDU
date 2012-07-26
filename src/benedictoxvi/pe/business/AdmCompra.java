package benedictoxvi.pe.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import benedictoxvi.pe.data.Compra;
import benedictoxvi.pe.util.CompraComparator;
import benedictoxvi.pe.util.FormatException;
import benedictoxvi.pe.util.ProcessException;
import benedictoxvi.pe.util.Validaciones;

public class AdmCompra {

	Validaciones objVal = new Validaciones();
	
	public int listaCompras(ArrayList<Compra> arrCom){
		int i = 0;
		i = arrCom.size();
		if ( i == 0 ) return i;
		System.out.println("-*----------------------*");
		i = 0;
		for(Compra objCom:arrCom){
			i+=1;
			//Compra 1	50001	01/11/2012	Empresa 1	3841,83	691,53	4533,36	USD	01/12/2012	Nuevo	19/11/2012	Observaciones de Compra 1
			System.out.println(i+".\t" + objCom.getConcepto() + "\t" + objCom.getNumero() + 
					"\t" + objCom.getFecEmision() + "\t"  + objCom.getNomEmpresa() +
					"\t" + objCom.getMonSubtot() + "\t" + objCom.getMonIGV() + "\t" +objCom.getMonTotal() +
					"\t" + objCom.getMoneda() + "\t" + objCom.getFecVencim() + "\t" + objCom.getEstado() +
					"\t" + objCom.getFecPago() + "\t" + objCom.getObservacion());
		}
		System.out.println("-*----------------------*");
		return i;
	}
	
	public boolean findCompraByNum(ArrayList<Compra> arrCom,int num){
		boolean ret = false;
		for (Compra objCom : arrCom){
			if (objCom.getNumero() == num){
				ret = true;
				break;
			}
		}
		return ret;
	}
	
	public boolean darAltaCompra(ArrayList<Compra> arrCom,String concepto, int numero,
			String fecEmision, String nomEmpresa, Double subtot, Double monIGV,
			Double monTot, String moneda, String fecVencim, String estado, String fecPagoReal,
			String observ) {
		// TODO Auto-generated method stub
		
		if (findCompraByNum(arrCom, numero)){
			new ProcessException("Ya existe un registro de Compra con el mismo Numero, imposible continuar.").printStackTrace();
			return false;
		}
		
		String msg_err = "";
		if (!objVal.isSet(concepto)){
			msg_err = "Debe ingresar el concepto de Compra (Obligatorio)";			
		}
		else if (!objVal.isSet(fecEmision)){
			msg_err = "Debe ingresar la Fecha de Emision del Documento (Obligatorio)";
		}
		else if (!objVal.isDate(fecEmision)){
			msg_err = "La Fecha de Emision debe tener el formato dd/mm/aaaa";			
		}
		else if (!objVal.isSet(fecVencim)){
			msg_err = "Debe ingresar la Fecha de Vecimiento del Documento (Obligatorio)";
		}
		else if (!objVal.isDate(fecVencim)){
			msg_err = "La Fecha de Vecimiento debe tener el formato dd/mm/aaaa";			
		}
		else if (objVal.isSet(fecPagoReal) && !objVal.isDate(fecPagoReal)){
			msg_err = "El Formato de Fecha de Pago debe ser dd/mm/aaaa";
		}
		else if (subtot<=0){
			msg_err = "El Subtotal del Monto de Compra debe ser mayor a cero (Obligatorio)";
		}
		else if (monIGV<=0){
			msg_err = "El Monto IGV de Compra debe ser mayor a cero (Obligatorio)";
		}
		else if (monIGV >= subtot){
			msg_err = "EL Monto IGV debe ser menor al SubTotal de  "+subtot;
		}
		else if (monTot<=0){
			msg_err = "El Monto Total de Compra debe ser mayor a cero (Obligatorio)";
		}
		else if (objVal.isSet(new String[]{fecEmision,fecPagoReal})){
			if (objVal.dateToInt(fecEmision)>objVal.dateToInt(fecPagoReal)){
				msg_err = "La Fecha de emision no puede ser mayor a la fecha de pago.";
			}
		}
		else if (objVal.isSet(new String[]{fecEmision,fecVencim})){
			if (objVal.dateToInt(fecEmision)>objVal.dateToInt(fecVencim)){
				msg_err = "La Fecha de emision no puede ser mayor a la fecha de Vencimiento.";
			}
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

	public ArrayList<Compra> encontrarCompras(ArrayList<Compra> arrCom,String concepto, int numero,
			String fec_emision, String nom_empresa, String fec_venc, String fec_pago,
			String estado) {
		ArrayList<Compra> filCom = new ArrayList<Compra>();
		// TODO Auto-generated method stub
		boolean comparar  = false;
		
		for (Compra objCom : arrCom){
			comparar = objCom.getConcepto().contains(concepto) &&
					objCom.getFecEmision().contains(fec_emision) &&
					objCom.getNomEmpresa().contains(nom_empresa) &&
					objCom.getFecVencim().contains(fec_venc) &&
					objCom.getFecPago().contains(fec_pago) &&
					objCom.getEstado().contains(estado);
//			System.out.println(comparar);
			if (numero != 0 ){
				if (objCom.getNumero() == numero && comparar){
					filCom.add(objCom);
				}				
			}
			else if (comparar){
				filCom.add(objCom);
			}
		}		
		if (filCom.size() == 0) {
			System.err.println("No se encontraron coincidencias con los Filtros");
		}
		else {
			// Ordenar 
			Collections.sort(filCom,new CompraComparator());
			// 
			System.err.println("Se encontraron '" + filCom.size() + "' coincidencias con los Filtros");
		}
		return filCom;
	}


}

