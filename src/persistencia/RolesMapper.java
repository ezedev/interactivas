package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import controlador.Sistema;
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

public class RolesMapper {

	private static RolesMapper instance;
	
	private RolesMapper() {
		
	}
	
	public static RolesMapper getInstance() {
		
		if(instance == null) {
			instance = new RolesMapper();
		}
		
		return instance;
	}
	
	public Rol find(String codigo) {
		
		Rol rol = null;
		
		Connection conn = PoolConnection.getInstance().getConnection();
			
		try {
			
			PreparedStatement s = conn.prepareStatement("SELECT codigo, nombre FROM [dbo].[rol] WHERE codigo = ?");
			s.setString(1, codigo);
			ResultSet rs = s.executeQuery();				
		
			if(rs.next()) {

				rol = new Rol();
				rol.setCodigo(rs.getString("codigo"));
				rol.setNombre(rs.getString("nombre"));
				Vector<Modulo> modulos = ModulosMapper.getInstance().findByRol(rs.getString("codigo"));
				rol.setModulos(modulos);
			}
			
		} catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		PoolConnection.getInstance().realeaseConnection(conn);		
		
		return rol;
	}	
}
