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
import benedictoxvi.pe.datatest.DataBD;
import benedictoxvi.pe.util.Loader;
import benedictoxvi.pe.util.Validaciones;

public class AdmCompraTest {

	ArrayList<Compra> arrCom  = new ArrayList<Compra>();
	AdmCompra admCom = new AdmCompra();
	Compra objCom = new Compra();
	
	
	@Test
	public void cuandoFecEmisionMayorFecPago(){
		
		Assert.assertFalse(admCom.darAltaCompra (
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
		
		Assert.assertTrue(admCom.darAltaCompra( 
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
		Assert.assertFalse(admCom.darAltaCompra(
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
		
		Assert.assertTrue(admCom.darAltaCompra( 
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
		
			admCom.listaCompras();
			
		Assert.assertFalse(admCom.darAltaCompra(
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
		Assert.assertTrue(admCom.encontrarCompras(
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
		Assert.assertTrue(admCom.encontrarCompras(
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

