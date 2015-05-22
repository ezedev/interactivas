package modelo;

public class ItemColocacion {

	private int cantidadEntrega;
	private int cantidadDevolucion;
	private Edicion edicion;
	private Vendedor vendedor;
	
	public ItemColocacion(int cantidadEntrega, int cantidadDevolucion, Edicion edicion, Vendedor vendedor) {
		super();
		this.cantidadEntrega = cantidadEntrega;
		this.cantidadDevolucion = cantidadDevolucion;
		this.edicion = edicion;
		this.vendedor = vendedor;
	}
	
	public ItemColocacion() {
		
	}

	public int getCantidadEntrega() {
		return cantidadEntrega;
	}

	public void setCantidadEntrega(int cantidadEntrega) {
		this.cantidadEntrega = cantidadEntrega;
	}

	public int getCantidadDevolucion() {
		return cantidadDevolucion;
	}

	public void setCantidadDevolucion(int cantidadDevolucion) {
		this.cantidadDevolucion = cantidadDevolucion;
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
	
}
