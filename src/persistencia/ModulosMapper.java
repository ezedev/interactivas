package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import modelo.DiarieroExclusivo;
import modelo.DiarieroRevistero;
import modelo.Modulo;
import modelo.Publicacion;
import modelo.PublicacionDiario;
import modelo.PublicacionRevista;
import modelo.RevisteroExclusivo;
import modelo.Rol;
import modelo.Usuario;
import modelo.Vendedor;
import modelo.Zona;

public class ModulosMapper {

	private static ModulosMapper instance;
	
	private ModulosMapper() {
		
	}
	
	public static ModulosMapper getInstance() {
		
		if(instance == null) {
			instance = new ModulosMapper();
		}
		
		return instance;
	}
	
	public Vector<Modulo> findByRol(String codigo) {
		
		Vector<Modulo> modulos = new Vector<Modulo>();
		
		Connection conn = PoolConnection.getInstance().getConnection();
			
		try {
			
			PreparedStatement s = conn.prepareStatement(
				"SELECT m.codigo, m.nombre " + 
				"FROM [dbo].[modulo] m " + 
				"INNER JOIN [dbo].[rol_modulo] rm ON rm.codigo_modulo = m.codigo " + 
				"INNER JOIN [dbo].[rol] r ON r.codigo = rm.codigo_rol " + 
				"WHERE r.codigo = ?"
			);
			
			s.setString(1, codigo);
			ResultSet rs = s.executeQuery();				
		
			while(rs.next()) {

				modulos.add(new Modulo(rs.getString("codigo"), rs.getString("nombre")));
			}
			
		} catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		PoolConnection.getInstance().realeaseConnection(conn);		
		
		return modulos;
	}	
}
