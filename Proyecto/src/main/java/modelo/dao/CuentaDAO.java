package modelo.dao;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import modelo.entidades.Cuenta;

public class CuentaDAO {
	
	private EntityManager em=null;
	
	//constructor
	
	public CuentaDAO() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia");
		this.em = emf.createEntityManager();
	}
	
	public List<Cuenta> getAll(){
		String sentenciaJPQL = "SELECT c FROM Cuenta c ORDER BY c.id ASC";
		
		Query query = this.em.createQuery(sentenciaJPQL);
		List<Cuenta> resultado = query.getResultList();
		return resultado;
	}
	

	public double actualizarTotal(int cuentaId, double monto) {
		
	}
	
	public Cuenta getCuenta(int cuentaId) {
		
	}
}

