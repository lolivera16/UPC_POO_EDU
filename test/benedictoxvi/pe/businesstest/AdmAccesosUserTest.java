package benedictoxvi.pe.businesstest;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import benedictoxvi.pe.business.AdmAccesosUser;
import benedictoxvi.pe.data.Compra;
import benedictoxvi.pe.data.Usuario;
import benedictoxvi.pe.util.Loader;

public class AdmAccesosUserTest {

	AdmAccesosUser objAcc=  new AdmAccesosUser();
	
	
	@Test
	public void requestAccesoCorrectoTest(){
		String my_user = "USUARIO01";
		Assert.assertTrue(objAcc.requestAcceso(my_user,"CLIENTES").getAcceso());
	}
	
	@Test
	public void requestAccesoIncorrectoTest(){
		String my_user = "USUARIO02";
		Assert.assertFalse(objAcc.requestAcceso(my_user,"PROSPECTOS").getAcceso());
	}
	
	@Test
	public void rolesByUserTest(){
		Assert.assertEquals(2,objAcc.rolesByUser("USUARIO02").size());
	}
	
	@Test
	public void modulosByRolTest(){
		Assert.assertEquals(5,objAcc.modulosByRol("ADM").size());
	}
	
	@Test
	public void addRolUserTest(){
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
		Assert.assertFalse(objAcc.requestAcceso("USUARIO02","PROSPECTOS").getAcceso());
		Assert.assertTrue(objAcc.addRolUser("USUARIO02","PROSP"));
		Assert.assertTrue(objAcc.requestAcceso("USUARIO02","PROSPECTOS").getAcceso());
	}
	
}
