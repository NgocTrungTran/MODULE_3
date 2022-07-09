<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Currency Converter</title>
</head>
<body>
    <h2>Currency Conver</h2>
    <form action="convert" method="get">
        <label>Rate: </label><br>
        <label>
            <input type="text" name="rate" placeholder="RATE" value="23000"/>
        </label><br>
        <label>USD: </label><br/>
        <label>
            <input type="text" name="usd" placeholder="USD" value="0"/>
        </label><br>
        <input type="submit" id="submit" value="Converter"/>
    </form>
</body>
</html>