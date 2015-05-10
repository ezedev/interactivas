package modelo;

import java.util.Date;
import java.util.Vector;

public class Colocacion {

	private int codigo;
	private Date fecha;
	private Vector<ItemColocacion> items;
	
	public Colocacion(Date fecha) {
		super();
		this.fecha = fecha;
	}

	public void crearItem(Edicion edicion, Vendedor vendedor, int cantidadEntrega) {
		
		ItemColocacion itemColocacion = new ItemColocacion(cantidadEntrega, 0, edicion, vendedor);
		
		this.items.add(itemColocacion);
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
