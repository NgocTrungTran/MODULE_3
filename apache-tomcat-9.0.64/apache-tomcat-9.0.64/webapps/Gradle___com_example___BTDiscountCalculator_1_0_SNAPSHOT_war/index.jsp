<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product Discount Caculator</title>
</head>
<body>
    <h1>Tính chiết khấu cho sản phẩm khi mua hàng online:</h1>
    <form action="discount" method="post">
        <label for="description">Product Description:
            <input type="text" name="Product Description" id="description" placeholder="Mô tả của sản phẩm">
        </label>
        <label for="Price">List Price:
            <input type="text" name="List Price" id="Price" placeholder="Giá niêm yết">
        </label>
        <label for="Percent">Discount Percent:
            <input type="text" name="Discount Percent" id="Percent" placeholder="Tỉ lệ chiết khấu (%)">
        </label>
        <input type="submit" id="discount" value="Calculate Doscount">
    </form>
</body>
</html>