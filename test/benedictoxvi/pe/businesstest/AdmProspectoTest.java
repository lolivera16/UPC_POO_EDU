package benedictoxvi.pe.businesstest;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import benedictoxvi.pe.business.AdmProspecto;
import benedictoxvi.pe.data.Prospecto;
import benedictoxvi.pe.util.Loader;

public class AdmProspectoTest {

	ArrayList<Prospecto> arrPro = new ArrayList<Prospecto>();
	AdmProspecto admPro = new AdmProspecto();
	

	@Test
	public void findEncontrarProspectoTest(){
		String nombs = "u",
				   apepat = "",
				   apemat = "",
				   mail = "",
				   dni = "",
				   tel_cel = "",
				   fecha = "";
			ArrayList<Prospecto> filtroPro = 
					admPro.findProspecto(nombs,apepat,apemat,mail,dni,tel_cel,fecha,"");
			Assert.assertTrue(filtroPro.size()>=0);
	}
	
	@Test
	public void findSinEncontrarProspectoTest(){
		String nombs = "Marcos",
				   apepat = "",
				   apemat = "",
				   mail = "",
				   dni = "",
				   tel_cel = "",
				   fecha = "";
			ArrayList<Prospecto> filtroPro = 
					admPro.findProspecto(nombs,apepat,apemat,mail,dni,tel_cel,fecha,"");
			Assert.assertTrue(filtroPro.size()==0);
	}
	
	
	@Test 
	public void darAltaProspecto(){		
		Assert.assertEquals(" ",admPro.getProspectoByNum(1003).getEstado());
		Assert.assertTrue(admPro.deProspectoToCliente( 1003));
		Assert.assertEquals("C",admPro.getProspectoByNum(1003).getEstado());
	}
	
	@Test 
	public void darAltaProspectoAClienteExistente(){
		//System.out.println(admPro.getProspectoByNum(1005).getEstado());
		Assert.assertEquals(" ",admPro.getProspectoByNum(1001).getEstado());
		Assert.assertTrue(admPro.deProspectoToCliente( 1001));		
		Assert.assertEquals("C",admPro.getProspectoByNum(1001).getEstado());
		Assert.assertFalse(admPro.deProspectoToCliente(1001));		
	}
	
	@Test
	public void modificarProspecto(){
		//admPro.listaProspectos();		
		Assert.assertNotSame("Enrique Luis", admPro.getProspectoByNum(1000).getNombes());
		Assert.assertTrue(admPro.modifcarProspecto(
				  1000, //  Nro Prospecto
				  null, // Fecha registro
				  "Enrique Luis", // Nombres
				  "Aguilar", // Ap.Paterno
				  "Olivera", // Ap.Materno
				  null, //  Correo
				  null, //  Nro DNI
				  null, // Telefono
				  null, // Celular
				  null // Estado
				  ));
		Assert.assertEquals("Enrique Luis", admPro.getProspectoByNum(1000).getNombes());
		//admPro.listaProspectos();
	}
			
	@Test
	public void registrarProspectoTest(){
			Assert.assertNull(admPro.getProspectoByNum(1));
			Assert.assertTrue(admPro.registrarProspecto(
									  1, //  Nro Prospecto
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
			Assert.assertNotNull(admPro.getProspectoByNum(1));
	}
	
	
	@Test
	public void eliminarProspectoTest(){
		int num_pro = 1001;
		Assert.assertNotNull(admPro.getProspectoByNum(num_pro));
		Assert.assertTrue(admPro.eliminarProspecto(num_pro));
		Assert.assertNull(admPro.getProspectoByNum(num_pro));

	}
	
	
}
