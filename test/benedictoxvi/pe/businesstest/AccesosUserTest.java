package benedictoxvi.pe.businesstest;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import benedictoxvi.pe.business.AccesosUser;
import benedictoxvi.pe.data.Compra;
import benedictoxvi.pe.data.Usuario;
import benedictoxvi.pe.util.Loader;

public class AccesosUserTest {

	AccesosUser objAcc=  new AccesosUser();
	
	
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
	
}
