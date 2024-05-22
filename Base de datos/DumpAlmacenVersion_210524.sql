-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: almacen_db
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ciudad_tbl`
--

DROP TABLE IF EXISTS `ciudad_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ciudad_tbl` (
  `codPostal` char(5) NOT NULL,
  `nombreCiudad` varchar(100) NOT NULL,
  PRIMARY KEY (`codPostal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudad_tbl`
--

LOCK TABLES `ciudad_tbl` WRITE;
/*!40000 ALTER TABLE `ciudad_tbl` DISABLE KEYS */;
INSERT INTO `ciudad_tbl` VALUES ('70044','COLONIA LAS FLORES'),('70125','XADANI'),('70200','COLONIA NUEVE'),('70300','IXTEPEC');
/*!40000 ALTER TABLE `ciudad_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingresomaterial_tbl`
--

DROP TABLE IF EXISTS `ingresomaterial_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingresomaterial_tbl` (
  `cveIngresoMaterial` char(6) NOT NULL,
  `detallePedido` varchar(50) DEFAULT NULL,
  `estado` bit(1) DEFAULT NULL,
  `cantidadPedido` int NOT NULL,
  `fechaPedido` datetime DEFAULT CURRENT_TIMESTAMP,
  `fechaIngreso` varchar(10) DEFAULT NULL,
  `costoTotal` float NOT NULL,
  `cveProveedor` varchar(6) NOT NULL,
  `cveMateriaPrima` char(6) NOT NULL,
  PRIMARY KEY (`cveIngresoMaterial`),
  KEY `cveProveedor` (`cveProveedor`),
  KEY `cveMateriaPrima` (`cveMateriaPrima`),
  CONSTRAINT `ingresomaterial_tbl_ibfk_1` FOREIGN KEY (`cveProveedor`) REFERENCES `proveedor_tbl` (`cveProveedor`) ON UPDATE CASCADE,
  CONSTRAINT `ingresomaterial_tbl_ibfk_2` FOREIGN KEY (`cveMateriaPrima`) REFERENCES `materiaprima_tbl` (`cveMateriaPrima`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingresomaterial_tbl`
--

