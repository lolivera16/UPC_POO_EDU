package benedictoxvi.pe.business;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import benedictoxvi.pe.data.Rol;
import benedictoxvi.pe.data.Usuario;
import benedictoxvi.pe.datatest.DataBD;
import benedictoxvi.pe.util.ProcessException;
import benedictoxvi.pe.util.Validaciones;

public class AdmUsuarios {
	
		/*ArrayList<Usuario> arrUsr | Usuario objUsuarioEncontrado;*/
		
		Validaciones objVal = new Validaciones();
		AdmRoles admRol =  new AdmRoles();
		ArrayList<Usuario> arrUsr=new ArrayList<Usuario>();
		//ArrayList<Rol> arrRols =  new ArrayList<Rol>();
		DataBD bd = new DataBD();
		
		public AdmUsuarios() {
			// TODO Auto-generated constructor stub
			//arrRol = bd.getDataRoles();
			arrUsr = bd.getDataUsuarios();
		}
		
		public ArrayList<Usuario> getarrUsr() {
		      return arrUsr;
		}
			
		Usuario objUsuarioEncontrado;
		  
		public Usuario getObjUsuarioEncontrado() {
		      return objUsuarioEncontrado;
		}
		    
		public void agregarUsuario(Usuario user) {
		      arrUsr.add(user);
		}
		    
		public Usuario getUser_name(String nombre) {
		      Usuario temp=null;
		      for (int i=0; i<arrUsr.size();i++){
		          if (nombre.equals(arrUsr.get(i).getNombre()))
		              temp=arrUsr.get(i);
		              break;
		     }
		     return temp;
		}
	
	  
	  /*<< -  - >>*/
	  public Date convertirFecha(String fecha) throws ParseException {
	      //SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd-MM-yyyy");
	      DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
	      Date d1 = df.parse(fecha);
	      //Date d1 = new Date();
	      //System.out.println(df.format(d1));}
	      return d1;
	  }
	  
	  public Usuario getUserByName(String usuario){	      
	      for(Usuario usr : arrUsr){
	    	if (usr.getUsuario().equals(usuario)){
	    		return usr;
	    	}  
	      }
	      new ProcessException("El usuario '"+usuario+"' no esta registrado.").printStackTrace();
	      return null;
	  }
	  
	  public static void DatosUsuarioBuscado(String usuario, ArrayList<Usuario> dbArray){
	      for(int x=0;x<dbArray.size();x++){
	          if(dbArray.get(x).getUsuario().equals(usuario)){
	              System.out.println("Nombre:    "  + dbArray.get(x).getNombre());
	              System.out.println("Apellido Paterno: "  + dbArray.get(x).getApellidoPaterno());
	              System.out.println("Apellido Materno: "  + dbArray.get(x).getApellidoMaterno());
	              System.out.println("Usuario:   "  + dbArray.get(x).getUsuario());
	              System.out.println("Contraseña:  "  + dbArray.get(x).getPassword());
	              System.out.println("Correo:    "  + dbArray.get(x).getCorreo());
	              System.out.println("Fecha de Ingreso: "  + dbArray.get(x).getF_ingreso());
	              System.out.println("Cargo:     "  + dbArray.get(x).getCargo());
	          }
	      }
	  }
	  
	  public static boolean eliminarUsuario(String usuario, ArrayList<Usuario> dbArray){
	      return false;
	  }
	  //USUARIO01	PASWORD01	NOMBRE 01	APELLIDO PAT 01	APELLIDO MAT 01	01/01/2012	ADM	COMPRA	70721577
	public boolean createUsuario(String nom_usr, String pwd1,String pwd2, String nombs,
			String apat, String amat, String fing, String[] rols,
			String cargo, String dni) {
		String msg_err = null;
		if(!objVal.isSet(nom_usr)){
			msg_err = "Debe ingresar el nombre de usuario.";
		}
		else if (!objVal.isSet(new String[]{pwd1,pwd2})){
			msg_err = "Debe Ingresar la Clave de Acceso y su respectiva verificacion.";
		}
		else if (!pwd1.equals(pwd2)){
			msg_err = "La Clave de Acceso y su Verificacion no coinciden.";
		}
		else if (!objVal.isSet(nombs)){
			msg_err = "Debe Ingresar el Nombre del Responsable del usuario.";
		}
		else if (!objVal.isSet(apat)){
			msg_err = "Debe Ingresar al menos el Apellido del Responsable del usuario.";
		}
		else if (!objVal.isSet(fing)){
			msg_err = "Debe Ingresar la Fecha de Ingreso del Usuario.";
		}
		else if (!objVal.isDate(fing)){
			msg_err = "La Fecha de Ingreso debe indicarse en el formato dd/mm/aaaa.";
		}
		else if (!objVal.isSet(dni)){
			msg_err = "Debe Ingresar el Nro. de DNI";
		}
		else if (!objVal.isDNI(dni)){
			msg_err = "El Formato de DNI ingresado es incorrecto.";
		}		
		
		if (objVal.isSet(msg_err)){
			new ProcessException(msg_err).printStackTrace();
			return false;
		}
		
		Rol add_rol = null;
		ArrayList<Rol> roles = new ArrayList<Rol>();
		for(String nom_rol : rols){
			add_rol = admRol.findRol(nom_rol);
			if (add_rol == null){
				new ProcessException("El Rol '"+nom_rol+"' no ha sido registrado, y no se ha podido adicionar al usuario.");
				return false;
			}
			roles.add(add_rol);	
		}
		
		// TODO Auto-generated method stub
		
		Usuario new_usr = new Usuario();
		new_usr.setRoles(roles);
		new_usr.setPassword(pwd1);
		new_usr.setUsuario(nom_usr);
		new_usr.setApellidoPaterno(apat);
		new_usr.setApellidoMaterno(amat);
		new_usr.setNombre(nombs);
		new_usr.setF_ingreso(fing);
		new_usr.setCargo(cargo);
		new_usr.setDni(dni);
		arrUsr.add(new_usr);
		return true;
	}

