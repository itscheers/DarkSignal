<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h1>Welcome to the Text Quest! (This quest is in English because I’m currently learning it in depth and working to improve my skills.)</h1>
<p>Enter your name to begin the journey.</p>

<form action="${pageContext.request.contextPath}/start" method="post">
    <input type="text" name="playerName" required placeholder="Your name">
    <button type="submit">Start</button>
</form>
</body>
</html>
