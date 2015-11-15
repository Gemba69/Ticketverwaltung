<%-- 
    Document   : home
    Created on : 29-Sep-2015, 11:44:50
    Author     : Jonas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="head.jsp"%>
<title>${requestScope.title}</title>
</head>
<body>
	<c:import url="header.jsp">
		<c:param name="title" value="${requestScope.title}" />
		<c:param name="username" value="${sessionScope.user.vorname} ${sessionScope.user.nachname}" />
	</c:import>
	<main>
	<div class="container">
		<div class="row">
			<div class="col s12">
				<div class="card">
					<div class="card-content">
						<table id="mainTable" class="striped tablesorter">
							<thead>
								<th>TicketNr</th>
								<th>Projektkürzel</th>
								<th>Thema</th>
								<th>Status</th>
								<th>Bearbeiter</th>
								<th>Autor</th>
								<th>Priorität</th>
							</thead>
							<tbody>
								<c:forEach items="${requestScope.projectList}" var="project">
									<c:forEach items="${project.tickets}" var="ticket">
										<tr class="modal-trigger" href="#modal${project.projectCode}${ticket.id.ticketId}">
											<td>${ticket.id.ticketId}</td>
											<td>${project.projectCode}</td>
											<td>${ticket.ticketName}</td>
											<td>${ticket.statusTyp.status}</td>
											<td>${ticket.userByTicketIssuer.vorname}
												${ticket.userByTicketIssuer.nachname}</td>
											<td>${ticket.userByTicketAuthor.vorname}
												${ticket.userByTicketAuthor.nachname}</td>
											<td>${ticket.ticketPrioritaet}</td>
										</tr>
									</c:forEach>
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
		<c:forEach items="${project.tickets}" var="ticket">
			<div id="modal${project.projectCode}${ticket.id.ticketId}"
				class="modal">
				<div class="modal-content">
					<div class="row">
						<div class="col s5 offset-s1">
							<form action="ModifyTicket" method="post" accept-charset="UTF-8">
								<input type="hidden" name="ticketId"
									value="${ticket.id.ticketId}"> <input type="hidden"
									name="projectCode" value="${project.projectCode}">
								<table class="bordered">
									<tbody>
										<tr>
											<td><span class="prop-header blue-text">TicketNr</span></td>
											<td><span class="right">${ticket.id.ticketId}</span></td>
										</tr>
										<tr>
											<td><span class="prop-header blue-text">Thema</span></td>
											<td><span class="right">${ticket.ticketName}</span></td>
										</tr>
										<tr>
											<td><span class="prop-header blue-text">Status</span></td>
											<td>
												<div class="input-field">
													<select name="ticketStatus">
														<option value="${ticket.statusTyp.status}" selected>${ticket.statusTyp.status}</option>
														<c:forEach items="${applicationScope.statusTypes}"
															var="st">
															<c:if test="${st.status != ticket.statusTyp.status}">
																<option value="${st.status}">${st.status}</option>
															</c:if>
														</c:forEach>
													</select>
												</div>
											</td>
										</tr>
										<tr>
											<td><span class="prop-header blue-text">Autor</span></td>
											<td><span class="right">${ticket.userByTicketAuthor.vorname}
													${ticket.userByTicketAuthor.nachname}</span></td>
										</tr>
										<tr>
											<td><span class="prop-header blue-text">Bearbeiter</span></td>
											<td>
												<div class="input-field">
													<select name="issuer">
														<option value="${ticket.userByTicketIssuer.username}"
															selected>${ticket.userByTicketIssuer.vorname}
															${ticket.userByTicketIssuer.nachname}</option>
														<c:forEach items="${applicationScope.users}" var="user">
															<option value="${user.username}">${user.vorname}
																${user.nachname}</option>
														</c:forEach>
													</select>
												</div>
											</td>
										</tr>
										<tr>
											<td><span class="prop-header blue-text">Prioritaet</span></td>
											<td>
												<div class="input-field">
													<select name="priority">
														<c:forEach var="counter" begin="1" end="5">
															<c:choose>
																<c:when test="${ticket.ticketPrioritaet != counter}">
																	<option value="${counter}">${counter}</option>
																</c:when>
																<c:otherwise>
																	<option value="${counter}" selected>${counter}</option>
																</c:otherwise>
															</c:choose>
														</c:forEach>
													</select>
												</div>
											</td>
										</tr>
										<tr>
											<td><span class="prop-header blue-text">Beschreibung</span></td>
											<td><span class="right">${ticket.ticketDesc}</span></td>
										</tr>
									</tbody>
								</table>
								<div class="input-field col s7 offset-s6">
									<button class="waves-effect waves-light btn blue" type="submit">
										<i class="material-icons seft">save</i>Speichern
									</button>
								</div>
							</form>
						</div>
						<div class="col s5">
							<c:forEach items="${ticket.comments}" var="comm">
								<div class="card-panel col s12 blue white-text">
									${comm.comment}<br> <span
										class="comment-author orange-text">${comm.user.vorname}
										${comm.user.nachname}</span>
								</div>
							</c:forEach>
							<!-- TODO: AJAX  -->
							<form action="PostComment" method="post" accept-charset="UTF-8">
								<input type="hidden" name="ticketId"
									value="${ticket.id.ticketId}"> <input type="hidden"
									name="projectCode" value="${project.projectCode}">

								<div class="input-field col s12">
									<textarea id="commentfield" class="materialize-textarea"
										name="comment"></textarea>
									<label for="commentfield">Kommentar schreiben</label>
								</div>
								<input type="submit" class="btn blue"
									value="Kommentar abschicken">
							</form>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</c:forEach>
	<%@include file="createModalsAndButtons.jsp" %>
	<%@include file="scripts.jsp"%>
</body>
</html>
