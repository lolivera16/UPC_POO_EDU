package benedictoxvi.pe.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import benedictoxvi.pe.data.Modulo;
import benedictoxvi.pe.data.Rol;
import benedictoxvi.pe.data.Usuario;
import benedictoxvi.pe.datatest.DataBD;
import benedictoxvi.pe.util.ProcessException;
import benedictoxvi.pe.util.Validaciones;

public class AdmRoles {
		
	ArrayList<Rol> arrRols = new ArrayList<Rol>();
	ArrayList<Usuario> arrUsr = new ArrayList<Usuario>();
	Validaciones objVal = new Validaciones();
	ArrayList<Modulo> arrMods = new ArrayList<Modulo>();
	DataBD bd = new DataBD();
	
	
	
	public Modulo getNewModulo(String cod_mod, boolean acceso, boolean adicion, boolean actualiza,
			boolean suprimir){
		if (findModuloByIdent(cod_mod)!=null){
			return new Modulo(cod_mod, acceso, adicion, actualiza, suprimir);
		}
		new ProcessException("No se puede ubicar el Modulo con identificador '"+cod_mod+"'.").printStackTrace();
		return null;
	}
	
	public Modulo findModuloByIdent(String cod_mod){
		Modulo new_mod = null;
		try {
			new_mod = arrMods.get(Collections.binarySearch(arrMods,new Modulo(cod_mod),new Comparator<Modulo>() {
				@Override
				public int compare(Modulo o1, Modulo o2) {
					return o1.getNombre().compareTo(o2.getNombre());
				}
			}));
		} catch (Exception e) {
			// TODO: handle exception
			new_mod = null;
		}
		return new_mod;
	}
	
	public AdmRoles() {
		// TODO Auto-generated constructor stub
		arrMods = bd.getDataModulos();
		arrRols = bd.getDataRoles();
		arrUsr = bd.getDataUsuarios();
	}
	
    public ArrayList<Rol> getRoles() {
        return arrRols;
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
	        for(int x=0;x<arrRols.size();x++){
	            if(arrRols.get(x).getNombre().equals(rol)){
	                System.out.println("Rol encontrado: " + arrRols.get(x).getNombre() + " " + arrRols.get(x).getDescrip());
	                encuentra = true;
	                break;
	            }
	        }
	        return encuentra;
	}
	
	public Rol findRol(String nom_rol){
		//Rol rol = null;
		for(Rol xrol : arrRols){
			if (xrol.getNombre().equals(nom_rol)){
				return xrol;
			}
		}
		new ProcessException("El Rol '"+nom_rol+"' no esta registrado.").printStackTrace();
		return null;
	}
	    
	public void eliminaRol(String rol){
	        boolean encontrado=false;
	        for(int x=0;x<arrRols.size();x++){
	            if(arrRols.get(x).getNombre().equals(rol)){
	                encontrado=true;
	                System.out.println("Rol será eliminado: " + arrRols.get(x).getNombre() + " " + arrRols.get(x).getDescrip());
	                arrRols.remove(x);
	                break;
	                }
	
	            }
	        if(encontrado==false){
	            System.out.println("Rol " + rol + " no fue encontrado");
	        }
	        
	    }

	public boolean registrarRol(String cod_rol, String nom_rol,ArrayList<Modulo> mods) {
		// TODO Auto-generated method stub
		Rol new_rol = new Rol();
		String msg_err = null;
		if (!objVal.isSet(cod_rol)){
			msg_err = "Debe Ingresar el Identificador del Rol Crear";
		}
		else if(cod_rol.trim().length() < 6){
			msg_err = "La Longitud del identificador del Rol debe ser al menos 6. ["+cod_rol+"]";
		}
		else if(!objVal.isSet(nom_rol)){
			msg_err = "Ingreser la descripcion del Rol '" + cod_rol + "'";
		}
		else if(mods!=null){
				for(Modulo mod : mods){
					//System.out.println(mod.getNombre());
					if (findModuloByIdent(mod.getNombre())==null){
						msg_err = ("El Modulo '"+mod.getNombre()+"' no se puede agregar al rol porque no existe.");
						break;
					}
				}
		}
		
		if (mods==null){
			mods= new ArrayList<Modulo>();
		}
		
		if (objVal.isSet(msg_err)){
			new ProcessException(msg_err).printStackTrace();
			return false;
		}
		
		new_rol.setNombre(cod_rol);
		new_rol.setDescrip(nom_rol);
		new_rol.setModulo(mods);
		arrRols.add(new_rol);
		objVal.messageOk("Se ha registrado el Rol ["+cod_rol+"] ["+nom_rol+"].");
		if (new_rol.getModulo().size()==0){
			objVal.messageWar("El Rol ha sido registrado sin Modulos, puede agregarlos despues.");	
		}
		return true;
	}

	public boolean suprimirRol(String cod_rol) {
		// TODO Auto-generated method stub
		Rol del_rol = findRol(cod_rol);
		if (del_rol!=null){
			
			// Verificar que este ROL no este asignado a usuarios
			for(Usuario usr : arrUsr){
				for(Rol rol_usr : usr.getRoles()){
					//System.out.println(rol_usr.getNombre());
					if (rol_usr.getNombre().equals(cod_rol)){
						new ProcessException("El Rol aun esta asignado a otros Usuarios ("+usr.getUsuario()+").").printStackTrace();
						return false;
						// El Rol esta asignado a usuarios
					}
				}
			}			
			arrRols.remove(del_rol);
			objVal.messageOk("Se ha removido el Rol ["+cod_rol+"].");
			return true;
		}
		return false;
	}

	public boolean modificarRol(String cod_rol, String nom_rol,
			ArrayList<Modulo> mods) {
		// TODO Auto-generated method stub
		Rol mod_rol = findRol(cod_rol);
		String msg_err = "";
		if(nom_rol!=null && !objVal.isSet(nom_rol)){
			msg_err = "Ingreser la descripcion del Rol '" + cod_rol + "'";
		}
		if (objVal.isSet(msg_err)){
			new ProcessException(msg_err).printStackTrace();
			return false;
		}
		if (mods==null){
			mods = new ArrayList<Modulo>();
		}
		mod_rol.setDescrip(nom_rol);
		mod_rol.setModulo(mods);
		objVal.messageOk("Se ha modificado satisfactoriamente el rol ["+cod_rol+"].");
		return true;
	}

}