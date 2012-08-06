package benedictoxvi.pe.businesstest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

import benedictoxvi.pe.business.AdmUsuarios;
import benedictoxvi.pe.data.Rol;
import benedictoxvi.pe.data.Usuario;
import benedictoxvi.pe.util.Security;

public class AdmUsuarioTest {
	
AdmUsuarios admUsuarios = new AdmUsuarios();
AdmRolTest test= new AdmRolTest();    
Security sec = new Security();
    //simularTabla();
    
    @Test
    public void createUsuarioTest() {
    	Assert.assertTrue(admUsuarios.createUsuario(
    												"USUARIO20",
    												"PASWORD20", // Clave de Acceso
    												"PASWORD20", //  Verificacion de Clave
    												"NOMBRES 20",
    												"APELLIDO PAT 20",
    												"APELLIDO MAT 20",
    												"01/05/2012",
    												new String[]{"ADM"}, // ROLES
    												"ADMINISTRADOR", // Cargo
    												"71033506" // dni
    			));	     
    }
        
    @Test
    public void createUsuarioClavesDistintasTest() {
    	Assert.assertFalse(admUsuarios.createUsuario(
    												"USUARIO20",
    												"PASWORD20", // Clave de Acceso
    												"PASWORD12", //  Verificacion de Clave
    												"NOMBRES 20",
    												"APELLIDO PAT 20",
    												"APELLIDO MAT 20",
    												"01/05/2012",
    												new String[]{"ADM"}, // ROLES
    												"ADMINISTRADOR", // Cargo
    												"71033506" // dni
    			));	     
    }
    
    @Test
    public void createUsuarioUsuarioVacioTest() {
    	Assert.assertFalse(admUsuarios.createUsuario(
    												"   ",
    												"PASWORD20", // Clave de Acceso
    												"PASWORD20", //  Verificacion de Clave
    												"NOMBRES 20",
    												"APELLIDO PAT 20",
    												"APELLIDO MAT 20",
    												"01/05/2012",
    												new String[]{"ADM"}, // ROLES
    												"ADMINISTRADOR", // Cargo
    												"71033506" // dni
    			));	     
    }
        
    @Test
    public void cambiarClaveUsuarioTest(){
    	Assert.assertTrue(admUsuarios.cambiarClaveUsuario("USUARIO01","PASWORD01","NEWCLAVE01","NEWCLAVE01"));
    }
    
    @Test
    public void loginUserTest(){
    	Assert.assertTrue(admUsuarios.loginUser("USUARIO01","PASWORD01"));
    }
    
    @Test
    public void bloquearUsuarioTest(){
    	Assert.assertTrue(admUsuarios.loginUser("USUARIO01", "PASWORD01"));
    	Assert.assertTrue(admUsuarios.bloquearUsuario("USUARIO01"));
    	Assert.assertFalse(admUsuarios.loginUser("USUARIO01", "PASWORD01"));
    }
    
    @Test
    public void desbloquearUsuarioTest(){
    	Assert.assertFalse(admUsuarios.loginUser("USUARIO15", "PASWORD15"));
    	Assert.assertTrue(admUsuarios.desbloquearUsuario("USUARIO15"));
    	Assert.assertTrue(admUsuarios.loginUser("USUARIO15", "PASWORD15"));
    }
    
    @Test
    public void modificarDatosUsuarioTest(){
    	Usuario usr = admUsuarios.getUserByName("USUARIO01");
    	Assert.assertNotSame("Atencion", usr.getCargo());
    	Assert.assertNotSame("12345678", usr.getDni());
    	Assert.assertTrue(admUsuarios.modificarUsuario("USUARIO01",
    													"Nombre Prueba", //nombres
    													"Apellido Prueba",// ap.paterno
    													"Apellido2 Prueba",//ap. materno
    													null,//fec ingreso 
    													null,//roles
    													"Atencion",//cargo
    													"12345678"// nro dni
    													));
    	Assert.assertEquals("Atencion", usr.getCargo());
    	Assert.assertEquals("12345678", usr.getDni());
    	Assert.assertEquals("Nombre Prueba", usr.getNombre());
    	Assert.assertEquals("Apellido Prueba", usr.getApellidoPaterno());
    	Assert.assertEquals("Apellido2 Prueba", usr.getApellidoMaterno());
    }
    
    @Test
    public void modificarDatosErroneosUsuarioTest(){
    	Usuario usr = admUsuarios.getUserByName("USUARIO01");
    	// null = Indica que se mantiene el valor acterior, sin modificarlo
    	// y si se planea blanquearlo enviarle commillas ""
    	Assert.assertFalse(admUsuarios.modificarUsuario("USUARIO01",
    													null, //nombres
    													null,// ap.paterno
    													null,//ap. materno
    													"12/01/20A0",//fec ingreso (ERRONEA) 
    													null,//roles
    													"Atencion",//cargo
    													"assffddd"// nro dni (ERRONEA)
    													));
    	Assert.assertNotSame("Atencion", usr.getCargo());    	
    }
    
    @Test
    public void suprimirUsuarioTest(){
    	int num_usuarios = admUsuarios.getarrUsr().size();
    	Assert.assertEquals(num_usuarios,admUsuarios.getarrUsr().size());
    	Assert.assertTrue(admUsuarios.quitarUsuario("USUARIO01"));
    	// Por el usuario eliminado
    	num_usuarios = num_usuarios - 1 ;
    	Assert.assertEquals(num_usuarios,admUsuarios.getarrUsr().size());
    }
    
    @Test
    public void suprimirUsuarioInexistenteTest(){
    	int num_usuarios = admUsuarios.getarrUsr().size();
    	Assert.assertEquals(num_usuarios,admUsuarios.getarrUsr().size());
    	Assert.assertFalse(admUsuarios.quitarUsuario("USUARIOAAAA"));
    	// Por el usuario eliminado
    	Assert.assertEquals(num_usuarios,admUsuarios.getarrUsr().size());
    }
        

}
