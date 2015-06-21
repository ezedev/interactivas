package modelo;

public class ItemColocacion {

	private int cantidadEntrega;
	private int cantidadDevolucion;
	private Vendedor vendedor;
	
	public ItemColocacion(int cantidadEntrega, int cantidadDevolucion, Vendedor vendedor) {
		super();
		this.cantidadEntrega = cantidadEntrega;
		this.cantidadDevolucion = cantidadDevolucion;
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

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
	public ReporteColocacionView toView(){
		ReporteColocacionView reporteView = new ReporteColocacionView();
		reporteView.setCantDevuelta(cantidadDevolucion);
		reporteView.setCantEntregada(cantidadEntrega);
		reporteView.setVendedor(vendedor.getDireccion());
		return reporteView;
	}
}
