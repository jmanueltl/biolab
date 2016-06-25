package dto;

/**
 *
 * @author yaliagap
 */
public class Cita {
    private int idCita;
    private String fecha;
    private String hora;
    private int idEstadoCita;
    private int idPaciente;
    private int idTecnico;
    private int idTecnologo;
    private Persona p;
    private Estadocita ec ;

    public Estadocita getEc() {
        return ec;
    }

    public void setEc(Estadocita ec) {
        this.ec = ec;
    }

    public Cita() {
    }

    /**
     * @return the idCita
     */
    public int getIdCita() {
        return idCita;
    }

    /**
     * @param idCita the idCita to set
     */
    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * @return the idEstadoCita
     */
    public int getIdEstadoCita() {
        return idEstadoCita;
    }

    /**
     * @param idEstadoCita the idEstadoCita to set
     */
    public void setIdEstadoCita(int idEstadoCita) {
        this.idEstadoCita = idEstadoCita;
    }

    /**
     * @return the idPaciente
     */
    public int getIdPaciente() {
        return idPaciente;
    }

    /**
     * @param idPaciente the idPaciente to set
     */
    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    /**
     * @return the idTecnico
     */
    public int getIdTecnico() {
        return idTecnico;
    }
    public void setEstadoCita(Estadocita ec){
        this.ec = ec;
    }
    /**
     * @param idTecnico the idTecnico to set
     */
    public void setIdTecnico(int idTecnico) {
        this.idTecnico = idTecnico;
    }

    /**
     * @return the idTecnologo
     */
    public int getIdTecnologo() {
        return idTecnologo;
    }

    /**
     * @param idTecnologo the idTecnologo to set
     */
    public void setIdTecnologo(int idTecnologo) {
        this.idTecnologo = idTecnologo;
    }

    /**
     * @return the p
     */
    public Persona getP() {
        return p;
    }

    /**
     * @param p the p to set
     */
    public void setP(Persona p) {
        this.p = p;
    }
    
    
}
