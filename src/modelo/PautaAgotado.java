package modelo;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class PautaAgotado extends Pauta {

	public final static String CODIGO_PAUTA = "AGOTADO";
	
	private Map<Integer, Integer> tablaAgotado = new HashMap<Integer, Integer>();
	
	public PautaAgotado(String codigo, String estado) {
		
		super(codigo, estado);
		
		this.tablaAgotado = new HashMap<Integer, Integer>();
		this.tablaAgotado.put(1, 3);
		this.tablaAgotado.put(2, 5);
		this.tablaAgotado.put(6, 10);
	}

	@Override
	public void aplicar(Colocacion colocacion, Map<String, Object> parametrosPauta) {
		
		/**
		 * Obtengo todos los vendedores que venden la publicacion
		 */
		
		Vector<Vendedor> vendedoresPublicacion = new Vector<Vendedor>();
		
		for(ItemColocacion itemColocacion : colocacion.getItems()) {
			
			vendedoresPublicacion.add(itemColocacion.getVendedor());
		}
		
		/**
		 * Verifico las ultimas colocaciones. El usuario ingreso la cantidad.
		 */
		
		int cantidadColocacionesAnteriores = Integer.parseInt(parametrosPauta.get("cantidadColocacionesAnteriores").toString());
		
		Vector<Edicion> edicionesAnteriores = colocacion.getEdicion().getPublicacion().obtenerEdicionesAnteriores(cantidadColocacionesAnteriores);
		
		for(Vendedor vendedor : vendedoresPublicacion) {
		
			int cantidadColocacionesAgotadas = 0;
			
			for(Edicion edicionAnterior : edicionesAnteriores) {
				
				if(edicionAnterior.estaColocada()) {
				
					for(ItemColocacion itemColocacionAnterior : edicionAnterior.getColocacion().getItems()) {
						
						if(itemColocacionAnterior.getVendedor().sosVendedor(vendedor.getCodigo())) {
							
							if(itemColocacionAnterior.getCantidadEntrega() > 0 
								&& itemColocacionAnterior.getCantidadDevolucion() == 0) {
								
								cantidadColocacionesAgotadas++;
							}
						}
					}
				}
			}
			
			/**
			 * Buscamos en la tabla el parametro a aplicar segun la cantidad de veces
			 * que agoto
			 */
			
			int cantidadAgotadosAplicar = 0;
			
			for(int cantidadAgotadosParametroTabla : this.tablaAgotado.keySet()) {
				
				if(cantidadColocacionesAgotadas >= cantidadAgotadosParametroTabla) {
					
					cantidadAgotadosAplicar = cantidadAgotadosParametroTabla;
				}
			}
			
			/**
			 * Incrementamos las cantidades segun la tabla
			 */
			
			if(cantidadAgotadosAplicar > 0) {
				
				for(ItemColocacion itemColocacion : colocacion.getItems()) {
					
					if(itemColocacion.getVendedor().sosVendedor(vendedor.getCodigo())) {
						
						int cantidadIncrementar = tablaAgotado.get(cantidadAgotadosAplicar);
						
						itemColocacion.setCantidadEntrega(itemColocacion.getCantidadEntrega() + cantidadIncrementar);
					}
				}
			}
		}
	}
}
