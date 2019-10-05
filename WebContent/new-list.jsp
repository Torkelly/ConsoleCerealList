<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a new list</title>
</head>
<body>
<form action = "createNewListServlet" method="post">
List Name: <input type ="text" name = "listName"><br />
Stock date: <input type ="text" name = "month" placeholder="mm" size="4"> <input type ="text" name = "day" placeholder="dd" size="4">, <input type ="text" name = "year" placeholder="yyyy" size="4">
Consumer Name: <input type = "text" name = "consumerName"><br />

Available Boxes:<br />

<select name="allBoxesToAdd" multiple size="6">
<c:forEach items="${requestScope.allBoxes}" var="currentBox">
   <option value = "${currentBox.id}">${currentBox.name} | ${currentBox.flavor}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value="Create List and Add Cereal Boxes">
</form>
<a href = "index.html">Go add new boxes instead.</a>
</body>

</html>