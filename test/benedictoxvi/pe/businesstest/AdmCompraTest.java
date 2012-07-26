package benedictoxvi.pe.businesstest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import benedictoxvi.pe.business.AdmCompra;
import benedictoxvi.pe.data.Compra;
import benedictoxvi.pe.util.Loader;
import benedictoxvi.pe.util.Validaciones;

public class AdmCompraTest {

	ArrayList<Compra> arrCom  = new ArrayList<Compra>();
	AdmCompra admCom = new AdmCompra();
	Compra objCom = new Compra();
	
	@Before
	public void bcLoadComprasTXT(){
		//Compra 1	50001	01/11/2012	Empresa 1	3841,83	691,53	4533,36	USD	01/12/2012	Nuevo	19/11/2012	Observaciones de Compra 1
		Loader objLoa = new Loader();
		Compra objPro = null;
		String url = objLoa.getClass().getResource("../bd/compras.txt").getFile();			
		ArrayList<String[]> lisPro = objLoa.getDataTxt(url);
		for(String[] row : lisPro){
			 objPro = new Compra();
			 objPro.setConcepto(row[0]);
			 objPro.setNumero(Integer.parseInt(row[1]));
			 objPro.setFecEmision(row[2]);
			 objPro.setNomEmpresa(row[3]);
			 objPro.setMonSubtot(Double.parseDouble(row[4]));
			 objPro.setMonIGV(Double.parseDouble(row[5]));
			 objPro.setMonTotal(Double.parseDouble(row[6]));
			 objPro.setMoneda(row[7]);
			 objPro.setFecVencim(row[8]);
			 objPro.setEstado(row[9]);
			 objPro.setFecPago(row[10]);
			 objPro.setObservacion(row[11]);
			 arrCom.add(objPro);
		}
/*		admCom.listaCompras(arrCom);
		Collections.sort(arrCom, new CompraComparator());
		admCom.listaCompras(arrCom);*/
	}
	
	
	@Test
	public void cuandoFecEmisionMayorFecPago(){
		
		Assert.assertFalse(admCom.darAltaCompra (arrCom, 
				 "Suministro", // Concepto
				40001, // Num.Compra
				"12/12/2012", // Fecha Emision
				"FIRAS EIRL", // NomEmpresa
				4050.00, // Subtoal
				729.00, // Monto IGV
				5229.00, // Monto Total
				"USD", // Moneda Compra
				"30/12/2012", // fecVencimiento
				"Nuevo", // Estado Compra
				 "10/12/2012", // FecPagoReal
				 "Sin Observaciones" // Observaciones
				));
	}
	
	@Test
	public void darAltaCompra(){
		
		Assert.assertTrue(admCom.darAltaCompra(arrCom, 
				 "Suministro", // Concepto *
				40001, // Num.Compra
				"12/12/2012", // Fecha Emision *
				"FIRAS EIRL", // NomEmpresa
				4050.00, // Subtoal *
				729.00, // Monto IGV *
				5229.00, // Monto Total *
				"USD", // Moneda Compra *
				"30/12/2012", // fecVencimiento *
				"Nuevo", // Estado Compra
				 "17/12/2012", // FecPagoReal
				 "Sin Observaciones" // Observaciones
				));
	}
	
	
	@Test
	public void cuandoRegistramosSinLosValoresObligatorios(){
		// valores obligatorios 
		// Concepto, fec.Emision, fecha.vencimiento, Subtotal,Igv,Total,Moneda
		Assert.assertFalse(admCom.darAltaCompra(arrCom, 
				 null, // Concepto *
				40001, // Num.Compra
				"12/12/2012", // Fecha Emision *
				"FIRAS EIRL", // NomEmpresa
				4050.00, // Subtoal *
				729.00, // Monto IGV *
				5229.00, // Monto Total *
				"USD", // Moneda Compra *
				"30/12/2012", // fecVencimiento *
				"Nuevo", // Estado Compra
				 "17/12/2012", // FecPagoReal
				 "Sin Observaciones" // Observaciones
				));
	}
	
	@Test
	public void cuandoRegistroCompraMismoNumero(){
		Assert.assertTrue(admCom.darAltaCompra(arrCom, 
				 "Suministro", // Concepto *
				40001, // Num.Compra
				"12/12/2012", // Fecha Emision *
				"FIRAS EIRL", // NomEmpresa
				4050.00, // Subtoal *
				729.00, // Monto IGV *
				5229.00, // Monto Total *
				"USD", // Moneda Compra *
				"30/12/2012", // fecVencimiento *
				"Nuevo", // Estado Compra
				 "17/12/2012", // FecPagoReal
				 "Sin Observaciones" // Observaciones
				));
		admCom.listaCompras(arrCom);
		Assert.assertFalse(admCom.darAltaCompra(arrCom, 
				 "Suministro 2", // Concepto *
				40001, // Num.Compra
				"12/12/2012", // Fecha Emision *
				"FIRAS EIRL", // NomEmpresa
				4050.00, // Subtoal *
				729.00, // Monto IGV *
				5229.00, // Monto Total *
				"USD", // Moneda Compra *
				"30/12/2012", // fecVencimiento *
				"Nuevo", // Estado Compra
				 "17/12/2012", // FecPagoReal
				 "Sin Observaciones" // Observaciones
				));
	}
	
	@Test
	public void buscarEncontrarCompras(){
		Assert.assertTrue(admCom.encontrarCompras(arrCom,
											      "Compra", //Concepto
												  0, // Num.Compra
												  "", // Fecha de Emision
												  "", // Empresa
												  "", // Fec.vencimiento
												  "", // Fec.Pago
												  "" // Estado 
				).size() > 0);
	}
	
	@Test
	public void buscarSinEncontrarCompras(){
		Assert.assertTrue(admCom.encontrarCompras(arrCom,
											      "Accesorios", //Concepto
												  0, // Num.Compra
												  "", // Fecha de Emision
												  "", // Empresa
												  "", // Fec.vencimiento
												  "", // Fec.Pago
												  "" // Estado 
				).size() == 0);
	}
}

