<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consumer's Lists</title>
</head>
<body>
<body>
<form method = "post" action = "listNavigationServlet">
<table>
<c:forEach items="${requestScope.allLists}" var="currentList">
<tr>
   <td><input type="radio" name="id" value="${currentList.id}"></td>
   <td><h2>${currentList.listName}</h2></td></tr>
   <tr><td colspan="3">Stock Date: ${currentList.stockDate}</td></tr>
   <tr><td colspan="3">Consumer: ${currentList.consumer.consumerName}</td></tr>
   <c:forEach var = "listVal" items = "${currentList.listOfBoxes}">
            <tr><td></td><td colspan="3">
                ${listVal.name}, ${listVal.flavor}
                </td>
            </tr>
  </c:forEach>
</c:forEach>
</table>
<input type = "submit" value = "edit" name="doThisToBox">
<input type = "submit" value = "delete" name="doThisToBox">
<input type="submit" value = "add" name = "doThisToBox">
</form>
<a href="addBoxesForListServlet">Create a new List</a>
<a href="index.html">Insert a new box</a>
</body>

</body>
</html>
