<%--
  Created by IntelliJ IDEA.
  User: FPTshop sapa
  Date: 15/07/2022
  Time: 10:32 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Country Manager</title>
</head>
<body>
<center>
    <h1>List Country Management</h1>
    <h2>
        <a href="/country?action=create">Add New Country</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Country</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="country" items="${listCountry}">
            <tr>
                <td><c:out value="${country.getId()}"/></td>
                <td><c:out value="${country.getName()}"/></td>
                <td>
                    <a href="/country?action=edit&id=${country.getId()}">Edit</a>
                    <a href="/country?action=delete&id=${country.getId()}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
