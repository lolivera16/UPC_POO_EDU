package benedictoxvi.pe.businesstest;

import junit.framework.Assert;

import org.junit.Test;

import benedictoxvi.pe.business.AdmLoginUsuario;

public class AdmLoginUsuarioTest {

	AdmLoginUsuario admUsr = new AdmLoginUsuario();
	
	@Test
	public void loginSatisfactorioTest(){
		String usuario = "USUARIO01";
		String clave = "PASWORD01";
		Assert.assertTrue(admUsr.loginUsuario(usuario,
										clave));
	}
	
	@Test
	public void loginErroneoTest(){
		String usuario = "USUARIO01";
		String clave = "INCORRECTO";
		Assert.assertFalse(admUsr.loginUsuario(usuario,
										clave));
	}
	
	@Test
	public void loginUsuarioVacioTest(){
		String usuario = "";
		String clave = "INCORRECTO";
		Assert.assertFalse(admUsr.loginUsuario(usuario,
										clave));
	} 
	
	@Test
	public void loginUsuarioInexistenteTest(){
		String usuario = "USUARIOXX";
		String clave = "CLAVE01";
		Assert.assertFalse(admUsr.loginUsuario(usuario,
										clave));
	}
	
	@Test
	public void loginClaveVaciaTest(){
		String usuario = "USUARIO01";
		String clave = "";
		Assert.assertFalse(admUsr.loginUsuario(usuario,
										clave));
	}
	
	@Test
	public void bloquearUsuarioPorIntentosFallidosTest(){
		int max_intentos = 5;
		String usuario = "USUARIO01";
		String clave = "INCORRECTO";
		for(int num_intento = 1; num_intento <= max_intentos ; num_intento ++){
			Assert.assertFalse(admUsr.loginUsuario(usuario,
					clave));
		}
		// Ahora intentamos luego de que se realizo el bloqueo de Usuario
		Assert.assertFalse(admUsr.loginUsuario(usuario,
				clave));
	}
	
}
