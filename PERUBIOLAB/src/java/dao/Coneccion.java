/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


/**
 *
 * @author jack
 */
public class Coneccion {
    private String database = "laboratorio";
    private String driver="com.mysql.jdbc.Driver";
    private String url="jdbc:mysql://localhost:3306/"+database+"?zeroDateTimeBehavior=convertToNull&autoReconnect=true&failOverReadOnly=false&maxReconnects=10";
    private String user="root";
    private String pass="";
    /*
    private String url="jdbc:mysql://localhost:3306/"+database+"?zeroDateTimeBehavior=convertToNull";
    private String user="root";
    private String pass="Telefonic4";*/
   //&autoReconnect=true&failOverReadOnly=false&maxReconnects=10
    public Coneccion() {
    }
    
    public Connection conectar()  {
        try {
            Class.forName(driver);
            //System.out.println("aaa: "+DriverManager.getConnection(url,user,pass));
            
            return (DriverManager.getConnection(url,user,pass));
        } catch (Exception e) {
            System.out.println("mala conexion");
            //JOptionPane.showMessageDialog(null, e,"Error conexion BD "+e.getMessage(),JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            //System.out.println("Error: " + e.toString());
        }
        return null;
    }
    public void desconectar(Connection con){
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getDB(){
        return database;
    }
    
    
}
