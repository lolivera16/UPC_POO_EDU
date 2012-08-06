package benedictoxvi.pe.businesstest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import benedictoxvi.pe.business.AdmRoles;
import benedictoxvi.pe.data.Modulo;
import benedictoxvi.pe.data.Rol;

public class AdmRolTest {
	
	
	AdmRoles admRol = new AdmRoles();
	ArrayList<Modulo> arrMod = new ArrayList<Modulo>();
	Modulo modVentas = new Modulo("VENTAS", true, true, true, true);
	Modulo modCompras = new Modulo("COMPRAS", true, true, true, true);
	Modulo modClientes = new Modulo("CLIENTESS", true, true, true, true);
	Modulo modProspectos = new Modulo("PROSPECTOS", true, true, true, true);
	
	private Rol rolActual;

	@Before
	public void cargarModulos(){

		arrMod.add(new Modulo("PROSPECTOS", true, true, true, true));
		arrMod.add(new Modulo("CLIENTESS", true, true, true, true));
		arrMod.add(new Modulo("USUARIOS", true, true, true, true));
	}
	
    
    @Test
    public void crearRolConModulosTest(){
    	ArrayList<Modulo> mods = new ArrayList<Modulo>();
    	mods.add(modProspectos);
    	mods.add(modCompras);
    	Assert.assertTrue(admRol.registrarRol(
    			"NEW_ROL", // Identificador del ROL
    			"Rol de Administracion", //Descripcion del Rol 
    			 mods// Modulos contenidos en el Rol
    			));
    }
    
    @Test
    public void crearRolConModulosErroneosTest(){
    	ArrayList<Modulo> mods = new ArrayList<Modulo>();
    	mods.add(modProspectos);
    	// Agregar el Rol Inconsistente
    	mods.add(modClientes);
    	mods.add(modCompras);
    	Assert.assertFalse(admRol.registrarRol(
    			"NEW_ROL", // Identificador del ROL
    			"Rol de Administracion", //Descripcion del Rol 
    			 mods// Modulos contenidos en el Rol
    			));
    }
    
    @Test
    public void crearRolConDatosVaciosErroneosTest(){
    	ArrayList<Modulo> mods = new ArrayList<Modulo>();
    	mods.add(modProspectos);
    	Assert.assertFalse(admRol.registrarRol(
    			"NEW_", // Identificador del ROL (longitud minima 6)
    			"Rol de Administracion", //Descripcion del Rol 
    			 mods// Modulos contenidos en el Rol
    			));
    }
    
    @Test
    public void crearRolSinModulosTest(){
    	ArrayList<Modulo> mods = new ArrayList<Modulo>();
    	Assert.assertTrue(admRol.registrarRol(
    			"NEW_ROL", // Identificador del ROL (longitud minima 6)
    			"Rol de Administracion", //Descripcion del Rol 
    			 mods// Modulos contenidos en el Rol
    			));
    }
    
    @Test
    public void modificarRolTest(){
    	ArrayList<Modulo> mods = new ArrayList<Modulo>();
    	//Vamos a quitarle los modulos existentes al Rol
    	Assert.assertTrue(admRol.modificarRol(
    			"SECUR", // Identificador del ROL (longitud minima 6)
    			"Nuevo Nombre", //Descripcion del Rol 
    			 mods// Modulos contenidos en el Rol
    			));
    }
    
    @Test
    public void suprimirRolTest(){
    	int num_roles  = admRol.getRoles().size();    	
    	Assert.assertTrue(admRol.suprimirRol(
    			"SECUR" // Identificador del ROL (longitud minima 6)    			
    			));
    	// Quitando 1 por el rol que se esta eliminando
    	num_roles = num_roles -1;
    	Assert.assertEquals(num_roles, admRol.getRoles().size());
    }
    
    @Test
    public void suprimirRolConUsuariosTest(){
    	int num_roles  = admRol.getRoles().size();    	
    	Assert.assertFalse(admRol.suprimirRol(
    			"VTAS" // Identificador del ROL (longitud minima 6)    			
    			));    	
    	Assert.assertEquals(num_roles, admRol.getRoles().size());
    }
    
    @Test
    public void verificarExistenciaRolTest(){
    	Assert.assertNotNull(admRol.findModuloByIdent("VENTAS"));
    }
    
    @Test
    public void verificarInexistenciaRolTest(){
    	Assert.assertNull(admRol.findModuloByIdent("VENTAS_MAL"));
    }   

}
