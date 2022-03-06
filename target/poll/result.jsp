<%@ page import="com.epam.model.Text" %><%--
  Created by IntelliJ IDEA.
  User: Armine Zakaryan
  Date: 05.03.2022
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% Text result = (Text) request.getAttribute("result"); %>
<%=  result + ""%>
</body>
</html>
