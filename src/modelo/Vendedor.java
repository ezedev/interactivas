package modelo;

import java.util.Vector;



public abstract class Vendedor {

	protected String direccion;
	protected  Vector<Publicacion> publicaciones;
	protected Zona zona;
	
	


	public Vendedor(String direccion, Vector<Publicacion> publicaciones,
			Zona zona) {
		super();
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

	public  abstract boolean vendesPublicaciones(Publicacion pub);
}
