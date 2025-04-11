<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Game Result</title>
</head>
<body>
<h1>Game Over</h1>
<p>Thank you for playing, <c:out value="${playerName}" />!</p>
<p><strong><c:out value="${resultMessage}" /></strong></p>
<p>Total games played: <c:out value="${gameCounter}" /></p>

<form action="${pageContext.request.contextPath}/start" method="get">
  <button type="submit">Play Again</button>
</form>
</body>
</html>
