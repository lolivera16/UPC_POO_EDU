package benedictoxvi.pe.businesstest;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import benedictoxvi.pe.business.AdmGrupoEstudio;
import benedictoxvi.pe.data.Cliente;
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
		//admGru.listarGruposEstudio();
	}
	
	@Test
	public void sinEncontrarGruposEstudioTest(){
		Assert.assertEquals(0,admGru.encontrarGrupoEstudio( "Otro",  // NomGrupo
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
	
	@Test
	public void addAlumnoPorClienteGrupoEstudioTest(){
		// Se ingresa el Codigo del Cliente
		GrupoEstudio grupo = admGru.getGrupoById("GP1001");
		int num_alumnos = grupo.getNumAlumnos();
		Assert.assertTrue(admGru.addAlumnoGrupoEstudio(grupo.getCodGrupo(),"C1008"));
		Assert.assertEquals(num_alumnos + 1,grupo.getInscritos().size());
		
	}
	
	@Test
	public void addAlumnoPorClienteExistenteGrupoEstudioTest(){
		// Se ingresa el Codigo del Cliente		
		GrupoEstudio grupo = admGru.getGrupoById("GP1001");
		// Se Agrega el primer Cliente
		Assert.assertTrue(admGru.addAlumnoGrupoEstudio(grupo.getCodGrupo(),"C1008"));
		// Se Agrega otra vez el mismo cliente
		Assert.assertFalse(admGru.addAlumnoGrupoEstudio(grupo.getCodGrupo(),"C1008"));		
	}
	
	@Test
	public void addAlumnoPorClienteGrupoEstudioErroneoTest(){		// 
		Assert.assertFalse(admGru.addAlumnoGrupoEstudio("GP100X","C1008"));	
	}
	
	@Test
	public void addAlumnoPorClienteErroneoGrupoEstudioTest(){		// 
		Assert.assertFalse(admGru.addAlumnoGrupoEstudio("GP1001","C1XXX"));	
	}
	
	@Test
	public void addAlumnoGrupoEstudiosAforoMaximo(){
		// Se ingresa el Codigo del Cliente		
				GrupoEstudio grupo = admGru.getGrupoById("GP1002");
				// Verificar que la ctd actual es el aforo
				Assert.assertEquals(grupo.getAforo(), grupo.getNumAlumnos());
				// Se Agrega el Cliente y dara el error del aforo
				Assert.assertFalse(admGru.addAlumnoGrupoEstudio(grupo.getCodGrupo(),"C1008"));		
	}	
}
