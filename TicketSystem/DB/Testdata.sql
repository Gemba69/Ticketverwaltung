Use ticketverwaltung;
Insert Into User (Username, Passwort, Email, vorname, nachname) VALUES ('testuser', '21232f297a57a5a743894a0e4a801fc3', 'test@gmx.de', 'Thomas', 'Tester');
Insert Into User (Username, Passwort, Email, vorname, nachname) VALUES ('rmertens', '21232f297a57a5a743894a0e4a801fc3', 'test@web.de', 'Dr Robert', 'Mertens');
Insert Into User (Username, Passwort, Email, vorname, nachname) VALUES ('bluhn', '21232f297a57a5a743894a0e4a801fc3', 'bluhn@web.de', 'Benni', 'Luhn');
Insert Into User (Username, Passwort, Email, vorname, nachname) VALUES ('jpoeppelmann', '21232f297a57a5a743894a0e4a801fc3', 'jpoeppemann@web.de', 'Jonas', 'Pöppelmann');
Insert Into User (Username, Passwort, Email, vorname, nachname) VALUES ('pklabunde', '21232f297a57a5a743894a0e4a801fc3', 'pklabunde@web.de', 'Philipp', 'Klabunde');
Insert Into User (Username, Passwort, Email, vorname, nachname) VALUES ('sbruns', '21232f297a57a5a743894a0e4a801fc3', 'sbruns@web.de', 'Simon', 'Bruns');

Insert Into User_Role (Username, Role_Name) VALUES ('testuser', 'member');
Insert Into User_Role (Username, Role_Name) VALUES ('rmertens', 'member');
Insert Into User_Role (Username, Role_Name) VALUES ('bluhn', 'admin');
Insert Into User_Role (Username, Role_Name) VALUES ('jpoeppelmann', 'admin');
Insert Into User_Role (Username, Role_Name) VALUES ('pklabunde', 'admin');
Insert Into User_Role (Username, Role_Name) VALUES ('sbruns', 'admin');

Insert Into Project (Project_Code, Project_Name, Project_Owner, Project_Desc, Project_Counter)
VALUES ('TEST', 'Testprojekt', 'admin', 'Dies ist ein Testprojekt', 0);
Insert Into Project (Project_Code, Project_Name, Project_Owner, Project_Desc, Project_Counter)
VALUES ('DEV', 'Entwicklungsprojekt', 'admin', 'Dies ist ein Entwicklungsprojekt', 0);
Insert Into Project (Project_Code, Project_Name, Project_Owner, Project_Desc, Project_Counter)
VALUES ('PROD', 'Produktivprojekt', 'bluhn', 'Dies ist ein Produktivprojekt', 0);

