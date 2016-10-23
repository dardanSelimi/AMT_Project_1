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

      <title>AMT Project Register Page </title>

      <!-- Bootstrap -->
      <link href="/amt/bootstrap/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
      <!-- Font Awesome -->
      <link href="/amt/bootstrap/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
      <!-- NProgress -->
      <link href="/amt/bootstrap/vendors/nprogress/nprogress.css" rel="stylesheet">
      <!-- Animate.css -->
      <link href="/amt/bootstrap/vendors/animate.css/animate.min.css" rel="stylesheet">

      <!-- Custom Theme Style -->
      <link href="/amt/bootstrap/build/css/custom.css" rel="stylesheet">
   </head>

   <body class="nav-md">
      <div class="container body">
         <div class="main_container">




            <!-- page content -->
            <div class="right_col" role="main">
               <div class="">
                  <div class="page-title">
                     <div class="title_left">
                        <h3>Register </h3>
                     </div>

                  </div>
                  <div class="clearfix"></div>

                  <div class="row">
                     <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">
                           <div class="x_title">
                              <h2>Please fill the fields: </h2>

                              <div class="clearfix"></div>
                           </div>
                           <div class="x_content">

                              <form class="form-horizontal form-label-left" novalidate action="register" method="post">

                                 <span class="section">Personal Information</span>

                                 <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="firstName">First Name</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                       <input id="firstName" class="form-control col-md-7 col-xs-12" data-validate-length-range="" data-validate-words="1" maxlength="25" minlength="5" name="firstName" placeholder="" required="required" type="text">
                                    </div>
                                 </div>
                                 <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="lastName">Last Name</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                       <input id="lastName" class="form-control col-md-7 col-xs-12" data-validate-length-range="" data-validate-words="1" name="lastName" placeholder="" required="required" type="text">
                                    </div>
                                 </div>
                                 <div class="item form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="email">Email</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                       <input type="email" id="email" name="email" required="required" class="form-control col-md-7 col-xs-12">
                                    </div>
                                 </div>
                                 <div class="item form-group">
                                    <label for="password" class="control-label col-md-3">Password</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                       <input id="password" type="password" name="password" data-validate-length="" class="form-control col-md-7 col-xs-12 "maxlength="25" minlength="5" required="required">
                                    </div>
                                 </div>
                                 <div class="item form-group">
                                    <label for="password2" class="control-label col-md-3 col-sm-3 col-xs-12">Repeat Password</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                       <input id="password2" type="password" name="password2" data-validate-linked="password" maxlength="25" minlength="5" class="form-control col-md-7 col-xs-12" required="required">
                                    </div>
                                 </div>
                                 <div class="ln_solid"></div>
                                 <div class="form-group">
                                    <div class="col-md-6 col-md-offset-3">
                                       <button type="submit" class="btn btn-primary">Cancel</button>
                                       <button id="send" type="submit" class="btn btn-success">Submit</button>
                                    </div>
                                 </div>
                              </form>

                              <c:if test="${requestScope.errorMessage != null}">
                                 <div class="alert alert-danger fade in">
                                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                                    <h3>ERROR: </h3> 
                                    <h2><c:out value='${requestScope.errorMessage}'/></h2>
                                 </div>
                              </c:if>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
            <!-- /page content -->

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
      <!-- validator -->
      <script src="/amt/bootstrap/vendors/validator/validator.js"></script>

      <!-- Custom Theme Scripts -->
      <script src="/amt/bootstrap/build/js/custom.min.js"></script>

      <!-- validator -->
      <script>
         // initialize the validator function
         validator.message.date = 'not a real date';

         // validate a field on "blur" event, a 'select' on 'change' event & a '.reuired' classed multifield on 'keyup':
         $('form')
                 .on('blur', 'input[required], input.optional, select.required', validator.checkField)
                 .on('change', 'select.required', validator.checkField)
                 .on('keypress', 'input[required][pattern]', validator.keypress);

         $('.multi.required').on('keyup blur', 'input', function () {
            validator.checkField.apply($(this).siblings().last()[0]);
         });

         $('form').submit(function (e) {
            e.preventDefault();
            var submit = true;

            // evaluate the form using generic validaing
            if (!validator.checkAll($(this))) {
               submit = false;
            }

            if (submit)
               this.submit();

            return false;
         });
      </script>
      <!-- /validator -->
   </body>
</html>
