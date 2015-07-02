/**
 * 
 */
package persistencia;

/**
 * @author lfuschetto
 *
 */
public class CargaVendedorView {

	private String codigoVendedor;
	private String direccionVendedor;
	private int carga1;
	private int devolucion1;
	private int carga2;
	private int devolucion2;
	private int carga3;
	private int devolucion3;
	private int salida;
	private int devolucion;
	
	
	/**
     * @param codigoVendedor
     * @param direccionVendedor
     * @param carga1
     * @param devolucion1
     * @param carga2
     * @param devolucion2
     * @param carga3
     * @param devolucion3
     * @param salida
     */
    public CargaVendedorView(String codigoVendedor, String direccionVendedor, int carga1,
            int devolucion1, int carga2, int devolucion2, int carga3, int devolucion3, int salida) {

	    super();
	    this.codigoVendedor = codigoVendedor;
	    this.direccionVendedor = direccionVendedor;
	    this.carga1 = carga1;
	    this.devolucion1 = devolucion1;
	    this.carga2 = carga2;
	    this.devolucion2 = devolucion2;
	    this.carga3 = carga3;
	    this.devolucion3 = devolucion3;
	    this.salida = salida;
    }
    
    public CargaVendedorView() {
    	
    }

	/**
	 * Devuelve el valor de codigoVendedor.
	 *
	 * @return El valor de codigoVendedor.
	 */
	public String getCodigoVendedor() {

		return codigoVendedor;
	}

	/**
	 * Asigna un nuevo valor a codigoVendedor.
	 *
	 * @param codigoVendedor El valor a asignar a codigoVendedor.
	 */
	public void setCodigoVendedor(String codigoVendedor) {

		this.codigoVendedor = codigoVendedor;
	}

	/**
	 * Devuelve el valor de direccionVendedor.
	 *
	 * @return El valor de direccionVendedor.
	 */
	public String getDireccionVendedor() {

		return direccionVendedor;
	}

	/**
	 * Asigna un nuevo valor a direccionVendedor.
	 *
	 * @param direccionVendedor El valor a asignar a direccionVendedor.
	 */
	public void setDireccionVendedor(String direccionVendedor) {

		this.direccionVendedor = direccionVendedor;
	}

	/**
	 * Devuelve el valor de carga1.
	 *
	 * @return El valor de carga1.
	 */
	public int getCarga1() {

		return carga1;
	}

	/**
	 * Asigna un nuevo valor a carga1.
	 *
	 * @param carga1 El valor a asignar a carga1.
	 */
	public void setCarga1(int carga1) {

		this.carga1 = carga1;
	}

	/**
	 * Devuelve el valor de devolucion1.
	 *
	 * @return El valor de devolucion1.
	 */
	public int getDevolucion1() {

		return devolucion1;
	}

	/**
	 * Asigna un nuevo valor a devolucion1.
	 *
	 * @param devolucion1 El valor a asignar a devolucion1.
	 */
	public void setDevolucion1(int devolucion1) {

		this.devolucion1 = devolucion1;
	}

	/**
	 * Devuelve el valor de carga2.
	 *
	 * @return El valor de carga2.
	 */
	public int getCarga2() {

		return carga2;
	}

	/**
	 * Asigna un nuevo valor a carga2.
	 *
	 * @param carga2 El valor a asignar a carga2.
	 */
	public void setCarga2(int carga2) {

		this.carga2 = carga2;
	}

	/**
	 * Devuelve el valor de devolucion2.
	 *
	 * @return El valor de devolucion2.
	 */
	public int getDevolucion2() {

		return devolucion2;
	}

	/**
	 * Asigna un nuevo valor a devolucion2.
	 *
	 * @param devolucion2 El valor a asignar a devolucion2.
	 */
	public void setDevolucion2(int devolucion2) {

		this.devolucion2 = devolucion2;
	}

	/**
	 * Devuelve el valor de carga3.
	 *
	 * @return El valor de carga3.
	 */
	public int getCarga3() {

		return carga3;
	}

	/**
	 * Asigna un nuevo valor a carga3.
	 *
	 * @param carga3 El valor a asignar a carga3.
	 */
	public void setCarga3(int carga3) {

		this.carga3 = carga3;
	}

	/**
	 * Devuelve el valor de devolucion3.
	 *
	 * @return El valor de devolucion3.
	 */
	public int getDevolucion3() {

		return devolucion3;
	}

	/**
	 * Asigna un nuevo valor a devolucion3.
	 *
	 * @param devolucion3 El valor a asignar a devolucion3.
	 */
	public void setDevolucion3(int devolucion3) {

		this.devolucion3 = devolucion3;
	}

	/**
	 * Devuelve el valor de salida.
	 *
	 * @return El valor de salida.
	 */
	public int getSalida() {

		return salida;
	}

	/**
	 * Asigna un nuevo valor a salida.
	 *
	 * @param salida El valor a asignar a salida.
	 */
	public void setSalida(int salida) {

		this.salida = salida;
	}

	public int getDevolucion() {
		return devolucion;
	}

	public void setDevolucion(int devolucion) {
		this.devolucion = devolucion;
	}
}
