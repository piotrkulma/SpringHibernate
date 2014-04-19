<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Spring4 MVC -HelloWorld</title>
</head>
<body>
	<c:choose>
		<c:when test="${fn:length(users)> 0}">
			<table>
			<c:forEach items="${users}" var="u">
				<tr>
					<td>${u.id} ${u.firstName} ${u.secondName} ${u.birthDate} </td>
				</tr>
			</c:forEach>
			</table>
		</c:when>
		<c:otherwise>NO DATA</c:otherwise>
	</c:choose>
	<br/>
	<sf:form method="POST" modelAttribute="user">
		<table>
			<tr>
				<th style="text-align: left;"><sf:label path="firstName">FirstName:</sf:label></th>
				<td><sf:input path="firstName"/><sf:errors path="firstName"/></td>
			</tr>
			<tr>
				<th style="text-align: left;"><sf:label cssStyle="text-align: left;" path="secondName">SecondName:</sf:label></th>
				<td><sf:input path="secondName"/><sf:errors path="secondName"/></td>
			</tr>
			<tr>
				<th style="text-align: left;"><sf:label cssStyle="text-align: left;" path="birthDate">BirthDate:</sf:label></th>
				<td><sf:input path="birthDate"/><sf:errors path="birthDate"/></td>
			</tr>
			<tr>
				<th></th>
				<td><input name="Register" type="submit"/></td>
			</tr>
		</table>
	</sf:form>
</body>
</html>