<%-- 
    Document   : inicioTrabajador
    Created on : 13-jun-2016, 1:21:34
    Author     : jack
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenido Trabajador :3!!!</h1>
        <form method="POST" action="<%=request.getContextPath()%>/controlLogin?action=2">
        <input type="submit" value="Cerrar Sesion">
        </form>
    </body>
</html>
