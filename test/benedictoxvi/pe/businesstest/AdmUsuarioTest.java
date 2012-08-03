package benedictoxvi.pe.businesstest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

import benedictoxvi.pe.business.AdmUsuarios;
import benedictoxvi.pe.data.Rol;
import benedictoxvi.pe.data.Usuario;

public class AdmUsuarioTest {
	
AdmUsuarios admUsuarios = new AdmUsuarios();
AdmRolTest test= new AdmRolTest();    
    //simularTabla();
    
    @Test
    public void createUsuarioTest() {
//USUARIO01	PASWORD01	NOMBRE 01	APELLIDO PAT 01	APELLIDO MAT 01	01/01/2012	ADM	COMPRA	70721577
    	Assert.assertTrue(admUsuarios.createUsuario(
    												"USUARIO20",
    												"PASWORD20",
    												"NOMBRES 20",
    												"APELLIDO PAT 20",
    												"APELLIDO MAT 20",
    												"01/05/2012",
    												"ADM", // ROLES
    												"ADMINISTRADOR", // Cargo
    												"71033506" // dni
    			));	
        
//        Usuario user1 = new Usuario("11111111", "Carlos", "Rengifo", "Florindez", "crengifo", "crengifo", "crengifo@benedicto.edu.pe", null, "cargo1", rol_actual);
//        System.out.println("*----- Inicio verificacion Usuario :" + user1.getUsuario() + " -----*");
//        System.out.println("El Nombre del Usuario es: "    + user1.getNombre());
//        System.out.println("El Apellido Paterno del Usuario es: " + user1.getApellidoPaterno());
//        System.out.println("El Apellido Materno del Usuario es: " + user1.getApellidoMaterno());
//        System.out.println("El Usuario  del Usuario es: "  + user1.getUsuario());
//        System.out.println("El Password del Usuario es: "  + user1.getPassword());
//        System.out.println("El Correo del Usuario es: "    + user1.getCorreo());
//        System.out.println("La Fecha de Ingreso del Usuario es: " + user1.getF_ingreso());
//        System.out.println("El Cargo del Usuario es: "     + user1.getCargo());
//        System.out.println("El Rol del Usuario es: "       + user1.getRol_actual().getDescrip());
//        System.out.println("*----- Fin verificacion Usuario -----*");
//        System.out.println("\n");
//
//        Usuario user2 = new Usuario("22222222", "Paolo", "Bazan", "Hernandez", "pbazan", "pbazan", "pbazan@benedicto.edu.pe", null, "cargo2", rol_actual);
//        System.out.println("*----- Inicio verificacion Usuario :" + user2.getUsuario() + " -----*");
//        System.out.println("El Nombre del Usuario es: "    + user2.getNombre());
//        System.out.println("El Apellido Paterno del Usuario es: " + user2.getApellidoPaterno());
//        System.out.println("El Apellido Materno del Usuario es: " + user2.getApellidoMaterno());
//        System.out.println("El Usuario  del Usuario es: "  + user2.getUsuario());
//        System.out.println("El Password del Usuario es: "  + user2.getPassword());
//        System.out.println("El Correo del Usuario es: "    + user2.getCorreo());
//        System.out.println("La Fecha de Ingreso del Usuario es: " + user2.getF_ingreso());
//        System.out.println("El Cargo del Usuario es: "     + user2.getCargo());
//        System.out.println("El Rol del Usuario es: "       + user2.getRol_actual().getDescrip());
//        System.out.println("*----- Fin verificacion Usuario -----*");
//        System.out.println("\n");
//        
//        Usuario user3 = new Usuario("33333333", "Luis", "Olivera", "Aguilar", "lolivera", "lolivera", "lolivera@benedicto.edu.pe", null, "cargo3", rol_actual);
//        System.out.println("*----- Inicio verificacion Usuario :" + user3.getUsuario() + " -----*");
//        System.out.println("El Nombre del Usuario es: "    + user3.getNombre());
//        System.out.println("El Apellido Paterno del Usuario es: " + user3.getApellidoPaterno());
//        System.out.println("El Apellido Materno del Usuario es: " + user3.getApellidoMaterno());
//        System.out.println("El Usuario  del Usuario es: "  + user3.getUsuario());
//        System.out.println("El Password del Usuario es: "  + user3.getPassword());
//        System.out.println("El Correo del Usuario es: "    + user3.getCorreo());
//        System.out.println("La Fecha de Ingreso del Usuario es: " + user3.getF_ingreso());
//        System.out.println("El Cargo del Usuario es: "     + user3.getCargo());
//        System.out.println("El Rol del Usuario es: "       + user3.getRol_actual().getDescrip());
//        System.out.println("*----- Fin verificacion Usuario -----*");
//        System.out.println("\n");
//        
//        Usuario user4 = new Usuario("44444444", "Max", "Romero", "Inocencio", "mromero", "mromero", "mguerrero@benedicto.edu.pe", null, "cargo4", rol_actual);
//        System.out.println("*----- Inicio verificacion Usuario :" + user4.getUsuario() + " -----*");
//        System.out.println("El Nombre del Usuario es: "    + user4.getNombre());
//        System.out.println("El Apellido Paterno del Usuario es: " + user4.getApellidoPaterno());
//        System.out.println("El Apellido Materno del Usuario es: " + user4.getApellidoMaterno());
//        System.out.println("El Usuario  del Usuario es: "  + user4.getUsuario());
//        System.out.println("El Password del Usuario es: "  + user4.getPassword());
//        System.out.println("El Correo del Usuario es: "    + user4.getCorreo());
//        System.out.println("La Fecha de Ingreso del Usuario es: " + user4.getF_ingreso());
//        System.out.println("El Cargo del Usuario es: "     + user4.getCargo());
//        System.out.println("El Rol del Usuario es: "       + user4.getRol_actual().getDescrip());
//        System.out.println("*----- Fin verificacion Usuario -----*");
//        System.out.println("\n");
//        
//        Usuario user5 = new Usuario("55555555", "Jean", "Guzman", "Abregu", "jguzman", "jguzman", "jguzman@benedicto.edu.pe", null, "cargo5", rol_actual);
//        System.out.println("*----- Inicio verificacion Usuario :" + user5.getUsuario() + " -----*");
//        System.out.println("El Nombre del Usuario es: "    + user5.getNombre());
//        System.out.println("El Apellido Paterno del Usuario es: " + user5.getApellidoPaterno());
//        System.out.println("El Apellido Materno del Usuario es: " + user5.getApellidoMaterno());
//        System.out.println("El Usuario  del Usuario es: "  + user5.getUsuario());
//        System.out.println("El Password del Usuario es: "  + user5.getPassword());
//        System.out.println("El Correo del Usuario es: "    + user5.getCorreo());
//        System.out.println("La Fecha de Ingreso del Usuario es: " + user5.getF_ingreso());
//        System.out.println("El Cargo del Usuario es: "     + user5.getCargo());
//        System.out.println("El Rol del Usuario es: "       + user5.getRol_actual().getDescrip());
//        System.out.println("*----- Fin verificacion Usuario -----*");
//        System.out.println("\n");
	
/*
        ArrayList<Usuario> dbUsuario= new ArrayList<Usuario>();
   
        String usuarioBuscar="crengifo";
        System.out.println("Validando la existencia del Usuario " + usuarioBuscar);
        System.out.println("------------------------------------------------------------");
        if (AdmUsuarios.buscaUsuario(usuarioBuscar, dbUsuario)){
            System.out.println("El usuario " + usuarioBuscar + ", ya existe!!!!");
        } else System.out.println("El usuario " + usuarioBuscar + ", no existe!!!!");
        System.out.println("\n");
        
        String usuarioDatos="jguzman";
        if (AdmUsuarios.buscaUsuario(usuarioDatos, dbUsuario)){
            System.out.println("Los datos de usuario " + usuarioBuscar + ", son los siguientes:");
            System.out.println("---------------------------------------------------------------");
            AdmUsuarios.DatosUsuarioBuscado(usuarioDatos, dbUsuario);
            System.out.println("\n");
        }
        
*/        
    }
        
