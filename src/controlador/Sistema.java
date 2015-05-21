package controlador;

import java.text.SimpleDateFormat;
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
import modelo.PublicacionDiario;
import modelo.PublicacionRevista;
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
		
		/**
		 * Carga para desarrollar
		 */
		
		/**
		 * Publicaciones
		 */
		
		Publicacion clarin = new PublicacionDiario("CLARIN", "CLARIN", "Grupo Clarin", "General", "General", "General", "es", "ARG");
		Publicacion lanacion = new PublicacionDiario("NACION", "LA NACION", "Grupo Clarin", "General", "General", "General", "es", "ARG");
		Publicacion noticias = new PublicacionRevista("1", "Revista NOTICIAS", "Noticias", "General", "General", "General", "es", "ARG");
		
		Vector<Publicacion> publicacionesDiarios = new Vector<Publicacion>();
		publicacionesDiarios.add(clarin);
		publicacionesDiarios.add(lanacion);
		Vector<Publicacion> publicacionesRevistas = new Vector<Publicacion>();
		publicacionesRevistas.add(noticias);
		Vector<Publicacion> publicacionesDiariosRevistas = new Vector<Publicacion>();
		publicacionesDiariosRevistas.addAll(publicacionesDiarios);
		publicacionesDiariosRevistas.addAll(publicacionesRevistas);
		this.publicaciones = publicacionesDiariosRevistas;
		
		/**
		 * Calculamos la fecha de mañana
		 */
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.add(Calendar.DATE, 1);
		Date fechaSalida = calendar.getTime();		

		/**
		 * Cargamos las ediciones que salen mañana
		 */		
		try{
		ediciones = EdicionesMapper.getInstance().findAll();
//		this.ediciones.add(new Edicion(1000, "Clarin - Lunes", stringToDate(getFechaSalida()), 9.50f, clarin));
//		this.ediciones.add(new Edicion(1001, "Lanacion - Lunes", stringToDate(getFechaSalida()), 12.50f, lanacion));
		}catch(Exception e){
			e.printStackTrace();
		}
		/**
		 * Cargamos zonas
		 */
	
		/*
		Zona microcentro = new Zona(1000, "Microcentro");
		Zona sur = new Zona(1001, "Sur");
		Zona norte = new Zona(1002, "Norte");
		*/
		
		/**
		 * Cargamos un vendedor diario que venda todos los diarios
		 */

		/*
		this.vendedores.add(new DiarieroExclusivo(1000, "Vendedor Diarios Puesto #1", publicacionesDiarios, microcentro));
		this.vendedores.add(new DiarieroExclusivo(1001, "Vendedor Diarios Puesto #2", publicacionesDiarios, sur));
		this.vendedores.add(new DiarieroExclusivo(1002, "Vendedor Diarios Puesto #3", publicacionesDiarios, norte));
		this.vendedores.add(new RevisteroExclusivo(1003, "Vendedor Revistas Puesto #1", publicacionesRevistas, norte));
		this.vendedores.add(new DiarieroRevistero(1004, "Vendedor Diarios y Revistas Puesto #1", publicacionesDiariosRevistas, microcentro));
		*/
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
	
	public void crearColocacion() {

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);		
		
		Colocacion colocacion = new Colocacion(calendar.getTime());
		
		this.colocacion = colocacion;
	}
	
	public void agregarItemColocacion(String codigoEdicion, String codigoVendedor, int cantidadEntrega) {
		
		this.colocacion.crearItem(
			this.buscarEdicion(codigoEdicion), 
			this.buscarVendedor(codigoVendedor), 
			cantidadEntrega
		);
	}
	
	public String buscarEdicionesXFechaYPublicacion (Date fecha, String publicacion){
		for (Edicion edicion : ediciones) {
			if(edicion.getFechaSalida().equals(fecha) && edicion.getPublicacion().getTitulo() == publicacion)
					return edicion.getTituloTapa();
		}
		return null;
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
	
	public Edicion buscarEdicion (String codigo){
		for(Edicion edicion: ediciones){
			if (edicion.getCodigo().equals(codigo))
				return edicion;
		}
		return null;
	}

	public Vendedor buscarVendedor (String codigo){
		
		Vendedor vendedorEncontrado = null;
		
		for(Vendedor vendedor: this.vendedores){
			
			if (vendedor.getCodigo().equals(codigo)) {
				vendedorEncontrado = vendedor;
				break;
			}
		}
		
		return vendedorEncontrado;
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
	
	
	public void bajaEdicion(String codigo) {
		
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
			}
		}
	}
	
	
	public Date stringToDate (String fecha) throws Exception{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
	 
			Date date = formatter.parse(fecha);
			return date;
	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Vector<Vendedor> buscarVendedoresXPublicacion(String codPublicacion){
		return VendedoresMapper.getInstance().findVendedoresXPublicacion(codPublicacion);
	}

	public String getStringFechaSalida() {
		return Utils.getFechaSalidaString();
	}


// busqueda de ediciones en la base por publicacion
	
	public EdicionView buscarEdicionXPublicacion(String codPublicacion) {
		
		Calendar calendar = Calendar.getInstance();
//		calendar.add(Calendar.DATE, 1);
		calendar.add(Calendar.DATE, -6);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
//		calendar.getTime();
		
		
		
		Colocacion colocacion = ColocacionesMapper.getInstance().buscarPorFecha(calendar.getTime());
		System.out.println(colocacion.getItems());
		System.out.println("hola");
		
		
		return (EdicionesMapper.getInstance().buscarEdicionXPublicacion(Utils.getFechaSalida(), codPublicacion)).toView();	
	}
		
	public Colocacion buscarUltimaColocacion (Date fecha){

		return ColocacionesMapper.getInstance().buscarPorFecha(fecha);
	}
	
	
	
	
	
	//la cantidad que devuelvo es la nueva para asigna a la colocacion del dia siguiente
	public int nuevaCantidadCargaProxColocacion (Date fecha, String nombrePauta, String codigoEdicion, String codigoVendedor){
		
		int cantidad = 0;
		
		Colocacion c = buscarUltimaColocacion(fecha);
		
		if (c != null){
			
			cantidad = c.aplicarPauta(nombrePauta, codigoEdicion, codigoVendedor);
		}
		
		return cantidad;
		
	}
	public Vector<Vendedor> buscarVendedoresPorPublicacion (String codPublicacion){
		return VendedoresMapper.getInstance().findVendedoresXPublicacion(codPublicacion);
	}
	
	public Vector<CargaVendedorView> cargarVendedoresTable (String codPublicacion){
		
		Vector<CargaVendedorView> cargas = new Vector<CargaVendedorView>();
		
		Vector<Vendedor> vendedores = Sistema.getInstance().buscarVendedoresPorPublicacion(codPublicacion);
		Map <Vendedor , Vector<ItemColocacion>>mapa = new HashMap <Vendedor , Vector<ItemColocacion>>();
		for (Vendedor vendedor : vendedores) {
			mapa.put(vendedor, new Vector<ItemColocacion>());//Vendedor.getItemsColocacion
		}
		
		
		Publicacion publicacion = PublicacionesMapper.getInstance().find(codPublicacion);
		Vector<Edicion> obtenerUltimas3 = publicacion.obtenerUltimas3();
		
		for (Edicion edicion : obtenerUltimas3) {
			Colocacion colocacion = ColocacionesMapper.getInstance().buscarPorFecha(edicion.getFechaSalida());
			Vector<ItemColocacion> items = colocacion.getItems();
			for (ItemColocacion itemColocacion : items) {
				if (itemColocacion.getEdicion().SosEdicion(edicion.getCodigo())) {
					mapa.get(itemColocacion.getVendedor()).add(itemColocacion);
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
	
	
	private Vector<ItemColocacion> buscarItemsPorVendedor (String codPublicacion){
		Vector<ItemColocacion> items = new Vector<ItemColocacion>();
		
		return items;
	}
	
	private Vector<Date> getFechasSalida(String tipoPublicacion) {
		Vector<Date> fechas = new Vector<Date>();
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		if (tipoPublicacion.equals("D")) {
			calendar.add(Calendar.DATE, -6);
			fechas.add(calendar.getTime());
			calendar.add(Calendar.DATE, -7);
			fechas.add(calendar.getTime());
			calendar.add(Calendar.DATE, -7);
			fechas.add(calendar.getTime());

		} else {
			fechas.add(calendar.getTime());
			calendar.add(Calendar.DATE, -1);
			fechas.add(calendar.getTime());
			calendar.add(Calendar.DATE, -1);
			fechas.add(calendar.getTime());
		}
		return fechas;
	}
}
