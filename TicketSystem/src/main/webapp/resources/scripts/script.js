var bolCheckFirstname	= false;
var bolCheckSurname 	= false;
var bolCheckUser 		= false;
var bolCheckEmail 		= false;
var bolCheckPassword 	= false;

function checkPasswords(){
	var p1 = document.getElementById("password").value;
	var p2 = document.getElementById("confirmPassword").value;
	
	if (p1 !== p2){
		document.getElementById("registerButton").disabled = true;
		document.getElementById("jsErrorMessage_pw").innerHTML = "Die Passwoerter stimmen nicht ueberein.";	
		bolCheckPassword = false;
	} else {
		document.getElementById("jsErrorMessage_pw").innerHTML = "";
		document.getElementById("registerButton").disabled = false;
		bolCheckPassword = true;
		checkNecessaryInput();
	}
}

function checkEmail(){
	var p1 = document.getElementById("email").value;
	var schema = /^[^0-9][A-z0-9_]+([.][A-z0-9_]+)*[@][A-z0-9_]+([.][A-z0-9_]+)*[.][A-z]{2,4}$/;
	var matches = p1.match(schema);
	
	if (!matches){
		document.getElementById("registerButton").disabled = true;
		document.getElementById("jsErrorMessage_email").innerHTML = "Es werden nicht erlaubte Zeichen in der Email-Adresse verwendet";
		bolCheckEmail = false;
	} else {
		document.getElementById("jsErrorMessage_email").innerHTML = "";
		bolCheckEmail = true;
		checkNecessaryInput();
	}
}

function checkUsername(){
	var p1 = document.getElementById("username").value;
	var schema = /^[A-Za-z0-9]{1,32}$/;
	var matches = p1.match(schema);
	
	if (!matches){
		document.getElementById("registerButton").disabled = true;
		document.getElementById("jsErrorMessage_username").innerHTML = "Es werden nicht erlaubte Zeichen im Benutzernamen verwendet";
		bolCheckUser = false;
	} else {
		document.getElementById("jsErrorMessage_username").innerHTML = "";
		bolCheckUser = true;
		checkNecessaryInput();
	}
}

function checkFirstname(){
	var p1 = document.getElementById("firstname").value;
	var schema = /^[A-Za-z]{1,32}$/;
	var matches = p1.match(schema);
	
	if (!matches){
		document.getElementById("registerButton").disabled = true;
		document.getElementById("jsErrorMessage_firstname").innerHTML = "Es werden nicht erlaubte Zeichen im Vornamen verwendet";
		bolCheckFirstname = false;
	} else {
		document.getElementById("jsErrorMessage_firstname").innerHTML = "";
		bolCheckFirstname = true;
		checkNecessaryInput();
	}
}

function checkSurname(){
	var p1 = document.getElementById("surname").value;
	var schema = /^[A-Za-z]{1,32}$/;
	var matches = p1.match(schema);
	
	if (!matches){
		document.getElementById("registerButton").disabled = true;
		document.getElementById("jsErrorMessage_surname").innerHTML = "Es werden nicht erlaubte Zeichen im Nachnamen verwendet";
		bolCheckSurname = false;
	} else {
		document.getElementById("jsErrorMessage_surname").innerHTML = "";
		bolCheckSurname = true;
		checkNecessaryInput();
	}
}

function checkNecessaryInput(){
	
	if (bolCheckUser && bolCheckEmail && bolCheckPassword && bolCheckFirstname && bolCheckSurname){
		document.getElementById("jsErrorMessage_missingInput").innerHTML = "Korrekt!";
		document.getElementById("registerButton").disabled = false;
		document.getElementById("registerButton").classList.remove("disabled");
	} else {
		document.getElementById("registerButton").disabled = true;
		document.getElementById("jsErrorMessage_missingInput").innerHTML = "";
	}
}

function checkNecessaryLoginInput(){
	var p1 = document.getElementById("loginUser").value;
	var p2 = document.getElementById("loginPassword").value;
	
	if (p1 !== "" && p2 !== ""){
		document.getElementById("loginSubmit").disabled = false;
		document.getElementById("loginSubmit").classList.add("blueBorder");
	} else {
		document.getElementById("loginSubmit").disabled = true;
		document.getElementById("loginSubmit").classList.remove("blueBorder");
	}
}