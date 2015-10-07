<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>		
		<%@include file="WEB-INF/head.jsp" %>
		<script src="resources/scripts/script.js"></script>
		<title>Registrierung</title>
	</head>
	<body>
		
		<form method="POST" action="DoRegister">
			<div class="Container">
				<div class="row">
					<div class="col s4 offset-s4">
						<div class="card blue-grey darken-1">
							<div class="card-content white-text">
								<span class="card-title">Registrierung</span>
								<c:if test="${failwarning == true}">
                                    <p id="servletErrorMessage" class="red-text">Der Benutzername <em>${username}</em> existiert bereits!</p>
                                </c:if>
                                <p id="jsErrorMessage_pw" class="red-text"></p>
                                <p id="jsErrorMessage_username" class="red-text"></p>
                                <p id="jsErrorMessage_email" class="red-text"></p>
                                <p id="jsErrorMessage_firstname" class="red-text"></p>
                                <p id="jsErrorMessage_surname" class="red-text"></p>
                                <p id="jsErrorMessage_missingInput" class="green-text"></p>
                                
                                <div class="input-field">                            
                            		<input id="firstname" type="text" name="firstname" onkeyup="checkFirstname()">
                            		<label for="firstname">Vorname</label>
                            	</div>
                            	<div class="input-field">
									<input id="surname" type="text" name="surname" onkeyup="checkSurname()">
									<label for="surname">Nachname</label>
								</div>
								<div class="input-field">
									<input id="username" type="text" name="username" onkeyup="checkUsername()">
									<label for="username">Benutzername</label>
								</div>
								<div class="input-field">
									<input id="email" type="text" name="email" onkeyup="checkEmail()">
									<label for="email">Email-Adresse</label>
								</div>
								<div class="input-field">	
									<input id="password" type="password" name="password" onkeyup="checkPasswords()"><br>
									<label for="password">Passwort</label>
								</div>
								<div class="input-field">	
									<input id="confirmPassword" type="password" name="password" onkeyup="checkPasswords()"><br>
									<label for="confirmPassword">Passwort bestätigen</label>
								</div>
								<div class="card-action">
									<button id="registerButton" class="btn waves-effect waves-light disabled" type="submit" name="action" disabled> Registrieren
										<i class="material-icons right">send</i>
									</button>
								</div>
							</div>
						</div>
					</div>
				</div>	
			</div>
		</form>
		<%@include file="WEB-INF/scripts.jsp" %>
	</body>
</html>