    @Test
    public void siNoingresoElUsuarioDebeDarError(){
        assertFalse(admUsuarios.verificarUsuario(null));
        System.out.println("El campo <Usuario> no debe estar vacio");
    }
    
    /*@Test
    public void siIngresoEspaciosEnElUsuarioDebeDarError(){
        assertFalse(admUsuarios.vacioUsuario("    "));
        System.out.println("Usuario no debe tener espacios en blanco");
    }*/
        
    @Test
    public void siNoingresoElNombreDebeDarError(){
        assertFalse(admUsuarios.verificarNombre(null));
        System.out.println("El campo <Nombre> no debe estar vacio");
    }
    
    @Test
    public void siNoIngresoElDniDebeDarError(){
        assertFalse(admUsuarios.validarDNI(null));
        System.out.println("El DNI no debe de estar vacio");
    }
    
    @Test
    public void siNoIngresoElApellidoPaternoDebeDarError(){
        assertFalse(admUsuarios.validarApellidoPaterno(null));
        System.out.println("El apellido paterno no debe de estar vacio");
    }
    
    @Test
    public void siNoIngresoElApellidoMaternoDebeDarError(){
        assertFalse(admUsuarios.validarApellidoMatermo(null));
        System.out.println("El apellido materno no debes de estar vacio");
    }
    
    @Test
    public void siNoIngresoElPasswordDebeDarError(){
        assertFalse(admUsuarios.validarPassword(null));
        System.out.println("El password no debe de estar vacio");
    }
    
    @Test
    public void siNoIngresoElCorreoDebeDarError(){
        assertFalse(admUsuarios.validarCorreo(null));
        System.out.println("El correo no debe de estar vacio");
    }
    
    @Test
    public void siNoTieneFechaIngresoDebeDarError(){
        assertFalse(admUsuarios.validarFecha(null));
        System.out.println("La fecha no debe de estar vacia");
    }
    
    @Test
    public void siNoIngresaCargoDebeDarError(){
        assertFalse(admUsuarios.validarCargo(null));
        System.out.println("El cargo no debe de estar vacio");
    }
    
    @Test
    public void siNoIngresaCodigoRolDebeDarError(){
        assertFalse(admUsuarios.validarCodigoRol(null));
        System.out.println("El rol no debe de estar vacio");
    }
    

}
