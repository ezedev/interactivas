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
	
	public Vector<Edicion> obtenerEdicionesAnteriores(int cantidad) {
		
		Vector<Edicion> edicionesAnteriores = new Vector<Edicion>();
		
		/**
		 * Calculamos el dia de mañana y de ahi vamos restando de a 7
		 */
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 1);
		calendar.add(Calendar.DATE, -7);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		System.out.println("Buscando diarios anteriores a la fecha...");
		
		int cantidadEncontradas = 1;
		
		for(int i = this.getEdiciones().size() - 1; i >= 0; i--) {
			
			if(cantidadEncontradas < cantidad + 1) {
			
				System.out.println("CONDICION " + this.getEdiciones().elementAt(i).getFechaSalida().toString() + " es igual a " + calendar.getTime().toString() + " ??");
			
				if (this.getEdiciones().elementAt(i).getFechaSalida().equals(calendar.getTime())) {
					
					edicionesAnteriores.add(this.getEdiciones().elementAt(i));
					calendar.add(Calendar.DATE, -7);
					cantidadEncontradas++;
					
					System.out.println("Encontramos diario anterior. " + 
									   "Fecha de salida: " + this.getEdiciones().elementAt(i).getFechaSalida() + " " + 
									   "Codigo de edicion: " + this.getEdiciones().elementAt(i).getCodigo());
				}
			}
		}
		
		System.out.println("Cantidad de ediciones anteriores a la fecha: " + edicionesAnteriores.size());
		
		return edicionesAnteriores;
	}

}
