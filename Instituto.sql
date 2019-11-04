
drop database instituto;
create database instituto;
USE instituto;

CREATE TABLE `profesores` (
  `idprofesor` int NOT NULL AUTO_INCREMENT,
  `dni` varchar(45) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idprofesor`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Table structure for table `modulos`
--

CREATE TABLE `modulos` (
  `idmodulo` int NOT NULL AUTO_INCREMENT,
  `idprofesor` int DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idmodulo`),
  KEY `fk_profesor_idx` (`idprofesor`),
  CONSTRAINT `fk_profesor` FOREIGN KEY (`idprofesor`) REFERENCES `profesores` (`idprofesor`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Table structure for table `alumnos`
--

CREATE TABLE `alumnos` (
  `idalumno` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idalumno`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Table structure for table `mod_alu`
--

CREATE TABLE `mod_alu` (
  `idmod_alu` int NOT NULL AUTO_INCREMENT,
  `idmodulo` int DEFAULT NULL,
  `idalumno` int DEFAULT NULL,
  PRIMARY KEY (`idmod_alu`),
  KEY `fk_modulo_idx` (`idmodulo`),
  KEY `fk_alumno_idx` (`idalumno`),
  CONSTRAINT `fk_alumno` FOREIGN KEY (`idalumno`) REFERENCES `alumnos` (`idalumno`) ON UPDATE CASCADE,
  CONSTRAINT `fk_modulo` FOREIGN KEY (`idmodulo`) REFERENCES `modulos` (`idmodulo`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;