/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Usuario;

/**
 *
 * @author yaliagap
 */
public class UsuarioDAO extends Conexion {
    public boolean validarUsuario(Usuario usuario) throws Exception{
        boolean bandera;
        try{
            cn = obtenerConexion();
            String sql = "select * FROM Usuario WHERE login=? and clave =?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, usuario.getLogin());
            ps.setString(2, usuario.getClave());
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
}
