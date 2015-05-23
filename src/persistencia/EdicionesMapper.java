package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

import modelo.Edicion;
import modelo.Publicacion;

public class EdicionesMapper {

	private static EdicionesMapper instance;

	private EdicionesMapper() {

	}

	public static EdicionesMapper getInstance() {

		if (instance == null) {
			instance = new EdicionesMapper();
		}

		return instance;
	}

	public Vector<Edicion> findAll() {

		Vector<Edicion> ediciones = new Vector<Edicion>();

		Connection conn = PoolConnection.getInstance().getConnection();

		try {

			PreparedStatement s = conn
					.prepareStatement("SELECT codigo, titulo, fecha_salida, precio FROM [dbo].[edicion]");
			ResultSet rs = s.executeQuery();

			while (rs.next()) {

				Edicion edicion = new Edicion();
				edicion.setCodigo(rs.getString("codigo"));
				edicion.setTituloTapa(rs.getString("titulo"));
				edicion.setFechaSalida(rs.getDate("fecha_salida"));
				edicion.setPrecio(rs.getFloat("precio"));
				ediciones.add(edicion);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		PoolConnection.getInstance().realeaseConnection(conn);

		return ediciones;
	}

	public Edicion find(String codigo) {

		Edicion edicion = null;

		Connection conn = PoolConnection.getInstance().getConnection();

		try {

			PreparedStatement s = conn
					.prepareStatement("SELECT id, codigo, titulo, fecha_salida, precio FROM edicion WHERE codigo = ? order by fecha_salida desc");
			s.setString(1, codigo);
			ResultSet rs = s.executeQuery();

			if (rs.next()) {

				edicion = new Edicion();
				edicion.setId(rs.getInt("id"));
				edicion.setCodigo(codigo);
				edicion.setTituloTapa(rs.getString("titulo"));
				edicion.setFechaSalida(rs.getDate("fecha_salida"));
				edicion.setPrecio(rs.getFloat("precio"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		PoolConnection.getInstance().realeaseConnection(conn);

		return edicion;
	}

	public Edicion byId(int id) {

		Edicion edicion = null;

		Connection conn = PoolConnection.getInstance().getConnection();

		try {

			PreparedStatement s = conn
					.prepareStatement("SELECT codigo, titulo, fecha_salida, precio, publicacion_id FROM edicion WHERE id = ? order by fecha_salida desc");
			s.setInt(1, id);
			ResultSet rs = s.executeQuery();

			if (rs.next()) {
				edicion = new Edicion(rs.getString("codigo"),
						rs.getString("titulo"), rs.getDate("fecha_salida"),
						rs.getFloat("precio"), PublicacionesMapper
								.getInstance()
								.byId(rs.getInt("publicacion_id")));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		PoolConnection.getInstance().realeaseConnection(conn);

		return edicion;
	}

	// private Edicion fromRs(ResultSet rs) {
	// return new Edicion(rs.getString("codigo"), rs.getString("titulo"),
	// rs.getDate("fecha_salida"), rs.getFloat("precio"),
	// PublicacionesMapper.getInstance().find(""));
	// }

	public void insert(Edicion edicion) {

		Connection conn = PoolConnection.getInstance().getConnection();

		try {

			PreparedStatement statementSelect = conn
					.prepareStatement("SELECT id FROM [dbo].publicacion WHERE codigo = ?");
			statementSelect.setString(1, edicion.getPublicacion().getCodigo());
			ResultSet rs = statementSelect.executeQuery();

			if (rs.next()) {

				int publicacionId = rs.getInt("id");

				PreparedStatement statementInsert = conn
						.prepareStatement("INSERT INTO dbo.[edicion] ("
								+ "codigo, titulo, fecha_salida, precio, publicacion_id"
								+ ") VALUES (?, ?, ?, ?, ?)");

				statementInsert.setString(1, edicion.getCodigo());
				statementInsert.setString(2, edicion.getTituloTapa());
				statementInsert.setDate(3, new java.sql.Date(edicion
						.getFechaSalida().getTime()));
				statementInsert.setFloat(4, edicion.getPrecio());
				statementInsert.setInt(5, publicacionId);
				statementInsert.execute();
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		PoolConnection.getInstance().realeaseConnection(conn);
	}

	public void update(Edicion edicion) {

		Connection conn = PoolConnection.getInstance().getConnection();

		try {

			PreparedStatement s = conn.prepareStatement("UPDATE edicion "
					+ "SET titulo = ?, " + "fecha_salida = ?, "
					+ "precio = ? WHERE codigo = ?");

			s.setString(1, edicion.getTituloTapa());
			s.setDate(2, new java.sql.Date(edicion.getFechaSalida().getTime()));
			s.setFloat(3, edicion.getPrecio());
			s.setString(4, edicion.getCodigo());
			
			s.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		PoolConnection.getInstance().realeaseConnection(conn);
	}

	public void delete(Edicion edicion) {

		Connection conn = PoolConnection.getInstance().getConnection();

		try {

			PreparedStatement s = conn
					.prepareStatement("DELETE FROM [dbo].edicion WHERE codigo = ?");
			s.setString(1, edicion.getCodigo());
			s.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		PoolConnection.getInstance().realeaseConnection(conn);
	}

	public Edicion buscarEdicionXPublicacion(Date fechaSalida,
			String codPublicacion) {
		// TODO Auto-generated method stub
		Edicion edicion = null;

		Connection conn = PoolConnection.getInstance().getConnection();

		try {

			PreparedStatement s = conn
					.prepareStatement("SELECT e.titulo, e.codigo FROM edicion e JOIN publicacion p on p.id = e.publicacion_id WHERE p.codigo = ? AND e.fecha_salida = ?");
			s.setString(1, codPublicacion);
			s.setDate(2, new java.sql.Date(fechaSalida.getTime()));
			ResultSet rs = s.executeQuery();

			if (rs.next()) {

				edicion = new Edicion();
				edicion.setTituloTapa(rs.getString("titulo"));
				edicion.setCodigo(rs.getString("codigo"));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		PoolConnection.getInstance().realeaseConnection(conn);

		return edicion;

	}
	
	public Vector<Edicion> buscarEdicionesDePublicacion(String codigo) {
		
		Vector<Edicion> result = new Vector<Edicion>();

		Connection conn = PoolConnection.getInstance().getConnection();

		try {

			PreparedStatement s = conn
					.prepareStatement("SELECT e.codigo, e.titulo, e.fecha_salida, e.precio, e.publicacion_id FROM edicion e"
							+ " JOIN publicacion p on p.id = e.publicacion_id WHERE p.codigo = ? order by fecha_salida asc");
			s.setString(1, codigo);
			ResultSet rs = s.executeQuery();
			
			Edicion element = null;

			while (rs.next()) {
				element = new Edicion(rs.getString("codigo"),
						rs.getString("titulo"), rs.getDate("fecha_salida"),
						rs.getFloat("precio"), null);
				result.add(element);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		PoolConnection.getInstance().realeaseConnection(conn);

		return result;
	}
	
	public Edicion buscarEdicionXPublicacion2(Date fechaSalida, String codPublicacion) {
		// TODO Auto-generated method stub
		Edicion edicion = null;
		
		Connection conn = PoolConnection.getInstance().getConnection();
			
		try {
			
		
			PreparedStatement s = conn.prepareStatement("SELECT * FROM edicion e JOIN publicacion p on p.id = e.publicacion_id WHERE p.codigo = ? AND e.fecha_salida = ?");
			s.setString(1, codPublicacion);
			s.setDate(2, new java.sql.Date(fechaSalida.getTime()));
			//.setDate(2,new java.sql.Date(fechaSalida.getDate()));
			ResultSet rs = s.executeQuery();				
			
			while (rs.next())
			{
			
				edicion = new Edicion();
				edicion.setTituloTapa(rs.getString("titulo"));
				edicion.setCodigo(rs.getString("codigo"));
				edicion.setFechaSalida(rs.getDate("fecha_salida"));
				edicion.setPrecio(rs.getFloat("precio"));
				
				
				//edicion.setPublicacion(rs.getString("titulo"));
				return edicion;
			}
			
		} catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		PoolConnection.getInstance().realeaseConnection(conn);		
		
		//return edicion;
		return null;
		
	}
	
}
