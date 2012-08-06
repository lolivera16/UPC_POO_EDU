package benedictoxvi.pe.datatest;

import junit.framework.Assert;

import org.junit.Test;

import com.sun.xml.internal.ws.developer.UsesJAXBContext;

import benedictoxvi.pe.data.Modulo;

public class ModuloTest {

	@Test
	public void dataModulo1Test(){
		Modulo objMod = new Modulo();
		objMod.setNombre("PROVEEDORES");
		objMod.setDescripcion("Manejo de Ingresos al Almacem");
		objMod.setAcceso(true);
		objMod.setAdicionar(false);
		objMod.setEditar(true);
		objMod.setEliminar(false);
		
		// Verificar los Setters con los Getters		
		Assert.assertEquals("PROVEEDORES", objMod.getNombre());
		Assert.assertEquals("Manejo de Ingresos al Almacem", objMod.getDescripcion());
		Assert.assertTrue(objMod.getAcceso());
		Assert.assertFalse(objMod.getAdicionar());
		Assert.assertTrue(objMod.getEditar());
		Assert.assertFalse(objMod.getEliminar());
		
	}
	
	@Test
	public void dataModulo2Test(){
		Modulo objMod = new Modulo();
		objMod.setNombre("ATENCION");
		objMod.setDescripcion("Atencion Externa");
		objMod.setAcceso(true);
		objMod.setAdicionar(true);
		objMod.setEditar(false);
		objMod.setEliminar(false);
		
		// Verificar los Setters con los Getters		
		Assert.assertEquals("ATENCION", objMod.getNombre());
		Assert.assertEquals("Atencion Externa", objMod.getDescripcion());
		Assert.assertTrue(objMod.getAcceso());
		Assert.assertTrue(objMod.getAdicionar());
		Assert.assertFalse(objMod.getEditar());
		Assert.assertFalse(objMod.getEliminar());
		
	}
	
}
