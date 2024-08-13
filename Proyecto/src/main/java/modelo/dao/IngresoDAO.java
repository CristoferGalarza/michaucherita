package modelo.dao;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import modelo.entidades.Categoria;
import modelo.entidades.CategoriaIngreso;
import modelo.entidades.Ingreso;

public class IngresoDAO {
    
	private EntityManager em=null;
	
	public IngresoDAO(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia");
		this.em = emf.createEntityManager();
	}
	
	//se agrega un objeto de tipo cuenta para actualizarlo
	public boolean agregarIngreso(int cuentaId, String concepto, Date fecha, Categoria categoria, double monto) {
		if (concepto == null || concepto.isEmpty() || fecha == null || monto <= 0) {
            return false; // Validación básica
        }

        try {
            this.em.getTransaction().begin();
            Ingreso ingreso = new Ingreso(); // Constructor sin categoría
            this.em.persist(ingreso);
            this.em.getTransaction().commit();

            // Actualizar el total de la cuenta
            CuentaDAO cuentaDAO = new CuentaDAO();
            cuentaDAO.actualizarTotal(cuentaId, monto);
            return true;
        } catch (Exception e) {
            this.em.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
	}
}
