package controlador;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import modelo.Colocacion;
import modelo.ComboItem;
import modelo.Edicion;
import modelo.EdicionView;
import modelo.ItemColocacion;
import modelo.Publicacion;
import modelo.Usuario;
import modelo.Vendedor;
import persistencia.CargaVendedorView;
import persistencia.ColocacionesMapper;
import persistencia.EdicionesMapper;
import persistencia.PublicacionesMapper;
import persistencia.UsuariosMapper;
import persistencia.VendedoresMapper;
import ventanas.Utils;

public class Sistema {
	
	private static Sistema instancia= new Sistema();
	private Vector<Publicacion> publicaciones;
	private Vector<Vendedor> vendedores;
	private Vector<Edicion> ediciones;
	private Vector <Colocacion> colocaciones;
	private Usuario usuarioAutenticado;

	private Colocacion colocacion;
	
	private Sistema() {
		super();
		this.vendedores = new Vector<Vendedor>();
		this.ediciones = new Vector<Edicion>();
		this.publicaciones = new Vector<Publicacion>();
	}
	
	public String getFechaSalida(){
		Calendar c = Calendar.getInstance();
		String dia = Integer.toString(c.get(Calendar.DATE)+1);
		String mes = Integer.toString(c.get(Calendar.MONTH));
		String annio = Integer.toString(c.get(Calendar.YEAR));
		String fechaSalida = dia +"/" + mes + "/" + annio;
		return fechaSalida;
	}
	
	/*Implementaci�n patr�n Singleton*/
	
	public static Sistema getInstance(){
		return instancia;
	}
	
	public boolean iniciarSesion(String usuario, String clave) {
		
		this.usuarioAutenticado = UsuariosMapper.getInstance().findByUsuarioClave(usuario, clave);
		
		return this.usuarioAutenticado != null;
	}
	
	public boolean tieneAcceso(String modulo) {
		
		return this.usuarioAutenticado.getRol().tieneAcceso(modulo);
	}

	/**
	 * Busca las ediciones para armar la colocacion.
	 * Son las que tienen fecha de salida de mañana.
	 * 
	 * @return Vector<Edicion>
	 */
	
	public Vector<Edicion> buscarEdicionesParaColocar(){
		
		Vector<Edicion> edicionesBuscadas = new Vector<Edicion>();
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.add(Calendar.DATE, 1);
		Date fechaSalida = calendar.getTime();
		
		for(Edicion edicion: ediciones){
			
			if (edicion.getFechaSalida().equals(fechaSalida)){
				edicionesBuscadas.add(edicion);
			}
		}
		
		return edicionesBuscadas;
	}
	
	public boolean crearColocacion(Vector<CargaVendedorView> cargas, String codigo) {

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);		
		
		Date fechaSalida = Utils.parseFecha(getStringFechaSalida());
		Edicion edicion = EdicionesMapper.getInstance().buscarEdicionXPublicacion(fechaSalida, codigo);
		Colocacion colocacion = new Colocacion(fechaSalida, edicion);
		colocacion.crearItems(cargas);
		
		return ColocacionesMapper.getInstance().insert(colocacion, fechaSalida);

	}
	// TODO ver si se usa
	
