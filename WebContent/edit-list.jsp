<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit a list</title>
</head>
<body>
<form action = "editExistingListServlet" method="post">
List Name: <input type ="text" name = "listName" value="${listToEdit.listName}"><br />
Stock date: <input type ="text" name = "month" placeholder="mm" size="4" value="${listToEdit.stockDate.getMonthValue()}"> <input type ="text" name = "day" placeholder="dd" size="4" value="${listToEdit.stockDate.getDayOfMonth()}">, <input type ="text" name = "year" placeholder="yyyy" size="4" value="${listToEdit.stockDate.getYear()}">
Consumer Name: <input type = "text" name = "consumerName" value="${listToEdit.consumer.consumerName}"><br />
<input type = "hidden" name = "id" value="${listToEdit.id}">
Current Boxes:<br />
<select name="currentBoxes" multiple size="6">
<c:forEach var = "listVal" items = "${listToEdit.listOfBoxes}">
          <option value = "${listVal.id}">${listVal.name} | ${listVal.flavor}</option>          
  </c:forEach>
</select>
<br />
Remaining Boxes:<br />
<select name="boxesToAdd" multiple size="6">
<c:forEach items="${requestScope.allBoxesToAdd}" var="currentBox">
   <option value = "${currentBox.id}">${currentBox.name} | ${currentBox.flavor}</option>
</c:forEach>
</select>

<br />
<input type = "submit" value="Edit List and Edit Boxes">
</form>
<a href = "index.html">Go add new boxes instead.</a>
</body>

</html>