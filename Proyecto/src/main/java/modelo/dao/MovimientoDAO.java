package modelo.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import modelo.conexion.BddConnection;
import modelo.entidades.Movimiento;

public class MovimientoDAO {
<<<<<<< HEAD

	private EntityManager em = null;

	//Constructor
	
	public MovimientoDAO() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia");
		this.em = emf.createEntityManager();
	}
	
	
	// devuelve una lista de movimientos
	public List<Movimiento> getAllSumarized(Date from, Date to) {
		String sentenciaJPQL = "SELECT m FROM Movimiento m WHERE m.fecha BETWEEN :from AND :to";

		Query query = this.em.createQuery(sentenciaJPQL);
		List<Movimiento> resultado = query.getResultList();
		return resultado;

	}


	// devuelve los movimientos segun el id de una cuenta y las fechas
	public List<Movimiento> getMovimientosCuenta(int idCuenta, Date from, Date to) {
		String sentenciaJPQL = "SELECT m FROM Movimiento m WHERE m.id = :idCuenta AND m.fecha BETWEEN :from AND :to";
=======
<<<<<<< Updated upstream
		//devuelve una lista de movimientos
		public static List<Movimiento> getAllSumarized(Date from, Date to) {
			String _SQL_GET_ALL_ = "SELECT * FROM MOVIMIENTO";
			try {
				PreparedStatement pstmt =  BddConnection.getConexion().prepareStatement(_SQL_GET_ALL_);
				ResultSet rs =  pstmt.executeQuery();//Resultados guardados en el result set
				//Vamos a iterar y formar un objeto, meterlo en la lista y devolverlo.
				List<Movimiento> movimiento = new ArrayList<Movimiento>();
				
				while(rs.next()) {
					//Creamos un nuevo objeto con el constructor y colocarmos los elementos en base a lo extraido del resultset.
					//Se deben ver los tipos de datos para aplicar el método get según corresponda.
					movimiento.add(new Movimiento(rs.getInt("id"), _SQL_GET_ALL_, to, 0, null));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*if (movimientos == null) {
=======
	
	private static List<Movimiento> movimientos = null;
	//devuelve una lista de movimientos
		public static List<Movimiento> getAllSumarized(Date from, Date to) {
			if (movimientos == null) {
				
>>>>>>> Stashed changes
				movimientos = new ArrayList<Movimiento>();
				
				movimientos.add(new Movimiento(1, "compra de suministro",
						Date.valueOf("2024-08-13"), 45.0, Time.valueOf("12:00:00")));
				movimientos.add(new Movimiento(2, "compra de zapatos",
						Date.valueOf("2024-08-15"), 50.0, Time.valueOf("08:30:00")));
				movimientos.add(new Movimiento(1, "compra de comida",
						Date.valueOf("2024-08-20"), 5.0, Time.valueOf("13:15:00")));
				movimientos.add(new Movimiento(3, "compra de comida",
						Date.valueOf("2024-08-26"), 16.0, Time.valueOf("10:20:00")));
			}
			return movimientos;*/
			
		}
>>>>>>> branch 'main' of https://github.com/CristoferGalarza/michaucherita.git
		
		Query query = this.em.createQuery(sentenciaJPQL);
		List<Movimiento> resultado = query.getResultList();
		return resultado;
	}
}
