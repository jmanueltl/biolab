<%-- 
    Document   : reservarCita
    Created on : 29/05/2016, 04:06:35 AM
    Author     : Anthony
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <head>
        <%@include file="template/referencias.jsp" %>
        <%@include file="template/header.jsp" %>

        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>


    </head>
    <body>
        <div class="col-sm-offset-4 "> 
            <h2 style="color:#4D8BA9;">Formulario de Reserva </h2>
            <hr align="left" noshade="noshade"  width="750px">
        </div>
        <div id="reserva" class="col-sm-offset-4 container" >

            <br><br>
            <div >
                <form action="<%=request.getContextPath()%>/controlCita?action=1" class="form-horizontal" id="registrocita"  method="POST">

                    Nombre: <span class="superindice">*</span><br>
                    <input class="input" name="nombre" type="text" required ><br><br>

                    Apellidos: <span class="superindice">*</span><br>
                    <input class="input" name="apellidos" type="text" required><br><br>

                    DNI: <span class="superindice">*</span><br>
                    <input class="input" name="dni" type="text"  required><br><br>

                    Edad:<br>
                    <input class="input" name="edad" type="text" required><br><br>

                    Telf/Movil: <span class="superindice">*</span><br>
                    <input class="input" name="telefono" type="text" required><br><br>

                    Correo: <span class="superindice">*</span><br>
                    <input class="input" name="correo" type="email" required><br><br>

                    Sexo: <span class="superindice">*</span><br>
                    <span style="position:relative;left:20%;"> <input type="radio" name="sexo" value="hombre" >Hombre </span>
                    <span style="position:relative;left:30%;"> <input type="radio" name="sexo" value="mujer" >Mujer</span>
                    <br><br>

                    Examenes: <span class="superindice">*</span><br>
                    
                    <select name="tipoExamen" size="4" multiple="multiple" required>
                        <option value="3">Bioquimico</option>
                        <option value="2">Coagulacion</option>
                        <option value="1">Hematologico</option>
                        <option value="4">Orina</option>                       
                    </select><br><br>
                    

                    <br>

                    Fecha: <span class="superindice">*</span> <br>

                    <input  name="fecha" class="input-date" type="date" required><br>

                    <div style="position:relative;left:250px;top:-45px;">Hora: <span class="superindice">*</span><br>   
                        <input  name="hora" class="input-date" type="time" required>
                    </div>

                   

                    <div >
                        <!--<button class=" btn btn-primary btn-lg" name="resgistra_cita">Registrar</button> -->
                        <input type="submit" class="boton" style="background:#4D8BA9; color:rgb(255,255,255);"value="Reservar">
                    </div>
                    <br>

                   
                </form>

            </div>
            <div class="aviso" id="aviso">
                <table class="table table-bordered table-striped" >
                    <thead><tr><th>Nota</th></tr> 
                    </thead>
                    <tbody>
                        <tr><td>(*) Todos los campos deben<br>
                                de ser llenados obligatoriamente.</td></tr>
                        <tr><td>Debe esperar la confimarción <br>
                                de su reserva de cita para la<br>
                                atención respectiva.</td></tr>
                        <tr><td>El tiempo mínimo para realizar<br>
                                la reserva es de 48 horas de<br>
                                anticipación.</td></tr>
                    </tbody>
                </table>
            </div> 
        </div>

      
        
        </div>

        



    </body>
</html>
