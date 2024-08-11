package modelo.dao;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import modelo.entidades.Movimiento;

public class MovimientoDAO {
	//devuelve una lista de movimientos
		public static List<Movimiento> getAllSumarized(Date from, Date to) {
			if (movimientos == null) {
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
			return movimientos;
		}
		
		//devuelve los movimientos segun el id de una cuenta y las fechas
		public static List<Movimiento> getMovimientosCuenta(int idCuenta, Date from,
				Date to){
			List<Movimiento> movimientosFiltrados = new ArrayList<>();
		    
		    // Obtener todos los movimientos sumarios
		    for (Movimiento movimiento : getAllSumarized(from, to)) {
		        // Filtrar por ID de cuenta
		        if (movimiento.getId() == idCuenta) {
		            // Filtrar por rango de fechas
		            if (!movimiento.getFecha().before(from) && !movimiento.getFecha().after(to)) {
		                // Añadir el movimiento a la lista filtrada si cumple con los criterios
		                movimientosFiltrados.add(movimiento);
		            }
		        }
		    }
		    
		    return movimientosFiltrados;//cambiar esto en el uml
		}
}
