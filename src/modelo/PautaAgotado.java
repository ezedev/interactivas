package modelo;

public class PautaAgotado extends Pauta {

	public PautaAgotado() {
		// TODO Auto-generated constructor stub
	}
	
	public int getCantidad(int cantidadCargada, int cantidadDevuelta) {
		
		int rango_menor = 0, rango_mayor = 0, cantidad_adicional = 0;
		
		//calculo la cantidad a asignar
		if (cantidadCargada - cantidadDevuelta == 0 && cantidadCargada == 1)
				cantidad_adicional = cantidadDevuelta + 3;
		else{
			if (cantidadCargada - cantidadDevuelta == 0){
				rango_menor = 2;
				rango_mayor = 5;
				
				for (int contador=0; contador <= cantidadDevuelta; contador++){
						
					if (rango_menor >= cantidadDevuelta && rango_mayor <= cantidadDevuelta){
						//si encuentro que la cantidad devuelta esta dentro del rango, 
						//devuelvo el mayor valor de ese rango
						
						cantidad_adicional = cantidadDevuelta + rango_mayor;
						break;
					}
					//sigo buscando el valor devuelto pero en otro rango
					
					rango_menor = rango_mayor+1;
					rango_mayor = rango_mayor*2;
				}
			}
		}
		return cantidad_adicional;
	}
}
