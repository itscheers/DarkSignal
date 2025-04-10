<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome to Text Quest</title>
</head>
<body>
<h1>Welcome!</h1>
<form action="${pageContext.request.contextPath}/start" method="post">
    <label>Please enter your name:</label>
    <input type="text" name="playerName" required />
    <button type="submit">Begin Game</button>
</form>
</body>
</html>
