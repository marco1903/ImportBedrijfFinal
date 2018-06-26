-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.21-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.5.0.5277
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for import_bedrijf
CREATE DATABASE IF NOT EXISTS `import_bedrijf` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `import_bedrijf`;

-- Dumping structure for table import_bedrijf.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `Customer_ID` int(6) NOT NULL AUTO_INCREMENT,
  `First_Name` varchar(15) NOT NULL,
  `Last_Name` varchar(15) NOT NULL,
  `Street_Name` varchar(50) NOT NULL,
  `House_Number` varchar(50) NOT NULL,
  `Identification_Number` varchar(11) NOT NULL,
  `Mobile_Number` varchar(11) NOT NULL,
  PRIMARY KEY (`Customer_ID`),
  UNIQUE KEY `Identification_Number` (`Identification_Number`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table import_bedrijf.orders
CREATE TABLE IF NOT EXISTS `orders` (
  `Order_ID` int(6) NOT NULL AUTO_INCREMENT,
  `Item` varchar(50) NOT NULL,
  `Quantity` int(3) NOT NULL,
  `Order_Number` int(6) NOT NULL,
  `Purchase_Date` varchar(50) NOT NULL,
  `Customer_ID` int(6) NOT NULL,
  `Store_ID` int(6) NOT NULL,
  PRIMARY KEY (`Order_ID`),
  UNIQUE KEY `Order_Number` (`Order_Number`),
  KEY `Orders_fk0` (`Customer_ID`),
  KEY `Orders_fk1` (`Store_ID`),
  CONSTRAINT `Orders_fk0` FOREIGN KEY (`Customer_ID`) REFERENCES `customer` (`Customer_ID`),
  CONSTRAINT `Orders_fk1` FOREIGN KEY (`Store_ID`) REFERENCES `store` (`Store_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table import_bedrijf.store
CREATE TABLE IF NOT EXISTS `store` (
  `Store_ID` int(6) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Website` varchar(50) NOT NULL,
  `E-mail` varchar(50) NOT NULL,
  `Street_Name` varchar(50) NOT NULL,
  PRIMARY KEY (`Store_ID`),
  UNIQUE KEY `E-mail` (`E-mail`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
