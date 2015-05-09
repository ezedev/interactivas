package modelo;

import java.util.Vector;

public class PublicacionDiario extends Publicacion{

	public PublicacionDiario(int codigo, String titulo, String editor,String tema, String subtema, String publico, String idioma, String paisDeOrigen) {
		super(codigo, titulo, editor, tema, subtema, publico, idioma,paisDeOrigen);
	}

	
	public Vector<Edicion> obtenerUltimas3() {
		return null;
	}

}
