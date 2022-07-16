<%--
  Created by IntelliJ IDEA.
  User: FPTshop sapa
  Date: 16/07/2022
  Time: 3:46 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Sort Ascending</h1>
    <h2>
        <a href="/users?action=create">Add New User</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${requestScope.listSort}">
            <tr>
                <td><c:out value="${user.getId()}"/></td>
                <td><c:out value="${user.getName()}"/></td>
                <td><c:out value="${user.getEmail()}"/></td>
                <td>
                    <c:forEach items="${applicationScope.listCountry}" var="country">
                        <c:if test="${country.getId()==user.getCountry()}">
                            <c:out value="${country.getName()}"/>
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <a href="/users?action=edit&id=${user.id}">Edit</a>
                    <a href="/users?action=delete&id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div>
        <form method="post" action="user/search.jsp">
            <p>Search by country</p>
            <input type="text" name="search" id="search">
            <input type="submit" value="Search">
        </form>
    </div>
    <p><a href="/users?action=sort">Sort by name</a></p>
</div>
</body>
</html>
