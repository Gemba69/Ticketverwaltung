Create Table If Not Exists `Right` (
  `Right_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Right_Name` varchar(40) NOT NULL,
  `Right_Desc` varchar(1000) NOT NULL,
   PRIMARY KEY (`Right_ID`),
   UNIQUE KEY `UNIQUE_NAME` (`Right_Name`)
   ) ;
   
Create Table If Not Exists `Role` (
  `Role_ID` int(11) NOT NULL AUTO_INCREMENT,
  `BearbeiterName` varchar(40) NOT NULL,
  `Email` varchar(40) NOT NULL,
   PRIMARY KEY (`BearbeiterID`),
   UNIQUE KEY `UNIQUE_NAME` (`BearbeiterName`),
   UNIQUE KEY `UNIQUE_EMAIL` (`Email`)
   ) ;
   
Create Table If Not Exists `Role_Right` (
  `Role_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Right_ID` varchar(40) NOT NULL,
  `Email` varchar(40) NOT NULL,
   PRIMARY KEY (`BearbeiterID`),
   UNIQUE KEY `UNIQUE_NAME` (`BearbeiterName`),
   UNIQUE KEY `UNIQUE_EMAIL` (`Email`)
   ) ;
   
Create Table If Not Exists `Benutzer` (
  `Nutzername` varchar(40) NOT NULL,
  `Passwort` varchar(40) NOT NULL,
  `Email` varchar(40) NOT NULL,
  `Name` varchar(40) NOT NULL,
  `Role_ID` int(11) NOT NULL,
   PRIMARY KEY (`BearbeiterID`),
   UNIQUE KEY `UNIQUE_NAME` (`BearbeiterName`),
   UNIQUE KEY `UNIQUE_EMAIL` (`Email`)
   ) ;
   
Create Table If Not Exists `Project` (
  `BearbeiterID` int(11) NOT NULL AUTO_INCREMENT,
  `BearbeiterName` varchar(40) NOT NULL,
  `Email` varchar(40) NOT NULL,
   PRIMARY KEY (`BearbeiterID`),
   UNIQUE KEY `UNIQUE_NAME` (`BearbeiterName`),
   UNIQUE KEY `UNIQUE_EMAIL` (`Email`)
   ) ;
   
Create Table If Not Exists `Ticket` (
  `BearbeiterID` int(11) NOT NULL AUTO_INCREMENT,
  `BearbeiterName` varchar(40) NOT NULL,
  `Email` varchar(40) NOT NULL,
   PRIMARY KEY (`BearbeiterID`),
   UNIQUE KEY `UNIQUE_NAME` (`BearbeiterName`),
   UNIQUE KEY `UNIQUE_EMAIL` (`Email`)
   ) ;
   
Create Table If Not Exists `Status_Typ` (
  `BearbeiterID` int(11) NOT NULL AUTO_INCREMENT,
  `BearbeiterName` varchar(40) NOT NULL,
  `Email` varchar(40) NOT NULL,
   PRIMARY KEY (`BearbeiterID`),
   UNIQUE KEY `UNIQUE_NAME` (`BearbeiterName`),
   UNIQUE KEY `UNIQUE_EMAIL` (`Email`)
   ) ;
   
Create Table If Not Exists `Comment` (
  `BearbeiterID` int(11) NOT NULL AUTO_INCREMENT,
  `BearbeiterName` varchar(40) NOT NULL,
  `Email` varchar(40) NOT NULL,
   PRIMARY KEY (`BearbeiterID`),
   UNIQUE KEY `UNIQUE_NAME` (`BearbeiterName`),
   UNIQUE KEY `UNIQUE_EMAIL` (`Email`)
   ) ;
   
Create Table If Not Exists `Ticket_Comment` (
  `BearbeiterID` int(11) NOT NULL AUTO_INCREMENT,
  `BearbeiterName` varchar(40) NOT NULL,
  `Email` varchar(40) NOT NULL,
   PRIMARY KEY (`BearbeiterID`),
   UNIQUE KEY `UNIQUE_NAME` (`BearbeiterName`),
   UNIQUE KEY `UNIQUE_EMAIL` (`Email`)
   ) ;
   
Create Table If Not Exists `Tag` (
  `BearbeiterID` int(11) NOT NULL AUTO_INCREMENT,
  `BearbeiterName` varchar(40) NOT NULL,
  `Email` varchar(40) NOT NULL,
   PRIMARY KEY (`BearbeiterID`),
   UNIQUE KEY `UNIQUE_NAME` (`BearbeiterName`),
   UNIQUE KEY `UNIQUE_EMAIL` (`Email`)
   ) ;
   
Create Table If Not Exists `Ticket_Tag` (
  `BearbeiterID` int(11) NOT NULL AUTO_INCREMENT,
  `BearbeiterName` varchar(40) NOT NULL,
  `Email` varchar(40) NOT NULL,
   PRIMARY KEY (`BearbeiterID`),
   UNIQUE KEY `UNIQUE_NAME` (`BearbeiterName`),
   UNIQUE KEY `UNIQUE_EMAIL` (`Email`)
   ) ;
   
GRANT ALL PRIVILEGES ON *.* TO 'ticket_user'@'localhost' IDENTIFIED BY PASSWORD '*01A6717B58FF5C7EAFFF6CB7C96F7428EA65FE4C' WITH GRANT OPTION;