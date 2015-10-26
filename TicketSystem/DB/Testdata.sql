Use ticketverwaltung;
Insert Into User (Username, Passwort, Email) VALUES ('testuser', 'test', 'test@gmx.de');
Insert Into User (Username, Passwort, Email) VALUES ('testuser2', 'test', 'test@web.de');

Insert Into User_Role (Username, Role_Name) VALUES ('testuser', 'member');
Insert Into User_Role (Username, Role_Name) VALUES ('testuser2', 'member');

Insert Into Project (Project_Code, Project_Name, Project_Owner, Project_Desc, Project_Counter)
VALUES ('TEST', 'Testprojekt', 'admin', 'Dies ist ein Testprojekt', 0);
Insert Into Project (Project_Code, Project_Name, Project_Owner, Project_Desc, Project_Counter)
VALUES ('DEV', 'Entwicklungsprojekt', 'admin', 'Dies ist ein Entwicklungsprojekt', 0);

Insert Into Ticket (Project_Code, Ticket_ID, Ticket_Name, Ticket_Issuer, Ticket_Author, Ticket_Desc, Ticket_Status)
VALUES ('TEST', '1', 'Testticket #1', 'testuser', 'testuser', 'Das erste Ticket', 'offen');
Insert Into Ticket (Project_Code, Ticket_ID, Ticket_Name, Ticket_Issuer, Ticket_Author, Ticket_Desc, Ticket_Status)
VALUES ('TEST', '2', 'Testticket #2', 'testuser', 'testuser2', 'Das zweite Ticket', 'in Arbeit');
Insert Into Ticket (Project_Code, Ticket_ID, Ticket_Name, Ticket_Issuer, Ticket_Author, Ticket_Desc, Ticket_Status)
VALUES ('TEST', '3', 'Testticket #3', 'testuser2', 'testuser', 'Das dritte Ticket', 'geschlossen');
Insert Into Ticket (Project_Code, Ticket_ID, Ticket_Name, Ticket_Issuer, Ticket_Author, Ticket_Desc, Ticket_Status)
VALUES ('DEV', '1', 'Entwicklungsticket #1', 'testuser', 'testuser2', 'Das erste Ticket', 'offen');
Insert Into Ticket (Project_Code, Ticket_ID, Ticket_Name, Ticket_Issuer, Ticket_Author, Ticket_Desc, Ticket_Status)
VALUES ('DEV', '2', 'Entwicklungsticket #2', 'testuser2', 'testuser', 'Das zweite Ticket', 'offen');

Update Project
	Set Project_Counter = 3
	Where Project_Code='TEST'
	;