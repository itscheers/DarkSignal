<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Text Quest</title>
</head>
<body>
<h1>Welcome to the DarkSignal !</h1>
<p>Click "Start" to begin the game.</p>
<form action="${pageContext.request.contextPath}/start" method="get">
    <button type="submit">Start</button>
</form>
</body>
</html>
