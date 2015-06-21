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
import modelo.Vendedor;
import modelo.Zona;

public class ZonasMapper {

	private static ZonasMapper instance;
	
	private ZonasMapper() {
		
	}
	
	public static ZonasMapper getInstance() {
		
		if(instance == null) {
			instance = new ZonasMapper();
		}
		
		return instance;
	}
	
	public Vector<Zona> findAll() {
		
		Vector<Zona> zonas = new Vector<Zona>();
		
		Connection conn = PoolConnection.getInstance().getConnection();
			
		try {
			
			PreparedStatement s = conn.prepareStatement("SELECT codigo, nombre, coeficiente FROM [dbo].[zona]");
			ResultSet rs = s.executeQuery();				
		
			while(rs.next()) {
			
				Zona zona = new Zona();
				zona.setCodigo(rs.getString("codigo"));
				zona.setNombre(rs.getString("nombre"));
				zona.setCoeficiente(rs.getFloat("coeficiente"));
				zonas.add(zona);
			}
			
		} catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		PoolConnection.getInstance().realeaseConnection(conn);		
		
		return zonas;		
	}
	
	public Zona find(String codigo) {
		
		Zona zona = null;
		
		Connection conn = PoolConnection.getInstance().getConnection();
			
		try {
			
			PreparedStatement s = conn.prepareStatement("SELECT codigo, nombre, coeficiente FROM [dbo].[zona] WHERE codigo = ?");
			s.setString(1, codigo);
			ResultSet rs = s.executeQuery();				
		
			if(rs.next()) {

				zona = new Zona();
				zona.setCodigo(rs.getString("codigo"));
				zona.setNombre(rs.getString("nombre"));
				zona.setCoeficiente(rs.getFloat("coeficiente"));
			}
			
		} catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		PoolConnection.getInstance().realeaseConnection(conn);		
		
		return zona;
	}
}