Insert Into Ticket (Project_Code, Ticket_ID, Ticket_Name, Ticket_Issuer, Ticket_Author, Ticket_Desc, Ticket_Status, Ticket_Priorität)
VALUES ('TEST', '1', 'Testticket #1', 'testuser', 'testuser', 'Das erste Ticket', 'offen', 1);
Insert Into Ticket (Project_Code, Ticket_ID, Ticket_Name, Ticket_Issuer, Ticket_Author, Ticket_Desc, Ticket_Status, Ticket_Priorität)
VALUES ('TEST', '2', 'Testticket #2', 'testuser', 'rmertens', 'Das zweite Ticket', 'in Arbeit', 2);
Insert Into Ticket (Project_Code, Ticket_ID, Ticket_Name, Ticket_Issuer, Ticket_Author, Ticket_Desc, Ticket_Status, Ticket_Priorität)
VALUES ('TEST', '3', 'Testticket #3', 'rmertens', 'testuser', 'Das dritte Ticket', 'geschlossen', 1);
Insert Into Ticket (Project_Code, Ticket_ID, Ticket_Name, Ticket_Issuer, Ticket_Author, Ticket_Desc, Ticket_Status, Ticket_Priorität)
VALUES ('TEST', '4', 'Testticket #4', 'bluhn', 'bluhn', 'Das vierte Ticket', 'in Arbeit', 3);
Insert Into Ticket (Project_Code, Ticket_ID, Ticket_Name, Ticket_Issuer, Ticket_Author, Ticket_Desc, Ticket_Status, Ticket_Priorität)
VALUES ('TEST', '5', 'Testticket #5', 'bluhn', 'bluhn', 'Das fünfte Ticket', 'geschlossen', 4);
Insert Into Ticket (Project_Code, Ticket_ID, Ticket_Name, Ticket_Issuer, Ticket_Author, Ticket_Desc, Ticket_Status, Ticket_Priorität)
VALUES ('TEST', '6', 'Testticket #6', 'pklabunde', 'pklabunde', 'Das sechste Ticket', 'in Arbeit', 5);
Insert Into Ticket (Project_Code, Ticket_ID, Ticket_Name, Ticket_Issuer, Ticket_Author, Ticket_Desc, Ticket_Status, Ticket_Priorität)
VALUES ('TEST', '7', 'Testticket #7', 'pklabunde', 'pklabunde', 'Das siebte Ticket', 'geschlossen', 3);
Insert Into Ticket (Project_Code, Ticket_ID, Ticket_Name, Ticket_Issuer, Ticket_Author, Ticket_Desc, Ticket_Status, Ticket_Priorität)
VALUES ('DEV', '1', 'Entwicklungsticket #1', 'sbruns', 'sbruns', 'Das erste Ticket', 'offen', 4);
Insert Into Ticket (Project_Code, Ticket_ID, Ticket_Name, Ticket_Issuer, Ticket_Author, Ticket_Desc, Ticket_Status, Ticket_Priorität)
VALUES ('DEV', '2', 'Entwicklungsticket #2', 'sbruns', 'sbruns', 'Das zweite Ticket', 'offen', 2);
Insert Into Ticket (Project_Code, Ticket_ID, Ticket_Name, Ticket_Issuer, Ticket_Author, Ticket_Desc, Ticket_Status, Ticket_Priorität)
VALUES ('DEV', '3', 'Entwicklungsticket #3', 'jpoeppelmann', 'jpoeppelmann', 'Das dritte Ticket', 'offen', 3);
Insert Into Ticket (Project_Code, Ticket_ID, Ticket_Name, Ticket_Issuer, Ticket_Author, Ticket_Desc, Ticket_Status, Ticket_Priorität)
VALUES ('DEV', '4', 'Entwicklungsticket #4', 'jpoeppelmann', 'jpoeppelmann', 'Das vierte Ticket', 'offen', 3);
Insert Into Ticket (Project_Code, Ticket_ID, Ticket_Name, Ticket_Issuer, Ticket_Author, Ticket_Desc, Ticket_Status, Ticket_Priorität)
VALUES ('DEV', '5', 'Entwicklungsticket #5', 'bluhn', 'jpoeppelmann', 'Das fünfte Ticket', 'offen', 1);
Insert Into Ticket (Project_Code, Ticket_ID, Ticket_Name, Ticket_Issuer, Ticket_Author, Ticket_Desc, Ticket_Status, Ticket_Priorität)
VALUES ('DEV', '6', 'Entwicklungsticket #6', 'pklabunde', 'jpoeppelmann', 'Das erste Ticket', 'offen', 5);
Insert Into Ticket (Project_Code, Ticket_ID, Ticket_Name, Ticket_Issuer, Ticket_Author, Ticket_Desc, Ticket_Status, Ticket_Priorität)
VALUES ('PROD', '1', 'Produktivticket #1', 'jpoeppelmann', 'bluhn', 'Das erste Ticket', 'offen', 3);
Insert Into Ticket (Project_Code, Ticket_ID, Ticket_Name, Ticket_Issuer, Ticket_Author, Ticket_Desc, Ticket_Status, Ticket_Priorität)
VALUES ('PROD', '2', 'Produktivticket #2', 'jpoeppelmann', 'sbruns', 'Das zweite Ticket', 'offen', 3);
Insert Into Ticket (Project_Code, Ticket_ID, Ticket_Name, Ticket_Issuer, Ticket_Author, Ticket_Desc, Ticket_Status, Ticket_Priorität)
VALUES ('PROD', '3', 'Produktivticket #3', 'sbruns', 'bluhn', 'Das dritte Ticket', 'offen', 2);
Insert Into Ticket (Project_Code, Ticket_ID, Ticket_Name, Ticket_Issuer, Ticket_Author, Ticket_Desc, Ticket_Status, Ticket_Priorität)
VALUES ('PROD', '4', 'Produktivticket #4', 'pklabunde', 'bluhn', 'Das vierte Ticket', 'offen', 5);
Insert Into Ticket (Project_Code, Ticket_ID, Ticket_Name, Ticket_Issuer, Ticket_Author, Ticket_Desc, Ticket_Status, Ticket_Priorität)
VALUES ('PROD', '5', 'Produktivticket #5', 'bluhn', 'sbruns', 'Das fünfte Ticket', 'offen', 3);

Update Project
	Set Project_Counter = 7
	Where Project_Code='TEST'
	;
Update Project
	Set Project_Counter = 6
	Where Project_Code='DEV'
	;
Update Project
	Set Project_Counter = 5
	Where Project_Code='PROD'
	;