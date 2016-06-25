<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%-- En caso de que exista una sesion iniciada redirecciono a index.jsp. "NO tiene caso mostrar este formulario cuando hay una sesion iniciada --%>

<t:choose>
    <t:when test="${sessionScope['sTipoUsuario']==5}">
        <% response.sendRedirect("inicioCliente.jsp");
        %>
    </t:when>
    <t:when test="${sessionScope['sTipoUsuario']==null}">
        
    </t:when>
    <t:otherwise>
        <% response.sendRedirect("inicioTrabajador.jsp");
        %>
    </t:otherwise>
</t:choose>
    
<!-- header -->
    <div class="banner">
        <div class="callbacks_container">
            <ul class="rslides" id="slider">
                <li>
                    <img src="images/imagen1.jpg"  class="img-responsive" alt="">
                </li>
                <li>
                    <img src="images/imagen2.jpg" class="img-responsive" alt="">
                </li>
                <li>
                    <img src="images/imagen3.jpg" class="img-responsive" alt="">
                </li>
            </ul>
        </div>
        <div class="header">
            <div class="logo">
                <a href="index.html"><img src="images/logo2.jpg" class="img-responsive" alt="" /></a>
            </div>
            <div class="head-nav">
                <span class="menu"> </span>
                <ul class="cl-effect-16">
                    <li><a href="inicio.jsp" data-hover="Inicio">Inicio</a></li>
                    <li><a href="nosotros.jsp" data-hover="Nosotros">Nosotros</a></li>
                    <li><a href="servicios.jsp" data-hover="Servicios">Servicios</a></li>
                    <li><a href="contactenos.jsp" data-hover="Contactenos">Contactenos</a></li>
                    <li><a href="login.jsp" data-hover="Login">Login</a></li>
                    <div class="clearfix"> </div>
                </ul>
            </div>
            <div class="clearfix"> </div>
            <!-- script-for-nav -->
            <script>
                $("span.menu").click(function () {
                    $(".head-nav ul").slideToggle(300, function () {
                        // Animation complete.
                    });
                });
            </script>
            <!-- script-for-nav -->
        </div>
    </div>
    <!-- header -->