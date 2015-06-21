package modelo;

import java.util.Map;

public class PautaZona extends Pauta {

	public final static String CODIGO_PAUTA = "ZONA";
	
	public PautaZona(String codigo, String estado) {
		
		super(codigo, estado);
	}
	
	@Override
	public void aplicar(Colocacion colocacion, Map<String, Object> parametrosPauta) {
		
		for(ItemColocacion itemColocacion : colocacion.getItems()) {
						
			Zona zonaVendedor = itemColocacion.getVendedor().getZona();
			
			if(zonaVendedor.getCodigo().equals(parametrosPauta.get("codigoZona"))) {
			
				float coeficienteZona = zonaVendedor.getCoeficiente();
				
				if(coeficienteZona > 1) {
					
					float cantidadEntrega = itemColocacion.getCantidadEntrega() * coeficienteZona;
					
					itemColocacion.setCantidadEntrega((int)cantidadEntrega);
				}
			}
		}
	}	
}
