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
	    double nuevoTotal = -1; // Inicializar a -1 para indicar error si algo sale mal
	    this.em.getTransaction().begin();
	    try {
	        Cuenta cuenta = this.em.find(Cuenta.class, cuentaId);
	        if (cuenta != null) {
	            cuenta.setTotal(cuenta.getTotal() + monto);
	            this.em.merge(cuenta);
	            this.em.getTransaction().commit();
	            nuevoTotal = cuenta.getTotal();
	        } else {
	            // Si la cuenta no existe, no realizamos el commit
	            System.out.println("Cuenta no encontrada con ID: " + cuentaId);
	            this.em.getTransaction().rollback();
	        }
	    } catch (Exception e) {
	        System.out.println(">>>>>>>>>> ERROR: Actualizar total - " + e.getMessage());
	        
	        if (this.em.getTransaction().isActive()) {
	            this.em.getTransaction().rollback();
	        } 
	        nuevoTotal = -1; // Asegurar que se devuelve un valor indicativo de error
	    }
	    
	    return nuevoTotal;
	}
	
	public Cuenta getCuenta(int cuentaId) {
		return this.em.find(Cuenta.class, cuentaId);
	}
}

