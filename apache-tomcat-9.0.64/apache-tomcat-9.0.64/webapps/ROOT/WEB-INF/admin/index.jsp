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
                                <p>Được thành lập vào <b>tháng 9 năm 1966</b> với tên gọi ban đầu là <b>trường cấp III Đồng Hới</b> trên mảnh đất Cồn Chùa dưới gian phòng lợp lá ngụy trang trong những ngày giặc Mỹ điên cuồng tàn phá, trường có 7 lớp 365 học sinh và 17 cán bộ giáo viên.</p>
                                <div id="accordion">
                                    <div class="card">
                                        <div class="card-header">
                                            <a class="card-link" data-toggle="collapse" href="#collapseOne">
                                                1970 - 1973
                                            </a>
                                        </div>
                                        <div id="collapseOne" class="collapse show" data-parent="#accordion">
                                            <div class="card-body">
                                                Năm học 1970 - 1971, sau 4 năm ở Cồn Chùa, trường chuyển về Cộn. Học kỳ II năm học 1971 - 1972, địa điểm trường bị B52 cày nát, trường sơ tán về Mỹ Cương, Trung Nghĩa, Đức Ninh. Năm học 1972 - 1973, Trường cấp III Bắc Quảng Ninh thành lập tách ra từ Trường cấp III Đồng Hới. Trường cấp III Đồng Hới sơ tán ra xã Quảng Hòa, huyện Quảng Trạch.
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
                                                Mùa xuân năm 1975, đất nước sạch bóng thù. Người dân Quảng Bình nói riêng, cả dân tộc nói chung bắt tay vào cuộc chiến mới, cuộc chiến khôi phục đất nước. Thêm một lần nữa, tập thể giáo viên nhà trường xiết chặt đội ngũ cùng nhau vượt qua sóng gió thời bao cấp.
                                                Năm 1985, trường chia ra làm 2 phân hiệu, phân hiệu 1 đóng tại đất Cộn, phân hiệu 2 trở về lại nền cũ (tiền thân của trường THPT Đào Duy Từ hiện nay).
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
                                                Năm học 2015 - 2016, trường THPT Đồng Hới tròn 50 tuổi, 50 mùa hoa phượng nở trong hành trình tiếp sức với nội lực dẻo dai và bền bỉ của giáo viên và học sinh. Song hành cùng dấu ấn nửa thế kỷ qua của trường THPT Đồng Hới là gần 20.000 học sinh đã tốt nghiệp ra trường, trưởng thành, công tác trong nhiều lĩnh vực khác nhau.
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