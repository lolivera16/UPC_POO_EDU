package benedictoxvi.pe.datatest;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import benedictoxvi.pe.businesstest.AdmGrupoEstudio;
import benedictoxvi.pe.data.GrupoEstudio;

public class AdmGrupoEstudioTest {

	ArrayList<GrupoEstudio> arrGru = new ArrayList<GrupoEstudio>();
	AdmGrupoEstudio admGru = new AdmGrupoEstudio();
	
	
	@Before
	public void  bcLoadGruposTXT(){
		admGru.setArrGrupos(arrGru);
	}
	
	@Test
	public void registraGrupoEstudioTest(ArrayList<GrupoEstudio> arrGru){
		Assert.assertTrue(admGru.registraGrupoEstudio(				
				"Nombre Curso", //Nom Curso
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
	
}
