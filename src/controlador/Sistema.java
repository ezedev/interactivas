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
import modelo.Pauta;
import modelo.Publicacion;
import modelo.ReporteColocacionView;
import modelo.Usuario;
import modelo.Vendedor;
import modelo.Zona;
import persistencia.CargaVendedorView;
import persistencia.ColocacionesMapper;
import persistencia.EdicionesMapper;
import persistencia.PautasMapper;
import persistencia.PublicacionesMapper;
import persistencia.UsuariosMapper;
import persistencia.VendedoresMapper;
import persistencia.ZonasMapper;
import ventanas.Utils;

public class Sistema {
	
	private static Sistema instancia;
	private Vector<Publicacion> publicaciones;
	private Vector<Pauta> pautasActivas;
	private Usuario usuarioAutenticado;
	private Colocacion colocacionActual;
	
	private Sistema() {
		super();
		// Se necesitan todas; las ediciones están en las publicaciones y son lazy fetch
		this.publicaciones = PublicacionesMapper.getInstance().findAll();
		this.pautasActivas = PautasMapper.getInstance().findAll();
	}
	
	public String getFechaSalida(){
		Calendar c = Calendar.getInstance();
		String dia = Integer.toString(c.get(Calendar.DATE)+1);
		String mes = Integer.toString(c.get(Calendar.MONTH));
		String annio = Integer.toString(c.get(Calendar.YEAR));
		String fechaSalida = dia +"/" + mes + "/" + annio;
		return fechaSalida;
	}
	
