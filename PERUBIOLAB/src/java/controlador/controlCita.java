/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import dao.Dao;
import dto.Cita;
import dto.Detallecita;
import dto.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author jack
 */
@WebServlet(name = "controlCita", urlPatterns = {"/controlCita"})
public class controlCita extends HttpServlet {
    Dao dao = new Dao();
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
                reservarCita(request, response);
                break;

        }
    }
    // exito = 0 --> no exitoso   /// exito = 1 --> exitoso
    private void mensaje(HttpServletResponse response, int exito) throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<script type=\"text/javascript\">");
        if(exito==0)
            out.println("alert('Reserva de cita no exitosa');");
        else
            out.println("alert('Reserva de cita exitosa');");   
        
        out.println("</script>");
    }
    private Date castStringDate(String dateString){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
        Date date=null;
	try {
                System.out.println("resultado funcion");
                date = formatter.parse(dateString);
		System.out.println(date);
                System.out.println(date);
		System.out.println(formatter.format(date));

	} catch (ParseException e) {
		e.printStackTrace();
	}
        return date;
    }
    private void reservarCita(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombres = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String dni =request.getParameter("dni");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        String sexo = request.getParameter("sexo");
        String[] tipoExamen = request.getParameterValues("tipoExamen");
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");
        String fechahora= fecha+" "+hora;
        System.out.println(fechahora);
        //Date dfechahora=castStringDate(fechahora);
        int existe_paciente=0;
        Persona paciente= new Persona();
        Cita cita= new Cita();
        Detallecita dc= new Detallecita();
        System.out.println("dni: "+dni);
        
        //registrar al paciente
        paciente.setDni(dni);
        dao.datosPaciente(paciente);
        if(paciente.getNombre()==null){
            paciente.setDni(dni);
            paciente.setNombre(nombres);
            paciente.setApellidos(apellidos);
            paciente.setSexo(sexo);
            paciente.setTelefono(telefono);
            paciente.setCorreo(correo);
            
            dao.registrarPersona(paciente);
            paciente.setIdPaciente(dao.existePaciente(dni));
        }
        System.out.println("id paciente: "+paciente.getIdPaciente());
        
        //registrar la cita
        cita.setFechaHora(fechahora);
        cita.setIdEstadoCita(1);
        cita.setIdPaciente(paciente.getIdPaciente());
        
        dao.agregarCita(cita);
        cita.setIdCita(dao.ultimaCita());
        System.out.println("id cita: "+cita.getIdCita());
        
        //agregar detalle cita
        for(int i =0 ; i<tipoExamen.length;i++){
                dc.setIdCita(cita.getIdCita());
                dc.setIdExamen(Integer.parseInt(tipoExamen[i]));
                dao.agregarDetalleCita(dc);
            }
        
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
