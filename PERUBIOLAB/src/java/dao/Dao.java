/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import dto.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import util.Utilitarios;

/**
 *
 * @author ALDO
 */
public class Dao {
    
    private Coneccion con = new Coneccion();
    private Connection cn;
    private ResultSet rs;
    private CallableStatement cs;
    private PreparedStatement ps;
    private Utilitarios util = new Utilitarios();
    
    
    public int validar_Usuario(String usuario, String password){
        
        int existe=0;
        
        try {    
        	
            cn=con.conectar();
            cs = cn.prepareCall("{call login_usuario(?,?,?)}");
            cs.setString(1, usuario);
            cs.setString(2, password);
            cs.registerOutParameter(3, Types.INTEGER);
            cs.execute();
            existe=cs.getInt(3);
            cs.close();
            cn.close();
            
        } catch (SQLException ex) {
            
        }
        
        return existe;
    }
    public int existePaciente(String dni){
        
        int existe=0;
        
        try {    
        	
            cn=con.conectar();
            cs = cn.prepareCall("{call existe_paciente(?)}");
            cs.setString(1, dni);
            cs.execute();
            existe=cs.getInt(1);
            cs.close();
            cn.close();
            
        } catch (SQLException ex) {
            
        }
        
        return existe;
    }
    public int  ultimaCita(){
        System.out.println("metodo ultimaCita");
        int idCita=0;
        try {    
        	
            cn=con.conectar();
            cs = cn.prepareCall("{call ultima_cita()}");
            cs.execute();
            rs=cs.getResultSet();
            if(rs.next()){
            idCita=rs.getInt(1);
            }
            System.out.println("uno id: "+idCita);
            rs.close();
            cs.close();
            cn.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return idCita;
    }
   
    public void registrarPersona(Persona p){
        try {    
        	
            cn=con.conectar();
            cs = cn.prepareCall("{call registrar_persona(?,?,?,?,?,?)}");
            cs.setString(1, p.getDni());
            cs.setString(2, p.getNombre());
            cs.setString(3, p.getApellidos());
            cs.setString(4, p.getSexo());
            cs.setString(5, p.getTelefono());
            cs.setString(6, p.getCorreo());
            cs.execute();
            cs.close();
            cn.close();
            
        } catch (SQLException ex) {
            
        }
    }
   
    public void agregarCita(Cita c){
        
        try {    
             
            cn=con.conectar();
            cs = cn.prepareCall("{call agregar_cita(?,?,?)}");
            cs.setString(1, c.getFechaHora());
            cs.setInt(2, c.getIdEstadoCita());
            cs.setInt(3, c.getIdPaciente());
            cs.execute();
            cs.close();
            cn.close();
            
        } catch (SQLException ex) {
            
        }
    }
     public void agregarDetalleCita(Detallecita dc){
        
        try {    
             
            cn=con.conectar();
            cs = cn.prepareCall("{call agregar_detalle_cita(?,?)}");
            cs.setInt(1, dc.getIdCita());
            cs.setInt(2, dc.getIdExamen());
            cs.execute();
            cs.close();
            cn.close();
            
        } catch (SQLException ex) {
            
        }
    }
    public void datosPaciente(Persona per){
        try {
            
            cn=con.conectar();
            cs = cn.prepareCall("{call datos_paciente(?)}");
            cs.setString(1, per.getDni());
            cs.execute();
            rs=cs.getResultSet();
            if(rs.next()){
                per.setIdPaciente(rs.getInt(1));
                per.setDni(rs.getString(2));
                per.setNombre(rs.getString(3));
                per.setApellidos(rs.getString(4));
                per.setSexo(rs.getString(5));
                per.setTelefono(rs.getString(6));
                per.setCorreo(rs.getString(7));
                
            }
            cs.close();
            rs.close();
            cn.close();
            
        } catch (SQLException ex) {
            
        }
        
    }
    public void datosUsuario(Usuario usu){
    
      
        try {
            
            cn=con.conectar();
            cs = cn.prepareCall("{call datos_usuario(?)}");
            cs.setString(1, usu.getUsuario());
            cs.execute();
            rs=cs.getResultSet();
            if(rs.next()){
                usu.setIdPersona(rs.getInt(1));
                usu.setPerfil(rs.getString(2));
                usu.setIdPersona(rs.getInt(3));
                usu.setDni(rs.getString(4));
                usu.setNombres(rs.getString(5));
                usu.setApellidos(rs.getString(6));
                usu.setSexo(rs.getString(7));
                usu.setTelefono(rs.getString(8));
                usu.setCorreo(rs.getString(9));
                usu.setIdTipoUsuario(rs.getInt(10));
            }
            cs.close();
            rs.close();
            cn.close();
            
        } catch (SQLException ex) {
            
        }
        
        //return usu;
    }
    
    public Consulta listar_Gestion(String querry){
        
        Consulta consulta = new Consulta();
        try {
            cn=con.conectar();
            ps=cn.prepareStatement(querry);
            rs=ps.executeQuery();
            consulta=util.obtener_Consulta(rs);
            rs.close();
            ps.close();
            cn.close();
        } catch (SQLException ex) {
            
        }
        
        return consulta;
    }
    
    public Empresa listar_Empresa(String querry){
        
        Empresa empresa = new Empresa();
        try {
            cn=con.conectar();
            ps=cn.prepareStatement(querry);
            rs=ps.executeQuery();
            
            while(rs.next()){
            	empresa.setRuc(rs.getString("ruc"));
            	empresa.setRazonSocial(rs.getString("razon_social"));
            	empresa.setClaro(rs.getString("claro"));
            	empresa.setEntel(rs.getString("entel"));
            	empresa.setTs1(rs.getString("telefono_sunat_1"));
            	empresa.setTs1(rs.getString("telefono_sunat_2"));
            	empresa.setTs1(rs.getString("telefono_sunat_3"));
            	empresa.setTs1(rs.getString("telefono_sunat_4"));
            	empresa.setTs1(rs.getString("telefono_sunat_5"));
            }
            rs.close();
            ps.close();
            cn.close();
        } catch (SQLException ex) {
            
        }
        
        return empresa;
    }

    public String registrar_Gestion(Feedback feedback) {

            String mensaje="",querry="update " + feedback.getBase() + " set claro = ? ,entel = ? ,resultado = ? " +
            ",contacto= ? ,cargo = ? ,correo = ? ,telefono_sunat_1 = ? ,telefono_sunat_2 = ? ,telefono_sunat_3 = ? " + 
            ",telefono_sunat_4 = ? ,telefono_sunat_5 = ? , total = ? where ruc = ?";
            int total = Integer.parseInt(feedback.getQClaro()) + Integer.parseInt(feedback.getQEntel()); 

        try {

            cn=con.conectar();
            cs = cn.prepareCall("{call registrar_gestion(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, feedback.getRuc());
            cs.setString(2, feedback.getGestor());
            cs.setString(3, feedback.getFecha_Asignacion());
            cs.setString(4, feedback.getResultado());
            cs.setString(5, feedback.getOportunidad());
            cs.setString(6, feedback.getFecha_Cita());
            cs.setString(7, feedback.getPersona_Contacto());
            cs.setString(8, feedback.getCargo());
            cs.setString(9, feedback.getTs1());
            cs.setString(10, feedback.getTs2());
            cs.setString(11, feedback.getTs3());
            cs.setString(12, feedback.getTs4());
            cs.setString(13, feedback.getTs5());
            cs.setString(14, feedback.getCorreo_Contacto());
            cs.setInt(15, util.nulo_A_Int(feedback.getOportunidad_Fija()));
            cs.setInt(16, util.nulo_A_Int(feedback.getOportunidad_Movil()));
            cs.setString(17, "1");
            cs.setString(18, "2");
            cs.setString(19, feedback.getBase());
            cs.execute();

            ps=cn.prepareStatement(querry);
        ps.setString(1, feedback.getQClaro());
        ps.setString(2, feedback.getQEntel());
        ps.setString(3, feedback.getResultado());
        ps.setString(4, feedback.getPersona_Contacto());
        ps.setString(5, feedback.getCargo());
        ps.setString(6, feedback.getCorreo_Contacto());
        ps.setString(7, feedback.getTs1());
        ps.setString(8, feedback.getTs2());
        ps.setString(9, feedback.getTs3());
        ps.setString(10, feedback.getTs4());
        ps.setString(11, feedback.getTs5());
        ps.setString(12, Integer.toString(total));
        ps.setString(13, feedback.getRuc());
        ps.executeUpdate();

        ps.close();
            cs.close();
            cn.close();

            mensaje="Gestion Registrada con Exito";

        } catch (SQLException ex) {
            mensaje="Error al registrar la gestion: " + ex.toString();
        }

        return mensaje;
    }
	
    public String[] Listar_Bases(String usuario) {
        Consulta consulta = new Consulta();
        try {
            cn=con.conectar();
            cs = cn.prepareCall("{call listar_bases_asignadas(?)}");
            cs.setString(1, usuario);
            cs.execute();
            rs=cs.getResultSet();
            consulta=util.obtener_Consulta(rs);
            cn.close();
            rs.close();
        } catch (SQLException ex) {
            
        }
        
        return util.Listar_Columna(0, consulta.getData());
    }
    
    public Consulta listar_Feedback(String usuario){
        
        Consulta consulta = new Consulta();
        
        try {
            cn=con.conectar();
            cs = cn.prepareCall("{call listar_feedback(?)}");
            cs.setString(1, usuario);
            cs.execute();
            rs=cs.getResultSet();
            consulta=util.obtener_Consulta(rs);
            cn.close();
            rs.close();
        } catch (SQLException ex) {
            
        }
        
        return consulta;
    }
    
    public Consulta listar_Citas(String usuario){
        
        Consulta consulta = new Consulta();
        
        try {
            cn=con.conectar();
            cs = cn.prepareCall("{call listar_citas(?)}");
            cs.setString(1, usuario);
            cs.execute();
            rs=cs.getResultSet();
            consulta=util.obtener_Consulta(rs);
            cn.close();
            rs.close();
        } catch (SQLException ex) {
            
        }
        
        return consulta;
    }
    /*
    public void registrar_Fannel(Feedback feedback) {
        try {
            cn=con.conectar();
            cs = cn.prepareCall("{call registrar_fannel(?,?,?,?,?,?,?,?)}");
            cs.setString(1, feedback.getGestor());
            cs.setString(2, feedback.getRuc());
            cs.setString(3, feedback.getFacturacion());
            cs.setString(4, feedback.getOportunidad());
            cs.setInt(5, (util.nulo_A_Int(feedback.getQClaro())+util.nulo_A_Int(feedback.getQEntel())));
            cs.setString(6, feedback.getFecha_cita());
            cs.setInt(7, util.nulo_A_Int(feedback.getOportunidad_Fija()));
            cs.setInt(8, util.nulo_A_Int(feedback.getOportunidad_Fija()));
            cs.execute();
            
            cs.close();
            cn.close();
            JOptionPane.showMessageDialog(null, "Fannel Registrada con Éxito");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }*/
    
}
