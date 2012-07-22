package benedictoxvi.pe.businesstest;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import benedictoxvi.pe.business.AdmProspecto;
import benedictoxvi.pe.data.Prospecto;
import benedictoxvi.pe.util.Loader;
import benedictoxvi.pe.util.Validaciones;

public class AdmProspectoTest {

	ArrayList<Prospecto> arrPro = new ArrayList<Prospecto>();
	
	@Before
	public  void bcLoadProspectosTXT(){
		//1000	01/01/2012	Olivera	Reyes	Luis	LOlivera@gmail.com	32432432	12124324	3324324	P
		Loader objLoa = new Loader();
		Prospecto objPro = null;
		String url = objLoa.getClass().getResource("../bd/Prospectos.txt").getFile();			
		ArrayList<String[]> lisPro = objLoa.getDataTxt(url.replaceAll("%20", " "));
		for(String[] row : lisPro){
			 objPro = new Prospecto();
			 objPro.setNumProspecto(Integer.parseInt(row[0]));
				objPro.setFecProspecto(row[1]);
				objPro.setNombes(row[4]);
				objPro.setApePaterno(row[2]);
				objPro.setApeMaterno(row[3]);
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
		String nombs = "u",
				   apepat = "",
				   apemat = "",
				   mail = "",
				   dni = "",
				   tel_cel = "",
				   fecha = "";
			ArrayList<Prospecto> filtroPro = 
					new AdmProspecto().findProspecto(arrPro,nombs,apepat,apemat,mail,dni,tel_cel,fecha);
	}
	
	@Test
	public void findSinEncontrarProspectoTest(){
		String nombs = "Marcos",
				   apepat = "",
				   apemat = "",
				   mail = "",
				   dni = "",
				   tel_cel = "",
				   fecha = "";
			ArrayList<Prospecto> filtroPro = 
					new AdmProspecto().findProspecto(arrPro,nombs,apepat,apemat,mail,dni,tel_cel,fecha);
	}
	
	@Test
	public void registrarProspectoTest(){
		AdmProspecto admPro = new AdmProspecto();
		try {
			Prospecto objPro = new Prospecto();
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
			admPro.registrarProspecto(num_pro,
									  fecha,
									  nombs,
									  apepat,
									  apemat,
									  mail,
									  dni,
									  telefono,
									  celular,
									  estado);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

	public static void main(String[] args){
		AdmProspectoTest testAdm = new AdmProspectoTest();
		testAdm.bcLoadProspectosTXT();
		
		//System.out.println(("hola").contains("s"));
		
		
	}
	
}
