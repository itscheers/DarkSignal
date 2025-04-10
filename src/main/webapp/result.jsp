<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Text Quest - Result</title>
</head>
<body>
<h1>Result for <c:out value="${playerName}"/></h1>
<h2><c:out value="${resultMessage}"/></h2>
<p>Games played: <c:out value="${gameCounter}"/></p>
<form action="${pageContext.request.contextPath}/result" method="post">
  <button type="submit">Start Over</button>
</form>
</body>
</html>
