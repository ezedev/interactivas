package modelo;

import java.util.Vector;

public class DiarieroRevistero extends Vendedor {


	public DiarieroRevistero(int codigo, String direccion, Vector<Publicacion> publicaciones, Zona zona) {
		
		super(codigo, direccion, publicaciones, zona);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean vendesPublicaciones(Publicacion pub) {
		// TODO Auto-generated method stub
		return false;
	}

}
