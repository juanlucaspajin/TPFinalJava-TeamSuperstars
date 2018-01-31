package data;
import java.sql.*;

import utils.ApplicationException;

public class FactoryConnection {
	private String dbDriver="com.mysql.jdbc.Driver";
	private String host="localhost";
	private String port="3306";
	private String user="root";
	private String pass="juanlucas";
	private String db="bd_team_superstar";
	private String dbType="mysql";
	

	private Connection conn;
	private int cantConn=0;
	
	private FactoryConnection() throws ApplicationException{
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			throw new ApplicationException("Error del Driver JDBC",e);
		}
	}
	
	private static FactoryConnection instancia;
	
	public static FactoryConnection getInstancia() throws ApplicationException{
		if (instancia==null){
			instancia = new FactoryConnection();
		}
		return instancia;
	}
	
	public Connection getConn(){
		try {
			if(conn==null || conn.isClosed()){
				conn = DriverManager.getConnection(
						"jdbc:"+dbType+"://"+host+":"+port+"/"+
						db+"?user="+user+"&password="+pass);
				cantConn++;
			}
		} catch (SQLException e) {
			new ApplicationException("Error al conectar a la DB",e);

		}
		return conn;
	}
	
	public void releaseConn() throws ApplicationException{
		try {
			cantConn--;
			if(cantConn==0){
				conn.close();
			}
		} catch (SQLException e) {
			throw new ApplicationException("Error al cerrar conexión",e);
		}
		
	}
}
