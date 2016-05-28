package modelo;
// Generated 28-may-2016 18:45:12 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Cita generated by hbm2java
 */
public class Cita  implements java.io.Serializable {


     private Integer idCita;
     private Estadocita estadocita;
     private Paciente paciente;
     private Trabajador trabajador;
     private Date fechaCita;
     private Date horaCita;
     private Set muestras = new HashSet(0);
     private Set detallecitas = new HashSet(0);

    public Cita() {
    }

	
    public Cita(Estadocita estadocita) {
        this.estadocita = estadocita;
    }
    public Cita(Estadocita estadocita, Paciente paciente, Trabajador trabajador, Date fechaCita, Date horaCita, Set muestras, Set detallecitas) {
       this.estadocita = estadocita;
       this.paciente = paciente;
       this.trabajador = trabajador;
       this.fechaCita = fechaCita;
       this.horaCita = horaCita;
       this.muestras = muestras;
       this.detallecitas = detallecitas;
    }
   
    public Integer getIdCita() {
        return this.idCita;
    }
    
    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }
    public Estadocita getEstadocita() {
        return this.estadocita;
    }
    
    public void setEstadocita(Estadocita estadocita) {
        this.estadocita = estadocita;
    }
    public Paciente getPaciente() {
        return this.paciente;
    }
    
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public Trabajador getTrabajador() {
        return this.trabajador;
    }
    
    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }
    public Date getFechaCita() {
        return this.fechaCita;
    }
    
    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }
    public Date getHoraCita() {
        return this.horaCita;
    }
    
    public void setHoraCita(Date horaCita) {
        this.horaCita = horaCita;
    }
    public Set getMuestras() {
        return this.muestras;
    }
    
    public void setMuestras(Set muestras) {
        this.muestras = muestras;
    }
    public Set getDetallecitas() {
        return this.detallecitas;
    }
    
    public void setDetallecitas(Set detallecitas) {
        this.detallecitas = detallecitas;
    }




}


