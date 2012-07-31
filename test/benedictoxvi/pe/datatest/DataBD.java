package benedictoxvi.pe.datatest;

import java.util.*;

import benedictoxvi.pe.data.*;
import benedictoxvi.pe.util.Loader;

public final class DataBD {

	Loader objLoa = new Loader();
	ArrayList<Usuario> dataUsuarios = new ArrayList<Usuario>();
	ArrayList<Compra> dataCompras = new ArrayList<Compra>();
	ArrayList<GrupoEstudio> dataGrupoEstudio = new ArrayList<GrupoEstudio>();
	ArrayList<Prospecto> dataProspecto = new ArrayList<Prospecto>();
	ArrayList<Rol> dataRoles = new ArrayList<Rol>();
	
	
	public static void main(String[] args) {
		new DataBD();
	}
	
	public DataBD() {
		// TODO Auto-generated constructor stub
		loadRoles();
		loadCompras();
		loadGrupoEstudio();
		loadUsuarios();
		loadProspectos();
	}
	
	public ArrayList<Usuario> getDataUsuarios() {
		return dataUsuarios;
	}

	public void setDataUsuarios(ArrayList<Usuario> dataUsuarios) {
		this.dataUsuarios = dataUsuarios;
	}

	public ArrayList<Compra> getDataCompras() {
		return dataCompras;
	}

	public void setDataCompras(ArrayList<Compra> dataCompras) {
		this.dataCompras = dataCompras;
	}

	public ArrayList<GrupoEstudio> getDataGrupoEstudio() {
		return dataGrupoEstudio;
	}

	public void setDataGrupoEstudio(ArrayList<GrupoEstudio> dataGrupoEstudio) {
		this.dataGrupoEstudio = dataGrupoEstudio;
	}

	public ArrayList<Prospecto> getDataProspecto() {
		return dataProspecto;
	}

	public void setDataProspecto(ArrayList<Prospecto> dataProspecto) {
		this.dataProspecto = dataProspecto;
	}

	public ArrayList<Rol> getDataRoles() {
		return dataRoles;
	}

	public void setDataRoles(ArrayList<Rol> dataRoles) {
		this.dataRoles = dataRoles;
	}

	public void loadRoles(){
		Rol objPro = null;
		String url = objLoa.getClass().getResource("../bd/roles.txt").getFile();
		//System.out.println(url);
		ArrayList<String[]> lisPro = objLoa.getDataTxt(url);
		//System.out.println(lisPro.size());
		for(String[] row : lisPro){
			 objPro = new Rol();
			 objPro.setNombre(row[0]);
			 objPro.setDescrip(row[1]);
			// System.out.println(row[2]);
			 for(String mod : row[2].split("/")){
				// System.out.println(mod);
				 String[] parts = mod.split(":");
					 Modulo mod_user  = new Modulo(parts[0]);
					// System.out.println(row[0]+"\t"+parts[0]);
					 mod_user.setAcceso((Integer.parseInt(parts[1])==0)?false:true);
					 mod_user.setAdicionar((Integer.parseInt(parts[2])==0)?false:true);
					 mod_user.setEditar((Integer.parseInt(parts[3])==0)?false:true);
					 mod_user.setEliminar((Integer.parseInt(parts[4])==0)?false:true);
					 objPro.getModulo().add(mod_user);
			 }
				dataRoles.add(objPro);
		}
	}
	
	public void loadProspectos(){
		Prospecto objPro = null;
		String url = objLoa.getClass().getResource("../bd/Prospectos.txt").getFile();			
		ArrayList<String[]> lisPro = objLoa.getDataTxt(url);
		for(String[] row : lisPro){
			 objPro = new Prospecto();
			 objPro.setNumProspecto(Integer.parseInt(row[0]));
				objPro.setFecProspecto(row[1]);				
				objPro.setApePaterno(row[2]);
				objPro.setApeMaterno(row[3]);
				objPro.setNombes(row[4]);
				objPro.setCorreo(row[5]);
				objPro.setNroDNI(row[6]);
				objPro.setTelefono(row[7]);		
				objPro.setCelular(row[8]);
				objPro.setEstado(row[9]);
				dataProspecto.add(objPro);
		}
	}
	
	public void loadClientes(){
		
	}
	
	public void loadGrupoEstudio(){
		GrupoEstudio objGru = null;
		String url = objLoa.getClass().getResource("../bd/gruposestudio.txt").getFile();
		//System.out.println(url.substring(1));
		ArrayList<String[]> lisPro = objLoa.getDataTxt(url.substring(1));
		for(String[] row : lisPro){
			if (row.length == 0) continue;
			 objGru = new GrupoEstudio();
			 objGru.setNomGrupo(row[0]);
			 objGru.setDescripcion(row[1]);
			 objGru.setNomAcademia(row[2]);
			 objGru.setNomCurso(row[3]);
			 objGru.setFecInicio(row[4]);
			 objGru.setFecFin(row[5]);
			 objGru.setInstructor(row[6].split(";"));
			 objGru.setLinkSylabus(row[7]);
			 objGru.setLocal(row[8]);
			 objGru.setEstado("");
			 objGru.setAula(Integer.parseInt(row[9]));
			 objGru.setCAltitud(Double.parseDouble(row[10]));
			 objGru.setCLatitud(Double.parseDouble(row[11]));
			 dataGrupoEstudio.add(objGru);
		}
	}
	
	public void loadCompras(){
		Compra objPro = null;
		String url = objLoa.getClass().getResource("../bd/compras.txt").getFile();			
		ArrayList<String[]> lisPro = objLoa.getDataTxt(url);
		for(String[] row : lisPro){
			 objPro = new Compra();
			 objPro.setConcepto(row[0]);
			 objPro.setNumero(Integer.parseInt(row[1]));
			 objPro.setFecEmision(row[2]);
			 objPro.setNomEmpresa(row[3]);
			 objPro.setMonSubtot(Double.parseDouble(row[4]));
			 objPro.setMonIGV(Double.parseDouble(row[5]));
			 objPro.setMonTotal(Double.parseDouble(row[6]));
			 objPro.setMoneda(row[7]);
			 objPro.setFecVencim(row[8]);
			 objPro.setEstado(row[9]);
			 objPro.setFecPago(row[10]);
			 objPro.setObservacion(row[11]);
			 dataCompras.add(objPro);
		}
	}
	
	public void  loadUsuarios(){		
		Usuario objPro = null;		
		String url = objLoa.getClass().getResource("../bd/usuarios.txt").getFile();			
		ArrayList<String[]> lisPro = objLoa.getDataTxt(url);
		for(String[] row : lisPro){
			 objPro = new Usuario();
			 objPro.setUsuario(row[0]);
			 objPro.setPassword(row[1]);
			 objPro.setNombre(row[2]);
			 objPro.setApellidoPaterno(row[3]);
			 objPro.setApellidoMaterno(row[4]);
			 objPro.setF_ingreso(row[5]);
			 String roles = row[6];
			 //System.out.println(row[0]);
			 for(String rol:roles.split("/")){
				 for(Rol usr_rol : dataRoles){
					 if (usr_rol.getNombre().equalsIgnoreCase(rol)){
						// System.out.println("\t"+usr_rol.getNombre());
						 objPro.getRoles().add(usr_rol);
					 }
				 }
			 }
			 objPro.setCargo(row[7]);
			 objPro.setDni(row[8]);
			 dataUsuarios.add(objPro);
		}
	}
	
}
