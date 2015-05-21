package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import modelo.ItemColocacion;

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

	public static Vector<ItemColocacion> buscarPorColocacion(int id) {
		
		Vector<ItemColocacion> items = new Vector<ItemColocacion>();

		Connection conn = PoolConnection.getInstance().getConnection();

		try {

			PreparedStatement s = conn
					.prepareStatement("SELECT edicion_id, vendedor_id, cantidad_entregada, cantidad_devuelta FROM item_colocacion WHERE colocacion_id = ?");
			s.setInt(1, id);
			ResultSet rs = s.executeQuery();

			while (rs.next()) {
				
				ItemColocacion item = new ItemColocacion(rs.getInt("cantidad_entregada"), 
														rs.getInt("cantidad_devuelta"), 
														EdicionesMapper.getInstance().byId(rs.getInt("edicion_id")), 
														VendedoresMapper.getInstance().byId(rs.getInt("vendedor_id")));

				items.add(item);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		PoolConnection.getInstance().realeaseConnection(conn);

		return items;
		
		
		
	}

}
