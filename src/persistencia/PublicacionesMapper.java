package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import modelo.Publicacion;
import modelo.PublicacionDiario;
import modelo.PublicacionRevista;

public class PublicacionesMapper {

	private static PublicacionesMapper instance;
	
	private PublicacionesMapper() {
		
	}
	
	public static PublicacionesMapper getInstance() {
		
		if(instance == null) {
			instance = new PublicacionesMapper();
		}
		
		return instance;
	}
	
	public Vector<Publicacion> findAll() {
		
		Vector<Publicacion> publicaciones = new Vector<Publicacion>();
		
		Connection conn = PoolConnection.getInstance().getConnection();
			
		try {
			
			PreparedStatement s = conn.prepareStatement(
				"SELECT codigo, titulo, editor, tema, subtema, publico, idioma, pais_origen, tipo FROM [dbo].[publicacion]"
			);
			ResultSet rs = s.executeQuery();				
		
			while(rs.next()) {
			
				String tipo = rs.getString("tipo");
				
				if(tipo.equals(Publicacion.TIPO_DIARIO)) {
				
					PublicacionDiario publicacion = new PublicacionDiario(
						rs.getString("codigo"),
						rs.getString("titulo"),
						rs.getString("editor"),				
						rs.getString("tema"),
						rs.getString("subtema"),
						rs.getString("publico"),
						rs.getString("idioma"),
						rs.getString("pais_origen")
					);
					
					publicaciones.add(publicacion);
					
				} else if(tipo.equals(Publicacion.TIPO_REVISTA)) {
				
					PublicacionRevista publicacion = new PublicacionRevista(
						rs.getString("codigo"),
						rs.getString("titulo"),
						rs.getString("editor"),				
						rs.getString("tema"),
						rs.getString("subtema"),
						rs.getString("publico"),
						rs.getString("idioma"),
						rs.getString("pais_origen")
					);
					
					publicaciones.add(publicacion);
				}
			}
			
		} catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		PoolConnection.getInstance().realeaseConnection(conn);		
		
		return publicaciones;		
	}
	
	public Publicacion find(String codigo) {
		
		Publicacion publicacion = null;
		
		Connection conn = PoolConnection.getInstance().getConnection();
			
		try {
			
			PreparedStatement s = conn.prepareStatement(
				"SELECT codigo, titulo, editor, tema, subtema, publico, idioma, pais_origen, tipo FROM [dbo].[publicacion] WHERE codigo = ?"
			);
			
			s.setString(1, codigo);
			ResultSet rs = s.executeQuery();				
		
			if(rs.next()) {
			
				String tipo = rs.getString("tipo");
				
				if(tipo.equals(Publicacion.TIPO_DIARIO)) {
					
					publicacion = new PublicacionDiario(
						rs.getString("codigo"),
						rs.getString("titulo"),
						rs.getString("editor"),				
						rs.getString("tema"),
						rs.getString("subtema"),
						rs.getString("publico"),
						rs.getString("idioma"),
						rs.getString("pais_origen")
					);
					
				} else if(tipo.equals(Publicacion.TIPO_REVISTA)) {
				
					publicacion = new PublicacionRevista(
						rs.getString("codigo"),
						rs.getString("titulo"),
						rs.getString("editor"),				
						rs.getString("tema"),
						rs.getString("subtema"),
						rs.getString("publico"),
						rs.getString("idioma"),
						rs.getString("pais_origen")
					);
				}
			}
			
		} catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		PoolConnection.getInstance().realeaseConnection(conn);		
		
		return publicacion;
	}
}
