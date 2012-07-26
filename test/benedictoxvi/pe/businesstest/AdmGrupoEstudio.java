package benedictoxvi.pe.businesstest;

import java.util.ArrayList;

import benedictoxvi.pe.data.GrupoEstudio;
import benedictoxvi.pe.util.Validaciones;

public class AdmGrupoEstudio {

	ArrayList<GrupoEstudio> arrGrupos = new ArrayList<GrupoEstudio>();
	Validaciones objVal = new Validaciones();

	public ArrayList<GrupoEstudio> getArrGrupos() {
		return arrGrupos;
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
		else if(!objVal.isDate(fec_inicio)){
			msg_err = "Debe ingresar la Fecha de Inicio (Obligatorio)";
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
		objGru.setCLatitud(latitud);
		objGru.setCAltitud(altitud);
		return false;
	}
	
}
