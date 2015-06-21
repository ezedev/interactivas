package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

import ventanas.Utils;
import modelo.Colocacion;
import modelo.Edicion;
import modelo.ItemColocacion;
import modelo.Publicacion;
import modelo.Vendedor;

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

	
	public boolean insert(Colocacion colocacion) {
		
		boolean resultadoExitoso = true;

		Connection conn = PoolConnection.getInstance().getConnection();

		try {
			
			PreparedStatement statementInsert = conn.prepareStatement("INSERT INTO dbo.colocacion (fecha, codigo_edicion) VALUES (?, ?)");
			statementInsert.setDate(1, new java.sql.Date(colocacion.getFecha().getTime()));
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
	
	public Vector<Colocacion> findByFecha(Date fecha)
	{
		Vector<Colocacion> colocaciones = new Vector <Colocacion>();
		Connection conn = PoolConnection.getInstance().getConnection();
		Vector<ItemColocacion> items = new Vector<ItemColocacion>();
		try
		{
			PreparedStatement s =conn.prepareStatement(
					"SELECT fecha, codigo_edicion " + 
							"FROM [dbo].[colocacion] " + 
							"WHERE fecha = ? " 
							
						);

			s.setDate(1, new java.sql.Date(fecha.getTime()));
			ResultSet rs = s.executeQuery();
			
			while(rs.next())
			{
				Colocacion colocacion = new Colocacion();
				colocacion.setFecha(rs.getDate("fecha"));
				Edicion edicion = EdicionesMapper.getInstance().find(rs.getString("codigo_edicion"));
				colocacion.setEdicion(edicion);
				//ahora la parte de items
				PreparedStatement s2 = conn.prepareStatement(
						"SELECT fecha_colocacion, codigo_edicion,codigo_vendedor,cantidad_entregada,cantidad_devuelta " + 
								"FROM [dbo].[item_colocacion] " + 
								"WHERE codigo_edicion = ? AND fecha_colocacion = ? " 
								
							);
				
						s2.setString(1, edicion.getCodigo());
						s2.setDate(2, new java.sql.Date(fecha.getTime()));
						ResultSet rs2 = s2.executeQuery();
						while(rs2.next())
						{
							ItemColocacion item = new ItemColocacion();
							item.setCantidadDevolucion(rs2.getInt("cantidad_devuelta"));
							item.setCantidadEntrega(rs2.getInt("cantidad_entregada"));
							
							Vendedor vendedor = VendedoresMapper.getInstance().find(rs2.getString("codigo_vendedor"));
							item.setVendedor(vendedor);
							items.add(item);
							
						}
						
						colocacion.setItems(items);
				
				colocaciones.add(colocacion);
			}
			
		}
		 catch (SQLException e) {
	
			e.printStackTrace();
			}
		
		PoolConnection.getInstance().realeaseConnection(conn);

		return colocaciones;
	}
	
	
}