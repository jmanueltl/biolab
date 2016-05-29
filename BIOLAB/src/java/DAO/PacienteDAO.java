/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;
import DTO.*;
import Util.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JOptionPane;

/**
 *
 * @author yaliagap
 */
public class PacienteDAO extends Conexion {
    
    /*
    private ResultSetMetaData rsm;
    public Consulta obtener_Consulta(ResultSet rs) {
        Consulta consulta = new Consulta();
        String columna[], data[][];
        int rowSize = 0;
        try {
            rs.last();
            rowSize = rs.getRow();
            rs.beforeFirst();
            rsm = rs.getMetaData();
            
            int columnSize = rsm.getColumnCount();
            columna=new String[columnSize];
            for (int i=1;i<=columnSize;i++){
            
                columna[i-1]=rsm.getColumnName(i);
            }
            consulta.setColumnas(columna);
            
            data = new String[rowSize][columnSize];
            int contador_fila=0;
            while(rs.next() && contador_fila < rowSize){
                for(int j=1;j<=columnSize;j++){
                    data[contador_fila][j-1] = rs.getString(j);
                }
                contador_fila++;                    
            }
            consulta.setData(data);
        rs.close();
        }
        catch(Exception ex) {
            
        }
        
        return consulta;
    }
    */
    
    public boolean validarPaciente(Paciente paciente) throws Exception{
        boolean bandera;
        try{
            cn = obtenerConexion();
            String sql = "select * FROM Paciente WHERE correo=? and contrasenia =?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, paciente.getCorreo());
            ps.setString(2, paciente.getContrasenia());
            rs = ps.executeQuery();
            //System.out.println("usuario:"+ usuario.getUsuario()+"clave: "+usuario.getContraseña());
            //System.out.println("valor: " +rs.isBeforeFirst());
            if(rs.first()){
                bandera= true;
            }else{
                bandera= false;
            }
            
        }finally{
            rs.close();
            ps.close();
            cn.close();
        }
        
        return bandera;
    }
    
    /*
    public Paciente getPacienteLogin(Paciente paciente){
        Consulta consulta = new Consulta();
        try {
            cn=obtenerConexion();
            ps=cn.prepareStatement("SELECT * FROM Paciente" );
            
            //pr.setString(1, paciente.getCorreo());
            //pr.setString(2,paciente.getContrasenia());
            
            rs=ps.executeQuery();
            consulta=obtener_Consulta(rs);
          
            String dni=consulta.getData()[0][0];
            int d=Integer.parseInt(dni);
            paciente.setDni(d);
            cn.close();
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex.toString());
        }      
        
        return paciente;
        
    }
    */
}
