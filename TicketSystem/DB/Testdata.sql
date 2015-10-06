Use ticketverwaltung;
Insert Into User (Username, Passwort, Email) VALUES ('testuser', 'test', 'test@gmx.de');
Insert Into User (Username, Passwort, Email) VALUES ('testuser2', 'test', 'test@web.de');

Insert Into User_Role (Username, Role_Name) VALUES ('testuser', 'member');
Insert Into User_Role (Username, Role_Name) VALUES ('testuser2', 'member');

Insert Into Project (Project_Code, Project_Name, Project_Owner, Project_Desc, Project_Counter)
VALUES ('TEST', 'Testprojekt', 'testuser', 'Dies ist ein Testprojekt', 0);

Insert Into Ticket (Project_Code, Ticket_ID, Ticket_Name, Ticket_Issuer, Ticket_Author, Ticket_Desc, Ticket_Status)
VALUES ('TEST', '1', 'Testticket #1', 'testuser', 'testuser', 'Das erste Ticket', 'open');
Insert Into Ticket (Project_Code, Ticket_ID, Ticket_Name, Ticket_Issuer, Ticket_Author, Ticket_Desc, Ticket_Status)
VALUES ('TEST', '2', 'Testticket #2', 'testuser', 'testuser2', 'Das zweite Ticket', 'in work');
Insert Into Ticket (Project_Code, Ticket_ID, Ticket_Name, Ticket_Issuer, Ticket_Author, Ticket_Desc, Ticket_Status)
VALUES ('TEST', '3', 'Testticket #3', 'testuser2', 'testuser', 'Das dritte Ticket', 'done');

Update Project
	Set Project_Counter = 3
	Where Project_Code='TEST'
	;