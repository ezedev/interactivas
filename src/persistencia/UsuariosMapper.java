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
				"SELECT usuario, clave, codigo_rol FROM [dbo].[usuario] " + 
				"WHERE usuario = ? " + 
				"AND clave = ?"
			);
			
			s.setString(1, usuario);
			s.setString(2, clave);
			ResultSet rs = s.executeQuery();				
		
			if(rs.next()) {

				Rol rol = RolesMapper.getInstance().find(rs.getString("codigo_rol"));
				
				usuarioEncontrado = new Usuario();
				usuarioEncontrado.setUsuario(rs.getString("usuario"));
				usuarioEncontrado.setClave(rs.getString("clave"));
				usuarioEncontrado.setRol(rol);
			}
			
		} catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		PoolConnection.getInstance().realeaseConnection(conn);		
		
		return usuarioEncontrado;
	}
}
