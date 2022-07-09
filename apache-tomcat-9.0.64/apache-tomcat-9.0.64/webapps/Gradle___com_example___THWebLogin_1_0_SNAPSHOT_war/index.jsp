<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <style>
        .login {
            height: 200px;
            width: 230px;
            margin: 0;
            padding: 10px;
            border: 1px #CCC solid;
        }
        .login input {
            padding: 5px;
            margin: 5px;
        }
    </style>
</head>
<body>
    <form action="${pageContext.request.contextPath}/login" method="get">
        <div class="login">
            <h2>Login</h2>
            <input type="text" name="username" size="25" placeholder="username"/>
            <input type="password" name="password" size="25" placeholder="password"/>
            <input type="submit" value="Sign in" />
        </div>
    </form>
</body>
</html>