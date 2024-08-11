package modelo;

import java.io.Serializable;
import java.sql.Date;//importación para el manejo de fechas
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Movimiento implements Serializable{
	
	//Serializable
	private static final long serialVersionUID = 1L;//Definido de forma local
	
	//variables
	private int id;
	private String concepto;
	private Date fecha; //Es necesario tener fecha inicio y fecha fin?
	private double valor;
	private Time hora;
	
	private static List<Movimiento> movimientos = null;//BDD en memoria
	
	//constructores
	
	public Movimiento() {
		
	}
	
	

	public Movimiento(int id, String concepto, Date fecha, double valor, Time hora) {
		this.id = id;
		this.concepto = concepto;
		this.fecha = fecha;
		this.valor = valor;
		this.hora = hora;
	}



	//Getter ans setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	//Otros métodos / métodos del negocio
	
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
