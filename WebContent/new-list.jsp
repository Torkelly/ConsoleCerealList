<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a new list</title>

<script>

	function checkInput() {
 		var listName = document.forms["newListForm"]["listName"].value;
 		var consumerName = document.forms["newListForm"]["consumerName"].value;
 		var day = document.forms["newListForm"]["day"].value;
 		var month = document.forms["newListForm"]["month"].value;
 		var year = document.forms["newListForm"]["year"].value;

 		if(listName == "" || !isNaN(listName)) {
 			alert("Invalid input. List name cannot be null or an integer!");
 			return false;
 		}
 		else if(consumerName == "" || !isNaN(consumerName))  {
 			alert("Invalid input. Consumer name cannot be null or an integer!");
 			return false;
 		}
 		else if(isNaN(month) || isNaN(day) || isNaN(year)) {
 			alert("Invalid input. Date input must use integers!");
 			return false;
 		}

 	}

</script>

</head>
<body>
<form name= "newListForm" action = "createNewListServlet" method="post" onsubmit= "return checkInput()">
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