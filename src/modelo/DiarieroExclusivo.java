package modelo;

import java.util.Vector;

public class DiarieroExclusivo extends Vendedor {



	public DiarieroExclusivo(String direccion,
			Vector<Publicacion> publicaciones, Zona zona) {
		super(direccion, publicaciones, zona);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean vendesPublicaciones(Publicacion pub) {
		// TODO Auto-generated method stub
		return false;
	}

}
