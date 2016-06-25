package modelo;
// Generated 16-jun-2016 0:35:22 by Hibernate Tools 4.3.1



/**
 * Paciente generated by hbm2java
 */
public class Paciente  implements java.io.Serializable {


     private Integer idPaciente;
     private Integer dni;
     private String nombre;
     private String apellidos;
     private String sexo;
     private String telefono;
     private String correo;

    public Paciente() {
    }

    public Paciente(Integer dni, String nombre, String apellidos, String sexo, String telefono, String correo) {
       this.dni = dni;
       this.nombre = nombre;
       this.apellidos = apellidos;
       this.sexo = sexo;
       this.telefono = telefono;
       this.correo = correo;
    }
   
    public Integer getIdPaciente() {
        return this.idPaciente;
    }
    
    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }
    public Integer getDni() {
        return this.dni;
    }
    
    public void setDni(Integer dni) {
        this.dni = dni;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getSexo() {
        return this.sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }




}

