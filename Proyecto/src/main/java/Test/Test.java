package Test;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import modelo.entidades.Cuenta;

public class Test {

	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("persistencia").createEntityManager();
		
		String sentenciaJPQL = "SELECT c FROM Cuenta c ORDER BY c.id ASC";
		
		Query query = em.createQuery(sentenciaJPQL);
		List<Cuenta> resultado = query.getResultList();
		for (Cuenta cuenta : resultado) {
			System.out.println(cuenta);
		}
	}

}
