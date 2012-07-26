package benedictoxvi.pe.businesstest;

import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.Test;


import benedictoxvi.pe.business.AdmLogin;
import benedictoxvi.pe.data.Rol;
import benedictoxvi.pe.data.Usuario;

public class AdmLoginTest {
	
	AdmLogin admLogin = new AdmLogin();
    
    public AdmLoginTest() {
    }
    

    //AdmGrupoEstudio objAdminGrupoEstudio = null;
    //ArrayList<GrupoEstudio> lstGrupoEstudio = new ArrayList<GrupoEstudio>();
    //ArrayList<Usuario> dbUsuario = new ArrayList<Usuario>();
    ArrayList<Usuario> dbUsuario = new ArrayList<Usuario>();
    AdmRolTest test= new AdmRolTest();
    Rol rol_actual=test.getRolActual();

    
    @Test
    public void siNoSeIngresaUsuarioMuestraMensajeError(){
        assertFalse(admLogin.usuarioVacio(dbUsuario.get(0).getUsuario()));
        System.out.println("-------------------------------------------------");
        System.out.println("Test: siNoSeIngresaUsuarioMuestraMensajeError");
        System.out.println("-------------------------------------------------");
        System.out.println("Se ha ingresado el usuario");
        System.out.println("--- FIN TEST ---");
        System.out.println();
    }
    
    @Test
    public void siNoSeIngresaContrase�aMuestraError(){

        //test
        assertFalse(admLogin.passwordVacio(dbUsuario.get(0).getPassword()));
//        assertFalse(admLogin.usuarioVacio(""));
        //resultado en pantalla
        System.out.println("-------------------------------------------------");
        System.out.println("Test: siNoSeIngresaContrase�aMuestraError");
        System.out.println("-------------------------------------------------");
        System.out.println("Se ha ingresado la contrase�a");
        System.out.println("--- FIN TEST ---");
        System.out.println();
    }
    
    @Test
    public void siSeIngresaContrase�aIncorrectaMuestraAdvertencia(){

        //test
        assertSame("Password Incorrecto", admLogin.passwordIncorrecto("rgiron","rgiron1",dbUsuario));
        //resultado en pantalla
        System.out.println("-------------------------------------------------");
        System.out.println("Test: siSeIngresaContrase�aIncorrectaMuestraAdvertencia");
        System.out.println("-------------------------------------------------");
        System.out.println("El usuario o password es incorrecto. Intente nuevamente!");
        System.out.println("--- FIN TEST ---");
        System.out.println();
     
    }
	
	

}
