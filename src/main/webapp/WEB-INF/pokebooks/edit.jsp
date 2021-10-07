<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Expense</title>

<link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">
</head>
<body>

<h1>Edit Expense</h1>

<a href="/expenses">Go back</a>

<form:form action="/expenses/${pokeBook.id}" method="post" modelAttribute="pokeBook">
	 <input type="hidden" name="_method" value="put">

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
        
        <p>
        <form:label class= "form-label" path="description">Description</form:label>
        <form:errors path="description"/>
        <form:textarea class= "form-control" path="description"/>
    </p>
    </p>    
    <input type="submit" class= "btn btn-primary" value="Submit"/>
</form:form>


</body>
</html>