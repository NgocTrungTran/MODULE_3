<!DOCTYPE html>
<html lang="en"><head>
    <meta charset="utf-8">
    <title>Simulor - Responsive Bootstrap 4 Admin Dashboard</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta content="A fully featured admin theme which can be used to build CRM, CMS, etc." name="description">
    <meta content="Coderthemes" name="author">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- App favicon -->
    <link rel="shortcut icon" href="assets\images\favicon.ico">

    <!-- App css -->
    <link href="assets\css\bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="assets\css\icons.min.css" rel="stylesheet" type="text/css">
    <link href="assets\css\app.min.css" rel="stylesheet" type="text/css">
    <link href="assets\css\css.css" rel="stylesheet" type="text/css">
    
    

<style type="text/css">/* Chart.js */
@-webkit-keyframes chartjs-render-animation{from{opacity:0.99}to{opacity:1}}@keyframes chartjs-render-animation{from{opacity:0.99}to{opacity:1}}.chartjs-render-monitor{-webkit-animation:chartjs-render-animation 0.001s;animation:chartjs-render-animation 0.001s;}</style><style type="text/css">.jqstooltip { position: absolute;left: 0px;top: 0px;visibility: hidden;background: rgb(0, 0, 0) transparent;background-color: rgba(0,0,0,0.6);filter:progid:DXImageTransform.Microsoft.gradient(startColorstr=#99000000, endColorstr=#99000000);-ms-filter: "progid:DXImageTransform.Microsoft.gradient(startColorstr=#99000000, endColorstr=#99000000)";color: white;font: 10px arial, san serif;text-align: left;white-space: nowrap;padding: 5px;border: 1px solid white;box-sizing: content-box;z-index: 10000;}.jqsfield { color: white;font: 10px arial, san serif;text-align: left;}</style></head>

<body class="">

    <!-- Begin page -->
    <div id="wrapper">

        <!-- Topbar Start -->
        <div class="navbar-custom">
            <ul class="list-unstyled topnav-menu float-right mb-0">

                

    
                <li class="dropdown notification-list">
                    <a class="nav-link dropdown-toggle waves-effect waves-light" data-toggle="dropdown" href="#" role="button" aria-haspopup="false" aria-expanded="false">
                        <i class="fe-bell noti-icon"></i>
                        <span class="badge badge-danger rounded-circle noti-icon-badge">2</span>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right dropdown-lg" style="">

                        <!-- item-->
                        <div class="dropdown-item noti-title">
                            <h5 class="m-0">
                                <span class="float-right">
                                    <a href="" class="text-dark">
                                        <small>Clear All</small>
                                    </a>
                                </span>Notification
                            </h5>
                        </div>

                        <div class="slimScrollDiv" style="position: relative; overflow: hidden; width: auto; height: 542.5px;"><div class="slimscroll noti-scroll" style="overflow: hidden; width: auto; height: 542.5px;">

                            <!-- item-->
                            <a href="javascript:void(0);" class="dropdown-item notify-item">
                                <div class="notify-icon">
                                    <img src="assets\images\users\avatar-2.jpg" class="img-fluid rounded-circle" alt=""> </div>
                                <p class="notify-details">Cristina Pride</p>
                                <p class="text-muted mb-0 user-msg">
                                    <small>Hi, How are you? What about our next meeting</small>
                                </p>
                            </a>

                            <!-- item-->
                            <a href="javascript:void(0);" class="dropdown-item notify-item active">
                                <div class="notify-icon bg-warning"><i class="mdi mdi-comment-account-outline"></i> </div>
                                <p class="notify-details">Caleb Flakelar commented on Admin<small class="text-muted">1 min ago</small></p>
                            </a>

                            <!-- item-->
                            <a href="javascript:void(0);" class="dropdown-item notify-item">
                                <div class="notify-icon bg-info"><i class="mdi mdi-account-plus"></i></div>
                                <p class="notify-details">New user registered.<small class="text-muted">5 hours ago</small></p>
                            </a>

                            <!-- item-->
                            <a href="javascript:void(0);" class="dropdown-item notify-item">
                                <div class="notify-icon">
                                    <img src="assets\images\users\avatar-4.jpg" class="img-fluid rounded-circle" alt=""> </div>
                                <p class="notify-details">Karen Robinson</p>
                                <p class="text-muted mb-0 user-msg">
                                    <small>Wow ! this admin looks good and awesome design</small>
                                </p>
                            </a>

                

                
                            <!-- item-->
                            <a href="javascript:void(0);" class="dropdown-item notify-item">
                                <div class="notify-icon bg-danger"><i class="mdi mdi-comment-account-outline"></i></div>
                                <p class="notify-details">Caleb Flakelar commented on Admin<small class="text-muted">4 days ago</small></p>
                            </a>

                            <!-- item-->
                            <a href="javascript:void(0);" class="dropdown-item notify-item">
                                <div class="notify-icon bg-primary">
                                    <i class="mdi mdi-heart"></i>
                                </div>
                                <p class="notify-details">Carlos Crouch liked
                                    <b>Admin</b>
                                    <small class="text-muted">13 days ago</small>
                                </p>
                            </a>
                        </div><div class="slimScrollBar" style="background: rgb(158, 165, 171); width: 8px; position: absolute; top: 0px; opacity: 0.4; display: block; border-radius: 7px; z-index: 99; right: 1px;"></div><div class="slimScrollRail" style="width: 8px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 7px; background: rgb(51, 51, 51); opacity: 0.2; z-index: 90; right: 1px;"></div></div>

                        <!-- All-->
                        <a href="javascript:void(0);" class="dropdown-item text-center text-primary notify-item notify-all">
                            View all
                            <i class="fi-arrow-right"></i>
                        </a>

                    </div>
                </li>

                <li class="dropdown notification-list">
                    <a class="nav-link dropdown-toggle nav-user mr-0 waves-effect waves-light" data-toggle="dropdown" href="#" role="button" aria-haspopup="false" aria-expanded="false">
                        <img src="assets\images\users\avatar-4.jpg" alt="user-image" class="rounded-circle">
                        <span class="pro-user-name ml-1">
                            Morgan K <i class="mdi mdi-chevron-down"></i> 
                        </span>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right profile-dropdown" x-placement="bottom-end" style="position: absolute; will-change: transform; top: 0px; left: 0px; transform: translate3d(-27px, 70px, 0px);">
                        <!-- item-->
                        <div class="dropdown-item noti-title">
                            <h6 class="m-0">
                                Welcome !
                            </h6>
                        </div>

                        <!-- item-->
                        <a href="javascript:void(0);" class="dropdown-item notify-item">
                            <i class="dripicons-user"></i>
                            <span>My Account</span>
                        </a>

                        <!-- item-->
                        <a href="javascript:void(0);" class="dropdown-item notify-item">
                            <i class="dripicons-gear"></i>
                            <span>Settings</span>
                        </a>

                        <!-- item-->
                        <a href="javascript:void(0);" class="dropdown-item notify-item">
                            <i class="dripicons-help"></i>
                            <span>Support</span>
                        </a>

                        <!-- item-->
                        <a href="javascript:void(0);" class="dropdown-item notify-item">
                            <i class="dripicons-lock"></i>
                            <span>Lock Screen</span>
                        </a>

                        <div class="dropdown-divider"></div>

                        <!-- item-->
                        <a href="javascript:void(0);" class="dropdown-item notify-item">
                            <i class="dripicons-power"></i>
                            <span>Logout</span>
                        </a>

                    </div>
                </li>

                

            </ul>

            <ul class="list-unstyled menu-left mb-0">

                <li class="float-left">
                    <button class="button-menu-mobile open-left disable-btn">
                        <i class="fe-menu"></i>
                    </button>
                </li>
                <li class="app-search d-none d-sm-block">
                    <form>
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="Search...">
                            <div class="input-group-append">
                                <button class="btn btn-primary" type="submit">
                                    <i class="fe-search"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                </li>
            </ul>
        </div>
        <!-- end Topbar -->

        <!-- ========== Left Sidebar Start ========== -->
        <div class="left-side-menu">

            <div class="slimScrollDiv mm-active" style="position: relative; overflow: hidden; width: auto; height: 685.6px;"><div class="slimscroll-menu mm-show" style="overflow: hidden; width: auto; height: 685.6px;">

                <!-- LOGO -->
                <a href="index.html" class="logo text-center mb-4">
                    <span class="logo-lg">
                        <img src="assets\images\logo.png" alt="" height="250">
                    </span>
                    <span class="logo-sm">
                        <img src="assets\images\logo.png" alt="" height="50">
                    </span>
                </a>
    
                <!--- Sidemenu -->
                <div id="sidebar-menu" class="mm-active">

                    <ul class="metismenu mm-show" id="side-menu">

                        <li class="menu-title">Navigation</li>

                        <li class="">
                            <a href="index.html" class="active" aria-expanded="false">
                                <i class="fe-airplay"></i>
                                <span> Home </span>
                            </a>
                        </li>
            
                        

                        <li class="">
                            <a href="javascript: void(0);" aria-expanded="false">
                                <i class="fe-hard-drive"></i>
                                <span> Admin </span>
                                <span class="menu-arrow"></span>
                            </a>
                            <ul class="nav-second-level mm-collapse" aria-expanded="false" style="height: 0px;">
                                <li>
                                    <a href="components-rangeslider.html">Student List</a>
                                </li>
                                <li>
                                    <a href="components-alerts.html">Profile</a>
                                </li>
                                <li>
                                    <a href="components-ribbons.html">Test scores and grades</a>
                                </li>
                                <li>
                                    <a href="components-sweet-alerts.html">Leaderboard</a>
                                </li>
                            </ul>
                        </li>
 
                    </ul>

                </div>
                <!-- End Sidebar -->

                <div class="clearfix"></div>

            </div><div class="slimScrollBar" style="background: rgb(158, 165, 171); width: 8px; position: absolute; top: 40px; opacity: 0.4; display: none; border-radius: 7px; z-index: 99; right: 1px; height: 685.2px;"></div><div class="slimScrollRail" style="width: 8px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 7px; background: rgb(51, 51, 51); opacity: 0.2; z-index: 90; right: 1px;"></div></div>
            <!-- Sidebar -left -->

        </div>
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
                                <h4 class="page-title">Home</h4>
                            </div>
                        </div>
                    </div>     
                    <!-- end page title -->

                    
                    <!-- end row -->

                    
                    <!-- end row -->

                    <div class="row">
                        <div class="col-12">
                            <div class="card">
                                <div class="card-body">
                                    <h4 class="header-title">Recent Customers</h4>
    
                                    <div class="table-responsive mt-3">
                                        <table class="table table-hover table-centered mb-0">
                                            <thead>
                                                <tr>
                                                    <th>User ID</th>
                                                    <th>Basic Info</th>
                                                    <th>Phone</th>
                                                    <th>Location</th>
                                                    <th>Created Date</th>
                                                    <th>Action</th>
                                                </tr>
                                            </thead>
                                        
                                        
                                            <tbody>
                                                <tr>
                                                    <th scope="row">#0121</th>
                                                    <td>
                                                        <img src="assets\images\users\avatar-2.jpg" alt="contact-img" height="36" title="contact-img" class="rounded-circle float-left mr-2">
                                                        <div class="overflow-hidden">
                                                            <p class="mb-0 font-weight-medium"><a href="javascript: void(0);">George Lanes</a></p>
                                                            <span class="font-13">george@examples.com</span>
                                                        </div>
                                                    </td>
        
                                                    <td>
                                                        606-467-7601
                                                    </td>
        
                                                    <td>
                                                        New York
                                                    </td>
        
                                                    <td>
                                                        2018/04/28
                                                    </td>
        
                                                    <td>
                                                        <div class="btn-group dropdown">
                                                            <a href="javascript: void(0);" class="dropdown-toggle arrow-none btn btn-light btn-sm" data-toggle="dropdown" aria-expanded="false"><i class="mdi mdi-dots-horizontal"></i></a>
                                                            <div class="dropdown-menu dropdown-menu-right" x-placement="bottom-end" style="position: absolute; will-change: transform; top: 0px; left: 0px; transform: translate3d(-120px, 29px, 0px);">
                                                                <a class="dropdown-item" href="#"><i class="mdi mdi-pencil mr-1 text-muted"></i>Edit Contact</a>
                                                                <a class="dropdown-item" href="#"><i class="mdi mdi-delete mr-1 text-muted"></i>Remove</a>
                                                
                                                            </div>
                                                        </div>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <th scope="row">#0120</th>
                                                    <td>
                                                        <img src="assets\images\users\avatar-3.jpg" alt="contact-img" height="36" title="contact-img" class="rounded-circle float-left mr-2">
                                                        <div class="overflow-hidden">
                                                            <p class="mb-0 font-weight-medium"><a href="javascript: void(0);">Morgan Fuller</a></p>
                                                            <span class="font-13">morgan@examples.com</span>
                                                        </div>
                                                    </td>
        
                                                    <td>
                                                        407-748-6878
                                                    </td>
        
                                                    <td>
                                                        England
                                                    </td>
        
                                                    <td>
                                                        2018/04/27
                                                    </td>
        
                                                    <td>
                                                        <div class="btn-group dropdown">
                                                            <a href="javascript: void(0);" class="dropdown-toggle arrow-none btn btn-light btn-sm" data-toggle="dropdown" aria-expanded="false"><i class="mdi mdi-dots-horizontal"></i></a>
                                                            <div class="dropdown-menu dropdown-menu-right">
                                                                <a class="dropdown-item" href="#"><i class="mdi mdi-pencil mr-1 text-muted"></i>Edit Contact</a>
                                                                <a class="dropdown-item" href="#"><i class="mdi mdi-delete mr-1 text-muted"></i>Remove</a>
                                                            </div>
                                                        </div>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <th scope="row">#0119</th>
                                                    <td>
                                                        <img src="assets\images\users\avatar-4.jpg" alt="contact-img" height="36" title="contact-img" class="rounded-circle float-left mr-2">
                                                        <div class="overflow-hidden">
                                                            <p class="mb-0 font-weight-medium"><a href="javascript: void(0);">Charlie Daly</a></p>
                                                            <span class="font-13">charlie@examples.com</span>
                                                        </div>
                                                    </td>
        
                                                    <td>
                                                        918-766-5946
                                                    </td>
        
                                                    <td>
                                                        Canada
                                                    </td>
        
                                                    <td>
                                                        2018/04/27
                                                    </td>
        
                                                    <td>
                                                        <div class="btn-group dropdown">
                                                            <a href="javascript: void(0);" class="dropdown-toggle arrow-none btn btn-light btn-sm" data-toggle="dropdown" aria-expanded="false"><i class="mdi mdi-dots-horizontal"></i></a>
                                                            <div class="dropdown-menu dropdown-menu-right">
                                                                <a class="dropdown-item" href="#"><i class="mdi mdi-pencil mr-1 text-muted"></i>Edit Contact</a>
                                                                <a class="dropdown-item" href="#"><i class="mdi mdi-delete mr-1 text-muted"></i>Remove</a>
                                                            </div>
                                                        </div>
                                                    </td>
                                                </tr>
    
                                                <tr>
                                                    <th scope="row">#0118
                                                    </th><td>
                                                        <img src="assets\images\users\avatar-5.jpg" alt="contact-img" height="36" title="contact-img" class="rounded-circle float-left mr-2">
                                                        <div class="overflow-hidden">
                                                            <p class="mb-0 font-weight-medium"><a href="javascript: void(0);">Skye Saunders</a></p>
                                                            <span class="font-13">skye@examples.com</span>
                                                        </div>
                                                    </td>
        
                                                    <td>
                                                        302-232-1376
                                                    </td>
        
                                                    <td>
                                                        France
                                                    </td>
        
                                                    <td>
                                                        2018/04/26
                                                    </td>
        
                                                    <td>
                                                        <div class="btn-group dropdown">
                                                            <a href="javascript: void(0);" class="dropdown-toggle arrow-none btn btn-light btn-sm" data-toggle="dropdown" aria-expanded="false"><i class="mdi mdi-dots-horizontal"></i></a>
                                                            <div class="dropdown-menu dropdown-menu-right">
                                                                <a class="dropdown-item" href="#"><i class="mdi mdi-pencil mr-1 text-muted"></i>Edit Contact</a>
                                                                <a class="dropdown-item" href="#"><i class="mdi mdi-delete mr-1 text-muted"></i>Remove</a>
                                                            </div>
                                                        </div>
                                                    </td>
                                                </tr>
    
                                                <tr>
                                                    <th scope="row">#0117
                                                    </th><td>
                                                        <img src="assets\images\users\avatar-6.jpg" alt="contact-img" height="36" title="contact-img" class="rounded-circle float-left mr-2">
                                                        <div class="overflow-hidden">
                                                            <p class="mb-0 font-weight-medium"><a href="javascript: void(0);">Jodie Townsend</a></p>
                                                            <span class="font-13">jodie@examples.com</span>
                                                        </div>
                                                    </td>
        
                                                    <td>
                                                        251-661-5962
                                                    </td>
        
                                                    <td>
                                                        Tokyo
                                                    </td>
        
                                                    <td>
                                                        2017/11/28
                                                    </td>
        
                                                    <td>
                                                        <div class="btn-group dropdown">
                                                            <a href="javascript: void(0);" class="dropdown-toggle arrow-none btn btn-light btn-sm" data-toggle="dropdown" aria-expanded="false"><i class="mdi mdi-dots-horizontal"></i></a>
                                                            <div class="dropdown-menu dropdown-menu-right">
                                                                <a class="dropdown-item" href="#"><i class="mdi mdi-pencil mr-1 text-muted"></i>Edit Contact</a>
                                                                <a class="dropdown-item" href="#"><i class="mdi mdi-delete mr-1 text-muted"></i>Remove</a>
                                                            </div>
                                                        </div>
                                                    </td>
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
            <footer class="footer">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-6">
                            2018 - 2019 © Simulor theme by <a href="">Coderthemes</a>
                        </div>
                        <div class="col-md-6">
                            <div class="text-md-right footer-links d-none d-sm-block">
                                <a href="#">About Us</a>
                                <a href="#">Help</a>
                                <a href="#">Contact Us</a>
                            </div>
                        </div>
                    </div>
                </div>
            </footer>
            <!-- end Footer -->

        </div>

        <!-- ============================================================== -->
        <!-- End Page content -->
        <!-- ============================================================== -->


    </div>
    <!-- END wrapper -->

    <!-- Right bar overlay-->
    <div class="rightbar-overlay"></div>

    <!-- Vendor js -->
    <script src="assets\js\vendor.min.js"></script>

    <!-- Chart JS -->
    <script src="assets\libs\chart-js\Chart.bundle.min.js"></script>

    <!-- Sparkline charts -->
    <script src="assets\libs\jquery-sparkline\jquery.sparkline.min.js"></script>

    <!-- Dashboard js -->
    <script src="assets\js\pages\dashboard.init.js"></script>

    <!-- App js -->
    <script src="assets\js\app.min.js"></script>
    
<!-- Code injected by live-server -->
<script type="text/javascript">
// <![CDATA[  <-- For SVG support
if ('WebSocket' in window) {
    (function () {
        function refreshCSS() {
            var sheets = [].slice.call(document.getElementsByTagName("link"));
            var head = document.getElementsByTagName("head")[0];
            for (var i = 0; i < sheets.length; ++i) {
                var elem = sheets[i];
                var parent = elem.parentElement || head;
                parent.removeChild(elem);
                var rel = elem.rel;
                if (elem.href && typeof rel != "string" || rel.length == 0 || rel.toLowerCase() == "stylesheet") {
                    var url = elem.href.replace(/(&|\?)_cacheOverride=\d+/, '');
                    elem.href = url + (url.indexOf('?') >= 0 ? '&' : '?') + '_cacheOverride=' + (new Date().valueOf());
                }
                parent.appendChild(elem);
            }
        }
        var protocol = window.location.protocol === 'http:' ? 'ws://' : 'wss://';
        var address = protocol + window.location.host + window.location.pathname + '/ws';
        var socket = new WebSocket(address);
        socket.onmessage = function (msg) {
            if (msg.data == 'reload') window.location.reload();
            else if (msg.data == 'refreshcss') refreshCSS();
        };
        if (sessionStorage && !sessionStorage.getItem('IsThisFirstTime_Log_From_LiveServer')) {
            console.log('Live reload enabled.');
            sessionStorage.setItem('IsThisFirstTime_Log_From_LiveServer', true);
        }
    })();
}
else {
    console.error('Upgrade your browser. This Browser is NOT supported WebSocket for Live-Reloading.');
}
// ]]>
</script>
</body></html>