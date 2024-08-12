package modelo.dao;

import java.util.ArrayList;
import java.util.List;

import modelo.entidades.Cuenta;

public class CuentaDAO {
	public static List<Cuenta> getAll(){
		List<Cuenta> cuentas = new ArrayList<Cuenta>();
		if(cuentas == null) {
			cuentas = new ArrayList<Cuenta>();
			cuentas.add(new Cuenta(1, "Ahorros Pichincha", 150.0));
			cuentas.add(new Cuenta(2, "Ahorros Pacifico", 70.6));
		}
		return cuentas;
	}
	
	public static double actualizarTotal(int cuentaId, double monto) {
		double total = 0.0;
		for(Cuenta cuenta : getAll()) {
			if(cuenta.getId() == cuentaId) {
				total = total + monto;//problema con static
			}
		}
		return total;
	}
	
	public static Cuenta getCuenta(int cuentaId) {
		for(Cuenta cuenta : getAll()) {
			if(cuenta.getId() == cuentaId) {
				return cuenta;
			}
		}
		return null;
	}
}
