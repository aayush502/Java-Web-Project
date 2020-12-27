<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
<a href = "StudentController?action=new_form">Add Student</a>
<input class="form-control" id="listSearch" type="text" placeholder="Type something to search list items">
<c:if test="${! empty students}">
<table class="table">
<thead>
<th>Id</th>
<th>Name</th>
<th>Grade</th>
<th>Roll</th>
<th>Gender</th>
</thead>
<tbody>

<c:forEach items="${students}" var="student">
<tr>
<td><c:out value="${student.id}"></c:out></td>
<td><c:out value="${student.name}"></c:out></td>
<td><c:out value="${student.grade}"></c:out></td>
<td><c:out value="${student.roll}"></c:out></td>
<td><c:out value="${student.gender}"></c:out></td>
<td><a href="StudentController?action=delete&id=${student.id}">Delete</a>
<td><a href="StudentController?action=edit&id=${student.id}">Edit</a>
</c:forEach>

</tbody>
</table>

</c:if>
<script type="text/javascript">

$(document).ready(function(){
	  $("#listSearch").on("keyup", function() {
	    var value = $(this).val().toLowerCase();
	    $("table tr").filter(function() {
	      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
	    });
	  });
	});

</script>
</body>
</html>