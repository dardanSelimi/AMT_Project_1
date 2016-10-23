<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page session="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <!-- Meta, title, CSS, favicons, etc. -->
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">

      <title>User page </title>

      <!-- Bootstrap -->
      <link href="/amt/bootstrap/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
      <!-- Font Awesome -->
      <link href="/amt/bootstrap/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
      <!-- NProgress -->
      <link href="/amt/bootstrap/vendors/nprogress/nprogress.css" rel="stylesheet">
      <!-- iCheck -->
      <link href="/amt/bootstrap/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
      <!-- Datatables -->
      <link href="/amt/bootstrap/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
      <link href="/amt/bootstrap/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
      <link href="/amt/bootstrap/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
      <link href="/amt/bootstrap/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
      <link href="/amt/bootstrap/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">

      <!-- Custom Theme Style -->
      <link href="/amt/bootstrap/build/css/custom.min.css" rel="stylesheet">
   </head>

   <body class="nav-md">
      <div class="container body">
         <div class="main_container">
            <div class="col-md-3 left_col">
               <div class="left_col scroll-view">
                  <div class="navbar nav_title" style="border: 0;">
                     <a href="index.jsp" class="site_title"><i class="fa fa-paw"></i> <span>AMT Projet 1</span></a>
                  </div>

                  <div class="clearfix"></div>

                  <br />

                  <!-- sidebar menu -->
                  <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                     <div class="menu_section">
                        <h3>Welcome
                           <c:if test="${sessionScope.user != null}">
                              <c:out value='${sessionScope.user.firstName}'/>
                           </c:if>
                        </h3>
                        <ul class="nav side-menu">
                           <li><a><i class="fa fa-home"></i> Home <span class="fa fa-chevron-down"></span></a>
                              <ul class="nav child_menu">
                                 <!--<li><a href="home">Home</a></li>-->
                                 <!--<li><a href="logout">Logout</a></li>-->
                                 <c:if test="${sessionScope.user != null}">
                                    <li>
                                       <a class="page-scroll" href="home">Home</a>
                                    </li>
                                 </c:if>
                                 <c:if test="${sessionScope.user != null}">
                                    <li>
                                       <a class="page-scroll" href="logout">Logout</a>
                                    </li>
                                 </c:if>
                                 <c:if test="${sessionScope.user == null}">
                                    <li>
                                       <a class="page-scroll" href="login">Login</a>
                                    </li>
                                 </c:if>
                                 <c:if test="${sessionScope.user == null}">
                                    <li>
                                       <a class="page-scroll" href="register">Register</a>
                                    </li>
                                 </c:if>

                              </ul>
                           </li>

                        </ul>
                     </div>


                  </div>
                  <!-- /sidebar menu -->


               </div>
            </div>

            <!-- top navigation -->
            <div class="top_nav">
               <div class="nav_menu">
                  <nav>
                     <div class="nav toggle">
                        <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                     </div>


                  </nav>
               </div>
            </div>
            <!-- /top navigation -->



            <!-- footer content -->
            <footer>
               <div class="pull-right">
                  Gentelella - Bootstrap Admin Template by <a href="https://colorlib.com">Colorlib</a>
               </div>
               <div class="clearfix"></div>
            </footer>
            <!-- /footer content -->
         </div>
      </div>

      <!-- jQuery -->
      <script src="/amt/bootstrap/vendors/jquery/dist/jquery.min.js"></script>
      <!-- Bootstrap -->
      <script src="/amt/bootstrap/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
      <!-- FastClick -->
      <script src="/amt/bootstrap/vendors/fastclick/lib/fastclick.js"></script>
      <!-- NProgress -->
      <script src="/amt/bootstrap/vendors/nprogress/nprogress.js"></script>
      <!-- iCheck -->
      <script src="/amt/bootstrap/vendors/iCheck/icheck.min.js"></script>
      <!-- Datatables -->
      <script src="/amt/bootstrap/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
      <script src="/amt/bootstrap/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
      <script src="/amt/bootstrap/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
      <script src="/amt/bootstrap/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
      <script src="/amt/bootstrap/vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
      <script src="/amt/bootstrap/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
      <script src="/amt/bootstrap/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
      <script src="/amt/bootstrap/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
      <script src="/amt/bootstrap/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
      <script src="/amt/bootstrap/vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
      <script src="/amt/bootstrap/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
      <script src="/amt/bootstrap/vendors/datatables.net-scroller/js/datatables.scroller.min.js"></script>
      <script src="/amt/bootstrap/vendors/jszip/dist/jszip.min.js"></script>
      <script src="/amt/bootstrap/vendors/pdfmake/build/pdfmake.min.js"></script>
      <script src="/amt/bootstrap/vendors/pdfmake/build/vfs_fonts.js"></script>

      <!-- Custom Theme Scripts -->
      <script src="/amt/bootstrap/build/js/custom.min.js"></script>

      <!-- Datatables -->
      <script>
         $(document).ready(function () {
            var handleDataTableButtons = function () {
               if ($("#datatable-buttons").length) {
                  $("#datatable-buttons").DataTable({
                     dom: "Bfrtip",
                     buttons: [
                        {
                           extend: "copy",
                           className: "btn-sm"
                        },
                        {
                           extend: "csv",
                           className: "btn-sm"
                        },
                        {
                           extend: "excel",
                           className: "btn-sm"
                        },
                        {
                           extend: "pdfHtml5",
                           className: "btn-sm"
                        },
                        {
                           extend: "print",
                           className: "btn-sm"
                        },
                     ],
                     responsive: true
                  });
               }
            };

            TableManageButtons = function () {
               "use strict";
               return {
                  init: function () {
                     handleDataTableButtons();
                  }
               };
            }();

            $('#datatable').dataTable();

            $('#datatable-keytable').DataTable({
               keys: true
            });

            $('#datatable-responsive').DataTable();

            $('#datatable-scroller').DataTable({
               ajax: "js/datatables/json/scroller-demo.json",
               deferRender: true,
               scrollY: 380,
               scrollCollapse: true,
               scroller: true
            });

            $('#datatable-fixed-header').DataTable({
               fixedHeader: true
            });

            var $datatable = $('#datatable-checkbox');

            $datatable.dataTable({
               'order': [[1, 'asc']],
               'columnDefs': [
                  {orderable: false, targets: [0]}
               ]
            });
            $datatable.on('draw.dt', function () {
               $('input').iCheck({
                  checkboxClass: 'icheckbox_flat-green'
               });
            });

            TableManageButtons.init();
         });
      </script>

   </body>
</html>

