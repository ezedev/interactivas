package modelo;

import java.util.Vector;

public class PublicacionRevista extends Publicacion{

	public PublicacionRevista(String codigo, String titulo, String editor,String tema, String subtema, String publico, String idioma, String paisDeOrigen) {
		super(codigo, titulo, editor, tema, subtema, publico, idioma,paisDeOrigen);
	}

	public Vector <Edicion> obtenerUltimas3() {
		Vector <Edicion> e = getEdiciones();
		Vector <Edicion> ultimas3 = new Vector <Edicion> ();
		//busco las ultimas 3, 2 o 1 ediciones consecutivas
		for (int i=e.size()-1; i >= 0 && ultimas3.size() < 3; i--)
			ultimas3.add(e.elementAt(i));
		return ultimas3;
	}

}