	public boolean loginUser(String nom_usr, String clave) {
		// TODO Auto-generated method stub
		Usuario usr = getUserByName(nom_usr);
		if (usr!=null){
			//if (objVal.isValidKey(key))
			if (usr.getPassword().equals(clave)){
			if(!usr.isActive()){
				new ProcessException("El usuario '"+nom_usr+"' tiene el acceso bloqueado.").printStackTrace();
				return false;
			}
			return true;
			}
			else{
				new ProcessException("La Clave de acceso es incorrecta para el usuario '"+nom_usr+"'").printStackTrace();			
				return false; 
			}
				
		}
		
		return false;
	}

	public boolean cambiarClaveUsuario(String nom_usr, String clave_actual,
			String newpwd1, String newpwd2) {
		// TODO Auto-generated method stub
		if (loginUser(nom_usr, clave_actual)){
			if (!objVal.isValidKey(newpwd1)){
				new ProcessException("La Nueva clave no es segura, debe ser al menos de 8 caracteres.").printStackTrace();
				return false;
			}
			if (!newpwd2.equals(newpwd2)){
				new ProcessException("La Nueva Clave de Acceso y la verificacion no coinciden.").printStackTrace();
				return false;
			}
			return true;
		}
		return false;
	}
	
	public boolean modificarUsuario(String nom_usr, String nombs,
			String apat, String amat, String fing, String[] rols,
			String cargo, String dni) {
		String msg_err = "";
		if(!objVal.isSet(nom_usr)){
			new ProcessException("Debe ingresar el nombre de usuario.").printStackTrace();
			return false;
		}	
		Usuario  upd_usr = getUserByName(nom_usr);		
		if (upd_usr==null)
		{
			return false;
		}
		
		if (nombs!=null && !objVal.isSet(nombs)){
			msg_err = "Debe Ingresar el Nombre del Responsable del usuario.";
		}
		else if (apat!=null && !objVal.isSet(apat)){
			msg_err = "Debe Ingresar al menos el Apellido del Responsable del usuario.";
		}
		else if (fing!=null && !objVal.isSet(fing)){
			msg_err = "Debe Ingresar la Fecha de Ingreso del Usuario.";
		}
		else if (fing!=null && !objVal.isDate(fing)){
			msg_err = "La Fecha de Ingreso debe indicarse en el formato dd/mm/aaaa.";
		}
		else if (dni!=null && !objVal.isSet(dni)){
			msg_err = "Debe Ingresar el Nro. de DNI";
		}
		else if (dni!=null && !objVal.isDNI(dni)){
			msg_err = "El Formato de DNI ingresado es incorrecto.";
		}				
		if (objVal.isSet(msg_err)){
			new ProcessException(msg_err).printStackTrace();
			return false;
		}
		
		if (rols!=null){
		ArrayList<Rol> roles =new ArrayList<Rol>();		
		for(String nom_rol : rols){
			Rol add_rol = admRol.findRol(nom_rol);
			if (add_rol == null){
				new ProcessException("El Rol '"+nom_rol+"' no ha sido registrado, y no se ha podido adicionar al usuario.");
				return false;
			}
			roles.add(add_rol);	
		}			
		upd_usr.setRoles(roles);
		}
		
		upd_usr.setNombre(nombs);
		upd_usr.setApellidoMaterno(amat);
		upd_usr.setApellidoPaterno(apat);
		upd_usr.setDni(dni);
		if (cargo!=null){
		upd_usr.setCargo(cargo);
		}
		upd_usr.setF_ingreso(fing);
		return true;
	}

	public boolean bloquearUsuario(String nom_usr) {
		// TODO Auto-generated method stub
		Usuario usr= getUserByName(nom_usr);
		if (!(usr==null)){
			if (usr.getStatus()=="X"){
				System.out.println("El Usuario ya se encuentra bloqueado.");
			}
			usr.setStatus("X");
			return true;
		}
		return false;
	}
	
	public boolean desbloquearUsuario(String nom_usr){
		Usuario usr= getUserByName(nom_usr);
		if (!(usr==null)){
			if (usr.getStatus()=="X"){
				System.out.println("El Usuario no se encuentra bloqueado.");
			}
			usr.setStatus("A");
			return true;
		}
		return false;
	}

}
