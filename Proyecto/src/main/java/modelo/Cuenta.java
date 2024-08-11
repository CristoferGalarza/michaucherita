package modelo;

import java.io.Serializable;
import java.util.List;

public class Cuenta implements Serializable{
	
	//Serializable
	private static final long serialVersionUID = 1L;//Definido de forma local
	
	//Variables
	private int id;
	private String nombre;
	private double total;
	
	//Constructores
	
	public Cuenta() {
		
	}
	
	
	
	//Getter and setter
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	//Otros métodos / métodos del negocio
	
	public static List<Cuenta> getAll(){
		return null;
	}
	
	public static double actualizarTotal(int cuentaId, double monto) {
		return 0;//revisar la devolución para total
	}
	
	public static Cuenta getCuenta(int cuentaId) {
		return null;
	}
}
