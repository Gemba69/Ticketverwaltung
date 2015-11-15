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
	
CREATE TABLE user (
username varchar(40) NOT NULL,
  passwort varchar(32) NOT NULL,
  email varchar(40) NOT NULL,
  vorname varchar(40),
  nachname varchar(40),
   PRIMARY KEY (username),
   UNIQUE KEY UNIQUE_NAME (username),
   UNIQUE KEY UNIQUE_EMAIL (email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Role`
--
	
CREATE TABLE role (
  role_name varchar(40) NOT NULL,
  role_Desc varchar(100),
   PRIMARY KEY (role_Name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `user_role`
--
	
CREATE TABLE user_role (
  username varchar(40) NOT NULL , -- REFERENCES User (username),
  role_name varchar(40) NOT NULL , -- REFERENCES Role (role_Name)
  PRIMARY KEY (username, role_name) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE user_role
   ADD CONSTRAINT `fk_user_role` FOREIGN KEY(username)
       REFERENCES user(`username`) ON DELETE NO ACTION ON UPDATE NO ACTION;
 
ALTER TABLE user_role
   ADD CONSTRAINT `fk_user_role_2` FOREIGN KEY(role_name)
       REFERENCES role(`role_name`) ON DELETE NO ACTION ON UPDATE NO ACTION;
 -- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Project`
--
	
CREATE TABLE project (
project_code varchar(5) NOT NULL,
  project_name varchar(40) NOT NULL,
  project_owner varchar(40) NOT NULL, -- REFERENCES User (username) ON DELETE CASCADE,
  project_desc varchar(2500),
  project_counter int(11) NOT NULL,
  PRIMARY KEY (project_code),
  UNIQUE KEY UNIQUE_PROJECT_NAME (project_Name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


ALTER TABLE project
   ADD CONSTRAINT `fk_project` FOREIGN KEY(project_owner)
       REFERENCES user(`username`) ON DELETE NO ACTION ON UPDATE NO ACTION;
 
 -- --------------------------------------------------------
 
 --
-- Tabellenstruktur für Tabelle `Status_Typ`
--	
CREATE TABLE IF NOT EXISTS `status_Typ` (
`status` varchar(20) NOT NULL,
  `Status_Desc` varchar(40),
  PRIMARY KEY (`Status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 -- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Ticket`
--
	
CREATE TABLE IF NOT EXISTS `ticket` (
  `project_code` varchar(5) NOT NULL,
  `Ticket_ID` int(15) NOT NULL,
  `Ticket_Name` varchar(40) NOT NULL,
  `Ticket_Issuer` varchar(40),
  `Ticket_Author` varchar(40) NOT NULL,
  `Ticket_Desc` varchar(2500),
  `Ticket_Status` varchar(20) NOT NULL,
  `Ticket_Prioritaet` int(1) NOT NULL,
  PRIMARY KEY (`Project_Code`, `Ticket_ID`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE ticket
   ADD CONSTRAINT `fk_ticket` FOREIGN KEY(Project_Code)
       REFERENCES project(`project_code`) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE ticket
   ADD CONSTRAINT `fk_ticket_2` FOREIGN KEY(Ticket_Issuer)
       REFERENCES user(`username`) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE ticket
   ADD CONSTRAINT `fk_ticket_3` FOREIGN KEY(Ticket_Author)
       REFERENCES user(`username`) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE ticket
   ADD CONSTRAINT `fk_ticket_4` FOREIGN KEY(Ticket_Status)
       REFERENCES status_typ(`status`) ON DELETE NO ACTION ON UPDATE NO ACTION;
 
 -- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Comment`
--
	
CREATE TABLE IF NOT EXISTS `Comment` (
`Comment_ID` int(11) NOT NULL AUTO_INCREMENT,
`Comment` varchar(2500) NOT NULL,
  `Comment_Issuer` varchar(40),
  `Ticket_ID` int(15) NOT NULL,
  Project_Code varchar(5),
  PRIMARY KEY (`Comment_ID`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
  
ALTER TABLE Comment
   ADD CONSTRAINT `fk_comment` FOREIGN KEY(Comment_Issuer)
       REFERENCES user(`username`) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE Comment
   ADD CONSTRAINT `fk_comment_2` FOREIGN KEY(Project_Code, Ticket_ID)
       REFERENCES ticket(project_code, Ticket_ID) ON DELETE NO ACTION ON UPDATE NO ACTION;

 -- --------------------------------------------------------
 

--
-- Tabellenstruktur für Tabelle `Tag`
--
	
CREATE TABLE IF NOT EXISTS `Tag` (
`Tag_Name` varchar(20) NOT NULL,
  `Tag_Desc` varchar(40),
  PRIMARY KEY (`Tag_Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Ticket_Tag`
--
	
CREATE TABLE IF NOT EXISTS `Ticket_Tag` (
  `Project_Code` varchar(5) NOT NULL,
  `Ticket_ID` int(15) NOT NULL,
  `Tag_Name` varchar(20) NOT NULL,
  PRIMARY KEY (`Project_Code`, `Ticket_ID`, `Tag_Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE Ticket_Tag
   ADD CONSTRAINT `fk_tag` FOREIGN KEY(Tag_Name)
       REFERENCES Tag(`Tag_Name`) ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE Ticket_Tag
   ADD CONSTRAINT `fk_tag_2` FOREIGN KEY(Project_Code, Ticket_ID)
       REFERENCES ticket(project_code, Ticket_ID) ON DELETE NO ACTION ON UPDATE NO ACTION;

 -- --------------------------------------------------------

--
-- Views 
--

--
-- Necessary Data for Standard-Tables 
--
Insert Into Role (Role_Name, Role_Desc) VALUES ('admin', 'Administrator mit allen Rechten');
Insert Into Role (Role_Name, Role_Desc) VALUES ('member', 'normaler Benutzer mit eingeschraenkten Rechten');

Insert Into Status_Typ (Status, Status_Desc) VALUES ('offen', 'Status für offene Tickets');
Insert Into Status_Typ (Status, Status_Desc) VALUES ('in Arbeit', 'Status für Ticket in Bearbeitung');
Insert Into Status_Typ (Status, Status_Desc) VALUES ('geschlossen', 'Status für fertige Tickets');

Insert Into User (Username, Passwort, Email, Vorname, Nachname) VALUES ('admin', '21232f297a57a5a743894a0e4a801fc3', 'admin@web.de', 'Arthur', 'Administrator');
Insert Into User_Role (Username, Role_Name) VALUES ('admin', 'admin');

--
-- User
--
CREATE USER ticket_user@localhost;
SET password for ticket_user@localhost = password('admin123');
GRANT Select, Insert, Update on ticketverwaltung.* to ticket_user@localhost;

Commit;
--
-- Daten Benutzer
--