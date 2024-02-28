<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Edit Book</title>
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
    input[type="text"], input[type="submit"] {
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
    <h1>Edit Book</h1>
    <form action="EditBookServlet" method="post">
        <label for="title">Title:</label>
        <input type="text" name="title" value="${bookToEdit.title}">
        
        <label for="author">Author:</label>
        <input type="text" name="author" value="${bookToEdit.author}">
        
        <label for="isbn">ISBN:</label>
        <input type="text" name="isbn" value="${bookToEdit.isbn}">
        
        <input type="hidden" name="id" value="${bookToEdit.id}">
        
        <input type="submit" value="Save Edited Book">
    </form>
</div>
</body>
</html>