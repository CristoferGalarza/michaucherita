package modelo.entidades;

import java.io.Serializable;
import java.sql.Date;//importación para el manejo de fechas
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.*;


@Entity
@Table(name = "Movimiento")
public class Movimiento implements Serializable{
	//Los movimientos se van aumentar cuando realicemos ingresos
	
	//Serializable
	private static final long serialVersionUID = 1L;//Definido de forma local
	
	//variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "concepto")
	private String concepto;
	
	@Column(name = "fecha")
	private Date fecha; //Es necesario tener fecha inicio y fecha fin?
	
	@Column(name = "valor")
	private double valor;
	
	@Column(name = "hora")
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
	
	@Override
	public String toString() {
		return "Movimiento [id=" + id + ", concepto=" + concepto + ", fecha=" + fecha + ", valor=" + valor + ", hora="
				+ hora + "]";
	}
	
}
