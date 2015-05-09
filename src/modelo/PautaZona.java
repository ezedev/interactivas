package modelo;

public class PautaZona extends Pauta {

	private String nombre;
	private String codPostal;
	private int  codZona;
	
	

	public PautaZona(String nombre, String codPostal, int codZona) {
		super();
		this.nombre = nombre;
		this.codPostal = codPostal;
		this.codZona = codZona;
	}



	@Override
	public int getCantidad(Edicion edicion, Vendedor vendedor) {
		// TODO Auto-generated method stub
		return 0;
	}

}
