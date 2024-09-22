<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <a href="logout.jsp">Sign Out</a>
    <%
        String user_name = (String) session.getAttribute("user_name");
        if(user_name == null || user_name.trim().isEmpty()){
            response.sendRedirect("loginAndRegister.jsp");
        }
    %>
    <h1>Hello <%=user_name%></h1>
</body>
</html>