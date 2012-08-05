package benedictoxvi.pe.data;

import java.util.ArrayList;

public class GrupoEstudio {

	String CodGrupo;
	String NomGrupo;
	String Descripcion;
	String NomAcademia;
	String NomCurso;
	String FecInicio;
	String FecFin;
	public String getCodGrupo() {
		return CodGrupo;
	}
	
	public int getNumAlumnos(){
		return getInscritos().size();
	}

	public void setCodGrupo(String codGrupo) {
		CodGrupo = codGrupo;
	}

	String Estado;
	String[] Instructor;
	
	String LinkSylabus;
	String Local;
	int Aula;
	Double CLatitud;
	Double CAltitud;
	
	int Vacantes;
	int Aforo;
	
	ArrayList<Cliente> Inscritos = new ArrayList<Cliente>();

	public boolean existsCliente(String cod_cliente){
		for(Cliente cli : getInscritos()){
			if (cli.getCodCliente().equals(cod_cliente)){
				return true;
			}
		}
		return false;
	}
	
	public int getVacantes() {
		return Vacantes;
	}

	public void setVacantes(int vacantes) {
		Vacantes = vacantes;
	}

	public int getAforo() {
		return Aforo;
	}

	public void setAforo(int aforo) {
		Aforo = aforo;
	}

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
	
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public ArrayList<Cliente> getInscritos() {
		return Inscritos;
	}

	public void setInscritos(ArrayList<Cliente> inscritos) {
		Inscritos = inscritos;
	}
}
