<%--
  Created by IntelliJ IDEA.
  User: Ojasva
  Date: 21-09-2024
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log Out</title>
</head>
<body>
    <%
        session.invalidate();
        response.sendRedirect("loginAndRegister.jsp");
    %>
</body>
</html>
