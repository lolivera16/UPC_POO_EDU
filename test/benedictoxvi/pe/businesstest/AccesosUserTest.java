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
	public void requestAccesoTest(){
		String my_user = "USUARIO01";
		Assert.assertTrue(objAcc.requestAcceso(my_user,"CLIENTES").getAcceso());
	}
	
}
