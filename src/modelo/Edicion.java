package modelo;

import java.sql.Date;

public class Edicion {

	private int codigo;
	private String tituloTapa;
	private Date fechaSalida;
	private float precio;
	private Publicacion publicacion;
	
	public Edicion (int codigo, String tituloTapa, Date fechaSalida, float precio, Publicacion publicacion) {
		super();
		this.codigo = codigo;
		this.tituloTapa = tituloTapa;
		this.fechaSalida = fechaSalida;
		this.precio = precio;
		this.publicacion = publicacion;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getTituloTapa() {
		return tituloTapa;
	}
	
	public void setTituloTapa(String tituloTapa) {
		this.tituloTapa = tituloTapa;
	}
	
	public Date getFechaSalida() {
		return fechaSalida;
	}
	
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	
	public float getPrecio() {
		return precio;
	}
	
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public Publicacion getPublicacion() {
		return publicacion;
	}
	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}
	public boolean SosEdicion (int c){
		return this.codigo==c;
	}
	

}
