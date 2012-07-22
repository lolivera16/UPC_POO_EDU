package benedictoxvi.pe.businesstest;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import benedictoxvi.pe.business.AdmCompra;
import benedictoxvi.pe.data.Compra;
import benedictoxvi.pe.util.Loader;

public class AdmCompraTest {

	ArrayList<Compra> arrCom  = new ArrayList<Compra>();
	AdmCompra admCom = new AdmCompra();
	
	public AdmCompraTest() {
		// TODO Auto-generated constructor stub
	}
	
	@Before
	public  void bcLoadComprasTXT(){
		
		//Compra 1	50001	01/11/2012	Empresa 1	3841,83	691,53	4533,36	USD	01/12/2012	Nuevo	19/11/2012	Observaciones de Compra 1
		Loader objLoa = new Loader();
		Compra objCom = new Compra();
		String url = objLoa.getClass().getResource("../bd/compras.txt").getFile();	
		ArrayList<String[]> lisPro = objLoa.getDataTxt(url);
		for(String[] row : lisPro){			
			 objCom = new Compra();
			 objCom.setConcepto(row[0]);
			 objCom.setNumero(Integer.parseInt(row[1]));
			 objCom.setFecEmision(row[2]);
			 objCom.setNomEmpresa(row[3]);
			 objCom.setMonSubtot(Double.parseDouble(row[4]));
			 objCom.setMonIGV(Double.parseDouble(row[5]));
			 objCom.setMonTotal(Double.parseDouble(row[6]));
			 objCom.setMoneda(row[7]);
			 objCom.setFecVencim(row[8]);
			 objCom.setEstado(row[9]);
			 objCom.setFecPago(row[10]);
			 objCom.setObservacion(row[11]);
			 arrCom.add(objCom);
			
		}
	}
	
	@Test
	public void findEncontrarComprasTest(){
		ArrayList<Compra> filtroCom = new ArrayList<Compra>();
		String concepto = "";
		int numero = 0 ;
		String fec_emision = "";
		String nom_empresa = "";
		String fec_venc = "";
		String fec_pago = "";
		String estado = "";
		
		// Tamano del arrayList debe ser mayor a cero
		filtroCom = admCom.findCompras(arrCom,concepto,numero,fec_emision,nom_empresa,fec_venc,fec_pago,estado);
		Assert.assertTrue(filtroCom.size() > 0);
	}
	
	@Test
	public void darAltaCompraTest(){
		
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
		Assert.assertTrue(admCom.darAltaCompra (arrCom, 
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
	
	public static void main(String[] args) {
		//new AdmCompraTest().bcLoadComprasTXT();
		
	}
	
}
