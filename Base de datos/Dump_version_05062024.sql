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

    drop database if exists almacen_db;
    create database almacen_db;
    use almacen_db;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudad_tbl`
--

LOCK TABLES `ciudad_tbl` WRITE;
/*!40000 ALTER TABLE `ciudad_tbl` DISABLE KEYS */;
INSERT INTO `ciudad_tbl` VALUES ('70000','JUCHITAN DE ZARAGOZA'),('70001','Ciudad de México'),('70002','Guadalajara'),('70003','Monterrey'),('70004','Puebla'),('70005','Toluca'),('70006','Tijuana'),('70007','León'),('70008','Ciudad Juárez'),('70009','Zapopan'),('70010','San Luis Potosí'),('70011','Querétaro'),('70012','Mérida'),('70013','Aguascalientes'),('70014','Hermosillo'),('70015','Mexicali'),('70016','Morelia'),('70017','Culiacán'),('70018','Saltillo'),('70019','Chihuahua'),('70020','Tampico'),('70021','Villahermosa'),('70022','Veracruz'),('70023','Cancún'),('70024','Reynosa'),('70025','Torreón'),('70026','San Nicolás de los Garza'),('70027','Irapuato'),('70028','Nuevo Laredo'),('70029','Durango'),('70030','Tepic'),('70031','Coatzacoalcos'),('70032','Xalapa'),('70033','Celaya'),('70034','Matamoros'),('70035','Acapulco'),('70036','Cuernavaca'),('70037','Tuxtla Gutiérrez'),('70038','Mazatlán'),('70039','Ensenada'),('70040','Colima'),('70041','La Paz'),('70042','Uruapan'),('70043','Pachuca'),('70044','Oaxaca'),('70045','Tuxpan'),('70046','Chetumal'),('70047','Tehuacán'),('70048','Poza Rica'),('70049','Mazatlán'),('70050','Playa del Carmen'),('70051','Guanajuato'),('70052','San Juan del Río'),('70053','Nogales'),('70054','Guaymas'),('70055','Victoria'),('70056','Tapachula'),('70057','Carmen'),('70058','Delicias'),('70059','Fresnillo'),('70060','Los Mochis'),('70061','Zamora'),('70062','Guadalupe'),('70063','Cabo San Lucas'),('70064','Chilpancingo'),('70065','Coatepec'),('70066','Comalcalco'),('70067','Cozumel'),('70068','Cuautitlán'),('70069','Fortín de las Flores'),('70070','Iguala'),('70071','Juchitán de Zaragoza'),('70072','Minatitlán'),('70073','Navojoa'),('70074','Orizaba'),('70075','San Cristóbal de las Casas'),('70076','San Pedro Garza García'),('70077','Soledad de Graciano Sánchez'),('70078','Tecomán'),('70079','Tulancingo'),('70080','Valle de Bravo'),('70081','Zacatecas'),('70082','Zapopan'),('70083','Zumpango'),('70084','Apatzingán'),('70085','Camargo'),('70086','Cárdenas'),('70087','Cintalapa'),('70088','Ciudad del Carmen'),('70089','Ciudad Obregón'),('70090','Cosamaloapan'),('70091','Frontera'),('70092','Huejutla'),('70093','Huatulco'),('70094','Ixtapa'),('70095','La Barca'),('70096','Lagos de Moreno'),('70097','Linares'),('70098','Nacozari de García'),('70099','Pánuco'),('70100','Piedras Negras'),('70101','Naucalpan'),('70102','Nezahualcóyotl'),('70103','Santa Catarina'),('70104','Cuautla'),('70105','Tlaxcala'),('70106','San Juan de los Lagos'),('70107','Puerto Vallarta'),('70108','Piedras Negras'),('70109','Salamanca'),('70110','San Martín Texmelucan'),('70111','Tehuacán'),('70112','Tequisquiapan'),('70113','Atlacomulco'),('70114','Chetumal'),('70115','Zacapu'),('70116','Zinapécuaro'),('70117','Apizaco'),('70118','Tejupilco'),('70119','Huajuapan de León'),('70120','Texcoco'),('70121','Ciudad Acuña'),('70122','Monclova'),('70123','Cabo San Lucas'),('70124','La Paz'),('70125','XADANI'),('70126','San Felipe'),('70127','Tecate'),('70128','Ensenada'),('70129','Rosarito'),('70130','Playas de Tijuana'),('70131','San Quintín'),('70132','Guaymas'),('70133','Navojoa'),('70134','Huatabampo'),('70135','Magdalena de Kino'),('70136','Cananea'),('70137','Agua Prieta'),('70138','Nacozari de García'),('70139','Hermosillo'),('70140','Caborca'),('70141','Santa Ana'),('70142','Álamos'),('70143','Ciudad Obregón'),('70144','San Luis Río Colorado'),('70145','Empalme'),('70146','Nogales'),('70147','Guadalupe Victoria'),('70148','San Miguel de Allende'),('70149','Celaya'),('70150','Guanajuato'),('70151','Irapuato'),('70152','León'),('70153','Salamanca'),('70154','Silao'),('70155','Valle de Santiago'),('70156','San Francisco del Rincón'),('70157','San Luis de la Paz'),('70158','Salvatierra'),('70159','San Miguel de Allende'),('70160','Dolores Hidalgo'),('70161','Pénjamo'),('70162','Yuriria'),('70163','Uriangato'),('70164','Acámbaro'),('70165','Moroleón'),('70166','Cortazar'),('70167','San José Iturbide'),('70168','Tarimoro'),('70169','Villagrán'),('70170','Santa Cruz de Juventino Rosas'),('70171','Comonfort'),('70172','Doctor Mora'),('70173','Huanímaro'),('70174','Jaral del Progreso'),('70175','Ocampo'),('70176','Pueblo Nuevo'),('70177','Romita'),('70178','San Diego de la Unión'),('70179','San Felipe'),('70180','Apaseo el Alto'),('70181','Apaseo el Grande'),('70182','Cuerámaro'),('70183','Manuel Doblado'),('70184','Victoria'),('70185','Santa Catarina'),('70186','General Cepeda'),('70187','Parras de la Fuente'),('70188','Arteaga'),('70189','Ramos Arizpe'),('70190','San Buenaventura'),('70191','Nadadores'),('70192','Frontera'),('70193','Sabinas'),('70194','Piedras Negras'),('70195','Ciudad Acuña'),('70196','Allende'),('70197','Morelos'),('70198','Múzquiz'),('70199','Zaragoza'),('70200','ALVARO OBREGON'),('70201','Nava'),('70202','Sacramento'),('70203','Lamadrid'),('70204','Cuatro Ciénegas'),('70205','San Pedro de las Colonias'),('70206','Francisco I. Madero'),('70207','Matamoros'),('70208','Viesca'),('70209','Ocampo'),('70210','Sierra Mojada'),('70211','Torreón'),('70212','Saltillo'),('70213','Monclova'),('70214','San Buenaventura'),('70215','Candela'),('70216','Abasolo'),('70217','Escobedo'),('70218','Progreso'),('70219','Castaños'),('70220','Piedras Negras'),('70221','Ciudad Acuña'),('70222','Jiménez'),('70223','Ahumada'),('70224','Buenaventura'),('70225','Casas Grandes'),('70226','Chihuahua'),('70227','Ciudad Juárez'),('70228','Delicias'),('70229','Hidalgo del Parral'),('70230','Cuauhtémoc'),('70231','Ojinaga'),('70232','Camargo'),('70233','Jiménez'),('70234','Meoqui'),('70235','Guerrero'),('70236','Aldama'),('70237','Madera'),('70238','Guadalupe y Calvo'),('70239','Nuevo Casas Grandes'),('70240','Saucillo'),('70241','San Francisco de Conchos'),('70242','Santa Bárbara'),('70243','Namiquipa'),('70244','San Francisco del Oro'),('70245','Bachíniva'),('70246','Rosales'),('70247','Temósachic'),('70248','Ascensión'),('70249','Galeana'),('70250','Janos'),('70251','Matamoros'),('70252','Cuernavaca'),('70253','Iguala'),('70254','Taxco'),('70255','Chilpancingo'),('70256','Acapulco'),('70257','Zihuatanejo'),('70258','Petatlán'),('70259','Tecpan de Galeana'),('70260','Atoyac de Álvarez'),('70261','Coyuca de Benítez'),('70262','Chilapa de Álvarez'),('70263','Tlapa de Comonfort'),('70264','Igualapa'),('70265','Ometepec'),('70266','Xochistlahuaca'),('70267','Ayutla de los Libres'),('70268','San Marcos'),('70269','Florencio Villarreal'),('70270','Tecoanapa'),('70271','Azoyú'),('70272','Copala'),('70273','Cuautepec'),('70274','Cuajinicuilapa'),('70275','Copanatoyac'),('70276','Alpoyeca'),('70277','Atlixtac'),('70278','Atlamajalcingo del Monte'),('70279','Acatepec'),('70280','Olinalá'),('70281','Cualác'),('70282','Huamuxtitlán'),('70283','Xochihuehuetlán'),('70284','Tlalixtaquilla'),('70285','Alcozauca de Guerrero'),('70286','Metlatónoc'),('70287','Atlamajalcingo del Monte'),('70288','Cochoapa el Grande'),('70289','Malinaltepec'),('70290','Tlacoapa'),('70291','Zitlala'),('70292','Mártir de Cuilapan'),('70293','Quechultenango'),('70294','Tixtla de Guerrero'),('70295','Ahuacuotzingo'),('70296','Chilpancingo de los Bravo'),('70297','Eduardo Neri'),('70298','Heliodoro Castillo'),('70299','General Canuto A. Neri'),('70300','San Luis Acatlán');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingresomaterial_tbl`
--

