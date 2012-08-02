package benedictoxvi.pe.business;

import java.util.ArrayList;

import benedictoxvi.pe.data.Modulo;
import benedictoxvi.pe.data.Rol;
import benedictoxvi.pe.datatest.DataBD;
import benedictoxvi.pe.util.ProcessException;

public class AdmRoles {
		
	private ArrayList<Rol> roles = new ArrayList<Rol>();
	DataBD bd = new DataBD();
	
	public AdmRoles() {
		// TODO Auto-generated constructor stub
		roles = bd.getDataRoles();
	}
	
    public ArrayList<Rol> getRoles() {
        return roles;
    }

    public void agregarRolAdmin(){
      
    	Modulo Prospecto = new Modulo("Prospecto",true,true,true,true);
    	Modulo Clientes = new Modulo("Clientes",true,true,true,true);
    	Modulo Ventas = new Modulo("Ventas",true,true,true,true);
    	Modulo Compras = new Modulo("Compras",true,true,true,true);
    	Modulo GdeEstudios = new Modulo("GdeEstudios",true,true,true,true);
    	Modulo Admin = new Modulo("Admin",true,true,true,true); 
    	Modulo Roles = new Modulo("Roles",true,true,true,true); 
    
    		ArrayList<Modulo> mods = new ArrayList<Modulo>();
    		mods.add(Prospecto);
    		mods.add(Clientes);
    		mods.add(Ventas);
    		mods.add(Compras);
    		mods.add(GdeEstudios);
    		mods.add(Admin);
    		mods.add(Roles);
                
    	Rol nuevo_rol=new Rol ("Admin", "Rol de administrador del Sistema", mods);
    		roles.add(nuevo_rol);
    }
  
    public void agregarRolUser(){
      
    	Modulo Prospecto = new Modulo("Prospecto",true,true,true,true);
    	Modulo Clientes = new Modulo("Clientes",true,true,true,true);
    	Modulo Ventas = new Modulo("Ventas",true,true,true,true);
    	Modulo Compras = new Modulo("Compras",true,true,true,true);
    	Modulo GdeEstudios = new Modulo("GdeEstudios",true,true,true,true);
    	Modulo Admin = new Modulo("Admin",true,true,true,true); 
    	Modulo Roles = new Modulo("Roles",true,true,true,true); 
    
    		ArrayList<Modulo> mods = new ArrayList<Modulo>();
    		mods.add(Prospecto);
    		mods.add(Clientes);
    		mods.add(Ventas);
    		mods.add(Compras);
    		mods.add(GdeEstudios);
    		mods.add(Admin);

    	Rol nuevo_rol=new Rol ("User", "Rol de usuario del Sistema", mods);
    		roles.add(nuevo_rol);
    }
    	

	public boolean validaNombreRol(Rol unRol){
	        
	    /*Valida que el Rol no tenga un nulo en el nombre o vacio
	    y Recibe un objeto de tipo rol*/
	        
	    boolean Ok=true;        
	        for(int i=0; i<unRol.getModulo().size();i++){
	            if(unRol.getModulo().get(i).getNombre() == null || unRol.getModulo().get(i).getNombre().equals("")){
	                Ok = false;
	            }
	        }
	        return Ok;
	    }
	    
	public boolean validaEstadoRol(Rol unRol){
        /*Valida que el Rol no tenga un nulo en alguno de los permisos
        y Recibe un objeto de tipo rol*/    

	        
	    boolean Ok = true;
	        for(int i=0; i<unRol.getModulo().size();i++){
	            if(unRol.getModulo().get(i).getAcceso() == null){
	                Ok = false;
	            } else if(unRol.getModulo().get(i).getAdicionar() == null){
	            	Ok = false;
	            } else if(unRol.getModulo().get(i).getEditar() == null){
	                Ok = false;
	            } else if(unRol.getModulo().get(i).getEliminar() == null){
	                Ok = false;
	            }
	        }
	        return Ok;
	}
	    
	public boolean validaDescripcionRol(Rol unRol){
        /*Valida que el Rol no tenga un nulo en la descripción o vacío
        y Recibe un objeto de tipo rol*/       
	        
	    boolean Ok=true;    
	        if(unRol.getDescrip() == null || unRol.getDescrip().equals("")){
	                Ok = false;
	            }
	        return Ok;
	}
	
	public boolean buscaRol(String rol){
	        boolean encuentra=false;
	        for(int x=0;x<roles.size();x++){
	            if(roles.get(x).getNombre().equals(rol)){
	                System.out.println("Rol encontrado: " + roles.get(x).getNombre() + " " + roles.get(x).getDescrip());
	                encuentra = true;
	                break;
	            }
	        }
	        return encuentra;
	}
	
	public Rol findRol(String nom_rol){
		//Rol rol = null;
		for(Rol xrol : roles){
			if (xrol.getNombre().equals(nom_rol)){
				return xrol;
			}
		}
		new ProcessException("El Rol '"+nom_rol+"' no esta registrado.").printStackTrace();
		return null;
	}
	    
	public void eliminaRol(String rol){
	        boolean encontrado=false;
	        for(int x=0;x<roles.size();x++){
	            if(roles.get(x).getNombre().equals(rol)){
	                encontrado=true;
	                System.out.println("Rol será eliminado: " + roles.get(x).getNombre() + " " + roles.get(x).getDescrip());
	                roles.remove(x);
	                break;
	                }
	
	            }
	        if(encontrado==false){
	            System.out.println("Rol " + rol + " no fue encontrado");
	        }
	        
	    }

}