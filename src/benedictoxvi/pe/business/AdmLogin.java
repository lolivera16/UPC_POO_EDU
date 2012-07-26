package benedictoxvi.pe.business;

import java.util.ArrayList;

import benedictoxvi.pe.data.Usuario;

public class AdmLogin {
	
    public String passwordEsperado = "crengifo";
    
  ArrayList<Usuario> dbUsuario = new ArrayList<Usuario>();
  
  
  	public String passwordIncorrecto(String usuario, String password, ArrayList<Usuario> dbArray){
  		//      String encuentra;
      for(int x=0;x<dbArray.size();x++){
          if(dbArray.get(x).getUsuario().equals(usuario)){
              if(dbArray.get(x).getPassword().equals(password))
              return "Password Correcto";
              break;
          }
      }
      return "Password Incorrecto";  
  	}
  
    public boolean usuarioVacio(String user){
      if(user.trim().length() > 0){
          return false;
      }
      return true;
    }
    
    public boolean passwordVacio(String password){
      if(password.trim().length() > 0){
          return false;
      }
      return true;
    }

}
