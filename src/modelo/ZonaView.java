package modelo;

public class ZonaView {

	private String codigo;
	private String nombre;
	private float coeficiente;
	
	public ZonaView(String codigo, String nombre, float coeficiente) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.coeficiente = coeficiente;
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
