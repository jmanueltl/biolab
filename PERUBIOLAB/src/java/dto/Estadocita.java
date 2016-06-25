/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author jack
 */
public class Estadocita {


     private Integer idEstadoCita;
     private String estado;

    public Estadocita() {
    }

    public Estadocita(String estado) {
       this.estado = estado;
    }
   
    public Integer getIdEstadoCita() {
        return this.idEstadoCita;
    }
    
    public void setIdEstadoCita(Integer idEstadoCita) {
        this.idEstadoCita = idEstadoCita;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
}