package benedictoxvi.pe.business;

import java.util.ArrayList;

import benedictoxvi.pe.data.Usuario;
import benedictoxvi.pe.datatest.DataBD;
import benedictoxvi.pe.util.ProcessException;
import benedictoxvi.pe.util.Validaciones;

public class AdmLoginUsuario {
		
	ArrayList<Usuario> arrUsr = new ArrayList<Usuario>();
	DataBD bd = new DataBD();
	Validaciones objVal = new Validaciones();
	
	public AdmLoginUsuario() {
		// TODO Auto-generated constructor stub
		arrUsr = bd.getDataUsuarios();
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

	public boolean loginUsuario(String usuario, String clave) {
		// TODO Auto-generated method stub
		String msg_err = null;		
		if (!objVal.isSet(usuario)){
			msg_err = "Debe Ingresar el Nombre de Usuario para el Login.";
		}
		else if(!objVal.isSet(clave)){
			msg_err = "Debe Ingresar la Clave de Acceso para el Login";
		}
		if (objVal.isSet(msg_err)){
			new ProcessException(msg_err).printStackTrace();
			return false;
		}
		
		Usuario usr = getUserByName(usuario);
		if (usr!=null){
			if (!usr.isActive()){
				new ProcessException("El ["+usuario+"] ha sido bloqueado, el intento de acceso no es posible.").printStackTrace();
				return false;
			}
			if (usr.getPassword().equals(clave)){
				usr.setNum_intentos(0);
				objVal.messageOk("Se ha validado el Acceso del usuario ["+usuario+"] al sistema.");				
				return true;
			}		
			else {
				usr.intentoFallido();
				if (usr.getNum_intentos()==5){
					usr.setStatus("B");
					new ProcessException("El Usuario  ["+usuario+"] se ha bloqueado por demasiados intentos fallidos.").printStackTrace();
					return false;
				}
				new ProcessException("La Clave de acceso es incorrecta para el Usuario ["+usuario+"].").printStackTrace();
			}
		}
		return false;
	}

}
