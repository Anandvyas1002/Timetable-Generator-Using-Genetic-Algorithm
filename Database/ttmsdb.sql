-- MySQL dump 10.13  Distrib 5.1.54, for Win32 (ia32)
--
-- Host: localhost    Database: ttms_java
-- ------------------------------------------------------
-- Server version	5.1.54-community

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
-- Table structure for table `faculty`
--

DROP TABLE IF EXISTS `faculty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `faculty` (
  `faculty_id` int(8) NOT NULL AUTO_INCREMENT,
  `fname` varchar(30) DEFAULT NULL,
  `lname` varchar(30) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`faculty_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty`
--

LOCK TABLES `faculty` WRITE;
/*!40000 ALTER TABLE `faculty` DISABLE KEYS */;
INSERT INTO `faculty` VALUES (1,'Bhupendra','Panchal','bp@gmail.com','abc'),(2,'Sanjay','Pal','sp@gmail.com','abc'),(3,'Anubha','Prajapati','ap@gmail.com','abc'),(4,'Pankaj','Panday','pp@gmail.com','abc'),(5,'Ayushi','Arzare','aa@gmail.com','abc'),(6,'Harita','Bhargava','hb@gmail.com','abc');
/*!40000 ALTER TABLE `faculty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `module`
--

DROP TABLE IF EXISTS `module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `module` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `mid` int(4) DEFAULT NULL,
  `subcode` varchar(40) DEFAULT NULL,
  `fid` int(5) DEFAULT NULL,
  `sem` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `module`
--

LOCK TABLES `module` WRITE;
/*!40000 ALTER TABLE `module` DISABLE KEYS */;
INSERT INTO `module` VALUES (1,1,'cs71',1,7),(2,2,'cs72',2,7),(3,3,'cs73',3,7),(4,4,'cs74',4,7),(5,5,'cs75',5,7),(6,5,'cs75',4,7),(7,1,'cs71',6,7),(8,6,'CS8001',3,8);
/*!40000 ALTER TABLE `module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rooms`
--

DROP TABLE IF EXISTS `rooms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rooms` (
  `room_id` int(8) NOT NULL AUTO_INCREMENT,
  `room_name` varchar(30) DEFAULT NULL,
  `capacity` int(5) DEFAULT NULL,
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rooms`
--

