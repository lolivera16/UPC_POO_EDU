package benedictoxvi.pe.businesstest;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import benedictoxvi.pe.business.AdmGrupoEstudio;
import benedictoxvi.pe.data.GrupoEstudio;
import benedictoxvi.pe.util.Loader;

public class AdmGrupoEstudioTest {

	ArrayList<GrupoEstudio> arrGru = new ArrayList<GrupoEstudio>();
	AdmGrupoEstudio admGru = new AdmGrupoEstudio();
	
	
	@Before
	public void  bcLoadGruposTXT(){
		Loader objLoa = new Loader();
		GrupoEstudio objGru = null;
		String url = objLoa.getClass().getResource("../bd/gruposestudio.txt").getFile();
		//System.out.println(url.substring(1));
		ArrayList<String[]> lisPro = objLoa.getDataTxt(url.substring(1));
		for(String[] row : lisPro){
			if (row.length == 0) continue;
			 objGru = new GrupoEstudio();
			 objGru.setNomGrupo(row[0]);
			 objGru.setDescripcion(row[1]);
			 objGru.setNomAcademia(row[2]);
			 objGru.setNomCurso(row[3]);
			 objGru.setFecInicio(row[4]);
			 objGru.setFecFin(row[5]);
			 objGru.setInstructor(row[6].split(";"));
			 objGru.setLinkSylabus(row[7]);
			 objGru.setLocal(row[8]);
			 objGru.setEstado("");
			 objGru.setAula(Integer.parseInt(row[9]));
			 objGru.setCAltitud(Double.parseDouble(row[10]));
			 objGru.setCLatitud(Double.parseDouble(row[11]));
			 admGru.getArrGrupos().add(objGru);
		}
		admGru.listarGruposEstudio();
		//admGru.setArrGrupos(arrGru);
	}
	
	@Test
	public void encontrarGruposEstudioTest(){
		Assert.assertTrue(admGru.encontrarGrupoEstudio("",  // NomGrupo
														"", // Academia
														"", // Curso
														"", // Fec.Inicio
														"", // Fec.Fin
														""  // Estado
														
					).size() > 0);
		admGru.listarGruposEstudio();
	}
	
	@Test
	public void sinEncontrarGruposEstudioTest(){
		System.out.println("Size : " + admGru.encontrarGrupoEstudio( "Otro",  // NomGrupo
														"", // Academia
														"", // Curso
														"", // Fec.Inicio
														"", // Fec.Fin
														""  // Estado													
					).size());
	}
	
	
	@Test
	public void registraGrupoEstudioTest(){
		Assert.assertTrue(admGru.registraGrupoEstudio(				
				"Nombre Grupo", //Nom Curso *
				"Descripcion", // Descripcion
				"Academia", // Academia
				"Curso", // Curso
				"01/01/2012",// Fec.Inicio
				"30/06/2012", // Fec.Final
				new String[]{"Instructor1","Instructor2"},
				"https://github.com",//Instructor
				"LOCAL SM",
				231,
				343.00,
				123.00
				));
	}
	
	@Test
	public void registraGrupoEstudioSinNomGrupoTest(){
		Assert.assertFalse(admGru.registraGrupoEstudio(				
				"", //Nom Curso *
				"Descripcion", // Descripcion
				"Academia", // Academia
				"Curso", // Curso
				"01/01/2012",// Fec.Inicio *
				"30/06/2012", // Fec.Final *
				new String[]{"Instructor1","Instructor2"},
				"https://github.com",//Instructor
				"LOCAL SM",
				231,
				343.00,
				123.00
				));
	}	
	
	@Test
	public void registraGrupoEstudioSinFechasTest(){
		Assert.assertFalse(admGru.registraGrupoEstudio(				
				"Nom Grupo", //Nom Curso *
				"Descripcion", // Descripcion
				"Academia", // Academia
				"Curso", // Curso
				"",// Fec.Inicio *
				"", // Fec.Final *
				new String[]{"Instructor1","Instructor2"},
				"https://github.com",//Instructor
				"LOCAL SM",
				231,
				343.00,
				123.00
				));
	}	
	
	@Test
	public void registraGrupoEstudioConFechaErrorTest(){
		Assert.assertFalse(admGru.registraGrupoEstudio(				
				"Nom Grupo", //Nom Curso *
				"Descripcion", // Descripcion
				"Academia", // Academia
				"Curso", // Curso
				"34/13/2010",// Fec.Inicio *
				"", // Fec.Final *
				new String[]{"Instructor1","Instructor2"},
				"https://github.com",//Instructor
				"LOCAL SM",
				231,
				343.00,
				123.00
				));
	}	
	
	@Test
	public void registraGrupoEstudioConRangoFechaErrorTest(){
		Assert.assertFalse(admGru.registraGrupoEstudio(				
				"Nom Grupo", //Nom Curso *
				"Descripcion", // Descripcion
				"Academia", // Academia
				"Curso", // Curso
				"31/12/2010",// Fec.Inicio *
				"01/12/2010", // Fec.Final *
				new String[]{"Instructor1","Instructor2"},
				"https://github.com",//Instructor
				"LOCAL SM",
				231,
				343.00,
				123.00
				));
	}	
	
	
	
}
