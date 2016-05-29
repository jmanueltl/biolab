/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
import java.util.Date;

/**
 *
 * @author yaliagap
 */
public class Cita {
    
    private Integer idCita;
    private Estadocita estadocita;
    private Paciente paciente;
    private Trabajador trabajador;
    private Date fechaCita;
    private Date horaCita;

    /**
     * @return the idCita
     */
    public Integer getIdCita() {
        return idCita;
    }

    /**
     * @param idCita the idCita to set
     */
    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    /**
     * @return the estadocita
     */
    public Estadocita getEstadocita() {
        return estadocita;
    }

    /**
     * @param estadocita the estadocita to set
     */
    public void setEstadocita(Estadocita estadocita) {
        this.estadocita = estadocita;
    }

    /**
     * @return the paciente
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * @param paciente the paciente to set
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    /**
     * @return the trabajador
     */
    public Trabajador getTrabajador() {
        return trabajador;
    }

    /**
     * @param trabajador the trabajador to set
     */
    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    /**
     * @return the fechaCita
     */
    public Date getFechaCita() {
        return fechaCita;
    }

    /**
     * @param fechaCita the fechaCita to set
     */
    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    /**
     * @return the horaCita
     */
    public Date getHoraCita() {
        return horaCita;
    }

    /**
     * @param horaCita the horaCita to set
     */
    public void setHoraCita(Date horaCita) {
        this.horaCita = horaCita;
    }
     
    
}