LOCK TABLES `ingresomaterial_tbl` WRITE;
/*!40000 ALTER TABLE `ingresomaterial_tbl` DISABLE KEYS */;
INSERT INTO `ingresomaterial_tbl` VALUES ('IAG-01','NUMERO UNO',_binary '',10,'2024-05-21 09:37:32','2024-5-20',10000,'MSC-01','MSC-01');
/*!40000 ALTER TABLE `ingresomaterial_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materiaprima_tbl`
--

DROP TABLE IF EXISTS `materiaprima_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materiaprima_tbl` (
  `cveMateriaPrima` char(6) NOT NULL,
  `nombreMateria` varchar(50) NOT NULL,
  `stockMinimo` int DEFAULT NULL,
  `cantidadDisp` int NOT NULL,
  PRIMARY KEY (`cveMateriaPrima`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materiaprima_tbl`
--

LOCK TABLES `materiaprima_tbl` WRITE;
/*!40000 ALTER TABLE `materiaprima_tbl` DISABLE KEYS */;
INSERT INTO `materiaprima_tbl` VALUES ('AGA-01','AGUA DEL TROPICO',0,110),('GDT-01','GAS LP DEL TROPICO',0,130),('MSC-01','MASECA',20,112);
/*!40000 ALTER TABLE `materiaprima_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor_tbl`
--

DROP TABLE IF EXISTS `proveedor_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor_tbl` (
  `cveProveedor` varchar(6) NOT NULL,
  `nombreEmpresa` varchar(100) NOT NULL,
  `nombreEncargado` varchar(100) NOT NULL,
  `apePatEncargado` varchar(50) NOT NULL,
  `apeMatEncargado` varchar(50) DEFAULT NULL,
  `telefonoProveedor` char(10) NOT NULL,
  `correoProveedor` varchar(100) DEFAULT NULL,
  `rfc` char(13) NOT NULL,
  `codPostal` char(5) NOT NULL,
  PRIMARY KEY (`cveProveedor`),
  KEY `codPostal` (`codPostal`),
  CONSTRAINT `proveedor_tbl_ibfk_1` FOREIGN KEY (`codPostal`) REFERENCES `ciudad_tbl` (`codPostal`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor_tbl`
--

LOCK TABLES `proveedor_tbl` WRITE;
/*!40000 ALTER TABLE `proveedor_tbl` DISABLE KEYS */;
INSERT INTO `proveedor_tbl` VALUES ('AGA-01','AGUA DEL TROPICO','AGUA DEL TROPICO','CARO','QUINTERO','9711581911','quintero@gmail.com','1234567899012','70125'),('glp-01','GAS DEL TROPICO','CARLOS DANIEL','RAMIREZ','LOPEZ','9711581169','gascorreo@gmail.com','1234567890123','70044'),('MSC-01','MASECA SA CV','MASECA SA CV','GUERRA','SANTIAGO','9711112233','maseca@gmail.com','1234567890123','70125');
/*!40000 ALTER TABLE `proveedor_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salidamaterial_tbl`
--

DROP TABLE IF EXISTS `salidamaterial_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salidamaterial_tbl` (
  `cveSalidaMaterial` char(9) NOT NULL,
  `cantidadSalida` int NOT NULL,
  `fechaSalida` datetime DEFAULT CURRENT_TIMESTAMP,
  `detalleSalida` varchar(50) DEFAULT NULL,
  `cveMateriaPrima` char(7) NOT NULL,
  PRIMARY KEY (`cveSalidaMaterial`),
  KEY `cveMateriaPrima` (`cveMateriaPrima`),
  CONSTRAINT `salidamaterial_tbl_ibfk_1` FOREIGN KEY (`cveMateriaPrima`) REFERENCES `materiaprima_tbl` (`cveMateriaPrima`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salidamaterial_tbl`
--

LOCK TABLES `salidamaterial_tbl` WRITE;
/*!40000 ALTER TABLE `salidamaterial_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `salidamaterial_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'almacen_db'
--

--
-- Dumping routines for database 'almacen_db'
--
/*!50003 DROP PROCEDURE IF EXISTS `prueba` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `prueba`()
BEGIN
SELECT 
    i.cveIngresoMaterial, 
    i.detallePedido, 
    i.estado,
    CASE i.estado
        WHEN 0 THEN 'EN ESPERA'
        WHEN 1 THEN 'EN ALMACÉN'
        ELSE 'ESTADO DESCONOCIDO'
    END AS estado_descripcion, 
    i.cantidadPedido, 
    i.fechaPedido, 
    i.fechaIngreso, 
    i.costoTotal, 
    i.cveProveedor, 
    p.nombreEmpresa AS nombreProveedor, 
    i.cveMateriaPrima, 
    m.nombreMateria
FROM 
    ingresoMaterial_tbl i
INNER JOIN 
    proveedor_tbl p ON i.cveProveedor = p.cveProveedor
INNER JOIN 
    materiaPrima_tbl m ON i.cveMateriaPrima = m.cveMateriaPrima
ORDER BY 
    i.cveIngresoMaterial DESC;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `TABLA_INGRESOMATERIAL_PROV_MAT` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `TABLA_INGRESOMATERIAL_PROV_MAT`()
BEGIN
SELECT 
        i.cveIngresoMaterial, 
        i.detallePedido, 
        i.estado,
        CASE i.estado
            WHEN 0 THEN 'EN ESPERA'
            WHEN 1 THEN 'EN ALMACÉN'
            ELSE 'ESTADO DESCONOCIDO'
        END AS estado_descripcion, 
        i.cantidadPedido, 
        i.fechaPedido, 
        i.fechaIngreso, 
        i.costoTotal, 
        i.cveProveedor, 
        p.nombreEmpresa AS nombreProveedor, 
        i.cveMateriaPrima, 
        m.nombreMateria
    FROM 
        ingresoMaterial_tbl i
    INNER JOIN 
        proveedor_tbl p ON i.cveProveedor = p.cveProveedor
    INNER JOIN 
        materiaPrima_tbl m ON i.cveMateriaPrima = m.cveMateriaPrima
	ORDER BY 
    i.cveIngresoMaterial DESC;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `TABLA_PROVEEDOR_CIUDAD` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `TABLA_PROVEEDOR_CIUDAD`(
)
BEGIN
SELECT p.cveProveedor, p.nombreEmpresa, p.nombreEncargado, p.apePatEncargado, p.apeMatEncargado, p.telefonoProveedor, p.correoProveedor, p.rfc, p.codPostal, c.nombreCiudad
FROM proveedor_tbl p
JOIN ciudad_tbl c ON p.codPostal = c.codPostal;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-21 20:37:51
