package modelo;

import java.util.Date;
import java.util.Vector;

public class Colocacion {

	private int id;
	private Date fecha;
	private Vector<ItemColocacion> items;
	
	public Colocacion(Date fecha) {
		super();
		this.fecha = fecha;
	}
	
	public Colocacion() {
		super();
	}

	public void crearItem(Edicion edicion, Vendedor vendedor, int cantidadEntrega) {
		
		ItemColocacion itemColocacion = new ItemColocacion(cantidadEntrega, 0, edicion, vendedor);
		
		this.items.add(itemColocacion);
	}
	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Vector<ItemColocacion> getItems() {
		return items;
	}

	public void setItems(Vector<ItemColocacion> items) {
		this.items = items;
	}

	public int aplicarPauta (String nombrePauta, String codigoEdicion, String codigoVendedor){
		int totalAdicional=0;
		
		ItemColocacion it = buscarItemVendedorEdicion (codigoVendedor,codigoEdicion);
	
		switch (nombrePauta){
		
		case "Agotado":
			PautaAgotado pa = new PautaAgotado ();
			totalAdicional = pa.getCantidad(it.getCantidadEntrega(), it.getCantidadDevolucion());
			break;
		case "Exceso":
			PautaExceso pe = new PautaExceso ();
			totalAdicional = pe.getCantidad(it.getCantidadEntrega(), it.getCantidadDevolucion());
			break;
		case "Zona":
			PautaZona pz = new PautaZona ();
			totalAdicional = pz.getCantidad(it.getCantidadEntrega(), it.getCantidadDevolucion());
			break;
		default:
			System.out.println("Nombre de Pauta mal ingresado");
			break;
		}
		return totalAdicional;
	}
	
	public ItemColocacion buscarItemVendedorEdicion (String codigoEdicion, String codigoVendedor ){
		for (int i=0; i< this.items.size(); i++){
			if (this.items.get(i).getVendedor().sosVendedor(codigoVendedor) && this.items.get(i).getEdicion().SosEdicion(codigoEdicion))
				return this.items.get(i);
		}
		return null;
	}
}
