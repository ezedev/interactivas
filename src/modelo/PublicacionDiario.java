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
		Vector <Edicion> e = getEdiciones();
		Vector <Edicion> ultimas3 = new Vector <Edicion> ();
		Calendar hoy = Calendar.getInstance();
		hoy.add(Calendar.DAY_OF_YEAR, 1);
		hoy.add(Calendar.DAY_OF_YEAR, -7);
		//busco las ultimas edicones segun el dia (pueden ser 1,2 o 3)
			for (int i=e.size()-1; i >= 0 && ultimas3.size() < 3; i--){
				if (Utils.mismoDia(hoy.getTime(), e.elementAt(i).getFechaSalida())) {
				
				
//				if (hoy.getTime().equals(e.elementAt(i).getFechaSalida())){
					ultimas3.add(e.elementAt(i));
					hoy.add(Calendar.DATE, -7);;
				}
			}
	return ultimas3;
	}

}
