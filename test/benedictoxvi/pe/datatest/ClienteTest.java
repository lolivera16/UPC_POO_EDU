package benedictoxvi.pe.datatest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import benedictoxvi.pe.data.Cliente;

public class ClienteTest {
	
	Cliente objCli = new Cliente();
	
	@Before
	public void contruct__(){
		objCli.setNomCliente("Jose Luis");
		objCli.setApePatCliente("Guzman");
		objCli.setApeMatCliente("Perez");
		objCli.setDniCliente(346578);
		objCli.setFonCliente(7665456);
		objCli.setFecConCliente("12/07/2012");
		objCli.setEmaCliente("jguzman@hotmail.com");
	}
	
	@Test
	public void registrarCliente(){
		assertEquals("Jose Luis",objCli.getNomCliente());
		assertEquals("Guzman",objCli.getApePatCliente());
		assertEquals("Perez",objCli.getApeMatCliente());
		assertEquals(346578,objCli.getDniCliente());
		assertEquals(7665456,objCli.getFonCliente());
		assertEquals("12/07/2012",objCli.getFecConCliente());
		assertEquals("jguzman@hotmail.com",objCli.getEmaCliente());
	}
	
	

}
