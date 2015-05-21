package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import modelo.DiarieroExclusivo;
import modelo.DiarieroRevistero;
import modelo.Publicacion;
import modelo.PublicacionDiario;
import modelo.PublicacionRevista;
import modelo.RevisteroExclusivo;
import modelo.Rol;
import modelo.Usuario;
import modelo.Vendedor;
import modelo.Zona;

public class UsuariosMapper {

	private static UsuariosMapper instance;
	
	private UsuariosMapper() {
		
	}
	
	public static UsuariosMapper getInstance() {
		
		if(instance == null) {
			instance = new UsuariosMapper();
		}
		
		return instance;
	}
	
	public Usuario findByUsuarioClave(String usuario, String clave) {
		
		Usuario usuarioEncontrado = null;
		
		Connection conn = PoolConnection.getInstance().getConnection();
			
		try {
			
			PreparedStatement s = conn.prepareStatement(
				"SELECT usuario, clave, rol_id FROM [dbo].[usuario] " + 
				"WHERE usuario = ? " + 
				"AND clave = ?"
			);
			
			s.setString(1, usuario);
			s.setString(2, clave);
			ResultSet rs = s.executeQuery();				
		
			if(rs.next()) {

				usuarioEncontrado = new Usuario();
				usuarioEncontrado.setUsuario(rs.getString("usuario"));
				usuarioEncontrado.setClave(rs.getString("clave"));
				
				/**
				 * Rol
				 */
				
				PreparedStatement statementRol = conn.prepareStatement(
					"SELECT codigo FROM [dbo].[rol] WHERE id = ?"
				); 
				
				statementRol.setInt(1, rs.getInt("rol_id"));
				ResultSet rs2 = statementRol.executeQuery();
				
				if(rs2.next()) {
				
					Rol rol = RolesMapper.getInstance().find(rs2.getString("codigo"));
					usuarioEncontrado.setRol(rol);
				}
			}
			
		} catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		PoolConnection.getInstance().realeaseConnection(conn);		
		
		return usuarioEncontrado;
	}
}
