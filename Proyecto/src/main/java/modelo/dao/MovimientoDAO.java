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
		
		Query query = this.em.createQuery(sentenciaJPQL);
		List<Movimiento> resultado = query.getResultList();
		return resultado;
	}
}