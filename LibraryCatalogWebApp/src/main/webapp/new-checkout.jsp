<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Create New Checkout</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f2f2f2;
    }
    .container {
        max-width: 500px;
        margin: 50px auto;
        background-color: #fff;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        padding: 20px;
    }
    h1 {
        text-align: center;
    }
    form {
        display: flex;
        flex-direction: column;
    }
    label {
        margin-bottom: 10px;
    }
    input[type="text"], select, input[type="submit"] {
        padding: 10px;
        margin-bottom: 20px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
        width: 100%;
    }
    input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        border: none;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>
<div class="container">
    <h1>Create New Checkout</h1>
    <form action="CreateNewCheckoutServlet" method="post">
        <label for="checkoutName">Checkout Name:</label>
        <input type="text" id="checkoutName" name="checkoutName">
        
        <label for="checkoutDate">Checkout Date:</label>
        <input type="text" id="month" name="month" placeholder="mm" size="2">
        <input type="text" id="day" name="day" placeholder="dd" size="2">
        <input type="text" id="year" name="year" placeholder="yyyy" size="4">
        
        <label for="personName">Person Name:</label>
        <input type="text" id="personName" name="personName">
        
        <label for="allBooksToAdd">Available Books:</label>
        <select name="allBooksToAdd" multiple size="6">
            <c:forEach items="${requestScope.allBooks}" var="currentBook">
                <option value="${currentBook.id}">${currentBook.title} | ${currentBook.author} | ${currentBook.isbn}</option>
            </c:forEach>
        </select>
        
        <input type="submit" value="Create Checkout and Add Books">
    </form>
</div>
</body>
</html>