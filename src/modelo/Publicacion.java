package modelo;

import java.util.Vector;

public abstract class Publicacion {
	
	private int codigo;
	private String titulo;
	private String editor;
	private String tema;
	private String subtema;
	private String publico;
	private Vector <Vendedor> periocidad;
	private Vector <Edicion> ediciones;
	private String idioma;
	private String paisDeOrigen;
	
	public Publicacion(int codigo, String titulo, String editor, String tema,String subtema, String publico, String idioma, String paisDeOrigen) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.editor = editor;
		this.tema = tema;
		this.subtema = subtema;
		this.publico = publico;
		this.periocidad = new Vector <Vendedor> ();
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

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
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

	public Vector<Vendedor> getPeriocidad() {
		return periocidad;
	}

	public void setPeriocidad(Vector<Vendedor> periocidad) {
		this.periocidad = periocidad;
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
