package benedictoxvi.pe.data;
/**
|--------------------------------------------------------------
| Cliente.java
|--------------------------------------------------------------
| @Autor: Jean Guzman Abregu
| @Fecha de creacion: 18/07/2012
| @Fecha de la ultima modificacion: 25/07/2012
| @Universidad Peruana de Ciencias Aplicadas
|--------------------------------------------------------------
| Clase cliente donde estan todos los atributos degun la historia de usuario
*/
public class Cliente {

    public String nomCliente;
    public String apePatCliente;
    public String apeMatCliente;
    public String emaCliente;
    public String dniCliente;
    public int fonCliente;
    public String fecConCliente;
    public String estCliente;
    
    
    public String getEstCliente() {
		return estCliente;
	}

	public void setEstCliente(String estCliente) {
		this.estCliente = estCliente;
	}

	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}
    
	public String getDniCliente() {
		return dniCliente;
	}

	public String getNomCliente() {
		return nomCliente;
	}
	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}
	public String getApePatCliente() {
		return apePatCliente;
	}
	public void setApePatCliente(String apePatCliente) {
		this.apePatCliente = apePatCliente;
	}
	public String getApeMatCliente() {
		return apeMatCliente;
	}
	public void setApeMatCliente(String apeMatCliente) {
		this.apeMatCliente = apeMatCliente;
	}
	public String getEmaCliente() {
		return emaCliente;
	}
	public void setEmaCliente(String emaCliente) {
		this.emaCliente = emaCliente;
	}

	public int getFonCliente() {
		return fonCliente;
	}
	public void setFonCliente(int fonCliente) {
		this.fonCliente = fonCliente;
	}
	public String getFecConCliente() {
		return fecConCliente;
	}
	public void setFecConCliente(String fecConCliente) {
		this.fecConCliente = fecConCliente;
	}

}
