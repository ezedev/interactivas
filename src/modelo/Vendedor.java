package modelo;

import java.util.Vector;

public abstract class Vendedor {

	public final static String TIPO_DIARIERIO_EXCLUSIVO = "D";
	public final static String TIPO_REVISTERO_EXCLUSIVO = "R";
	public final static String TIPO_DIARIERIO_REVISTERO = "A";
	
	protected String codigo;
	protected String direccion;
	protected  Vector<Publicacion> publicaciones;
	protected Zona zona;
	
	public Vendedor(String codigo, String direccion, Vector<Publicacion> publicaciones,
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public  abstract boolean vendesPublicaciones(Publicacion pub);
}
