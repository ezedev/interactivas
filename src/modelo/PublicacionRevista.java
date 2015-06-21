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

	public Vector <Edicion> obtenerEdicionesAnteriores(int cantidad) {
	
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
		
		int cantidadEncontradas = 1;
		
		for(int i = this.getEdiciones().size() - 1; i >= 0; i--) {
			
			if(cantidadEncontradas < cantidad + 1) {
		
				edicionesAnteriores.add(this.getEdiciones().elementAt(cantidad));
				
				cantidadEncontradas++;
				
				System.out.println("Encontramos revista anterior. " + 
						   "Fecha de salida: " + this.getEdiciones().elementAt(i).getFechaSalida() + " " + 
						   "Codigo de edicion: " + this.getEdiciones().elementAt(i).getCodigo());				
			}
		}
		
		System.out.println("Cantidad de ediciones anteriores a la fecha: " + edicionesAnteriores.size());		
		
		return edicionesAnteriores;
	}
}
