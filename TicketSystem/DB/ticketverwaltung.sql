-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Erstellungszeit: 05. Okt 2015 um 19:02
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

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Comment`
--

CREATE TABLE IF NOT EXISTS `Comment` (
`Comment_ID` int(10) NOT NULL,
  `Comment` varchar(400) NOT NULL,
  `Comment_Issuer` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Project`
--

CREATE TABLE IF NOT EXISTS `Project` (
`Project_ID` int(10) NOT NULL,
  `Project_Name` varchar(30) DEFAULT NULL,
  `Project_Code` varchar(5) NOT NULL,
  `Project_Desc` varchar(80) DEFAULT NULL,
  `Project_Owner` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Right`
--

CREATE TABLE IF NOT EXISTS `Right` (
`Right_ID` int(10) NOT NULL,
  `Right_Name` varchar(30) NOT NULL,
  `Right_Desc` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Role`
--

CREATE TABLE IF NOT EXISTS `Role` (
`Role_ID` int(10) NOT NULL,
  `Role_Name` varchar(30) NOT NULL,
  `Role_Desc` varchar(100) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `Role`
--

INSERT INTO `Role` (`Role_ID`, `Role_Name`, `Role_Desc`) VALUES
(1, 'User', NULL);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Role_Right`
--

CREATE TABLE IF NOT EXISTS `Role_Right` (
  `Right_ID` int(10) NOT NULL,
  `Role_ID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Status_Typ`
--

CREATE TABLE IF NOT EXISTS `Status_Typ` (
`Status_ID` int(10) NOT NULL,
  `Status` varchar(30) NOT NULL,
  `Status_Desc` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Tag`
--

CREATE TABLE IF NOT EXISTS `Tag` (
`Tag_ID` int(10) NOT NULL,
  `Tag_Name` varchar(30) NOT NULL,
  `Tag_Desc` varchar(80) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Ticket`
--

CREATE TABLE IF NOT EXISTS `Ticket` (
`TicketID` int(10) NOT NULL,
  `Ticket_Name` varchar(40) NOT NULL,
  `Ticket_Desc` varchar(150) DEFAULT NULL,
  `Project_ID` int(10) NOT NULL,
  `Ticket_Issuer` varchar(40) NOT NULL,
  `Ticket_Author` varchar(40) NOT NULL,
  `Ticket_Status` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Ticket_Comment`
--

CREATE TABLE IF NOT EXISTS `Ticket_Comment` (
  `Comment_ID` int(10) NOT NULL,
  `TicketID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Ticket_Tag`
--

CREATE TABLE IF NOT EXISTS `Ticket_Tag` (
  `Tag_ID` int(10) NOT NULL,
  `TicketID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `User`
--

CREATE TABLE IF NOT EXISTS `User` (
  `Username` varchar(40) NOT NULL,
  `Passwort` varchar(256) NOT NULL,
  `Email` varchar(40) NOT NULL,
  `Vorname` varchar(30) NOT NULL,
  `Nachname` varchar(30) NOT NULL,
  `Role_ID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `Comment`
--
ALTER TABLE `Comment`
 ADD PRIMARY KEY (`Comment_ID`), ADD KEY `FK_Comment_1` (`Comment_Issuer`);

--
-- Indizes für die Tabelle `Project`
--
ALTER TABLE `Project`
 ADD PRIMARY KEY (`Project_ID`), ADD KEY `FK_Project_1` (`Project_Owner`);

--
-- Indizes für die Tabelle `Right`
--
ALTER TABLE `Right`
 ADD PRIMARY KEY (`Right_ID`);

--
-- Indizes für die Tabelle `Role`
--
ALTER TABLE `Role`
 ADD PRIMARY KEY (`Role_ID`);

--
-- Indizes für die Tabelle `Role_Right`
--
ALTER TABLE `Role_Right`
 ADD PRIMARY KEY (`Right_ID`,`Role_ID`), ADD KEY `FK_Role_Right_2` (`Role_ID`);

--
-- Indizes für die Tabelle `Status_Typ`
--
ALTER TABLE `Status_Typ`
 ADD PRIMARY KEY (`Status_ID`);

--
-- Indizes für die Tabelle `Tag`
--
ALTER TABLE `Tag`
 ADD PRIMARY KEY (`Tag_ID`);

--
-- Indizes für die Tabelle `Ticket`
--
ALTER TABLE `Ticket`
 ADD PRIMARY KEY (`TicketID`), ADD KEY `FK_Ticket_1` (`Project_ID`), ADD KEY `FK_Ticket_2` (`Ticket_Issuer`), ADD KEY `FK_Ticket_3` (`Ticket_Author`), ADD KEY `FK_Ticket_4` (`Ticket_Status`);

--
-- Indizes für die Tabelle `Ticket_Comment`
--
ALTER TABLE `Ticket_Comment`
 ADD PRIMARY KEY (`Comment_ID`,`TicketID`), ADD KEY `FK_Ticket_Comment_2` (`TicketID`);

--
-- Indizes für die Tabelle `Ticket_Tag`
--
ALTER TABLE `Ticket_Tag`
 ADD PRIMARY KEY (`Tag_ID`,`TicketID`), ADD KEY `FK_Ticket_Tag_2` (`TicketID`);

--
-- Indizes für die Tabelle `User`
--
ALTER TABLE `User`
 ADD PRIMARY KEY (`Username`), ADD KEY `FK_User_1` (`Role_ID`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `Comment`
--
ALTER TABLE `Comment`
MODIFY `Comment_ID` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT für Tabelle `Project`
--
ALTER TABLE `Project`
MODIFY `Project_ID` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT für Tabelle `Right`
--
ALTER TABLE `Right`
MODIFY `Right_ID` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT für Tabelle `Role`
--
ALTER TABLE `Role`
MODIFY `Role_ID` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT für Tabelle `Status_Typ`
--
ALTER TABLE `Status_Typ`
MODIFY `Status_ID` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT für Tabelle `Tag`
--
ALTER TABLE `Tag`
MODIFY `Tag_ID` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT für Tabelle `Ticket`
--
ALTER TABLE `Ticket`
MODIFY `TicketID` int(10) NOT NULL AUTO_INCREMENT;
--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `Comment`
--
ALTER TABLE `Comment`
ADD CONSTRAINT `FK_Comment_1` FOREIGN KEY (`Comment_Issuer`) REFERENCES `User` (`Username`);

--
-- Constraints der Tabelle `Project`
--
ALTER TABLE `Project`
ADD CONSTRAINT `FK_Project_1` FOREIGN KEY (`Project_Owner`) REFERENCES `User` (`Username`);

--
-- Constraints der Tabelle `Role_Right`
--
ALTER TABLE `Role_Right`
ADD CONSTRAINT `FK_Role_Right_1` FOREIGN KEY (`Right_ID`) REFERENCES `Right` (`Right_ID`),
ADD CONSTRAINT `FK_Role_Right_2` FOREIGN KEY (`Role_ID`) REFERENCES `Role` (`Role_ID`);

--
-- Constraints der Tabelle `Ticket`
--
ALTER TABLE `Ticket`
ADD CONSTRAINT `FK_Ticket_1` FOREIGN KEY (`Project_ID`) REFERENCES `Project` (`Project_ID`),
ADD CONSTRAINT `FK_Ticket_2` FOREIGN KEY (`Ticket_Issuer`) REFERENCES `User` (`Username`),
ADD CONSTRAINT `FK_Ticket_3` FOREIGN KEY (`Ticket_Author`) REFERENCES `User` (`Username`),
ADD CONSTRAINT `FK_Ticket_4` FOREIGN KEY (`Ticket_Status`) REFERENCES `Status_Typ` (`Status_ID`);

--
-- Constraints der Tabelle `Ticket_Comment`
--
ALTER TABLE `Ticket_Comment`
ADD CONSTRAINT `FK_Ticket_Comment_1` FOREIGN KEY (`Comment_ID`) REFERENCES `Comment` (`Comment_ID`),
ADD CONSTRAINT `FK_Ticket_Comment_2` FOREIGN KEY (`TicketID`) REFERENCES `Ticket` (`TicketID`);

--
-- Constraints der Tabelle `Ticket_Tag`
--
ALTER TABLE `Ticket_Tag`
ADD CONSTRAINT `FK_Ticket_Tag_1` FOREIGN KEY (`Tag_ID`) REFERENCES `Tag` (`Tag_ID`),
ADD CONSTRAINT `FK_Ticket_Tag_2` FOREIGN KEY (`TicketID`) REFERENCES `Ticket` (`TicketID`);

--
-- Constraints der Tabelle `User`
--
ALTER TABLE `User`
ADD CONSTRAINT `FK_User_1` FOREIGN KEY (`Role_ID`) REFERENCES `Role` (`Role_ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

  
GRANT ALL PRIVILEGES ON *.* TO 'ticket_user'@'localhost' IDENTIFIED BY PASSWORD '*01A6717B58FF5C7EAFFF6CB7C96F7428EA65FE4C' WITH GRANT OPTION;
