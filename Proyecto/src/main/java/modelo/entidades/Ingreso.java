package modelo.entidades;
import java.io.Serializable;
import java.sql.Date;

public class Ingreso implements Serializable {
    private static final long serialVersionUID = 1L;

    private String concepto;
    private Date fecha;
    private Double monto;
    private Categoria categoria;

    public Ingreso() {}

    public Ingreso(String concepto, Date fecha, Double monto, Categoria categoria) {
        this.concepto = concepto;
        this.fecha = fecha;
        this.monto = monto;
        this.categoria = categoria;
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

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /*************** MÉTODOS DEL NEGOCIO ***************/

   
    public void agregarIngreso(Double monto) {
        this.monto += monto;
    }
}


