-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Erstellungszeit: 16. Apr 2015 um 15:57
-- Server Version: 5.6.21
-- PHP-Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Datenbank: `ticketverwaltung`
--
Create database ticketverwaltung;

Use ticketverwaltung;
-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `User`
--
	
CREATE TABLE IF NOT EXISTS `User` (
`Username` varchar(30) NOT NULL,
  `Passwort` varchar(32) NOT NULL,
  `Email` varchar(40) NOT NULL,
  `Vorname` varchar(40),
  `Nachname`varchar(40),
   PRIMARY KEY (`Username`),
   UNIQUE KEY `UNIQUE_NAME` (`Username`),
   UNIQUE KEY `UNIQUE_EMAIL` (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Role`
--
	
CREATE TABLE IF NOT EXISTS `Role` (
  `Role_Name` varchar(40) NOT NULL,
  `Role_Desc` varchar(100),
   PRIMARY KEY (`Role_Name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `User_Role`
--
	
CREATE TABLE IF NOT EXISTS `User_Role` (
  `Username` varchar(40) NOT NULL,
  `Role_Name` varchar(40) NOT NULL,
  PRIMARY KEY (`Username`, `Role_Name`), 
  FOREIGN KEY (`Username`) REFERENCES User (`Username`),
  FOREIGN KEY (`Role_Name`) REFERENCES Role (`Role_Name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 
 -- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Project`
--
	
CREATE TABLE IF NOT EXISTS `Project` (
`Project_Code` varchar(5) NOT NULL,
  `Project_Name` varchar(40) NOT NULL,
  `Project_Owner` varchar(40) NOT NULL,
  `Project_Desc` varchar(40),
  `Project_Counter` int(11) NOT NULL,
  PRIMARY KEY (`Project_Code`),
  UNIQUE KEY `UNIQUE_PROJECT_NAME` (`Project_Name`),
  FOREIGN KEY (`Project_Owner`) REFERENCES User (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


 
 -- --------------------------------------------------------
 
 --
-- Tabellenstruktur für Tabelle `Status_Typ`
--	
CREATE TABLE IF NOT EXISTS `Status_Typ` (
`Status` varchar(20) NOT NULL,
  `Status_Desc` varchar(40),
  PRIMARY KEY (`Status`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

 -- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Ticket`
--
	
CREATE TABLE IF NOT EXISTS `Ticket` (
  `Project_Code` varchar(5) NOT NULL,
  `Ticket_ID` int(15) NOT NULL,
  `Ticket_Name` varchar(40) NOT NULL,
  `Ticket_Issuer` varchar(40),
  `Ticket_Author` varchar(40) NOT NULL,
  `Ticket_Desc` varchar(200),
  `Ticket_Status` varchar(20) NOT NULL,
  PRIMARY KEY (`Project_Code`, `Ticket_ID`),
  FOREIGN KEY (`Project_Code`) REFERENCES Project (`Project_Code`),
  FOREIGN KEY (`Ticket_Issuer`) REFERENCES User (`Username`),
  FOREIGN KEY (`Ticket_Author`) REFERENCES User (`Username`),
  FOREIGN KEY (`Ticket_Status`) REFERENCES Status_Typ (`Status`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;
 
 -- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Comment`
--
	
CREATE TABLE IF NOT EXISTS `Comment` (
`Comment_ID` int(11) NOT NULL AUTO_INCREMENT,
`Comment` varchar(200) NOT NULL,
  `Comment_Issuer` varchar(40) NOT NULL,
  PRIMARY KEY (`Comment_ID`), 
  FOREIGN KEY (`Comment_Issuer`) REFERENCES User (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

 -- --------------------------------------------------------
 
  

--
-- Tabellenstruktur für Tabelle `Ticket_Comment`
--
	
CREATE TABLE IF NOT EXISTS `Ticket_Comment` (
  `Project_Code` varchar(5) NOT NULL REFERENCES Ticket (`Project_Code`),
  `Ticket_ID` int(15) NOT NULL REFERENCES Ticket (`Ticket_ID`),
  `Comment_ID` int(11) NOT NULL REFERENCES Comment (`Comment_ID`),
  PRIMARY KEY (`Project_Code`, `Ticket_ID`, `Comment_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

 -- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Tag`
--
	
CREATE TABLE IF NOT EXISTS `Tag` (
`Tag_Name` varchar(20) NOT NULL,
  `Tag_Desc` varchar(40),
  PRIMARY KEY (`Tag_Name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Ticket_Tag`
--
	
CREATE TABLE IF NOT EXISTS `Ticket_Tag` (
  `Project_Code` varchar(5) NOT NULL REFERENCES Ticket (`Project_Code`),
  `Ticket_ID` int(15) NOT NULL REFERENCES Ticket (`Ticket_ID`),
  `Tag_Name` varchar(20) NOT NULL REFERENCES Tag (`Tag_Name`),
  PRIMARY KEY (`Project_Code`, `Ticket_ID`, `Tag_Name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

 -- --------------------------------------------------------

--
-- Views 
--

--
-- Necessary Data for Standard-Tables 
--
Insert Into Role (Role_Name, Role_Desc) VALUES ('admin', 'Administrator mit allen Rechten');
Insert Into Role (Role_Name, Role_Desc) VALUES ('member', 'normaler Benutzer mit eingeschraenkten Rechten');

Insert Into Status_Typ (Status, Status_Desc) VALUES ('open', 'Status für offene Tickets');
Insert Into Status_Typ (Status, Status_Desc) VALUES ('in work', 'Status für Ticket in Bearbeitung');
Insert Into Status_Typ (Status, Status_Desc) VALUES ('done', 'Status für fertige Tickets');

Insert Into User (Username, Passwort, Email) VALUES ('admin', 'admin', 'admin@web.de');
Insert Into User_Role (Username, Role_Name) VALUES ('admin', 'admin');

--
-- User
--
CREATE USER ticket_user@localhost;
SET password for Raeud@localhost = password('admin123');
GRANT Select, Insert, Update on ticketverwaltung.* to ticket_user@localhost;


--
-- Daten Benutzer
--