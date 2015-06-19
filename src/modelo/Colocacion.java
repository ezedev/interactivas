package modelo;

import java.util.Date;
import java.util.Vector;

import persistencia.CargaVendedorView;

public class Colocacion {

	private Date fecha;
	private Vector<ItemColocacion> items;
	private Edicion edicion;
	
	public Colocacion(Date fecha, Edicion edicion) {
		super();
		this.fecha = fecha;
		this.edicion = edicion;
	}
	
	public Colocacion() {
		super();
	}

	public void crearItem(Vendedor vendedor, int cantidadEntrega) {
		
		ItemColocacion itemColocacion = new ItemColocacion(cantidadEntrega, 0, vendedor);
		
		this.items.add(itemColocacion);
	}
	
	public void crearItem(Vendedor vendedor, int cantidadEntrega, int cantidadDevolucion) {
		
		ItemColocacion itemColocacion = new ItemColocacion(cantidadEntrega, cantidadDevolucion, vendedor);
		
		this.items.add(itemColocacion);
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
	
	public Edicion getEdicion() {
		return edicion;
	}

	public void setEdicion(Edicion edicion) {
		this.edicion = edicion;
	}

	public void crearItems(Vector<CargaVendedorView> cargas) {
		
		Vector<ItemColocacion> items = new Vector<ItemColocacion>();
		
		for (CargaVendedorView carga : cargas) {
			
			ItemColocacion item = new ItemColocacion();
			item.setCantidadEntrega(carga.getSalida());
			Vendedor vendedor = new DiarieroExclusivo();
			vendedor.setCodigo(carga.getCodigoVendedor());
			item.setVendedor(vendedor);
			item.setCantidadDevolucion(0);
			
			items.add(item);
		}
		this.setItems(items);
		
	}

	// TODO rever
//	public int aplicarPauta (String nombrePauta, String codigoVendedor){
//		int totalAdicional=0;
//		
////		ItemColocacion it = buscarItemVendedorEdicion (codigoVendedor,codigoEdicion);
//	
//		switch (nombrePauta){
//		
//		case "Agotado":
//			PautaAgotado pa = new PautaAgotado ();
//			totalAdicional = pa.getCantidad(it.getCantidadEntrega(), it.getCantidadDevolucion());
//			break;
//		case "Exceso":
//			PautaExceso pe = new PautaExceso ();
//			totalAdicional = pe.getCantidad(it.getCantidadEntrega(), it.getCantidadDevolucion());
//			break;
//		case "Zona":
//			PautaZona pz = new PautaZona ();
//			totalAdicional = pz.getCantidad(it.getCantidadEntrega(), it.getCantidadDevolucion());
//			break;
//		default:
//			System.out.println("Nombre de Pauta mal ingresado");
//			break;
//		}
//		return totalAdicional;
//	}
	
//	public ItemColocacion buscarItemVendedorEdicion (String codigoEdicion, String codigoVendedor ){
//		for (int i=0; i< this.items.size(); i++){
//			if (this.items.get(i).getVendedor().sosVendedor(codigoVendedor) && this.items.get(i).getEdicion().SosEdicion(codigoEdicion))
//				return this.items.get(i);
//		}
//		return null;
//	}
}
