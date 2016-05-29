<%-- 
    Document   : reservarCita
    Created on : 29/05/2016, 04:06:35 AM
    Author     : Anthony
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/css/estilos.css" rel="stylesheet" type="text/css"/>
        <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="resources/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <script language="JavaScript" type="text/javascript" src="ajax.js"></script>
        <title>Laboratorio BIOLAB</title>>
    </head>
    
    <%-- <script type="text/javascript">
    //para que se ejectuten las funciones de INICIO al cargar las paginas
    window.addEventListener('load',inicio,false);
    function inicio()
    { 
      //obtiene los datos de los examenes disponibles, se mantiene  oculto hasta presionar el boton
      obtenerDatos("reservar/mostrarExamen.php","tablaExam");
    }
    var contador=0;
    var opciones=[];
    
    //esta funcion se encarga de la seleeciony deseleccion de un examen al hacerle click a toda la fila, ingresa los examenes seleccionados en el arreglo opciones
    function seleccion(val){
     var tabla = document.getElementById('tablaExamen');
     fila = tabla.rows[val].getElementsByTagName('td');
     celda1=fila[0].innerHTML;//id_modulo
     celda2=fila[1].innerHTML;//nombre
     
     
     flag=false;
       for(f=0;f<=contador;f++){
          if(opciones[f] == celda2){
            flag=true;
            indice=f;
            break;
          }
       }
     if(flag){
      document.getElementById(celda2).checked=false;
      delete opciones[indice];
     }else{
        document.getElementById(celda2).checked=true;

        opciones[contador]=celda2;
        contador++;
     }
    
 }
//Se encarga de mostrar los examenes que seleccionaste si vuelves a apretar el boton ver examenes.
    function mostrarExamen(){    
      var div=document.getElementById("listaExamen");
      div.hidden=false;
      for(f=0;f<opciones.length;f++){
        if(opciones[f]!=undefined)
         document.getElementById(opciones[f]).checked=true;
        }
	   document.getElementById("aviso").hidden = true;
	   document.getElementById("selectExam").hidden = true;
    }
    
//Permite visualizar en el textarea los examenes que escogiste
    function aceptar(){
      document.getElementById("eleccion").value="Examenes Elegidos: \n -------------------------------";
      for(f=0;f<opciones.length;f++){
        if(opciones[f]!=undefined)
        document.getElementById("eleccion").value=document.getElementById("eleccion").value+"\n"+opciones[f];
      }
      //esta parte convierte el arreglo a string  para agregarlo a un campo de texto y sea enviado al archivo php atraves del metodo submit del formulario
      arr  = opciones.toString();
      document.getElementById("arreglo").value=""+arr;  

      var div=document.getElementById("listaExamen");
      div.hidden=true;  
	  document.getElementById("aviso").hidden = false;
	   document.getElementById("selectExam").hidden = false;	
    }
     
    function cancelar(){
      var div=document.getElementById("listaExamen");
      div.hidden=true;
	  document.getElementById("aviso").hidden = false;
	   document.getElementById("selectExam").hidden = false;
    }
    
