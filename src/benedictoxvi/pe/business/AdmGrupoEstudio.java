package benedictoxvi.pe.business;

import java.util.ArrayList;

import benedictoxvi.pe.businesstest.AdmClienteTest;
import benedictoxvi.pe.data.Cliente;
import benedictoxvi.pe.data.GrupoEstudio;
import benedictoxvi.pe.datatest.DataBD;
import benedictoxvi.pe.util.ProcessException;
import benedictoxvi.pe.util.Validaciones;



public class AdmGrupoEstudio {

	ArrayList<GrupoEstudio> arrGrupos = new ArrayList<GrupoEstudio>();
	AdmCliente admCli = new AdmCliente();
	Validaciones objVal = new Validaciones();
	DataBD bd = new DataBD();
	
	public AdmGrupoEstudio() {
		// TODO Auto-generated constructor stub
		arrGrupos = bd.getDataGrupoEstudio();
	}

	public ArrayList<GrupoEstudio> getArrGrupos() {
		return arrGrupos;
	}
	
	public int listarGruposEstudio(){
		if (this.getArrGrupos().size() == 0)
				return 0;
		int i = 0;
		for(GrupoEstudio objGru : getArrGrupos()){
			i+=1;
			System.out.println(i+".\t" + objGru.getNomGrupo() + "\t" + objGru.getDescripcion() + "\t" + objGru.getNomAcademia()
					+ "\t" +  objGru.getFecInicio() + "\t" + objGru.getFecFin() + "\t" + objGru.getInstructorStr() + "\t"
					+ "\t" + objGru.getLocal() + "\t" + objGru.getAula() +"\t" + objGru.getCAltitud() + "\t" + objGru.getCLatitud());
		}
		return i;		
	}
	
	public void setArrGrupos(ArrayList<GrupoEstudio> arrGrupos) {
		this.arrGrupos = arrGrupos;
	}
	/*
	 * 
	 * "Nombre Curso", //Nom Curso
				"Descripcion", // Descripcion
				"Academia", // Academia
				"Curso", // Curso
				"01/01/2012",// Fec.Inicio
				"30/06/2012", // Fec.Final
				new String[]{"Instructor1","Instructor2"},
				"https://github.com",//Instructor
				"LOCAL SM",
				231,
				343.00,
				123.00
	 */
	public boolean registraGrupoEstudio(String nom_grupo, String descripcion,
			String nom_academia, String nom_curso, String fec_inicio, String fec_final,
			String[] instructores, String link, String local, int aula, double latitud,
			double altitud) {
		
		String msg_err = null;
		if (!objVal.isSet(nom_grupo)){
			msg_err = "Debe ingresar el Nombre del Grupo (Obligatorio)";
		}
		else if(!objVal.isSet(fec_inicio)){
			msg_err = "Debe ingresar la Fecha de Inicio (Obligatorio)";
		}
		else if(!objVal.isDate(fec_inicio)){
			msg_err = "Debe ingresar La Fecha de Inicio en Formato dd/mm/aaaa";
		}
		else if(!objVal.isSet(fec_final)){
			msg_err = "Debe ingresar la Fecha de Final (Obligatorio)";
		}		
		else if(!objVal.isDate(fec_final)){
			msg_err = "Debe ingresar La Fecha Final en Formato dd/mm/aaaa";
		}
		else if(objVal.dateToInt(fec_final)<objVal.dateToInt(fec_inicio)){
			msg_err = "La Fecha Final no puede ser menor que la Fecha de Inicio.";
		}
		
		if (objVal.isSet(msg_err)){
		new ProcessException(msg_err).printStackTrace();
		return false;
		}		
		// TODO Auto-generated method stub
		GrupoEstudio objGru = new GrupoEstudio();
		objGru.setNomGrupo(nom_grupo);
		objGru.setDescripcion(descripcion);
		objGru.setNomAcademia(nom_academia);
		objGru.setFecInicio(fec_inicio);
		objGru.setFecFin(fec_final);
		objGru.setInstructor(instructores);
		objGru.setLinkSylabus(link);
		objGru.setLocal(local);
		objGru.setAula(aula);		
		objGru.setEstado("");
		objGru.setCLatitud(latitud);
		objGru.setCAltitud(altitud);
		arrGrupos.add(objGru);
		return true;
	}

	public ArrayList<GrupoEstudio> encontrarGrupoEstudio(String nom_grupo, String nom_acade,
			String curso, String fec_ini, String fec_fin, String estado) {
		// TODO Auto-generated method stub
		ArrayList<GrupoEstudio> filGru = new ArrayList<GrupoEstudio>();
		for(GrupoEstudio objGru : getArrGrupos()){
			if (objGru.getNomGrupo().contains(nom_grupo) &&
					objGru.getNomAcademia().contains(nom_acade) &&
		        objGru.getNomCurso().contains(curso) &&
		        objGru.getFecInicio().contains(fec_ini) &&
		        objGru.getFecFin().contains(fec_fin) &&
		        objGru.getEstado().contains(estado)){
				filGru.add(objGru);
			}			
		}
		//System.out.println("Size : " + filGru.size());
		return filGru;
	}
	
	
	public GrupoEstudio getGrupoById(String cod_grupo) {
		// TODO Auto-generated method stub
		for(GrupoEstudio objGru : getArrGrupos()){
			//System.out.println(objGru.getCodGrupo());
			if (objGru.getCodGrupo().equals(cod_grupo)){
					return objGru;
			}
		}				
		new ProcessException("El Codigo de Grupo '"+cod_grupo+"' no esta registrado.").printStackTrace();
		return null;
	}

	public boolean addAlumnoGrupoEstudio(String codGrupo, String codCliente) {
		// TODO Auto-generated method stub
		GrupoEstudio add_grupo = getGrupoById(codGrupo);		
		if (add_grupo==null){
			return false;
		}
		if (add_grupo.getAforo() == add_grupo.getNumAlumnos()){
			new ProcessException("El Grupo [" + codGrupo + "]["+add_grupo.getNomGrupo()+ "] ya no tiene vacantes disponibles.").printStackTrace();
			return false;
		}
		if (add_grupo.existsCliente(codCliente)){
			new ProcessException("El Codigo de Cliente '"+codCliente+"' ya esta inscrito en el Grupo de Estudios ["+codGrupo+"] "+add_grupo.getNomGrupo()).printStackTrace();
			return false;
		}
		Cliente add_cli = admCli.getClienteByCod(codCliente);
		if (add_cli!=null){
			add_grupo.getInscritos().add(add_cli);	
			return true;
		}
		return false;
	}
	
}
