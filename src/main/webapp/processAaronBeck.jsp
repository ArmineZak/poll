<%@ page import="com.epam.dao.impl.QuestionDAOImpl" %>
<%@ page import="com.epam.model.Text" %>
<%@ page import="java.util.List" %>
<%@ page import="com.epam.model.Answer" %>
<%@ page import="java.util.Map" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page pageEncoding="UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>


<%
    QuestionDAOImpl question = new QuestionDAOImpl();
    for (int i = 1; i <= 20; i++) {
        Map<Text, List<Answer>> byId = question.findById(i);
        request.setAttribute("questions", byId);
%>
<html>
<body>
<form action="<%= request.getContextPath() %>/process" method="get">
    <c:forEach items="${questions}" var="entry">
        ${entry.key}<br>
        <c:forEach items="${entry.value}" var="item" varStatus="loop">
            ${!loop.last ? ' ' : ''}
            <input type="radio" name="${item.questionId}" value="${item.weight}"><c:out value="${item.text}"></c:out>
            <br>
        </c:forEach><br>
    </c:forEach>
    <% } %>
    <input type="submit" value="Submit">
</form>
</body>
</html>
