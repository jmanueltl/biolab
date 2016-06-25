/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.operacionPaciente;
import dao.operacionTipoUsuario;
import dao.operacionTrabajador;
import dao.operacionUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Paciente;
import modelo.Tipousuario;
import modelo.Trabajador;
import modelo.Usuario;

/**
 *
 * @author jack
 */
@WebServlet(name = "controlLogin", urlPatterns = {"/controlLogin"})
public class controlLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int accion = Integer.parseInt(request.getParameter("action"));
        switch (accion) {
            case 1: //inicio de sesion
                iniciarSesion(request, response);
                break;
            case 2://cierre de sesion
                cerrarSesion(request, response);
                break;
        }

    }

    private void iniciarSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession respuesta = request.getSession(true);
        operacionUsuario opUsuario = new operacionUsuario();
        operacionTipoUsuario opTipoUsuario = new operacionTipoUsuario();
        operacionPaciente opPaciente = new operacionPaciente();
        operacionTrabajador opTrabajador = new operacionTrabajador();

        String login = request.getParameter("login");
        String clave = request.getParameter("clave");

        Usuario objUsuario = opUsuario.validarLogin(login, clave);
        
        if (objUsuario != null) {
            //trayendo el resto de datos del tipoUsuario segun id
            int idTipo = objUsuario.getIdTipoUsuario();            
            Tipousuario objTipoUsuario = opTipoUsuario.getTipoPorId(idTipo);
            
            //similar para el resto de objetos
            respuesta.setAttribute("sLogin", login);
            respuesta.setAttribute("sTipoUsuario", idTipo);
            respuesta.setAttribute("sCargo", objTipoUsuario.getCargo());
            String nombres = "";
            String apellidos = "";
            String correo = "";
            if (objUsuario.getIdPaciente()!= null) {
                Paciente objPaciente=opPaciente.getPacientePorId(objUsuario.getIdPaciente());
                nombres = objPaciente.getNombre();
                apellidos = objPaciente.getApellidos();
                correo = objPaciente.getCorreo();
            } else if (objUsuario.getIdTrabajador()!= null) {
                Trabajador objTrabajador = opTrabajador.getTrabajadorPorId(objUsuario.getIdTrabajador());
                nombres = objTrabajador.getNombres();
                apellidos = objTrabajador.getApellidos();
                correo = objTrabajador.getCorreo();
            }
            if (!nombres.equals("")) {
                respuesta.setAttribute("sNombres", nombres);
                respuesta.setAttribute("sApellidos", apellidos);
                respuesta.setAttribute("sCorreo", correo);
            }
            switch (idTipo) {
                case 1:
                    response.sendRedirect("inicioTrabajador.jsp");
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    response.sendRedirect("inicioCliente.jsp");
                    break;
                default:
                    break;
            }

        } else {
            System.out.println("error de acceso al login");
            response.sendRedirect("login.jsp");
        }

    }

    private void cerrarSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession respuesta = request.getSession(true);
        //Cerrar sesion
        respuesta.invalidate();

        //Redirecciono a index.jsp
        response.sendRedirect("inicio.jsp");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
