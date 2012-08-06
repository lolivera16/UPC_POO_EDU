package benedictoxvi.pe.businesstest;


import junit.framework.Assert;
import org.junit.Test;

import benedictoxvi.pe.business.AdmAccesosUser;


public class AdmAccesosUserTest {

	AdmAccesosUser objAcc=  new AdmAccesosUser();
	
	
	@Test
	public void verificarAccesoCorrectoTest(){
		// Validar que el usuario tiene Acceso al Modulo CLientes
		String my_user = "USUARIO01";
		Assert.assertTrue(objAcc.requestAcceso(my_user,"CLIENTES"));
	}
	
	@Test
	public void verificarAccesoIncorrectoTest(){
		String my_user = "USUARIO02";
		// Validad que el usuario no tiene acceso a este Modulo
		Assert.assertFalse(objAcc.requestAcceso(my_user,"PROSPECTOS"));
	}
	
	@Test
	public void verificarAdicionCorrectoTest(){
		// Validar que el usuario tiene Acceso al Modulo CLientes
		String my_user = "USUARIO01";
		Assert.assertTrue(objAcc.requestAdicion(my_user,"CLIENTES"));
	}
	
	@Test
	public void verificarAdicionIncorrectoTest(){
		String my_user = "USUARIO02";
		// Validad que el usuario no tiene acceso a este Modulo
		Assert.assertFalse(objAcc.requestAdicion(my_user,"PROSPECTOS"));
	}
	
	@Test
	public void verificarModificacionCorrectoTest(){
		// Validar que el usuario tiene Acceso al Modulo CLientes
		String my_user = "USUARIO01";
		Assert.assertTrue(objAcc.requestModificacion(my_user,"CLIENTES"));
	}
	
	@Test
	public void verificarModificacionIncorrectoTest(){
		String my_user = "USUARIO02";
		// Validad que el usuario no tiene acceso a este Modulo
		Assert.assertFalse(objAcc.requestModificacion(my_user,"PROSPECTOS"));
	}
	
	@Test
	public void verificarEliminacionCorrectoTest(){
		// Validar que el usuario tiene Acceso al Modulo CLientes
		String my_user = "USUARIO01";
		Assert.assertTrue(objAcc.requestEliminacion(my_user,"CLIENTES"));
	}
	
	@Test
	public void verificarEliminacionIncorrectoTest(){
		String my_user = "USUARIO02";
		// Validad que el usuario no tiene acceso a este Modulo
		Assert.assertFalse(objAcc.requestEliminacion(my_user,"PROSPECTOS"));
	}
	
	@Test
	public void rolesByUserTest(){
		// Obtiene la cantidad de Roles que tiene actualmente el Usuario
		Assert.assertEquals(2,objAcc.rolesByUser("USUARIO02").size());
	}
	
	@Test
	public void modulosByRolTest(){
		// Obtiene la Cantidad de Modulos contenidos en el Rol
		Assert.assertEquals(5,objAcc.modulosByRol("ADM").size());
	}
	
	@Test
	public void addRolUserTest(){
		// Agregar un Rol al Usuario
		Assert.assertEquals(2,objAcc.rolesByUser("USUARIO02").size());
		Assert.assertTrue(objAcc.addRolUser("USUARIO02","ADM"));
		Assert.assertEquals(3,objAcc.rolesByUser("USUARIO02").size());
	}
	
	@Test
	public void addRolUserRepetidoTest(){
		Assert.assertEquals(2,objAcc.rolesByUser("USUARIO02").size());
		Assert.assertFalse(objAcc.addRolUser("USUARIO01","ADM"));
		Assert.assertEquals(2,objAcc.rolesByUser("USUARIO02").size());
	}
	
	@Test
	public void removeRolUserTest(){
		Assert.assertEquals(1,objAcc.rolesByUser("USUARIO04").size());
		Assert.assertTrue(objAcc.removeRolUser("USUARIO04","VTAS"));
		Assert.assertEquals(0,objAcc.rolesByUser("USUARIO04").size());
	}
	
	@Test
	public void removeRolInexistenteUserTest(){
		Assert.assertEquals(1,objAcc.rolesByUser("USUARIO04").size());
		Assert.assertFalse(objAcc.removeRolUser("USUARIO04","ADM"));
		Assert.assertEquals(1,objAcc.rolesByUser("USUARIO04").size());
	}
	
	@Test
	public void checkAddRolAccessUser(){
		// Intenta acceder al Modulo de Prospectos, PERO NO TIENE EL ROL PROSP
		Assert.assertFalse(objAcc.requestAcceso("USUARIO02","PROSPECTOS"));
		Assert.assertTrue(objAcc.addRolUser("USUARIO02","PROSP"));
		Assert.assertTrue(objAcc.requestAcceso("USUARIO02","PROSPECTOS"));
	}
	
}
