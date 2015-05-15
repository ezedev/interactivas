package controlador;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import modelo.Colocacion;
import modelo.DiarieroExclusivo;
import modelo.DiarieroRevistero;
import modelo.Edicion;
import modelo.Publicacion;
import modelo.PublicacionDiario;
import modelo.PublicacionRevista;
import modelo.RevisteroExclusivo;
import modelo.Vendedor;
import modelo.Zona;

public class Sistema {
	
	private static Sistema instancia= new Sistema();
	private Vector<Publicacion> publicaciones;
	private Vector<Vendedor> vendedores;
	private Vector<Edicion> ediciones;

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
		
		Publicacion clarin = new PublicacionDiario(1, "Clarin", "Grupo Clarin", "General", "General", "General", "es", "ARG");
		Publicacion lanacion = new PublicacionDiario(1, "Lanacion", "Grupo Clarin", "General", "General", "General", "es", "ARG");
		Publicacion noticias = new PublicacionRevista(1, "Revista NOTICIAS", "Noticias", "General", "General", "General", "es", "ARG");
		
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
		 * Calculamos la fecha de ma√±ana
		 */
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.add(Calendar.DATE, 1);
		Date fechaSalida = calendar.getTime();		

		/**
		 * Cargamos las ediciones que salen ma√±ana
		 */		
		try{
		this.ediciones.add(new Edicion(1000, "Clarin - Lunes", stringToDate(getFechaSalida()), 9.50f, clarin));
		this.ediciones.add(new Edicion(1001, "Lanacion - Lunes", stringToDate(getFechaSalida()), 12.50f, lanacion));
		}catch(Exception e){
			e.printStackTrace();
		}
		/**
		 * Cargamos zonas
		 */
		
		Zona microcentro = new Zona(1000, "Microcentro");
		Zona sur = new Zona(1001, "Sur");
		Zona norte = new Zona(1002, "Norte");
		
		/**
		 * Cargamos un vendedor diario que venda todos los diarios
		 */

		this.vendedores.add(new DiarieroExclusivo(1000, "Vendedor Diarios Puesto #1", publicacionesDiarios, microcentro));
		this.vendedores.add(new DiarieroExclusivo(1001, "Vendedor Diarios Puesto #2", publicacionesDiarios, sur));
		this.vendedores.add(new DiarieroExclusivo(1002, "Vendedor Diarios Puesto #3", publicacionesDiarios, norte));
		this.vendedores.add(new RevisteroExclusivo(1003, "Vendedor Revistas Puesto #1", publicacionesRevistas, norte));
		this.vendedores.add(new DiarieroRevistero(1004, "Vendedor Diarios y Revistas Puesto #1", publicacionesDiariosRevistas, microcentro));
	}
	
	public String getFechaSalida(){
		Calendar c = Calendar.getInstance();
		String dia = Integer.toString(c.get(Calendar.DATE)+1);
		String mes = Integer.toString(c.get(Calendar.MONTH));
		String annio = Integer.toString(c.get(Calendar.YEAR));
		String fechaSalida = dia +"/" + mes + "/" + annio;
		return fechaSalida;
	}
	
	/*ImplementaciÛn patrÛn Singleton*/
	
	public static Sistema getInstance(){
		return instancia;
	}
	
	

	/**
	 * Busca las ediciones para armar la colocacion.
	 * Son las que tienen fecha de salida de ma√±ana.
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
	
	public void agregarItemColocacion(int codigoEdicion, int codigoVendedor, int cantidadEntrega) {
		
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
	
	public Edicion buscarEdicion (int codigo){
		for(Edicion edicion: ediciones){
			if (edicion.getCodigo()==codigo)
				return edicion;
		}
		return null;
	}

	public Vendedor buscarVendedor (int codigo){
		
		Vendedor vendedorEncontrado = null;
		
		for(Vendedor vendedor: this.vendedores){
			
			if (vendedor.getCodigo()==codigo) {
				vendedorEncontrado = vendedor;
				break;
			}
		}
		
		return vendedorEncontrado;
	}

	public String[] listaPublicaciones() {
		// TODO Auto-generated method stub
		Vector<String> nombresPublicaciones = new Vector <String>();
		for (Publicacion publicacion : publicaciones) {
			nombresPublicaciones.add(publicacion.getTitulo());
		}
		return (String[])nombresPublicaciones.toArray(new String[nombresPublicaciones.size()]);
	}	
	
	
	
	//para ediciones
	private Publicacion buscarPublicacion(int codigo)
	{
		for (int i = 0 ; i < publicaciones.size() ; i++)
		{
			
			if(publicaciones.elementAt(i).getCodigo() == codigo)
			{
				return publicaciones.elementAt(i);
			}
		}
		return null;
	}
	
	public void altaEdicion(int codigo,String tituloTapa, float precio, Date fechaDeSalida, int CodPublicacion)
	{
		Edicion nuevaEdicion = buscarEdicion(codigo);		
		Publicacion publicacion = buscarPublicacion(CodPublicacion);
		if(publicacion != null)
		{
			if(nuevaEdicion == null)
			{
				nuevaEdicion = new Edicion(codigo,tituloTapa,fechaDeSalida,precio, publicacion);
				ediciones.add(nuevaEdicion);
			}
		}
	}
	
	public void modificacionEdicion(int codigo,String tituloTapa, float precio, Date fechaDeSalida, int CodPublicacion)
	{
			
		Publicacion publicacion = buscarPublicacion(CodPublicacion);
		if(publicacion != null)
		{
			for(Edicion edicion: ediciones)
			{
				if(edicion.getCodigo() == codigo)
				{
					edicion.setTituloTapa(tituloTapa);
					edicion.setPrecio(precio);
					edicion.setFechaSalida(fechaDeSalida);
					edicion.setPublicacion(publicacion);
							
				}
			}
		}
	}
	
	
	public void bajaEdicion(int codigo)
	{
		//tengo que hablarlo para saber si hago baja fisica o logica
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
}

