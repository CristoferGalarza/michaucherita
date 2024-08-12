package modelo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BddConnection {
	
	//variable estatica para convertirla a traves de singleton en una clase que nos da una sola instancia
	private static Connection cnn = null;

	//inicializamos las variables que nos van a permitir generar las url de conexion entre el jdbc con el motor de mysql
	public BddConnection() {
		String servidor = "127.0.0.1";
		String database = "michaucherita";
		String usuario = "root";
		String password = "root";
		
		String url = "jdbc:mysql://" + servidor + "/" + database; 
		
		//Es necesario registrar la libreria
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			cnn = DriverManager.getConnection(url, usuario, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConexion() {
		if(cnn == null) {
			new BddConnection();
		}
		return cnn;
	}
	
	//para ejecutar las consultas usamos prepared state y result set 
	
	public static void cerrar(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rs = null;
	}
	
	public static void cerrar(PreparedStatement pstmt) {
		try {
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//cerramos la conexion
	public static void cerrar() {
		if(cnn != null)
			try {
				cnn.close();
				cnn = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
}
