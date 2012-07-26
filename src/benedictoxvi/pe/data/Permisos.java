package benedictoxvi.pe.data;

public class Permisos {
	private boolean Acceso;
	private boolean Adicionar;
	private boolean Editar;
	private boolean Eliminar;
	private Modulo modulo;
	
	public Permisos(boolean acceso, boolean adicionar, boolean editar,
			boolean eliminar, Modulo modulo) {
		this.Acceso = acceso;
		this.Adicionar = adicionar;
		this.Editar = editar;
		this.Eliminar = eliminar;
		this.modulo = modulo;
	}

	public boolean isAcceso() {
		return Acceso;
	}

	public void setAcceso(boolean acceso) {
		Acceso = acceso;
	}

	public boolean isAdicionar() {
		return Adicionar;
	}

	public void setAdicionar(boolean adicionar) {
		Adicionar = adicionar;
	}

	public boolean isEditar() {
		return Editar;
	}

	public void setEditar(boolean editar) {
		Editar = editar;
	}

	public boolean isEliminar() {
		return Eliminar;
	}

	public void setEliminar(boolean eliminar) {
		Eliminar = eliminar;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

}
