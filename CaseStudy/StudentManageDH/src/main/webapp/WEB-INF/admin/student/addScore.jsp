<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Add Student's Score</title>
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
                <div class="row">
                    <div class="col-12">
                        <div class="page-title-box">
                            <div class="page-title-right">
                                <ol class="breadcrumb m-0">
                                    <li class="breadcrumb-item"><a href="/students">Dong Hoi High School</a></li>
                                    <li class="breadcrumb-item active"><a href="/students?action=list">Student List</a>
                                    </li>
                                    <li class="breadcrumb-item active">Add Student's Score</li>
                                </ol>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="row"
                     style="align-items: center; justify-content: center; margin-top: 20px; margin-left: 100px">
                    <div class="col-lg-8">
                        <div class="card">
                            <div class="card-body">
                                <c:if test="${student != null}">
                                    <input type="hidden" name="code" value="${code}"/>
                                    <input type="hidden" name="firstName" value="${firstName}"/>
                                    <input type="hidden" name="lastName" value="${lastName}"/>
                                </c:if>
                                <h4 class="header-title mb-3" style="font-size: larger">Add Score
                                    <c:out value="${firstName}"/> <c:out value="${lastName}"/>
                                </h4>

                                <form method="post" class="needs-validation" novalidate="">
                                    <div class="col-4" style="float:left;">
                                        <div class="form-group mb-3" id="class_id">
                                            <label for="validationCustom08" style="margin-left: 10px">Subjects</label>
                                            <select id="validationCustom08" name="subject">
                                                <c:forEach var="subject" items="${applicationScope.listSubjects}">
                                                    <option value="${subject.getSubjects_id()}">
                                                        <c:out value="${subject.getSub_name() }"/>
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-4" style="float:left;">
                                        <div class="form-group mb-3">
                                            <label for="validationCustomUsername">First Score</label>
                                                <input type="text" class="form-control" id="validationCustomUsername"
                                                       name="firstScore" value="${firstScore}"
                                                       placeholder="min 0 - max 10" required="">
                                            <div class="invalid-feedback">
                                                Please enter firstScore!
                                            </div>
                                        </div>
                                        <div class="form-group mb-3">
                                            <label for="validationCustom01">Second Score</label>
                                            <input type="text" class="form-control" name="secondScore"
                                                   id="validationCustom01" value="${secondScore}"
                                                   placeholder="min 0 - max 10" required="">
                                            <div class="invalid-feedback">
                                                Please enter secondScore!
                                            </div>
                                        </div>
                                        <div class="form-group mb-3">
                                            <label for="validationCustom02">Third Score</label>
                                            <input type="text" class="form-control" id="validationCustom02"
                                                   name="thirdScore" value="${thirdScore}"
                                                   placeholder="min 0 - max 10" required="">
                                            <div class="invalid-feedback">
                                                Please enter thirdScore!
                                            </div>
                                        </div>
                                    </div>
                                    <div style="clear: both; text-align: center">
                                        <button class="btn btn-primary" type="submit" id="submit_add"><b style="color: white;">Add</b></button>
                                        <button class="btn btn-warning" type="reset"><b style="color: white;">Reset</b></button>
                                        <button type="button" class="btn btn-secondary waves-effect waves-light"><a
                                                href="/students?action=list"><b style="color: white;">Back</b></a>
                                        </button>
                                    </div>
                                </form>
                                <div id="alertFormat">
                                    ${errors}
                                </div>
                            </div> <!-- end card-body-->
                        </div> <!-- end card-->
                    </div> <!-- end col-->
                </div>
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
