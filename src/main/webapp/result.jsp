<%@ page import="com.epam.model.Text" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Результаты опроса</h2>

<% Text result = (Text) request.getAttribute("result"); %>
<%=  result + ""%>
<br><br>


<a href="index.html">К списку опросов</a><br>
</body>
</html>
