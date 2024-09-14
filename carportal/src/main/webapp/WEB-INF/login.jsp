<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta charset="ISO-8859-1">

		<title>Login - Car Portal</title>
		<meta name="description" content="Free Bootstrap 4 Template by uicookies.com">
		<meta name="keywords" content="Free website templates, Free bootstrap themes, Free template, Free bootstrap, Free website template">

    <link href="https://fonts.googleapis.com/css?family=Crimson+Text:400,400i,600|Montserrat:200,300,400" rel="stylesheet">
	<link rel="stylesheet" href="assets/css/bootstrap/bootstrap.css">
    <link rel="stylesheet" href="assets/fonts/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="assets/fonts/law-icons/font/flaticon.css">
    <link rel="stylesheet" href="assets/fonts/fontawesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/slick.css">
    <link rel="stylesheet" href="assets/css/slick-theme.css">
    <link rel="stylesheet" href="assets/css/helpers.css">
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="assets/css/landing-2.css">
	</head>
	<body data-spy="scroll" data-target="#pb-navbar" data-offset="200">

    <nav class="navbar navbar-expand-lg navbar-dark pb_navbar pb_scrolled-light" id="pb-navbar">
      <div class="container">
        <a class="navbar-brand" href="/">
        	<img src="img/LogoABCCars.png" style="weight:40px; height:40px;">
        	ABCCars
        </a>
        <button class="navbar-toggler ml-auto" type="button" data-toggle="collapse" data-target="#probootstrap-navbar" aria-controls="probootstrap-navbar" aria-expanded="false" aria-label="Toggle navigation">
          <span><i class="ion-navicon"></i></span>
        </button>
        <div class="collapse navbar-collapse" id="probootstrap-navbar">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item cta-btn ml-xl-2 ml-lg-2 ml-md-0 ml-sm-0 ml-0"><a class="nav-link" href="/" ><span class="pb_rounded-4 px-4">BACK</span></a></li>
          </ul>
        </div>
      </div>
    </nav>
    <!-- END nav -->




    <section class="bg-land" id="section-home">
      <div class="container">
        <div class="row align-items-center justify-content-center">
          <div class="col-md-5 relative align-self-center">
            <form action="login" class="bg-white rounded pb_form_v1" method="post">
			<h5 class="text-center alert-success rounded">${okError}</h5>
			<h5 class="text-center alert-danger rounded">${loginError}</h5>
              <h2 class="mb-4 mt-0 text-center">Login Here</h2>
              <div class="form-group">
                <input name="usernameLogin" required="required" type="text" class="form-control pb_height-50 reverse" placeholder="Username"/>
              </div>
              <div class="form-group">
                <input name="passwordLogin" required="required" type="password" class="form-control pb_height-50 reverse" placeholder="Password"/>
              </div>
              <div class="form-group">
              	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="submit" class="btn btn-primary btn-lg btn-block   btn-shadow-blue" value="Login">
              </div>
            </form>
          </div>
        </div>
      </div>
    </section>
    <!-- END section -->

	<%@include file="footer.jsp" %>

	</body>
</html>
