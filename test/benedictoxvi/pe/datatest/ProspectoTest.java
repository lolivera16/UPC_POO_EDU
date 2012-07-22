package benedictoxvi.pe.datatest;

import org.junit.Assert;
import org.junit.Test;

import benedictoxvi.pe.data.Prospecto;

public class ProspectoTest {

	
	@Test
	public void testDataProspecto(){

		Prospecto objPro = new Prospecto();
		objPro.setNumProspecto(1);
		objPro.setFecProspecto("01/01/2013");
		objPro.setNombes("Luis Enrique");
		objPro.setApePaterno("Olivera");
		objPro.setApeMaterno("Aguilar");
		objPro.setCorreo("lolivera@gmail.com");
		objPro.setNroDNI("71033506");
		objPro.setTelefono("3533332");		
		objPro.setCelular("983422323");
		objPro.setEstado("");
		
		// Assert del Primer Prospecto
		Assert.assertEquals(1,objPro.getNumProspecto(),0);
		Assert.assertEquals("01/01/2013",objPro.getFecProspecto());
		Assert.assertEquals("Luis Enrique",objPro.getNombes());
		Assert.assertEquals("Olivera",objPro.getApePaterno());
		Assert.assertEquals("Aguilar",objPro.getApeMaterno());
		Assert.assertEquals("lolivera@gmail.com",objPro.getCorreo());
		Assert.assertEquals("71033506",objPro.getNroDNI());
		Assert.assertEquals("3533332",objPro.getTelefono());
		Assert.assertEquals("983422323",objPro.getCelular());
		Assert.assertEquals("",objPro.getEstado());
		
		
		// Segundo Objeto Prospecto
		objPro = new Prospecto(); // Reinicializar el objeto
		objPro.setNumProspecto(2);
		objPro.setFecProspecto("31/12/2012");
		objPro.setNombes("Karol");
		objPro.setApePaterno("Vargas");
		objPro.setApeMaterno("Cancho");
		objPro.setCorreo("kvargas@gmail.com");
		objPro.setNroDNI("54334431");
		objPro.setTelefono("5873456");		
		objPro.setCelular("987183223");
		objPro.setEstado("X");
		
		// Assert del Primer Prospecto
		Assert.assertEquals(2,objPro.getNumProspecto(),0);
		Assert.assertEquals("31/12/2012",objPro.getFecProspecto());
		Assert.assertEquals("Karol",objPro.getNombes());
		Assert.assertEquals("Vargas",objPro.getApePaterno());
		Assert.assertEquals("Cancho",objPro.getApeMaterno());
		Assert.assertEquals("kvargas@gmail.com",objPro.getCorreo());
		Assert.assertEquals("54334431",objPro.getNroDNI());
		Assert.assertEquals("5873456",objPro.getTelefono());
		Assert.assertEquals("987183223",objPro.getCelular());
		Assert.assertEquals("X",objPro.getEstado());


	}
}
