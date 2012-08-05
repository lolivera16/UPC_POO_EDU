package benedictoxvi.pe.data;

import java.util.ArrayList;

public class Usuario {
	
	private String dni;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String usuario;
    private String password;
    private String correo;
    private String f_ingreso;
    private String cargo;
    private String status;
    //private Rol rol_actual;
	
    public String getStatus() {
		return status;
	}

    public boolean isActive(){
    	if (this.getStatus().equalsIgnoreCase("A")){
    		return true;
    	}
    	return false;
    }
    
	public void setStatus(String status) {
		this.status = status;
	}


	// 
    private ArrayList<Rol> roles =  new ArrayList<Rol>();
    
    public ArrayList<Rol> getRoles() {
		return roles;
	}


	public void setRoles(ArrayList<Rol> roles) {
		this.roles = roles;
	}


	public Usuario(String dni, String nombre, String apellidoPaterno,
			String apellidoMaterno, String usuario, String password,
			String correo, String f_ingreso, String cargo, Rol rol_actual) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.usuario = usuario;
		this.password = password;
		this.correo = correo;
		this.f_ingreso = f_ingreso;
		this.cargo = cargo;
		
	}


	public Usuario() {
		// TODO Auto-generated constructor stub
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidoPaterno() {
		return apellidoPaterno;
	}


	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}


	public String getApellidoMaterno() {
		return apellidoMaterno;
	}


	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getF_ingreso() {
		return f_ingreso;
	}


	public void setF_ingreso(String f_ingreso) {
		this.f_ingreso = f_ingreso;
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

    
}
