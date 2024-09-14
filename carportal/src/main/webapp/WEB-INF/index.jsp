<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta charset="ISO-8859-1">

		<title>Car Portal</title>
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
<!-- NavBar -->
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
            <li class="nav-item cta-btn ml-xl-2 ml-lg-2 ml-md-0 ml-sm-0 ml-0"><a class="nav-link" href="/login" ><span class="pb_rounded-4 px-4">LOGIN</span></a></li>
          </ul>
        </div>
      </div>
    </nav>
<!-- END nav -->


<section class="bg-land" id="section-home">
  <div class="container">
    <div class="row align-items-center justify-content-center">
       <div class="col-md-6">
        <h2 style="color:#fff;" class="heading mb-3">I�d drive a million miles for one of your smiles.</h2>
         <div class="sub-heading">
          <p style="color:#fff;" class="mb-4">Buy or Sell Your cars according to your demand and budget</p>
          <p class="mb-5"><a class="btn btn-primary btn-lg btn-block  btn-shadow-blue" href="/login"><span class="pb_font-14 text-uppercase pb_letter-spacing-1">Login Here</span></a></p>
         </div>
      </div>
      <div class="col-md-1">
      </div>
      <div class="col-md-5 relative align-self-center">
        <form:form action="/register" class="bg-white rounded pb_form_v1" modelAttribute="register" method="post">
          <h4 class="mb-4 mt-0 text-center alert-danger">${ExistUname}</h4>
          <h2 class="mb-4 mt-0 text-center">Sign Up </h2>
          <div class="form-group">
            <form:input path="username" required="required" type="text" class="form-control pb_height-50 reverse" placeholder="Enter Username"/>
          </div>
          <div class="form-group">
            <form:input path="fullName" required="required" type="text" class="form-control pb_height-50 reverse" placeholder=" Enter Full Name (Alphabet Only)" pattern="[A-Z a-z]+"/>
          </div>
          <div class="form-group">
            <form:input path="password" required="required" type="password" class="form-control pb_height-50 reverse" placeholder="Enter Password"/>
          </div>
          <div class="form-group">
          	<form:input path="userId" type="hidden"/>
            <input type="submit" class="btn btn-primary btn-lg btn-block   btn-shadow-blue" value="Register">
          </div>
        </form:form>
       </div>
    </div>
  </div>
</section>
<!-- END section -->

<%@include file="footer.jsp" %>

    <!-- loader -->

	</body>
</html>
