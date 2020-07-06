<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Contacts</title>
</head>
<body>
     
     <h2>All_contact</h2>
	<a href="showForm">+add new Contact</a>
	<table border="1">
		<thead>
		     <tr>
			    <td>contactId</td>
				<td>contactName</td>
				<td>contactNum</td>
				<td>contactEmail</td>
				<td>Action</td>
			 </tr>
		  </thead>
		  <tbody>
			  <c:forEach items="${contacts}" var="contact">
					<tr>
						<td>${contact.contactId}</td>
						<td>${contact.contactName}</td>
						<td>${contact.contactNum}</td>
						<td>${contact.contactEmail}</td>
						<td><a href="updateContact?contactId=${contact.contactId }">edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp; 
							<a href="deleteContact?contactId=${contact.contactId }">delete</a></td>
					</tr>
				</c:forEach>
				</tbody>
				</table>


</body>
</html>