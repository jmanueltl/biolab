package modelo;
// Generated 28-may-2016 18:45:12 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Estadocita generated by hbm2java
 */
public class Estadocita  implements java.io.Serializable {


     private Integer idestadoCita;
     private String estado;
     private Set citas = new HashSet(0);

    public Estadocita() {
    }

	
    public Estadocita(String estado) {
        this.estado = estado;
    }
    public Estadocita(String estado, Set citas) {
       this.estado = estado;
       this.citas = citas;
    }
   
    public Integer getIdestadoCita() {
        return this.idestadoCita;
    }
    
    public void setIdestadoCita(Integer idestadoCita) {
        this.idestadoCita = idestadoCita;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Set getCitas() {
        return this.citas;
    }
    
    public void setCitas(Set citas) {
        this.citas = citas;
    }




}