</script>
--%>
    <body>
        <div class="line">
        </div>
        <div class="cabecera" >
              <div id="logo" class="" style="position:relative;left:140px;">
                <br><img src="/BIOLAB/resources/images/logo3.jpg" >
              </div>

              <div id="logindiv" style="position:absolute;left:70%;"> <br><br>
              <form action="cliente/clienteAcceso.php" class="form-horizontal" id=""  method="post" enctype="multipart/form-data">

                <img src="/BIOLAB/resources/images/user2.gif" width="70px"  height="70px">
                <!-- campos de ususario -->

                <input type="text"  name="usu" id="usu" maxlength="10" size="10px"  placeholder="Usuario">
                <input type="password"  maxlength="10" size="10px"  name="contra" id="contra" placeholder="Contraseña">
                <input   type="submit" class="btn-info"   value="Ingresar" onclick=""> 
              </form>
              </div>

        </div>
        
        <div class="menu1" id="horizontal">
       
          <ul>
            <li><a href="cliente.html"><br>Inicio</a></li>
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
        
        <br><br><br>
  <div class="col-sm-offset-4 "> 
      <h2 style="color:#4D8BA9;">Formulario de Reserva </h2>
      <hr align="left" noshade="noshade"  width="750px">
  </div>
   <div id="reserva" class="col-sm-offset-4 container" >

          <br><br>
          <div >
            <form action="reservar/reservarCita.php" class="form-horizontal" id="registrocita"  method="post" enctype="multipart/form-data">

              Nombre: <span class="superindice">*</span><br>
              <input class="input" name="nombre" type="text" ><br><br>
              
              Apellidos: <span class="superindice">*</span><br>
              <input class="input" name="apellidos" type="text" ><br><br>

              DNI: <span class="superindice">*</span><br>
              <input class="input" name="dni" type="text" ><br><br>

              Edad:<br>
              <input class="input" name="edad" type="text"><br><br>
              
              Telf/Movil: <span class="superindice">*</span><br>
              <input class="input" name="telefono" type="text" ><br><br>

              Correo: <span class="superindice">*</span><br>
              <input class="input" name="correo" type="text" ><br><br>

              Sexo: <span class="superindice">*</span><br>
               <span style="position:relative;left:20%;"> <input type="radio" name="sexo" value="hombre" >Hombre </span>
               <span style="position:relative;left:30%;"> <input type="radio" name="sexo" value="mujer" >Mujer</span>
               <br><br>

              Examenes: <span class="superindice">*</span><br>
              <input id="verExamen" type="button" onclick='mostrarExamen()' value="Ver Lista">
              <br>
         
              Fecha: <span class="superindice">*</span> <br>

              <input  name="fecha" class="input-date" type="date" ><br>
         
              <div style="position:relative;left:250px;top:-45px;">Hora: <span class="superindice">*</span><br>   
                  <input  name="hora" class="input-date" type="time" >
              </div>
              
              <!-- Para pasar el arreglo que no se me funciona de otra manera :s    -->
              <div hidden="true" >
                  <input  id="arreglo" name="arreglo"  type="text" >
              </div>

              <div >
              <!--<button class=" btn btn-primary btn-lg" name="resgistra_cita">Registrar</button> -->
              <input type="submit" class="boton" style="background:#4D8BA9; color:rgb(255,255,255);"value="Reservar">
              </div>
             <br>

            <div id="listaExamen" style="position:relative;left:-50px;top:-450px;" hidden>
                  <div id="tablaExam" >
                  </div>
                  <div>
                  <input style="background:#4D8BA9; color:rgb(255,255,255);position:relative;left:160px;" onclick="aceptar()" class="boton" type="button" value="aceptar">
                  <input style="background:#4D8BA9; color:rgb(255,255,255);position:relative;left:180px;" onclick="cancelar()" class="boton" type="button" value="cancelar">
                  </div>
            </div>
           
            <div id="selectExam">
                  <textarea id="eleccion" rows="10" cols="25" style="position:relative;left:400px;" readonly="true">Examenes Elegidos:</textarea>
            </div>
            
            </form>

          </div>
          <div class="aviso" id="aviso">
              <table class="table table-bordered table-striped" >
                <thead> 
                 <tr> 
                   <th>Nota</th>
                 </tr> 
               </thead>
               <tbody>
                 <tr> 
                 <td>(*) Todos los campos deben<br>
                   de ser llenados obligatoriamente.</td>
                 </tr>
                 <tr> 
                 <td>
                  Debe esperar la confimarción <br>
                   de su reserva de cita para la<br>
                   atención respectiva.</td>
                 </tr>
                 <tr> 
                 <td>
                  El tiempo mínimo para realizar<br>
                   la reserva es de 48 horas de<br>
                   anticipación.</td>
                 </tr>
               </tbody>
             </table>
            </div> 

            
      </div>
    </body>
</html>
