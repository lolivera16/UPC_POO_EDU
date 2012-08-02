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
		System.out.println("+----------+");
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
		System.out.println("+----------+");
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
		admPro.listaProspectos();
		Assert.assertTrue(admPro.deProspectoToCliente( 1001));
		admPro.listaProspectos();
	}
	
	@Test 
	public void darAltaProspectoAClienteExistente(){
		admPro.listaProspectos();
		Assert.assertFalse(admPro.deProspectoToCliente(1005));
		admPro.listaProspectos();
	}
	
	@Test
	public void modificarProspecto(){
		admPro.listaProspectos();
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
		admPro.listaProspectos();
	}
			
	@Test
	public void registrarProspectoTest(){
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
	}
	
	
	@Test
	public void eliminarProspectoTest(){
		int num_pro = 1001;
		System.out.println("+----------+");
		System.out.println("\nCtd.prospectos antes de eliminar : "+arrPro.size());
		Assert.assertTrue(admPro.eliminarProspecto(num_pro));
		System.out.println("Ctd.prospectos luego de eliminar : "+arrPro.size());
	}
	

	public static void main(String[] args){

		
		//System.out.println(("hola").contains("s"));
		
		
	}
	
}
