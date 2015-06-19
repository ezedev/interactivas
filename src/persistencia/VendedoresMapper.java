package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import controlador.Sistema;
import modelo.DiarieroExclusivo;
import modelo.DiarieroRevistero;
import modelo.Publicacion;
import modelo.PublicacionDiario;
import modelo.PublicacionRevista;
import modelo.RevisteroExclusivo;
import modelo.Vendedor;

public class VendedoresMapper {

	private static VendedoresMapper instance;
	
	private VendedoresMapper() {
		
	}
	
	public static VendedoresMapper getInstance() {
		
		if(instance == null) {
			instance = new VendedoresMapper();
		}
		
		return instance;
	}
	
	public Vector<Vendedor> findAll() {
		
		Vector<Vendedor> vendedores = new Vector<Vendedor>();
		
		Connection conn = PoolConnection.getInstance().getConnection();
			
		try {
			
			PreparedStatement s = conn.prepareStatement("SELECT codigo, direccion, tipo, zona_id FROM [dbo].[vendedor]");
			ResultSet rs = s.executeQuery();				
		
			while(rs.next()) {
	
				String tipo = rs.getString("tipo"); 
				
				if(tipo.equals(Vendedor.TIPO_DIARIERIO_EXCLUSIVO)) {
				
					DiarieroExclusivo vendedor = new DiarieroExclusivo(
						rs.getString("codigo"), rs.getString("direccion"), null, null
					);
					
					vendedores.add(vendedor);
					
				} else if(tipo.equals(Vendedor.TIPO_REVISTERO_EXCLUSIVO)) {				

					RevisteroExclusivo vendedor = new RevisteroExclusivo(
						rs.getString("codigo"), rs.getString("direccion"), null, null
					);					
					
					vendedores.add(vendedor);
					
				} else if(tipo.equals(Vendedor.TIPO_DIARIERIO_REVISTERO)) {
					
					DiarieroRevistero vendedor = new DiarieroRevistero(
							rs.getString("codigo"), rs.getString("direccion"), null, null
						);					
						
					vendedores.add(vendedor);					
				}
			}
			
		} catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		PoolConnection.getInstance().realeaseConnection(conn);		
		
		return vendedores;		
	}
	
	public Vendedor find(String codigo) {
		
		Vendedor vendedor = null;
		
		Connection conn = PoolConnection.getInstance().getConnection();
			
		try {
			
			PreparedStatement s = conn.prepareStatement(
				"SELECT codigo, direccion, tipo, codigo_zona " + 
				"FROM [dbo].[vendedor] " + 
				"WHERE codigo = ?"
			);
			
			s.setString(1, codigo);
			ResultSet rs = s.executeQuery();				
		
			if(rs.next()) {
			
				String tipo = rs.getString("tipo"); 
				
				if(tipo.equals(Vendedor.TIPO_DIARIERIO_EXCLUSIVO)) {
					
					vendedor = new DiarieroExclusivo(
						rs.getString("codigo"), rs.getString("direccion"), null, null
					);
					
				} else if(tipo.equals(Vendedor.TIPO_REVISTERO_EXCLUSIVO)) {				

					vendedor = new RevisteroExclusivo(
						rs.getString("codigo"), rs.getString("direccion"), null, null
					);
					
				} else if(tipo.equals(Vendedor.TIPO_DIARIERIO_REVISTERO)) {
					
					vendedor = new DiarieroRevistero(
						rs.getString("codigo"), rs.getString("direccion"), null, null
					);
				}
			}
			
		} catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		PoolConnection.getInstance().realeaseConnection(conn);		
		
		return vendedor;
	}
	
	public Vector<Vendedor> findVendedoresXPublicacion(String codPublicacion) {
		
		Vector<Vendedor> vendedores = new Vector<Vendedor>();
		
		Connection conn = PoolConnection.getInstance().getConnection();
			
		try {
			
			PreparedStatement s = conn.prepareStatement(
				"SELECT v.tipo , v.direccion , v.codigo " + 
				"FROM vendedor_publicacion vp " + 
			    "INNER JOIN vendedor v ON vp.codigo_vendedor = v.codigo " + 
				"INNER JOIN publicacion p ON vp.codigo_publicacion = p.codigo " + 
			    "WHERE p.codigo = ?");
			
			s.setString(1, codPublicacion);
			ResultSet rs = s.executeQuery();				
		
			while(rs.next()) {
			
				String tipo = rs.getString("tipo"); 
				
				if(tipo.equals(Vendedor.TIPO_DIARIERIO_EXCLUSIVO)) {
					
					Vendedor vendedor = new DiarieroExclusivo(
						rs.getString("codigo"), rs.getString("direccion"), null, null
					);
					vendedores.add(vendedor);
					
				} else if(tipo.equals(Vendedor.TIPO_REVISTERO_EXCLUSIVO)) {				

					Vendedor vendedor = new RevisteroExclusivo(
							rs.getString("codigo"), rs.getString("direccion"), null, null
					);
					vendedores.add(vendedor);
					
				} else if(tipo.equals(Vendedor.TIPO_DIARIERIO_REVISTERO)) {
					
					Vendedor vendedor = new DiarieroRevistero(
							rs.getString("codigo"), rs.getString("direccion"), null, null
					);
					vendedores.add(vendedor);
				}
			}
			
		} catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		PoolConnection.getInstance().realeaseConnection(conn);		
		return vendedores;
	}
	
}
