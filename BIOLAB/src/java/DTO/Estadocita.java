/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author yaliagap
 */
public class Estadocita {
    private Integer idestadoCita;
    private String estado;

    /**
     * @return the idestadoCita
     */
    public Integer getIdestadoCita() {
        return idestadoCita;
    }

    /**
     * @param idestadoCita the idestadoCita to set
     */
    public void setIdestadoCita(Integer idestadoCita) {
        this.idestadoCita = idestadoCita;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
