<%-- 
    Document   : home
    Created on : 29-Sep-2015, 11:44:50
    Author     : Jonas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="head.jsp" %>
        <title>${requestScope.title}</title>
    </head>
    <body>
        <c:import url="header.jsp">
            <c:param name="title" value="${requestScope.title}" />
            <c:param name="username" value="Jonas Pöppelmann" />
        </c:import>
        <main>
            <div class="container">
                <div class="row">
                    <div class="col s12">
                        <div class="card">
                            <div class="card-content">
                                <table class="striped">
                                    <thead>
                                    <th>TicketNr</th>
                                    <th>ProjektNr</th>
                                    <th>Thema</th>
                                    <th>Status</th>
                                    <th>Bearbeiter</th>
                                    <th>Autor</th>
                                    <th>Priorität</th>
                                    </thead>
                                </table>
                                <ul class="collapsible" data-collapsible="accordion">                              	                             
                                    <c:forEach items="${requestScope.projectList}" var="project">
                                        <c:forEach items="${project.tickets}" var="ticket">                                       
                                            <li>
                                                <div class="collapsible-header">
                                                    <table>
                                                        <tbody>
                                                            <tr>
                                                                <td>${ticket.ticketId}</td>
                                                                <td>${project.projectId}</td>
                                                                <td>${ticket.ticketName}</td>
                                                                <td>${ticket.ticketStatus.status}</td>
                                                                <td>${ticket.ticketIssuer.firstName} ${ticket.ticketIssuer.lastName}</td>
                                                                <td>${ticket.ticketAuthor.firstName} ${ticket.ticketAuthor.lastName} </td>
                                                                <td>${ticket.ticketPrio}</td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </div>
                                                <div class="collapsible-body">
                                                    <div class="row">
                                                        <div class="col s5 offset-s1">
                                                            <ul>
                                                                <li><span class="prop-header blue-text">TicketNr</span><span class="right">${ticket.ticketId}</span></li>
                                                                <li><span class="prop-header blue-text">Thema</span><span class="right">${ticket.ticketName}</span></li>
                                                                <li><span class="prop-header blue-text">Status</span><span class="right">${ticket.ticketStatus.status}</span></li>
                                                                <li><span class="prop-header blue-text">Autor</span><span class="right">${ticket.ticketAuthor.firstName} ${ticket.ticketAuthor.lastName}</span></li>
                                                                <li><span class="prop-header blue-text">Bearbeiter</span><span class="right">${ticket.ticketIssuer.firstName} ${ticket.ticketIssuer.lastName}</span></li>
                                                                <li><span class="prop-header blue-text">Priorität</span><span class="right">${ticket.ticketPrio}</span></li>
                                                            </ul>
                                                        </div>
                                                        <div class="col s5">
                                                            <c:forEach items="${ticket.comments}" var="comm">
                                                                <div class="card-panel col s12 blue darken-3 white-text">
                                                                    ${comm.comment}<br>
                                                                    <span class="comment-author orange-text">${comm.commentIssuer.firstName} ${comm.commentIssuer.lastName}</span>
                                                                </div>
                                                            </c:forEach>
                                                            <div class="input-field col s12">
                                                                <textarea id="commentfield" class="materialize-textarea"></textarea>
                                                                <label for="commentfield">Kommentar schreiben</label>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </li>                                      
                                        </c:forEach>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <%@include file="createTicketModal.jsp" %>
        <%@include file="scripts.jsp" %>
    </body>
</html>
