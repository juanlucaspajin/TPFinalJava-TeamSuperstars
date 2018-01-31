package data;

import entities.Jugador;
import utils.ApplicationException;
import java.sql.*;


public class DataJugador {
	public DataJugador (){
		
	}
	
	public void add(Jugador j) throws ApplicationException{
		ResultSet rs=null;
		PreparedStatement stmt=null;
		
		
		try {
			stmt=FactoryConnection.getInstancia().getConn().prepareStatement(
					"insert into jugador(idJugador,nombre,apellido,posicion,estado)"+
					" values(?,?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			// PreparedStatement.RETURN_GENERATED_KEYS to be able to retrieve id generated on the db
			// by the autoincrement column. Otherwise don't use it
						
			stmt.setInt(1, 0);
			stmt.setString(2, j.getNombre());
			stmt.setString(3, j.getApellido());
			stmt.setString(4, j.getPosicion());
			stmt.setBoolean(5, j.isEstado());
			stmt.execute();
			
			//after executing the insert use the following lines to retrieve the id
			rs=stmt.getGeneratedKeys();
			/*if(rs!=null && rs.next()){
				j.setId(rs.getInt(1));
			}*/
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ApplicationException("Error en el sql al crear personaje",e);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();;
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null)stmt.close();
				FactoryConnection.getInstancia().releaseConn();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public boolean coincideNombre(Jugador j) {
		PreparedStatement stmt=null;
		ResultSet rs=null;
		boolean coincide = false;
		try {
			stmt = FactoryConnection.getInstancia().getConn().prepareStatement(
					"select nombre from personajes where nombre like ?");
			stmt.setString(1, j.getNombre());
			rs= stmt.executeQuery();
			if(rs!=null && rs.next()){
				if( ((String) rs.getObject(1)).matches(j.getNombre()) ) 
				{
					coincide =  true;
				}
				else { coincide = false; }
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConnection.getInstancia().releaseConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return coincide;
		
	}
}

