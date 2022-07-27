<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>[DH] Student List</title>
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
                                    <li class="breadcrumb-item active">Student List</li>
                                </ol>
                            </div>
                            <h4 class="page-title">Student List</h4>
                            <div>
                                <div class="col-4" style="float: left">
                                    <div id="button">
                                        <button type="button" class="btn btn-primary waves-effect waves-light"><a
                                                href="/students?action=add"><b style="color: white">Add Student</b></a>
                                        </button>
                                        <button type="button" class="btn btn-secondary waves-effect waves-light"><a
                                                href="/students?action=listTrash"><i class="fe-trash"></i><b
                                                style="color: white">- List trash</b></a></button>
                                    </div>
                                </div>
                                <div class="col-5" style="float: left">
                                    <form method="get" action="/students?action=list">
                                        <input type="hidden" value="search" name="action">
                                        <div class="input-group">
                                            <input type="search" class="form-control" name="search" value="${search}"
                                                   placeholder="code, firstname, lastname, email, phone, or address">
                                            <button class="btn btn-primary" type="submit">
                                                <i class="fe-search"></i>
                                            </button>
                                        </div>
                                    </form>
                                </div>
                                <form action="/students?action=classes" method="get">
                                    <input type="hidden" value="classes" name="action">
                                    <div class="col-3" style="float: left">
                                        <div class="form-group mb-3">
                                            <select id="validationCustom08" name="classes" class="select-css">
                                                <option data-display="Select" value="0">Nothing</option>
                                                <c:forEach var="classes" items="${applicationScope.listClass}">
                                                    <option value="${classes.getC_id()}">
                                                        <c:out value="${classes.getClassName() }"/>
                                                    </option>
                                                </c:forEach>
                                            </select>
                                            <button class="btn btn-primary" type="submit">
                                                <i class="dripicons-checklist"></i>
                                            </button>
                                        </div>
                                    </div>
                                </form>
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
                                            <th>Class</th>
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
                                                    <img src="<c:out value="${student.getAvatar()}"/>" alt="contact-img"
                                                         width="50" height="50" title="contact-img"
                                                         class="rounded-circle float-left mr-2">
                                                    <div class="overflow-hidden">
                                                        <p class="mb-0 font-weight-medium"><a
                                                                href="/students?action=profile&code=${student.getCode()}"><c:out
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
                                                        <a href="javascript: void(0);"
                                                           class="dropdown-toggle arrow-none btn btn-light btn-sm"
                                                           data-toggle="dropdown" aria-expanded="false"><i
                                                                class="mdi mdi-dots-horizontal"></i></a>
                                                        <div class="dropdown-menu dropdown-menu-right"
                                                             x-placement="bottom-end"
                                                             style="position: absolute; will-change: transform; top: 0; left: 0; transform: translate3d(-120px, 29px, 0px);">
                                                            <a class="dropdown-item"
                                                               href="/students?action=update&code=${student.getCode()}"><i
                                                                    class="mdi mdi-pencil mr-1 text-muted"></i>Edit</a>
                                                            <a class="dropdown-item"
                                                               href="/students?action=score&code=${student.getCode()}"><i
                                                                    class="mdi mdi-book-open-page-variant mr-1 text-muted"></i>Add
                                                                Score</a>
                                                            <a class="dropdown-item"
                                                               href="/students?action=remove&code=${student.getCode()}"><i
                                                                    class="mdi mdi-delete mr-1 text-muted"></i>Remove</a>
                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                    <nav aria-label="Page navigation example">
                                        <ul class="pagination justify-content-center">

                                            <c:if test="${requestScope.currentPage != 1}">
                                                <li class="page-item"><a class="page-link"
                                                                         href="/students?action=list&page=${requestScope.currentPage - 1}&search=${requestScope.search}">Previous</a>
                                                </li>
                                            </c:if>
                                            <c:forEach begin="1" end="${noOfPages}" var="i">
                                                <c:choose>
                                                    <c:when test="${requestScope.currentPage eq i}">
                                                        <li class="page-item"><a class="page-link"
                                                                                 href="/students?action=list&page=${i}&search=${requestScope.search}">${i}</a>
                                                        </li>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <li class="page-item"><a class="page-link"
                                                                                 href="/students?action=list&page=${i}&search=${requestScope.search}">${i}</a>
                                                        </li>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                            <c:if test="${requestScope.currentPage lt requestScope.noOfPages}">
                                                <li class="page-item"><a class="page-link"
                                                                         href="/students?action=list&page=${requestScope.currentPage + 1}&search=${requestScope.search}">Next</a>
                                                </li>
                                            </c:if>
                                        </ul>
                                    </nav>
                                    <div id="alertFormat">
                                        ${errors}
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
</body>
</html>
<script>
    $(document).ready(function () {
        $('select').niceSelect();
    });
</script>