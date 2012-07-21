package benedictoxvi.pe.data;

import java.util.ArrayList;

public class Rol {
	private String nombre;
	private String descrip;
	
	private ArrayList<Modulo> Modulo = new ArrayList<Modulo>();

	public Rol(String nombre, String descrip,
			ArrayList<benedictoxvi.pe.data.Modulo> modulo) {
		this.nombre = nombre;
		this.descrip = descrip;
		for (int i=0; i<modulo.size();i++){
			this.Modulo.add(modulo.get(i));
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public ArrayList<Modulo> getModulo() {
		return Modulo;
	}

	public void setModulo(ArrayList<Modulo> modulo) {
		this.Modulo = modulo;
	}


}
