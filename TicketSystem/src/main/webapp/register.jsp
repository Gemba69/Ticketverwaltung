<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrierung</title>
</head>
<body>
	<p> Bitte geben Sie Ihre Daten ein: </p>
	<form method="POST" action="DoRegister">
		Vorname: <input type="text" name="firstname"><br>
		Nachname: <input type="text" name="surname"><br>
		Benutzername: <input type="text" name="username"><br>
		Email-Adresse: <input type="text" name="email"><br>	
		passwort: <input type="password" name="password"><br>
		<input type="submit">	
	</form>

</body>
</html>