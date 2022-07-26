<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>[DH] Leaderboard Student</title>
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
                                    <li class="breadcrumb-item active">Leaderboard</li>
                                </ol>
                            </div>
                            <h4 class="page-title">Leaderboar</h4>
                            <div class="col-4" style="float: left">
                                    <div class="input-group">
                                        <input type="search" class="form-control" id="myInput" name="search"
                                               placeholder="search...">
                                    </div>
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
                                            <th>No.</th>
                                            <th>Code</th>
                                            <th>Basic Info</th>
                                            <th>Class</th>
                                            <th>Phone</th>
                                            <%--                                            <th>Address</th>--%>
                                            <%--                                            <th>Action</th>--%>
                                        </tr>
                                        </thead>
                                        <tbody  id="myTable">
                                        <c:forEach var="student" items="${requestScope.listStudent}" begin="0" end="9">
                                        <tr>
                                            <th scope="row"><c:out value="${i}"/></th>
                                            <th scope="row"><c:out value="${student.getCode()}"/></th>
                                            <td>
                                                <img src="<c:out value="${student.getAvatar()}"/>"
                                                     alt="contact-img"
                                                     width="50" height="50" title="contact-img"
                                                     class="rounded-circle float-left mr-2">
                                                <div class="overflow-hidden">
                                                    <p class="mb-0 font-weight-medium"><a
                                                            href="javascript: void(0);"><c:out
                                                            value="${student.getFirstName()}"/> <c:out
                                                            value="${student.getLastName()}"/></a></p>
                                                    <span class="font-13"><c:out
                                                            value="${student.getEmail()}"/></span>
                                                </div>
                                            </td>
                                            <td>
                                                <c:forEach items="${applicationScope.listClass}" var="classes">
                                                    <c:if test="${classes.getC_id()==student.getClass_id()}">
                                                        <c:out value="${classes.getClassName()}"/>
                                                    </c:if>
                                                </c:forEach>
                                            </td>
                                            <td>
                                                <c:out value="${student.getPhoneNum()}"/>
                                            </td>
                                            </c:forEach>

                                        </tr>
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
</body>
</html>
<script>
    $(document).ready(function () {
        $("#myInput").on("keyup", function () {
            var value = $(this).val().toLowerCase();
            $("#myTable tr").filter(function () {
                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
            });
        });
    });
</script>