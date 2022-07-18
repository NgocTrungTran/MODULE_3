<%--
  Created by IntelliJ IDEA.
  User: FPTshop sapa
  Date: 18/07/2022
  Time: 9:08 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html"%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP-Servlet Upload file</title>
</head>
<body>
<h2>${requestScope.message}</h2>
<form method="post" action="/UploadFileServlet" enctype="multipart/form-data">
    Select file to upload: <input type="file" name="file" size="60" /><br /><br />
    <input type="submit" value="Upload" />
</form>
</body>
</html>
