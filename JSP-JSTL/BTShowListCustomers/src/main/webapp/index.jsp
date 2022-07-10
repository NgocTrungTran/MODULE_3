<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <h2>Danh sách khách hàng</h2>
    <div>
        <div style="float: left;width: 24%">
            <h4>Tên</h4>
            <c:forTokens items="Mai Văn Hoàn,
                        Nguyễn Văn Nam,
                        Nguyễn Thái Hòa,
                        Trần Đăng Khoa,
                        Nguyễn Đình Thi" delims="," var="name">
                <p style="height: 70px"><c:out value="${name}"/><hr>
            </c:forTokens>
        </div>
        <div style="float: left;width: 24%">
            <h4>Ngày sinh</h4>
            <c:forTokens items="1983-08-20,
                        1983-08-21,
                        1983-08-22,
                        1983-08-17,
                        1983-08-19" delims="," var="birth">
            <p style="height: 70px"><c:out value="${birth}"/><hr><p>
            </c:forTokens>
        </div>
        <div style="float: left;width: 24%">
            <h4>Địa chỉ</h4>
            <c:forTokens items="Hà Nội,
                        Bắc Giang,
                        Nam Định,
                        Hà Tây,
                        Hà Nội" delims="," var="address">
            <p style="height: 70px"><c:out value="${address}"/><hr><p>
            </c:forTokens>
        </div>
        <div style="float: left;width: 24%;">
            <h4>Ảnh</h4>
            <c:forTokens items="https://i.pinimg.com/736x/ec/e6/7c/ece67cb653a6c07ab10d83e4a95191e8.jpg,
                        https://i.pinimg.com/originals/ec/b6/35/ecb6350cf7ecaba43ef99479dae32858.jpg,
                        https://i.pinimg.com/736x/57/5f/63/575f63040c9d8a2e218111d181d4dfcf.jpg,
                        https://i.imgur.com/proIBbl.jpg,
                        https://i.imgur.com/rjgpP68.jpg" delims="," var="image">
            <img src="<c:out value="${image}"/>" style="width: 50px; height: 70px; padding: 0; margin: 0"><hr><p>
            </c:forTokens>
        </div>
    </div>

</body>
</html>