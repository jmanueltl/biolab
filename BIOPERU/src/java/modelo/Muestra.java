package modelo;
// Generated 16-jun-2016 0:35:22 by Hibernate Tools 4.3.1



/**
 * Muestra generated by hbm2java
 */
public class Muestra  implements java.io.Serializable {


     private Integer idMuestra;
     private Integer idCita;
     private String estado;

    public Muestra() {
    }

    public Muestra(Integer idCita, String estado) {
       this.idCita = idCita;
       this.estado = estado;
    }
   
    public Integer getIdMuestra() {
        return this.idMuestra;
    }
    
    public void setIdMuestra(Integer idMuestra) {
        this.idMuestra = idMuestra;
    }
    public Integer getIdCita() {
        return this.idCita;
    }
    
    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }




}


