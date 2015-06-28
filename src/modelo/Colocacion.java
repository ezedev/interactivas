package modelo;

import java.util.Date;
import java.util.Map;
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
		this.items = new Vector<ItemColocacion>();
	}
	
	public Colocacion() {
		super();
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

	public void crearItem(Vendedor vendedor, int cantidadEntrega, int cantidadDevolucion) {
		
		ItemColocacion itemColocacion = new ItemColocacion();
		itemColocacion.setVendedor(vendedor);
		itemColocacion.setCantidadEntrega(cantidadEntrega);
		itemColocacion.setCantidadDevolucion(cantidadDevolucion);
		this.items.add(itemColocacion);
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
	
	public void actualizarCantidadesEntrega(Vector<CargaVendedorView> cargas) {
		
		for(CargaVendedorView carga : cargas) {
			
			for(ItemColocacion itemColocacion : this.items) {
				
				if(itemColocacion.getVendedor().sosVendedor(carga.getCodigoVendedor())) {
					
					itemColocacion.setCantidadEntrega(carga.getSalida());
				}
			}
		}
	}
	
	public Vector<CargaVendedorView> getCantidadesEntrega() {
		
		Vector<CargaVendedorView> cargas = new Vector<CargaVendedorView>();
		
		for(ItemColocacion itemColocacion : this.items) {

			CargaVendedorView carga = new CargaVendedorView();
			carga.setSalida(itemColocacion.getCantidadEntrega());
			carga.setCodigoVendedor(itemColocacion.getVendedor().getCodigo());
			cargas.add(carga);
		}
		
		return cargas;
	}

	public void aplicarPauta(Pauta pauta, Map<String, Object> parametrosPauta) {
		
		pauta.aplicar(this, parametrosPauta);
	}
}
