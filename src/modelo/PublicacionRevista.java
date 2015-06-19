package modelo;

import java.util.Calendar;
import java.util.Vector;

public class PublicacionRevista extends Publicacion{

	public PublicacionRevista(String codigo, 
							  String titulo, 
							  String editor,
							  String tema, 
							  String subtema, 
							  String publico, 
							  String idioma, 
							  String paisDeOrigen) {
		super(codigo, titulo, editor, tema, subtema, publico, idioma,paisDeOrigen);
	}

	public Vector <Edicion> obtenerUltimas3() {
	
		Vector<Edicion> edicionesAnteriores = new Vector<Edicion>();
		
		/**
		 * Calculamos el dia de hoy para imprimirlo
		 */
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);		
		
		System.out.println("Buscando revistas anteriores a la fecha: " + calendar.getTime().toString());
		
		int index = 1;
		
		for (Edicion edicion : this.getEdiciones()){
			
			if (edicion.getFechaSalida().getTime() < calendar.getTime().getTime() && index <= 3) {

				edicionesAnteriores.add(edicion);
				
				index++;
				
				System.out.println("Encontramos diario anterior. " + 
						   "Fecha de salida: " + edicion.getFechaSalida() + " " + 
						   "Codigo de edicion: " + edicion.getCodigo());				
			}
		}
		
		System.out.println("Cantidad de ediciones anteriores a la fecha: " + edicionesAnteriores.size());		
		
		return edicionesAnteriores;
	}
}
