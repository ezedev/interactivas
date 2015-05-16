package modelo;

import java.util.Vector;

public abstract class Publicacion {
	
	public final static String TIPO_DIARIO = "D";
	public final static String TIPO_REVISTA = "R";
	
	protected String codigo;
	protected String titulo;
	protected String editor;
	protected String tema;
	protected String subtema;
	protected String publico;
	protected Vector <Edicion> ediciones;
	protected String idioma;
	protected String paisDeOrigen;

	public Publicacion(String codigo, String titulo, String editor, String tema,String subtema, String publico, String idioma, String paisDeOrigen) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.editor = editor;
		this.tema = tema;
		this.subtema = subtema;
		this.publico = publico;
		this.ediciones = new Vector <Edicion> ();
		this.idioma = idioma;
		this.paisDeOrigen = paisDeOrigen;
	}

	public Vector<Edicion> getEdiciones() {
		return ediciones;
	}

	public void setEdiciones(Vector<Edicion> ediciones) {
		this.ediciones = ediciones;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getSubtema() {
		return subtema;
	}

	public void setSubtema(String subtema) {
		this.subtema = subtema;
	}

	public String getPublico() {
		return publico;
	}

	public void setPublico(String publico) {
		this.publico = publico;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getPaisDeOrigen() {
		return paisDeOrigen;
	}

	public void setPaisDeOrigen(String paisDeOrigen) {
		this.paisDeOrigen = paisDeOrigen;
	}

	public abstract Vector <Edicion> obtenerUltimas3 ();
	

}
