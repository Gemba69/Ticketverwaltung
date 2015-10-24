<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="head.jsp" %>
        <title>Login</title>
    </head>
    <body>
        <form action="j_security_check" method="POST">
            <div class="container">
                <div class="row">
                    <div class="col s4 offset-s4">
                        <div class="card">
                            <div class="card-image">
                                <img src="resources/crap/login.jpg">
                                <span class="card-title">Login</span>
                            </div>
                            <div class="card-content">
                                <c:if test="${param.failed == 'true'}">
                                    <p class="red-text">Falsche Benutzerdaten.</p>
                                </c:if>
                                <div class="input-field">
                                    <input id="j_username" name="j_username" type="text" class="validate" />
                                    <label for="j_username">Benutzername</label>
                                </div>
                                <div class="input-field">
                                    <input id="j_password" name="j_password" type="password" class="validate" />
                                    <label for="j_password">Passwort</label>
                                </div>
                                <button class="btn waves-effect waves-light blue center-align" type="submit" name="action">Login
                                    <i class="material-icons right">send</i>
                                </button>
                                <a href="/TicketSystem/register.jsp" class="btn waves-effect waves-light green right" type="submit" name="action">Zur Registrierung</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <%@include file="scripts.jsp" %>
    </body>
</html>