LOCK TABLES `ingresomaterial_tbl` WRITE;
/*!40000 ALTER TABLE `ingresomaterial_tbl` DISABLE KEYS */;
INSERT INTO `ingresomaterial_tbl` VALUES ('IAG-01','PRIMER INGRESO',_binary '',10,'2024-05-21 09:37:32','2024-5-20',10000,'MSC-01','MSC-01'),('IAG-02','DOS',_binary '',40,'2024-05-23 20:18:50','2024-5-30',19921,'AGA-01','AGA-01'),('IAG-03','TRES',_binary '',8,'2024-05-23 20:26:07','2024-5-29',18821,'MSC-01','MSC-01'),('IAG-04','CUATRO',_binary '',10,'2024-05-25 20:22:38','2024-5-28',18912,'MSC-01','MSC-01'),('ISP-01','PRIMERA DE SEPTIEMBRE',_binary '',10,'2024-05-26 16:11:05','2024-5-31',68123,'MSC-01','MSC-01');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materiaprima_tbl`
--

LOCK TABLES `materiaprima_tbl` WRITE;
/*!40000 ALTER TABLE `materiaprima_tbl` DISABLE KEYS */;
INSERT INTO `materiaprima_tbl` VALUES ('ADT-01','AIRE DEL TROPICO',0,0),('AGA-01','AGUA DEL TROPICO',0,100),('GDT-01','GAS LP DEL TROPICO',0,130),('MSC-01','MASECA',20,70),('PDT-01','PAPEL DEL TROPICO',10,9);
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor_tbl`
--

