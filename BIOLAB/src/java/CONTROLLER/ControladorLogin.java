/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import DAO.PacienteDAO;
import DTO.Paciente;
import DTO.Usuario;
import DAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author yaliagap
 */
@WebServlet(name = "ControladorLogin", urlPatterns = {"/ControladorLogin"})
public class ControladorLogin extends HttpServlet {

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
        
        String accion = request.getParameter("action");
        switch(accion){
            case "INICIAR_SESION":
                iniciarSesionGeneral(request, response);
                break;         
                                    
        }        
    }
    
    private void iniciarSesionGeneral(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario= new Usuario();            
        usuario.setLogin(request.getParameter("login"));
        usuario.setClave(request.getParameter("clave"));        
        try{
            if(dao.validarUsuario(usuario)){        
               response.sendRedirect("pacienteLogueado.jsp");  
           }else{
                System.out.println("NO COMO USUARIO");
               response.sendRedirect("login.jsp");
           }
        }catch(Exception ex){
            System.out.println("ERROR : "+ex.getMessage());
        }
    }
    
    private void iniciarSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PacienteDAO dao = new PacienteDAO();
        Paciente p = new Paciente();            
        p.setCorreo(request.getParameter("usu"));
        p.setContrasenia(request.getParameter("contra"));        
        try{
            if(dao.validarPaciente(p)){
                                
                               
               response.sendRedirect("pacienteLogueado.jsp");
               
                
           }else{
                System.out.println("NO COMO USUARIO");
               response.sendRedirect("inicio.jsp");
           }
        }catch(Exception ex){
            System.out.println("ERROR : "+ex.getMessage());
        }
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
