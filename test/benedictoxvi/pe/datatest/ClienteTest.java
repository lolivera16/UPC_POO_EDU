package benedictoxvi.pe.datatest;
/**
|--------------------------------------------------------------
| ClienteTest.java
|--------------------------------------------------------------
| @Autor: Jean Guzman Abregu
| @Fecha de creacion: 20/07/2012
| @Fecha de la ultima modificacion: 25/07/2012
| @Universidad Peruana de Ciencias Aplicadas
|--------------------------------------------------------------
| Clase donde realizo los test del cliente
*/

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;



import benedictoxvi.pe.data.Cliente;
import benedictoxvi.pe.util.*;

public class ClienteTest {
	
	Cliente objCli = new Cliente();
	List<String> gruEstudio = new ArrayList<String>();
	List<String> aluGrupo = new ArrayList<String>();
	
	@Before
	public void contruct__(){
		objCli.setNomCliente("Jose Luis");
		objCli.setApePatCliente("Guzman");
		objCli.setApeMatCliente("Perez");
		objCli.setDniCliente("34567543");
		objCli.setFonCliente(7665456);
		objCli.setFecConCliente("12/07/2012");
		objCli.setEmaCliente("jguzman@hotmail.com");
		objCli.setEstCliente("Cliente");
		
		//Agregar cursos 
		gruEstudio.add("Grupo Matematica");
		gruEstudio.add("Grupo Lenguaje");
		gruEstudio.add("Grupo Fisica");
		gruEstudio.add("Grupo Quimica");
		
		
	}
	
	@Test
	public void testDataCliente(){
		assertEquals("Jose Luis",objCli.getNomCliente());
		assertEquals("Guzman",objCli.getApePatCliente());
		assertEquals("Perez",objCli.getApeMatCliente());
		assertEquals("346578",objCli.getDniCliente());
		assertEquals(7665456,objCli.getFonCliente());
		assertEquals("12/07/2012",objCli.getFecConCliente());
		assertEquals("jguzman@hotmail.com",objCli.getEmaCliente());
		assertEquals("Cliente",objCli.getEstCliente());
	}
	
	@Test
	public void testValidaDni(){	
		Validaciones objVal = new Validaciones();
		assertEquals(true,objVal.isDNI(objCli.getDniCliente()));
		
	}
	
	@Test
	public void testValidaCorreoCliente(){	
		Validaciones objVal = new Validaciones();
		assertEquals(true,objVal.isEmail(objCli.getEmaCliente()));
			
	}
	
	
	@Test
	public void testLitarClienteGrupoEstudio(){
		aluGrupo.add(objCli.getNomCliente());
		assertEquals(objCli.getNomCliente(),aluGrupo.get(0));
		System.out.print(aluGrupo.get(0)+" - "+gruEstudio.get(0));				
	}
	
	
	
		

}
