<%-- 
    Document   : consultarCitas
    Created on : Jun 25, 2016, 1:13:27 AM
    Author     : yaliagap
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dto.Cita"%>
<%@page import="dao.Dao"%>

<%@page import="java.util.List"%>

<%  
    HttpSession respuesta = request.getSession(true);
    respuesta.getAttribute("sIdPersona");
    String mensaje = "";
    Dao dao = new Dao();
    ArrayList<Cita> citas = null;
    try{
        citas= dao.citasPaciente(Integer.parseInt(respuesta.getAttribute("sIdPersona").toString()));
    }catch(Exception e){
        e.printStackTrace();
        mensaje = "Error al listar citas: " + e.getMessage();
    }
    if(request.getParameter("mensaje")!=null){
        mensaje = request.getParameter("mensaje");
    }
%>
<!DOCTYPE html>
<html>
    <head>
    <head>
        <%@include file="template/referencias.jsp" %>
       

        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>


    </head>
    <body>
        <div class="container" style="text-align: center;"> 
            <br>
            <h2 style="color:#4D8BA9;">Historial de Citas </h2>
            <hr align="left" noshade="noshade"  width="750px">
        </div>
        <div id="consultas" class="container">
            <br><br>
            <div>
            <table class="table table-bordered">
            <thead>
                <tr>
                    
                    
                    <th class="info">DNI</th>
                    <th class="info">Nombres</th>
                    <th class="info">Apellidos</th>
                    
                    <th class="info">Fecha</th>
                    <th class="info">Hora</th>
                    <th class="info">Estado</th>                    
                </tr>
            </thead>
            <tbody>
                <%
                for(Cita c : citas){
                    
                %>
                <tr>
                    
                    <td><%= c.getP().getDni()%></td>
                    <td><%= c.getP().getNombre()%></td>
                    <td><%= c.getP().getApellidos()  %></td>
                    <td><%= c.getFecha() %></td>
                    <td><%= c.getHora() %></td>
                    <td><%=c.getEc().getEstado()%></td>
                </tr>
               <%
                }
               %>
                
            </tbody>
        </table>                

            </div>            
           
        </div>

      
        
        </div>

        



    </body>
</html>