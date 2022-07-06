-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: tabeldata
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `dosen`
--

DROP TABLE IF EXISTS `dosen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dosen` (
  `NIDN` int NOT NULL,
  `NAMA` varchar(45) NOT NULL,
  `JK` varchar(45) NOT NULL,
  `MKDIAJAR` varchar(45) NOT NULL,
  PRIMARY KEY (`NIDN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dosen`
--

LOCK TABLES `dosen` WRITE;
/*!40000 ALTER TABLE `dosen` DISABLE KEYS */;
INSERT INTO `dosen` VALUES (90128771,'Arya Kumbara','L','OOAD'),(90132781,'Zainab Maryam','P','Akuntansi');
/*!40000 ALTER TABLE `dosen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mhs`
--

DROP TABLE IF EXISTS `mhs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mhs` (
  `NIM` int NOT NULL,
  `NAMA` varchar(45) NOT NULL,
  `JURUSAN` varchar(45) NOT NULL,
  `JK` varchar(45) NOT NULL,
  `TGLLAHIR` date NOT NULL,
  PRIMARY KEY (`NIM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mhs`
--

LOCK TABLES `mhs` WRITE;
/*!40000 ALTER TABLE `mhs` DISABLE KEYS */;
INSERT INTO `mhs` VALUES (20103320,'Dani Pratama','KAB','L','2001-12-07'),(20103340,'Ahmad Dahlan','MTI','L','2000-01-12');
/*!40000 ALTER TABLE `mhs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mk`
--

DROP TABLE IF EXISTS `mk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mk` (
  `idmk` int NOT NULL,
  `NAMAMK` varchar(45) NOT NULL,
  PRIMARY KEY (`idmk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mk`
--

LOCK TABLES `mk` WRITE;
/*!40000 ALTER TABLE `mk` DISABLE KEYS */;
INSERT INTO `mk` VALUES (1345672,'Stastika'),(23456345,'OOP');
/*!40000 ALTER TABLE `mk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'tabeldata'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-06 21:56:56
