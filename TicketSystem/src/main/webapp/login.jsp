<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="DoLogin" method="POST">
		<div class="ui-body ui-body-a">

			<label for="username">Name</label> <input type="text" name="username"
				id="username" data-clear-btn="true"></input> <label for="password">Password</label>
			<input type="password" name="password" id="password"
				data-clear-btn="true"></input>

		</div>
		<div class="ui-grid-a">
			<div class="ui-block-a">
				<div class="button-wrap-left">
					<button class="ui-btn ui-btn-b" type="submit">Login</button>
				</div>
			</div>
			<div class="ui-block-b">
				<div class="button-wrap-right">
					<a class="ui-btn ui-btn-b" href="register.jsp">Registrieren</a>
				</div>
			</div>
		</div>
	</form>

</body>
</html>