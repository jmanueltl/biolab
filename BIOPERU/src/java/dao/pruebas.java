/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Tipousuario;
import modelo.Usuario;

/**
 *
 * @author jack
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        operacionUsuario opUsuario = new operacionUsuario();
        operacionTipoUsuario opTipoUsuario  = new operacionTipoUsuario();
        String login = "usu1";
        String clave = "usu1";

        Usuario objUsuario = opUsuario.validarLogin(login, clave);

        if (objUsuario != null) {
            /*
            Tipousuario objTipoUsuario = objUsuario.getTipousuario();
            //trayendo el resto de datos del tipoUsuario segun id
            int idTipo = objTipoUsuario.getIdTipoUsuario();
            objTipoUsuario = opTipoUsuario.getTipoPorId(idTipo);
            
            System.out.println("id: "+objTipoUsuario.getIdTipoUsuario()+" cargo: "+objTipoUsuario.getCargo() );*/
        }
    }
    
}
