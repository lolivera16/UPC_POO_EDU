package benedictoxvi.pe.business;

import java.util.ArrayList;

import benedictoxvi.pe.data.Cliente;
import benedictoxvi.pe.datatest.DataBD;
import benedictoxvi.pe.util.FormatException;
import benedictoxvi.pe.util.ProcessException;
import benedictoxvi.pe.util.Validaciones;

public class AdmCliente {

	ArrayList<Cliente> arrCli = new ArrayList<Cliente>();
	Validaciones objVal = new Validaciones();
	DataBD bd = new DataBD();
	
	public AdmCliente() {
		// TODO Auto-generated constructor stub
		arrCli = bd.getDataCliente();
	}
	
	public Cliente getClienteByCod(String numCli){
		for(Cliente cli : arrCli){
			if (cli.getCodCliente()== numCli){
				return cli;
			}
		}
		new ProcessException("El Codigo de Cliente '"+numCli+"' no se encuentra registrado.").printStackTrace();
		return null;
	}
	
	public Cliente getClienteByNum(String numCli){
		//Cliente obj = null;
		for(Cliente cli : arrCli){
			if (cli.getCodCliente().equals(numCli)){
				return cli;
			}
		}
		new ProcessException("El Nro de Cliente '"+numCli+"' no existe.").printStackTrace();
		return null;
	}


	
	public ArrayList<Cliente> findCliente(String nombs, String apepat,String apemat, String mail, String dni, String tel_cel, String fecha, String estado) {
		 ArrayList<Cliente> filtro = new ArrayList<Cliente>();
	try{
		
		// TODO Auto-generated method stub
		
		 for(Cliente objCli : arrCli){
//			 System.out.println(objCli.getNomCliente());
//			 System.out.println(objCli.getApePatCliente());
//			 System.out.println(objCli.getApeMatCliente());
//			 System.out.println(objCli.getDniCliente());
//			 System.out.println(objCli.getFonCliente());
//			 System.out.println(objCli.getFecConCliente());
//			 System.out.println(objCli.getEstCliente());
			 
			 if (objCli.getNomCliente().contains(nombs) &&
					 objCli.getApePatCliente().contains(apepat) &&
					 objCli.getApeMatCliente().contains(apemat) &&
					 objCli.getEmaCliente().contains(mail) &&
					 objCli.getDniCliente().contains(dni) &&
				     objCli.getFonCliente().contains(tel_cel) &&
				 objCli.getFecConCliente().contains(fecha) &&
				 objCli.getEstCliente().contains(estado)){
				 filtro.add(objCli);				 
			 }
		 }
		 if (filtro.size() == 0) {
			 // No existen registros
			 new ProcessException("No se encontraron registros.").printStackTrace();
		 }
		 else {
			 objVal.messageOk("Se encontraron '"+filtro.size()+"' conincidencias.");
		 }
	}
	catch(Exception ex){
		ex.printStackTrace();
	}
		//return null;
		 return filtro;
	}
	
	public boolean modifcarCliente(String cod_cli, String fecha, String nombs,
			String apepat, String apemat, String mail, String dni,
			String telefono, String celular, String estado){
				boolean ret = false;
				boolean cambio = false;
				for (int x=0;x<arrCli.size();x++){
					Cliente objCli = arrCli.get(x);
					if (objCli.getCodCliente().equals(cod_cli)){
						if (fecha != null) { // Cambiar Fecha prospecto
							objCli.setFecConCliente(fecha); cambio = true;
						}
						if (nombs != null){ //  Cambiar Nombres
							objCli.setNomCliente(nombs); cambio = true;
						}
						if (apepat != null){
							objCli.setApePatCliente(apepat); cambio = true;
						}
						if (apemat != null){
							objCli.setApeMatCliente(apemat); cambio = true;
						}
						if (mail != null){
							objCli.setEmaCliente(mail); cambio = true;
						}
						if (dni != null){
							objCli.setDniCliente(dni); cambio = true;
						}
						if (telefono != null){
							objCli.setFonCliente(telefono); cambio = true;
						}

						if (estado != null){
							if (estado.equalsIgnoreCase("C") && objCli.getEstCliente().trim().isEmpty()) {
								// Dar de Alta Prospecto
								// Buscando un Prospecto que fue transformado a Cliente y tiene el mismo DNI
								if (findCliente("", "", "", "", objCli.getDniCliente(), "", "","C").size() > 0){
									new ProcessException("Ya existe un Cliente registrado con el Nro.Documento[" + objCli.getDniCliente() + "] que tiene el Cliente actual").printStackTrace();
									return false;
								}
							}
							else if (estado.equalsIgnoreCase("C") && objCli.getEstCliente().equalsIgnoreCase("C")){
								new ProcessException("El Cliente '"+cod_cli+"' ya ha sido dado de alta.").printStackTrace();
								return false;
							}
							objCli.setEstCliente(estado); cambio = true;
						}
						if (cambio) {
						arrCli.set(x, objCli);
						if (estado==null){
							objVal.messageOk("Se ha modificado satisfactoriamente el Cliente Nro. "+cod_cli);
						}
						}
						ret = true;	
						return ret;
					}
				}
				// TODO Auto-generated method stub
				new ProcessException("No se ha encontrado ningun Cliente con el numero '" + cod_cli + "'");
				return ret;
			}
	
	public boolean deClienteToProspecto(String cod_cli){
		boolean res = modifcarCliente(
				  cod_cli, //  Nro Prospecto
				  null, // Fecha registro
				  null, // Nombres
				  null, // Ap.Paterno
				  null, // Ap.Materno
				  null, //  Correo
				  null, //  Nro DNI
				  null, // Telefono
				  null, // Celular
				  "C"  // Estado - Indica convesion a Cliente
				  )
				  ;
		if (res){
			objVal.messageOk("Se ha Dado de Alta al Cliente Nro."+cod_cli);
		}
		return res;
	}
	
	public boolean registrarCliente(String cod_cli, String fecha, String nombs,
			String apepat, String apemat, String mail, String dni,
			String telefono, String celular, String estado) {
		// TODO Auto-generated method stub
		Cliente objCli = new Cliente();
		
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
				
		objCli.setCodCliente(cod_cli);
		objCli.setFecConCliente(fecha);
		objCli.setNomCliente(nombs);
		objCli.setApePatCliente(apepat);
		objCli.setApeMatCliente(apemat);
		objCli.setEmaCliente(mail);
		objCli.setDniCliente(dni);
		objCli.setFonCliente(telefono);		
		objCli.setEstCliente(estado);
		arrCli.add(objCli);
		objVal.messageOk("Se ha registrado el Cliente Nro. "+cod_cli);
		return true;
	}
	
	
	public boolean eliminarCliente(String cod_cli) {
		// TODO Auto-generated method stub
		for(Cliente objCli : arrCli){
			if (objCli.getCodCliente().equals(cod_cli)){
				objVal.messageOk("Se ha eliminado el Cliente Nro."+cod_cli);
				return arrCli.remove(objCli);
			}
		}
		return false;
	}
	
	
}
