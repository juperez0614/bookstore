-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bookstore
-- ------------------------------------------------------
-- Server version	5.6.21-log

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
-- Table structure for table `author`
--

DROP TABLE IF EXISTS `author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `author` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(50) DEFAULT NULL,
  `LastName` varchar(50) DEFAULT NULL,
  `Biography` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author`
--

LOCK TABLES `author` WRITE;
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
INSERT INTO `author` VALUES (1,'John','Mclain','The bio of john mclane'),(2,'Luis','Mclittle','The bio of lius mclittle'),(3,'Jake','Master','The bio of jake master'),(4,'gilbert','joseph','The bio of gilbert joseph'),(5,'jose','alexis','The bio of jose alexis'),(6,'ruby','desmond','The bio of ruby desmond'),(7,'juan','perez','The bio of juan perez'),(8,'master','chief','The bio of master chief'),(9,'John','egoes','The bio of john egoes'),(10,'nancy','Mclain','The bio of nancy mclane'),(11,'Anonymous','','The bio of ...');
/*!40000 ALTER TABLE `author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `ISBN` int(11) DEFAULT NULL,
  `Price` double NOT NULL,
  `Summary` varchar(250) DEFAULT NULL,
  `Title` varchar(100) DEFAULT NULL,
  `GenreId` int(11) NOT NULL,
  `PublisherId` int(11) NOT NULL,
  `Cost` double NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `GenreId` (`GenreId`),
  KEY `PublisherId` (`PublisherId`),
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`GenreId`) REFERENCES `genre` (`Id`),
  CONSTRAINT `book_ibfk_2` FOREIGN KEY (`PublisherId`) REFERENCES `publisher` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,123456789,19.99,'summary-book1','book1',1,1,5),(2,123456788,18.88,'summary-book2','book2',2,2,4),(3,123456787,17.77,'summary-book3','book3',3,3,3),(4,123456786,16.66,'summary-book4','book4',4,4,2),(5,123456785,15.55,'summary-book5','book5',5,5,5),(6,123456784,14.44,'summary-book6','book6',6,6,5),(7,123456783,13.33,'summary-book7','book7',7,7,4),(8,123456782,12.22,'summary-book8','book8',8,8,2),(9,123456781,11.11,'summary-book9','book9',9,9,5),(10,123456780,10,'summary-book10','book10',10,10,1),(11,223456789,19.99,'summary-book21','2book1',1,1,5),(12,223456788,18.88,'summary-book22','2book2',2,2,4),(13,223456787,17.77,'summary-book23','2book3',3,3,3),(14,223456786,16.66,'summary-book24','2book4',4,4,2),(15,223456785,15.55,'summary-book25','2book5',5,5,5),(16,223456784,14.44,'summary-book26','2book6',6,6,5),(17,223456783,13.33,'summary-book27','2book7',7,7,4),(18,223456782,12.22,'summary-book28','2book8',8,8,2),(19,223456781,11.11,'summary-book29','2book9',9,9,5),(20,223456780,10,'summary-book210','2book10',10,10,1),(21,323456789,19.99,'summary-book31','3book1',1,1,5),(22,323456788,18.88,'summary-book32','3book2',2,2,4),(23,323456787,17.77,'summary-book33','3book3',3,3,3),(24,323456786,16.66,'summary-book34','3book4',4,4,2),(25,323456785,15.55,'summary-book35','3book5',5,5,5),(26,323456784,14.44,'summary-book36','3book6',6,6,5),(27,323456783,13.33,'summary-book37','3book7',7,7,4),(28,323456782,12.22,'summary-book38','3book8',8,8,2),(29,323456781,11.11,'summary-book39','3book9',9,9,5),(30,323456780,10,'summary-book310','3book10',10,10,1),(31,423456789,19.99,'summary-book41','4book1',1,1,5),(32,423456788,18.88,'summary-book42','4book2',2,2,4),(33,423456787,17.77,'summary-book43','4book3',3,3,3),(34,423456786,16.66,'summary-book44','4book4',4,4,2),(35,423456785,15.55,'summary-book45','4book5',5,5,5),(36,423456784,14.44,'summary-4','4book6',6,6,5),(37,423456783,13.33,'summary-book47','4book7',7,7,4),(38,423456782,12.22,'summary-book48','4book8',8,8,2),(39,423456781,11.11,'summary-book49','4book9',9,9,5),(40,423456780,10,'summary-book410','4book10',10,10,1),(41,523456789,19.99,'summary-book51','5book1',1,1,5),(42,523456788,18.88,'summary-book52','5book2',2,2,4),(43,523456787,17.77,'summary-book53','5book3',3,3,3),(44,523456786,16.66,'summary-book54','5book4',4,4,2),(45,523456785,15.55,'summary-book55','5book5',5,5,5),(46,523456784,14.44,'summary-book56','5book6',6,6,5),(47,523456783,13.33,'summary-book57','5book7',7,7,4),(48,523456782,12.22,'summary-book58','5book8',8,8,2),(49,523456781,11.11,'summary-book59','5book9',9,9,5),(50,523456780,10,'summary-book510','5book10',10,10,1),(51,623456789,19.99,'summary-book61','6book1',1,1,5),(52,623456788,18.88,'summary-book62','6book2',2,2,4),(53,623456787,17.77,'summary-book63','6book3',3,3,3),(54,623456786,16.66,'summary-book64','6book4',4,4,2),(55,623456785,15.55,'summary-book65','6book5',5,5,5),(56,623456784,14.44,'summary-book66','6book6',6,6,5),(57,623456783,13.33,'summary-book67','6book7',7,7,4),(58,623456782,12.22,'summary-book68','6book8',8,8,2),(59,623456781,11.11,'summary-book69','6book9',9,9,5),(60,623456780,10,'summary-book10','6book10',10,10,1);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookauthor`
--

DROP TABLE IF EXISTS `bookauthor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bookauthor` (
  `BookId` int(11) NOT NULL,
  `AuthorId` int(11) NOT NULL,
  KEY `BookId` (`BookId`),
  KEY `AuthorId` (`AuthorId`),
  CONSTRAINT `bookauthor_ibfk_1` FOREIGN KEY (`BookId`) REFERENCES `book` (`Id`),
  CONSTRAINT `bookauthor_ibfk_2` FOREIGN KEY (`AuthorId`) REFERENCES `author` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookauthor`
--

LOCK TABLES `bookauthor` WRITE;
/*!40000 ALTER TABLE `bookauthor` DISABLE KEYS */;
INSERT INTO `bookauthor` VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7),(8,8),(9,9),(10,10),(11,1),(12,2),(13,3),(14,4),(15,5),(16,6),(17,7),(18,8),(19,9),(20,10),(21,1),(22,2),(23,3),(24,4),(25,5),(26,6),(27,7),(28,8),(29,9),(30,10),(31,1),(32,2),(33,3),(34,4),(35,5),(36,6),(37,7),(38,8),(39,9),(40,10),(41,1),(42,2),(43,3),(44,4),(45,5),(46,6),(47,7),(48,8),(49,9),(50,10),(51,1),(52,2),(53,3),(54,4),(55,5),(56,6),(57,7),(58,8),(59,9),(60,10),(1,3);
/*!40000 ALTER TABLE `bookauthor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(50) DEFAULT NULL,
  `LastName` varchar(50) DEFAULT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `Address2` varchar(50) DEFAULT NULL,
  `City` varchar(50) DEFAULT NULL,
  `State` varchar(2) DEFAULT NULL,
  `ZipCode` int(11) DEFAULT NULL,
  `Username` varchar(50) NOT NULL,
  `Email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `Username` (`Username`),
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`Username`) REFERENCES `userauth` (`Username`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Jeff','Asmus','22567 NW 146th St',NULL,'Seattle','WA',98101,'jeffrey98','jasmus08@uw.edu'),(2,'Linda','Perez','27950 NE 147th Circle',NULL,'Duvall','WA',98019,'linda98','lper555@yahoo.com'),(3,'Brian','kliff','28550 SE 147th Pl',NULL,'Goldbar','WA',98032,'brian98','bkliff@microsoft.com'),(4,'Clifford','Bigger','814 NE 4th Pl',NULL,'Redmond','WA',98054,'clifford98','cliff@uw.edu'),(5,'Red','Dog','814 NE 4th Pl',NULL,'Redmond','WA',98054,'red98','rdog@microsoft.com'),(6,'Ryu','Ken','28550 SE 147th Pl',NULL,'Goldbar','WA',98032,'ryu98','ryuken@uw.edu'),(7,'Ricky','Ricardo','27950 NE 147th Circle',NULL,'Duvall','WA',98019,'ricky98','rcardo@uw.edu'),(8,'Gob','Bluth','1459 S Cocaine Rd',NULL,'Bogota','CO',10,'gob98','magic@magicians4life.gov'),(9,'George','Michael','000 bannanastand ln',NULL,'Hell','WI',44019,'george98','terrorrist1@alibaba.cn'),(10,'Julio','Perez','27950 NE 147th Circle',NULL,'Duvall','WA',98019,'julio98','jperez99@uw.edu'),(11,'admin','admin','123321','2','seattle','wa',98371,'admin','admin@admin.com'),(12,'jjj','ppp','123','23','ret','wa',22345,'Jd','email@ema8il.com'),(13,'Jeffrey','Asmus','3720 90th ave ct e','','edgewood','wa',98371,'username1','testw@dtest.com'),(14,'Jeffrey','Asmus','3720 90th ave ct e','','edgewood','wa',98371,'Testing','testw3@test.com'),(15,'julio','Jeff','1234  Lane','','daddadfab','FL',33302,'newuseraccount','emaisl@email.com'),(16,'juan','pilar','23455 SW 21st st','','hello','wa',98109,'test1','killingit@daddada3fg.com'),(17,'jdsa','asd','123','123','city','wa',98103,'test2','te333st@test.com'),(18,'jdsa','asd','123','123','city','wa',98103,'test3','test@tesddadt.com'),(19,'j','d','','','edg','wa',12345,'etea','daj;d'),(20,'J','don\'t','1','','city','wa',98103,'testing12','test@test.com'),(21,'J','don\'t','1','','city','wa',12345,'testing12','testd'),(22,'Jeffrey','Asmus','3720 90th ave ct e','','edgewood','wa',98371,'yodel','tesqsatw@test.com'),(23,'Test ','User','123 Address ','apt#205','Seattle','WA',98101,'test1234','example@test.com'),(24,'Bertha','Jacobson','123 rainbow way','apt #7','San Jose','CA',12346,'test1232','sunnybertha@gmail.com'),(25,'Julio','Perez','Somewhere','','hello','WA',98019,'julio','julio@julio.com');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre`
--

DROP TABLE IF EXISTS `genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genre` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Genre` varchar(100) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre`
--

LOCK TABLES `genre` WRITE;
/*!40000 ALTER TABLE `genre` DISABLE KEYS */;
INSERT INTO `genre` VALUES (1,'Suspense'),(2,'Action'),(3,'romance'),(4,'mystery'),(5,'politics'),(6,'history'),(7,'biography'),(8,'autobiography'),(9,'childrens'),(10,'science fiction');
/*!40000 ALTER TABLE `genre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventory` (
  `BookId` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL,
  KEY `BookId` (`BookId`),
  CONSTRAINT `inventory_ibfk_1` FOREIGN KEY (`BookId`) REFERENCES `book` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory`
--

LOCK TABLES `inventory` WRITE;
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
INSERT INTO `inventory` VALUES (11,20),(12,20),(13,20),(14,20),(15,20),(16,20),(17,20),(18,20),(19,20),(20,20),(21,20),(22,20),(23,20),(24,20),(25,20),(26,20),(27,20),(28,20),(29,20),(30,20),(31,20),(32,20),(33,20),(34,20),(35,20),(36,20),(37,20),(38,20),(39,20),(40,20),(41,20),(42,20),(43,20),(44,20),(45,20),(46,20),(47,20),(48,20),(49,20),(50,20),(51,20),(52,20),(53,20),(54,20),(55,20),(56,20),(57,20),(58,20),(59,20),(60,20),(1,15),(2,20),(3,18),(4,20),(5,20),(6,20),(7,20),(8,20),(9,20),(10,20);
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoice` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `CustomerId` int(11) NOT NULL,
  `PaymentType` varchar(50) DEFAULT NULL,
  `TransactionDate` date DEFAULT NULL,
  `TotalAmount` double DEFAULT NULL,
  `IsProcessed` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `CustomerId` (`CustomerId`),
  CONSTRAINT `invoice_ibfk_1` FOREIGN KEY (`CustomerId`) REFERENCES `customer` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
INSERT INTO `invoice` VALUES (1,1,NULL,'2015-01-01',30,1),(2,2,NULL,'2015-01-02',50,1),(3,3,NULL,'2015-01-08',40,1),(4,4,NULL,'2015-01-09',20,1),(5,5,NULL,'2015-01-15',10,1),(6,6,NULL,'2015-01-16',90,1),(7,7,NULL,'2015-01-22',80,1),(8,8,NULL,'2015-01-23',70,1),(9,9,NULL,'2015-01-29',60,1),(10,10,NULL,'2015-01-30',30,1),(11,1,NULL,'2015-02-01',50,1),(12,2,NULL,'2015-02-02',30,1),(13,3,NULL,'2015-02-08',80,1),(14,4,NULL,'2015-02-09',20,1),(15,5,NULL,'2015-02-15',90,1),(16,6,NULL,'2015-02-16',20,1),(17,7,NULL,'2015-02-22',30,1),(18,8,NULL,'2015-02-23',10,1),(19,9,NULL,'2015-02-27',40,1),(20,10,NULL,'2015-02-28',80,1),(21,11,'Credit Card','2015-03-05',627.4899999999999,1),(22,11,'Credit Card','2015-03-06',213.24,1),(23,14,'Credit Card','2015-03-07',19.99,1),(24,18,'Credit Card','2015-03-07',439.78999999999996,1),(25,21,NULL,NULL,0,0),(26,22,'Credit Card','2015-03-08',129.94,1),(27,22,'Credit Card','2015-03-08',19.99,1),(28,11,'Credit Card','2015-03-08',19.99,1),(29,11,'Credit Card','2015-03-08',18.88,1),(30,11,'Credit Card','2015-03-08',16.66,1),(31,11,'Credit Card','2015-03-08',19.99,1),(32,11,'Credit Card','2015-03-08',19.99,1),(33,11,'Credit Card','2015-03-08',15.55,1),(34,11,'Credit Card','2015-03-08',14.44,1),(35,11,'Credit Card','2015-03-08',348.78000000000003,1),(36,11,NULL,NULL,0,0),(37,11,NULL,NULL,0,0),(38,11,NULL,NULL,0,0),(39,11,NULL,NULL,0,0),(40,11,'Credit Card','2015-03-08',111.09,1),(41,11,NULL,NULL,0,0),(42,11,NULL,NULL,0,0),(43,10,NULL,NULL,0,0),(44,24,'Credit Card','2015-03-10',14.44,1),(45,11,NULL,NULL,0,0),(46,11,NULL,NULL,0,0),(47,25,'Credit Card','2015-03-10',97.72999999999999,1);
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lineitem`
--

DROP TABLE IF EXISTS `lineitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lineitem` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `BookId` int(11) NOT NULL,
  `Quantity` int(11) DEFAULT NULL,
  `InvoiceId` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `BookId` (`BookId`),
  KEY `InvoiceId` (`InvoiceId`),
  CONSTRAINT `lineitem_ibfk_1` FOREIGN KEY (`BookId`) REFERENCES `book` (`Id`),
  CONSTRAINT `lineitem_ibfk_2` FOREIGN KEY (`InvoiceId`) REFERENCES `invoice` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lineitem`
--

LOCK TABLES `lineitem` WRITE;
/*!40000 ALTER TABLE `lineitem` DISABLE KEYS */;
INSERT INTO `lineitem` VALUES (1,1,1,1),(2,2,2,2),(3,3,3,3),(4,4,1,4),(5,5,1,5),(6,6,1,6),(7,7,1,7),(8,8,1,8),(9,9,1,9),(10,10,1,10),(11,1,10,21),(12,2,9,21),(13,3,7,21),(14,4,8,21),(17,3,12,22),(18,1,1,23),(19,7,1,24),(20,1,10,24),(21,2,12,24),(24,2,5,26),(25,3,2,26),(26,1,1,27),(27,1,1,28),(28,2,1,29),(29,4,1,30),(30,1,1,31),(31,1,1,32),(32,5,1,33),(33,6,1,34),(36,5,2,35),(37,6,22,35),(38,5,3,36),(39,8,3,37),(44,6,1,38),(46,4,1,39),(47,1,1,39),(48,10,2,40),(49,9,1,40),(50,7,6,40),(52,1,1,42),(53,7,1,42),(54,6,1,42),(58,6,1,44),(65,1,4,47),(66,3,1,47);
/*!40000 ALTER TABLE `lineitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monthlyprofits`
--

DROP TABLE IF EXISTS `monthlyprofits`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `monthlyprofits` (
  `MonthId` int(11) NOT NULL AUTO_INCREMENT,
  `TotalProfit` double NOT NULL,
  PRIMARY KEY (`MonthId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monthlyprofits`
--

LOCK TABLES `monthlyprofits` WRITE;
/*!40000 ALTER TABLE `monthlyprofits` DISABLE KEYS */;
/*!40000 ALTER TABLE `monthlyprofits` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publisher`
--

DROP TABLE IF EXISTS `publisher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `publisher` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `CompanyName` varchar(50) DEFAULT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `Address2` varchar(50) DEFAULT NULL,
  `City` varchar(50) DEFAULT NULL,
  `ZipCode` int(11) DEFAULT NULL,
  `State` varchar(2) DEFAULT NULL,
  `Phone` varchar(12) DEFAULT NULL,
  `PointOfContact` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publisher`
--

LOCK TABLES `publisher` WRITE;
/*!40000 ALTER TABLE `publisher` DISABLE KEYS */;
INSERT INTO `publisher` VALUES (1,'GoodBooks','123 Candycane Ln',NULL,'Seattle',98110,'WA','808-719-3232','Kaleb McGraw'),(2,'BadBooks','123 Candycane Ln',NULL,'Seattle',98110,'WA','426-736-3232','John Outlaw'),(3,'GreatBooks','123 Candykane Ln',NULL,'Seattle',98110,'WA','405-789-3232','Michael Phelps'),(4,'BetterBooks','444 kiddycorner st',NULL,'Seattle',98110,'WA','808-779-3232','Jesus Martinez'),(5,'BestBooks','999 Champion Ave',NULL,'Seattle',98110,'WA','808-732-3232','Chris Crater'),(6,'GreaterBooks','321 Candycorn Ln',NULL,'Nashville',32101,'TN','808-766-3232','Gumbo Jenkins'),(7,'ExtremeBooks','123 Skyhigh Tr',NULL,'Seattle',98110,'WA','305-719-3223','Leroy Hilliford'),(8,'Awful Books','333 Garbage St',NULL,'Philidelphia',69808,'PA','808-919-3232','Joe Celeb'),(9,'ReligiousBooks','777 Heaven Rd',NULL,'Seattle',98110,'WA','808-319-3232','Jack Frost'),(10,'SatanicBooks','999 Upsidedown Ln',NULL,'Miami',33014,'FL','808-419-3232','Abe Acerater');
/*!40000 ALTER TABLE `publisher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rating`
--

DROP TABLE IF EXISTS `rating`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rating` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Rating` int(11) DEFAULT NULL,
  `Review` varchar(250) DEFAULT NULL,
  `BookId` int(11) NOT NULL,
  `CustomerId` int(11) NOT NULL,
  `RatingDate` date NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `CustomerId` (`CustomerId`),
  KEY `BookId` (`BookId`),
  CONSTRAINT `rating_ibfk_1` FOREIGN KEY (`CustomerId`) REFERENCES `customer` (`Id`),
  CONSTRAINT `rating_ibfk_2` FOREIGN KEY (`BookId`) REFERENCES `book` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rating`
--

LOCK TABLES `rating` WRITE;
/*!40000 ALTER TABLE `rating` DISABLE KEYS */;
INSERT INTO `rating` VALUES (1,1,'reveiwb1',1,1,'2015-01-06'),(2,2,'reveiwb2',2,2,'2015-01-14'),(3,3,'reveiwb3',3,3,'2015-01-28'),(4,4,'reveiwb4',4,4,'2015-02-13'),(5,5,'reveiwb5',5,5,'2015-02-18'),(6,5,'reveiwb6',6,6,'2015-02-23'),(7,4,'reveiwb7',7,7,'2015-03-02'),(8,3,'reveiwb8',8,8,'2015-03-02'),(9,2,'reveiwb9',9,9,'2015-03-03'),(10,1,'reveiwb10',10,10,'2015-03-04'),(11,3,'reveiwb1',4,1,'2015-01-08'),(12,3,'reveiwb2',5,2,'2015-01-18'),(13,5,'reveiwb3',8,3,'2015-01-24'),(14,4,'reveiwb4',9,4,'2015-02-14'),(15,5,'reveiwb5',10,5,'2015-02-18'),(16,5,'reveiwb6',4,6,'2015-02-25'),(17,3,'reveiwb7',8,7,'2015-03-03'),(18,3,'reveiwb8',7,8,'2015-03-04'),(19,1,'reveiwb9',10,9,'2015-03-04'),(20,4,'reveiwb10',9,10,'2015-03-05'),(21,1,'submit review',1,14,'2015-03-07'),(22,5,'this is a test review',1,18,'2015-03-07'),(23,2,'review book1, for testing purposes',1,11,'2015-03-08'),(24,1,'teste teste ateat a',1,11,'2015-03-08'),(25,3,'thsljda;',1,14,'2015-03-08'),(26,4,'tesing a reiew',1,22,'2015-03-08'),(27,1,'new stuff ',1,11,'2015-03-08'),(28,3,'Adding a review to this book!',2,11,'2015-03-09'),(29,5,'This is the best book in the history of literature. ',10,11,'2015-03-09'),(30,3,'This is a new review ',1,10,'2015-03-10'),(31,4,'Testing the review says Bertha',2,24,'2015-03-10'),(34,1,'<script> \r\n\r\nconsole.log(document.cookies);\r\n\r\n</script>',51,11,'2015-03-10'),(35,1,'<script type=\"text/javascript\" >\r\nconsole.log(document.cookie);\r\n</script>',51,11,'2015-03-10'),(36,4,'This is a great book!',7,11,'2015-03-10'),(38,5,'THis book is sGREAT',1,25,'2015-03-10');
/*!40000 ALTER TABLE `rating` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userauth`
--

DROP TABLE IF EXISTS `userauth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userauth` (
  `Username` varchar(50) NOT NULL,
  `UserPassword` varchar(50) NOT NULL,
  PRIMARY KEY (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userauth`
--

LOCK TABLES `userauth` WRITE;
/*!40000 ALTER TABLE `userauth` DISABLE KEYS */;
INSERT INTO `userauth` VALUES ('','dja;'),('231','123'),('admin','123'),('brian98','kliff0'),('clifford98','bigg0'),('etea','123'),('george98','stefan0'),('gob98','magicman0'),('JAsmus@icitsolutions.com','123'),('JAsmus@icitsolutions231.com','123'),('Jd','123'),('jdad',''),('Jdj',''),('jdl;','jd'),('jeffrey98','jeff9800'),('julio','pass'),('julio98','perez0'),('linda98','per0'),('newuseraccount','pass123'),('red98','dogg0'),('ricky98','ricard0'),('ryu98','karate0'),('Test','test'),('test1','test'),('test12','123'),('test123','123'),('test1232','123'),('test1234','123'),('test2','test'),('test3','123'),('Testing','123'),('testing12','123'),('username1','123'),('yodel','123');
/*!40000 ALTER TABLE `userauth` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userrole`
--

DROP TABLE IF EXISTS `userrole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userrole` (
  `Role` varchar(50) DEFAULT 'customer',
  `Username` varchar(50) NOT NULL,
  KEY `Username` (`Username`),
  CONSTRAINT `userrole_ibfk_1` FOREIGN KEY (`Username`) REFERENCES `userauth` (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userrole`
--

LOCK TABLES `userrole` WRITE;
/*!40000 ALTER TABLE `userrole` DISABLE KEYS */;
INSERT INTO `userrole` VALUES ('customer','jeffrey98'),('customer','julio98'),('customer','linda98'),('customer','brian98'),('customer','clifford98'),('customer','red98'),('customer','ryu98'),('customer','ricky98'),('customer','gob98'),('customer','george98');
/*!40000 ALTER TABLE `userrole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `weeklyprofits`
--

DROP TABLE IF EXISTS `weeklyprofits`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `weeklyprofits` (
  `WeekId` int(11) NOT NULL AUTO_INCREMENT,
  `TotalProfit` double NOT NULL,
  PRIMARY KEY (`WeekId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weeklyprofits`
--

LOCK TABLES `weeklyprofits` WRITE;
/*!40000 ALTER TABLE `weeklyprofits` DISABLE KEYS */;
/*!40000 ALTER TABLE `weeklyprofits` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-03-10 22:10:27
