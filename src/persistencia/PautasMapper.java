package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import modelo.DiarieroExclusivo;
import modelo.DiarieroRevistero;
import modelo.Pauta;
import modelo.PautaAgotado;
import modelo.PautaExceso;
import modelo.PautaZona;
import modelo.Publicacion;
import modelo.PublicacionDiario;
import modelo.PublicacionRevista;
import modelo.RevisteroExclusivo;
import modelo.Rol;
import modelo.Usuario;
import modelo.Vendedor;
import modelo.Zona;

public class PautasMapper {

	private static PautasMapper instance;
	
	private PautasMapper() {
		
	}
	
	public static PautasMapper getInstance() {
		
		if(instance == null) {
			instance = new PautasMapper();
		}
		
		return instance;
	}
	
	public Vector<Pauta> findAll() {
		
		Vector<Pauta> pautasActivas = new Vector<Pauta>();
		
		Connection conn = PoolConnection.getInstance().getConnection();
			
		try {
			
			PreparedStatement s = conn.prepareStatement(
				"SELECT codigo, estado FROM pauta"
			);
			
			ResultSet rs = s.executeQuery();				
		
			while(rs.next()) {
				
				String codigoPauta = rs.getString("codigo"); 
				
				if(codigoPauta.equals(PautaAgotado.CODIGO_PAUTA)) {
					
					pautasActivas.add(new PautaAgotado(rs.getString("codigo"), rs.getString("estado")));
					
				} else if(codigoPauta.equals(PautaExceso.CODIGO_PAUTA)) {
					
					pautasActivas.add(new PautaExceso(rs.getString("codigo"), rs.getString("estado")));
					
				} else if(codigoPauta.equals(PautaZona.CODIGO_PAUTA)) {
					
					pautasActivas.add(new PautaZona(rs.getString("codigo"), rs.getString("estado")));
				}
			}
			
		} catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		PoolConnection.getInstance().realeaseConnection(conn);		
		
		return pautasActivas;
	}
}
