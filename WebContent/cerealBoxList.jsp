<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cereal Boxes List</title>
</head>
<body>
<form method = "post" action = "navigationServlet">
    <table>
        <c:forEach items="${requestScope.allBoxes}" var="currentBox">
            <tr>
                <td><input type="radio" name="ID" value="${currentBox.ID}"></td>
                <td>${currentBox.name}</td>
                <td>${currentBox.flavor}</td>
            </tr>
        </c:forEach>
    </table>
    <input type = "submit" value = "edit" name="doThisToBox">
    <input type = "submit" value = "delete" name="doThisToBox">
    <input type="submit" value = "add" name = "doThisToBox">
</form>
</body>
</html>