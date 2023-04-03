-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: project24
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bookings`
--

DROP TABLE IF EXISTS `bookings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookings` (
  `BookingID` int NOT NULL AUTO_INCREMENT,
  `ScheduleID` int NOT NULL,
  `PassengerID` int NOT NULL,
  `NumberOfSeats` int NOT NULL,
  `TotalCost` decimal(10,2) NOT NULL,
  `Status` varchar(10) DEFAULT 'Booked',
  `is_deleted` int DEFAULT '0',
  PRIMARY KEY (`BookingID`),
  KEY `ScheduleID` (`ScheduleID`),
  KEY `PassengerID` (`PassengerID`),
  CONSTRAINT `bookings_ibfk_1` FOREIGN KEY (`ScheduleID`) REFERENCES `schedules` (`ScheduleID`),
  CONSTRAINT `bookings_ibfk_2` FOREIGN KEY (`PassengerID`) REFERENCES `passenger` (`PassengerID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookings`
--

LOCK TABLES `bookings` WRITE;
/*!40000 ALTER TABLE `bookings` DISABLE KEYS */;
INSERT INTO `bookings` VALUES (6,1,6,2,1600.00,'cancelled',0),(8,2,7,4,7872.00,'Cancelled',0),(9,1,7,3,2400.00,'Booked',0),(10,1,7,3,2400.00,'Cancelled',0),(11,1,6,3,2400.00,'Cancelled',0),(12,3,7,2,3108.00,'Cancelled',0),(13,6,7,2,1384.00,'Cancelled',0),(14,6,7,2,1384.00,'Cancelled',0),(15,6,10,2,1384.00,'Cancelled',0);
/*!40000 ALTER TABLE `bookings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `buses`
--

DROP TABLE IF EXISTS `buses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `buses` (
  `BusID` int NOT NULL AUTO_INCREMENT,
  `BusNumber` varchar(50) NOT NULL,
  `BusType` varchar(50) NOT NULL,
  `TotalSeats` int NOT NULL,
  `is_deleted` int DEFAULT '0',
  PRIMARY KEY (`BusID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buses`
--

LOCK TABLES `buses` WRITE;
/*!40000 ALTER TABLE `buses` DISABLE KEYS */;
INSERT INTO `buses` VALUES (1,'BUS101','AC',45,1),(2,'BUS201','NON-AC',50,0),(3,'BUS301','Delux',40,0),(4,'BUS401','AC',50,0),(5,'BUS501','DELUX',60,0),(6,'BS601','NON-AC',40,0),(7,'701','NON-AC',45,0);
/*!40000 ALTER TABLE `buses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passenger`
--

DROP TABLE IF EXISTS `passenger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passenger` (
  `PassengerID` int NOT NULL AUTO_INCREMENT,
  `Password` varchar(100) NOT NULL,
  `mobileNumber` varchar(10) DEFAULT NULL,
  `userName` varchar(50) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `is_deleted` int DEFAULT '0',
  PRIMARY KEY (`PassengerID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passenger`
--

LOCK TABLES `passenger` WRITE;
/*!40000 ALTER TABLE `passenger` DISABLE KEYS */;
INSERT INTO `passenger` VALUES (1,'Gupta','122345','','',0),(2,'uplabdhi@1','89876778','','',0),(3,'12sh','8802345','rdjhpnsb','Shalu',0),(4,'riy12345','897239847',':I[yLr#efA','Riyansh',1),(5,'12','94835798','Anubh%4873','khushbu',0),(6,'1234','9911443355','Gaura$26','Anant',0),(7,'ranu@12','123459876','Ranu@943','Ranu',0),(8,'nishu@12','999999999','Nishu$44','Nishu',0),(9,'akku@12','2233445566','Akku&449','Akku',0),(10,'uppi@12','678868976','Uplab@13','Uplabdhi',0);
/*!40000 ALTER TABLE `passenger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `routes`
--

