package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

import modelo.Edicion;

public class EdicionesMapper {

	private static EdicionesMapper instance;
	
	private EdicionesMapper() {
		
	}
	
	public static EdicionesMapper getInstance() {
		
		if(instance == null) {
			instance = new EdicionesMapper();
		}
		
		return instance;
	}
	
	public Vector<Edicion> findAll() {
		
		Vector<Edicion> ediciones = new Vector<Edicion>();
		
		Connection conn = PoolConnection.getInstance().getConnection();
			
		try {
			
			PreparedStatement s = conn.prepareStatement("SELECT codigo, titulo, fecha_salida, precio FROM [dbo].[edicion]");
			ResultSet rs = s.executeQuery();				
		
			while(rs.next()) {
			
				Edicion edicion = new Edicion();
				edicion.setCodigo(rs.getString("codigo"));
				edicion.setTituloTapa(rs.getString("titulo"));
				edicion.setFechaSalida(rs.getDate("fecha_salida"));
				edicion.setPrecio(rs.getFloat("precio"));
				ediciones.add(edicion);
			}
			
		} catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		PoolConnection.getInstance().realeaseConnection(conn);		
		
		return ediciones;		
	}
	
	public Edicion find(String codigo) {
		
		Edicion edicion = null;
		
		Connection conn = PoolConnection.getInstance().getConnection();
			
		try {
			
			PreparedStatement s = conn.prepareStatement("SELECT codigo, titulo, fecha_salida, precio FROM edicion WHERE codigo = ?");
			s.setString(1, codigo);
			ResultSet rs = s.executeQuery();				
		
			if(rs.next()) {
			
				edicion = new Edicion();
				edicion.setCodigo(codigo);
				edicion.setTituloTapa(rs.getString("titulo"));
				edicion.setFechaSalida(rs.getDate("fecha_salida"));
				edicion.setPrecio(rs.getFloat("precio"));
			}
			
		} catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		PoolConnection.getInstance().realeaseConnection(conn);		
		
		return edicion;
	}
	
	public void update(Edicion edicion) {
		
		Connection conn = PoolConnection.getInstance().getConnection();
		
		try {
			
			PreparedStatement s = conn.prepareStatement(
				"UPDATE edicion " + 
				"SET titulo = ?, " + 
				"fecha_salida = ?, " + 
				"precio = ? WHERE codigo = ?"
			);
			
			s.setString(1, edicion.getTituloTapa());
			s.setDate(2, new java.sql.Date(edicion.getFechaSalida().getTime()));
			s.setString(3, edicion.getCodigo());
			s.executeUpdate();
			
		} catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		PoolConnection.getInstance().realeaseConnection(conn);
	}
	
	public void delete(Edicion edicion) {
		
		Connection conn = PoolConnection.getInstance().getConnection();
		
		try {
			
			PreparedStatement s = conn.prepareStatement("DELETE FROM edicion WHERE codigo = ?");
			s.setString(1, edicion.getCodigo());
			s.executeUpdate();
			
		} catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		PoolConnection.getInstance().realeaseConnection(conn);		
	}

	public Edicion buscarEdicionXPublicacion(Date fechaSalida, String codPublicacion) {
		// TODO Auto-generated method stub
Edicion edicion = null;
		
		Connection conn = PoolConnection.getInstance().getConnection();
			
		try {
			
		
			PreparedStatement s = conn.prepareStatement("SELECT e.titulo FROM edicion e JOIN publicacion p on p.id = e.publicacion_id WHERE p.codigo = ? AND e.fecha_salida = ?");
			s.setString(1, codPublicacion);
			s.setDate(2, new java.sql.Date(fechaSalida.getTime()));
			ResultSet rs = s.executeQuery();				
			
			if(rs.next()) {
			
				edicion = new Edicion();
				edicion.setTituloTapa(rs.getString("titulo"));

			}
			
		} catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		PoolConnection.getInstance().realeaseConnection(conn);		
		
		return edicion;
		
	}
}
