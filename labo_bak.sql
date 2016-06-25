/*
SQLyog Community v11.31 (32 bit)
MySQL - 10.1.9-MariaDB : Database - laboratorio
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`laboratorio` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `laboratorio`;

/*Table structure for table `cita` */

DROP TABLE IF EXISTS `cita`;

CREATE TABLE `cita` (
  `idCita` int(11) NOT NULL AUTO_INCREMENT,
  `fechaHora` datetime DEFAULT NULL,
  `idEstadoCita` int(11) DEFAULT NULL,
  `idTecnico` int(11) DEFAULT NULL,
  `idTecnologo` int(11) DEFAULT NULL,
  `idPaciente` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCita`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `cita` */

insert  into `cita`(`idCita`,`fechaHora`,`idEstadoCita`,`idTecnico`,`idTecnologo`,`idPaciente`) values (1,'2016-06-15 01:02:00',1,NULL,NULL,3),(2,'2016-07-01 01:02:00',1,NULL,NULL,3);

/*Table structure for table `detallecita` */

DROP TABLE IF EXISTS `detallecita`;

CREATE TABLE `detallecita` (
  `idDetalleCita` int(11) NOT NULL AUTO_INCREMENT,
  `idCita` int(11) DEFAULT NULL,
  `idExamen` int(11) DEFAULT NULL,
  `idResultado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idDetalleCita`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `detallecita` */

insert  into `detallecita`(`idDetalleCita`,`idCita`,`idExamen`,`idResultado`) values (1,2,2,NULL),(2,2,1,NULL);

/*Table structure for table `estadocita` */

DROP TABLE IF EXISTS `estadocita`;

CREATE TABLE `estadocita` (
  `idEstadoCita` int(11) NOT NULL AUTO_INCREMENT,
  `estado` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idEstadoCita`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `estadocita` */

insert  into `estadocita`(`idEstadoCita`,`estado`) values (1,'espera');

/*Table structure for table `examen` */

DROP TABLE IF EXISTS `examen`;

CREATE TABLE `examen` (
  `idExamen` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `rangoMin` varchar(45) DEFAULT NULL,
  `rangoMax` varchar(45) DEFAULT NULL,
  `unidad` varchar(45) DEFAULT NULL,
  `idTipoExamen` int(11) DEFAULT NULL,
  PRIMARY KEY (`idExamen`)
) ENGINE=InnoDB AUTO_INCREMENT=422 DEFAULT CHARSET=latin1;

/*Data for the table `examen` */

insert  into `examen`(`idExamen`,`nombre`,`rangoMin`,`rangoMax`,`unidad`,`idTipoExamen`) values (101,'Leucocitos','4','11','1/mm^3',1),(102,'Hematies','3.8','4.8','1/mm^3',1),(103,'Plaquetas','150','450','1/mm^3',1),(104,'Hemoglobina','12','15','g/dL',1),(105,'Hematrocito','36','45','%',1),(106,'VCM','80','97','fL',1),(107,'HCM','26','33','pg',1),(108,'CCMH','32.3','35.2','g/dL',1),(201,'Tiempo de Coagulacion','5','15','min',2),(202,'Tiempo de protombina','11','13','seg',2),(301,'Urea','10','50','mg/dL',3),(302,'Creatina','0.7','1.2','mg/dL',3),(303,'Glucosa','74','106','mg/dL',3),(304,'Colesterol','0','200','mg/dL',3),(305,'HDL','40','60','mg/dL',3),(306,'LDL','0','130','mg/dL',3),(307,'VLDL','10','60','mg/dL',3),(308,'Trigliceridos','0','200','mg/dL',3),(401,'Color','','','',4),(402,'Aspecto','','','',4),(403,'Densidad','1.001','1.035',NULL,4),(404,'PH','5','8',NULL,4),(405,'Glucosa',NULL,NULL,NULL,4),(406,'Bilirrubina',NULL,NULL,NULL,4),(407,'Cuerpos cetonicos',NULL,NULL,NULL,4),(408,'Lucocitos',NULL,NULL,NULL,4),(409,'Proteinas',NULL,NULL,NULL,4),(410,'Urobilinogeno',NULL,NULL,NULL,4),(411,'Nitritos',NULL,NULL,NULL,4),(412,'Hemoglobina',NULL,NULL,NULL,4),(413,'Leucocitos',NULL,NULL,NULL,4),(414,'Hematies',NULL,NULL,NULL,4),(415,'Celulas Epiteliales',NULL,NULL,NULL,4),(416,'Levaduras',NULL,NULL,NULL,4),(417,'Cilindros',NULL,NULL,NULL,4),(418,'Cristales',NULL,NULL,NULL,4),(419,'Filamento Mucoides',NULL,NULL,NULL,4),(420,'Parasitos',NULL,NULL,NULL,4),(421,'Germenes',NULL,NULL,NULL,4);

/*Table structure for table `muestra` */

DROP TABLE IF EXISTS `muestra`;

CREATE TABLE `muestra` (
  `idMuestra` int(11) NOT NULL AUTO_INCREMENT,
  `idCita` int(11) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idMuestra`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `muestra` */

/*Table structure for table `persona` */

DROP TABLE IF EXISTS `persona`;

CREATE TABLE `persona` (
  `idPersona` int(11) NOT NULL AUTO_INCREMENT,
  `dni` varchar(45) DEFAULT NULL,
  `nombres` varchar(45) DEFAULT NULL,
  `apellidos` varchar(45) DEFAULT NULL,
  `sexo` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idPersona`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `persona` */

insert  into `persona`(`idPersona`,`dni`,`nombres`,`apellidos`,`sexo`,`telefono`,`correo`) values (1,'76358935','jack','naquib','hombre','4520015','jackechevarria@gmail.com'),(2,'76358936','yersy','aliaga','hombre','4520016','yersyaliaga@gmail.com'),(3,'76358937','maria','lara','mujer','4520017','mariaLara@gmail.com'),(4,'76358938','josefina','ramirez',NULL,NULL,'josefina@hotmail.com'),(5,'76358990','antony','villacorta','hombre','4520017','antonyvilla@gmail.com'),(6,'76358991','aldo','chavez','hombre','4520018','aldochavez@gmail.com'),(7,'76358935','jack','naquib','hombre','4520015','jacknaquib@gmail.com');

/*Table structure for table `resultado` */

DROP TABLE IF EXISTS `resultado`;

CREATE TABLE `resultado` (
  `idResultado` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime DEFAULT NULL,
  `valor` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idResultado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `resultado` */

/*Table structure for table `tipoexamen` */

DROP TABLE IF EXISTS `tipoexamen`;

CREATE TABLE `tipoexamen` (
  `idTipoExamen` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `colorTubo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTipoExamen`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `tipoexamen` */

insert  into `tipoexamen`(`idTipoExamen`,`nombre`,`colorTubo`) values (1,'Hematologico',''),(2,'Coagulacion',''),(3,'Bioquimico',''),(4,'Orina','');

/*Table structure for table `tipousuario` */

DROP TABLE IF EXISTS `tipousuario`;

CREATE TABLE `tipousuario` (
  `idTipoUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `perfil` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTipoUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `tipousuario` */

insert  into `tipousuario`(`idTipoUsuario`,`perfil`) values (1,'administrador'),(2,'secretaria'),(3,'tecnico'),(4,'tecnologo'),(5,'cliente');

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) DEFAULT NULL,
  `clave` varchar(45) DEFAULT NULL,
  `idTipoUsuario` int(11) DEFAULT NULL,
  `idPersona` int(11) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `usuario` */

insert  into `usuario`(`idUsuario`,`login`,`clave`,`idTipoUsuario`,`idPersona`) values (2,'admin','admin',1,1),(3,'secre','secre',2,2),(4,'tecni','tecni',3,3),(5,'tecno','tecno',4,4),(6,'usu1','usu1',5,5),(7,'usu2','usu2',5,6);

/* Procedure structure for procedure `datos_usuario` */

/*!50003 DROP PROCEDURE IF EXISTS  `datos_usuario` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `datos_usuario`(IN nombre VARCHAR(30))
BEGIN
	SELECT u.idUsuario,tu.perfil,p.*,tu.idTipoUsuario FROM usuario u
	LEFT JOIN persona p ON u.idPersona=p.idPersona 
	LEFT JOIN tipoUsuario tu ON tu.idTipoUsuario = u.idTipoUsuario
	WHERE u.login = nombre;
    
END */$$
DELIMITER ;

/* Procedure structure for procedure `login_usuario` */

/*!50003 DROP PROCEDURE IF EXISTS  `login_usuario` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `login_usuario`(IN nombre varchar(30), 
				IN passw CHAR(30),
				OUT existe INT)
BEGIN
	SET existe=0;
	SELECT 
    case when STRCMP(login,nombre)=0 and STRCMP(clave,passw)=0 then 1
		when STRCMP(login,nombre)=0 and STRCMP(clave,passw)=1 then 2 end as user
    into existe 
	FROM usuario
	WHERE STRCMP(login,nombre)=0;
    
END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
