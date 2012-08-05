package benedictoxvi.pe.business;

import java.util.ArrayList;

import benedictoxvi.pe.data.Prospecto;
import benedictoxvi.pe.datatest.DataBD;
import benedictoxvi.pe.util.FormatException;
import benedictoxvi.pe.util.ProcessException;
import benedictoxvi.pe.util.Validaciones;

public class AdmProspecto {
	
	Validaciones objVal = new Validaciones();
	ArrayList<Prospecto> arrPro = new ArrayList<Prospecto>();
	DataBD bd = new DataBD();

	public ArrayList<Prospecto> getArrPro() {
		return arrPro;
	}

	public void setArrPro(ArrayList<Prospecto> arrPro) {
		this.arrPro = arrPro;
	}

	public AdmProspecto() {
		// TODO Auto-generated constructor stub
		arrPro = bd.getDataProspecto();
	}
	
	public int listaProspectos(){
		 int i=arrPro.size();
		 if (i == 0) return 0;
		 i = 0;
			for(Prospecto objPro : arrPro){
				i+=1;
				System.out.println(i+".\t"  +objPro.getNumProspecto()+"\t" + objPro.getFecProspecto() + "\t" +objPro.getNombes()+"\t" + objPro.getApePaterno() + 
						"\t" + objPro.getApeMaterno() + "\t" + objPro.getCorreo() + "\t" + objPro.getTelefono()
						+ "\t" + objPro.getCelular() + "\t" + objPro.getNroDNI() + "\t" + objPro.getEstado());
			}
		return i;
	}
	
	public ArrayList<Prospecto> findProspecto(String nombs, String apepat,
			String apemat, String mail, String dni, String tel_cel, String fecha, String estado) {
		// TODO Auto-generated method stub
		 ArrayList<Prospecto> filtro = new ArrayList<Prospecto>();
		 for(Prospecto objPro : arrPro){
			 if (objPro.getNombes().contains(nombs) &&
				 objPro.getApePaterno().contains(apepat) &&
				 objPro.getApeMaterno().contains(apemat) &&
				 objPro.getCorreo().contains(mail) &&
				 objPro.getNroDNI().contains(dni) &&
				 ( objPro.getTelefono().contains(tel_cel) || objPro.getCelular().contains(tel_cel)) &&
				 objPro.getFecProspecto().contains(fecha) &&
				 objPro.getEstado().contains(estado)){
				 filtro.add(objPro);
			 }
		 }
		 if (filtro.size() == 0) {
			 // No existen registros
			 new ProcessException("No se encontraron registros.").printStackTrace();
		 }
		 else {
			 System.out.println("Se encontraron '"+filtro.size()+"' conincidencias.");
		 }
		//return null;
		 return filtro;
	}

	public boolean registrarProspecto(int num_pro, String fecha, String nombs,
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
		else if (!objVal.isDate(fecha)){
			msg_err = "El Formato de Fecha debe ser dd/mm/aaaa";
		}
		else if (objVal.isSet(dni) && !objVal.isDNI(dni)){
			msg_err = "El Formato de DNI is incorrecto";
		}
		else if (objVal.isSet(telefono) && !objVal.isDigits(telefono)){
			msg_err = "El Formato de Teléfono es incorrecto";
		}
		else if (objVal.isSet(celular) && !objVal.isDigits(celular)){
			msg_err = "El Formato de Celular is incorrecto";
		}
		
		
		if (objVal.isSet(msg_err)){
			new FormatException(msg_err).printStackTrace();
		return false;
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
		arrPro.add(objPro);
		return true;
	}
	
	public Prospecto getProspectoByNum(int num_pro){
		//Prospecto obj = null;
		for(Prospecto xpro : arrPro){
			if (xpro.getNumProspecto() == num_pro){
				return xpro;
			}
		}
		new ProcessException("El Nro de Prospecto '"+num_pro+"' no existe.").printStackTrace();
		return null;
	}
	
	
	public boolean deProspectoToCliente(int num_pro){
		return modifcarProspecto(
				  num_pro, //  Nro Prospecto
				  null, // Fecha registro
				  null, // Nombres
				  null, // Ap.Paterno
				  null, // Ap.Materno
				  null, //  Correo
				  null, //  Nro DNI
				  null, // Telefono
				  null, // Celular
				  "C"  // Estado
				  );
	}
	
	public boolean deClientetoProspecto(ArrayList<Prospecto> arrPro,int num_pro){
		return modifcarProspecto(
				  num_pro, //  Nro Prospecto
				  null, // Fecha registro
				  null, // Nombres
				  null, // Ap.Paterno
				  null, // Ap.Materno
				  null, //  Correo
				  null, //  Nro DNI
				  null, // Telefono
				  null, // Celular
				  " "  // Estado
				  );
	}

	public boolean eliminarProspecto(int i) {
		// TODO Auto-generated method stub
		for(Prospecto objPro : arrPro){
			if (objPro.getNumProspecto()==(i)){
				return arrPro.remove(objPro);
			}
		}
		return false;
	}

	public boolean modifcarProspecto(int num_pro, String fecha, String nombs,
	String apepat, String apemat, String mail, String dni,
	String telefono, String celular, String estado){
		boolean ret = false;
		boolean cambio = false;
		for (int x=0;x<arrPro.size();x++){
			Prospecto objPro = arrPro.get(x);
			if (objPro.getNumProspecto() == num_pro){
				if (fecha != null) { // Cambiar Fecha prospecto
					objPro.setFecProspecto(fecha); cambio = true;
				}
				if (nombs != null){ //  Cambiar Nombres
					objPro.setNombes(nombs); cambio = true;
				}
				if (apepat != null){
					objPro.setApePaterno(apepat); cambio = true;
				}
				if (apemat != null){
					objPro.setApeMaterno(apemat); cambio = true;
				}
				if (mail != null){
					objPro.setCorreo(mail); cambio = true;
				}
				if (dni != null){
					objPro.setNroDNI(dni); cambio = true;
				}
				if (telefono != null){
					objPro.setTelefono(telefono); cambio = true;
				}
				if (celular != null){
					objPro.setCelular(celular); cambio = true;
				}
				if (estado != null){
					if (estado.equalsIgnoreCase("C") && objPro.getEstado().trim().isEmpty()) {
						// Dar de Alta Prospecto
						// Buscando un Prospecto que fue transformado a Cliente y tiene el mismo DNI
						if (findProspecto("", "", "", "", objPro.getNroDNI(), "", "","C").size() > 0){
							new ProcessException("Ya existe un Cliente registrado con el Nro.Documento[" + objPro.getNroDNI() + "] que tiene el Prospecto actual").printStackTrace();
							return false;
						}
					}
					else if (estado.equalsIgnoreCase("C") && objPro.getEstado().equalsIgnoreCase("C")){
						new ProcessException("El prospecto '"+num_pro+"' ya ha sido dado de alta.").printStackTrace();
						return false;
					}
					objPro.setEstado(estado); cambio = true;
				}
				if (cambio) {
				arrPro.set(x, objPro);
				}
				ret = true;	
				return ret;
			}
		}
		// TODO Auto-generated method stub
		new ProcessException("No se ha encontrado ningun Prospecto con el numero '" + num_pro + "'");
		return ret;
	}

	
	
}
