package modelo;
// Generated 16-jun-2016 0:35:22 by Hibernate Tools 4.3.1



/**
 * Trabajador generated by hbm2java
 */
public class Trabajador  implements java.io.Serializable {


     private Integer idTrabajador;
     private String dni;
     private String nombres;
     private String apellidos;
     private String sexo;
     private String telefono;
     private String correo;

    public Trabajador() {
    }

    public Trabajador(String dni, String nombres, String apellidos, String sexo, String telefono, String correo) {
       this.dni = dni;
       this.nombres = nombres;
       this.apellidos = apellidos;
       this.sexo = sexo;
       this.telefono = telefono;
       this.correo = correo;
    }
   
    public Integer getIdTrabajador() {
        return this.idTrabajador;
    }
    
    public void setIdTrabajador(Integer idTrabajador) {
        this.idTrabajador = idTrabajador;
    }
    public String getDni() {
        return this.dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getNombres() {
        return this.nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
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

