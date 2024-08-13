package modelo.entidades;
import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Ingreso extends Movimiento implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @ManyToOne
    @JoinColumn(name = "destino")
    private Cuenta destino;
    @ManyToOne
    @JoinColumn(name = "categoria")
    private CategoriaIngreso categoria;
    

    public Ingreso() {}


	public Cuenta getDestino() {
		return destino;
	}


	public void setDestino(Cuenta destino) {
		this.destino = destino;
	}


	public CategoriaIngreso getCategoria() {
		return categoria;
	}


	public void setCategoria(CategoriaIngreso categoria) {
		this.categoria = categoria;
	}


	@Override
	public String toString() {
		return "Ingreso [destino=" + destino + ", categoria=" + categoria + "]";
	}

      
}


