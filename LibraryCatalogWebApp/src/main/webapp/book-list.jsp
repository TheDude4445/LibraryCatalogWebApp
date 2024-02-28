<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>List of Books</title>
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
</style>
</head>
<body>
<form method="post" action="NavigationServlet">
    <table>
        <thead>
            <tr>
                <th>Select</th>
                <th>Title</th>
                <th>Author</th>
                <th>ISBN</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${requestScope.allBooks}" var="currentBook">
                <tr>
                    <td><input type="radio" name="id" value="${currentBook.id}"></td>
                    <td>${currentBook.title}</td>
                    <td>${currentBook.author}</td>
                    <td>${currentBook.isbn}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <input type="submit" value="edit" name="doThisToBook">
    <input type="submit" value="delete" name="doThisToBook">
    <input type="submit" value="add" name="doThisToBook">
</form>
</body>
</html>