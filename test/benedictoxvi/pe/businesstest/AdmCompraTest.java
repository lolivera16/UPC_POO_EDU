package benedictoxvi.pe.businesstest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import benedictoxvi.pe.data.Compra;

public class AdmCompraTest {

	ArrayList<Compra> arrCom  = new ArrayList<Compra>();
	AdmCompra admCom = new AdmCompra();
	
	@Test
	public void darAltaCompra(){
		
		String concepto = "Suministro";
		int numero = 40001;
		String FecEmision = "12/12/2012";
		String NomEmpresa = "FIRAS EIRL";
		Double Subtot = 4050.00 ; 
		Double MonIGV = 729.00 ;
		Double MonTot = 5229.00 ;
		String Moneda = "USD";
		String FecVencim = "30/12/2012";
		String Estado = "Nuevo";
		String FecPagoReal = "20/12/2012";
		String Observ = "Sin Observaciones";
		//admCom.darAltaCompraTest(arrCom, concepto, numero, fecEmision, nomEmpresa, subtot, monIGV, monTot, moneda, fecVencim, estado, fecPagoReal, observ)
		Assert.assertTrue(admCom.darAltaCompraTest (arrCom, 
													concepto,
													numero,
													FecEmision,
													NomEmpresa,
													Subtot,
													MonIGV,
													MonTot,
													Moneda,
													FecVencim,
													Estado,
													FecPagoReal,
													Observ
													));
	}
	
}
