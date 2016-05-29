<%-- 
    Document   : menuInicio
    Created on : 28-may-2016, 19:30:33
    Author     : jack
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="../resources/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="../resources/jquery/jquery-1.12.0.min.js" type="text/javascript"></script>
        <script src="../resources/bootstrap/bootstrap.min.js" type="text/javascript"></script>
        <link href="../resources/css/estilos.css" rel="stylesheet" type="text/css"/> 
    </head>
    <body>
        <div class="cabecera" >
            <div id="logo" class="col-md-6 col-sm-6  col-xs-6">
                <br><img src="<%=request.getContextPath()%>/img/logo2.jpg">
            </div>

            <div id="logindiv" > <br><br>
                <form action="<%=request.getContextPath()%>/ControladorLogin?action=INICIAR_SESION" id=""  method="post" >

                    <img src="<%=request.getContextPath()%>/img/user2.gif" width="70px"  height="70px">
                    <!-- campos de ususario -->

                    <input type="text"  name="usu" id="usu" maxlength="10" size="10px"  placeholder="Usuario">
                    <input type="password"  maxlength="10" size="10px"  name="contra" id="contra" placeholder="Contraseña">
                    <input   type="submit" class="btn-info"   value="Ingresar" onclick=""> 
                </form>
            </div>

        </div>
        <div class="menu1" id="horizontal">
       
          <ul>
            <li><a href="#"><br>Inicio</a></li>
            <li>

              <div class="dropdown">
                <a class="dropdown" class="btn btn-default dropdown-toggle" 
                id="menu1" data-toggle="dropdown"><br>¿Quiénes somos?
                <span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
                    <li role="presentation">
                      <a role="menuitem" tabindex="-1" href="#">Presentación</a>
                    </li>
                    <li role="presentation">
                      <a role="menuitem" tabindex="-1" href="#">Misión, Visión y Valores</a>
                    </li>
                    <li role="presentation">
                      <a role="menuitem" tabindex="-1" href="#">Políticas y Objetivos</a>
                    </li>
                </ul>
              </div>  

            </li> 
            <li><a href="#"><br>Ubicación</a></li> 
            <li><a href="#"><br>Servicios</a></li> 
            <li><a href="#"><br>Opción 5</a></li> 
            <li><a href="#"><br>Opción 6</a></li> 
          </ul>
      
  </div>

                    
    </body>
</html>
