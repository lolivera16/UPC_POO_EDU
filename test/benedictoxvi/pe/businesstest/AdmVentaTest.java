package benedictoxvi.pe.businesstest;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import benedictoxvi.pe.business.AdmVenta;
import benedictoxvi.pe.data.Compra;
import benedictoxvi.pe.data.Prospecto;
import benedictoxvi.pe.data.Venta;


public class AdmVentaTest {

	AdmVenta objAdmVenta = new AdmVenta();
	ArrayList<Venta> arrVenta  = new ArrayList<Venta>();

	ArrayList<Venta> arrMovimiento  = new ArrayList<Venta>();
	
	@Before
	public void cargarData(){
		cargarCursos();
		cargarCliente();
		cargarMovimientos();		
	}		

	@Test
	public void registrarVentaConBoleta(){
		System.out.println("+----- Listado de Movimientos antes de Registrar Boleta-----+");
		listarMovimientos();
		
		int nroMovimiento = 5; 
		 String CodTipoDocumento = "1";
		 String CodCurso = "C01";
		 String NomCuro;
		 double PreCurso;
		 int CanCurso;
		 String NomEmpleado;
		 String ApeEmpleado;
		 String CodEmpleado;
		
		 String CodCliente = "CL00006";
		 String CodTipCliente;
		 String NroRucCliente;
		 String nomCliente = "Jose Salazar";
		 String ApePatCliente;
		 String ApeMatCliente;
		
		 String FecEmision = "12/12/2012";
 		 String NomEmpresa = "FIRAS EIRL";
		 Double Subtot = 5000.00 ; 
		 Double MonIGV = 900.00 ;
		 Double MonTot = 5900.00 ;
		 String Moneda = "USD";
		 String FecVencim = "10/12/2013";
		 String Estado = "Pagada";
		 String FecPagoReal = "20/12/2012";
		 String Observ = "Sin Observaciones";
		 String concepto = "Pago Matricula del curso POO";
		
		assertTrue(objAdmVenta.registrarPagoConBoleta(arrVenta,
															nroMovimiento, 
															CodTipoDocumento, 
															CodCurso,
															CodCliente,
															nomCliente,
															concepto,															
															FecEmision,
															Subtot,
															MonIGV,
															MonTot,
															Moneda,
															FecVencim,
															Estado,
															FecPagoReal,
															Observ)); 
		//System.out.println(.toString());
		arrMovimiento.add(arrVenta.get(0));
		System.out.println("+----- Listado de Movimientos Despues de Registrar Boleta-----+");
		listarMovimientos();
		System.out.println("");
		
	}
	
	
	@Test
	public void registrarVentaConFactura(){
		System.out.println("+----- Listado de Movimientos antes de Registrar Factura-----+");
		listarMovimientos();
		
		int nroMovimiento = 6; 
		 String CodTipoDocumento = "2";//Factura
		 String CodCurso = "C01";
		 String NomCuro;
		 double PreCurso;
		 int CanCurso;
		 String NomEmpleado;
		 String ApeEmpleado;
		 String CodEmpleado;
		
		 String CodCliente = "CL00005";
		 String CodTipCliente;
		 String NroRucCliente = "41045820790";
		 String nomCliente = "Marco Delgado";
		 String ApePatCliente;
		 String ApeMatCliente;
		
		 String FecEmision = "12/12/2012";
 		 String NomEmpresa = "FIRAS EIRL";
		 Double Subtot = 5000.00 ; 
		 Double MonIGV = 900.00 ;
		 Double MonTot = 5900.00 ;
		 String Moneda = "USD";
		 String FecVencim = "02/12/2013";
		 String Estado = "Pagada";
		 String FecPagoReal = "20/12/2012";
		 String Observ = "Sin Observaciones";
		 String concepto = "Pago Matricula del curso POO";
		
		assertTrue(objAdmVenta.registrarPagoConFactura(arrVenta,
															nroMovimiento, 
															CodTipoDocumento, 
															CodCurso,
															CodCliente,
															nomCliente,
															NroRucCliente,
															concepto,															
															FecEmision,
															Subtot,
															MonIGV,
															MonTot,
															Moneda,
															FecVencim,
															Estado,
															FecPagoReal,
															Observ)); 
		arrMovimiento.add(arrVenta.get(0));
		System.out.println("+----- Listado de Movimientos despues de Registrar Factura-----+");
		listarMovimientos();
		System.out.println("");
		
	}
	
	
	
	
	
