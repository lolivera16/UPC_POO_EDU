package benedictoxvi.pe.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import benedictoxvi.pe.data.Modulo;
import benedictoxvi.pe.data.Rol;
import benedictoxvi.pe.data.Usuario;
import benedictoxvi.pe.datatest.DataBD;
import benedictoxvi.pe.util.ProcessException;

public class AccesosUser {

	ArrayList<Usuario> arrUsr = new ArrayList<Usuario>();
	DataBD myBD = new DataBD();
	
	public AccesosUser() {
		// TODO Auto-generated constructor stub
		arrUsr = myBD.getDataUsuarios();
	}
	
	public Modulo requestAcceso(String nom_user, String nom_modulo) {
		// TODO Auto-generated method stub
		Modulo mod_usr = new Modulo("NONE", false, false, false, false);
		boolean find = false;
		boolean find_usr = false;
		int index=0;
		for(Usuario usr : myBD.getDataUsuarios()){
			//System.out.println(usr.getUsuario());
			if (usr.getUsuario().equalsIgnoreCase(nom_user)){
				find_usr = true;
				for(Rol user_rol : usr.getRoles()){
					for(Modulo mod : user_rol.getModulo()){
						//System.out.println(mod.getNombre() + "\t" + nom_modulo);
						if (mod.getNombre().equalsIgnoreCase(nom_modulo)){
							mod_usr = mod;
							//System.out.println("Find");
							//System.out.println(mod.getAcceso());
							find = true;
							break;
						}
					}				
					if ( find ) break;					
				}
			break;
			}
		}
			
		//System.out.println(find_usr);	
		if (find_usr == false){
			new ProcessException("El Usuario '" + nom_user + "' no existe.").printStackTrace();
		}
		else if (find == false){
			new ProcessException("No existe el Modulo '"+nom_modulo+"' para el usuario '"+nom_user+"'.").printStackTrace();
		}
		//System.out.println(mod_usr.getAcceso());
		return mod_usr;
		
	}
	
	public Usuario getUserByName(String nom_usr){
		Usuario usr_end= null;
		for(Usuario usr : arrUsr){
			if (usr.getUsuario().equals(nom_usr)){
				usr_end = usr;
				break;
			}
		}
		if (usr_end==null){
			new ProcessException("El Usuario '"+nom_usr+"' no est[a registrado.").printStackTrace();
		}
		return usr_end;
	}

	public ArrayList<Rol> rolesByUser(String nom_user) {
		// TODO Auto-generated method stub
		//ArrayList<Rol> lisRoles = new ArrayList<Rol>();
		Usuario usr = getUserByName(nom_user);
		if (usr==null){
			return null;
		}
		return usr.getRoles();
		//return lisRoles;
	}


	public ArrayList<Modulo> modulosByRol(String nom_rol) {
		// TODO Auto-generated method stub
		return new AdmRoles().findRol(nom_rol).getModulo();
	}

}
