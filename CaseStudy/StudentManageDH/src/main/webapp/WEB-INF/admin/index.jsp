<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en"><head>
    <meta charset="utf-8">
    <title>Dong Hoi High School - Quang Binh</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta content="A fully featured admin theme which can be used to build CRM, CMS, etc." name="description">
    <meta content="Coderthemes" name="author">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <jsp:include page="/WEB-INF/admin/layout/meta_css.jsp"></jsp:include>
<body class="">

<!-- Begin page -->
<div id="wrapper">
    <jsp:include page="/WEB-INF/admin/layout/navbar-custom.jsp"></jsp:include>
    <!-- ========== Left Sidebar Start ========== -->
    <jsp:include page="/WEB-INF/admin/layout/left-side-menu.jsp"></jsp:include>
    <!-- Left Sidebar End -->

    <!-- ============================================================== -->
    <!-- Start Page Content here -->
    <!-- ============================================================== -->

    <div class="content-page">
        <div class="content">

            <!-- Start Content-->
            <div class="container-fluid">

                <!-- start page title -->
                <div class="row">
                    <div class="col-12">
                        <div class="page-title-box">
                            <div class="page-title-right">
                                <ol class="breadcrumb m-0">
                                    <li class="breadcrumb-item"><a href="javascript: void(0);">Dong Hoi High School</a></li>
                                    <li class="breadcrumb-item active">Home</li>
                                </ol>
                            </div>
                            <h4 class="page-title">Welcome to Dong Hoi High School</h4>
                        </div>
                    </div>
                </div>
                <!-- end row -->
                <div class="row">
                    <div class="col-12">
                        <div class="card" style="flex-direction: row;">
                            <div class="card-body col-7">
                                <video width="100%" height="500px" autoplay loop muted>
                                    <source src="/videos/introcut.mp4" type="video/mp4">
                                </video>
                            </div>
                            <div class="card-body col-5">
                                <h4>Dong Hoi High School - Quang Binh</h4>
                                <p>???????c th??nh l???p v??o <b>th??ng 9 n??m 1966</b> v???i t??n g???i ban ?????u l?? <b>tr?????ng c???p III ?????ng H???i</b> tr??n m???nh ?????t C???n Ch??a d?????i gian ph??ng l???p l?? ng???y trang trong nh???ng ng??y gi???c M??? ??i??n cu???ng t??n ph??, tr?????ng c?? 7 l???p 365 h???c sinh v?? 17 c??n b??? gi??o vi??n.</p>
                                <div id="accordion">
                                    <div class="card">
                                        <div class="card-header">
                                            <a class="card-link" data-toggle="collapse" href="#collapseOne">
                                                1970 - 1973
                                            </a>
                                        </div>
                                        <div id="collapseOne" class="collapse show" data-parent="#accordion">
                                            <div class="card-body">
                                                N??m h???c 1970 - 1971, sau 4 n??m ??? C???n Ch??a, tr?????ng chuy???n v??? C???n. H???c k??? II n??m h???c 1971 - 1972, ?????a ??i???m tr?????ng b??? B52 c??y n??t, tr?????ng s?? t??n v??? M??? C????ng, Trung Ngh??a, ?????c Ninh. N??m h???c 1972 - 1973, Tr?????ng c???p III B???c Qu???ng Ninh th??nh l???p t??ch ra t??? Tr?????ng c???p III ?????ng H???i. Tr?????ng c???p III ?????ng H???i s?? t??n ra x?? Qu???ng H??a, huy???n Qu???ng Tr???ch.
                                            </div>
                                        </div>
                                    </div>
                                    <div class="card">
                                        <div class="card-header">
                                            <a class="collapsed card-link" data-toggle="collapse" href="#collapseTwo">
                                                1975 - 1985
                                            </a>
                                        </div>
                                        <div id="collapseTwo" class="collapse" data-parent="#accordion">
                                            <div class="card-body">
                                                M??a xu??n n??m 1975, ?????t n?????c s???ch b??ng th??. Ng?????i d??n Qu???ng B??nh n??i ri??ng, c??? d??n t???c n??i chung b???t tay v??o cu???c chi???n m???i, cu???c chi???n kh??i ph???c ?????t n?????c. Th??m m???t l???n n???a, t???p th??? gi??o vi??n nh?? tr?????ng xi???t ch???t ?????i ng?? c??ng nhau v?????t qua s??ng gi?? th???i bao c???p.
                                                N??m 1985, tr?????ng chia ra l??m 2 ph??n hi???u, ph??n hi???u 1 ????ng t???i ?????t C???n, ph??n hi???u 2 tr??? v??? l???i n???n c?? (ti???n th??n c???a tr?????ng THPT ????o Duy T??? hi???n nay).
                                            </div>
                                        </div>
                                    </div>
                                    <div class="card">
                                        <div class="card-header">
                                            <a class="collapsed card-link" data-toggle="collapse" href="#collapseThree">
                                                2015 - 2016
                                            </a>
                                        </div>
                                        <div id="collapseThree" class="collapse" data-parent="#accordion">
                                            <div class="card-body">
                                                N??m h???c 2015 - 2016, tr?????ng THPT ?????ng H???i tr??n 50 tu???i, 50 m??a hoa ph?????ng n??? trong h??nh tr??nh ti???p s???c v???i n???i l???c d???o dai v?? b???n b??? c???a gi??o vi??n v?? h???c sinh. Song h??nh c??ng d???u ???n n???a th??? k??? qua c???a tr?????ng THPT ?????ng H???i l?? g???n 20.000 h???c sinh ???? t???t nghi???p ra tr?????ng, tr?????ng th??nh, c??ng t??c trong nhi???u l??nh v???c kh??c nhau.
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- end row -->

            </div> <!-- container-fluid -->

        </div> <!-- content -->



        <!-- Footer Start -->
        <jsp:include page="/WEB-INF/admin/layout/footer.jsp"></jsp:include>
        <%-- end Footer --%>
</div>
<%-- END wrapper --%>
<jsp:include page="/WEB-INF/admin/layout/script.jsp"></jsp:include>
</body></html>