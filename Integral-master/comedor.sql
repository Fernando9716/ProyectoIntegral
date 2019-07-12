CREATE DATABASE  IF NOT EXISTS `comedor` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `comedor`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: comedor
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.28-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente_factura`
--

DROP TABLE IF EXISTS `cliente_factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente_factura` (
  `idCliente_Factura` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `RFC` varchar(45) DEFAULT NULL,
  `razonSocial` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCliente_Factura`),
  UNIQUE KEY `idCliente_Factura_UNIQUE` (`idCliente_Factura`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente_factura`
--

LOCK TABLES `cliente_factura` WRITE;
/*!40000 ALTER TABLE `cliente_factura` DISABLE KEYS */;
INSERT INTO `cliente_factura` VALUES (1,'F9R3M0','Id Erat Etiam Company','2659 Nisl St.','dolor.sit.amet@necmalesuadaut.org',522622583),(2,'Q0V4P8','Vitae Consulting','7546 Mus. St.','massa.Suspendisse.eleifend@Suspendissealiquet',559278476),(3,'E3D0A3','Vel Turpis Aliquam Associates','1798 Amet, St.','id.libero@cubilia.ca',905491080),(4,'A6H4E6','Hendrerit Neque Associates','404-9943 Taciti Rd.','accumsan@diam.com',185249758),(5,'O4K9G3','Gravida Aliquam Inc.','855-6393 Mus. Ave','erat.nonummy@nisi.net',938617343),(6,'I1F9S1','Dapibus Corporation','4951 Proin St.','tincidunt@nibhDonecest.net',690294104),(7,'Z9S9F8','Ligula Eu LLC','Ap #771-6679 Mattis. Avenue','fermentum.fermentum@Nunc.edu',930017288),(8,'S4C3T6','Mi Tempor Industries','Ap #100-6394 Feugiat Road','magnis.dis@Namac.edu',877759807),(9,'M6I2Q5','Euismod Incorporated','Ap #421-796 Ipsum Avenue','nec.cursus.a@Crasvehicula.org',582063939),(10,'Y0Z6N1','Ipsum Sodales Purus Company','593-8767 Integer Street','nunc@placerat.org',462389458);
/*!40000 ALTER TABLE `cliente_factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente_ordendomicilio`
--

DROP TABLE IF EXISTS `cliente_ordendomicilio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente_ordendomicilio` (
  `idorden` int(10) unsigned NOT NULL,
  `idCliente` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idorden`),
  UNIQUE KEY `idorden_UNIQUE` (`idorden`),
  KEY `foraneaClienteDomicilio_idx` (`idCliente`),
  CONSTRAINT `foraneaClienteDomicilio` FOREIGN KEY (`idCliente`) REFERENCES `clientedomicilio` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `foraneaOrden` FOREIGN KEY (`idorden`) REFERENCES `orden` (`idOrden`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente_ordendomicilio`
--

LOCK TABLES `cliente_ordendomicilio` WRITE;
/*!40000 ALTER TABLE `cliente_ordendomicilio` DISABLE KEYS */;
INSERT INTO `cliente_ordendomicilio` VALUES (2,2),(4,2),(6,3),(8,4),(10,5);
/*!40000 ALTER TABLE `cliente_ordendomicilio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente_ordenmesa`
--

DROP TABLE IF EXISTS `cliente_ordenmesa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente_ordenmesa` (
  `idorden` int(10) unsigned NOT NULL,
  `num_mesa` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idorden`),
  UNIQUE KEY `idorden_UNIQUE` (`idorden`),
  KEY `foraneaClienteOrdenMesa_OrdenMesa_idx` (`num_mesa`),
  CONSTRAINT `foraneaClienteOrdenMesa_OrdenMesa` FOREIGN KEY (`num_mesa`) REFERENCES `ordenmesa` (`num_mesa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `foranea_ClienteOrdenMesaOrden` FOREIGN KEY (`idorden`) REFERENCES `cliente_ordenrestaurante` (`idorden`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente_ordenmesa`
--

LOCK TABLES `cliente_ordenmesa` WRITE;
/*!40000 ALTER TABLE `cliente_ordenmesa` DISABLE KEYS */;
INSERT INTO `cliente_ordenmesa` VALUES (1,1),(3,1),(5,1),(7,1),(9,1);
/*!40000 ALTER TABLE `cliente_ordenmesa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente_ordenrestaurante`
--

DROP TABLE IF EXISTS `cliente_ordenrestaurante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente_ordenrestaurante` (
  `idorden` int(10) unsigned NOT NULL,
  `idclienteRes` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idorden`),
  UNIQUE KEY `idorden_UNIQUE` (`idorden`),
  KEY `foranea_ordenResCllienteRes_idx` (`idclienteRes`),
  CONSTRAINT `foranea_ordenResCllienteRes` FOREIGN KEY (`idclienteRes`) REFERENCES `clienterestaurante` (`idclienteRes`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `foranea_ordenresOrden` FOREIGN KEY (`idorden`) REFERENCES `orden` (`idOrden`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente_ordenrestaurante`
--

LOCK TABLES `cliente_ordenrestaurante` WRITE;
/*!40000 ALTER TABLE `cliente_ordenrestaurante` DISABLE KEYS */;
INSERT INTO `cliente_ordenrestaurante` VALUES (1,1),(3,1),(5,2),(7,3),(9,4);
/*!40000 ALTER TABLE `cliente_ordenrestaurante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientedomicilio`
--

DROP TABLE IF EXISTS `clientedomicilio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientedomicilio` (
  `idCliente` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCliente`),
  UNIQUE KEY `idCliente_UNIQUE` (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientedomicilio`
--

LOCK TABLES `clientedomicilio` WRITE;
/*!40000 ALTER TABLE `clientedomicilio` DISABLE KEYS */;
INSERT INTO `clientedomicilio` VALUES (1,'Nyssa Lewis','Ap #926-882 Integer Rd.'),(2,'Aline Henderson','581-1202 Semper. Av.'),(3,'Mary English','9492 Purus. Ave'),(4,'Ruth Good','P.O. Box 214, 4523 Et Rd.'),(5,'Risa Turner','P.O. Box 758, 1250 Venenatis Ave'),(6,'Jessica Carrillo','548-7550 Lacinia Av.'),(7,'Wendy Horton','Ap #781-7082 Pede, Road'),(8,'Maggy Cooper','384-6141 Integer St.'),(9,'Samantha Ellison','Ap #824-5497 Rhoncus Street'),(10,'Marcia Fischer','509-4222 Tristique Street');
/*!40000 ALTER TABLE `clientedomicilio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clienterestaurante`
--

DROP TABLE IF EXISTS `clienterestaurante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clienterestaurante` (
  `idclienteRes` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `sexo` varchar(10) DEFAULT NULL,
  `color` varchar(15) DEFAULT NULL,
  `edadBiologica` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`idclienteRes`),
  UNIQUE KEY `idcliente_UNIQUE` (`idclienteRes`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clienterestaurante`
--

LOCK TABLES `clienterestaurante` WRITE;
/*!40000 ALTER TABLE `clienterestaurante` DISABLE KEYS */;
INSERT INTO `clienterestaurante` VALUES (1,'hombre','negro','mayor'),(2,'mujer','amarillo','señor'),(3,'hombre','rosa','niño'),(4,'mujer','negro','adulto'),(5,'nose','verde','joven');
/*!40000 ALTER TABLE `clienterestaurante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `factura` (
  `idfactura` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_venta` int(10) unsigned NOT NULL,
  `idClienteFactura` int(10) unsigned NOT NULL,
  `fecha` date DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idfactura`),
  UNIQUE KEY `idfactura_UNIQUE` (`idfactura`),
  KEY `foraneaFactura_venta_idx` (`id_venta`),
  KEY `foraneaFactura_ClienteFactura_idx` (`idClienteFactura`),
  CONSTRAINT `foraneaFactura_ClienteFactura` FOREIGN KEY (`idClienteFactura`) REFERENCES `cliente_factura` (`idCliente_Factura`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `foraneaFactura_venta` FOREIGN KEY (`id_venta`) REFERENCES `venta` (`idventa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
INSERT INTO `factura` VALUES (1,1,1,'2018-12-04','pendiente'),(2,2,1,'2018-12-04','hecho'),(3,3,2,'2018-12-04','pendiente'),(4,4,3,'2018-12-04','hecho'),(5,5,6,'2018-12-04','pendiente'),(6,6,4,'2018-12-04','hecho'),(7,7,10,'2018-12-04','hecho');
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `idmenu` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idmenu`),
  UNIQUE KEY `idmenu_UNIQUE` (`idmenu`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'del dia'),(2,'a la carta');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orden`
--

DROP TABLE IF EXISTS `orden`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orden` (
  `idorden` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fecha` datetime DEFAULT NULL,
  `tipo` varchar(20) DEFAULT NULL,
  `estadoOrden` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idorden`),
  UNIQUE KEY `idorden_UNIQUE` (`idorden`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orden`
--

LOCK TABLES `orden` WRITE;
/*!40000 ALTER TABLE `orden` DISABLE KEYS */;
INSERT INTO `orden` VALUES (1,'2018-12-04 00:00:00','restaurante','tomado'),(2,'2018-12-04 00:00:00','domicilio','atendido'),(3,'2018-12-04 00:00:00','restaurante','pagado'),(4,'2018-12-04 00:00:00','domicilio','tomado'),(5,'2018-12-04 00:00:00','restaurante','atendido'),(6,'2018-12-04 00:00:00','domicilio','pagado'),(7,'2018-12-04 00:00:00','restaurante','tomado'),(8,'2018-12-04 00:00:00','domicilio','atendido'),(9,'2018-12-04 00:00:00','restaurante','pagado'),(10,'2018-12-04 00:00:00','domicilio','tomado');
/*!40000 ALTER TABLE `orden` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orden_producto`
--

DROP TABLE IF EXISTS `orden_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orden_producto` (
  `idorden` int(10) unsigned NOT NULL,
  `idproducto` int(10) unsigned NOT NULL,
  `observacion` varchar(45) DEFAULT NULL,
  `cantidad` int(2) DEFAULT NULL,
  PRIMARY KEY (`idorden`,`idproducto`),
  KEY `foraneaOrdenProducto_producto_idx` (`idproducto`),
  CONSTRAINT `foraneaOrdenProducto_Orden` FOREIGN KEY (`idorden`) REFERENCES `orden` (`idOrden`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `foraneaOrdenProducto_producto` FOREIGN KEY (`idproducto`) REFERENCES `producto` (`idproducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orden_producto`
--

LOCK TABLES `orden_producto` WRITE;
/*!40000 ALTER TABLE `orden_producto` DISABLE KEYS */;
INSERT INTO `orden_producto` VALUES (1,1,'erty',1),(1,2,'werty',2),(1,3,'werty',1),(2,2,'erty',1),(2,3,'werty',1),(3,1,'dfgh',1),(3,2,'cvb',1),(3,10,'cvbn',1),(4,7,'',1),(4,8,'',1),(5,1,'cvbn',1),(6,1,'ertyhujkolp',1),(6,7,'dfghj',1),(6,10,'wertyuio ertyujertyu erfgh',2),(7,5,'',2),(7,6,'sedrftgyh',1),(8,3,'sdfghjedrftyu dfghjkdfghj',2),(8,4,'',1),(9,1,'',2),(10,1,'',1);
/*!40000 ALTER TABLE `orden_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orden_utensilio`
--

DROP TABLE IF EXISTS `orden_utensilio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orden_utensilio` (
  `idorden` int(10) unsigned NOT NULL,
  `idutensilio` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idorden`,`idutensilio`),
  KEY `foraneaOrdenUtencilio-utencilio_idx` (`idutensilio`),
  CONSTRAINT `foraneaOrdenUtencilio-utencilio` FOREIGN KEY (`idutensilio`) REFERENCES `utensilio` (`idutensilio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `foraneaOrdenUtencilio_orden` FOREIGN KEY (`idorden`) REFERENCES `orden` (`idOrden`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orden_utensilio`
--

LOCK TABLES `orden_utensilio` WRITE;
/*!40000 ALTER TABLE `orden_utensilio` DISABLE KEYS */;
INSERT INTO `orden_utensilio` VALUES (2,1),(2,3),(4,2),(4,5),(6,2),(6,10),(8,5),(8,9),(10,3),(10,7);
/*!40000 ALTER TABLE `orden_utensilio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orden_venta`
--

DROP TABLE IF EXISTS `orden_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orden_venta` (
  `idorden` int(10) unsigned NOT NULL,
  `idventa` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idorden`),
  UNIQUE KEY `idorden_UNIQUE` (`idorden`),
  KEY `foraneaOrdenVenta_Venta_idx` (`idventa`),
  CONSTRAINT `foraaneaOrden_OrdenVenta` FOREIGN KEY (`idorden`) REFERENCES `orden` (`idOrden`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `foraneaOrdenVenta_Venta` FOREIGN KEY (`idventa`) REFERENCES `venta` (`idventa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orden_venta`
--

LOCK TABLES `orden_venta` WRITE;
/*!40000 ALTER TABLE `orden_venta` DISABLE KEYS */;
INSERT INTO `orden_venta` VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7);
/*!40000 ALTER TABLE `orden_venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordenmesa`
--

DROP TABLE IF EXISTS `ordenmesa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordenmesa` (
  `num_mesa` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `estado` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`num_mesa`),
  UNIQUE KEY `num_mesa_UNIQUE` (`num_mesa`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordenmesa`
--

LOCK TABLES `ordenmesa` WRITE;
/*!40000 ALTER TABLE `ordenmesa` DISABLE KEYS */;
INSERT INTO `ordenmesa` VALUES (1,'ocupado'),(2,'ocupado'),(3,'desocupado'),(4,'ocupado'),(5,'desocupado'),(6,'desocupado'),(7,'desocupado'),(8,'desocupado'),(9,'desocupado'),(11,'ocupado'),(12,'ocupado'),(13,'ocupado');
/*!40000 ALTER TABLE `ordenmesa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `idproducto` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idmenu` int(10) unsigned NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `precio` float DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `clasificacion` varchar(20) DEFAULT NULL,
  `tipo` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idproducto`),
  UNIQUE KEY `idproducto_UNIQUE` (`idproducto`),
  KEY `foraneaMenu_idx` (`idmenu`),
  CONSTRAINT `foraneaMenu` FOREIGN KEY (`idmenu`) REFERENCES `menu` (`idmenu`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,1,'Chhattisgarh','descripcion',61,1,'bebida, comida','sem. Nulla'),(2,2,'BC','descripcion',55,5,'bebida, comida','orci'),(3,2,'Zeeland','descripcion',59,9,'bebida, comida','quam.'),(4,1,'MA','descripcion',56,6,'bebida, comida','euismod et, commodo'),(5,2,'CA','descripcion',60,4,'bebida, comida','hymenaeos.'),(6,2,'Murcia','descripcion',41,8,'bebida, comida','imperdiet ornare. In'),(7,1,'RS','descripcion',60,9,'bebida, comida','justo'),(8,1,'MP','descripcion',49,5,'bebida, comida','Aliquam'),(9,2,'WB','descripcion',52,9,'bebida, comida','euismod'),(10,1,'Ist','descripcion',61,10,'bebida, comida','tristique aliquet. P');
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto_compuesto`
--

DROP TABLE IF EXISTS `producto_compuesto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto_compuesto` (
  `idproductoCompuesto` int(10) unsigned NOT NULL,
  `idProducto` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idproductoCompuesto`,`idProducto`),
  KEY `ForaneaProductoCompuesto_Producto_idx` (`idProducto`),
  CONSTRAINT `ForaneaProductoCompuesto_Producto` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idproducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto_compuesto`
--

LOCK TABLES `producto_compuesto` WRITE;
/*!40000 ALTER TABLE `producto_compuesto` DISABLE KEYS */;
INSERT INTO `producto_compuesto` VALUES (1,1),(1,2),(1,3),(2,2),(2,3),(3,1),(3,2),(3,10),(4,7),(4,8),(5,1),(6,1),(6,7),(6,10),(7,5),(7,6),(8,3),(8,4),(9,1),(10,1);
/*!40000 ALTER TABLE `producto_compuesto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utensilio`
--

DROP TABLE IF EXISTS `utensilio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `utensilio` (
  `idutensilio` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `cantidad` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idutensilio`),
  UNIQUE KEY `idutensilio_UNIQUE` (`idutensilio`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utensilio`
--

LOCK TABLES `utensilio` WRITE;
/*!40000 ALTER TABLE `utensilio` DISABLE KEYS */;
INSERT INTO `utensilio` VALUES (1,'Armenia','7'),(2,'Jersey','6'),(3,'Niger','10'),(4,'Mongolia','10'),(5,'Libya','6'),(6,'Australia','7'),(7,'Croatia','5'),(8,'Guadeloupe','8'),(9,'United Kingdom (Great Britain)','5'),(10,'Mauritania','8'),(11,'Somalia','10'),(12,'Mauritius','6'),(13,'Indonesia','6'),(14,'Antarctica','6'),(15,'Western Sahara','6'),(16,'Mozambique','7'),(17,'Ukraine','6'),(18,'Gibraltar','9'),(19,'Costa Rica','6'),(20,'Malta','5');
/*!40000 ALTER TABLE `utensilio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venta` (
  `idventa` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `subtotal` float DEFAULT NULL,
  `total` float NOT NULL,
  PRIMARY KEY (`idventa`),
  UNIQUE KEY `idventa_UNIQUE` (`idventa`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES (1,345,345),(2,234,234),(3,712,342),(4,123,123),(5,213,212),(6,211,211),(7,111,111);
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-01 18:49:44
