package benedictoxvi.pe.businesstest;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import benedictoxvi.pe.business.AdmVenta;
import benedictoxvi.pe.data.Compra;
import benedictoxvi.pe.data.Venta;


public class AdmVentaTest {

	AdmVenta objAdmVenta = new AdmVenta();
	ArrayList<Venta> arrVenta  = new ArrayList<Venta>();

	@Before
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
	
	
	@Test
	public void registrarVentaConBoleta(){
		int nroMovimiento = 1; 
		 String CodTipoDocumento = "1";
		 String CodCurso = "C01";
		 String NomCuro;
		 double PreCurso;
		 int CanCurso;
		 String NomEmpleado;
		 String ApeEmpleado;
		 String CodEmpleado;
		
		 String CodCliente = "CL00001";
		 String CodTipCliente;
		 String NroRucCliente;
		 String NomCliente = "Juan Manuel Vargas";
		 String ApePatCliente;
		 String ApeMatCliente;
		
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
		 String concepto = "Pago Matricula";
		
		assertTrue(objAdmVenta.registrarPagoConBoleta(arrVenta,
															nroMovimiento, 
															CodTipoDocumento, 
															CodCurso,
															CodCliente,
															NomCliente,
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
													
		
		
	}
	
	
	
	
}
