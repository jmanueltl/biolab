//Desarrollado por Jesus Liñán
//ribosomatic.com
//Puedes hacer lo que quieras con el código
//pero visita la web cuando te acuerdes

function objetoAjax(){
	var xmlhttp=false;
	try {
		xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
	} catch (e) {
		try {
		   xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		} catch (E) {
			xmlhttp = false;
  		}
	}

	if (!xmlhttp && typeof XMLHttpRequest!='undefined') {
		xmlhttp = new XMLHttpRequest();
	}
	return xmlhttp;
}

function validarLogin(datos){
	var divResultado = document.getElementById('aviso');
	id_usuario=document.getElementById('id_usuario').value;
	var clave=document.getElementById('clave').value;
	
	datos=datos+ '? id_usu='+id_usuario+'& clav='+clave;
	var ajax=objetoAjax();
	ajax.open("GET", datos);
	ajax.onreadystatechange=function() {
		if (ajax.readyState==4) {
			divResultado.innerHTML = ajax.responseText;
			bandera=document.getElementById('flag').value;
			//alert(bandera);
			if(bandera=="si"){

				location.href = "vistaAdmin.php";
			
			}
			
		}
	}

	ajax.send(null);
}

function busquedaUsuario(datos,componente,opcion,datoBuscar){
	var divResultado = document.getElementById(componente);
	
	
	datos=datos+ '? opcion='+opcion+'& datoBuscar='+datoBuscar;
	var ajax=objetoAjax();
	ajax.open("GET", datos);
	ajax.onreadystatechange=function() {
		if (ajax.readyState==4) {
			divResultado.innerHTML = ajax.responseText;
			
		}
	}

	ajax.send(null);
}

function obtenerDatos(datos,componente){
	var divResultado = document.getElementById(componente);
	//id_usuario="ADM01";	
	//datos=datos+ '? id_usu='+id_usuario;
	var ajax=objetoAjax();
	ajax.open("GET", datos);
	ajax.onreadystatechange=function() {
		if (ajax.readyState==4) {
			divResultado.innerHTML = ajax.responseText;			
		}
	}

	ajax.send(null);
}
function obtenerDatos(datos,componente,variable){
	var divResultado = document.getElementById(componente);
	//id_usuario="ADM01";	
	//datos=datos+ '? id_usu='+id_usuario;
	datos=datos+ '? variable='+variable;
	var ajax=objetoAjax();
	ajax.open("GET", datos);
	ajax.onreadystatechange=function() {
		if (ajax.readyState==4) {
			divResultado.innerHTML = ajax.responseText;			
		}
	}

	ajax.send(null);
}

