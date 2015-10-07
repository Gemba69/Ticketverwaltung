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
    </head><
    <body>
        <c:import url="header.jsp">
            <c:param name="title" value="${requestScope.title}" /> 
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
                                    <tbody>
                                        <c:forEach items="${requestScope.projectList}" var="project">
                                            <c:forEach items="${project.tickets}" var="ticket">
                                                <tr>
                                                    <td>${ticket.ticketId}</td>
                                                    <td>${project.projectId}</td>
                                                    <td>${ticket.ticketName}</td>
                                                    <td>${ticket.ticketStatus.status}</td>
                                                    <td>${ticket.ticketIssuer.firstName} ${ticket.ticketIssuer.lastName}</td>
                                                    <td>${ticket.ticketAuthor.firstName} ${ticket.ticketAuthor.lastName} </td>
                                                    <td>${ticket.ticketPrio}</td>
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
        <%@include file="scripts.jsp" %>
    </body>
</html>
