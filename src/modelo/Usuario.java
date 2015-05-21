package modelo;

public class Usuario {
	private String usuario;
	private String clave;
	private Rol rol;
	
	public Usuario() {
		super();
	}

	public Usuario(String usuario, String clave, Rol rol) {
		super();
		this.usuario = usuario;
		this.clave = clave;
		this.rol = rol;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
}
