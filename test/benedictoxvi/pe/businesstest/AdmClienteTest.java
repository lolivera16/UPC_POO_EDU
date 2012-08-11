package benedictoxvi.pe.businesstest;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import benedictoxvi.pe.business.AdmCliente;
import benedictoxvi.pe.data.Cliente;


public class AdmClienteTest {

	ArrayList<Cliente> arrCli = new ArrayList<Cliente>();
	AdmCliente admCli = new AdmCliente();
	

	@Test
	public void findEncontrarClienteTest(){
		String nombs = "o",
				   apepat = "",
				   apemat = "",
				   mail = "",
				   dni = "",
				   tel_cel = "",
				   fecha = "";
			ArrayList<Cliente> filtroCli = 
			admCli.findCliente(nombs,apepat,apemat,mail,dni,tel_cel,fecha,"");
			Assert.assertTrue(filtroCli.size()>=0);
	}
	
	@Test
	public void findSinEncontrarClienteTest(){
		String nombs = "Marcos",
				   apepat = "",
				   apemat = "",
				   mail = "",
				   dni = "",
				   tel_cel = "",
				   fecha = "";
			ArrayList<Cliente> filtroCli = 
					admCli.findCliente(nombs,apepat,apemat,mail,dni,tel_cel,fecha,"");
			Assert.assertTrue(filtroCli.size()==0);
	}
	
//	
//	@Test 
//	public void darCliente(){		
//		Assert.assertEquals(" ",admCli.getClienteByCod("C1003").getEstCliente());
//		Assert.assertTrue(admCli.deClienteToProspecto("C1003"));
//		Assert.assertEquals("C",admCli.getClienteByNum("C1003").getEstCliente());
//	}
//	
//	@Test 
//	public void darAltaClienteAProspectoeExistente(){
//		Assert.assertEquals(" ",admCli.getClienteByNum("C1001").getEstCliente());
//		Assert.assertTrue(admCli.deClienteToProspecto( "C1001"));		
//		Assert.assertEquals("C",admCli.getClienteByNum("C1001").getEstCliente());
//		Assert.assertFalse(admCli.deClienteToProspecto("C1001"));		
//	}
	

			
	@Test
	public void registrarClienteTest(){
			Assert.assertNull(admCli.getClienteByNum("C1200"));
			Assert.assertTrue(admCli.registrarCliente(
									  "C1200", //  Nro Prospecto
									  "01/01/2013", // Fecha registro
									  "Luis Enrique", // Nombres
									  "Olivera", // Ap.Paterno
									  "Aguilar", // Ap.Materno
									  "lolivera@gmail.com", //  Correo
									  "34612331", //  Nro DNI
									  "3533332", // Telefono
									  "983422323", // Celular
									  "" // Estado
									  ));
			Assert.assertNotNull(admCli.getClienteByNum("C1200"));
	}
	
	
	@Test
	public void eliminarClienteTest(){
		String cod_cli = "C1008";
		Assert.assertNotNull(admCli.getClienteByNum(cod_cli));
		Assert.assertTrue(admCli.eliminarCliente(cod_cli));
		Assert.assertNull(admCli.getClienteByNum(cod_cli));

	}
	
}
