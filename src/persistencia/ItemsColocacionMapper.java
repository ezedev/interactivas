package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

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

	public static Vector<ItemColocacion> buscarPorColocacion(int id) {

		Vector<ItemColocacion> items = new Vector<ItemColocacion>();

		Connection conn = PoolConnection.getInstance().getConnection();

		try {

			PreparedStatement s = conn
					.prepareStatement("SELECT vendedor_id, cantidad_entregada, cantidad_devuelta FROM item_colocacion WHERE colocacion_id = ?");
			s.setInt(1, id);
			ResultSet rs = s.executeQuery();

			while (rs.next()) {

				ItemColocacion item = new ItemColocacion(
						rs.getInt("cantidad_entregada"),
						rs.getInt("cantidad_devuelta"),
						VendedoresMapper.getInstance().byId(
								rs.getInt("vendedor_id")));

				items.add(item);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		PoolConnection.getInstance().realeaseConnection(conn);

		return items;

	}

	public void insert(ItemColocacion itemColocacion, int colocacion_id) {

		Connection conn = PoolConnection.getInstance().getConnection();

		try {

			PreparedStatement statementInsert = conn
					.prepareStatement("INSERT INTO dbo.item_colocacion ("
							+ "colocacion_id, vendedor_id, cantidad_entregada, cantidad_devuelta"
							+ ") VALUES (?, ?, ?, ?, ?)");

			statementInsert.setInt(1, colocacion_id);
			Vendedor vendedor = VendedoresMapper.getInstance().find(itemColocacion.getVendedor().getCodigo());
			statementInsert.setInt(3, vendedor.getId());
			statementInsert.setInt(4, itemColocacion.getCantidadEntrega());
			statementInsert.setInt(5, itemColocacion.getCantidadDevolucion());
			statementInsert.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		PoolConnection.getInstance().realeaseConnection(conn);
	}

}