	public static Sistema getInstance(){
	
		if(instancia == null) {
			instancia = new Sistema();
		}
		
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
	 * Cada vez que se selecciona una publicacion creamos una nueva colocacion
	 * 
	 * @param codigoPublicacion
	 */
	
	public Vector<CargaVendedorView> crearColocacion(String codigoPublicacion) {
		
		Date fechaSalida = Utils.parseFecha(getStringFechaSalida());
		
		Edicion edicion = EdicionesMapper.getInstance().findByFechaAndPublicacion(fechaSalida, codigoPublicacion);
		
		this.colocacionActual = new Colocacion(fechaSalida, edicion);
		
		/**
		 * Generamos los datos para cargar la JTable
		 */
		
		Map <Vendedor , Vector<ItemColocacion>>mapa = new HashMap <Vendedor , Vector<ItemColocacion>>();
		Vector<CargaVendedorView> cargas = new Vector<CargaVendedorView>();

		/**
		 * Buscamos los vendedores que venden la publicacion seleccionada
		 */
		
		Vector<Vendedor> vendedores = VendedoresMapper.getInstance().findVendedoresXPublicacion(codigoPublicacion);
		
		/**
		 * Generamos los items de colocacion vacios
		 */
		
		for (Vendedor vendedor : vendedores) {
			
			mapa.put(vendedor, new Vector<ItemColocacion>());
			
			/**
			 * Creamos el item por cada vendedor
			 */
			
			this.colocacionActual.crearItem(vendedor, 0, 0);
		}
		
		/**
		 * Buscamos la publicacion seleccionada para buscar las ultimas 3 ediciones
		 */
		
		Publicacion publicacion = edicion.getPublicacion();
	
		/**
		 * Obtenemos las 3 ediciones anteriores de la edicion actual para acceder
		 * a la colocacion de cada una de ellas.
		 */
		
		System.out.println("Buscando ultimas 3 ediciones de la publicacion *" + publicacion.getCodigo() + "*");
		
		for (Edicion edicionAnterior : publicacion.obtenerEdicionesAnteriores(3)) {
		
			System.out.println("Buscando la colocacion correspondiente a la edicion *" + edicionAnterior.getCodigo() + "*");			
			
			if(edicionAnterior.estaColocada()) {
			
				System.out.println("Encontramos la colocacion *" + edicionAnterior.getColocacion().getFecha() + "* correspondiente a la edicion *" + edicionAnterior.getCodigo() + "*");
				
				for (ItemColocacion itemColocacion : edicionAnterior.getColocacion().getItems()) {

					for(Vendedor vendedor: vendedores) {
						
						if(itemColocacion.getVendedor().sosVendedor(vendedor.getCodigo())) {
							
							mapa.get(vendedor).add(itemColocacion);
						}
					}
				}
				
			} else {
				
				System.out.println("NO encontramos la colocacion correspondiente a la edicion *" + edicionAnterior.getCodigo() + "*");
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
		
		this.colocacionActual.actualizarCantidadesEntrega(cargas);
		
		return cargas;
	}
	
	public void actualizarColocacion(Vector<CargaVendedorView> cantidadesEntrega) {
		
		this.colocacionActual.actualizarCantidadesEntrega(cantidadesEntrega);
	}
	
	public Vector<CargaVendedorView> aplicarPauta(String codigo, Map<String, Object> parametrosPauta) {
		
		Vector<CargaVendedorView> cantidadesEntrega = new Vector<CargaVendedorView>();
		
		/**
		 * Buscamos la pauta que selecciono el usuario
		 */
		
		for(Pauta pauta : pautasActivas) {
			
			if(pauta.sosPauta(codigo)) {

				/**
				 * Aplicamos la pauta a la colocacion
				 */
				
				this.colocacionActual.aplicarPauta(pauta, parametrosPauta);
				
				/**
				 * Obtenemos los items modificados
				 */
				
				cantidadesEntrega = this.colocacionActual.getCantidadesEntrega();
			}
		}
		
		return cantidadesEntrega;
	}
	
	public boolean confirmarColocacion() {
		
		// Para actualizar el caché.
		Edicion edicion = buscarEdicion(colocacionActual.getEdicion().getCodigo());
		edicion.setColocacion(colocacionActual);
		
		return ColocacionesMapper.getInstance().insert(colocacionActual);
	}

	public Vector<ComboItem> listaPutas() {
		
		Vector<ComboItem> pautasItems = new Vector <ComboItem>();
		pautasItems.add(new ComboItem("XXX", "<ninguna>"));
		
		for (Pauta pauta : this.pautasActivas) {
			
			if(pauta.estasActiva()) {
			
				pautasItems.add(new ComboItem(pauta.getCodigo(), pauta.getCodigo()));
			}
		}
		
		return pautasItems;
	}

	public Vector<ComboItem> listaZonas() {
		
		Vector<ComboItem> zonasItems = new Vector <ComboItem>();
		
		for (Zona zona : ZonasMapper.getInstance().findAll()) {
			
			zonasItems.add(new ComboItem (String.valueOf(zona.getCodigo()), zona.getNombre()));
			
		}
		return zonasItems;
	}	
	
	public Vector<ComboItem> listaPublicaciones() {
	
		Vector<ComboItem> publicacionesItems = new Vector <ComboItem>();
		
		for (Publicacion publicacion : this.publicaciones) {
			
			publicacionesItems.add(new ComboItem (String.valueOf(publicacion.getCodigo()), publicacion.getTitulo()));
			
		}
		return publicacionesItems;
	}	
	
	public void altaEdicion(String codigo,String tituloTapa, float precio, Date fechaDeSalida, String CodPublicacion) {
		Edicion nuevaEdicion = buscarEdicion(codigo);		
		Publicacion publicacion = buscarPublicacion(CodPublicacion);
		if(publicacion != null)
		{
			if(nuevaEdicion == null)
			{
				nuevaEdicion = new Edicion(codigo,tituloTapa,fechaDeSalida,precio, publicacion);
				
				publicacion.getEdiciones().add(nuevaEdicion);
				
				EdicionesMapper.getInstance().insert(nuevaEdicion);
			}
		}
	}
	
	public void modificacionEdicion(String codigo,String tituloTapa, float precio, Date fechaDeSalida, String CodPublicacion)
	{
			
		Publicacion publicacion = buscarPublicacion(CodPublicacion);
		if(publicacion != null)
		{
			for(Edicion edicion: publicacion.getEdiciones())
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
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			calendar.add(Calendar.DATE, 1);
			
			/**
			 * Si todavia no se hizo la colocacion para esta edicion podemos borrarla
			 */
			
			if(!edicion.estaColocada()) {
				
				edicion.getPublicacion().getEdiciones().remove(edicion);
				
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
		
		Edicion edicion = EdicionesMapper.getInstance().findByFechaAndPublicacion(
			calendar.getTime(), codPublicacion
		); 
		
		return edicion.toView();	
	}
		
	public Vector<ReporteColocacionView> buscarColocacionPorFecha (Date fecha){
		Vector<Colocacion> colocaciones = ColocacionesMapper.getInstance().findByFecha(fecha);
		Vector<ReporteColocacionView> reportesView = new Vector();
		for (Colocacion colocacion : colocaciones) {
			for (ItemColocacion item : colocacion.getItems()) {
				ReporteColocacionView reporteView = item.toView();
				reporteView.setEdicion(colocacion.getEdicion().getTituloTapa());
				reportesView.add(reporteView);
			}
		}
		return reportesView;
	}
	
	public Vector<CargaVendedorView> buscarColocacion(Date fechaSalida, String codEdicion) {
		
		Vector<CargaVendedorView> cargas = new Vector<CargaVendedorView>();
		
		this.colocacionActual = ColocacionesMapper.getInstance().find(fechaSalida, codEdicion);
		
		for(ItemColocacion item : this.colocacionActual.getItems()) {
			
			CargaVendedorView carga = new CargaVendedorView();
			carga.setCodigoVendedor(item.getVendedor().getCodigo());
			carga.setDireccionVendedor(item.getVendedor().getDireccion());
			carga.setDevolucion(item.getCantidadDevolucion());
			cargas.add(carga);
		}
		
		return cargas;
	}

	public void confirmarDevolucion(Vector<CargaVendedorView> cargas) {
		
		this.colocacionActual.actualizarCantidadesDevolucion(cargas);
		
		ColocacionesMapper.getInstance().update(colocacionActual);
	}
	
	private Edicion buscarEdicion (String codigo){
		
		for(Publicacion publicacion: this.publicaciones) {
			for(Edicion edicion: publicacion.getEdiciones()){
				if (edicion.getCodigo().equals(codigo))
					return edicion;
			}
		}
		
		return null;
	}
	
	private Publicacion buscarPublicacion(String codigo) {
		
		for (int i = 0 ; i < publicaciones.size() ; i++) {
			
			if(publicaciones.elementAt(i).getCodigo().equals(codigo))
			{
				return publicaciones.elementAt(i);
			}
		}
		return null;
	}	
}
