<!DOCTYPE html>
<html lang="en">
<%

        if (session.getAttribute("username") == null | session.getAttribute("usertype") == null) {
            response.sendRedirect("login.jsp");
        } 

    %>
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Montana</title>

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">

    </head>

    <body id="page-top" onload="load()">

        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

                <!-- Sidebar - Brand -->
                <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.jsp">
                    <div class="sidebar-brand-icon rotate-n-15">
                        <i class="fas fa-laugh-wink"></i>
                    </div>
                    <div class="sidebar-brand-text mx-3">Montana</div>
                </a>

                <!-- Divider -->
                <hr class="sidebar-divider my-0">



                <!-- Divider -->
                <hr class="sidebar-divider">

                <!-- Heading -->
                <div class="sidebar-heading">
                    Booking
                </div>

                <!-- Nav Item - Pages Collapse Menu -->
                <li class="nav-item">
                    <a class="nav-link" href="reservation.jsp">
                        <i class="fas fa-fw fa-file"></i>
                        <span>Reservation</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="customer.jsp">
                        <i class="fas fa-fw fa-user-circle"></i>
                        <span>Customer</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="room.jsp">
                        <i class="fas fa-fw fa-bed"></i>
                        <span>Rooms</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="payment.jsp">
                        <i class="fas fa-fw fa-coins"></i>
                        <span>Payment</span></a>
                </li>
                
                


                <!-- Divider -->
                <hr class="sidebar-divider">

                <!-- Heading -->
                <div class="sidebar-heading">
                    Finance
                </div>

                <li class="nav-item">
                    <a class="nav-link" href="finance_details.jsp">
                        <i class="fas fa-fw fa-donate"></i>
                        <span>Finance Details</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="offers.jsp">
                        <i class="fas fa-fw fa-gift"></i>
                        <span>Offers</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="salary.jsp">
                        <i class="fas fa-fw fa-money-bill-alt"></i>
                        <span>Salary Plans</span></a>
                </li>
                
                 <hr class="sidebar-divider">

                <div class="sidebar-heading">
                    Employee
                </div>

                <li class="nav-item">
                    <a class="nav-link" href="employee.jsp">
                        <i class="fas fa-fw fa-user"></i>
                        <span>Employee</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="attendance.jsp">
                        <i class="fas fa-fw fa-calendar"></i>
                        <span>Attendance</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="salary_view.jsp">
                        <i class="fas fa-fw fa-calendar"></i>
                        <span>Salary</span></a>
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider">

                <!-- Heading -->
                <div class="sidebar-heading">
                    Admin
                </div>

                <li class="nav-item">
                    <a class="nav-link" href="user.jsp">
                        <i class="fas fa-fw fa-user"></i>
                        <span>User</span></a>
                </li>



                <!-- Divider -->
                <hr class="sidebar-divider d-none d-md-block">

                <!-- Sidebar Toggler (Sidebar) -->
                <div class="text-center d-none d-md-inline">
                    <button class="rounded-circle border-0" id="sidebarToggle"></button>
                </div>

            </ul>
            <!-- End of Sidebar -->

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                        <!--                         Sidebar Toggle (Topbar) 
                                                <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                                                    <i class="fa fa-bars"></i>
                                                </button>
                        
                                                 Topbar Search 
                                                <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                                                    <div class="input-group">
                                                        <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                                                        <div class="input-group-append">
                                                            <button class="btn btn-primary" type="button">
                                                                <i class="fas fa-search fa-sm"></i>
                                                            </button>
                                                        </div>
                                                    </div>
                                                </form>-->

                        <!-- Topbar Navbar -->
                        <ul class="navbar-nav ml-auto">

                            <div class="topbar-divider d-none d-sm-block"></div>

                            <!-- Nav Item - User Information -->
                            <li class="nav-item dropdown no-arrow">
                                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small">${username}</span>
                                    <img class="img-profile rounded-circle" src="img/user.png">
                                </a>
                                <!-- Dropdown - User Information -->
                                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                                    <a class="dropdown-item" href="#">
                                        <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                        ${username}
                                    </a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="logout.jsp" data-toggle="modal" data-target="#logoutModal">
                                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Logout
                                    </a>
                                </div>
                            </li>

                        </ul>

                    </nav>
                    <!-- End of Topbar -->

                    <!-- Begin Page Content -->
                    <div class="container-fluid">

                        <!-- Page Heading -->
                        <div class="d-sm-flex align-items-center justify-content-between mb-4">
                            <h1 class="h3 mb-0 text-gray-800">Montana Hotel Management System</h1>
                            <button onclick="Export()" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-download fa-sm text-white-50"></i> Generate Report</button>
                        </div>


                        <section class="forms">
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="card">
                                            <div class="card-header d-flex align-items-center">
                                                <h3 class="h4">offer</h3>
                                            </div>
                                            <div class="card-body">
                                                <form class="form-horizontal">
                                                    <div class="form-group row">
                                                        <div class="col-sm-9">
                                                            <input id="offer_id" type="hidden"	value="0" class="form-control form-control-warning">
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label class="col-sm-3 form-control-label">Description</label>
                                                        <div class="col-sm-9">
                                                            <input id="description" type="text"	placeholder="description" class="form-control form-control-warning">
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label class="col-sm-3 form-control-label">Type</label>
                                                        <div class="col-sm-9">
                                                            <select id="type" class="form-control form-control-warning">
                                                                <option>Invoice Details</option>
                                                                <option>GRN Details</option>
                                                                <option>Other Expenses Details</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label class="col-sm-3 form-control-label">Amount</label>
                                                        <div class="col-sm-9">
                                                            <input id="amount" type="number"	placeholder="amount" class="form-control form-control-warning">
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label class="col-sm-3 form-control-label">Status</label>
                                                        <div class="col-sm-9">
                                                            <input id="status" type="text"	placeholder="status" class="form-control form-control-warning">
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <div class="col-sm-9">
                                                            <input id="date_time" type="hidden"	value="2020" class="form-control form-control-warning">
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <div class="col-sm-9 offset-sm-3">
                                                            <input onclick="save()" type="button" value="Save" class="btn btn-primary">
                                                            <input onclick="update()" type="button" value="Update" class="btn btn-primary">
                                                            <input onclick="delet()" type="button" value="Delete" class="btn btn-primary">
                                                            <input type="reset" value="Reset" class="btn btn-primary">
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-lg-12">
                                        <div class="card" id="report">
                                            <div class="card-header d-flex align-items-center">
                                                <h3 class="h4">History</h3>
                                            </div>
                                            <div class="card-body">
                                                <div class="table-responsive">
                                                    <table class="table table-hover" id="table">
                                                        <thead>
                                                            <tr>
                                                                <th>#</th>
                                                                <th>Offer ID</th>
                                                                <th>Description</th>
                                                                <th>Type</th>
                                                                <th>Amount</th>
                                                                <th>Status</th>
                                                                <th>Date</th>
                                                            </tr>
                                                        </thead>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>


                                </div>
                            </div>
                        </section>

                    </div>
                    <!-- /.container-fluid -->

                </div>
                <!-- End of Main Content -->

                <!-- Footer -->
                <footer class="sticky-footer bg-white">
                    <div class="container my-auto">
                        <div class="copyright text-center my-auto">
                            <span>Copyright &copy; SLIIT 2020</span>
                        </div>
                    </div>
                </footer>
                <!-- End of Footer -->

            </div>
            <!-- End of Content Wrapper -->

        </div>
        <!-- End of Page Wrapper -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>

        <!-- Logout Modal-->
        <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                        <a class="btn btn-primary" href="logout.jsp">Logout</a>
                    </div>
                </div>
            </div>
        </div>

        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="js/sb-admin-2.min.js"></script>

        <!-- Page level plugins -->
        <script src="vendor/chart.js/Chart.min.js"></script>

        <!-- Page level custom scripts -->
        <script src="js/demo/chart-area-demo.js"></script>
        <script src="js/demo/chart-pie-demo.js"></script>
        <script src="ajax/jquery.3.2.1.min.js" type="text/javascript"></script>
        <script src="ajax/ajax.js" type="text/javascript"></script>
        <script src="ajax/OfferJS.js" type="text/javascript"></script>
                <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.22/pdfmake.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.min.js"></script>

    </body>

</html>
