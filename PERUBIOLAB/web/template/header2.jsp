<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<t:if test="${sessionScope['sTipoUsuario']==null}">
    <% response.sendRedirect("inicio.jsp");%>
</t:if>
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
                    <li><a href="<%=request.getContextPath()%>/controlLogin?action=2" data-hover="Salir">Salir</a></li>
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