// !JavaScript für register.jsp und login.jsp!
//
// Eingaben werden vom Script vor der Datenbank geprüft. Registrierung erst bei 
// erlaubten Eingaben möglich (disabled Button)
//
// Login erst bei Eingabe in die beiden Felder möglich.

var bolCheckFirstname	= false;
var bolCheckSurname 	= false;
var bolCheckUser 		= false;
var bolCheckEmail 		= false;
var bolCheckPassword 	= false;
var bolErrorInfoFirstName 	= true;
var bolErrorInfoUser		= true;
var bolErrorInfoEMail		= true;
var bolErrorInfoSurName 	= true;
var bolErrorInfoPassword 	= true;


function checkPasswords(){
	var p1 = document.getElementById("password").value;
	var p2 = document.getElementById("confirmPassword").value;
	var bolPwInput = false;
	
	if (p1 == null || p1 == ""){
		bolPwInput = true;
	}
	
	if (p1 !== p2 || bolPwInput){
		bolCheckPassword = false;
		bolErrorInfoPassword = false;
		document.getElementById("registerButton").disabled = true;
		document.getElementById("jsErrorMessage_pw").innerHTML = "Passwörter stimmen nicht überein";
		checkErrorInfo();
	} else {
		bolCheckPassword = true;
		bolErrorInfoPassword = true;
		document.getElementById("registerButton").disabled = false;	
		document.getElementById("jsErrorMessage_pw").innerHTML = "";
		checkErrorInfo();
		checkNecessaryInput();
	}
}

function checkEmail(){
	var p1 = document.getElementById("email").value;
	var schema = /^[^0-9][A-z0-9_]+([.][A-z0-9_]+)*[@][A-z0-9_]+([.][A-z0-9_]+)*[.][A-z]{2,4}$/;
	var matches = p1.match(schema);
	
	if (!matches){
		bolCheckEmail = false;
		bolErrorInfoEMail = false;
		document.getElementById("registerButton").disabled = true;
		document.getElementById("jsErrorMessage_email").innerHTML = "Email";
		checkErrorInfo();
	} else {
		bolCheckEmail = true;
		bolErrorInfoEMail = true;
		document.getElementById("jsErrorMessage_email").innerHTML = "";
		checkErrorInfo();
		checkNecessaryInput();
	}
}

function checkUsername(){
	var p1 = document.getElementById("username").value;
	var schema = /^[A-Za-z0-9öäüÖÄÜ]{1,32}$/;
	var matches = p1.match(schema);
	
	if (!matches){
		bolErrorInfoUser = false;
		bolCheckUser = false;
		document.getElementById("registerButton").disabled = true;
		document.getElementById("jsErrorMessage_username").innerHTML = "Benutzername";
		checkErrorInfo();
	} else {
		bolCheckUser = true;
		bolErrorInfoUser = true;
		document.getElementById("jsErrorMessage_username").innerHTML = "";
		checkErrorInfo();
		checkNecessaryInput();
	}
}

function checkFirstname(){
	var p1 = document.getElementById("firstname").value;
	var schema = /^[A-Za-zöäüÖÄÜ]{1,32}$/;
	var matches = p1.match(schema);
	
	if (!matches){
		bolCheckFirstname = false;
		bolErrorInfoFirstName = false;
		document.getElementById("registerButton").disabled = true;
		document.getElementById("jsErrorMessage_firstname").innerHTML = "Vorname";
		checkErrorInfo();	
	} else {
		bolCheckFirstname = true;
		bolErrorInfoFirstName = true;
		document.getElementById("jsErrorMessage_firstname").innerHTML = "";
		checkErrorInfo();
		checkNecessaryInput();
	}
}

function checkErrorInfo() {
	if (bolErrorInfoUser && bolErrorInfoFirstName && bolErrorInfoEMail &&bolErrorInfoSurName && bolErrorInfoPassword){
		document.getElementById("hideElementId").hidden = true;
	} else {
		document.getElementById("hideElementId").hidden = false;
	}
}

function checkSurname(){
	var p1 = document.getElementById("surname").value;
	var schema = /^[A-Za-zöäüÖÄÜ]{1,32}$/;
	var matches = p1.match(schema);
	
	if (!matches){
		bolCheckSurname = false;
		bolErrorInfoSurName = false;
		document.getElementById("registerButton").disabled = true;	
		document.getElementById("jsErrorMessage_surname").innerHTML = "Nachname";
		checkErrorInfo();
		
	} else {
		bolCheckSurname = true;
		bolErrorInfoSurName = true;
		document.getElementById("jsErrorMessage_surname").innerHTML = "";
		checkErrorInfo();
		checkNecessaryInput();
	}
}

function checkNecessaryInput(){
	
	if (bolCheckUser && bolCheckEmail && bolCheckPassword && bolCheckFirstname && bolCheckSurname){
		document.getElementById("registerButton").disabled = false;
		document.getElementById("registerButton").classList.remove("disabled");
	} else {
		document.getElementById("registerButton").disabled = true;
	}
}