<%--
  Created by IntelliJ IDEA.
  User: Ojasva
  Date: 21-09-2024
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="styleLoginRegister.css">
    <title>Login Or Register</title>
</head>
<body>
    <div class="wrapper">
        <div class="loginDiv">
            <form action="login" method="post">
                <table>
                    <tr>
                        <td><h2>Login:</h2></td>
                    </tr>
                    <tr class="input-field">
                        <td>
                            <input type="text" name="user_identifier" required>
                            <label>Enter Username or E-mail</label>
                        </td>
                    </tr>
                    <tr class="input-field">
                        <td>
                            <input type="password" name="user_password" required>
                            <label>Enter Password</label>
                        </td>
                    </tr>
                    <tr>
                        <c:if test="${not empty loginError}">
                            <p class="error">${loginError}</p>
                        </c:if>
                    </tr>
                    <tr>
                        <td><button type="submit">Sign In</button></td>
                    </tr>
                </table>
            </form>
        </div>

        <div class="registerDiv">
            <form action="register" method="post">
                <table>
                    <tr>
                        <td><h2>Register:</h2></td>
                    </tr>
                    <tr class="input-field">
                        <td>
                            <input type="text" name="user_name" required>
                            <label>Enter Username</label>
                        </td>
                    </tr>
                    <tr class="input-field">
                        <td>
                            <input type="text" name="user_mail" required>
                            <label>Enter E-mail</label>
                        </td>
                    </tr>
                    <tr class="input-field">
                        <td>
                            <input type="password" name="user_password" required>
                            <label>Enter Password</label>
                        </td>
                    </tr>
                    <tr>
                        <c:if test="${not empty registerError}">
                            <p class="error">${registerError}</p>
                        </c:if>

                        <c:if test="${not empty success}">
                            <p class="success">${success}</p>
                        </c:if>
                    </tr>
                    <tr>
                        <td><button type="submit">Sign Up</button></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</body>
</html>
