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
	
	@Before
	public void bcLoadProspectosTXT(){
		
		//1000	01/01/2012	Olivera	Reyes	Luis	LOlivera@gmail.com	32432432	12124324	3324324	P
		Loader objLoa = new Loader();
		Prospecto objPro = null;
		String url = objLoa.getClass().getResource("../bd/Prospectos.txt").getFile();			
		ArrayList<String[]> lisPro = objLoa.getDataTxt(url);
		for(String[] row : lisPro){
			 objPro = new Prospecto();
			 objPro.setNumProspecto(Integer.parseInt(row[0]));
				objPro.setFecProspecto(row[1]);				
				objPro.setApePaterno(row[2]);
				objPro.setApeMaterno(row[3]);
				objPro.setNombes(row[4]);
				objPro.setCorreo(row[5]);
				objPro.setNroDNI(row[6]);
				objPro.setTelefono(row[7]);		
				objPro.setCelular(row[8]);
				objPro.setEstado(row[9]);
				arrPro.add(objPro);
		}
	}
	
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
					admPro.findProspecto(arrPro,nombs,apepat,apemat,mail,dni,tel_cel,fecha);
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
					admPro.findProspecto(arrPro,nombs,apepat,apemat,mail,dni,tel_cel,fecha);
			Assert.assertTrue(filtroPro.size()==0);
	}
	
	@Test 
	public void darAltaProspecto(){
		
	}
			
	@Test
	public void registrarProspectoTest(){
		System.out.println("+----------+");
			int num_pro = 1;
			String fecha=("01/01/2013");
			String nombs=("Luis Enrique");
			String apepat=("Olivera");
			String apemat=("Aguilar");
			String mail=("lolivera@gmail.com");
			String dni=("71033506");
			String telefono=("3533332");		
			String celular=("983422323");
			String estado=("");
			Assert.assertTrue(admPro.registrarProspecto(num_pro,
									  fecha,
									  nombs,
									  apepat,
									  apemat,
									  mail,
									  dni,
									  telefono,
									  celular,
									  estado));
	}
	
	@Test
	public void eliminarProspectoTest(){
		int num_pro = 1001;
		System.out.println("+----------+");
		System.out.println("\nCtd.prospectos antes de eliminar : "+arrPro.size());
		Assert.assertTrue(admPro.eliminarProspecto(arrPro,num_pro));
		System.out.println("Ctd.prospectos luego de eliminar : "+arrPro.size());
	}
	

	public static void main(String[] args){
		AdmProspectoTest testAdm = new AdmProspectoTest();
		testAdm.bcLoadProspectosTXT();
		
		//System.out.println(("hola").contains("s"));
		
		
	}
	
}
