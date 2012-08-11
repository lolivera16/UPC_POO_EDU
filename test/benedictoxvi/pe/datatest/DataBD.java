package benedictoxvi.pe.datatest;

import java.util.*;

import benedictoxvi.pe.data.*;
import benedictoxvi.pe.util.Loader;
import benedictoxvi.pe.util.ProcessException;

public final class DataBD {

	Loader objLoa = new Loader();
	ArrayList<Usuario> dataUsuarios = new ArrayList<Usuario>();
	ArrayList<Compra> dataCompras = new ArrayList<Compra>();
	ArrayList<GrupoEstudio> dataGrupoEstudio = new ArrayList<GrupoEstudio>();
	ArrayList<Prospecto> dataProspecto = new ArrayList<Prospecto>();
	ArrayList<Rol> dataRoles = new ArrayList<Rol>();
	ArrayList<Modulo> dataModulos = new ArrayList<Modulo>();
	ArrayList<Cliente> dataClientes = new ArrayList<Cliente>();
	
	
	public ArrayList<Cliente> getDataClientes() {
		return dataClientes;
	}

	public void setDataClientes(ArrayList<Cliente> dataClientes) {
		this.dataClientes = dataClientes;
	}

	public void setDataModulos(ArrayList<Modulo> dataModulos) {
		this.dataModulos = dataModulos;
	}

	public DataBD() {
		// TODO Auto-generated constructor stub
		
		dataClientes = getDataCliente();
		dataModulos = getDataModulos();
		dataRoles = loadRoles();
		dataCompras = loadCompras();
		dataGrupoEstudio = loadGrupoEstudio();
		dataUsuarios = loadUsuarios();
		dataProspecto = loadProspectos();
	}
	
