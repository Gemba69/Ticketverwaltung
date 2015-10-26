<%-- 
    Document   : home
    Created on : 29-Sep-2015, 11:44:50
    Author     : Jonas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="head.jsp"%>
<title>${requestScope.title}</title>
</head>
<body>
	<c:import url="header.jsp">
		<c:param name="title" value="${requestScope.title}" />
		<c:param name="username"
			value="${sessionScope.user.vorname} ${sessionScope.user.nachname}" />
	</c:import>
	<main>
	<div class="container">
		<div class="row">
			<div class="col s12">
				<div class="card">
					<div class="card-content">
						<table class="striped">
							<thead>
								<th>Projektkürzel</th>
								<th>Projektname</th>
								<th>Projektleiter</th>
								<th></th>
							</thead>
							<tbody>
								<c:forEach items="${requestScope.projectList}" var="project">
									<tr>
										<td class="modal-trigger" href="#modal${project.projectCode}">${project.projectCode}</td>
										<td class="modal-trigger" href="#modal${project.projectCode}">${project.projectName}</td>
										<td class="modal-trigger" href="#modal${project.projectCode}">${project.user.vorname}${project.user.nachname}</td>
										<td><a
											href="home?view=all&project=${project.projectCode}"
											class="btn waves-effect waves-ligh"><i
												class="material-icons left">trending_flat</i>Tickets</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	</main>
	<!-- Modals für die Detailansicht -->
	<c:forEach items="${requestScope.projectList}" var="project">
		<div id="modal${project.projectCode}" class="modal">
			<div class="modal-content">
				<div class="row">
					<div class="col s5 offset-s1">
						<input type="hidden" name="ticketId" value="${ticket.id.ticketId}">
						<input type="hidden" name="projectCode"
							value="${project.projectCode}">
						<table class="bordered">
							<tbody>
								<tr>
									<td><span class="prop-header blue-text">Projektkürzel</span></td>
									<td><span class="right">${project.projectCode}</span></td>
								</tr>
								<tr>
									<td><span class="prop-header blue-text">Projektname</span></td>
									<td><span class="right">${project.projectName}</span></td>
								</tr>
								<tr>
									<td><span class="prop-header blue-text">Projektleiter</span></td>
									<td><span class="right">${project.user.vorname}
											${project.user.nachname}</span></td>
								</tr>
								<tr>
									<td><span class="prop-header blue-text">Beschreibung</span></td>
									<td><span class="right">${project.projectDesc}</span></td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="col s5">
						<table class="bordered">
							<tbody>
								<tr>
									<td><span class="prop-header blue-text">Offene
											Tickets</span></td>
									<td><c:forEach items="${project.tickets}" var="ticket">
											<c:if test="${ticket.statusTyp.status=='open'}">
												<span class="right">${ticket.ticketName}</span>
												<br>
											</c:if>
										</c:forEach></td>
								</tr>
								<tr>
									<td><span class="prop-header blue-text">Tickets in
											Bearbeitung</span></td>
									<td><c:forEach items="${project.tickets}" var="ticket">
											<c:if test="${ticket.statusTyp.status=='in work'}">
												<span class="right">${ticket.ticketName}</span>
												<br>
											</c:if>
										</c:forEach></td>
								</tr>
								<tr>
									<td><span class="prop-header blue-text">Geschlossene
											Tickets</span></td>
									<td><c:forEach items="${project.tickets}" var="ticket">
											<c:if test="${ticket.statusTyp.status=='done'}">
												<span class="right">${ticket.ticketName}</span>
												<br>
											</c:if>
										</c:forEach></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		</div>
	</c:forEach>
	<%@include file="createModalsAndButtons.jsp"%>
	<%@include file="scripts.jsp"%>
</body>
</html>
