<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
      <!-- c:out ; c:forEach ; c:if -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
   <!-- Formatting (like dates) -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
   <!-- form:form -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
   <!-- for rendering errors on PUT routes -->
 <%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pokebook Home</title>
<link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">
</head>
<body>

<h1> PokeBook </h1>

<table class="table table-striped">
	<tr>
		<th>
		Expense
		</th>
		
		<th>
		Vendor
		</th>
		
		<th>
		Amount
		</th>
		
		<th>
		Actions
		</th>
	</tr>
	
	<tbody>
	<c:forEach var="pokeBook" items = "${ pokeBooks }">
	<tr>
		<td>
		<a href="expenses/${ pokeBook.id }"><c:out value="${ pokeBook.expense }"/></a>
		</td>
		
		<td>
		<c:out value="${ pokeBook.vendor }"/>
		</td>
		
		<td>
		$<c:out value="${ pokeBook.amount }"/>
		</td>
		
		<td>
		<a href="expenses/${ pokeBook.id }/edit">edit</a>
		<form action="/expenses/${ pokeBook.id}" method="post">
    	<input type="hidden" name="_method" value="delete">
    	<input type="submit" class= "btn btn-danger" value="Delete">
		</form>
		
		</td>
	
	
	</c:forEach>
	</tbody>
</table>

<h2>Track an Expense</h2>

<form:form action="/expenses/new" method="post" modelAttribute="pokeBook">
    <p>
        <form:label class= "form-label" path="expense">Expense</form:label>
        <form:errors path="expense"/>
        <form:input class= "form-control" path="expense"/>
    </p>
    <p>
        <form:label class= "form-label" path="vendor">Vendor</form:label>
        <form:errors path="vendor"/>
        <form:input class= "form-control" path="vendor"/>
    </p>
    <p>
        <form:label class= "form-label" path="amount">Amount</form:label>
        <form:errors path="amount"/>
        <form:input class= "form-control" type="number" path="amount"/>
    </p>
    <p>
        <form:label class= "form-label" path="description">Description</form:label>
        <form:errors path="description"/>     
        <form:textarea class= "form-control" path="description"/>
    </p>    
    <input type="submit" class= "btn btn-primary" value="Submit"/>
</form:form>



</body>
</html>