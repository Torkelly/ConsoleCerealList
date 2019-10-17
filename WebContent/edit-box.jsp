<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cereal Box Editor</title>

<script>

	function checkInput() {
 		var name = document.forms["editBoxForm"]["name"].value;
 		var flavor = document.forms["editBoxForm"]["flavor"].value;
 		if(name == "" || flavor == "") {
 			alert("Invalid input. Cannot be null!");
 			return false;
 		}
 		else if(!isNaN(name) || !isNaN(flavor)) {
 			alert("Invalid input. Cannot be an integer!");
 			return false;
 		}
 	}

</script>

</head>
<body>
    <form name = "editBoxForm" action = "editBoxServlet" method="post" onsubmit="return checkInput()">
        Box: <input type ="text" name = "name" value="${boxToEdit.name}">
        flavor: <input type = "text" name = "flavor" value= "${boxToEdit.flavor}">
        <input type = "hidden" name = "id" value="${boxToEdit.id}">
        <input type = "submit" value="Save Edited Box">
    </form>
</body>
</html>