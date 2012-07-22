package benedictoxvi.pe.data;

public class Modulo {
	
	/*private String codigo;
	private String nombre;
	
	public Modulo(String codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}*/
	
	private String nombre;
	private Boolean acceso;
	private Boolean adicionar;
	private Boolean editar;
	private Boolean eliminar;
	
	public Modulo(String nombre, Boolean acceso, Boolean adicionar,
			Boolean editar, Boolean eliminar) {
		this.nombre = nombre;
		this.acceso = acceso;
		this.adicionar = adicionar;
		this.editar = editar;
		this.eliminar = eliminar;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getAcceso() {
		return acceso;
	}

	public void setAcceso(Boolean acceso) {
		this.acceso = acceso;
	}

	public Boolean getAdicionar() {
		return adicionar;
	}

	public void setAdicionar(Boolean adicionar) {
		this.adicionar = adicionar;
	}

	public Boolean getEditar() {
		return editar;
	}

	public void setEditar(Boolean editar) {
		this.editar = editar;
	}

	public Boolean getEliminar() {
		return eliminar;
	}

	public void setEliminar(Boolean eliminar) {
		this.eliminar = eliminar;
	}
	
}