	@Test 
	public void listarMovimientos(){			
		//System.out.println("+----- Listado de Movimientos -----+");
				
		ArrayList<Venta> arrlstMovimiento = objAdmVenta.listarMovimientos(arrMovimiento);
		Assert.assertTrue(arrlstMovimiento.size()>=0);		
		System.out.println("");
				
	}
	
	@Test 
	public void listarMovimientosBoleta(){
		System.out.println("+----- Listado de Boletas -----+");
		String codTipoDocumento = "1";
		
		ArrayList<Venta> arrlstMovimiento 
			= objAdmVenta.listarMovimientosTipoDocumento(arrMovimiento, codTipoDocumento);		
		Assert.assertTrue(arrlstMovimiento.size()>=0);
		System.out.println("");
	}
	
	
	@Test 
	public void listarMovimientosFactura(){
		System.out.println("+----- Listado de Facturas -----+");
		String codTipoDocumento = "2";
		
		ArrayList<Venta> arrlstMovimiento 
			= objAdmVenta.listarMovimientosTipoDocumento(arrMovimiento, codTipoDocumento);		
		Assert.assertTrue(arrlstMovimiento.size()>=0);
		System.out.println("");
	}
		
	@Test 
	public void listarDetalleMovimiento(){			
		System.out.println("+----- Detalle de Movimiento -----+");
		int nroMovimiento = 2;		
		ArrayList<Venta> arrlstMovimiento 
					= objAdmVenta.listarDetalleMovimiento(arrMovimiento, nroMovimiento);
		Assert.assertTrue(arrlstMovimiento.size()>=0);		
		System.out.println("");
				
	}
	
	@Test 
	public void listarDetalleMovimientoInexistente(){			
		System.out.println("+----- Detalle de Movimiento Inexistente -----+");
		int nroMovimiento = 6;		
		ArrayList<Venta> arrlstMovimiento 
					= objAdmVenta.listarDetalleMovimiento(arrMovimiento, nroMovimiento);
		Assert.assertTrue(arrlstMovimiento.size()>=0);
		System.out.println("");
		
				
	}
	
	@Test
	public void anularFactura(){
		System.out.println("+----- Anular Factura-----+");
		listarMovimientos();
				
		int nroMovimiento = 4; 
		
		String Estado = "Pagada";
		
		assertTrue(objAdmVenta.anularDocumento(arrMovimiento, nroMovimiento)); 
		
		System.out.println("+----- Listado de Movimientos despues Anular Factura-----+");
		listarMovimientos();
		System.out.println("");
		
	}
	
	public  void cargarCursos(){
		
		List<Venta> olstCurso = new ArrayList<Venta>();
		
		Venta objCurso01 = new Venta();
		objCurso01.setCodCurso("C01");
		objCurso01.setNomCuro("Estructura de Datos");
		objCurso01.setPreCurso(300.0);
		
		Venta objCurso02 = new Venta();
		objCurso02.setCodCurso("C01");
		objCurso02.setNomCuro("Java Aplicaciones Web");
		objCurso02.setPreCurso(500.0);
		
		Venta objCurso03 = new Venta();
		objCurso03.setCodCurso("C03");
		objCurso03.setNomCuro("Implementando Aplicaciones Web");
		objCurso03.setPreCurso(400.0);
		
		olstCurso.add(objCurso01);
		olstCurso.add(objCurso02);
		olstCurso.add(objCurso03);
		
	}
	
