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
public class Paciente {
    
    private int dni;
     private String nombre;
     private String apellidos;
     private String sexo;
     private int edad;
     private String telefono;
     private String correo;
     private String contrasenia;

    
    public int getDni() {
        return dni;
    }

    
    public void setDni(int dni) {
        this.dni = dni;
    }

   
    public String getNombre() {
        return nombre;
    }

   
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellidos() {
        return apellidos;
    }

    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

   
    public String getSexo() {
        return sexo;
    }

   
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    
    public int getEdad() {
        return edad;
    }

    
    public void setEdad(int edad) {
        this.edad = edad;
    }

    
    public String getTelefono() {
        return telefono;
    }

    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
    public String getCorreo() {
        return correo;
    }

   
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    
    public String getContrasenia() {
        return contrasenia;
    }

    
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
     
    
}
