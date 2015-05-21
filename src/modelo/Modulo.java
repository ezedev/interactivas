package modelo;

public class Modulo {
	
	public static final String MODULO_COLOCACION = "M-COLOCACION";
	public static final String MODULO_EDICIONES = "M-EDICIONES";
	
	private String codigo;
	private String descripcion;
	
	public Modulo(String codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
