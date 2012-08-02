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
