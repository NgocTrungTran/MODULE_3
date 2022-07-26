<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>List Trash Student</title>
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
                                    <li class="breadcrumb-item"><a href="/students">Dong Hoi High School</a></li>
                                    <li class="breadcrumb-item active"><a href="/students?action=list">Student List</a></li>
                                    <li class="breadcrumb-item active">List Trash</li>
                                </ol>
                            </div>
                            <h4 class="page-title">List Trash</h4>
                            <div id="button">
                                <button type="button" class="btn btn-primary waves-effect waves-light"><a href="/students?action=list"><b style="color: white">List Student</b></a></button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- end row -->
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="table-responsive mt-3">
                                    <table class="table table-hover table-centered mb-0">
                                        <thead>
                                        <tr>
                                            <th>Code</th>
                                            <th>Basic Info</th>
                                            <th>Birth</th>
                                            <th>Phone</th>
                                            <th>Address</th>
                                            <th>Action</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="student" items="${requestScope.listStudent}">
                                            <tr>
                                                <th scope="row"><c:out value="${student.getCode()}"/></th>
                                                <td>
                                                    <img src="<c:out value="${student.getAvatar()}"/>" alt="contact-img" width="50" height="50" title="contact-img" class="rounded-circle float-left mr-2">
                                                    <div class="overflow-hidden">
                                                        <p class="mb-0 font-weight-medium"><a href="javascript: void(0);"><c:out value="${student.getFirstName()}"/> <c:out value="${student.getLastName()}"/></a></p>
                                                        <span class="font-13"><c:out value="${student.getEmail()}"/></span>
                                                    </div>
                                                </td>

                                                <td>
                                                    <c:out value="${student.getDayBirth()}"/>
                                                </td>

                                                <td>
                                                    <c:out value="${student.getPhoneNum()}"/>
                                                </td>
                                                <td>
                                                    <c:out value="${student.getAddress()}"/>
                                                </td>

                                                <td>
                                                    <div class="btn-group dropdown">
                                                        <a href="javascript: void(0);" class="dropdown-toggle arrow-none btn btn-light btn-sm" data-toggle="dropdown" aria-expanded="false"><i class="mdi mdi-dots-horizontal"></i></a>
                                                        <div class="dropdown-menu dropdown-menu-right" x-placement="bottom-end" style="position: absolute; will-change: transform; top: 0; left: 0; transform: translate3d(-120px, 29px, 0px);">
                                                            <a class="dropdown-item bg-warning" href="/students?action=restore&code=${student.getCode()}"><i class="mdi mdi-arrow-down-bold-box-outline"></i><span style="color: honeydew">Restore</span></a>
                                                            <a class="dropdown-item bg-danger" href="/students?action=delete&code=${student.getCode()}" onclick="return confirm('Are you sure?');" id="deleteStudent" ><i class="mdi mdi-close-box"></i><span style="color: honeydew">Delete</span></a>
                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
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
<script>

</script>