package benedictoxvi.pe.datatest;
import org.junit.Test;

import junit.framework.Assert;
import benedictoxvi.pe.data.GrupoEstudio;

public class GrupoEstudioTest {

	@Test
	public void testDataGrupoEstudio(){
		
		GrupoEstudio objGrp = new GrupoEstudio();
		objGrp.setNomGrupo("Grupo Estudio 1");
		objGrp.setNomAcademia("Academia Start");
		objGrp.setNomCurso("Estadistica");
		objGrp.setFecInicio("01/01/2012");
		objGrp.setFecFin("31/05/2012");
		objGrp.setEstado("En Curso");
		
		// Probar con Asserts
		Assert.assertEquals("Grupo Estudio 1", objGrp.getNomGrupo());
		Assert.assertEquals("Academia Start",objGrp.getNomAcademia());
		Assert.assertEquals("Estadistica",objGrp.getNomCurso());
		Assert.assertEquals("01/01/2012",objGrp.getFecInicio());
		Assert.assertEquals("31/05/2012",objGrp.getFecFin());
		Assert.assertEquals("En Curso", objGrp.getEstado());
		
		
	}
	
}