	public ArrayList<Modulo> getDataModulos() {
		ArrayList<Modulo> mods = new ArrayList<Modulo>();
		Modulo objPro = null;
		String url = objLoa.getClass().getResource("../bd/modulos.txt").getFile();		//
		ArrayList<String[]> lisPro = objLoa.getDataTxt(url);
		//System.out.println(lisPro.size());
		for(String[] row : lisPro){
		//	System.out.println(row[0]);
			 objPro = new Modulo();
			 objPro.setNombre(row[0]);
			 objPro.setDescripcion(row[1]);						
			 mods.add(objPro);
		}
		return mods;
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

	public ArrayList<Rol> loadRoles(){
		ArrayList<Rol> roles = new ArrayList<Rol>();
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
				 	 if (Collections.binarySearch(dataModulos, new Modulo(parts[0]), new Comparator<Modulo>(){
				 		 @Override
				 		public int compare(Modulo o1, Modulo o2) {
				 			return o1.getNombre().compareTo(o2.getNombre());
				 		}
					}
				 	 ) < 0 )
				 	 {
				 		new ProcessException("No ha sido posible ubicar el Modulo '" + parts[0]+"'.").printStackTrace();
				 		return null;
				 	 }
					 Modulo mod_user  = new Modulo(parts[0]);
					// System.out.println(row[0]+"\t"+parts[0]);
					 mod_user.setAcceso((Integer.parseInt(parts[1])==0)?false:true);
					 mod_user.setAdicionar((Integer.parseInt(parts[2])==0)?false:true);
					 mod_user.setEditar((Integer.parseInt(parts[3])==0)?false:true);
					 mod_user.setEliminar((Integer.parseInt(parts[4])==0)?false:true);
					 objPro.getModulo().add(mod_user);
			 }
				roles.add(objPro);
		}
		return roles;
	}
	
	public ArrayList<Prospecto> loadProspectos(){
		ArrayList<Prospecto> prospectos = new ArrayList<Prospecto>();
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
				//dataProspecto.add(objPro);
				prospectos.add(objPro);
		}
		return prospectos;
	}
	
	public ArrayList<Prospecto> loadCuentas(){
			return null;		
	}
	
	public void loadClientes(){
		
	}
	
	public ArrayList<GrupoEstudio> loadGrupoEstudio(){
		ArrayList<GrupoEstudio> grupos = new ArrayList<GrupoEstudio>();
		GrupoEstudio objGru = null;
		String url = objLoa.getClass().getResource("../bd/gruposestudio.txt").getFile();
		//System.out.println(url.substring(1));
		ArrayList<String[]> lisPro = objLoa.getDataTxt(url.substring(1));
		for(String[] row : lisPro){
			if (row.length == 0) continue;
			/* 
			 * GP1001
			 * Grupo 1	
			 * Academia_Grupo 1	
			 * SISE	
			 * Algoritmica	
			 * 01/12/2011	
			 * 28/02/2012	
			 * Mario;Ernesto;Juan	
			 * http://curso_SISE_Algoritmica.edu.pe	
			 * SM	
			 * 231	
			 * 947.8723298	
			 * 126.7698794	
			 * 1
			*/
			 objGru = new GrupoEstudio();
			 objGru.setCodGrupo(row[0]);
			 objGru.setNomGrupo(row[1]);
			 objGru.setDescripcion(row[2]);
			 objGru.setNomAcademia(row[3]);
			 objGru.setNomCurso(row[4]);
			 objGru.setFecInicio(row[5]);
			 objGru.setFecFin(row[6]);
			 objGru.setInstructor(row[7].split(";"));
			 objGru.setLinkSylabus(row[8]);
			 objGru.setLocal(row[9]);
			 objGru.setEstado("");
			 objGru.setAula(Integer.parseInt(row[10]));
			 objGru.setCAltitud(Double.parseDouble(row[11]));
			 objGru.setCLatitud(Double.parseDouble(row[12]));
			 //System.out.println(row[13]);
			 objGru.setAforo(Integer.parseInt(row[13]));
			 grupos.add(objGru);
		}
				
		// Grupo  GP1002
		// Se le pone aforo al maximo de lo cargado
		// para realizar los tests de prueba
		int i = 0;
		for(Cliente cli : dataClientes){
			if (cli.getCodCliente().equals("C1008")){
				// omite este codigo para adicionarlo en los tests
				continue; 
			}
			i+=1;
			grupos.get(1).getInscritos().add(cli);
		}
		grupos.get(1).setAforo(i);
		return grupos;
	}
	
	public ArrayList<Compra> loadCompras(){
		 ArrayList<Compra> compras = new  ArrayList<Compra>();
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
			 compras.add(objPro);
		}
		 return compras;
	}
	
	public ArrayList<Usuario>  loadUsuarios(){
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
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
			 objPro.setStatus(row[9]);
			 usuarios.add(objPro);
		}
		return usuarios;
	}

	public ArrayList<Cliente> getDataCliente() {
		// TODO Auto-generated method stub
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Cliente objPro = null;		
		String url = objLoa.getClass().getResource("../bd/clientes.txt").getFile();			
		ArrayList<String[]> lisPro = objLoa.getDataTxt(url);
		for(String[] row : lisPro){
			 objPro = new Cliente();
			 objPro.setCodCliente(row[0]);
			 //1008	09/01/2012	Lopez	Inocencio	Carlos	CLopez@gmail.com	32430840		4543345		C
			 objPro.setFecConCliente(row[1]);
			 objPro.setApePatCliente(row[2]);
			 objPro.setApeMatCliente(row[3]);
			 objPro.setNomCliente(row[4]);
			 objPro.setEmaCliente(row[5]);
			 objPro.setDniCliente(row[6]);
			 objPro.setFonCliente(row[7]);
			 objPro.setEstCliente(row[8]);
//			 System.out.println(row[0]);
//			 System.out.println(row[1]);
//			 System.out.println(row[2]);
//			 System.out.println(row[3]);
//			 System.out.println(row[4]);
//			 System.out.println(row[5]);
//			 System.out.println(row[6]);
//			 System.out.println(row[7]);
//			 System.out.println(row[8]);
			 //System.out.println(row[0]);
			 clientes.add(objPro);
			 //break;
		}
		return clientes;
	}
	
	public static void main(String[] args) {
		DataBD bd= new DataBD();
//		System.out.println(Collections.binarySearch(bd.dataModulos, new Modulo("VENTAS"), new Comparator<Modulo>(){
//	 		 @Override
//	 		public int compare(Modulo o1, Modulo o2) {
//	 			// TODO Auto-generated method stub
//	 			 System.out.println(o1.getNombre() + "/"+ o2.getNombre());
//	 			return o1.getNombre().compareTo(o2.getNombre());
//	 		}
//		}
//	 	 ));
	}
}