LOCK TABLES `proveedor_tbl` WRITE;
/*!40000 ALTER TABLE `proveedor_tbl` DISABLE KEYS */;
INSERT INTO `proveedor_tbl` VALUES ('AGA-01','AGUA DEL TROPICO','AGUA DEL TROPICO','CARO','QUINTERO','9711581911','quintero@gmail.com','1234567899012','70125'),('GTP-01','GAS DEL TROPICO','CARLOS','LOPEZ','BARTOLIN','9883111231','','18128312G1231','70200'),('MSC-01','MASECA SA CV','MASECA SA CV','GUERRA','SANTIAGO','9711112233','maseca@gmail.com','1234567890123','70125'),('PDT-01','PAPEL DEL TROPICO','JESUS','RAMOS','PINEDA','972','yatienecorreo@gmail.com','123988888112P','70000');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salidamaterial_tbl`
--

LOCK TABLES `salidamaterial_tbl` WRITE;
/*!40000 ALTER TABLE `salidamaterial_tbl` DISABLE KEYS */;
INSERT INTO `salidamaterial_tbl` VALUES ('SLN-24241',10,'2024-05-24 10:03:17','PARA PRODUCCION','GDT-01'),('SLN-24242',30,'2024-05-25 21:29:52','','AGA-01'),('SLN-24243',20,'2024-05-25 21:44:13','PRODUCCION','AGA-01'),('SLN-24245',50,'2024-05-25 21:28:00','','MSC-01'),('SSA-06241',10,'2024-05-23 21:33:53','primera salida','MSC-01');
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
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `prueba`()
BEGIN
SELECT 
        sm.cveSalidaMaterial,
		mp.nombreMateria, 
        sm.cantidadSalida,
        mp.stockMinimo, 
        mp.cantidadDisp,
		sm.detalleSalida
    FROM 
        salidaMaterial_tbl sm
    INNER JOIN 
        materiaPrima_tbl mp ON sm.cveMateriaPrima = mp.cveMateriaPrima;
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
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `TABLA_PROVEEDOR_CIUDAD`(
)
BEGIN
SELECT p.cveProveedor, p.rfc, p.nombreEmpresa, p.nombreEncargado, p.apePatEncargado, p.apeMatEncargado, p.telefonoProveedor, p.correoProveedor, p.rfc, p.codPostal, c.nombreCiudad
FROM proveedor_tbl p
JOIN ciudad_tbl c ON p.codPostal = c.codPostal;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `TABLA_SALIDA_MAT_PRIMA` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `TABLA_SALIDA_MAT_PRIMA`()
BEGIN
SELECT 
        sm.cveSalidaMaterial,
		mp.nombreMateria, 
        sm.cantidadSalida,
        mp.stockMinimo, 
        mp.cantidadDisp,
		sm.detalleSalida
    FROM 
        salidaMaterial_tbl sm
    INNER JOIN 
        materiaPrima_tbl mp ON sm.cveMateriaPrima = mp.cveMateriaPrima;
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

-- Dump completed on 2024-06-05 18:36:45
