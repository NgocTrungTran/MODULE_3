<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Simple Calculator!" %></h1>
<div>
  <form action="calculator" method="get">
    <table style="border: 1px solid black">
      <caption>Calculator</caption>
      <tr>
        <td>First operand:</td>
        <td><input type="text" name="fOperand"></td>
      </tr>
      <tr>
        <td>Operand:</td>
        <td>
          <select name="operator">
            <option value="Addition">Addition</option>
            <option value="Subtraction">Subtraction</option>
            <option value="Multiplication">Multiplication</option>
            <option value="Division">Division</option>
          </select>
        </td>
      </tr>
      <tr>
        <td>Second operand:</td>
        <td><input type="text" name="sOperand"></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" name="submit" value="Calculator"></td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>