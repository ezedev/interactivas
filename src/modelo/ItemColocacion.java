package modelo;

public class ItemColocacion {

	private int codigo;
	private int cantidad;
	private Edicion edicion;
	private Vendedor vendedor;
	
	public ItemColocacion(int codigo, int cantidad, Edicion edicion,
			Vendedor vendedor) {
		super();
		this.codigo = codigo;
		this.cantidad = cantidad;
		this.edicion = edicion;
		this.vendedor = vendedor;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Edicion getEdicion() {
		return edicion;
	}

	public void setEdicion(Edicion edicion) {
		this.edicion = edicion;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public int getCodigo() {
		return codigo;
	}
	
	
	
}
