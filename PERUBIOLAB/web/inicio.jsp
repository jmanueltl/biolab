<%-- 
    Document   : inicio
    Created on : 28-may-2016, 22:26:46
    Author     : jack
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="template/referencias.jsp" %>
        <%@include file="template/header.jsp" %>
      
    </head>

<body>
    
    
    <!-- welcome -->
    <div class="welcome">
        <div class="col-md-6 welcome-left">
            <img src="images/right2.png" class="img-responsive" alt="" />
            <div class="welcome-lefttop">	
                <h5>Funcionalidades con las que cuenta nuestro sistema</h5>
                <li><span>01.</span>Realizar la reserva de una cita </li>
                <li><span>02.</span>Iniciar sesion con la cuenta de cliente </li>
                <li><span>03.</span>Ver el estado en el que se encuentran tus citas</li>
                <li><span>04.</span>Ver los resultados de la cita</li>
                <!--<div class="button">
                    <a href="#" class="btn  btn-1c btn1 btn-1d">LEARN MORE</a>	
                </div> -->
            </div>
        </div>
        <div class="col-md-6 welcome-right">
            <h3>Bienvenido</h3>
            <h6>Este sitio te permitira obtener informacion de nosotros y nuestros servicios, ademas podras reservar una cita para tu atencion</h6>
            <p>Esta interfaz esta disponible para todo publico que desea saber de nuestra organizacion, las opciones que se muestren deshabilitados son aquellas que requiere que el cliente inicie una sesion y con ello acceder a la informacion de sus citas realizadas y resultados</p>
        </div>
        <div class="clearfix"> </div>

    </div>
    <!-- welcome -->
    <!-- hand -->
    <div class="hand">
        <div class="container">
            <a href="reservarCita.jsp" class="yes-active">
            <div class="col-md-3 flights">
                <i class="fligh"> </i>
                <h4>Reserve sus Citas</h4>
                <p>A traves de esta opcion usted puede llenar un formulario consignando sus datos para poder hacer la reserva de su cita a traves de nuestro sistema</p>
            </div>
            </a>
            <a href="" class="not-active">
            <div class="col-md-3 resturants">
                <i class="rest"> </i>
                <h4> Consulte sus Citas</h4>
                <p>Consulte el estado de sus citas para saber si la fecha solicitada ha sido aceptada o existen otros horarios disponibles para su atencion</p>
            </div>
            </a>
            <a href="" class="not-active">
            <div class="col-md-3 beech">
                <i class="beec"> </i>
                <h4>Resultados Online</h4>
                <p>Con esta opcion usted puede visualizar los resultados de su cita sin tener que acercarse a nuestras instalaciones</p>
            </div>
            </a>
            <a href="" class="not-active">
            <div class="col-md-3 cars">
                <i class="ca"> </i>
                <h4>Quejas o Sugerencias</h4>
                <p>Como una organizacion seria y responsable esperamos sus opiniones respecto a los servicios que les prestamos para poder mejorar la calidad de nuestra atencion.</p>
            </div>
            </a>
            <div class="clearfix"> </div>
        </div>
    </div>
    <!-- hand -->

    
            <!-- FlexSlider -->
            <script defer src="js/jquery.flexslider.js"></script>
            <script type="text/javascript">
                $(function () {
                    SyntaxHighlighter.all();
                });
                $(window).load(function () {
                    $('.flexslider').flexslider({
                        animation: "slide",
                        start: function (slider) {
                            $('body').removeClass('loading');
                        }
                    });
                });
            </script>
            <!-- FlexSlider -->

        </div>
    </div>
    <!-- midban-->
    <!-- footer -->
    <div class="footer">
        <div class="container">
            <p>unmsm@unmsm.edu.pe</p>
            
            <h3>FISI</h3>
        </div>
    </div>
    <!-- footer -->

</body>
</html>