LOCK TABLES `rooms` WRITE;
/*!40000 ALTER TABLE `rooms` DISABLE KEYS */;
INSERT INTO `rooms` VALUES (1,'tb11',200),(2,'tb12',200),(4,'tb13',250),(5,'tb15',420);
/*!40000 ALTER TABLE `rooms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `semester`
--

DROP TABLE IF EXISTS `semester`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `semester` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `semid` int(4) DEFAULT NULL,
  `sem` int(2) DEFAULT NULL,
  `batch` varchar(2) DEFAULT NULL,
  `capacity` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `semester`
--

LOCK TABLES `semester` WRITE;
/*!40000 ALTER TABLE `semester` DISABLE KEYS */;
INSERT INTO `semester` VALUES (1,71,7,'A',150),(2,72,7,'B',150),(3,81,8,'A',150),(4,82,8,'B',150),(5,31,3,'A',200);
/*!40000 ALTER TABLE `semester` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjects`
--

DROP TABLE IF EXISTS `subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subjects` (
  `sid` int(8) NOT NULL AUTO_INCREMENT,
  `subcode` varchar(20) DEFAULT NULL,
  `subname` varchar(30) DEFAULT NULL,
  `sem` int(3) DEFAULT NULL,
  `lpw` int(3) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjects`
--

LOCK TABLES `subjects` WRITE;
/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
INSERT INTO `subjects` VALUES (1,'cs71','DBMS',7,6),(2,'cs72','Dist. System',7,6),(3,'cs73','Compiler',7,6),(4,'cs74','ML',7,6),(5,'cs75','Web',7,6),(6,'CS8001','Soft Computing',8,5);
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timeslot`
--

DROP TABLE IF EXISTS `timeslot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `timeslot` (
  `id` int(4) NOT NULL,
  `day_no` int(2) DEFAULT NULL,
  `slot_no` int(3) DEFAULT NULL,
  `day_name` varchar(15) DEFAULT NULL,
  `time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timeslot`
--

LOCK TABLES `timeslot` WRITE;
/*!40000 ALTER TABLE `timeslot` DISABLE KEYS */;
INSERT INTO `timeslot` VALUES (1,1,1,'Mon','09:00 - 10:00'),(2,1,2,'Mon','10:00 - 11:00'),(3,1,3,'Mon','11:00 - 12:00'),(4,1,4,'Mon','13:00 - 14:00'),(5,1,5,'Mon','14:00 - 15:00'),(6,1,6,'Mon','15:00 - 16:00'),(7,2,1,'Tue','09:00 - 10:00'),(8,2,2,'Tue','10:00 - 11:00'),(9,2,3,'Tue','11:00 - 12:00'),(10,2,4,'Tue','13:00 - 14:00'),(11,2,5,'Tue','14:00 - 15:00'),(12,2,6,'Tue','15:00 - 16:00'),(13,3,1,'Wed','09:00 - 10:00'),(14,3,2,'Wed','10:00 - 11:00'),(15,3,3,'Wed','11:00 - 12:00'),(16,3,4,'Wed','13:00 - 14:00'),(17,3,5,'Wed','14:00 - 15:00'),(18,3,6,'Wed','15:00 - 16:00'),(19,4,1,'Thu','09:00 - 10:00'),(20,4,2,'Thu','10:00 - 11:00'),(21,4,3,'Thu','11:00 - 12:00'),(22,4,4,'Thu','13:00 - 14:00'),(23,4,5,'Thu','14:00 - 15:00'),(24,4,6,'Thu','15:00 - 16:00'),(25,5,1,'Fri','09:00 - 10:00'),(26,5,2,'Fri','10:00 - 11:00'),(27,5,3,'Fri','11:00 - 12:00'),(28,5,4,'Fri','13:00 - 14:00'),(29,5,5,'Fri','14:00 - 15:00'),(30,5,6,'Fri','15:00 - 16:00');
/*!40000 ALTER TABLE `timeslot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timetable`
--

DROP TABLE IF EXISTS `timetable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `timetable` (
  `class_id` int(3) NOT NULL,
  `sub_name` varchar(40) DEFAULT NULL,
  `sem` int(3) DEFAULT NULL,
  `batch` varchar(2) DEFAULT NULL,
  `room_name` varchar(30) DEFAULT NULL,
  `fac_name` varchar(50) DEFAULT NULL,
  `day_no` int(2) DEFAULT NULL,
  `slot_no` int(2) DEFAULT NULL,
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timetable`
--

LOCK TABLES `timetable` WRITE;
/*!40000 ALTER TABLE `timetable` DISABLE KEYS */;
INSERT INTO `timetable` VALUES (1,'Soft Computing',8,'A','tb11','Anubha Prajapati',3,5),(2,'Soft Computing',8,'A','tb12','Anubha Prajapati',4,1),(3,'Soft Computing',8,'A','tb11','Anubha Prajapati',1,6),(4,'Soft Computing',8,'A','tb12','Anubha Prajapati',2,4),(5,'Soft Computing',8,'A','tb11','Anubha Prajapati',3,2),(6,'Soft Computing',8,'B','tb15','Anubha Prajapati',2,3),(7,'Soft Computing',8,'B','tb11','Anubha Prajapati',5,3),(8,'Soft Computing',8,'B','tb11','Anubha Prajapati',5,1),(9,'Soft Computing',8,'B','tb11','Anubha Prajapati',2,2),(10,'Soft Computing',8,'B','tb13','Anubha Prajapati',1,1),(11,'DBMS',7,'A','tb12','Bhupendra Panchal',2,1),(12,'DBMS',7,'A','tb15','Bhupendra Panchal',3,5),(13,'DBMS',7,'A','tb15','Harita Bhargava',4,1),(14,'DBMS',7,'A','tb12','Harita Bhargava',1,4),(15,'DBMS',7,'A','tb15','Harita Bhargava',5,6),(16,'DBMS',7,'A','tb11','Harita Bhargava',4,4),(17,'Dist. System',7,'A','tb15','Sanjay Pal',4,6),(18,'Dist. System',7,'A','tb15','Sanjay Pal',2,2),(19,'Dist. System',7,'A','tb12','Sanjay Pal',2,5),(20,'Dist. System',7,'A','tb13','Sanjay Pal',2,3),(21,'Dist. System',7,'A','tb12','Sanjay Pal',5,4),(22,'Dist. System',7,'A','tb11','Sanjay Pal',3,1),(23,'Compiler',7,'A','tb13','Anubha Prajapati',1,5),(24,'Compiler',7,'A','tb13','Anubha Prajapati',5,5),(25,'Compiler',7,'A','tb12','Anubha Prajapati',4,2),(26,'Compiler',7,'A','tb15','Anubha Prajapati',1,3),(27,'Compiler',7,'A','tb12','Anubha Prajapati',3,3),(28,'Compiler',7,'A','tb12','Anubha Prajapati',4,5),(29,'ML',7,'A','tb12','Pankaj Panday',5,3),(30,'ML',7,'A','tb13','Pankaj Panday',1,6),(31,'ML',7,'A','tb15','Pankaj Panday',5,1),(32,'ML',7,'A','tb12','Pankaj Panday',1,1),(33,'ML',7,'A','tb15','Pankaj Panday',4,3),(34,'ML',7,'A','tb15','Pankaj Panday',1,2),(35,'Web',7,'A','tb15','Ayushi Arzare',3,2),(36,'Web',7,'A','tb15','Pankaj Panday',3,6),(37,'Web',7,'A','tb13','Pankaj Panday',5,2),(38,'Web',7,'A','tb12','Ayushi Arzare',2,6),(39,'Web',7,'A','tb13','Ayushi Arzare',2,4),(40,'Web',7,'A','tb12','Ayushi Arzare',3,4),(41,'DBMS',7,'B','tb13','Harita Bhargava',5,3),(42,'DBMS',7,'B','tb12','Bhupendra Panchal',4,3),(43,'DBMS',7,'B','tb12','Bhupendra Panchal',3,6),(44,'DBMS',7,'B','tb12','Bhupendra Panchal',2,3),(45,'DBMS',7,'B','tb12','Bhupendra Panchal',5,5),(46,'DBMS',7,'B','tb13','Bhupendra Panchal',5,1),(47,'Dist. System',7,'B','tb15','Sanjay Pal',3,3),(48,'Dist. System',7,'B','tb11','Sanjay Pal',4,5),(49,'Dist. System',7,'B','tb12','Sanjay Pal',1,2),(50,'Dist. System',7,'B','tb12','Sanjay Pal',5,2),(51,'Dist. System',7,'B','tb12','Sanjay Pal',1,6),(52,'Dist. System',7,'B','tb11','Sanjay Pal',1,1),(53,'Compiler',7,'B','tb13','Anubha Prajapati',3,4),(54,'Compiler',7,'B','tb12','Anubha Prajapati',4,4),(55,'Compiler',7,'B','tb13','Anubha Prajapati',5,6),(56,'Compiler',7,'B','tb11','Anubha Prajapati',2,5),(57,'Compiler',7,'B','tb11','Anubha Prajapati',2,6),(58,'Compiler',7,'B','tb13','Anubha Prajapati',4,6),(59,'ML',7,'B','tb11','Pankaj Panday',1,5),(60,'ML',7,'B','tb11','Pankaj Panday',4,1),(61,'ML',7,'B','tb13','Pankaj Panday',3,2),(62,'ML',7,'B','tb12','Pankaj Panday',2,2),(63,'ML',7,'B','tb11','Pankaj Panday',2,4),(64,'ML',7,'B','tb13','Pankaj Panday',3,5),(65,'Web',7,'B','tb13','Pankaj Panday',3,1),(66,'Web',7,'B','tb15','Pankaj Panday',4,2),(67,'Web',7,'B','tb13','Pankaj Panday',2,1),(68,'Web',7,'B','tb11','Ayushi Arzare',1,4),(69,'Web',7,'B','tb12','Pankaj Panday',1,3),(70,'Web',7,'B','tb11','Ayushi Arzare',5,4);
/*!40000 ALTER TABLE `timetable` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-16 17:15:05
