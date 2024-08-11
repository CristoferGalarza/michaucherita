package modelo.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cuenta implements Serializable{
	
	//Serializable
	private static final long serialVersionUID = 1L;//Definido de forma local
	
	//Variables
	private int id;
	private String nombre;
	private double total;
	
	private static List<Cuenta> cuentas = null;//BDD en memoria
	
	//Constructores
	
	public Cuenta() {
		
	}
	
	public Cuenta(int id, String nombre, double total) {
		this.id = id;
		this.nombre = nombre;
		this.total = total;
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
	
	
}
