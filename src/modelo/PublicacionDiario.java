package modelo;
import java.util.Calendar;
import java.util.Vector;

import ventanas.Utils;

public class PublicacionDiario extends Publicacion{

	public PublicacionDiario(String codigo, 
							 String titulo, 
							 String editor, 
							 String tema, 
							 String subtema, 
							 String publico, 
							 String idioma, 
							 String paisDeOrigen) {
		
		super(codigo, titulo, editor, tema, subtema, publico, idioma,paisDeOrigen);
	}
	
	public Vector<Edicion> obtenerUltimas3() {
		
		Vector<Edicion> edicionesAnteriores = new Vector<Edicion>();
		
		/**
		 * Calculamos el dia de mañana y de ahi vamos restando de a 7
		 */
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 1);
		calendar.add(Calendar.DATE, -7 * 4);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		System.out.println("Buscando diarios anteriores a la fecha...");
		
		int index = 1;
		
		for (Edicion edicion : this.getEdiciones()){
			
			if(index <= 3) {
			
				System.out.println("CONDICION " + edicion.getFechaSalida().toString() + " es igual a " + calendar.getTime().toString() + " ??");
			
				if (edicion.getFechaSalida().equals(calendar.getTime())) {
					
					edicionesAnteriores.add(edicion);
					calendar.add(Calendar.DATE, 7);
					index++;
					
					System.out.println("Encontramos diario anterior. " + 
									   "Fecha de salida: " + edicion.getFechaSalida() + " " + 
									   "Codigo de edicion: " + edicion.getCodigo());
				}
			}
		}
		
		System.out.println("Cantidad de ediciones anteriores a la fecha: " + edicionesAnteriores.size());
		
		return edicionesAnteriores;
	}

}
