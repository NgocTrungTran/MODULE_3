<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Simulor - Responsive Bootstrap 4 Admin Dashboard</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta content="A fully featured admin theme which can be used to build CRM, CMS, etc." name="description">
        <meta content="Coderthemes" name="author">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- App favicon -->
        <jsp:include page="/WEB-INF/admin/layout/meta_css.jsp"></jsp:include>

    </head>

    <body class="authentication-bg">
        <div class="account-pages my-5">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-5">
                        <div class="card">

                            <div class="card-body p-4">
                                
                                <div class="text-center w-75 m-auto">
                                    <a href="#">
                                        <span><img src="assets\images\logo.png" alt="" height="250"></span>
                                    </a>
                                    <p class="text-muted mb-4 mt-3">Enter your email address and password to access admin panel.</p>
                                </div>

                                <form action="#">

                                    <div class="form-group mb-3">
                                        <label for="emailaddress">Email address</label>
                                        <input class="form-control" type="email" id="emailaddress" name="email" required="" placeholder="Enter your email">
                                    </div>

                                    <div class="form-group mb-3">
                                        <a href="pages-recoverpw.html" class="text-muted float-right"><small></small></a>
                                        <label for="password">Password</label>
                                        <input class="form-control" type="password" name="phone" required="" id="password" placeholder="Enter your password">
                                    </div>

<%--                                    <div class="form-group mb-3">--%>
<%--                                        <div class="custom-control custom-checkbox">--%>
<%--                                            <input type="checkbox" class="custom-control-input" id="checkbox-signin" checked="">--%>
<%--                                            <label class="custom-control-label" for="checkbox-signin">Remember me</label>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>

                                    <div class="form-group mb-0 text-center">
                                        <button class="btn btn-primary btn-block" type="submit"> Log In </button>
                                    </div>

                                </form>
                            </div> <!-- end card-body -->
                        </div>
                        <!-- end card -->

                        <div class="row mt-3">
                            <div class="col-12 text-center">
                                <p class="text-muted"> <a href="#" class="text-muted ml-1">Forgot your password?</a></p>
                                <p class="text-muted">Don't have an account? <a href="#" class="text-dark font-weight-medium ml-1">Sign Up</a></p>
                            </div> <!-- end col -->
                        </div>
                        <!-- end row -->

                    </div> <!-- end col -->
                </div>
                <!-- end row -->
            </div>
            <!-- end container -->
        </div>
        <!-- end page -->
    

        <!-- Vendor js -->
        <script src="assets\js\vendor.min.js"></script>

        <!-- App js -->
        <script src="assets\js\app.min.js"></script>
        
    </body>
</html>