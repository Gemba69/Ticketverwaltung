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
                                    <th>Projektkürzel</th>
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
                                                                <td>${ticket.id.ticketId}</td>
                                                                <td>${project.projectCode}</td>
                                                                <td>${ticket.ticketName}</td>
                                                                <td>${ticket.statusTyp.status}</td>
                                                                <td>${ticket.userByTicketIssuer.vorname} ${ticket.userByTicketIssuer.nachname}</td>
                                                                <td>${ticket.userByTicketAuthor.vorname} ${ticket.userByTicketAuthor.nachname} </td>
                                                                <td>${ticket.ticketPriorität}</td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </div>
                                                <div class="collapsible-body grey darken-2 white-text">
                                                    <div class="row">
                                                        <div class="col s5 offset-s1">
                                                            <table class="bordered">
                                                            <tbody>
                                                                <tr><td><span class="prop-header blue-text">TicketNr</span></td><td><span class="right">${ticket.id.ticketId}</span></td></tr>
                                                                <tr><td><span class="prop-header blue-text">Thema</span></td><td><span class="right">${ticket.ticketName}</span></td></tr>
                                                                <tr>
                                                                	<td>
                                                               			<span class="prop-header blue-text">Status</span>
                                                             		</td>
                                                             		<td>
                                                             		 <div class="input-field">
																	    <select>
																	      <option value="${ticket.statusTyp.status}" selected>${ticket.statusTyp.status}</option>
																	      <c:forEach items="${applicationScope.statusTypes}" var="st">
																	      	<c:if test="${st.status != ticket.statusTyp.status}">
																	      		<option value="${st.status}">${st.status}</option>
																	      	</c:if>
																	      </c:forEach>
																	    </select>	
																	  </div>
                                                            		</td>
                                                            	</tr>
                                                                <tr><td><span class="prop-header blue-text">Autor</span></td><td><span class="right">${ticket.userByTicketAuthor.vorname} ${ticket.userByTicketAuthor.nachname}</span></td></tr>
                                                                <tr>
                                                                	<td>
                                                                		<span class="prop-header blue-text">Bearbeiter</span>
                                                               		</td>
                                                              		<td>
                                                              		 	<div class="input-field">
																	    	<select>
																	    		<option value="${ticket.userByTicketIssuer.username}" selected>${ticket.userByTicketIssuer.vorname} ${ticket.userByTicketIssuer.nachname}</option>
																    			<c:forEach items="${applicationScope.users}" var="user">
																    				<option value="${user.username}">${user.vorname} ${user.nachname}</option>
																    			</c:forEach>
																	    	</select>	
																	 	 </div>
                                                           			</td>
                                                       			</tr>
                                                                <tr>
                                                                	<td>
                                                                		<span class="prop-header blue-text">Priorität</span>
                                                               		</td>
                                                         			<td>
                                                         				<div class="input-field">
																	    	<select>
																    			<c:forEach var="counter" begin="1" end="5">
																    				<c:choose>
																    					<c:when test="${ticket.ticketPriorität != counter}">
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
																<tr><td><span class="prop-header blue-text">Beschreibung</span></td><td><span class="right">${ticket.ticketDesc}</span></td></tr>
															</tbody>
															</table>
															<div class="input-field col s7 offset-s6">
																<a href="#" class="waves-effect waves-light btn blue"><i class="material-icons left">save</i>Speichern</a>															
															</div>

                                                        </div>
                                                        <div class="col s5">
                                                            <c:forEach items="${ticket.comments}" var="comm">
                                                                <div class="card-panel col s12 blue darken-3 white-text">
                                                                    ${comm.comment}<br>
                                                                    <span class="comment-author orange-text">${comm.user.vorname} ${comm.user.nachname}</span>
                                                                </div>
                                                            </c:forEach>
                                                            <form action="PostComment">
	                                                            <div class="input-field col s12">
	                                                                <textarea id="commentfield" class="materialize-textarea"></textarea>
	                                                                <label for="commentfield">Kommentar schreiben</label>
	                                                            </div>
	                                                            <input type="submit" class="btn blue" value="Kommentar abschicken">
                                                            </form>
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
