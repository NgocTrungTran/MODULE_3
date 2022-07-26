<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Profile</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta content="A fully featured admin theme which can be used to build CRM, CMS, etc." name="description">
    <meta content="Coderthemes" name="author">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- App favicon -->
    <jsp:include page="/WEB-INF/admin/layout/meta_css.jsp"></jsp:include>
</head>

<body>

<!-- Begin page -->
<div id="wrapper">

    <!-- Topbar Start -->
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
                <div class="row" style="margin-top: 55px">
                    <div class="col-12">
                        <div class="page-title-box">
                            <div class="page-title-right">
                                <ol class="breadcrumb m-0">
                                    <li class="breadcrumb-item"><a href="/students">Dong Hoi High School</a></li>
                                    <li class="breadcrumb-item active"><a href="/students?action=list">Student List</a>
                                    </li>
                                    <li class="breadcrumb-item active">Profile Student</li>
                                </ol>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="row"
                     style="align-items: center; justify-content: center; margin-top: 100px; margin-left: 100px">
                    <div class="col-lg-10">
                        <div class="card" style="background-color: #f2f2f2;border-radius: 5px">
                            <div class="card-body">
                                <h4 class="header-title mb-3" style="font-size: 20px; text-align: center">
                                    Information</h4>
                                <div class="form-group mb-3" style="text-align: center">
                                    <img id="blah" class="rounded-circle" src="${avatar}" alt="your avatar"
                                         style="width: 300px; height: 300px"/>
                                </div>
                                <div class="form-group mb-3">
                                    <c:if test="${student != null}">
                                        <input type="text" name="code" value="${code}"/>
                                    </c:if>
                                </div>
                                <div style="display: flex;justify-content: space-around;">
                                    <div style="float:left;" class="form-group mb-3">
                                        <div>
                                            <label>Student code</label><br>
                                            <p><c:out value="${code}"/></p>
                                        </div>
                                        <div>
                                            <label>First name</label><br>
                                            <p><c:out value="${firstName}"/></p>
                                        </div>
                                        <div class="form-group mb-3">
                                            <label>Last name</label><br>
                                            <p><c:out value="${lastName}"/></p>
                                        </div>
                                        <div class="form-group mb-3" id="class_id">
                                            <label>Class</label><br>
                                            <p><c:out value="${classes}"/></p>
                                        </div>
                                        <div class="form-group mb-3">
                                            <label>Birthday</label><br>
                                            <p><c:out value="${birthday}"/></p>
                                        </div>
                                    </div>
                                    <div style="float:left;" class="form-group mb-3">
                                        <div class="form-group mb-3">
                                            <label>Email</label><br>
                                            <p><c:out value="${email}"/></p>
                                        </div>
                                        <div class="form-group mb-3">
                                            <label>Phone</label><br>
                                            <p><c:out value="${phoneNum}"/></p>
                                        </div>
                                        <div class="form-group mb-3">
                                            <label>Address</label><br>
                                            <p><c:out value="${address}"/></p>
                                        </div>
                                        <div class="form-group mb-3">
                                            <label>Create Date</label><br>
                                            <p><c:out value="${createDate}"/></p>
                                        </div>
                                        <div class="form-group mb-3">
                                            <label>Last update</label><br>
                                            <p><c:out value="${updateDate}"/></p>
                                        </div>
                                    </div>
                                </div>
                                <div style="text-align: center;">
                                    <button type="button" class="btn btn-secondary waves-effect waves-light"><a
                                            href="/students?action=list"><b style="color: white;">Back</b></a>
                                    </button>
                                </div>
                            </div> <!-- end card-body-->
                        </div> <!-- end card-->
                    </div> <!-- end col-->
                </div>
            </div>
        </div>
    </div>

    <!-- ============================================================== -->
    <!-- End Page content -->
    <!-- ============================================================== -->

    <jsp:include page="/WEB-INF/admin/layout/footer.jsp"></jsp:include>

</div>
<!-- END wrapper -->
<!-- Vendor js -->
<jsp:include page="/WEB-INF/admin/layout/script.jsp"></jsp:include>
<script>
    validationCustom06.onchange = evt => {
        const [file] = validationCustom06.files
        if (file) {
            blah.src = URL.createObjectURL(file)
        }
    }
</script>
<%--                        script an hien--%>
<script>
    document.getElementById("role1").onclick = function () {
        document.getElementById("class_id").style.display = 'none';
    };

    document.getElementById("role2").onclick = function () {
        document.getElementById("class_id").style.display = 'block';
    };
</script>
</body>
</html>
<script>

</script>