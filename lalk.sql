-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.1.19-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win32
-- HeidiSQL Versión:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para lalk
CREATE DATABASE IF NOT EXISTS `lalk` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `lalk`;


-- Volcando estructura para tabla lalk.alquileres
CREATE TABLE IF NOT EXISTS `alquileres` (
  `idAlquiler` int(5) NOT NULL AUTO_INCREMENT,
  `idArrendatario` int(5) DEFAULT NULL,
  `idInmueble` int(5) NOT NULL,
  `fechaEgreso` varchar(50) NOT NULL,
  `precioAlquiler` double NOT NULL,
  `plazoContractual` int(3) NOT NULL,
  `garantia1` varchar(50) NOT NULL,
  `garantia2` varchar(50) DEFAULT NULL,
  `nombreFia` varchar(50) DEFAULT NULL,
  `telFia` int(20) DEFAULT NULL,
  `emailFia` varchar(50) DEFAULT NULL,
  `detalleFia` text,
  `detalleGar` text,
  `detalleAlq` text,
  `tipoMoneda` int(10) NOT NULL,
  PRIMARY KEY (`idAlquiler`),
  KEY `idArrendatario` (`idArrendatario`),
  KEY `idInmueble` (`idInmueble`),
  KEY `FK_alquileres_monedalista` (`tipoMoneda`),
  CONSTRAINT `FK_alquileres_inmueble2` FOREIGN KEY (`idInmueble`) REFERENCES `inmueble2` (`refInmueble`),
  CONSTRAINT `FK_alquileres_monedalista` FOREIGN KEY (`tipoMoneda`) REFERENCES `monedalista` (`idMonLista`),
  CONSTRAINT `alquileres_ibfk_1` FOREIGN KEY (`idArrendatario`) REFERENCES `arrendatarios` (`idArrendatario`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla lalk.alquileres: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `alquileres` DISABLE KEYS */;
/*!40000 ALTER TABLE `alquileres` ENABLE KEYS */;


-- Volcando estructura para tabla lalk.apartamentos
CREATE TABLE IF NOT EXISTS `apartamentos` (
  `idApartamento` int(5) NOT NULL AUTO_INCREMENT,
  `idInmueble` int(5) NOT NULL,
  `unidad` int(2) DEFAULT NULL,
  `ubicarEdificio` varchar(50) NOT NULL,
  `ubicarPlanta` varchar(50) NOT NULL,
  `habitacionSocial` varchar(50) NOT NULL,
  `cocina` varchar(50) NOT NULL,
  `monoambiente` varchar(50) DEFAULT NULL,
  `unAmbiente` varchar(50) DEFAULT NULL,
  `dorm` int(2) NOT NULL,
  `dormConSuite` varchar(50) DEFAULT NULL,
  `dormConVestidor` varchar(50) DEFAULT NULL,
  `baños` int(2) NOT NULL,
  `bañoSocial` varchar(50) DEFAULT NULL,
  `bañoServicio` varchar(50) DEFAULT NULL,
  `bañoJacuzzi` varchar(50) DEFAULT NULL,
  `balcon` varchar(50) DEFAULT NULL,
  `terrazaPrincipal` varchar(50) DEFAULT NULL,
  `terrazaLavadero` varchar(50) DEFAULT NULL,
  `garaje` varchar(50) DEFAULT NULL,
  `cochAbierta` varchar(50) DEFAULT NULL,
  `cochTechada` varchar(50) DEFAULT NULL,
  `amenities` text,
  `gastosComunes` int(10) NOT NULL,
  `areaEdificada` double NOT NULL,
  `detalleApto` text,
  `rutaImagenApto` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idApartamento`),
  KEY `idInmueble` (`idInmueble`),
  CONSTRAINT `apartamentos_ibfk_1` FOREIGN KEY (`idInmueble`) REFERENCES `inmueble2` (`refInmueble`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla lalk.apartamentos: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `apartamentos` DISABLE KEYS */;
/*!40000 ALTER TABLE `apartamentos` ENABLE KEYS */;


-- Volcando estructura para tabla lalk.arrendatarios
CREATE TABLE IF NOT EXISTS `arrendatarios` (
  `idArrendatario` int(5) NOT NULL AUTO_INCREMENT,
  `idPersona` int(5) NOT NULL,
  `detalleArr` varchar(350) DEFAULT NULL,
  PRIMARY KEY (`idArrendatario`),
  KEY `idPersona` (`idPersona`),
  CONSTRAINT `arrendatarios_ibfk_1` FOREIGN KEY (`idPersona`) REFERENCES `personas` (`idPersona`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla lalk.arrendatarios: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `arrendatarios` DISABLE KEYS */;
INSERT INTO `arrendatarios` (`idArrendatario`, `idPersona`, `detalleArr`) VALUES
	(1, 1, 'alquila pero compra en dos a¤os'),
	(2, 2, 'alquila porque alquil¢ su propiedad'),
	(3, 3, 'sustiuir  garant¡a'),
	(4, 4, 'deposito bhu cinco meses'),
	(5, 5, 'alquila local tambi‚n'),
	(6, 6, 'tiene propiedad en arrendamiento por eso alquila'),
	(7, 7, 'alquila pero compra en dos a¤os'),
	(8, 8, 'alquila porque alquil¢ su propiedad'),
	(9, 9, 'sustiuir  garant¡a'),
	(10, 10, 'deposito bhu cinco meses'),
	(11, 11, 'alquila local tambi‚n'),
	(12, 12, 'tiene propiedad en arrendamiento por eso alquila'),
	(13, 13, 'alquila pero compra en dos a¤os'),
	(14, 14, 'alquila porque alquil¢ su propiedad'),
	(15, 15, 'sustiuir  garant¡a'),
	(16, 16, 'deposito bhu cinco meses'),
	(17, 17, 'alquila local tambi‚n'),
	(18, 18, 'tiene propiedad en arrendamiento por eso alquila'),
	(19, 19, 'alquila pero compra en dos a¤os'),
	(20, 20, 'alquila porque alquil¢ su propiedad'),
	(21, 21, 'sustiuir  garant¡a'),
	(22, 22, 'deposito bhu cinco meses'),
	(23, 23, 'alquila local tambi‚n'),
	(24, 24, 'tiene propiedad en arrendamiento por eso alquila'),
	(25, 25, 'alquila pero compra en dos a¤os'),
	(26, 26, 'alquila porque alquil¢ su propiedad'),
	(27, 27, 'sustiuir  garant¡a'),
	(28, 28, 'deposito bhu cinco meses'),
	(29, 29, 'alquila local tambi‚n'),
	(30, 30, 'tiene propiedad en arrendamiento por eso alquila'),
	(31, 31, 'alquila pero compra en dos a¤os'),
	(32, 32, 'alquila porque alquil¢ su propiedad'),
	(33, 33, 'sustiuir  garant¡a'),
	(34, 34, 'deposito bhu cinco meses'),
	(35, 35, 'alquila local tambi‚n'),
	(36, 36, 'tiene propiedad en arrendamiento por eso alquila'),
	(37, 37, 'alquila pero compra en dos a¤os'),
	(38, 38, 'alquila porque alquil¢ su propiedad'),
	(39, 39, 'sustiuir  garant¡a'),
	(40, 40, 'deposito bhu cinco meses'),
	(41, 41, 'alquila local tambi‚n'),
	(42, 42, 'tiene propiedad en arrendamiento por eso alquila'),
	(43, 43, 'alquila pero compra en dos a¤os'),
	(44, 44, 'alquila porque alquil¢ su propiedad'),
	(45, 45, 'sustiuir  garant¡a'),
	(46, 46, 'deposito bhu cinco meses'),
	(47, 47, 'alquila local tambi‚n'),
	(48, 48, 'tiene propiedad en arrendamiento por eso alquila'),
	(49, 49, 'alquila pero compra en dos a¤os');
/*!40000 ALTER TABLE `arrendatarios` ENABLE KEYS */;


-- Volcando estructura para tabla lalk.casas
CREATE TABLE IF NOT EXISTS `casas` (
  `idCasa` int(5) NOT NULL AUTO_INCREMENT,
  `idInmueble` int(5) NOT NULL,
  `situacionJuridica` varchar(50) NOT NULL,
  `estructura` varchar(50) DEFAULT NULL,
  `habitacionSocial` varchar(50) NOT NULL,
  `estar` varchar(50) DEFAULT NULL,
  `dormitorios` int(2) NOT NULL,
  `dormConSuite` varchar(50) DEFAULT NULL,
  `dormSocial` varchar(50) DEFAULT NULL,
  `baños` int(2) NOT NULL,
  `bañoServicio` varchar(50) DEFAULT NULL,
  `bañoSocial` varchar(50) DEFAULT NULL,
  `bañoConJacuzzi` varchar(50) DEFAULT NULL,
  `fondo` varchar(50) DEFAULT NULL,
  `patio` varchar(50) DEFAULT NULL,
  `jardin` varchar(2) DEFAULT NULL,
  `garaje` varchar(50) DEFAULT NULL,
  `cocheraAbierta` varchar(50) DEFAULT NULL,
  `cocheraTechada` varchar(50) DEFAULT NULL,
  `amenities` text,
  `areaEdificada` double NOT NULL,
  `metrosFrente` double NOT NULL,
  `detalleCasa` text,
  `Cocina` varchar(20) DEFAULT NULL,
  `rutaImagenCasa` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idCasa`),
  KEY `casas_ibfk_1` (`idInmueble`),
  CONSTRAINT `casas_ibfk_1` FOREIGN KEY (`idInmueble`) REFERENCES `inmueble2` (`refInmueble`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla lalk.casas: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `casas` DISABLE KEYS */;
/*!40000 ALTER TABLE `casas` ENABLE KEYS */;


-- Volcando estructura para tabla lalk.compradores
CREATE TABLE IF NOT EXISTS `compradores` (
  `idComprador` int(5) NOT NULL AUTO_INCREMENT,
  `idPersona` int(5) NOT NULL,
  `detalleComp` varchar(350) DEFAULT NULL,
  PRIMARY KEY (`idComprador`),
  KEY `idPersona` (`idPersona`),
  CONSTRAINT `compradores_ibfk_1` FOREIGN KEY (`idPersona`) REFERENCES `personas` (`idPersona`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla lalk.compradores: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `compradores` DISABLE KEYS */;
/*!40000 ALTER TABLE `compradores` ENABLE KEYS */;


-- Volcando estructura para tabla lalk.control_ingreso
CREATE TABLE IF NOT EXISTS `control_ingreso` (
  `usuario` varchar(50) NOT NULL,
  `clave` varchar(50) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla lalk.control_ingreso: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `control_ingreso` DISABLE KEYS */;
INSERT INTO `control_ingreso` (`usuario`, `clave`, `id`) VALUES
	('adm', '123', 1),
	('Carlos', '123', 2);
/*!40000 ALTER TABLE `control_ingreso` ENABLE KEYS */;


-- Volcando estructura para tabla lalk.formas_pago
CREATE TABLE IF NOT EXISTS `formas_pago` (
  `idVenta` int(5) NOT NULL,
  `formaDePago` enum('Contado','Financiado','Permuto') NOT NULL,
  `detalleFP` varchar(350) DEFAULT NULL,
  KEY `idVenta` (`idVenta`),
  CONSTRAINT `formas_pago_ibfk_1` FOREIGN KEY (`idVenta`) REFERENCES `ventas` (`idVenta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla lalk.formas_pago: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `formas_pago` DISABLE KEYS */;
/*!40000 ALTER TABLE `formas_pago` ENABLE KEYS */;


-- Volcando estructura para tabla lalk.inmueble2
CREATE TABLE IF NOT EXISTS `inmueble2` (
  `refInmueble` int(9) NOT NULL AUTO_INCREMENT,
  `tipoMonedaPrecioLista` int(9) NOT NULL,
  `precioLista` int(9) NOT NULL,
  `contribucionInmobiliaria` int(9) NOT NULL,
  `areaTotal` int(9) NOT NULL,
  `exclusividad` varchar(2) NOT NULL,
  `estadoDisponibilidad` varchar(12) NOT NULL,
  `fechaIngreso` varchar(12) NOT NULL,
  `direccion` varchar(30) NOT NULL,
  `padron` int(9) DEFAULT NULL,
  `barrio` varchar(30) DEFAULT NULL,
  `departamento` varchar(30) DEFAULT NULL,
  `estadoDetalle` text NOT NULL,
  `detalleInmueble` text NOT NULL,
  `antiguedad` int(4) NOT NULL,
  `estadoConservacion` varchar(30) NOT NULL,
  PRIMARY KEY (`refInmueble`),
  KEY `tipoMonedaPrecioLista` (`tipoMonedaPrecioLista`),
  CONSTRAINT `FK_inmueble2_monedalista` FOREIGN KEY (`tipoMonedaPrecioLista`) REFERENCES `monedalista` (`idMonLista`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla lalk.inmueble2: ~99 rows (aproximadamente)
/*!40000 ALTER TABLE `inmueble2` DISABLE KEYS */;
INSERT INTO `inmueble2` (`refInmueble`, `tipoMonedaPrecioLista`, `precioLista`, `contribucionInmobiliaria`, `areaTotal`, `exclusividad`, `estadoDisponibilidad`, `fechaIngreso`, `direccion`, `padron`, `barrio`, `departamento`, `estadoDetalle`, `detalleInmueble`, `antiguedad`, `estadoConservacion`) VALUES
	(1, 1, 100100, 2101, 100, 'SI', 'Disponible', '01/01/2010', 'JACKSON', 10954, 'Pocitos', 'Montevideo', 'actualizar ba¤o', 'zona residencia', 1960, 'bueno'),
	(2, 2, 100101, 2102, 200, 'NO', 'Suspendido', '02/02/2010', 'COLONIA', 10955, 'Aguada', 'Montevideo', 'actulizar cocina', 'zona centrica', 1950, 'malo'),
	(3, 3, 100202, 2103, 150, 'SI', 'Retirado', '06/03/2010', 'ROXLO', 10956, 'Prado', 'Montevideo', 'humedades techos', 'zona roja', 1970, 'regular'),
	(4, 4, 100303, 2104, 250, 'NO', 'Disponible', '07/04/2010', 'CARLOS MARIA RAMIREZ', 10957, 'Centro', 'Montevideo', 'humedades cimientos', 'zona de buenos servicios', 1960, 'bueno'),
	(5, 3, 100404, 2105, 100, 'SI', 'Suspendido', '09/05/2010', 'AMEGHINO', 10958, 'Cord¢n', 'Montevideo', 'ruidos molestos', 'zona sin servicios', 1950, 'malo'),
	(6, 2, 100505, 2106, 175, 'NO', 'Retirado', '10/06/2010', 'GUANA', 10959, 'Bella Vista', 'Montevideo', 'actualizar ba¤o', 'pr¢ximo colegios', 1970, 'regular'),
	(7, 1, 100606, 2107, 180, 'SI', 'Disponible', '12/07/2010', 'PEDRO BUSTAMANTE', 10960, 'La Teja', 'Montevideo', 'actulizar cocina', 'pr¢ximo facultades', 1964, 'bueno'),
	(8, 2, 100707, 2108, 185, 'NO', 'Suspendido', '13/08/2010', 'RAMON ANADOR', 10961, 'Ciudad Vieja', 'Montevideo', 'humedades techos', 'zona residencia', 1958, 'malo'),
	(9, 3, 100808, 2109, 190, 'SI', 'Retirado', '14/09/2010', 'AGRACIADA', 10962, 'Tres Cruces', 'Montevideo', 'humedades cimientos', 'zona centrica', 1952, 'regular'),
	(10, 1, 100909, 2110, 195, 'NO', 'Disponible', '16/10/2010', 'GONZALO RAMIREZ', 10963, 'Athaualpa', 'Montevideo', 'ruidos molestos', 'zona roja', 1946, 'bueno'),
	(11, 2, 101010, 2111, 200, 'SI', 'Suspendido', '17/11/2010', 'DEMOSTENES', 10964, 'Parque Rod¢', 'Montevideo', 'actualizar ba¤o', 'zona de buenos servicios', 1940, 'malo'),
	(12, 1, 101111, 2112, 205, 'NO', 'Retirado', '19/12/2010', 'ZUBIRIA', 10965, 'Pocitos', 'Montevideo', 'actulizar cocina', 'zona sin servicios', 1934, 'regular'),
	(13, 2, 101212, 2113, 210, 'SI', 'Disponible', '20/01/2011', '18 DE JULIO', 10966, 'Aguada', 'Montevideo', 'humedades techos', 'pr¢ximo colegios', 1950, 'bueno'),
	(14, 1, 101313, 2114, 100, 'NO', 'Suspendido', '21/02/2011', 'MINAS', 10967, 'Prado', 'Montevideo', 'humedades cimientos', 'pr¢ximo facultades', 1951, 'malo'),
	(15, 1, 101414, 2115, 120, 'SI', 'Retirado', '25/03/2011', 'RUPERTO PEREZ MARTÖNEZ', 10968, 'Centro', 'Montevideo', 'ruidos molestos', 'zona residencia', 1952, 'regular'),
	(16, 1, 101515, 2116, 140, 'NO', 'Disponible', '26/04/2011', 'JACKSON', 10969, 'Cord¢n', 'Montevideo', 'actualizar ba¤o', 'zona centrica', 1953, 'bueno'),
	(17, 1, 101616, 2117, 160, 'SI', 'Suspendido', '28/05/2011', 'COLONIA', 10970, 'Bella Vista', 'Montevideo', 'actulizar cocina', 'zona roja', 1954, 'malo'),
	(18, 1, 101717, 2118, 180, 'NO', 'Retirado', '29/06/2011', 'ROXLO', 10971, 'La Teja', 'Montevideo', 'humedades techos', 'zona de buenos servicios', 1955, 'regular'),
	(19, 1, 101818, 2119, 200, 'SI', 'Disponible', '31/07/2011', 'CARLOS MARIA RAMIREZ', 10972, 'Ciudad Vieja', 'Montevideo', 'humedades cimientos', 'zona sin servicios', 1956, 'bueno'),
	(20, 1, 101919, 2120, 180, 'NO', 'Suspendido', '01/09/2011', 'AMEGHINO', 10973, 'Tres Cruces', 'Montevideo', 'ruidos molestos', 'pr¢ximo colegios', 1957, 'malo'),
	(21, 1, 102020, 2121, 160, 'SI', 'Retirado', '03/10/2011', 'GUANA', 10974, 'Athaualpa', 'Montevideo', 'actualizar ba¤o', 'pr¢ximo facultades', 1958, 'regular'),
	(22, 1, 102121, 2122, 140, 'NO', 'Disponible', '04/11/2011', 'PEDRO BUSTAMANTE', 10975, 'Parque Rod¢', 'Montevideo', 'actulizar cocina', 'zona residencia', 1959, 'bueno'),
	(23, 1, 102222, 2123, 120, 'SI', 'Suspendido', '06/12/2011', 'RAMON ANADOR', 10976, 'Pocitos', 'Montevideo', 'humedades techos', 'zona centrica', 1960, 'malo'),
	(24, 1, 102323, 2124, 100, 'NO', 'Retirado', '07/01/2012', 'AGRACIADA', 10977, 'Aguada', 'Montevideo', 'humedades cimientos', 'zona roja', 1961, 'regular'),
	(25, 1, 102424, 2125, 120, 'SI', 'Disponible', '08/02/2012', 'GONZALO RAMIREZ', 10978, 'Prado', 'Montevideo', 'ruidos molestos', 'zona de buenos servicios', 1962, 'bueno'),
	(26, 1, 102525, 2126, 140, 'NO', 'Suspendido', '11/03/2012', 'DEMOSTENES', 10979, 'Centro', 'Montevideo', 'actualizar ba¤o', 'zona sin servicios', 1963, 'malo'),
	(27, 1, 102626, 2127, 160, 'SI', 'Retirado', '12/04/2012', 'ZUBIRIA', 10980, 'Cord¢n', 'Montevideo', 'actulizar cocina', 'pr¢ximo colegios', 1964, 'regular'),
	(28, 1, 102727, 2128, 180, 'NO', 'Disponible', '14/05/2012', '19 DE JULIO', 10981, 'Bella Vista', 'Montevideo', 'humedades techos', 'pr¢ximo facultades', 1965, 'bueno'),
	(29, 1, 102828, 2129, 200, 'SI', 'Suspendido', '15/06/2012', 'MINAS', 10982, 'La Teja', 'Montevideo', 'humedades cimientos', 'zona residencia', 1966, 'malo'),
	(30, 1, 102929, 2130, 220, 'NO', 'Retirado', '17/07/2012', 'RUPERTO PEREZ MARTÖNEZ', 10983, 'Ciudad Vieja', 'Montevideo', 'ruidos molestos', 'zona centrica', 1967, 'regular'),
	(31, 1, 103030, 2131, 240, 'SI', 'Disponible', '18/08/2012', 'JACKSON', 10984, 'Tres Cruces', 'Montevideo', 'actualizar ba¤o', 'zona roja', 1968, 'bueno'),
	(32, 1, 103131, 2132, 260, 'NO', 'Suspendido', '19/09/2012', 'COLONIA', 10985, 'Athaualpa', 'Montevideo', 'actulizar cocina', 'zona de buenos servicios', 1969, 'malo'),
	(33, 1, 103232, 2133, 280, 'SI', 'Retirado', '21/10/2012', 'ROXLO', 10986, 'Parque Rod¢', 'Montevideo', 'humedades techos', 'zona sin servicios', 1970, 'regular'),
	(34, 1, 103333, 2134, 300, 'NO', 'Disponible', '22/11/2012', 'CARLOS MARIA RAMIREZ', 10987, 'Pocitos', 'Montevideo', 'humedades cimientos', 'pr¢ximo colegios', 1971, 'bueno'),
	(35, 1, 103434, 2135, 320, 'SI', 'Suspendido', '24/12/2012', 'AMEGHINO', 10988, 'Aguada', 'Montevideo', 'ruidos molestos', 'pr¢ximo facultades', 1972, 'malo'),
	(36, 1, 103535, 2136, 50, 'NO', 'Retirado', '25/01/2013', 'GUANA', 10989, 'Prado', 'Montevideo', 'actualizar ba¤o', 'zona residencia', 1973, 'regular'),
	(37, 1, 103636, 2137, 100, 'SI', 'Disponible', '26/02/2013', 'PEDRO BUSTAMANTE', 10990, 'Carrasco', 'Montevideo', 'actulizar cocina', 'zona centrica', 1974, 'bueno'),
	(38, 1, 103737, 2138, 50, 'NO', 'Suspendido', '30/03/2013', 'RAMON ANADOR', 10991, 'Cord¢n', 'Montevideo', 'humedades techos', 'zona roja', 1975, 'malo'),
	(39, 1, 103838, 2139, 100, 'SI', 'Retirado', '01/05/2013', 'AGRACIADA', 10992, 'Bella Vista', 'Montevideo', 'humedades cimientos', 'zona de buenos servicios', 1976, 'regular'),
	(40, 1, 103939, 2140, 100, 'NO', 'Retirado', '02/06/2013', 'GUANA', 10993, 'Prado', 'Montevideo', 'actualizar ba¤o', 'zona residencia', 1977, 'regular'),
	(41, 1, 104040, 2141, 110, 'SI', 'Disponible', '04/07/2013', 'PEDRO BUSTAMANTE', 10994, 'Carrasco', 'Montevideo', 'actulizar cocina', 'zona centrica', 1978, 'bueno'),
	(42, 3, 104141, 2142, 120, 'NO', 'Suspendido', '05/08/2013', 'RAMON ANADOR', 10995, 'Cord¢n', 'Montevideo', 'humedades techos', 'zona roja', 1979, 'malo'),
	(43, 3, 104242, 2143, 130, 'SI', 'Retirado', '06/09/2013', 'AGRACIADA', 10996, 'Bella Vista', 'Montevideo', 'humedades cimientos', 'zona de buenos servicios', 1980, 'regular'),
	(44, 3, 104343, 2144, 140, 'NO', 'Retirado', '08/10/2013', 'GUANA', 10997, 'Prado', 'Montevideo', 'actualizar ba¤o', 'zona residencia', 1981, 'regular'),
	(45, 3, 104444, 2145, 150, 'SI', 'Disponible', '09/11/2013', 'PEDRO BUSTAMANTE', 10998, 'Carrasco', 'Montevideo', 'actulizar cocina', 'zona centrica', 1982, 'bueno'),
	(46, 3, 104545, 2146, 160, 'NO', 'Suspendido', '11/12/2013', 'RAMON ANADOR', 10999, 'Cord¢n', 'Montevideo', 'humedades techos', 'zona roja', 1983, 'malo'),
	(47, 3, 104646, 2147, 170, 'SI', 'Retirado', '12/01/2014', 'AGRACIADA', 11000, 'Bella Vista', 'Montevideo', 'humedades cimientos', 'zona de buenos servicios', 1984, 'regular'),
	(48, 1, 104747, 2148, 180, 'NO', 'Retirado', '13/02/2014', 'GUANA', 11001, 'Prado', 'Montevideo', 'actualizar ba¤o', 'zona residencia', 1985, 'regular'),
	(49, 1, 104848, 2149, 190, 'SI', 'Disponible', '17/03/2014', 'PEDRO BUSTAMANTE', 11002, 'Carrasco', 'Montevideo', 'actulizar cocina', 'zona centrica', 1986, 'bueno'),
	(50, 1, 104949, 2150, 200, 'NO', 'Suspendido', '18/04/2014', 'RAMON ANADOR', 11003, 'Cord¢n', 'Montevideo', 'humedades techos', 'zona roja', 1987, 'malo'),
	(51, 1, 105050, 2151, 210, 'SI', 'Retirado', '20/05/2014', 'AGRACIADA', 11004, 'Bella Vista', 'Montevideo', 'humedades cimientos', 'zona de buenos servicios', 1988, 'regular'),
	(52, 1, 105151, 2152, 220, 'NO', 'Retirado', '21/06/2014', 'GUANA', 11005, 'Prado', 'Montevideo', 'actualizar ba¤o', 'zona residencia', 1989, 'regular'),
	(53, 1, 105252, 2153, 230, 'SI', 'Disponible', '23/07/2014', 'PEDRO BUSTAMANTE', 11006, 'Carrasco', 'Montevideo', 'actulizar cocina', 'zona centrica', 1990, 'bueno'),
	(54, 1, 105353, 2154, 240, 'NO', 'Suspendido', '24/08/2014', 'RAMON ANADOR', 11007, 'Cord¢n', 'Montevideo', 'humedades techos', 'zona roja', 1991, 'malo'),
	(55, 1, 105454, 2155, 250, 'SI', 'Retirado', '25/09/2014', 'AGRACIADA', 11008, 'Bella Vista', 'Montevideo', 'humedades cimientos', 'zona de buenos servicios', 1992, 'regular'),
	(56, 1, 105555, 2156, 260, 'NO', 'Retirado', '27/10/2014', 'GUANA', 11009, 'Prado', 'Montevideo', 'actualizar ba¤o', 'zona residencia', 1993, 'regular'),
	(57, 1, 105656, 2157, 270, 'SI', 'Disponible', '28/11/2014', 'PEDRO BUSTAMANTE', 11010, 'Carrasco', 'Montevideo', 'actulizar cocina', 'zona centrica', 1994, 'bueno'),
	(58, 1, 105757, 2158, 280, 'NO', 'Suspendido', '30/12/2014', 'RAMON ANADOR', 11011, 'Cord¢n', 'Montevideo', 'humedades techos', 'zona roja', 1995, 'malo'),
	(59, 1, 105858, 2159, 290, 'SI', 'Retirado', '31/01/2015', 'AGRACIADA', 11012, 'Bella Vista', 'Montevideo', 'humedades cimientos', 'zona de buenos servicios', 1996, 'regular'),
	(60, 1, 105959, 2160, 300, 'NO', 'Retirado', '04/03/2015', 'GUANA', 11013, 'Prado', 'Montevideo', 'actualizar ba¤o', 'zona residencia', 1997, 'regular'),
	(61, 1, 106060, 2161, 310, 'SI', 'Disponible', '05/04/2015', 'PEDRO BUSTAMANTE', 11014, 'Carrasco', 'Montevideo', 'actulizar cocina', 'zona centrica', 1998, 'bueno'),
	(62, 1, 106161, 2162, 320, 'NO', 'Suspendido', '07/05/2015', 'RAMON ANADOR', 11015, 'Cord¢n', 'Montevideo', 'humedades techos', 'zona roja', 1999, 'malo'),
	(63, 1, 106262, 2163, 330, 'SI', 'Retirado', '08/06/2015', 'AGRACIADA', 11016, 'Bella Vista', 'Montevideo', 'humedades cimientos', 'zona de buenos servicios', 2000, 'regular'),
	(64, 1, 106363, 2164, 340, 'NO', 'Retirado', '10/07/2015', 'GUANA', 11017, 'Prado', 'Montevideo', 'actualizar ba¤o', 'zona residencia', 2001, 'regular'),
	(65, 1, 106464, 2165, 350, 'SI', 'Disponible', '11/08/2015', 'PEDRO BUSTAMANTE', 11018, 'Carrasco', 'Montevideo', 'actulizar cocina', 'zona centrica', 2002, 'bueno'),
	(66, 1, 106565, 2166, 360, 'NO', 'Suspendido', '12/09/2015', 'RAMON ANADOR', 11019, 'Cord¢n', 'Montevideo', 'humedades techos', 'zona roja', 2003, 'malo'),
	(67, 1, 106666, 2167, 370, 'SI', 'Retirado', '14/10/2015', 'AGRACIADA', 11020, 'Bella Vista', 'Montevideo', 'humedades cimientos', 'zona de buenos servicios', 2004, 'regular'),
	(68, 1, 106767, 2168, 380, 'NO', 'Retirado', '15/11/2015', 'GUANA', 11021, 'Prado', 'Montevideo', 'actualizar ba¤o', 'zona residencia', 2005, 'regular'),
	(69, 1, 106868, 2169, 390, 'SI', 'Disponible', '17/12/2015', 'PEDRO BUSTAMANTE', 11022, 'Carrasco', 'Montevideo', 'actulizar cocina', 'zona centrica', 2006, 'bueno'),
	(70, 1, 106969, 2170, 400, 'NO', 'Suspendido', '18/01/2016', 'RAMON ANADOR', 11023, 'Cord¢n', 'Montevideo', 'humedades techos', 'zona roja', 2007, 'malo'),
	(71, 1, 107070, 2171, 410, 'SI', 'Retirado', '19/02/2016', 'AGRACIADA', 11024, 'Bella Vista', 'Montevideo', 'humedades cimientos', 'zona de buenos servicios', 2008, 'regular'),
	(72, 1, 107171, 2172, 420, 'NO', 'Retirado', '22/03/2016', 'GUANA', 11025, 'Prado', 'Montevideo', 'actualizar ba¤o', 'zona residencia', 2009, 'regular'),
	(73, 1, 107272, 2173, 430, 'SI', 'Disponible', '23/04/2016', 'PEDRO BUSTAMANTE', 11026, 'Carrasco', 'Montevideo', 'actulizar cocina', 'zona centrica', 2010, 'bueno'),
	(74, 1, 107373, 2174, 440, 'NO', 'Suspendido', '25/05/2016', 'RAMON ANADOR', 11027, 'Cord¢n', 'Montevideo', 'humedades techos', 'zona roja', 2011, 'malo'),
	(75, 1, 107474, 2175, 450, 'SI', 'Retirado', '26/06/2016', 'AGRACIADA', 11028, 'Bella Vista', 'Montevideo', 'humedades cimientos', 'zona de buenos servicios', 2012, 'regular'),
	(76, 1, 107575, 2176, 460, 'NO', 'Retirado', '28/07/2016', 'GUANA', 11029, 'Prado', 'Montevideo', 'actualizar ba¤o', 'zona residencia', 2013, 'regular'),
	(77, 1, 107676, 2177, 470, 'SI', 'Disponible', '29/08/2016', 'PEDRO BUSTAMANTE', 11030, 'Carrasco', 'Montevideo', 'actulizar cocina', 'zona centrica', 2014, 'bueno'),
	(78, 1, 107777, 2178, 480, 'NO', 'Suspendido', '30/09/2016', 'RAMON ANADOR', 11031, 'Cord¢n', 'Montevideo', 'humedades techos', 'zona roja', 1960, 'malo'),
	(79, 1, 107878, 2179, 490, 'SI', 'Retirado', '01/11/2016', 'AGRACIADA', 11032, 'Bella Vista', 'Montevideo', 'humedades cimientos', 'zona de buenos servicios', 1961, 'regular'),
	(80, 1, 107979, 2180, 500, 'NO', 'Retirado', '03/12/2016', 'GUANA', 11033, 'Prado', 'Montevideo', 'actualizar ba¤o', 'zona residencia', 1962, 'regular'),
	(81, 1, 108080, 2181, 510, 'SI', 'Disponible', '04/01/2017', 'PEDRO BUSTAMANTE', 11034, 'Carrasco', 'Montevideo', 'actulizar cocina', 'zona centrica', 1963, 'bueno'),
	(82, 1, 108181, 2182, 520, 'NO', 'Suspendido', '05/02/2017', 'RAMON ANADOR', 11035, 'Cord¢n', 'Montevideo', 'humedades techos', 'zona roja', 1964, 'malo'),
	(83, 1, 108282, 2183, 530, 'SI', 'Retirado', '09/03/2017', 'AGRACIADA', 11036, 'Bella Vista', 'Montevideo', 'humedades cimientos', 'zona de buenos servicios', 1965, 'regular'),
	(84, 2, 108383, 2184, 540, 'NO', 'Retirado', '10/04/2017', 'GUANA', 11037, 'Prado', 'Montevideo', 'actualizar ba¤o', 'zona residencia', 1966, 'regular'),
	(85, 2, 108484, 2185, 550, 'SI', 'Disponible', '12/05/2017', 'PEDRO BUSTAMANTE', 11038, 'Carrasco', 'Montevideo', 'actulizar cocina', 'zona centrica', 1967, 'bueno'),
	(86, 2, 108585, 2186, 560, 'NO', 'Suspendido', '13/06/2017', 'RAMON ANADOR', 11039, 'Cord¢n', 'Montevideo', 'humedades techos', 'zona roja', 1968, 'malo'),
	(87, 2, 108686, 2187, 570, 'SI', 'Retirado', '15/07/2017', 'AGRACIADA', 11040, 'Bella Vista', 'Montevideo', 'humedades cimientos', 'zona de buenos servicios', 1969, 'regular'),
	(88, 2, 108787, 2188, 580, 'NO', 'Retirado', '16/08/2017', 'GUANA', 11041, 'Prado', 'Montevideo', 'actualizar ba¤o', 'zona residencia', 1970, 'regular'),
	(89, 2, 108888, 2189, 590, 'SI', 'Disponible', '17/09/2017', 'PEDRO BUSTAMANTE', 11042, 'Carrasco', 'Montevideo', 'actulizar cocina', 'zona centrica', 1971, 'bueno'),
	(90, 1, 108989, 2190, 600, 'NO', 'Suspendido', '19/10/2017', 'RAMON ANADOR', 11043, 'Cord¢n', 'Montevideo', 'humedades techos', 'zona roja', 1972, 'malo'),
	(91, 1, 109090, 2191, 610, 'SI', 'Retirado', '20/11/2017', 'AGRACIADA', 11044, 'Bella Vista', 'Montevideo', 'humedades cimientos', 'zona de buenos servicios', 1973, 'regular'),
	(92, 1, 109191, 2192, 620, 'NO', 'Retirado', '22/12/2017', 'GUANA', 11045, 'Prado', 'Montevideo', 'actualizar ba¤o', 'zona residencia', 1974, 'regular'),
	(93, 1, 109292, 2193, 630, 'SI', 'Disponible', '23/01/2018', 'PEDRO BUSTAMANTE', 11046, 'Carrasco', 'Montevideo', 'actulizar cocina', 'zona centrica', 1975, 'bueno'),
	(94, 1, 109393, 2194, 640, 'NO', 'Suspendido', '24/02/2018', 'RAMON ANADOR', 11047, 'Cord¢n', 'Montevideo', 'humedades techos', 'zona roja', 1976, 'malo'),
	(95, 1, 109494, 2195, 650, 'SI', 'Retirado', '28/03/2018', 'AGRACIADA', 11048, 'Bella Vista', 'Montevideo', 'humedades cimientos', 'zona de buenos servicios', 1977, 'regular'),
	(96, 1, 109595, 2196, 660, 'NO', 'Retirado', '29/04/2018', 'GUANA', 11049, 'Prado', 'Montevideo', 'actualizar ba¤o', 'zona residencia', 1978, 'regular'),
	(97, 1, 109696, 2197, 670, 'SI', 'Disponible', '31/05/2018', 'PEDRO BUSTAMANTE', 11050, 'Carrasco', 'Montevideo', 'actulizar cocina', 'zona centrica', 1979, 'bueno'),
	(98, 1, 109797, 2198, 680, 'NO', 'Suspendido', '02/07/2018', 'RAMON ANADOR', 11051, 'Cord¢n', 'Montevideo', 'humedades techos', 'zona roja', 1980, 'malo'),
	(99, 1, 109898, 2199, 690, 'SI', 'Retirado', '03/08/2018', 'AGRACIADA', 11052, 'Bella Vista', 'Montevideo', 'humedades cimientos', 'zona de buenos servicios', 1981, 'regular');
/*!40000 ALTER TABLE `inmueble2` ENABLE KEYS */;


-- Volcando estructura para tabla lalk.monedalista
CREATE TABLE IF NOT EXISTS `monedalista` (
  `monLista` varchar(10) NOT NULL,
  `idMonLista` int(2) NOT NULL,
  PRIMARY KEY (`idMonLista`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla lalk.monedalista: ~8 rows (aproximadamente)
/*!40000 ALTER TABLE `monedalista` DISABLE KEYS */;
INSERT INTO `monedalista` (`monLista`, `idMonLista`) VALUES
	('', 0),
	('$UY', 1),
	('$AR', 2),
	('USD Americ', 3),
	('USD Canadi', 4),
	('$R', 5),
	('Libra', 6),
	('Euro', 7);
/*!40000 ALTER TABLE `monedalista` ENABLE KEYS */;


-- Volcando estructura para tabla lalk.operadores
CREATE TABLE IF NOT EXISTS `operadores` (
  `idOperador` int(5) NOT NULL AUTO_INCREMENT,
  `idPersona` int(5) NOT NULL,
  `fechaIngOpe` date NOT NULL,
  `detalleOpe` varchar(350) DEFAULT NULL,
  PRIMARY KEY (`idOperador`),
  KEY `idPersona` (`idPersona`),
  CONSTRAINT `operadores_ibfk_1` FOREIGN KEY (`idPersona`) REFERENCES `personas` (`idPersona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla lalk.operadores: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `operadores` DISABLE KEYS */;
/*!40000 ALTER TABLE `operadores` ENABLE KEYS */;


-- Volcando estructura para tabla lalk.personas
CREATE TABLE IF NOT EXISTS `personas` (
  `idPersona` int(5) NOT NULL AUTO_INCREMENT,
  `nombrePer` varchar(50) NOT NULL,
  `emailPer` varchar(50) DEFAULT NULL,
  `detallePer` varchar(350) DEFAULT NULL,
  PRIMARY KEY (`idPersona`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla lalk.personas: ~15 rows (aproximadamente)
/*!40000 ALTER TABLE `personas` DISABLE KEYS */;
INSERT INTO `personas` (`idPersona`, `nombrePer`, `emailPer`, `detallePer`) VALUES
	(1, 'Axel', 'axel@1', 'llamar al celular'),
	(2, 'Bruno', 'bruno@2', 'contactarse a la oficina'),
	(3, 'Aler', 'aler@3', 'llamar al tel‚fono'),
	(4, 'Mar¡a Eugenia', 'mar¡a eugenia@', 'contactarse por email'),
	(5, 'Axel', 'axel@2', 'llamar al celular'),
	(6, 'Bruno', 'bruno@3', 'contactarse a la oficina'),
	(7, 'Aler', 'aler@4', 'llamar al tel‚fono'),
	(8, 'Mar¡a Eugenia', 'mar¡a eugenia@', 'contactarse por email'),
	(9, 'Axel', 'axel@3', 'llamar al celular'),
	(10, 'Bruno', 'bruno@4', 'contactarse a la oficina'),
	(11, 'Aler', 'aler@5', 'llamar al tel‚fono'),
	(12, 'Mar¡a Eugenia', 'mar¡a eugenia@', 'contactarse por email'),
	(13, 'Axel', 'axel@4', 'llamar al celular'),
	(14, 'Bruno', 'bruno@5', 'contactarse a la oficina'),
	(15, 'Aler', 'aler@6', 'llamar al tel‚fono'),
	(16, 'Mar¡a Eugenia', 'mar¡a eugenia@', 'contactarse por email'),
	(17, 'Axel', 'axel@5', 'llamar al celular'),
	(18, 'Bruno', 'bruno@6', 'contactarse a la oficina'),
	(19, 'Aler', 'aler@7', 'llamar al tel‚fono'),
	(20, 'Mar¡a Eugenia', 'mar¡a eugenia@', 'contactarse por email'),
	(21, 'Axel', 'axel@6', 'llamar al celular'),
	(22, 'Bruno', 'bruno@7', 'contactarse a la oficina'),
	(23, 'Aler', 'aler@8', 'llamar al tel‚fono'),
	(24, 'Mar¡a Eugenia', 'mar¡a eugenia@', 'contactarse por email'),
	(25, 'Axel', 'axel@7', 'llamar al celular'),
	(26, 'Bruno', 'bruno@8', 'contactarse a la oficina'),
	(27, 'Aler', 'aler@9', 'llamar al tel‚fono'),
	(28, 'Mar¡a Eugenia', 'mar¡a eugenia@', 'contactarse por email'),
	(29, 'Axel', 'axel@8', 'llamar al celular'),
	(30, 'Bruno', 'bruno@9', 'contactarse a la oficina'),
	(31, 'Aler', 'aler@10', 'llamar al tel‚fono'),
	(32, 'Mar¡a Eugenia', 'mar¡a eugenia@', 'contactarse por email'),
	(33, 'Axel', 'axel@9', 'llamar al celular'),
	(34, 'Bruno', 'bruno@10', 'contactarse a la oficina'),
	(35, 'Aler', 'aler@11', 'llamar al tel‚fono'),
	(36, 'Mar¡a Eugenia', 'mar¡a eugenia@', 'contactarse por email'),
	(37, 'Axel', 'axel@10', 'llamar al celular'),
	(38, 'Bruno', 'bruno@11', 'contactarse a la oficina'),
	(39, 'Aler', 'aler@12', 'llamar al tel‚fono'),
	(40, 'Mar¡a Eugenia', 'mar¡a eugenia@', 'contactarse por email'),
	(41, 'Axel', 'axel@11', 'llamar al celular'),
	(42, 'Bruno', 'bruno@12', 'contactarse a la oficina'),
	(43, 'Aler', 'aler@13', 'llamar al tel‚fono'),
	(44, 'Mar¡a Eugenia', 'mar¡a eugenia@', 'contactarse por email'),
	(45, 'Axel', 'axel@12', 'llamar al celular'),
	(46, 'Bruno', 'bruno@13', 'contactarse a la oficina'),
	(47, 'Aler', 'aler@14', 'llamar al tel‚fono'),
	(48, 'Mar¡a Eugenia', 'mar¡a eugenia@', 'contactarse por email'),
	(49, 'Axel', 'axel@13', 'llamar al celular'),
	(50, 'Bruno', 'bruno@14', 'contactarse a la oficina'),
	(51, 'Aler', 'aler@15', 'llamar al tel‚fono'),
	(52, 'Mar¡a Eugenia', 'mar¡a eugenia@', 'contactarse por email'),
	(53, 'Axel', 'axel@14', 'llamar al celular'),
	(54, 'Bruno', 'bruno@15', 'contactarse a la oficina'),
	(55, 'Aler', 'aler@16', 'llamar al tel‚fono'),
	(56, 'Mar¡a Eugenia', 'mar¡a eugenia@', 'contactarse por email'),
	(57, 'Axel', 'axel@15', 'llamar al celular'),
	(58, 'Bruno', 'bruno@16', 'contactarse a la oficina'),
	(59, 'Aler', 'aler@17', 'llamar al tel‚fono'),
	(60, 'Mar¡a Eugenia', 'mar¡a eugenia@', 'contactarse por email'),
	(61, 'Axel', 'axel@16', 'llamar al celular'),
	(62, 'Bruno', 'bruno@17', 'contactarse a la oficina'),
	(63, 'Aler', 'aler@18', 'llamar al tel‚fono'),
	(64, 'Mar¡a Eugenia', 'mar¡a eugenia@', 'contactarse por email'),
	(65, 'Axel', 'axel@17', 'llamar al celular'),
	(66, 'Bruno', 'bruno@18', 'contactarse a la oficina'),
	(67, 'Aler', 'aler@19', 'llamar al tel‚fono'),
	(68, 'Mar¡a Eugenia', 'mar¡a eugenia@', 'contactarse por email'),
	(69, 'Axel', 'axel@18', 'llamar al celular'),
	(70, 'Bruno', 'bruno@19', 'contactarse a la oficina'),
	(71, 'Aler', 'aler@20', 'llamar al tel‚fono'),
	(72, 'Mar¡a Eugenia', 'mar¡a eugenia@', 'contactarse por email'),
	(73, 'Axel', 'axel@19', 'llamar al celular'),
	(74, 'Bruno', 'bruno@20', 'contactarse a la oficina'),
	(75, 'Aler', 'aler@21', 'llamar al tel‚fono'),
	(76, 'Mar¡a Eugenia', 'mar¡a eugenia@', 'contactarse por email'),
	(77, 'Axel', 'axel@20', 'llamar al celular'),
	(78, 'Bruno', 'bruno@21', 'contactarse a la oficina'),
	(79, 'Aler', 'aler@22', 'llamar al tel‚fono'),
	(80, 'Mar¡a Eugenia', 'mar¡a eugenia@', 'contactarse por email'),
	(81, 'Axel', 'axel@21', 'llamar al celular'),
	(82, 'Bruno', 'bruno@22', 'contactarse a la oficina'),
	(83, 'Aler', 'aler@23', 'llamar al tel‚fono'),
	(84, 'Mar¡a Eugenia', 'mar¡a eugenia@', 'contactarse por email'),
	(85, 'Axel', 'axel@22', 'llamar al celular'),
	(86, 'Bruno', 'bruno@23', 'contactarse a la oficina'),
	(87, 'Aler', 'aler@24', 'llamar al tel‚fono'),
	(88, 'Mar¡a Eugenia', 'mar¡a eugenia@', 'contactarse por email'),
	(89, 'Axel', 'axel@23', 'llamar al celular'),
	(90, 'Bruno', 'bruno@24', 'contactarse a la oficina'),
	(91, 'Aler', 'aler@25', 'llamar al tel‚fono'),
	(92, 'Mar¡a Eugenia', 'mar¡a eugenia@', 'contactarse por email'),
	(93, 'Axel', 'axel@24', 'llamar al celular'),
	(94, 'Bruno', 'bruno@25', 'contactarse a la oficina'),
	(95, 'Aler', 'aler@26', 'llamar al tel‚fono'),
	(96, 'Mar¡a Eugenia', 'mar¡a eugenia@', 'contactarse por email'),
	(97, 'Axel', 'axel@25', 'llamar al celular'),
	(98, 'Bruno', 'bruno@26', 'contactarse a la oficina'),
	(99, 'Aler', 'aler@27', 'llamar al tel‚fono');
/*!40000 ALTER TABLE `personas` ENABLE KEYS */;


-- Volcando estructura para tabla lalk.propietarios
CREATE TABLE IF NOT EXISTS `propietarios` (
  `idPropietario` int(5) NOT NULL AUTO_INCREMENT,
  `idPersona` int(5) NOT NULL,
  `detalleCli` varchar(350) DEFAULT NULL,
  PRIMARY KEY (`idPropietario`),
  KEY `idPersona` (`idPersona`),
  CONSTRAINT `propietarios_ibfk_1` FOREIGN KEY (`idPersona`) REFERENCES `personas` (`idPersona`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla lalk.propietarios: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `propietarios` DISABLE KEYS */;
INSERT INTO `propietarios` (`idPropietario`, `idPersona`, `detalleCli`) VALUES
	(1, 1, 'nos deja llave'),
	(2, 2, 'tiene disponibilidad'),
	(3, 3, 'tiene m s propiedades'),
	(4, 4, 'quiere vender para comprar'),
	(5, 5, 'quiere alquilar para comprar'),
	(6, 6, 'nos deja llave'),
	(7, 7, 'tiene disponibilidad'),
	(8, 8, 'tiene m s propiedades'),
	(9, 9, 'quiere vender para comprar'),
	(10, 10, 'quiere alquilar para comprar'),
	(11, 11, 'nos deja llave'),
	(12, 12, 'tiene disponibilidad'),
	(13, 13, 'tiene m s propiedades'),
	(14, 14, 'quiere vender para comprar'),
	(15, 15, 'quiere alquilar para comprar'),
	(16, 16, 'nos deja llave'),
	(17, 17, 'tiene disponibilidad'),
	(18, 18, 'tiene m s propiedades'),
	(19, 19, 'quiere vender para comprar'),
	(20, 20, 'quiere alquilar para comprar'),
	(21, 21, 'nos deja llave'),
	(22, 22, 'tiene disponibilidad'),
	(23, 23, 'tiene m s propiedades'),
	(24, 24, 'quiere vender para comprar'),
	(25, 25, 'quiere alquilar para comprar'),
	(26, 26, 'nos deja llave'),
	(27, 27, 'tiene disponibilidad'),
	(28, 28, 'tiene m s propiedades'),
	(29, 29, 'quiere vender para comprar'),
	(30, 30, 'quiere alquilar para comprar'),
	(31, 31, 'nos deja llave'),
	(32, 32, 'tiene disponibilidad'),
	(33, 33, 'tiene m s propiedades'),
	(34, 34, 'quiere vender para comprar'),
	(35, 35, 'quiere alquilar para comprar'),
	(36, 36, 'nos deja llave'),
	(37, 37, 'tiene disponibilidad'),
	(38, 38, 'tiene m s propiedades'),
	(39, 39, 'quiere vender para comprar'),
	(40, 40, 'quiere alquilar para comprar'),
	(41, 41, 'nos deja llave'),
	(42, 42, 'tiene disponibilidad'),
	(43, 43, 'tiene m s propiedades'),
	(44, 44, 'quiere vender para comprar'),
	(45, 45, 'quiere alquilar para comprar'),
	(46, 46, 'nos deja llave'),
	(47, 47, 'tiene disponibilidad'),
	(48, 48, 'tiene m s propiedades'),
	(49, 49, 'quiere vender para comprar'),
	(50, 50, 'quiere alquilar para comprar'),
	(51, 51, 'nos deja llave'),
	(52, 52, 'tiene disponibilidad'),
	(53, 53, 'tiene m s propiedades'),
	(54, 54, 'quiere vender para comprar'),
	(55, 55, 'quiere alquilar para comprar'),
	(56, 56, 'nos deja llave'),
	(57, 57, 'tiene disponibilidad'),
	(58, 58, 'tiene m s propiedades'),
	(59, 59, 'quiere vender para comprar'),
	(60, 60, 'quiere alquilar para comprar'),
	(61, 61, 'nos deja llave'),
	(62, 62, 'tiene disponibilidad'),
	(63, 63, 'tiene m s propiedades'),
	(64, 64, 'quiere vender para comprar'),
	(65, 65, 'quiere alquilar para comprar'),
	(66, 66, 'nos deja llave'),
	(67, 67, 'tiene disponibilidad'),
	(68, 68, 'tiene m s propiedades'),
	(69, 69, 'quiere vender para comprar'),
	(70, 70, 'quiere alquilar para comprar'),
	(71, 71, 'nos deja llave'),
	(72, 72, 'tiene disponibilidad'),
	(73, 73, 'tiene m s propiedades'),
	(74, 74, 'quiere vender para comprar'),
	(75, 75, 'quiere alquilar para comprar'),
	(76, 76, 'nos deja llave'),
	(77, 77, 'tiene disponibilidad'),
	(78, 78, 'tiene m s propiedades'),
	(79, 79, 'quiere vender para comprar'),
	(80, 80, 'quiere alquilar para comprar'),
	(81, 81, 'nos deja llave'),
	(82, 82, 'tiene disponibilidad'),
	(83, 83, 'tiene m s propiedades'),
	(84, 84, 'quiere vender para comprar'),
	(85, 85, 'quiere alquilar para comprar'),
	(86, 86, 'nos deja llave'),
	(87, 87, 'tiene disponibilidad'),
	(88, 88, 'tiene m s propiedades'),
	(89, 89, 'quiere vender para comprar'),
	(90, 90, 'quiere alquilar para comprar'),
	(91, 91, 'nos deja llave'),
	(92, 92, 'tiene disponibilidad'),
	(93, 93, 'tiene m s propiedades'),
	(94, 94, 'quiere vender para comprar'),
	(95, 95, 'quiere alquilar para comprar'),
	(96, 96, 'nos deja llave'),
	(97, 97, 'tiene disponibilidad'),
	(98, 98, 'tiene m s propiedades'),
	(99, 99, 'quiere vender para comprar');
/*!40000 ALTER TABLE `propietarios` ENABLE KEYS */;


-- Volcando estructura para tabla lalk.tel_personas
CREATE TABLE IF NOT EXISTS `tel_personas` (
  `telPersona` int(15) DEFAULT NULL,
  `idPersona` int(5) DEFAULT NULL,
  `detalleTel` varchar(350) DEFAULT NULL,
  UNIQUE KEY `telPersona` (`telPersona`),
  KEY `FK_tel_personas_personas` (`idPersona`),
  CONSTRAINT `FK_tel_personas_personas` FOREIGN KEY (`idPersona`) REFERENCES `personas` (`idPersona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla lalk.tel_personas: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `tel_personas` DISABLE KEYS */;
/*!40000 ALTER TABLE `tel_personas` ENABLE KEYS */;


-- Volcando estructura para tabla lalk.terrenos
CREATE TABLE IF NOT EXISTS `terrenos` (
  `idTerreno` int(5) NOT NULL AUTO_INCREMENT,
  `idInmueble` int(5) NOT NULL,
  `FOS` int(3) DEFAULT NULL,
  `alturaEdificable` double DEFAULT NULL,
  `frente` double NOT NULL,
  `situacionJuridicaSuelo` varchar(50) NOT NULL,
  `productividad` varchar(50) NOT NULL,
  `conMejoras` varchar(50) DEFAULT NULL,
  `Coneat` int(3) DEFAULT NULL,
  `AreaTotal` int(11) NOT NULL,
  `detalleTerr` varchar(350) DEFAULT NULL,
  `rutaImagenTerreno` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idTerreno`),
  KEY `terreno_ibfk_1` (`idInmueble`),
  CONSTRAINT `terrenos_ibfk_1` FOREIGN KEY (`idInmueble`) REFERENCES `inmueble2` (`refInmueble`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla lalk.terrenos: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `terrenos` DISABLE KEYS */;
/*!40000 ALTER TABLE `terrenos` ENABLE KEYS */;


-- Volcando estructura para tabla lalk.ventas
CREATE TABLE IF NOT EXISTS `ventas` (
  `idVenta` int(5) NOT NULL AUTO_INCREMENT,
  `idComprador` int(5) DEFAULT NULL,
  `idInmueble` int(5) NOT NULL,
  `tipoMoneda` int(5) NOT NULL,
  `precioVenta` double DEFAULT NULL,
  `fechaEgreso` varchar(50) DEFAULT NULL,
  `gravamen` varchar(350) DEFAULT NULL,
  `nombreEsc` varchar(50) DEFAULT NULL,
  `telEsc` int(15) DEFAULT NULL,
  `emailEsc` varchar(50) DEFAULT NULL,
  `detalleEsc` varchar(350) DEFAULT NULL,
  `detalleVen` varchar(350) DEFAULT NULL,
  PRIMARY KEY (`idVenta`),
  KEY `idComprador` (`idComprador`),
  KEY `idInmueble` (`idInmueble`),
  KEY `tipoMoneda` (`tipoMoneda`),
  CONSTRAINT `FK_ventas_monedalista` FOREIGN KEY (`tipoMoneda`) REFERENCES `monedalista` (`idMonLista`),
  CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`idComprador`) REFERENCES `compradores` (`idComprador`),
  CONSTRAINT `ventas_ibfk_2` FOREIGN KEY (`idInmueble`) REFERENCES `inmueble2` (`refInmueble`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla lalk.ventas: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
