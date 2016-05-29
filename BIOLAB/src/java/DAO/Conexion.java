/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author yaliagap
 */
public class Conexion {

    protected Connection cn = null;
    protected PreparedStatement ps = null;
    protected ResultSet rs = null;

    public Connection obtenerConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/laboratorio", "root", "");
        } catch (Exception ex) {
            System.out.println("YERSY: Error CONEXION base de datos");
            return null;
        }
    }

}
