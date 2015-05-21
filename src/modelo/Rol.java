package modelo;

import java.util.Vector;

public class Rol {
	private String codigo;
	private String nombre;
	private Vector<Modulo> modulos;
	
	public Rol() {
		super();
	}

	public Rol(String codigo, String nombre, Vector<Modulo> modulos) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.modulos = modulos;
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
	}
	
	public Vector<Modulo> getModulos() {
		return modulos;
	}
	public void setModulos(Vector<Modulo> modulos) {
		this.modulos = modulos;
	}
	public boolean tieneAcceso(String modulo){
		
		boolean tieneAcceso = false;
		
		 for(Modulo m : modulos){
			 
			 if(m.getCodigo().equals(modulo)){
			
				 tieneAcceso = true;
			 }
		 }
		 
		 return tieneAcceso;
	}
	
	
}
