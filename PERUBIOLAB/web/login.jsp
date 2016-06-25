

<%-- 
    Document   : login
    Created on : 28-may-2016, 19:15:48
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<%=request.getContextPath()%>/css/estilos2.css" rel="stylesheet" type="text/css"/>
        <link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Laboratorio BIOLAB</title>
    </head>
    <body>        
        <div>                
                <img src="<%=request.getContextPath()%>/images/logo3.jpg" />
        </div>
        <div>
                <img src="<%=request.getContextPath()%>/images/imagen1.jpg" width="100%" height="100%"/>
        </div>
        <div class="form1" >
            <form id="form" method="post" action="<%=request.getContextPath()%>/controlLogin?action=1" /> 
                <div>
                    <img src="<%=request.getContextPath()%>/images/Login.png" width="20%" height="20%"/>
                <br/>
                </div>                               
                <center>
                    <input  type="text" id="txtUsuario"  value="" required="true" placeholder="Usuario" name="login"/>     
                    <br/><br/><br/>
                    <input  type="password" id="txtClave" value="" required="true" placeholder="Password" name="clave" />
                    
                    <br/><br/><br/>        
                    <input type="submit" class="btn btn-primary" value="Inciar Sesion" /> 
                    &nbsp;&nbsp;&nbsp;<a href="inicio.jsp">Regresar</a>
                </center>    
                
            </form>
        </div>
    </body>
</html>
