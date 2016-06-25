/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.Dao;
import dto.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jack
 */
@WebServlet(name = "controlLogin", urlPatterns = {"/controlLogin"})
public class controlLogin extends HttpServlet {

    Dao dao = new Dao();
    Usuario usu = new Usuario();

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

        String login = request.getParameter("login");
        String clave = request.getParameter("clave");
        usu.setUsuario(login);
        usu.setPassword(clave);
        int exito = dao.validar_Usuario(login, clave);
        //System.out.println("valor: "+exito);
        switch (exito) {
            case 0:
                System.out.println("Usuario no registrado");
                response.sendRedirect("login.jsp");
                break;
            case 1:
                
                dao.datosUsuario(usu);
                respuesta.setAttribute("sLogin", login);
                respuesta.setAttribute("sTipoUsuario",usu.getIdTipoUsuario());
                System.out.println("valores: ");
                System.out.println(usu.getNombres() + "\n" + usu.getApellidos());
                
                switch (usu.getPerfil()) {
                    case "administrador":
                        System.out.println("entro admin");
                        response.sendRedirect("inicioTrabajador.jsp");
                        break;
                    case "secretaria":
                        break;
                    case "tecnico":
                        break;
                    case "tecnologo":
                        break;
                    case "cliente":
                        System.out.println("entro cliente");
                        response.sendRedirect("inicioCliente.jsp");
                        System.out.println("ccccliente");
                        break;
                    default:
                        break;
                }
                break;
            case 2:
                System.out.println("Contrasenia incorrecta");
                response.sendRedirect("login.jsp");
                break;
            default:
                break;
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
