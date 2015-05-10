package modelo;

import java.util.Vector;



public abstract class Vendedor {

	protected int codigo;
	protected String direccion;
	protected  Vector<Publicacion> publicaciones;
	protected Zona zona;
	
	public Vendedor(int codigo, String direccion, Vector<Publicacion> publicaciones,
			Zona zona) {
		super();
		this.codigo = codigo;
		this.direccion = direccion;
		this.publicaciones = publicaciones;
		this.zona = zona;
	}

	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public Vector<Publicacion> getPublicaciones() {
		return publicaciones;
	}


	public void setPublicaciones(Vector<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}


	public Zona getZona() {
		return zona;
	}


	public void setZona(Zona zona) {
		this.zona = zona;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public  abstract boolean vendesPublicaciones(Publicacion pub);
}
