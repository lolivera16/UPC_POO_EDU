package benedictoxvi.pe.businesstest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import benedictoxvi.pe.business.AdmRoles;
import benedictoxvi.pe.data.Modulo;
import benedictoxvi.pe.data.Rol;

public class AdmRolTest {
	
	private Rol rolActual;

	Modulo Prospecto = new Modulo("Prospecto",true,true,true,true);
	Modulo Clientes = new Modulo("Clientes",true,true,true,true);
	Modulo Ventas = new Modulo("Ventas",true,true,true,true);
	Modulo Compras = new Modulo("Compras",true,true,true,true);
	Modulo GdeEstudios = new Modulo("GdeEstudios",true,true,true,true);
	Modulo Admin = new Modulo("Admin",true,true,true,true); 

    ArrayList<Modulo> Modulos = new ArrayList<Modulo>();
    
    
    public Rol getRolActual() {
        return rolActual;
    }

    @Test
    public void crearRol(){
        Modulos.add(Prospecto);
        Modulos.add(Clientes);
        Modulos.add(Ventas);
        Modulos.add(Compras);
        Modulos.add(GdeEstudios);
        Modulos.add(Admin);
   
        Rol administrador = new Rol("Admin","Rol de administrador",Modulos);
   
        assertNotNull(administrador.getNombre());
        System.out.println("El nombre del Rol es: "+administrador.getNombre());
     
            for (int i=0;i<administrador.getModulo().size();i++){
                assertNotNull(administrador.getModulo().get(i).getAcceso());
                System.out.println("El Modulo es : "+administrador.getModulo().get(i).getNombre());
                System.out.println("El permiso para acceder   : "+administrador.getModulo().get(i).getAcceso().toString()); 
                System.out.println("El permiso para adicionar : "+administrador.getModulo().get(i).getAdicionar().toString());
                System.out.println("El permiso para editar    : "+administrador.getModulo().get(i).getEditar().toString());
                System.out.println("El permiso para eliminar  : "+administrador.getModulo().get(i).getEliminar().toString());
            }
        this.rolActual=administrador;
  }
   
   @Test
   public void nombreDelRolNoSeaNuloOVacio(){
       Modulos.add(Prospecto);
       Modulos.add(Clientes);
       Modulos.add(Ventas);
       Modulos.add(Compras);
       Modulos.add(GdeEstudios);
       Modulos.add(Admin); 
       
       Rol administrador = new Rol("Admin","Rol de administrador",Modulos);
       AdmRoles businessRoles = new AdmRoles(); 
       assertTrue(businessRoles.validaNombreRol(administrador));

   }

   @Test
   public void permisosDelRolNoSeaNulo(){
       Modulos.add(Prospecto);
       Modulos.add(Clientes);
       Modulos.add(Ventas);
       Modulos.add(Compras);
       Modulos.add(GdeEstudios);
       Modulos.add(Admin);  
       Rol administrador = new Rol("Admin","Rol de administrador",Modulos);
       AdmRoles businessRoles = new AdmRoles();
       assertTrue(businessRoles.validaEstadoRol(administrador));
   }

   @Test
   public void validaDescripcionRolNoSeaNuloOVacio(){
       Modulos.add(Prospecto);
       Modulos.add(Clientes);
       Modulos.add(Ventas);
       Modulos.add(Compras);
       Modulos.add(GdeEstudios);
       Modulos.add(Admin);
       Rol administrador = new Rol("Admin","Rol de administrador",Modulos);
       AdmRoles businessRoles = new AdmRoles();
       assertTrue(businessRoles.validaDescripcionRol(administrador));
   }

   @Test
   public void verificaBusquedaRol(){
       Modulos.add(Prospecto);
       Modulos.add(Clientes);
       Modulos.add(Ventas);
       Modulos.add(Compras);
       Modulos.add(GdeEstudios);
       Modulos.add(Admin);
       
       ArrayList<Rol>aRoles = new ArrayList<Rol>();
       
       Rol administrador = new Rol("Admin","Rol de administrador",Modulos);
       Rol logistica = new Rol("Logistics", "Logistica", Modulos);
       
       aRoles.add(administrador);
       aRoles.add(logistica);
       
       AdmRoles businessRoles = new AdmRoles();
       assertEquals(true, businessRoles.buscaRol("ADM"));
   }
   
   @Test
   public void verificaEliminaRol(){
       Modulos.add(Prospecto);
       Modulos.add(Clientes);
       Modulos.add(Ventas);
       Modulos.add(Compras);
       Modulos.add(GdeEstudios);
       Modulos.add(Admin);
       
       ArrayList<Rol>aRoles = new ArrayList<Rol>();
       
       Rol administrador = new Rol("Admin","Rol de administrador",Modulos);
       Rol logistica = new Rol("Logistics", "Logistica", Modulos);
       
       aRoles.add(administrador);
       aRoles.add(logistica);
       
       AdmRoles businessRoles = new AdmRoles();
       /*Elimina el Rol*/
       businessRoles.eliminaRol("LOGISTIC");
       /*Busca el Rol Eliminado*/
       assertFalse(businessRoles.buscaRol("LOGISTIC"));
       
   }

}
