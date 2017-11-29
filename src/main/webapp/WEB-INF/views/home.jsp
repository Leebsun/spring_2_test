<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<h1>Brand: ${car.brand}</h1>
<h1>Color: ${car.color}</h1>
<h1>Hp: ${car.engine.hp}</h1>
<h1>Fuel: ${car.engine.fuel}</h1>
</body>
</html>
