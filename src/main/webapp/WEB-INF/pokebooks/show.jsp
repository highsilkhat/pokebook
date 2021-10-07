<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${ pokeBook.expense }"/></title>
</head>
<body>

<h1> Expense Details </h1>

<a href="/expenses">Go back</a>

<p> Expense Name: <c:out value="${ pokeBook.expense }"/>
<p> Expense Description: <c:out value="${ pokeBook.description }"/>
<p> Vendor: <c:out value="${ pokeBook.vendor }"/>
<p> Amount Spent: $<c:out value="${ pokeBook.amount }"/>

</body>
</html>