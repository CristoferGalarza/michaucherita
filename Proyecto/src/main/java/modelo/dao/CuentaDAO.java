package modelo.dao;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import modelo.entidades.Cuenta;

public class CuentaDAO {
<<<<<<< HEAD
	
	private EntityManager em=null;
	
	//constructor
	
	public CuentaDAO() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia");
		this.em = emf.createEntityManager();
=======
	public static List<Cuenta> getAll(){
		List<Cuenta> cuentas = new ArrayList<Cuenta>();
		if(cuentas == null) {
			cuentas = new ArrayList<Cuenta>();
			cuentas.add(new Cuenta(1, "Ahorros Pichincha", 150.0));
			cuentas.add(new Cuenta(2, "Ahorros Pacifico", 70.6));
		}
		return cuentas;
>>>>>>> branch 'main' of https://github.com/CristoferGalarza/michaucherita.git
	}
	
<<<<<<< HEAD
	public List<Cuenta> getAll(){
		String sentenciaJPQL = "SELECT c FROM Cuenta c ORDER BY c.id ASC";
		
		Query query = this.em.createQuery(sentenciaJPQL);
		List<Cuenta> resultado = query.getResultList();
		return resultado;
=======
	public static double actualizarTotal(int cuentaId, double monto) {
		double total = 0.0;
		for(Cuenta cuenta : getAll()) {
			if(cuenta.getId() == cuentaId) {
				total = total + monto;//problema con static
			}
		}
		return total;
>>>>>>> branch 'main' of https://github.com/CristoferGalarza/michaucherita.git
	}
	

	public double actualizarTotal(int cuentaId, double monto) {
		
	}
	
	public Cuenta getCuenta(int cuentaId) {
		
	}
}
