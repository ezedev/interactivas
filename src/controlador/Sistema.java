package controlador;

import java.util.Date;
import java.util.Vector;

import modelo.Edicion;
import modelo.Publicacion;
import modelo.Vendedor;

public class Sistema {
	
	private Vector<Vendedor> vendedores;
	private Vector<Edicion> ediciones;
	
	public Sistema(Vector<Vendedor> vendedores, Vector<Publicacion> publicaciones) {
		super();
		this.vendedores = new Vector<Vendedor>();
		this.ediciones = new Vector<Edicion>();
	}

	public Vector<Edicion> buscarEdiciones (Date fecha){
		Vector<Edicion> edicionesBuscadas = new Vector<Edicion>();
		for(Edicion edicion: ediciones){
			if (edicion.getFechaSalida().equals(fecha)){
				edicionesBuscadas.add(edicion);
			}
		}
		return edicionesBuscadas;
	}
	
	public Edicion buscarEdicion (int codigo){
		for(Edicion edicion: ediciones){
			if (edicion.getCodigo()==codigo)
				return edicion;
		}
		return null;
	}
	
}

