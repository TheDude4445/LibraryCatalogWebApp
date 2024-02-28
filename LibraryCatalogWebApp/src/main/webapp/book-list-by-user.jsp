<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Checkouts</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 20px;
        background-color: #f2f2f2;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
    }
    th, td {
        padding: 8px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }
    th {
        background-color: #f2f2f2;
    }
    h2 {
        margin-top: 0;
    }
    form {
        margin-bottom: 20px;
    }
    input[type="submit"] {
        padding: 10px 20px;
        margin-right: 10px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        background-color: #4CAF50;
        color: white;
        font-size: 16px;
        text-transform: uppercase;
    }
    input[type="submit"]:hover {
        background-color: #45a049;
    }
    a {
        text-decoration: none;
        color: #4CAF50;
        font-weight: bold;
    }
    a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
<form method="post" action="CheckoutNavigationServlet">
    <table>
        <thead>
            <tr>
                <th>Select</th>
                <th>Checkout Name</th>
                <th>Checkout Date</th>
                <th>Person</th>
                <th>Books</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${requestScope.allCheckouts}" var="currentCheckout">
                <tr>
                    <td><input type="radio" name="id" value="${currentCheckout.id}"></td>
                    <td><h2>${currentCheckout.checkoutName}</h2></td>
                    <td>${currentCheckout.checkoutDate}</td>
                    <td>${currentCheckout.person.personName}</td>
                    <td>
                        <ul>
                            <c:forEach var="checkoutVal" items="${currentCheckout.listOfBook}">
                                <li>${checkoutVal.title}, ${checkoutVal.author}, ${checkoutVal.isbn}</li>
                            </c:forEach>
                        </ul>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <input type="submit" value="edit" name="doThisToCheckout">
    <input type="submit" value="delete" name="doThisToCheckout">
    <input type="submit" value="add" name="doThisToCheckout">
</form>
<a href="AddItemsForCheckoutServlet">Create a new Checkout</a> <br />
<a href="index.html">Insert a new Book</a>
</body>
</html>