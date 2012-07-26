package benedictoxvi.pe.data;

import java.util.ArrayList;

public class GrupoEstudio {

	String NomGrupo;
	String Descripcion;
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	String NomAcademia;
	String NomCurso;
	String FecInicio;
	String FecFin;
	String Estado;
	String[] Instructor;
	
	String LinkSylabus;
	String Local;
	int Aula;
	Double CLatitud;
	Double CAltitud;

	public String getInstructorStr(){
		String list ="";
		for(String ins:getInstructor()){
			list = ins  + "/";
		}
		//list.
		return list;
	}

	public String[] getInstructor() {
		return Instructor;
	}
	public void setInstructor(String[] instructor) {
		Instructor = instructor;
	}
	public String getLinkSylabus() {
		return LinkSylabus;
	}
	public void setLinkSylabus(String linkSylabus) {
		LinkSylabus = linkSylabus;
	}
	public String getLocal() {
		return Local;
	}
	public void setLocal(String local) {
		Local = local;
	}
	public int getAula() {
		return Aula;
	}
	public void setAula(int aula) {
		Aula = aula;
	}
	public Double getCLatitud() {
		return CLatitud;
	}
	public void setCLatitud(Double cLatitud) {
		CLatitud = cLatitud;
	}
	public Double getCAltitud() {
		return CAltitud;
	}
	public void setCAltitud(Double cAltitud) {
		CAltitud = cAltitud;
	}
	
	public String getNomGrupo() {
		return NomGrupo;
	}
	public void setNomGrupo(String nomGrupo) {
		NomGrupo = nomGrupo;
	}
	public String getNomAcademia() {
		return NomAcademia;
	}
	public void setNomAcademia(String nomAcademia) {
		NomAcademia = nomAcademia;
	}
	public String getNomCurso() {
		return NomCurso;
	}
	public void setNomCurso(String nomCurso) {
		NomCurso = nomCurso;
	}
	public String getFecInicio() {
		return FecInicio;
	}
	public void setFecInicio(String fecInicio) {
		FecInicio = fecInicio;
	}
	public String getFecFin() {
		return FecFin;
	}
	public void setFecFin(String fecFin) {
		FecFin = fecFin;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	
	
}
