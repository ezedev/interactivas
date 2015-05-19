package modelo;

public class PautaExceso extends Pauta {

	public PautaExceso() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getCantidad (int cantidadCargada, int cantidadDevuelta) {
		int cantidadExceso = 0;
		if (cantidadDevuelta - (cantidadCargada - cantidadDevuelta) > 0)
			cantidadExceso = cantidadCargada - (cantidadDevuelta - (cantidadCargada - cantidadDevuelta));
		return cantidadExceso;
	}

}
