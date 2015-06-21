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

	public Vector<Edicion> findByPublicacion(String codPublicacion) {

		Vector<Edicion> ediciones = new Vector<Edicion>();

		Connection conn = PoolConnection.getInstance().getConnection();

		try {

			PreparedStatement s = conn.prepareStatement(
				"SELECT codigo, titulo, fecha_salida, precio, codigo_publicacion " + 
				"FROM [dbo].[edicion] " + 
				"WHERE codigo_publicacion = ? " +
				"ORDER BY fecha_salida ASC"
			);
			
			s.setString(1, codPublicacion);
			ResultSet rs = s.executeQuery();

			while (rs.next()) {

				Edicion edicion = new Edicion();
				edicion.setCodigo(rs.getString("codigo"));
				edicion.setTituloTapa(rs.getString("titulo"));
				edicion.setFechaSalida(rs.getDate("fecha_salida"));
				edicion.setPrecio(rs.getFloat("precio"));
				
				Publicacion publicacion = PublicacionesMapper.getInstance().find(
					rs.getString("codigo_publicacion")
				);
				
				edicion.setPublicacion(publicacion);
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
					.prepareStatement("SELECT codigo, titulo, fecha_salida, precio FROM edicion WHERE codigo = ? order by fecha_salida desc");
			s.setString(1, codigo);
			ResultSet rs = s.executeQuery();

			if (rs.next()) {

				edicion = new Edicion();
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

	public void insert(Edicion edicion) {

		Connection conn = PoolConnection.getInstance().getConnection();

		try {

			PreparedStatement statementInsert = conn.prepareStatement("INSERT INTO dbo.[edicion] ("
						+ "codigo, titulo, fecha_salida, precio, codigo_publicacion"
						+ ") VALUES (?, ?, ?, ?, ?)");

			statementInsert.setString(1, edicion.getCodigo());
			statementInsert.setString(2, edicion.getTituloTapa());
			statementInsert.setDate(3, new java.sql.Date(edicion
					.getFechaSalida().getTime()));
			statementInsert.setFloat(4, edicion.getPrecio());
			statementInsert.setString(5, edicion.getPublicacion().getCodigo());
			statementInsert.execute();

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

	public Edicion findByFechaAndPublicacion(Date fechaSalida, String codPublicacion) {

		Edicion edicion = null;

		Connection conn = PoolConnection.getInstance().getConnection();

		try {

			PreparedStatement s = conn.prepareStatement(
				"SELECT codigo, titulo, codigo_publicacion " + 
				"FROM edicion " +  
				"WHERE codigo_publicacion = ? AND fecha_salida = ?"
			);
			
			s.setString(1, codPublicacion);
			s.setDate(2, new java.sql.Date(fechaSalida.getTime()));
			ResultSet rs = s.executeQuery();

			if (rs.next()) {

				Publicacion publicacion = PublicacionesMapper.getInstance().find(rs.getString("codigo_publicacion"));
				
				edicion = new Edicion();
				edicion.setCodigo(rs.getString("codigo"));
				edicion.setTituloTapa(rs.getString("titulo"));
				edicion.setPublicacion(publicacion);
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

			PreparedStatement s = conn.prepareStatement(
				"SELECT codigo, titulo, fecha_salida, precio, codigo_publicacion " + 
				"FROM edicion " +  
				"WHERE codigo_publicacion = ? " + 
				"ORDER BY fecha_salida asc"
			);
			
			s.setString(1, codigo);
			ResultSet rs = s.executeQuery();
			
			Edicion edicion = null;

			while (rs.next()) {
				
				edicion = new Edicion(
					rs.getString("codigo"),
					rs.getString("titulo"), 
					rs.getDate("fecha_salida"),
					rs.getFloat("precio"), 
					null
				);
				
				result.add(edicion);
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
			
		
			PreparedStatement s = conn.prepareStatement(
				"SELECT * FROM edicion WHERE codigo_publicacion = ? AND fecha_salida = ?");
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
				
				return edicion;
			}
			
		} catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		PoolConnection.getInstance().realeaseConnection(conn);		
		
		//return edicion;
		return null;
		
	}

	public boolean updateColocacion(Edicion edicion) {
		
		Connection conn = PoolConnection.getInstance().getConnection();
		boolean resultadoExitoso = true;

		try {

			PreparedStatement s = conn
					.prepareStatement("UPDATE [dbo].edicion WHERE codigo = ?");
			s.setString(1, edicion.getCodigo());
			s.executeUpdate();

		} catch (SQLException e) {
			resultadoExitoso = false;
			e.printStackTrace();
		}

		PoolConnection.getInstance().realeaseConnection(conn);
		
		return resultadoExitoso;
	}

	
}
