package modelo;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class PautaExceso extends Pauta {

	public final static String CODIGO_PAUTA = "EXCESO";
	
	private Map<Integer, Integer> tablaExceso;
	
	public PautaExceso(String codigo, String estado) {
		
		super(codigo, estado);

		/**
		 * Tabla de exceso en porcentajes:
		 * 
		 *  EJ: Si devolvio el 50% le descontamos el 45%
		 *  
		 *  Si devuelve mas del 100% se lo penaliza al 100%.
		 */
		
		this.tablaExceso = new HashMap<Integer, Integer>();
		this.tablaExceso.put(25, 20);
		this.tablaExceso.put(50, 45);
		this.tablaExceso.put(75, 70);
		this.tablaExceso.put(100, 95);
	}

	@Override
	public void aplicar(Colocacion colocacion, Map<String, Object> parametrosPauta) {
		
		/**
		 * Esta pauta trabaja con la colocacion anterior...
		 */
		
		Vector<Edicion> edicionesAnteriores = colocacion.getEdicion().getPublicacion().obtenerEdicionesAnteriores(1);
		
		if(edicionesAnteriores.size() > 0) {
		
			Edicion edicionAnterior = edicionesAnteriores.firstElement();
			
			if(edicionAnterior.estaColocada()) {
			
				for(ItemColocacion itemColocacionAnterior : edicionAnterior.getColocacion().getItems()) {
					
					float porcentajeDevolucion = itemColocacionAnterior.getCantidadDevolucion() * 100 / (float)itemColocacionAnterior.getCantidadEntrega();
					float porcentajePenalizacionAplicar = 0;
					
					for(int porcentajePenalizacion : tablaExceso.keySet()) {
						
						if(porcentajeDevolucion > porcentajePenalizacion) {
							
							porcentajePenalizacionAplicar = porcentajePenalizacion;
						}
					}
					
					if(porcentajePenalizacionAplicar > 0) {
					
						for(ItemColocacion itemColocacionActual : colocacion.getItems()) {
						
							if(itemColocacionActual.getVendedor().sosVendedor(itemColocacionAnterior.getVendedor().getCodigo())) {
							
								itemColocacionActual.setCantidadEntrega(itemColocacionAnterior.getCantidadEntrega() - (int)porcentajePenalizacionAplicar * 100 /itemColocacionAnterior.getCantidadEntrega());
							}
						}
					}
				}
			}
		}
	}
}
