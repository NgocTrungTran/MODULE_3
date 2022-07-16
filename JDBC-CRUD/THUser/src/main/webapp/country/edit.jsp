<%--
  Created by IntelliJ IDEA.
  User: FPTshop sapa
  Date: 15/07/2022
  Time: 1:55 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Country Management Application</title>
</head>
<body>
<center>
    <h1>Country Management</h1>
    <h2>
        <a href="country?action=country">List All Country</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Country
                </h2>
            </caption>
            <c:if test="${country != null}">
                <input type="hidden" name="id" value="<c:out value='${country.getId()}' />"/>
            </c:if>
            <tr>
                <th>Country Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${country.getName()}' />"
                    />
                </td>
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
