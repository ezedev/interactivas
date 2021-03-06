package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

import modelo.Colocacion;
import modelo.ItemColocacion;
import modelo.Vendedor;

public class ItemsColocacionMapper {

	private static ItemsColocacionMapper instance;

	private ItemsColocacionMapper() {

	}

	public static ItemsColocacionMapper getInstance() {

		if (instance == null) {
			instance = new ItemsColocacionMapper();
		}

		return instance;
	}

	public static Vector<ItemColocacion> findByColocacion(Date fecha, String codEdicion) {

		Vector<ItemColocacion> items = new Vector<ItemColocacion>();

		Connection conn = PoolConnection.getInstance().getConnection();

		try {

			PreparedStatement s = conn.prepareStatement(
				"SELECT codigo_vendedor, cantidad_entregada, cantidad_devuelta " + 
				"FROM item_colocacion " + 
				"WHERE fecha_colocacion = ? and codigo_edicion = ?");
			
			s.setDate(1, new java.sql.Date(fecha.getTime()));
			s.setString(2, codEdicion);
			ResultSet rs = s.executeQuery();

			while (rs.next()) {

				Vendedor vendedor = VendedoresMapper.getInstance().find(rs.getString("codigo_vendedor")); 
				
				ItemColocacion item = new ItemColocacion(
					rs.getInt("cantidad_entregada"),
					rs.getInt("cantidad_devuelta"),
					vendedor
				);

				items.add(item);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		PoolConnection.getInstance().realeaseConnection(conn);

		return items;

	}
}
