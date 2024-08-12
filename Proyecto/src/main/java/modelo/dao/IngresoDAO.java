package modelo.dao;

public class IngresoDAO {
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import modelo.entidades.Ingreso;

public class IngresoDAO {
    private static List<Ingreso> ingresos;

    public static boolean agregarIngreso(int cuentaId, String concepto, Date fecha, String categoria, double monto) {
        if (ingresos == null) {
            ingresos = new ArrayList<>();
        }
        
        if (concepto == null || concepto.isEmpty() || fecha == null || monto <= 0 || categoria == null || categoria.isEmpty()) {
            return false; // Validación básica
        }

        Ingreso ingreso = new Ingreso(concepto, fecha, monto, categoria);
        ingresos.add(ingreso);

        // Actualizar el total de la cuenta
        CuentaDAO.actualizarTotal(cuentaId, monto);

        return true;
    }

  
    public static List<Ingreso> obtenerTodosLosIngresos() {
        if (ingresos == null) {
            ingresos = new ArrayList<>();
        }
        return new ArrayList<>(ingresos);
    }

    public static List<Ingreso> obtenerIngresosPorFecha(Date from, Date to) {
        List<Ingreso> resultado = new ArrayList<>();
        if (ingresos != null) {
            for (Ingreso ingreso : ingresos) {
                if (!ingreso.getFecha().before(from) && !ingreso.getFecha().after(to)) {
                    resultado.add(ingreso);
                }
            }
        }
        return resultado;
    }
    
}
