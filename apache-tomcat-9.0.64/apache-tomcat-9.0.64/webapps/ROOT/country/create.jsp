<%--
  Created by IntelliJ IDEA.
  User: FPTshop sapa
  Date: 15/07/2022
  Time: 10:56 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create Country Management Application</title>
</head>
<body>
<div style="text-align: center;">
    <h1>Create Country</h1>
    <h2>
        <a href="country?action=users">List All Users</a>
    </h2>
</div>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Country</h2>
            </caption>
            <tr>
                <th>Country Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
