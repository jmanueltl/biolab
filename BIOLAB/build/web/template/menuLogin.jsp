<%-- 
    Document   : menuLogin
    Created on : 28-may-2016, 19:32:34
    Author     : jack
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="cabecera.jsp" %>
    </head>
    <div class="cabecera" >
        <div id="logo" class="" style="position:relative;left:140px;">
            <br><img src="<%=request.getContextPath()%>/img/logo2.jpg">
        </div>
        <div id="logindiv"><br><br><br>
            <form  class="form-horizontal" id="" enctype="multipart/form-data">

                <img src="<%=request.getContextPath()%>/img/user2.gif" width="70px" style="position:relative;left:180px;" height="70px">
                <!-- campos de ususario -->

                <?php
                echo '<input type="text" style="position:relative;left:180px;" readonly="true" id="usuario" value='.$_SESSION['nombre']." ".$_SESSION['apellido'].'>';
                ?>


                <label id=' '></label>
                <a href="../cliente.html"><input type="button" class="btn-info"  style="position:relative;left:180px;" value="Cerrar Sesion"></a>
            </form>
        </div>

    </div>
</html>
