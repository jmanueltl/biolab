package modelo;
// Generated 16-jun-2016 0:35:22 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Resultado generated by hbm2java
 */
public class Resultado  implements java.io.Serializable {


     private Integer idResultado;
     private Date fecha;
     private String valor;

    public Resultado() {
    }

    public Resultado(Date fecha, String valor) {
       this.fecha = fecha;
       this.valor = valor;
    }
   
    public Integer getIdResultado() {
        return this.idResultado;
    }
    
    public void setIdResultado(Integer idResultado) {
        this.idResultado = idResultado;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getValor() {
        return this.valor;
    }
    
    public void setValor(String valor) {
        this.valor = valor;
    }




}