//	public void agregarItemColocacion(String codigoEdicion, String codigoVendedor, int cantidadEntrega) {
//		
//		this.colocacion.crearItem(
//			this.buscarEdicion(codigoEdicion), 
//			this.buscarVendedor(codigoVendedor), 
//			cantidadEntrega
//		);
//	}
	
	public String buscarEdicionesXFechaYPublicacion (Date fecha, String publicacion){
		for (Edicion edicion : ediciones) {
			if(edicion.getFechaSalida().equals(fecha) && edicion.getPublicacion().getTitulo() == publicacion)
					return edicion.getTituloTapa();
		}
		return null;
	}
	
	public Edicion buscarEdicion (String codigo){
		for(Edicion edicion: ediciones){
			if (edicion.getCodigo().equals(codigo))
				return edicion;
		}
		return null;
	}

	public Vector<ComboItem> listaPublicaciones() {
		// TODO Auto-generated method stub
		Vector<ComboItem> publicacionesItems = new Vector <ComboItem>();
		
		for (Publicacion publicacion : PublicacionesMapper.getInstance().findAll()) {
			publicacionesItems.add(new ComboItem (String.valueOf(publicacion.getCodigo()), publicacion.getTitulo()));
		}
		return publicacionesItems;
	}	
	
	//para ediciones
	private Publicacion buscarPublicacion(String codigo) {
		
		for (int i = 0 ; i < publicaciones.size() ; i++) {
			
			if(publicaciones.elementAt(i).getCodigo().equals(codigo))
			{
				return publicaciones.elementAt(i);
			}
		}
		return null;
	}
	
	public void altaEdicion(String codigo,String tituloTapa, float precio, Date fechaDeSalida, String CodPublicacion) {
		Edicion nuevaEdicion = buscarEdicion(codigo);		
		Publicacion publicacion = buscarPublicacion(CodPublicacion);
		if(publicacion != null)
		{
			if(nuevaEdicion == null)
			{
				nuevaEdicion = new Edicion(codigo,tituloTapa,fechaDeSalida,precio, publicacion);
				
				ediciones.add(nuevaEdicion);
				
				EdicionesMapper.getInstance().insert(nuevaEdicion);
			}
		}
	}
	
	public void modificacionEdicion(String codigo,String tituloTapa, float precio, Date fechaDeSalida, String CodPublicacion)
	{
			
		Publicacion publicacion = buscarPublicacion(CodPublicacion);
		if(publicacion != null)
		{
			for(Edicion edicion: ediciones)
			{
				if(edicion.getCodigo().equals(codigo))
				{
					edicion.setTituloTapa(tituloTapa);
					edicion.setPrecio(precio);
					edicion.setFechaSalida(fechaDeSalida);
					edicion.setPublicacion(publicacion);
							
					EdicionesMapper.getInstance().update(edicion);
				}
			}
		}
	}
	
	
	public boolean bajaEdicion(String codigo) {
		
		boolean resultadoExitoso = false;
		
		/**
		 * Buscamos la edicion 
		 */
		
		Edicion edicion = buscarEdicion(codigo);
		
		/**
		 * Si encontramos la edicion
		 */
		
		if(edicion != null) {
			
			/**
			 * Calculamos la fecha de colocacion para esta edicion
			 */
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(edicion.getFechaSalida());
			calendar.set(Calendar.HOUR, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.add(Calendar.DATE, -1);
			
			Colocacion colocacion = buscarUltimaColocacion(calendar.getTime());
			
			/**
			 * Si todavia no se hizo la colocacion para esta edicion podemos borrarla
			 */
			
			if(colocacion == null) {
				
				EdicionesMapper.getInstance().delete(edicion);
				
				resultadoExitoso = true;
			}
		}
		
		return resultadoExitoso;
		
	}

	public String getStringFechaSalida() {
		return Utils.getFechaSalidaString();
	}
	
	public EdicionView buscarUltimaEdicionPorPublicacion(String codPublicacion) {

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 1);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);		
		
		Edicion edicion = EdicionesMapper.getInstance().buscarEdicionXPublicacion(
			calendar.getTime(), codPublicacion
		); 
		
		return edicion.toView();	
	}
		
	private Colocacion buscarUltimaColocacion (Date fecha){

		// ARREGLAR RODRIGO!
		// return ColocacionesMapper.getInstance().buscarPorFecha(fecha);
		return null;
	}
	
	public Vector<CargaVendedorView> cargarVendedoresTable (String codPublicacion){
		
		Map <Vendedor , Vector<ItemColocacion>>mapa = new HashMap <Vendedor , Vector<ItemColocacion>>();
		Vector<CargaVendedorView> cargas = new Vector<CargaVendedorView>();

		/**
		 * Buscamos los vendedores que venden la publicacion seleccionada
		 */
		
		Vector<Vendedor> vendedores = VendedoresMapper.getInstance().findVendedoresXPublicacion(codPublicacion);
		
		/**
		 * Generamos los items de colocacion vacios
		 */
		
		for (Vendedor vendedor : vendedores) {
			
			mapa.put(vendedor, new Vector<ItemColocacion>());//Vendedor.getItemsColocacion
		}
		
		/**
		 * Buscamos la publicacion seleccionada para buscar las ultimas 3 ediciones
		 */
		
		Publicacion publicacion = PublicacionesMapper.getInstance().find(codPublicacion);
	
		/**
		 * Obtenemos las 3 ediciones anteriores de la edicion actual para acceder
		 * a la colocacion de cada una de ellas.
		 */
		
		for (Edicion edicion : publicacion.obtenerUltimas3()) {
			
			Colocacion colocacion = ColocacionesMapper.getInstance().find(
				edicion.getFechaSalida(), edicion.getCodigo()
			);
			
			/**
			 * Si encontramos la colocacion, por cada vendedor obtenemos el item.
			 */
			
			if(colocacion != null) {
				
				for (ItemColocacion itemColocacion : colocacion.getItems()) {

					for(Vendedor vendedor: vendedores) {
						
						if(itemColocacion.getVendedor().sosVendedor(vendedor.getCodigo())) {
							
							mapa.get(vendedor).add(itemColocacion);
						}
					}
				}
			}
		}
		
		for (Vendedor vendedor : mapa.keySet()) {
			CargaVendedorView carga = new CargaVendedorView();
			carga.setCodigoVendedor(vendedor.getCodigo());
			carga.setDireccionVendedor(vendedor.getDireccion());
			int nroCarga = 1;
			for (ItemColocacion item : mapa.get(vendedor)) {
				switch (nroCarga) {
				case 1:
					carga.setCarga3(item.getCantidadEntrega());
					carga.setDevolucion3(item.getCantidadDevolucion());
					carga.setSalida(item.getCantidadEntrega());
					break;
				case 2:
					carga.setCarga2(item.getCantidadEntrega());
					carga.setDevolucion2(item.getCantidadDevolucion());
					break;
				default:
					carga.setCarga1(item.getCantidadEntrega());
					carga.setDevolucion1(item.getCantidadDevolucion());
					break;
				}
				nroCarga++;
			}
			cargas.add(carga);
		}
		
		return cargas;
	}
}
