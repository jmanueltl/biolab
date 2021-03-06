/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.operacionCita;
import dao.operacionDetalleCita;
import dao.operacionPaciente;
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
import modelo.Cita;
import modelo.Detallecita;
import modelo.Paciente;

/**
 *
 * @author jack
 */
@WebServlet(name = "controlCita", urlPatterns = {"/controlCita"})
public class controlCita extends HttpServlet {

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
        int dni = Integer.parseInt(request.getParameter("dni"));
        int edad = Integer.parseInt(request.getParameter("edad"));
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        String sexo = request.getParameter("sexo");
        String[] tipoExamen = request.getParameterValues("tipoExamen");
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");
        String fechahora= fecha+" "+hora;
        System.out.println(fechahora);
        Date dfechahora=castStringDate(fechahora);
        operacionPaciente opPaciente = new operacionPaciente();
        operacionCita opCita = new operacionCita();
        operacionDetalleCita opDetalleCita = new operacionDetalleCita();
        Cita objCita = new Cita();
        Detallecita objDetalleCita  = new Detallecita();
        System.out.println("dni: "+dni);
        //validando si ya exitste paciente en la BD
        Paciente objPaciente=opPaciente.getPacientePorDni(dni);
        //agregar paciente
        if(objPaciente== null){
            //paciente nuevo se registra
            objPaciente= new Paciente();
            objPaciente.setDni(dni);
            objPaciente.setNombre(nombres);
            objPaciente.setApellidos(apellidos);
            objPaciente.setSexo(sexo);
            objPaciente.setCorreo(correo);
            objPaciente.setTelefono(telefono);
            //agregar paciente
            opPaciente.agregarPaciente(objPaciente);
            //obteniendo datos del paciente agregado
            objPaciente=opPaciente.getPacientePorDni(dni);
        }
        

//mensaje(response,1);
        //agregar cita
        objCita.setFechaHora(dfechahora);
        objCita.setIdEstadoCita(1);
        objCita.setIdPaciente(objPaciente.getIdPaciente());
        opCita.agregarCita(objCita);
        System.out.println("objeto resultado");
        System.out.println(objCita.getFechaHora());
        //obteniendo datos de la cita agregada
        objCita= opCita.getUltimaCita();
        System.out.println("id cita: "+objCita.getIdCita());
        
        //agregar detalleCita
         System.out.println("examenes: ");
        for(int i =0 ; i<tipoExamen.length;i++){
                objDetalleCita.setIdCita(objCita.getIdCita());
                objDetalleCita.setIdExamen(Integer.parseInt(tipoExamen[i]));
                System.out.println(tipoExamen[i]);
                opDetalleCita.agregarDetalleCita(objDetalleCita);
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