	public void cargarCliente(){
		List<Venta> olstCliente = new ArrayList<Venta>();
		
		Venta objCliente01 = new Venta();
		objCliente01.setCodCliente("CL00001");
		objCliente01.setNomCliente("Ricardo");
		objCliente01.setApePatCliente("Falcon");
		objCliente01.setApeMatCliente("Pelaez");
		objCliente01.setCodTipCliente("1");//Persona Natural
		

		Venta objCliente02 = new Venta();
		objCliente02.setCodCliente("CL00002");
		objCliente02.setNomCliente("Juan Manuel");
		objCliente02.setApePatCliente("Vargas");
		objCliente02.setApeMatCliente("Gonzales");
		objCliente02.setCodTipCliente("2");//Persona Jurídica
		
		olstCliente.add(objCliente01);
		olstCliente.add(objCliente02);
		
	}
	
	
void cargarMovimientos(){
		
		Venta objVenta;
		
		int nroMovimiento = 1; 
		 String codTipoDocumento = "2";
		 String codCurso = "C01";
		 
		 String nomCurso;
		 double preCurso;
		 
		 int CanCurso;
		 String NomEmpleado;
		 String ApeEmpleado;
		 String CodEmpleado;
		
		 String codCliente = "CL00001";
		 String codTipCliente;
		 String nroDniCliente = "45820790";
		 String nroRucCliente = "12345820790";
		 String nomCliente = "Juan Manuel Vargas";
		 
		 String ApePatCliente;
		 String ApeMatCliente;
		 String nomEmpresa = "FIRAS EIRL";
		
		 String concepto = "Pago Matricula del curso POO";
		 String fecEmision = "12/12/2012";		 
		 Double subTotal = 5000.00 ; 
		 Double monIGV = 900.00 ;
		 Double monTotal = 5900.00 ;
		 String moneda = "USD";
		 String fecVencim = "30/12/2012";
		 String estado = "Nuevo";
		 String fecPagoReal = "20/12/2012";
		 String observacion = "Sin Observaciones";
		 
		objVenta = new Venta();
		
		objVenta.setNumero(nroMovimiento);
		objVenta.setCodTipoDocumento(codTipoDocumento);
		objVenta.setCodCurso(codCurso);
		objVenta.setCodCliente(codCliente);
		objVenta.setNomCliente(nomCliente);
		objVenta.setNroRucCliente(nroRucCliente);
		objVenta.setConcepto(concepto);
		objVenta.setFecEmision(fecEmision);		
		objVenta.setMonSubtot(subTotal);
		objVenta.setMonIGV(monIGV);
		objVenta.setMonTotal(monTotal);
		objVenta.setMoneda(moneda);
		objVenta.setFecVencim(fecVencim);
		objVenta.setEstado(estado);
		objVenta.setFecPago(fecPagoReal);
		objVenta.setObservacion(observacion);
		
		arrMovimiento.add(objVenta);
		
		  nroMovimiento = 2; 
		  codTipoDocumento = "2";
		  codCurso = "C01";		
		  codCliente = "CL00002";
		  nroDniCliente = "45820791";
		  nroRucCliente = "67845820790";
		  nomCliente = "Luis Jimenez";
		  concepto = "Pago Matricula del curso POO";
		  fecEmision = "13/04/2012";
		  subTotal = 10000.00 ; 
		  monIGV = 1800.00 ;
		  monTotal = 11800.00 ;
		  moneda = "USD";
		  fecVencim = "30/02/2012";
		  estado = "Nuevo";
		  fecPagoReal = "20/12/2012";
		  observacion = "Sin Observaciones";
		 
		 
		objVenta = new Venta();
		
		objVenta.setNumero(nroMovimiento);
		objVenta.setCodTipoDocumento(codTipoDocumento);
		objVenta.setCodCurso(codCurso);
		objVenta.setCodCliente(codCliente);
		objVenta.setNomCliente(nomCliente);
		objVenta.setNroRucCliente(nroRucCliente);
		objVenta.setConcepto(concepto);
		objVenta.setFecEmision(fecEmision);		
		objVenta.setMonSubtot(subTotal);
		objVenta.setMonIGV(monIGV);
		objVenta.setMonTotal(monTotal);
		objVenta.setMoneda(moneda);
		objVenta.setFecVencim(fecVencim);
		objVenta.setEstado(estado);
		objVenta.setFecPago(fecPagoReal);
		objVenta.setObservacion(observacion);
		
		arrMovimiento.add(objVenta);
		
		nroMovimiento = 3;
		codTipoDocumento = "1";
		  codCurso = "C01";		
		  codCliente = "CL00003";
		  nroDniCliente = "45820792";
		  nomCliente = "Manuel Gonzales";
		  concepto = "Pago Matricula del curso POO";
		  fecEmision = "13/04/2012";
		  subTotal = 10000.00 ; 
		  monIGV = 1800.00 ;
		  monTotal = 11800.00 ;
		  moneda = "USD";
		  fecVencim = "19/12/2012";
		  estado = "Nuevo";
		  fecPagoReal = "20/12/2012";
		  observacion = "Sin Observaciones";
		 
		 
		objVenta = new Venta();
		
		objVenta.setNumero(nroMovimiento);
		objVenta.setCodTipoDocumento(codTipoDocumento);
		objVenta.setCodCurso(codCurso);
		objVenta.setCodCliente(codCliente);
		objVenta.setNomCliente(nomCliente);
		objVenta.setNroRucCliente(nroRucCliente);
		objVenta.setConcepto(concepto);
		objVenta.setFecEmision(fecEmision);		
		objVenta.setMonSubtot(subTotal);
		objVenta.setMonIGV(monIGV);
		objVenta.setMonTotal(monTotal);
		objVenta.setMoneda(moneda);
		objVenta.setFecVencim(fecVencim);
		objVenta.setEstado(estado);
		objVenta.setFecPago(fecPagoReal);
		objVenta.setObservacion(observacion);
		
		arrMovimiento.add(objVenta);
		
		nroMovimiento = 4;
		codTipoDocumento = "1";
		  codCurso = "C01";		
		  codCliente = "CL00004";
		  nroDniCliente = "45820792";
		  nomCliente = "Luis Quispe Maita";
		  concepto = "Pago Matricula del curso POO";
		  fecEmision = "13/04/2012";
		  subTotal = 10000.00 ; 
		  monIGV = 1800.00 ;
		  monTotal = 11800.00 ;
		  moneda = "USD";
		  fecVencim = "21/05/2012";
		  estado = "Nuevo";
		  fecPagoReal = "20/12/2012";
		  observacion = "Sin Observaciones";
		 
		 
		objVenta = new Venta();
		
		objVenta.setNumero(nroMovimiento);
		objVenta.setCodTipoDocumento(codTipoDocumento);
		objVenta.setCodCurso(codCurso);
		objVenta.setCodCliente(codCliente);
		objVenta.setNomCliente(nomCliente);
		objVenta.setNroRucCliente(nroRucCliente);
		objVenta.setConcepto(concepto);
		objVenta.setFecEmision(fecEmision);		
		objVenta.setMonSubtot(subTotal);
		objVenta.setMonIGV(monIGV);
		objVenta.setMonTotal(monTotal);
		objVenta.setMoneda(moneda);
		objVenta.setFecVencim(fecVencim);
		objVenta.setEstado(estado);
		objVenta.setFecPago(fecPagoReal);
		objVenta.setObservacion(observacion);
		
		arrMovimiento.add(objVenta);
		
	}
	
	
	
}
