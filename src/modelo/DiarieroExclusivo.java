package modelo;

import java.util.Vector;

public class DiarieroExclusivo extends Vendedor {

	public DiarieroExclusivo(String codigo, 
							 String direccion, 
							 Vector<Publicacion> publicaciones, 
							 Zona zona) {
		
		super(codigo, direccion, publicaciones, zona);
		// TODO Auto-generated constructor stub
	}

	
	public boolean vendesPublicaciones(Publicacion pub) {
		// TODO Auto-generated method stub
		return false;
	}

}
