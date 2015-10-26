<c:forEach items="${sessionScope.user.roles}" var="role">
	<c:if test="${role.roleName == 'admin'}">
		<c:set var="projectRights" scope="page" value="true" />
	</c:if>
</c:forEach>

<c:choose>
	<c:when test="${projectRights}">
		<%@include file="createTicketAndProjectFloatButton.jsp"%>
		<%@include file="createProjectModal.jsp" %>
	</c:when>
	<c:otherwise>
		<%@include file="createTicketFloatButton.jsp"%>
	</c:otherwise>
</c:choose>
<%@include file="createTicketModal.jsp"%>