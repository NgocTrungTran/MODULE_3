<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Add Student</title>
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
                                    <li class="breadcrumb-item active">Update Student</li>
                                </ol>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="row"
                     style="align-items: center; justify-content: center; margin-top: 100px; margin-left: 100px">
                    <div class="col-lg-10">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="header-title mb-3" style="font-size: larger">Fill in the editing
                                    information</h4>

                                <form method="post" class="needs-validation" novalidate=""
                                      enctype="multipart/form-data">
                                    <div class="form-group mb-3">
                                        <c:if test="${student != null}">
                                            <input type="hidden" name="code" value="${code}"/>
                                            <h4><c:out value="${firstName}"/> <c:out value="${lastName}"/></h4>
                                        </c:if>
                                        <label for="validationCustom01">First name</label>
                                        <input type="text" class="form-control" id="validationCustom01" name="firstName"
                                               value="${firstName}">
                                        <div class="valid-feedback">
                                            Looks good!
                                        </div>
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="validationCustom02">Last name</label>
                                        <input type="text" class="form-control" id="validationCustom02" name="lastName"
                                               value="${lastName}">
                                        <div class="valid-feedback">
                                            Looks good!
                                        </div>
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="validationCustom03">Birthday</label>
                                        <input type="date" class="form-control" name="birthday" id="validationCustom03"
                                               value="${birthday}">
                                        <div class="valid-feedback">
                                            Looks good!
                                        </div>
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="validationCustomUsername">Email</label>
                                        <div class="input-group">
                                            <input type="email" class="form-control" id="validationCustomUsername"
                                                   name="email"
                                                   aria-describedby="inputGroupPrepend" value="${email}">
                                            <div class="invalid-feedback">
                                                Please enter your email!
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="validationCustom04">Phone</label>
                                        <input type="text" class="form-control" name="phoneNum" id="validationCustom04"
                                               value="${phoneNum}">
                                        <div class="invalid-feedback">
                                            Please provide a phone number!
                                        </div>
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="validationCustom05">Address</label>
                                        <input type="text" class="form-control" name="address" id="validationCustom05"
                                               value="${address}">
                                        <div class="invalid-feedback">
                                            Please provide an address.
                                        </div>
                                    </div>

                                    <div class="form-group mb-3">
                                        <label for="validationCustom06">Avatar: </label>
                                        <input type="hidden" name="avatar" value="${avatar}"/>
                                        <input accept="image/*" type='file' id="validationCustom06" width="45%"
                                               name="file"
                                               style="margin-left: 10px"/>
                                        <img id="blah" src="${avatar}" alt="your avatar"
                                             style="width: 150px; height: 200px"/>
                                    </div>
                                    <div class="form-group mb-3" id="class_id">
                                        <label for="validationCustom07" style="margin-left: 10px">Class before</label>
                                        <input type="text" name="classes" value="${classes}" readonly disabled
                                               style="border: none; width: 50px">
                                        <label for="validationCustom07" style="margin-left: 10px">Choose more
                                            class</label>
                                        <select id="validationCustom07" name="classes" style="margin-left: 10px; height: 30px; width: 60px; border-radius: 5px; background-color: #C5DFEA">
                                            <c:forEach var="classes" items="${applicationScope.listClass}">
                                                <option value="${classes.getC_id()}">
                                                    <c:out value="${classes.getClassName() }"/>
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <button class="btn btn-success" type="submit" id="submit_add"><b style="color: white;">Update</b></button>
                                    <button class="btn btn-warning" type="reset"><b style="color: white;">Reset</b></button>
                                    <button type="button" class="btn btn-secondary waves-effect waves-light"><a
                                            href="/students?action=list"><b style="color: white;">Back</b></a>
                                    </button>
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