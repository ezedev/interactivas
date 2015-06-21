package modelo;

import java.util.Map;

public abstract class Pauta {

	public static final String ESTADO_ACTIVA = "A";
	public static final String ESTADO_INACTIVA = "I";
	
	protected String codigo;
	protected String estado;
	
	public Pauta(String codigo, String estado) {
		super();
		this.codigo = codigo;
		this.estado = estado;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public String getEstado() {
		return estado;
	}

	public boolean estasActiva() {
		
		return this.estado.equals(Pauta.ESTADO_ACTIVA);
	}
	
	public boolean sosPauta(String codigo) {
		
		return this.codigo.equals(codigo);
	}
	
	public abstract void aplicar(Colocacion colocacionActual, Map<String, Object> parametrosPauta); 
}
