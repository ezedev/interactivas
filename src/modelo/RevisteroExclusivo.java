package modelo;

import java.util.Vector;

public class RevisteroExclusivo extends Vendedor {
	
	public RevisteroExclusivo(int codigo, String direccion, Vector<Publicacion> publicaciones, Zona zona) {
		
		super(codigo, direccion, publicaciones, zona);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean vendesPublicaciones(Publicacion pub) {
		// TODO Auto-generated method stub
		return false;
	}

}
