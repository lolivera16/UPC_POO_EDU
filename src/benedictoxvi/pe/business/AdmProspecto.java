package benedictoxvi.pe.business;

import java.util.ArrayList;

import benedictoxvi.pe.data.Prospecto;
import benedictoxvi.pe.util.FormatException;
import benedictoxvi.pe.util.Validaciones;

public class AdmProspecto {
	
	Validaciones objVal = new Validaciones();

	public ArrayList<Prospecto> findProspecto(ArrayList<Prospecto> data,String nombs, String apepat,
			String apemat, String mail, String dni, String tel_cel, String fecha) {
		// TODO Auto-generated method stub
		 ArrayList<Prospecto> filtro = new ArrayList<Prospecto>();
		 for(Prospecto objPro : data){
			 if (objPro.getNombes().contains(nombs) &&
				 objPro.getApePaterno().contains(apepat) &&
				 objPro.getApeMaterno().contains(apemat) &&
				 objPro.getCorreo().contains(mail) &&
				 objPro.getNroDNI().contains(dni) &&
				 ( objPro.getTelefono().contains(tel_cel) || objPro.getCelular().contains(tel_cel)) &&
				 objPro.getFecProspecto().contains(fecha)){
				 filtro.add(objPro);
			 }
		 }
		 if (filtro.size() == 0) {
			 // No existen registros
			 System.err.println("\nNo se encontraron registros.");
		 }
		 else {
			 System.out.println("Se encontraron '"+filtro.size()+"' conincidencias.");
			 int i=0;
				for(Prospecto objPro : filtro){
					i+=1;
					System.out.println("\n " + i + ".\t" +objPro+"\t"+objPro.getNombes());
				}
		 }
		//return null;
		 return filtro;
	}

	public void registrarProspecto(int num_pro, String fecha, String nombs,
			String apepat, String apemat, String mail, String dni,
			String telefono, String celular, String estado) {
		// TODO Auto-generated method stub
		Prospecto objPro = new Prospecto();
		
		String msg_err = "";
		
		if (!objVal.isSet(nombs))
			msg_err = "El Nombre no puede estar en blanco";
		else if (!objVal.isSet(apepat))
			msg_err = "El Apellido Paterno no puede estar en blanco";
		else if (!objVal.isSet(mail)){
			msg_err = "El Apellido Paterno no puede estar en blanco";
		}
		else if (!objVal.isEmail(mail)){
			msg_err = "El Formato de Correo electronico es incorrecto";
		}
		else if (objVal.isSet(dni) && !objVal.isDNI(dni)){
			msg_err = "El Formato de DNI is incorrecto";
		}
		else if (!objVal.isDate(fecha)){
			msg_err = "El Formato de Fecha debe ser dd/mm/aaaa";
		}
		
		objPro.setNumProspecto(num_pro);
		objPro.setFecProspecto(fecha);
		objPro.setNombes(nombs);
		objPro.setApePaterno(apepat);
		objPro.setApeMaterno(apemat);
		objPro.setCorreo(mail);
		objPro.setNroDNI(dni);
		objPro.setTelefono(telefono);		
		objPro.setCelular(celular);
		objPro.setEstado(estado);
	}

	
	
}
