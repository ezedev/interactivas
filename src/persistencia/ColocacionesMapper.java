package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

import modelo.Colocacion;
import modelo.Edicion;
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

	public Colocacion find(Date fechaSalida, String codEdicion) {

		Colocacion colocacion = null;

		Connection conn = PoolConnection.getInstance().getConnection();

		try {

			PreparedStatement s = conn.prepareStatement(
				"SELECT fecha, codigo_edicion " + 
				"FROM colocacion " + 
				"WHERE fecha = ? " +
				"AND codigo_edicion = ?"
			);
			
			s.setDate(1, new java.sql.Date(fechaSalida.getTime()));
			s.setString(2, codEdicion);
			ResultSet rs = s.executeQuery();

			if (rs.next()) {

				Edicion edicion = EdicionesMapper.getInstance().find(rs.getString("codigo_edicion"));
				Vector<ItemColocacion> itemsColocacion = ItemsColocacionMapper.findByColocacion(rs.getDate("fecha"), rs.getString("codigo_edicion")); 
				
				colocacion = new Colocacion();
				colocacion.setFecha(rs.getDate("fecha"));
				colocacion.setEdicion(edicion);
				colocacion.setItems(itemsColocacion);
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
			
			PreparedStatement statementInsert = conn.prepareStatement("INSERT INTO dbo.colocacion (fecha, codigo_edicion) VALUES (?, ?)");
			statementInsert.setDate(1, new java.sql.Date(fecha.getTime()));
			statementInsert.setString(2, colocacion.getEdicion().getCodigo());
			statementInsert.execute();
				 
			for (ItemColocacion itemColocacion : colocacion.getItems()) {
				
				ItemsColocacionMapper.getInstance().insert(itemColocacion, colocacion.getFecha(), colocacion.getEdicion().getCodigo());
			}

		} catch (SQLException e) {

			e.printStackTrace();
			resultadoExitoso = false;
		}

		PoolConnection.getInstance().realeaseConnection(conn);
		return resultadoExitoso;
	}
}