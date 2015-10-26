<%-- 
    Document   : 500
    Created on : 29-Sep-2015, 11:44:50
    Author     : Jonas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/head.jsp"%>
<title>Error ${param.code}</title>
</head>
<body>
	<c:import url="/WEB-INF/header.jsp">
		<c:param name="title" value="Error ${param.code}" />
		<c:param name="username"
			value="${sessionScope.user.vorname} ${sessionScope.user.nachname}" />
	</c:import>
	<main class="valign-wrapper">
		<div class="container">
			<h2 class="white-text valgin">Upps, da hat etwas nicht
				funktioniert.</h2>
		</div>
	</main>
	<%@include file="/WEB-INF/createModalsAndButtons.jsp"%>
	<%@include file="/WEB-INF/scripts.jsp"%>
</body>
</html>
