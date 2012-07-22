package benedictoxvi.pe.datatest;

import org.junit.Assert;
import org.junit.Test;

import benedictoxvi.pe.data.Compra;



public class CompraTest {	
	
	@Test
	public void testDataCompra(){
		
		Compra objCom = new Compra();
		objCom.setConcepto("Suministro");
		objCom.setNumero(3545);
		objCom.setFecEmision("01/12/2012");
		objCom.setNomEmpresa("Los Deudores SAC");
		objCom.setEstado("Nuevo");
		objCom.setFecPago("10/12/2012");
		objCom.setFecVencim("15/12/2012");
		objCom.setMonSubtot(100.00);
		objCom.setMonIGV(18.00);
		objCom.setMonTotal(118.00);
		objCom.setObservacion("No existen observaciones");
		
		Assert.assertArrayEquals(
			
			new Object[]{"Suministro",
			3545,
			"01/12/2012",
			"Los Deudores SAC",
			"Nuevo",
			"10/12/2012",
			"15/12/2012",
			100.00,
			18.00,
			118.00,	
			"No existen observaciones"
			},
			
			new Object[]{
			objCom.getConcepto(),
			objCom.getNumero(),
			objCom.getFecEmision(),
			objCom.getNomEmpresa(),
			objCom.getEstado(),
			objCom.getFecPago(),
			objCom.getFecVencim(),
			objCom.getMonSubtot(),
			objCom.getMonIGV(),
			objCom.getMonTotal(),
			objCom.getObservacion()
			}
			
			);
	
		
		// Una 2da Compra
		objCom = new Compra(); // reinicializar el Objeto
		objCom.setConcepto("Accesorios de Computo");
		objCom.setNumero(3546);
		objCom.setFecEmision("01/01/2013");
		objCom.setNomEmpresa("Developers EIRL");
		objCom.setEstado("Cancelada");
		objCom.setFecPago("15/01/2013");
		objCom.setFecVencim("24/01/2013");
		objCom.setMonSubtot(300.00);
		objCom.setMonIGV(54.00);
		objCom.setMonTotal(354.00);
		objCom.setObservacion("No se consiguio el presupuesto");
		
		Assert.assertEquals("Accesorios de Computo",objCom.getConcepto());
		Assert.assertEquals(3546,objCom.getNumero());
		Assert.assertEquals("01/01/2013",objCom.getFecEmision());
		Assert.assertEquals("Developers EIRL",objCom.getNomEmpresa());
		Assert.assertEquals("Cancelada",objCom.getEstado());
		Assert.assertEquals("15/01/2013",objCom.getFecPago());
		Assert.assertEquals("24/01/2013",objCom.getFecVencim());
		Assert.assertEquals(300.00,objCom.getMonSubtot(),0);
		Assert.assertEquals(54.00,objCom.getMonIGV(),0);
		Assert.assertEquals(354.00,objCom.getMonTotal(),0);	
		Assert.assertEquals("No se consiguio el presupuesto",objCom.getObservacion());
			

	}
}

