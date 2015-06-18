package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import modelo.Colocacion;
import modelo.ItemColocacion;

public class ColocacionesMapper {

	private static ColocacionesMapper instance;

	private ColocacionesMapper() {

	}

	public static ColocacionesMapper getInstance() {

		if (instance == null) {
			instance = new ColocacionesMapper();
		}

		return instance;
	}

//	public Vector<Edicion> findAll() {
//
//		Vector<Edicion> ediciones = new Vector<Edicion>();
//
//		Connection conn = PoolConnection.getInstance().getConnection();
//
//		try {
//
//			PreparedStatement s = conn
//					.prepareStatement("SELECT codigo, titulo, fecha_salida, precio FROM [dbo].[edicion]");
//			ResultSet rs = s.executeQuery();
//
//			while (rs.next()) {
//
//				Edicion edicion = new Edicion();
//				edicion.setCodigo(rs.getString("codigo"));
//				edicion.setTituloTapa(rs.getString("titulo"));
//				edicion.setFechaSalida(rs.getDate("fecha_salida"));
//				edicion.setPrecio(rs.getFloat("precio"));
//				ediciones.add(edicion);
//			}
//
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//		}
//
//		PoolConnection.getInstance().realeaseConnection(conn);
//
//		return ediciones;
//	}
//
//	public Edicion find(String codigo) {
//
//		Edicion edicion = null;
//
//		Connection conn = PoolConnection.getInstance().getConnection();
//
//		try {
//
//			PreparedStatement s = conn
//					.prepareStatement("SELECT codigo, titulo, fecha_salida, precio FROM edicion WHERE codigo = ?");
//			s.setString(1, codigo);
//			ResultSet rs = s.executeQuery();
//
//			if (rs.next()) {
//
//				edicion = new Edicion();
//				edicion.setCodigo(codigo);
//				edicion.setTituloTapa(rs.getString("titulo"));
//				edicion.setFechaSalida(rs.getDate("fecha_salida"));
//				edicion.setPrecio(rs.getFloat("precio"));
//			}
//
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//		}
//
//		PoolConnection.getInstance().realeaseConnection(conn);
//
//		return edicion;
//	}


	public Colocacion buscarPorFecha(Date fechaSalida) {

		Colocacion colocacion = null;

		Connection conn = PoolConnection.getInstance().getConnection();

		try {

			PreparedStatement s = conn
					.prepareStatement("SELECT id FROM colocacion WHERE fecha = ?");
			s.setDate(1, new java.sql.Date(fechaSalida.getTime()));
			ResultSet rs = s.executeQuery();

			if (rs.next()) {

				colocacion = new Colocacion();
				colocacion.setId(rs.getInt("id"));
				colocacion.setItems(ItemsColocacionMapper.buscarPorColocacion(colocacion.getId()));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		PoolConnection.getInstance().realeaseConnection(conn);

		return colocacion;

	}

	public boolean insert(Colocacion colocacion, Date fecha) {
		
		boolean resultadoExitoso = true;

		Connection conn = PoolConnection.getInstance().getConnection();

		try {
			
			Colocacion colocacionPrevia = ColocacionesMapper.getInstance().buscarPorFecha(fecha);
			
			if (null == colocacionPrevia) {
				PreparedStatement statementInsert = conn
						.prepareStatement("INSERT INTO dbo.colocacion ("
								+ "fecha, edicion_id"
								+ ") VALUES (?, ?)");
				statementInsert.setDate(1, new java.sql.Date(fecha.getTime()));
				statementInsert.setInt(2, colocacion.getEdicion().getId());
				statementInsert.execute();
				
				colocacionPrevia = ColocacionesMapper.getInstance().buscarPorFecha(fecha);
				
			} 
			
			for (ItemColocacion itemColocacion : colocacion.getItems()) {
				ItemsColocacionMapper.getInstance().insert(itemColocacion, colocacionPrevia.getId());
			}

		} catch (SQLException e) {

			e.printStackTrace();
			resultadoExitoso = false;
		}

		PoolConnection.getInstance().realeaseConnection(conn);
		return resultadoExitoso;
	}
}