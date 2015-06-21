package modelo;

import java.util.Date;

import persistencia.ColocacionesMapper;

public class Edicion{

	private String codigo;
	private String tituloTapa;
	private Date fechaSalida;
	private float precio;
	private Publicacion publicacion;
	private Colocacion colocacion;

	public Edicion() {
		
	}	
	
	public Edicion (String codigo, String tituloTapa, Date fechaSalida, float precio, Publicacion publicacion) {
		super();
		this.codigo = codigo;
		this.tituloTapa = tituloTapa;
		this.fechaSalida = fechaSalida;
		this.precio = precio;
	}

	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
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
	
	public boolean estaColocada() {
		
		return this.getColocacion() != null;
	}
	
	public Colocacion getColocacion() {

		if(this.colocacion == null) { 
		
			this.colocacion = ColocacionesMapper.getInstance().getInstance().find(this.fechaSalida, this.codigo);
		}
		
		return this.colocacion;
	}

	public void setColocacion(Colocacion colocacion) {
		this.colocacion = colocacion;
	}

	public boolean SosEdicion (String c){
		return this.codigo.equals(c);
	}
	
	public EdicionView toView() {
		return new EdicionView(codigo, tituloTapa, fechaSalida, precio, publicacion);
	}
}