DROP TABLE IF EXISTS `routes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `routes` (
  `RouteID` int NOT NULL AUTO_INCREMENT,
  `SourceLocation` varchar(100) NOT NULL,
  `DestinationLocation` varchar(100) NOT NULL,
  `Distance` int NOT NULL,
  `is_deleted` int DEFAULT '0',
  PRIMARY KEY (`RouteID`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `routes`
--

LOCK TABLES `routes` WRITE;
/*!40000 ALTER TABLE `routes` DISABLE KEYS */;
INSERT INTO `routes` VALUES (1,'Delhi','Pune',400,1),(2,'Delhi','Gujrat',1000,0),(3,'Mumbai','Delhi',1150,0),(4,'Mumbai','Kolkata',2014,0),(5,'Mumbai','Chennai',1336,0),(6,'Mumbai','Bengaluru',984,0),(7,'Delhi','Kolkata',1474,0),(8,'Delhi','Chennai',2183,0),(9,'Delhi','Bengaluru',1743,0),(10,'Kolkata','Chennai',1659,0),(11,'Kolkata','Bengaluru',1871,0),(12,'Chennai','Bengaluru',346,0),(13,'Ahmedabad','Mumbai',531,0),(14,'Ahmedabad','Delhi',777,0),(15,'Ahmedabad','Kolkata',2069,0),(16,'Ahmedabad','Chennai',1747,0),(17,'Ahmedabad','Bengaluru',1482,0),(18,'Hyderabad','Mumbai',706,0),(19,'Hyderabad','Delhi',1543,0),(20,'Hyderabad','Kolkata',1468,0),(21,'Hyderabad','Chennai',628,0),(22,'Hyderabad','Bengaluru',569,0),(23,'Pune','Mumbai',149,0),(24,'Pune','Delhi',1182,0),(25,'Pune','Kolkata',1660,0),(26,'Pune','Chennai',1164,0),(27,'Pune','Bengaluru',734,0);
/*!40000 ALTER TABLE `routes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedules`
--

DROP TABLE IF EXISTS `schedules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schedules` (
  `ScheduleID` int NOT NULL AUTO_INCREMENT,
  `BusID` int NOT NULL,
  `RouteID` int NOT NULL,
  `DepartureTime` time NOT NULL,
  `ArrivalTime` time NOT NULL,
  `journeyDate` date NOT NULL,
  `is_deleted` int DEFAULT '0',
  `AvailableSeats` int NOT NULL,
  PRIMARY KEY (`ScheduleID`),
  KEY `BusID` (`BusID`),
  KEY `RouteID` (`RouteID`),
  CONSTRAINT `schedules_ibfk_1` FOREIGN KEY (`BusID`) REFERENCES `buses` (`BusID`),
  CONSTRAINT `schedules_ibfk_2` FOREIGN KEY (`RouteID`) REFERENCES `routes` (`RouteID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedules`
--

LOCK TABLES `schedules` WRITE;
/*!40000 ALTER TABLE `schedules` DISABLE KEYS */;
INSERT INTO `schedules` VALUES (1,2,1,'10:10:10','11:30:30','2023-04-01',0,0),(2,4,6,'01:00:00','05:00:00','2023-04-03',0,50),(3,5,14,'06:00:00','09:00:00','2023-04-03',0,60),(4,3,5,'13:00:00','09:00:00','2023-04-04',0,40),(5,6,9,'07:00:00','10:00:00','2023-04-04',0,40),(6,7,12,'07:00:00','10:00:00','2023-04-04',0,45);
/*!40000 ALTER TABLE `schedules` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wallet`
--

DROP TABLE IF EXISTS `wallet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wallet` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `balance` decimal(10,2) DEFAULT '0.00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wallet`
--

LOCK TABLES `wallet` WRITE;
/*!40000 ALTER TABLE `wallet` DISABLE KEYS */;
INSERT INTO `wallet` VALUES (1,6,'2023-04-02 07:43:53',2800.00),(2,7,'2023-04-02 14:23:59',33006.00),(3,10,'2023-04-03 06:35:23',8616.00);
/*!40000 ALTER TABLE `wallet` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-03 12:20:24
