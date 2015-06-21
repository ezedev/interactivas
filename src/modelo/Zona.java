package modelo;

public class Zona {
	private String codigo;
	private String nombre;
	private float coeficiente;
	
	public Zona() {
		super();
	}
	
	public Zona(String codigo, String nombre, float coeficiente) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.coeficiente = coeficiente;
	}
	
	public ZonaView toView() {
		
		return new ZonaView(this.codigo, this.nombre, this.coeficiente);
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

	public float getCoeficiente() {
		return coeficiente;
	}

	public void setCoeficiente(float coeficiente) {
		this.coeficiente = coeficiente;
	}
}
