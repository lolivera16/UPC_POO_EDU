package benedictoxvi.pe.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import benedictoxvi.pe.data.Modulo;
import benedictoxvi.pe.data.Rol;
import benedictoxvi.pe.data.Usuario;
import benedictoxvi.pe.datatest.DataBD;
import benedictoxvi.pe.util.ProcessException;
import benedictoxvi.pe.util.Validaciones;

public class AdmAccesosUser {

	ArrayList<Usuario> arrUsr = new ArrayList<Usuario>();
	Validaciones objVal = new Validaciones();
	DataBD myBD = new DataBD();
	
	public AdmAccesosUser() {
		// TODO Auto-generated constructor stub
		arrUsr = myBD.getDataUsuarios();
	}
	
	
	public Modulo getModuloInUser(String nom_user, String nom_modulo) {
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
							return mod;
							//System.out.println("Find");
							//System.out.println(mod.getAcceso());							
						}
					}								
				}
				return null;
			}
		}			
		//System.out.println(find_usr);	
		if (find_usr == false){
			new ProcessException("El Usuario '" + nom_user + "' no existe.").printStackTrace();
			return null;
		}
		else if (find == false){
			new ProcessException("No existe el Modulo '"+nom_modulo+"' para el usuario '"+nom_user+"'.").printStackTrace();
			return null;
		}
		//System.out.println(mod_usr.getAcceso());
		return null;
		
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
			new ProcessException("El Usuario '"+nom_usr+"' no esta registrado.").printStackTrace();
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

	public boolean addRolUser(String nom_user, String nom_rol) {
		// TODO Auto-generated method stub
		// Verificar Existencia del Usuario
		Usuario usr_rol = getUserByName(nom_user);
		if(usr_rol!=null){
		for(Rol xrol : usr_rol.getRoles()){
			if (xrol.getNombre().equals(nom_rol)){
				new ProcessException("El Usuario '"+nom_user+"' ya tiene asignado el rol '"+nom_rol+"'").printStackTrace();
				return false;
			}
		}
		// Verificar existencia del Rol
		Rol new_rol = new AdmRoles().findRol(nom_rol);
		if (new_rol!=null){
			//System.out.println("Add Rol");
		usr_rol.getRoles().add(new_rol);
		objVal.messageOk("Se ha adicionado el Rol [" + nom_rol + "] al Usuario ["+ nom_user + "].");
		return true;
		}		
		}
		return false;
	}

	public boolean removeRolUser(String nom_usr, String nom_rol) {
		// TODO Auto-generated method stub
		Usuario usr = getUserByName(nom_usr);
		if (usr!=null){
			for(Rol xrol:usr.getRoles()){
				if (xrol.getNombre().equals(nom_rol)){
					usr.getRoles().remove(xrol);
					return true;
				}
			}
			new ProcessException("El Usuario '"+nom_usr+"' no tiene asignado el rol '"+nom_rol+"'").printStackTrace();
			return false;
		}
		return false;
	}

	public boolean requestAcceso(String nom_user, String nom_modulo) {
		// TODO Auto-generated method stub
		Modulo mod_usr = getModuloInUser(nom_user, nom_modulo);
		if (mod_usr!=null){
			return mod_usr.getAcceso();
		}
		return false;
	}
	
	public boolean requestAdicion(String nom_user, String nom_modulo) {
		// TODO Auto-generated method stub
		Modulo mod_usr = getModuloInUser(nom_user, nom_modulo);
		if (mod_usr!=null){
			return mod_usr.getAdicionar();
		}
		return false;
	}
	
	public boolean requestModificacion(String nom_user, String nom_modulo) {
		// TODO Auto-generated method stub
		Modulo mod_usr = getModuloInUser(nom_user, nom_modulo);
		if (mod_usr!=null){
			return mod_usr.getEditar();
		}
		return false;
	}
	
	public boolean requestEliminacion(String nom_user, String nom_modulo) {
		// TODO Auto-generated method stub
		Modulo mod_usr = getModuloInUser(nom_user, nom_modulo);
		if (mod_usr!=null){
			return mod_usr.getEliminar();
		}
		return false;
	}

}
